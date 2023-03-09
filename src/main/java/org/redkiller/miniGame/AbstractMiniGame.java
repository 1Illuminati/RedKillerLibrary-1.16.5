package org.redkiller.miniGame;

import org.bukkit.GameRule;
import org.redkiller.entity.livingentity.player.NewPlayer;
import org.redkiller.util.key.Keyed;

import java.util.*;

public abstract class AbstractMiniGame implements Keyed {

    protected abstract boolean start();

    protected abstract boolean stop();

    private final List<UUID> joinPlayer = new ArrayList<>();
    private final List<UUID> specterPlayer = new ArrayList<>();
    private MiniGameStatus status = MiniGameStatus.STOP;

    private final HashMap<GameRule<?>, Object> gameRuleTemp = new HashMap<>();

    public List<UUID> getJoinPlayer() {
        return joinPlayer;
    }

    public List<UUID> getSpecterPlayer() {
        return specterPlayer;
    }

    public boolean checkJoinPlayer(UUID playerUUID) {
        return joinPlayer.contains(playerUUID);
    }

    public boolean checkSpecterPlayer(UUID playerUUID) {
        return specterPlayer.contains(playerUUID);
    }

    public void addJoinPlayer(UUID playerUUID) {
        joinPlayer.add(playerUUID);
    }

    public void addSpecterPlayer(UUID playerUUID) {
        specterPlayer.add(playerUUID);
    }

    public void removeJoinPlayer(UUID playerUUID) {
        joinPlayer.remove(playerUUID);
    }

    public void removeSpecterPlayer(UUID playerUUID) {
        specterPlayer.remove(playerUUID);
    }

    public MiniGameStatus getStatus() {
        return status;
    }

    public void startGame() {
        if (status == MiniGameStatus.STARTING || status == MiniGameStatus.START) {
            return;
        }

        status = MiniGameStatus.STARTING;
        start();
        status = MiniGameStatus.START;
    }

    public void stopGame() {
        if (status == MiniGameStatus.STOPPING || status == MiniGameStatus.STOP) {
            return;
        }

        status = MiniGameStatus.STOPPING;
        stop();
        this.getJoinPlayer().clear();
        this.getSpecterPlayer().clear();
        status = MiniGameStatus.STOP;
    }

    public void sendTitleAll(String title, String subTitle) {
        this.joinPlayer.forEach(uuid-> NewPlayer.getNewPlayer(uuid).sendTitle(title, subTitle));
        this.specterPlayer.forEach(uuid-> NewPlayer.getNewPlayer(uuid).sendTitle(title, subTitle));
    }

    public void sendMessageAll(String message) {
        this.joinPlayer.forEach(uuid-> NewPlayer.getNewPlayer(uuid).sendMessage(message));
        this.specterPlayer.forEach(uuid-> NewPlayer.getNewPlayer(uuid).sendMessage(message));
    }

    public void sendActionBarAll(String message) {
        this.joinPlayer.forEach(uuid-> NewPlayer.getNewPlayer(uuid).sendActionBar(message));
        this.specterPlayer.forEach(uuid-> NewPlayer.getNewPlayer(uuid).sendActionBar(message));
    }

    protected int randNum(int bound) {
        return new Random().nextInt(bound);
    }

    protected int randNum(int min, int max) {
        return new Random().nextInt(max - min) + min;
    }
}
