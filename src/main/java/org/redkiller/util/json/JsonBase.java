package org.redkiller.util.json;

import org.redkiller.util.map.dataMap.ToDataMap;

public interface JsonBase extends ToDataMap {
    boolean equals(Object var1);

    JsonBase clone();

    Object getValue();

    int getTypeNumber();
}
