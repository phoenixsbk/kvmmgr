package cn.lynx.emi;

import java.util.Date;

import cn.lynx.emi.license.LicenseBean;
import cn.lynx.emi.license.RSAEngine;

public class LicenseService {
	private boolean init = false;
	private LicenseBean bean;

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
	
	public final void UpdateLicense(String license) {
		RSAEngine.storeLicense(license);
		initialize(true);
	}
}
