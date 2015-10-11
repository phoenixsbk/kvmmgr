package org.ovirt.engine.api.restapi.resource.license;

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
		return RSAEngine.getMachineCode();
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
		String ss = "";
		ss += "CPU:[" + LicenseService.getInstance().getCpu() + "]";
		long mem = LicenseService.getInstance().getMem();
		ss += ",Memory:[" + (mem / 1024 / 1024 / 1024) + "]";
		ss += ",Expire:[" + new Date(LicenseService.getInstance().getExpire()) + "]";
		return ss;
	}
}
