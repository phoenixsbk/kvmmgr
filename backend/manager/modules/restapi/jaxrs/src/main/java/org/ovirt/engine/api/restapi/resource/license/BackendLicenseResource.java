package org.ovirt.engine.api.restapi.resource.license;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.ws.rs.FormParam;

import org.ovirt.engine.api.resource.LicenseResource;
import org.ovirt.engine.api.restapi.resource.BackendResource;

public class BackendLicenseResource extends BackendResource implements LicenseResource {

	@Override
	public boolean isLicenseValid() {
		return LicenseService.getInstance().ValidateLicense();
	}
	
	@Override
	public boolean UpdateLicense(@FormParam("key") String key) {
		LicenseService.getInstance().UpdateLicense(key);
		return isLicenseValid();
	}
	
	@Override
	public String getMachineCode() {
		return "{\"machinecode\":\"" + RSAEngine.getMachineCode() + "\"}";
	}
	
	@Override
	public int getLicenseCPU() {
		return LicenseService.getInstance().getCpu();
	}
	
	@Override
	public long getLicenseMem() {
		return LicenseService.getInstance().getMem();
	}
	
	@Override
	public long getLicenseExpire() {
		return LicenseService.getInstance().getExpire();
	}
	
	@Override
	public String getLicenseInfo() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String ss = "{";
		ss += "\"cpu\":" + LicenseService.getInstance().getCpu();
		long mem = LicenseService.getInstance().getMem();
		ss += ",\"memory\":" + (mem / 1024 / 1024 / 1024);
		ss += ",\"expire\":\"" + sdf.format(new Date(LicenseService.getInstance().getExpire())) + "\"}";
		return ss;
	}
}
