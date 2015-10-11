package org.ovirt.engine.api.resource;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.ovirt.engine.api.model.License;

@Path("/license")
@Produces(ApiMediaType.APPLICATION_JSON)
public interface LicenseResource {
	
	@GET
	public License getLicense();
	
	@GET
	@Path("/machine")
	public String getMachineCode();
	
	@POST
	public boolean updateLicense(String license);
}
