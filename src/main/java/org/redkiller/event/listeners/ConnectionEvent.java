package org.redkiller.event.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.redkiller.entity.livingentity.player.NewPlayer;
import org.redkiller.event.AbstractEventListener;

public class ConnectionEvent extends AbstractEventListener {
    @EventHandler(priority = EventPriority.LOWEST)
    public void playerJoinEvent(PlayerJoinEvent event) {
        NewPlayer player = NewPlayer.getNewPlayer(event.getPlayer());
        player.sendMessage("현재 이 서버는 RedKillerLibrary Plugin을 사용하고 있습니다.");
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void playerQuitEvent(PlayerQuitEvent event) {
        NewPlayer player = NewPlayer.getNewPlayer(event.getPlayer());
        player.save();
    }
}
