package org.redkiller.miniGame;

import org.redkiller.RedKillerLibrary;
import org.redkiller.entity.livingentity.player.NewPlayer;
import org.redkiller.util.key.RedKillerKey;

import java.util.HashMap;
import java.util.UUID;

public class MiniGameManager {
    private static MiniGameManager miniGameManager;

    public static MiniGameManager getManager() {
        if (miniGameManager == null) {
            miniGameManager = new MiniGameManager();
        }

        return miniGameManager;
    }

    private MiniGameManager() {

    }
    private final HashMap<RedKillerKey ,MiniGame> progressingGame = new HashMap<>();

    public boolean checkPlayerPlaying(UUID playerUUID) {
        for (MiniGame miniGame : progressingGame.values()) {
            if (miniGame.checkJoinPlayer(playerUUID)) {
                return true;
            }
        }

        return false;
    }

    public MiniGame getMiniGame(RedKillerKey key) {
        return progressingGame.get(key);
    }

    public void startMiniGame(MiniGame miniGame) {
        RedKillerKey key = miniGame.getKey();
        progressingGame.put(key, miniGame);
        RedKillerLibrary.sendLog(key.toString() + "is Starting...");
        miniGame.start();
    }

    public void joinPlayer(MiniGame game, NewPlayer player) {
        UUID playerUUID = player.getUniqueId();
        if (game.checkJoinPlayer(playerUUID)) {
            player.sendMessage("§c이미 플레이어로 참가하셨습니다!");
            return;
        } else if (game.checkSpecterPlayer(playerUUID)) {
            player.sendMessage("§c현재 관전자로 참여중입니다. 먼저 관전자 참여를 취소해주세요.");
            return;
        }

        game.addJoinPlayer(player.getUniqueId());
        NewPlayer.sendMessageAll("§a" + player.getName() + "님이 게임에 플레이어로 참가하셨습니다!", game.getJoinPlayer().toArray(new UUID[0]));
    }

    public void joinSpecter(MiniGame game, NewPlayer player) {
        UUID playerUUID = player.getUniqueId();
        if (game.checkSpecterPlayer(playerUUID)) {
            player.sendMessage("§c이미 관전자로 참가하셨습니다!");
            return;
        } else if (game.checkJoinPlayer(playerUUID)) {
            player.sendMessage("§c현재 플레이어로 참여중입니다. 먼저 플레이어 참여를 취소해주세요.");
            return;
        }

        game.addSpecterPlayer(player.getUniqueId());
        player.sendMessage("§7게임에 관전자로 참가하셨습니다!");
    }

    public void unJoinPlayer(MiniGame game, NewPlayer player) {
        UUID playerUUID = player.getUniqueId();
        if (!game.checkJoinPlayer(playerUUID)) {
            player.sendMessage("§c아직 플레이어로 참가하지 않았습니다!");
            return;
        }

        game.addJoinPlayer(player.getUniqueId());
        NewPlayer.sendMessageAll("§c" + player.getName() + "플레이어 참여를 취소되었습니다!", game.getJoinPlayer().toArray(new UUID[0]));
    }

    public void unJoinSpecter(MiniGame game, NewPlayer player) {
        UUID playerUUID = player.getUniqueId();
        if (!game.checkJoinPlayer(playerUUID)) {
            player.sendMessage("§c아직 관전자로 참가하지 않았습니다!");
            return;
        }

        game.addJoinPlayer(player.getUniqueId());
        player.sendMessage("§c관전자 참여를 취소되었습니다!");
    }
}
