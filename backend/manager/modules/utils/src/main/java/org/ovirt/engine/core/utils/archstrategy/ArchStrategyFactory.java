package org.ovirt.engine.core.utils.archstrategy;

import java.util.EnumMap;

import org.ovirt.engine.core.common.businessentities.ArchitectureType;

public class ArchStrategyFactory {

    private static final EnumMap<ArchitectureType, ArchStrategy> architectureArchStrategyMap =
            new EnumMap<ArchitectureType, ArchStrategy>(ArchitectureType.class);

    static {
        architectureArchStrategyMap.put(ArchitectureType.x86_64, new X86_64Strategy());
        architectureArchStrategyMap.put(ArchitectureType.ppc64, new PPC64Strategy());
    }

    public static ArchStrategy getStrategy(ArchitectureType architecture) {

        return architectureArchStrategyMap.get(architecture);
    }
}
