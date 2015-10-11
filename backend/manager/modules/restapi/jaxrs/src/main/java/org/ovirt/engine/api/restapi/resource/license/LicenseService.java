package org.ovirt.engine.api.restapi.resource.license;

import java.util.Date;
import java.util.List;

import org.ovirt.engine.api.model.Host;
import org.ovirt.engine.api.model.Hosts;
import org.ovirt.engine.api.restapi.resource.BackendHostsResource;

public class LicenseService {
	private static LicenseService instance = new LicenseService();
	private boolean init = false;
	private LicenseBean bean;
	private int curCpu;
	private long curMem;
	
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
				refreshCurrent();
			}
		}
	}
	
	public final void refreshCurrent() {
		BackendHostsResource bhr = new BackendHostsResource();
		Hosts hs = bhr.list();
		List<Host> hhs = hs.getHosts();
		int totalCpu = 0;
		long totalMem = 0;
		for (Host h : hhs) {
			totalCpu += h.getCpu().getCores().getCore().size();
			totalMem += h.getMemory();
		}
		curCpu = totalCpu;
		curMem = totalMem;
	}

	public final boolean ValidateLicense() {
		initialize(false);
		if (bean == null) {
			return false;
		}
		
		refreshCurrent();
		
		if (new Date().getTime() > bean.getExpireDate() && bean.getExpireDate() != -1L) {
			return false;
		}
		
		if (bean.getCpuCount() < curCpu) {
			return false;
		}
		
		if (bean.getMemCount() < curMem) {
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
	
	public final boolean validateCpu(int cpu) {
		refreshCurrent();
		return curCpu + cpu <= bean.getCpuCount();
	}
	
	public final boolean validateMem(long mem) {
		refreshCurrent();
		return curMem + mem <= bean.getMemCount();
	}
	
	public final boolean UpdateLicense(String license) {
		boolean success = RSAEngine.storeLicense(license);
		if (success)
			initialize(true);
		
		return success;
	}
}
