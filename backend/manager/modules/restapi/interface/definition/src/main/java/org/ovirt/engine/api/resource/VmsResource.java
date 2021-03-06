/*
* Copyright (c) 2010 Red Hat, Inc.
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*           http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

package org.ovirt.engine.api.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import org.jboss.resteasy.annotations.providers.jaxb.Formatted;

import org.ovirt.engine.api.model.Action;
import org.ovirt.engine.api.model.VM;
import org.ovirt.engine.api.model.VMs;


@Path("/vms")
@Produces({ApiMediaType.APPLICATION_XML, ApiMediaType.APPLICATION_JSON, ApiMediaType.APPLICATION_X_YAML})
public interface VmsResource {

    @GET
    @Formatted
    public VMs list();

    /**
     * Creates a new VM and adds it to the database. The VM is created
     * based on the properties of @vm.
     * <p>
     * The VM#name, VM#templateId and VM#clusterId properties are required.
     *
     * @param vm  the VM definition from which to create the new VM
     * @return    the new newly created VM
     */
    @POST
    @Formatted
    @Consumes({ApiMediaType.APPLICATION_XML, ApiMediaType.APPLICATION_JSON, ApiMediaType.APPLICATION_X_YAML})
    public Response add(VM vm);

    @DELETE
    @Path("{id}")
    public Response remove(@PathParam("id") String id);

    @DELETE
    @Consumes({ApiMediaType.APPLICATION_XML, ApiMediaType.APPLICATION_JSON, ApiMediaType.APPLICATION_X_YAML})
    @Path("{id}")
    public Response remove(@PathParam("id") String id, Action action);


    /**
     * Sub-resource locator method, returns individual VmResource on which the
     * remainder of the URI is dispatched.
     *
     * @param id  the VM ID
     * @return    matching subresource if found
     */
    @Path("{id}")
    public VmResource getVmSubResource(@PathParam("id") String id);
}
