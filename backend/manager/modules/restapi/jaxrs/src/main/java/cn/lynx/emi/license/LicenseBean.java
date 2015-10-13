package cn.lynx.emi.license;

import java.io.Serializable;

public class LicenseBean implements Serializable {
	private static final long serialVersionUID = 5577194763104972455L;
	
	private String machineCode;
	private int cpuCount;
	private long memCount;
	private long expireDate;

	public String getMachineCode() {
		return machineCode;
	}

	public void setMachineCode(String machineCode) {
		this.machineCode = machineCode;
	}

	public int getCpuCount() {
		return cpuCount;
	}

	public void setCpuCount(int cpuCount) {
		this.cpuCount = cpuCount;
	}

	public long getMemCount() {
		return memCount;
	}

	public void setMemCount(long memCount) {
		this.memCount = memCount;
	}

	public long getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(long expireDate) {
		this.expireDate = expireDate;
	}
}
