package org.ovirt.engine.core.common.vdscommands;

import org.ovirt.engine.core.compat.Guid;

public class HSMGetIsoListParameters extends VdsIdVDSCommandParametersBase {
    public HSMGetIsoListParameters(Guid vdsId, Guid storagePoolId) {
        super(vdsId);
        setStoragePoolId(storagePoolId);
    }

    private Guid privateStoragePoolId;

    public Guid getStoragePoolId() {
        return privateStoragePoolId;
    }

    private void setStoragePoolId(Guid value) {
        privateStoragePoolId = value;
    }

    public HSMGetIsoListParameters() {
        privateStoragePoolId = Guid.Empty;
    }

    @Override
    public String toString() {
        return String.format("%s, storagePoolId=%s", super.toString(), getStoragePoolId());
    }
}
