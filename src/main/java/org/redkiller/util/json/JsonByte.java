package org.redkiller.util.json;

import org.redkiller.util.map.dataMap.DataMap;

public class JsonByte implements JsonBase {
    private final byte i;

    public JsonByte(byte i) {
        this.i = i;
    }

    public byte getByte() {
        return this.i;
    }

    @Override
    public JsonBase clone() {
        return new JsonByte(i);
    }

    @Override
    public Object getValue() {
        return this.i;
    }

    @Override
    public int getTypeNumber() {
        return 3;
    }

    @Override
    public DataMap toDataMap() {
        return new DataMap();
    }
}
