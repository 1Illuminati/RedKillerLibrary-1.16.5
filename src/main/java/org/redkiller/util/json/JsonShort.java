package org.redkiller.util.json;

import org.redkiller.util.map.dataMap.DataMap;

public class JsonShort implements JsonBase {
    private final short i;

    public JsonShort(short i) {
        this.i = i;
    }

    public short getShort() {
        return this.i;
    }

    @Override
    public JsonShort clone() {
        return new JsonShort(i);
    }

    @Override
    public Object getValue() {
        return this.i;
    }

    @Override
    public int getTypeNumber() {
        return 4;
    }

    @Override
    public DataMap toDataMap() {
        return new DataMap();
    }
}
