package org.ovirt.engine.api.restapi.resource.license;

import java.util.Date;

import cn.lynx.emi.license.LicenseBean;

public class LicenseService {
	private static LicenseService instance = new LicenseService();
	private boolean init = false;
	private LicenseBean bean;
	
	private LicenseService() {
		initialize(true);
	}
	
	public static LicenseService getInstance() {
		return instance;
	}

	private void initialize(boolean forceInit) {
		if (forceInit) {
			init = false;
		}
		
		if (!init) {
			synchronized (this) {
				init = true;
				bean = RSAEngine.retrieveLicense();
			}
		}
	}

	public final boolean ValidateLicense() {
		initialize(false);
		if (bean == null) {
			return false;
		}
		
		if (new Date().getTime() > bean.getExpireDate() && bean.getExpireDate() != -1L) {
			return false;
		}
		
		return true;
	}
	
	public final int getCpu() {
		if (ValidateLicense()) {
			return bean.getCpuCount();
		}
		
		return -1;
	}
	
	public final long getMem() {
		if (ValidateLicense()) {
			return bean.getMemCount();
		}
		
		return -1L;
	}
	
	public final long getExpire() {
		if (ValidateLicense()) {
			return bean.getExpireDate();
		}
		
		return -2L;
	}
	
	public final boolean UpdateLicense(String license) {
		boolean success = RSAEngine.storeLicense(license);
		if (success)
			initialize(true);
		
		return success;
	}
}
