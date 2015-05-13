package org.ovirt.engine.core.common.vdscommands;

import org.ovirt.engine.core.compat.Guid;

public class TargetDomainImageGroupVDSCommandParameters extends StoragePoolDomainAndGroupIdBaseVDSCommandParameters {

    private Guid privateDstDomainId;

    public TargetDomainImageGroupVDSCommandParameters(Guid storagePoolId,
            Guid storageDomainId,
            Guid imageGroupId,
            Guid dstStorageDomainId) {
        super(storagePoolId, storageDomainId, imageGroupId);
        setDstDomainId(dstStorageDomainId);
    }

    public TargetDomainImageGroupVDSCommandParameters() {
        privateDstDomainId = Guid.Empty;
    }

    public Guid getDstDomainId() {
        return privateDstDomainId;
    }

    protected void setDstDomainId(Guid value) {
        privateDstDomainId = value;
    }

    @Override
    public String toString() {
        return String.format("%s, dstDomainId = %s", super.toString(), getDstDomainId());
    }
}
