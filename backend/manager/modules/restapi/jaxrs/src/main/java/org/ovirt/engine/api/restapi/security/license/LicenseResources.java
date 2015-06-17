package org.ovirt.engine.api.restapi.security.license;

import org.ovirt.engine.api.model.License;
import org.ovirt.engine.api.resource.LicenseResource;

import cn.lynx.emi.LicenseService;

public class LicenseResources implements LicenseResource {

	@Override
	public License getLicense() {
		License l = new License();
		int cpu = LicenseService.getInstance().getCpu();
		if (cpu == -1) {
			return null;
		}
		
		l.setCpuCount(cpu);
		l.setMemCount(LicenseService.getInstance().getMem());
		l.setExpireDate(LicenseService.getInstance().getExpire());
		return l;
	}

	@Override
	public boolean updateLicense(String license) {
		return LicenseService.getInstance().UpdateLicense(license);
	}

}