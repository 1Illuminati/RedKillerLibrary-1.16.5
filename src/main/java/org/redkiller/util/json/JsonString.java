package org.redkiller.util.json;

import org.redkiller.util.map.dataMap.DataMap;

public class JsonString implements JsonBase{
    private final String i;

    public JsonString(String i) {
        this.i = i;
    }

    public String getString() {
        return this.i;
    }

    @Override
    public JsonBase clone() {
        return new JsonString(i);
    }

    @Override
    public Object getValue() {
        return this.i;
    }

    @Override
    public int getTypeNumber() {
        return 1;
    }

    @Override
    public DataMap toDataMap() {
        return new DataMap();
    }
}
