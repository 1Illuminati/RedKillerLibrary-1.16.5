package org.redkiller.miniGame;

import org.redkiller.util.key.Keyed;

import java.util.List;
import java.util.UUID;

public interface MiniGame extends Keyed {

    public List<UUID> getJoinPlayer();

    public List<UUID> getSpecterPlayer();

    public boolean start();

    public boolean stop();

    public boolean checkJoinPlayer(UUID playerUUID);

    public boolean checkSpecterPlayer(UUID playerUUID);

    public void addJoinPlayer(UUID playerUUID);

    public void addSpecterPlayer(UUID playerUUID);

    public void removeJoinPlayer(UUID playerUUID);

    public void removeSpecterPlayer(UUID playerUUID);

    public GameStatus getStatus();

    public enum GameStatus {
        STARTING, STOPPING, START, STOP
    }
}
