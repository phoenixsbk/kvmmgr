package org.ovirt.engine.api.restapi.resource.license;

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
}
