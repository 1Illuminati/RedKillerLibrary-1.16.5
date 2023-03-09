package org.redkiller.system.world;

import org.bukkit.Location;
import org.bukkit.util.BoundingBox;
import org.redkiller.entity.livingentity.player.NewPlayer;

public interface InterfaceArea {
    public BoundingBox getBoundingBox();

    /**
     * area안에 loc가 포함되어있는지 확인
     * @param loc 확인할 위치
     * @return 포함되어있으면 true, 아니면 false
     */
    public boolean contain(Location loc);

    /**
     * area안에 boundingBox가 포함되어있는지 확인
     * @param boundingBox 확인할 위치
     * @return 포함되어있으면 true, 아니면 false
     */
    public boolean contain(BoundingBox boundingBox);
    /**
     * area안에 interfaceArea가 포함되어있는지 확인
     * @param interfaceArea 확인할 위치
     * @return 포함되어있으면 true, 아니면 false
     */
    public boolean contain(InterfaceArea interfaceArea);

    /**
     * area안에 interfaceArea가 겹치는 구역이 있는지 확인
     * @param interfaceArea 확인할 위치
     * @return 겹치는 공간이 존재하면 true, 아니면 false
     */
    public boolean overlap(InterfaceArea interfaceArea);

    /**
     * area안에 boundingBox가 겹치는 구역이 있는지 확인
     * @param boundingBox 확인할 위치
     * @return 겹치는 공간이 존재하면 true, 아니면 false
     */
    public boolean overlap(BoundingBox boundingBox);

    public boolean playerAct(NewPlayer newPlayer, AreaAct act);
}
