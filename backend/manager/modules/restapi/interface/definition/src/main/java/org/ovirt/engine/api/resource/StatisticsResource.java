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

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import org.jboss.resteasy.annotations.providers.jaxb.Formatted;

import org.ovirt.engine.api.model.Statistics;


@Produces({ApiMediaType.APPLICATION_XML, ApiMediaType.APPLICATION_JSON, ApiMediaType.APPLICATION_X_YAML})
public interface StatisticsResource {

    @GET
    @Formatted
    public Statistics list();

    /**
     * Sub-resource locator method, returns individual StatisticResource, on
     * which the remainder of the URI is dispatched.
     *
     * @param id  the Statistic ID
     * @return    matching subresource if found
     */
    @Path("{id}")
    public StatisticResource getStatisticSubResource(@PathParam("id") String id);
}
