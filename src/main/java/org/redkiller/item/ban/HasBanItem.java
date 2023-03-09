package org.redkiller.item.ban;

import org.bukkit.Material;

public interface HasBanItem {

    public void add(Material material);

    public void add(BanItemInfo banItemInfo);

    public void remove(Material material);

    public void remove(BanItemInfo banItemInfo);

    public boolean contains(Material material);

    public boolean contains(BanItemInfo banItemInfo);

    public Material[] getMaterials();

    public BanItemInfo[] getBanItemInfos();

    public BanItemInfo get(Material material);

}
