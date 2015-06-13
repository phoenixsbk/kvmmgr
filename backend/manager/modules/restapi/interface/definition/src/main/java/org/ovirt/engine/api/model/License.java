package org.ovirt.engine.api.model;

public class License {
	private int cpuCount;
	private long memCount;
	private long expireDate;

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
