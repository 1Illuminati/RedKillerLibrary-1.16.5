package org.redkiller.item.ban;

import org.bukkit.Material;
import org.redkiller.util.map.dataMap.DataMap;
import org.redkiller.util.map.dataMap.ToDataMap;

import java.util.EnumMap;

public class BanItemInfo implements ToDataMap {
    private final Material material;
    private final EnumMap<BanItemAct, Boolean> actMap = new EnumMap<>(BanItemAct.class);

    public BanItemInfo(Material material) {
        this.material = material;
    }

    public Material getMaterial() {
        return material;
    }

    public boolean getAllow(BanItemAct act) {
        return actMap.computeIfAbsent(act, v -> Boolean.TRUE);
    }

    public void setAllow(BanItemAct act, boolean allow) {
        actMap.put(act, allow);
    }

    @Override
    public DataMap toDataMap() {
        return null;
    }
}