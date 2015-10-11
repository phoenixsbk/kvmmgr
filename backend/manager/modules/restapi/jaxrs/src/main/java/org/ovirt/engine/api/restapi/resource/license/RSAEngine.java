package org.ovirt.engine.api.restapi.resource.license;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.spec.X509EncodedKeySpec;
import java.util.Enumeration;

import javax.crypto.Cipher;

import org.apache.commons.codec.binary.Base64;

public class RSAEngine {
	private static final String LICENSE_CORE_KEY = "MIICIjANBgkqhkiG9w0BAQEFAAOCAg8AMIICCgKCAgEAoc7HGhetqiAwyrVZxBskNusiz9TNPX0niaIi7C16DxnKguANpn1lDOk/U2T+gOJiLIt/zL3bvhjCXN0krD4lZUJZxC2RXSQG97622aFeYuYOKtkzmrNwlRK8RCeKlGbydF9V7O+LmKHEzlpttLx0pglw0x4ps4ALEc82wZErHhZ9m76m1ykoNOSY+Khz4OPhMVXKm0EYwitTktfSEsV/vIsXymbJCUprkN1Nw7ftjA3UyU9LvRhs1puczss8kp0WLE9gOB9dxzV+QrmLnZWVvHAF8BGsalQpOQ/KaY9hl8UIqleYqBcYa6sfX9vzbl66RVII7l30Hx2wKK6PhAs51NeGE1s3wg81fq80aC3vOhlwoAIK8w9gXKrctbg8bV0pf2uLUVkjFR63YgTsQbHJTux8fnRM99//x8quM3/g+qVVUsYBwmHbl6YEUxTyYsO+auYCLrsxBvPSa5JVXiTmDyz22NBOaDdNqjSVygyXB6nH7CZogze1IDOqbzNPy+Lu20bEAQKVXwU8kWIW22dWrNYVXDeCDYb8dkLZj9qPHIwDQeM4kgLqnEMfObvZJbgbbJ1SQ84gZ0RPFtgIic6KTel/8ToSVZRuBrz5p6Eb5J9kB1a6Xb/5uVenmtHA4y4L+he6Fuq07QRnfzTZw7Gi3hunwxPOzrQoE45MdSVD9gUCAwEAAQ==";
	private static final String MACHINE_HW_FILE = "/var/kvmmgr/kmhw.inc";
	private static final String LICENSE_CODE_FILE = "/var/kvmmgr/license.inc";
	
	public static final String getMachineCode() {
		String machineCode = _readFile(MACHINE_HW_FILE);
		if (machineCode == null) {
			machineCode = _generateMachineCode();
			_storeFile(MACHINE_HW_FILE, machineCode);
		}
		
		return machineCode;
		
	}

	private static final String _generateMachineCode() {
		StringBuilder sb = new StringBuilder();
		try {
			Enumeration<NetworkInterface> enumsofnet = NetworkInterface.getNetworkInterfaces();
			while (enumsofnet.hasMoreElements()) {
				NetworkInterface nic = enumsofnet.nextElement();
				byte[] mac = nic.getHardwareAddress();
				if (mac != null) {
					sb.append(Base64.encodeBase64String(mac));
				}
			}
		} catch (SocketException e) {
		}
		
		return sb.toString();
	}
	
	public static final boolean storeLicense(String license) {
		return _storeFile(LICENSE_CODE_FILE, license);
	}
	
	public static final LicenseBean retrieveLicense() {
		String license = _readFile(LICENSE_CODE_FILE);
		String machineCode = getMachineCode();
		
		if (license == null || machineCode == null) {
			return null;
		}
		
		String decryptedLicense = _decrypt(license);
		
		// Deserialize to license bean
		try {
			ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(Base64.decodeBase64(decryptedLicense)));
			LicenseBean bean = (LicenseBean) ois.readObject();
			
			if (!bean.getMachineCode().equalsIgnoreCase(machineCode)) {
				return null;
			}
			
			return bean;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	private static final boolean _storeFile(String filename, String content) {
		File f = new File(filename);
		if (f.exists()) {
			f.delete();
		}
		
		try {
			f.createNewFile();
			DataOutputStream dos = new DataOutputStream(new FileOutputStream(f));
			dos.writeUTF(content);
			dos.flush();
			dos.close();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	private static final String _readFile(String filename) {
		File f = new File(filename);
		if (!f.exists()) {
			return null;
		}
		
		try {
			DataInputStream dis = new DataInputStream(new FileInputStream(f));
			StringBuilder sb = new StringBuilder();
			while (dis.available() > 0) {
				sb.append(dis.readUTF());
			}
			dis.close();
			return sb.toString();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	private static final String _decrypt(String data) {
		byte[] corekey = Base64.decodeBase64(LICENSE_CORE_KEY);
		byte[] rawData = Base64.decodeBase64(data);
		X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(corekey);
		
		try {
			KeyFactory keyFactory = KeyFactory.getInstance("RSA");
			Key publicKey = keyFactory.generatePublic(x509EncodedKeySpec);

			Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
			cipher.init(Cipher.DECRYPT_MODE, publicKey);
			
			return new String(cipher.doFinal(rawData), "UTF-8");
		} catch (Exception e) {
			return null;
		}
	}
}
