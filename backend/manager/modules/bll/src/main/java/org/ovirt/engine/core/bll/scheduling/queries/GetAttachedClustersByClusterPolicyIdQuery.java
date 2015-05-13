package org.ovirt.engine.core.bll.scheduling.queries;

import org.ovirt.engine.core.bll.QueriesCommandBase;
import org.ovirt.engine.core.bll.scheduling.SchedulingManager;
import org.ovirt.engine.core.common.queries.IdQueryParameters;

public class GetAttachedClustersByClusterPolicyIdQuery extends QueriesCommandBase<IdQueryParameters> {
    public GetAttachedClustersByClusterPolicyIdQuery(IdQueryParameters parameters) {
        super(parameters);
    }

    @Override
    protected void executeQueryCommand() {
        getQueryReturnValue().setReturnValue(SchedulingManager.getInstance()
                .getClustersByClusterPolicyId(getParameters().getId()));
    }
}
