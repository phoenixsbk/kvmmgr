package org.ovirt.engine.api.restapi.resource.license;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.ovirt.engine.api.resource.ApiMediaType;

import cn.lynx.emi.LicenseService;

@Path("/license")
@Produces(ApiMediaType.APPLICATION_JSON)
public class LicenseResource {

	@GET
	@Path("/validate")
	public boolean isLicenseValid() {
		return LicenseService.getInstance().ValidateLicense();
	}
	
	@POST
	public boolean UpdateLicense(@FormParam("key") String key) {
		LicenseService.getInstance().UpdateLicense(key);
		return true;
	}
	
	@GET
	@Path("/cpu")
	public int getLicenseCPU() {
		return LicenseService.getInstance().getCpu();
	}
	
	@GET
	@Path("/mem")
	public long getLicenseMem() {
		return LicenseService.getInstance().getMem();
	}
	
	@GET
	@Path("/expire")
	public long getLicenseExpire() {
		return LicenseService.getInstance().getExpire();
	}
}
