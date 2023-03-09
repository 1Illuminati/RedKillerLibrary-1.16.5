package org.redkiller.util.json;

import org.redkiller.util.map.dataMap.DataMap;

public class JsonInt implements JsonBase{
    private final int i;

    public JsonInt(int i) {
        this.i = i;
    }

    public int getInt() {
        return this.i;
    }

    @Override
    public JsonInt clone() {
        return new JsonInt(i);
    }

    @Override
    public Object getValue() {
        return this.i;
    }

    @Override
    public int getTypeNumber() {
        return 2;
    }

    @Override
    public DataMap toDataMap() {
        return new DataMap();
    }
}
