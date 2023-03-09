package org.redkiller.miniGame.hideAndSeek;

public class HideAndSeek {
    /*private final RedKillerKey key = RedKillerKey.randomKey("HideAndSeek");
    private GameStatus status = GameStatus.STOP;

    private Location spawn;
    private int time = 300;
    private KeyedBossBar runnerTimer;
    private KeyedBossBar murderTimer;
    private final ArrayList<UUID> survivor = new ArrayList<>();
    private final ArrayList<UUID> dead = new ArrayList<>();
    private final ArrayList<UUID> murder = new ArrayList<>();

    private final HashMap<UUID, PlayerInventory> playerInventorys = new HashMap<>();
    private final HashMap<GameRule<?>, Object> gameRuleTemp = new HashMap<>();

    private int murderNum = 1;

    public Location getSpawn() {
        return this.spawn;
    }

    public int getTime() {
        return this.time;
    }

    public void setTime(int second) {
        this.time = second;
    }

    public List<UUID> getMurder() {
        return this.murder;
    }

    public boolean checkMurder(UUID uuid) {
        return this.murder.contains(uuid);
    }

    public List<UUID> getDead() {
        return this.dead;
    }

    public boolean checkDead(UUID uuid) {
        return this.dead.contains(uuid);
    }

    public List<UUID> getSurvivor() {
        return this.survivor;
    }

    public boolean checkSurvivor(UUID uuid) {
        return this.survivor.contains(uuid);
    }

    public void setMurderNum(int num) {
        this.murderNum = num;
    }

    private void setGameRule(GameRule gameRule, Object value) {
        World world = spawn.getWorld();
        this.gameRuleTemp.put(gameRule, world.getGameRuleValue(gameRule));
        world.setGameRule(gameRule, value);
    }

    private void victoryRunner() {
        NewPlayer.sendTitleAll("§4§l[ §7도망자가 승리하였습니다! §4§l]", "", this.getSpecterPlayer().toArray(new UUID[0]));
        NewPlayer.sendTitleAll("§4§l[ §a승리하셨습니다 §4§l]", "", this.survivor.toArray(new UUID[0]));
        NewPlayer.sendTitleAll("§4§l[ §a승리하셨습니다 §4§l]", "", this.dead.toArray(new UUID[0]));
        NewPlayer.sendTitleAll("§4§l[ §c패배하셨습니다 §4§l]", "", this.murder.toArray(new UUID[0]));
        stop();
    }

    private void victoryMurder() {
        NewPlayer.sendTitleAll("§4§l[ §7살인마가 승리하였습니다! §4§l]", "", this.getSpecterPlayer().toArray(new UUID[0]));
        NewPlayer.sendTitleAll("§4§l[ §a승리하셨습니다 §4§l]", "", this.murder.toArray(new UUID[0]));
        NewPlayer.sendTitleAll("§4§l[ §c패배하셨습니다 §4§l]", "", this.dead.toArray(new UUID[0]));
        stop();
    }

    public void revive(UUID playerUUID) {
        if (getStatus() != GameStatus.START) {
            return;
        }

        if (!this.getJoinPlayer().contains(playerUUID)) {
            return;
        }

        if (!this.checkDead(playerUUID) || this.checkMurder(playerUUID) || this.checkSurvivor(playerUUID)) {
            return;
        }

        this.dead.remove(playerUUID);
        this.survivor.add(playerUUID);
    }

    public void dead(UUID playerUUID) {
        if (getStatus() != GameStatus.START) {
            return;
        }

        if (!this.getJoinPlayer().contains(playerUUID)) {
            return;
        }

        if (this.checkDead(playerUUID) || this.checkMurder(playerUUID) || !this.checkSurvivor(playerUUID)) {
            return;
        }

        this.survivor.remove(playerUUID);
        this.dead.add(playerUUID);

        if (survivor.isEmpty()) {
            return;
        }

        this.sendMessage(this.getJoinPlayer(), "§4§m                         ",
                "",
                "",
                "§c누군가 살인마에게 사망하셨습니다",
                "§c이제 " + this.survivor.size() + "명 남았습니다",
                "",
                "",
                "§4§m                         ");
    }

    @Override
    public boolean start() {
        status = GameStatus.STARTING;
        RedKillerLibrary.sendLog("HideAndSeek Starting...");
        int playerNum = this.getJoinPlayer().size();

        if (playerNum < 4) {
            NewPlayer.sendMessageAll("§c게임 최소 요구 인원 : 4, 현재 인원 : " + playerNum, this.getJoinPlayer().toArray(new UUID[0]));
        }

        for (UUID playerUUID : this.getSpecterPlayer()) {
            Player player = Bukkit.getPlayer(playerUUID);
            player.teleport(this.spawn);
            player.setGameMode(GameMode.SPECTATOR);
            player.sendTitle("§4§l[ §7당신은 관전자입니다 §4§l]", "§7게임이 조만간 시작됩니다");
        }

        for (int i = 0; i < murderNum; i++) {
            this.murder.add(this.getJoinPlayer().get(new Random().nextInt(playerNum)));
        }

        ItemStack[] murderWeapons = GameItems.MURDER_WEAPON;
        ItemStack[] runnerWeapons = GameItems.RUNNER_WEAPON;
        this.setGameRule(GameRule.DO_MOB_SPAWNING, false);
        this.setGameRule(GameRule.DO_DAYLIGHT_CYCLE, false);
        this.setGameRule(GameRule.FALL_DAMAGE, false);
        this.setGameRule(GameRule.NATURAL_REGENERATION, false);
        this.setGameRule(GameRule.DO_IMMEDIATE_RESPAWN, true);
        this.setGameRule(GameRule.SHOW_DEATH_MESSAGES, false);
        this.setGameRule(GameRule.KEEP_INVENTORY, true);

        for (UUID uuid : this.getJoinPlayer()) {
            NewPlayer player;
            try {
                player = NewPlayer.getNewPlayer(uuid);
            } catch (NullPointerException e) {
                continue;
            }

            player.setHealth(player.getMaxHealth());
            PlayerInventory playerInventory = player.getInventory();
            this.playerInventorys.put(uuid, playerInventory);
            DataMap dataMap = player.getDataMap();
            dataMap.set("HideAndSeek", true);
            playerInventory.clear();
            NamespacedKey namespacedKey = new NamespacedKey(RedKillerLibrary.getPlugin(), "hideAndSeek_Timer");
            runnerTimer = Bukkit.createBossBar(namespacedKey, "§f살인마로부터 살아남으세요", BarColor.GREEN, BarStyle.SOLID);
            murderTimer = Bukkit.createBossBar(namespacedKey, "§f도망자를 모두 죽이세요", BarColor.RED, BarStyle.SOLID);
            Scheduler.delayScheduler(new Scheduler.RunnableEx() {
                @Override
                public void function() {
                    player.getActivePotionEffects().clear();
                    player.setGameMode(GameMode.ADVENTURE);
                    player.teleport(spawn);
                    if (murder.contains(uuid)) {
                        player.sendTitle("§4§l[ §7게임 시작! §4§l]", "§7당신은 §4§l살인마§7입니다 모두를 죽이세요");
                        playerInventory.addItem(murderWeapons[new Random().nextInt(murderWeapons.length)]);
                        player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 4, 999999));
                        player.setWalkSpeed(0.24F);
                        player.makeBossBarTimer(murderTimer, time);
                        dataMap.set("hideAndSeek_murderSkillNum", 0);
                        player.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 400, 5));
                        player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 400, 130));
                        player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 400, 5));
                        player.addPotionEffect(new PotionEffect(PotionEffectType.GLOWING, 400, 5));
                        player.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 400, 5));

                        Scheduler.delayScheduler(new Scheduler.RunnableEx() {
                            @Override
                            public void function() {
                                player.sendTitle("§4§l[ §4§l살인마§7가 풀려났습니다! §4§l]", "§7이제 모두를 죽일 시간입니다");
                            }
                        }, 400);
                    } else {
                        player.sendTitle("§4§l[ §7게임 시작! §4§l]", "§7당신은 §a§l도망자§7입니다 존나 살아남으세요");
                        playerInventory.addItem(runnerWeapons[new Random().nextInt(runnerWeapons.length)]);
                        player.makeBossBarTimer(runnerTimer, time);
                        survivor.add(uuid);

                        Scheduler.delayScheduler(new Scheduler.RunnableEx() {
                            @Override
                            public void function() {
                                player.sendTitle("§4§l[ §4§l살인마§7가 풀려났습니다! §4§l]", "§7지금부터 살인마가 당신을 쫓아옵니다");
                            }
                        }, 400);
                    }
                }
            }, 80);

            for (int i = 3; i >= 1; i--) {
                final int temp = i;
                Scheduler.delayScheduler(new Scheduler.RunnableEx() {
                    @Override
                    public void function() {
                        player.sendTitle("§4§l[" + temp + "§4§l]", "");
                    }
                }, (3 - i) * 20);
            }
        }

        Scheduler.repeatDelayScheduler(new Scheduler.RunnableEx() {
            @Override
            public void function() {
                if (status == GameStatus.STOP) {
                    this.stop();
                }

                if (survivor.isEmpty()) {
                    victoryMurder();
                }

                if (this.getCount() >= this.getRepeat() - 1) {
                    if (status == GameStatus.START) {
                        victoryRunner();
                        return;
                    }
                    this.stop();
                }
            }
        },20, this.time + 4);

        Scheduler.delayScheduler(new Scheduler.RunnableEx() {
            @Override
            public void function() {
                status = GameStatus.START;
                RedKillerLibrary.sendLog("HideAndSeek Start!");
            }
        }, 80);

        return true;
    }

    @Override
    public boolean stop() {
        this.status = GameStatus.STOPPING;

        this.runnerTimer.removeAll();
        this.murderTimer.removeAll();
        this.murder.clear();
        this.survivor.clear();
        this.dead.clear();

        for (UUID uuid : this.getJoinPlayer()) {
            Player player = Bukkit.getPlayer(uuid);

            if (player == null)
                continue;

            player.getInventory().setContents(this.playerInventorys.get(uuid).getContents());
            player.setGameMode(GameMode.SURVIVAL);
        }
        this.getJoinPlayer().clear();
        this.getSpecterPlayer().clear();
        this.status = GameStatus.STOP;
        return true;
    }

    @Override
    public GameStatus getStatus() {
        return this.status;
    }

    @Override
    public RedKillerKey getKey() {
        return key;
    }

    private void sendTitle(List<UUID> playerList, String title, String subTitle) {
        for (UUID uuid : playerList) {
            Player player = Bukkit.getPlayer(uuid);

            if (player == null)
                continue;

            player.sendTitle(title, subTitle);
        }
    }

    private void sendMessage(List<UUID> playerList, String... messages) {
        for (UUID uuid : playerList) {
            Player player = Bukkit.getPlayer(uuid);

            if (player == null)
                continue;

            for (String message : messages) {
                player.sendMessage(message);
            }
        }
    }*/
}
