package org.ovirt.engine.api.resource;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/license")
@Produces(ApiMediaType.APPLICATION_JSON)
public interface LicenseResource {
	
	@GET
	@Path("/validate")
	public boolean isLicenseValid();
	
	@POST
	public boolean UpdateLicense(String key);
	
	@GET
	@Path("/machinecode")
	public String getMachineCode();
	
	@GET
	@Path("/cpu")
	public int getLicenseCPU();
	
	@GET
	@Path("/mem")
	public long getLicenseMem();
	
	@GET
	@Path("/expire")
	public long getLicenseExpire();
	
	@GET
	@Path("/all")
	public String getLicenseInfo();
}
