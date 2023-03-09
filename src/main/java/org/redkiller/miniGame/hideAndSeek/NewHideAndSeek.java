package org.redkiller.miniGame.hideAndSeek;

import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.material.MaterialData;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.redkiller.entity.livingentity.player.NewPlayer;
import org.redkiller.entity.livingentity.player.mail.Mail;
import org.redkiller.entity.livingentity.player.offline.NewOfflinePlayer;
import org.redkiller.miniGame.AbstractMiniGame;
import org.redkiller.miniGame.MiniGameStatus;
import org.redkiller.miniGame.hideAndSeek.item.GameItems;
import org.redkiller.util.Scheduler;
import org.redkiller.util.key.RedKillerKey;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class NewHideAndSeek extends AbstractMiniGame {

    private int time = 300;
    private int murderNum = 1;
    private int startDelay = 5;
    private Location spawnLocation;
    private List<UUID> murder = new ArrayList<>();
    private List<UUID> surviver = new ArrayList<>();



    private final RedKillerKey key = new RedKillerKey("HideAndSeek", UUID.randomUUID());
    @Override
    protected boolean start() {
        List<NewPlayer> joinPlayer = new ArrayList<>();
        this.getJoinPlayer().forEach(uuid -> {
            NewPlayer player = NewPlayer.getNewPlayer(uuid);

            if (player != null && player.isOnline())
                joinPlayer.add(player);
            else {
                this.removeJoinPlayer(uuid);
                NewOfflinePlayer offlinePlayer = NewOfflinePlayer.getNewOfflinePlayer(uuid);
                this.sendMessageAll("§c" + offlinePlayer.getName() + "님께서 오프라인 상태가되어 강제로 퇴장되었습니다.");
            }
        });

        if (this.spawnLocation == null) {
            this.sendMessageAll("§c스폰 위치가 설정되지 않았습니다.");
            return false;
        }


        if (joinPlayer.size() < 2) {
            this.sendMessageAll("§c인원이 부족하여 게임이 시작되지 않았습니다.");
            return false;
        }

        for (int i = 0; i < startDelay; i++) {
            final int j = i;

            Scheduler.delayScheduler(new Scheduler.RunnableEx() {
                @Override
                public void function() {
                    sendTitleAll("§c§l[ §f" + (startDelay - j) +  "초 뒤에 게임이 시작됩니다! §c§l]", "");
                }
            }, i * 20);
        }

        for (int i = 0; i < murderNum; i++) {
            while (true) {
                UUID uuid = this.getJoinPlayer().get(randNum(this.getJoinPlayer().size()));

                if (!this.murder.contains(uuid)) {
                    this.murder.add(uuid);
                    break;
                }
            }
        }

        joinPlayer.forEach(player -> {
            player.setGameMode(GameMode.SPECTATOR);
            PlayerInventory playerInventory = player.getInventory();
            player.sendMail(new Mail("인밴토리 보관 메일").addAll(playerInventory.getContents()).addDescription("미니게임 시작시 인벤토리 초기화로 인한 인벤 복구 메일"));
            playerInventory.clear();
            player.setMaxHealth(20);
            player.setHealth(20);
            UUID uuid = player.getUniqueId();

            Scheduler.delayScheduler(new Scheduler.RunnableEx() {
                @Override
                public void function() {
                    if (getStatus() == MiniGameStatus.STOP || getStatus() == MiniGameStatus.STOPPING) {
                        return;
                    }

                    player.teleport(spawnLocation);
                    player.setGameMode(GameMode.ADVENTURE);
                    playerInventory.addItem(new MaterialData(Material.GOLDEN_CARROT).toItemStack(64));

                    if (murder.contains(uuid)) {
                        playerInventory.addItem(randMurderWeapon());
                        player.sendTitle("§c§l[ §f당신은 §4§l살인마 §f입니다! §c§l]", "§7지금부터 모든 생존자를 죽이세요");
                        player.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 400, 5));
                        player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 400, 130));
                        player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 400, 5));
                        player.addPotionEffect(new PotionEffect(PotionEffectType.GLOWING, 400, 5));
                        player.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 400, 5));
                        player.setWalkSpeed(0.22F);
                    } else {
                        surviver.add(uuid);
                        playerInventory.addItem(randRunnerWeapon());
                        player.sendTitle("§c§l[ §f당신은 §a§l생존자 §f입니다! §c§l]", "§7살인마는 20초뒤에 풀려납니다!");
                        player.setWalkSpeed(0.2F);

                        Scheduler.delayScheduler(new Scheduler.RunnableEx() {
                            @Override
                            public void function() {
                                player.sendTitle("§c§l[ §4§l살인마§f가 풀려났습니다! §c§l]", "§7이제부터 살인마가 당신을 쫓아옵니다!");
                            }
                        }, 400);
                    }
                }
            }, 20 * this.startDelay);
        });

        this.getSpecterPlayer().forEach(uuid -> {
            NewPlayer player = NewPlayer.getNewPlayer(uuid);

            if (player != null && !player.isOnline()) {
                this.removeSpecterPlayer(uuid);
            }

            Scheduler.delayScheduler(new Scheduler.RunnableEx() {

                @Override
                public void function() {
                    if (getStatus() == MiniGameStatus.STOP || getStatus() == MiniGameStatus.STOPPING) {
                        return;
                    }

                    player.teleport(spawnLocation);
                    player.sendTitle("§c§l[ §f당신은 §7§l관전자 §f입니다! §c§l]", "§7개꿀잼 팝콘을 뜯을 시간입니다!");
                }
            }, 20 * this.startDelay);
        });


        return true;
    }

    public void setSpawn(Location spawnLocation) {
        this.spawnLocation = spawnLocation;
    }

    @Override
    protected boolean stop() {
        return true;
    }

    @Override
    public RedKillerKey getKey() {
        return key;
    }

    private ItemStack randRunnerWeapon() {
        return GameItems.RUNNER_WEAPON[randNum(GameItems.RUNNER_WEAPON.length)];
    }

    private ItemStack randMurderWeapon() {
        return GameItems.MURDER_WEAPON[randNum(GameItems.MURDER_WEAPON.length)];
    }

}
