package org.redkiller.event.events;

import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import org.redkiller.entity.livingentity.player.NewPlayer;
import org.redkiller.system.world.AreaAct;
import org.redkiller.system.world.InterfaceArea;

public class AreaEvent extends Event implements Cancellable {
    private static final HandlerList HANDLERS_LIST = new HandlerList();
    private boolean isCancelled;

    private final NewPlayer player;
    private final InterfaceArea interfaceArea;
    private final AreaAct areaAct;
    private final Event event;

    public AreaEvent(NewPlayer player, InterfaceArea interfaceArea, AreaAct areaAct, Event event) {
        this.player = player;
        this.interfaceArea = interfaceArea;
        this.areaAct = areaAct;
        this.isCancelled = interfaceArea.playerAct(player, areaAct);
        this.event = event;
    }

    public Event getEvent() {
        return event;
    }

    public NewPlayer getPlayer() {
        return this.player;
    }

    public InterfaceArea getInterfaceArea() {
        return this.interfaceArea;
    }

    public AreaAct getAreaAct() {
        return this.areaAct;
    }

    @Override
    public boolean isCancelled() {
        return this.isCancelled;
    }

    @Override
    public void setCancelled(boolean b) {
        this.isCancelled = b;
    }

    @Override
    public @NotNull HandlerList getHandlers() {
        return HANDLERS_LIST;
    }
}
