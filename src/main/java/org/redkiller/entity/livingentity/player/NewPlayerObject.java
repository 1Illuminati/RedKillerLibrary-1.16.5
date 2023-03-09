package org.redkiller.entity.livingentity.player;

import com.destroystokyo.paper.ClientOption;
import com.destroystokyo.paper.Title;
import com.destroystokyo.paper.block.TargetBlockInfo;
import com.destroystokyo.paper.entity.TargetEntityInfo;
import com.destroystokyo.paper.profile.PlayerProfile;
import net.kyori.adventure.audience.MessageType;
import net.kyori.adventure.bossbar.BossBar;
import net.kyori.adventure.identity.Identified;
import net.kyori.adventure.identity.Identity;
import net.kyori.adventure.inventory.Book;
import net.kyori.adventure.sound.SoundStop;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.ComponentLike;
import net.kyori.adventure.text.event.HoverEvent;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.BaseComponent;
import org.bukkit.*;
import org.bukkit.advancement.Advancement;
import org.bukkit.advancement.AdvancementProgress;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.PistonMoveReaction;
import org.bukkit.block.Sign;
import org.bukkit.block.data.BlockData;
import org.bukkit.conversations.Conversation;
import org.bukkit.conversations.ConversationAbandonedEvent;
import org.bukkit.entity.*;
import org.bukkit.entity.memory.MemoryKey;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerResourcePackStatusEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.inventory.*;
import org.bukkit.map.MapView;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.permissions.PermissionAttachmentInfo;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.util.BoundingBox;
import org.bukkit.util.RayTraceResult;
import org.bukkit.util.Vector;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.net.InetSocketAddress;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.function.UnaryOperator;

public class NewPlayerObject {
    private final Player player;

    public NewPlayerObject(Player player) {
        this.player = player;
    }

    @NotNull
    public Identity identity() {
        return player.identity();
    }

    @NotNull
    public Component displayName() {
        return player.displayName();
    }

    public void displayName(@Nullable Component displayName) {
        player.displayName(displayName);
    }

    @Deprecated
    @NotNull
    public String getDisplayName() {
        return player.getDisplayName();
    }

    @Deprecated
    public void setDisplayName(@Nullable String name) {
        player.setDisplayName(name);
    }

    public void playerListName(@Nullable Component name) {
        player.playerListName(name);
    }

    @Nullable
    public Component playerListName() {
        return player.playerListName();
    }

    public @Nullable Component playerListHeader() {
        return player.playerListHeader();
    }

    public @Nullable Component playerListFooter() {
        return player.playerListFooter();
    }

    @Deprecated
    @NotNull
    public String getPlayerListName() {
        return player.getPlayerListName();
    }

    @Deprecated
    public void setPlayerListName(@Nullable String name) {
        player.setPlayerListName(name);
    }

    @Deprecated
    @Nullable
    public String getPlayerListHeader() {
        return player.getPlayerListHeader();
    }

    @Deprecated
    @Nullable
    public String getPlayerListFooter() {
        return player.getPlayerListFooter();
    }

    @Deprecated
    public void setPlayerListHeader(@Nullable String header) {
        player.setPlayerListHeader(header);
    }

    @Deprecated
    public void setPlayerListFooter(@Nullable String footer) {
        player.setPlayerListFooter(footer);
    }

    @Deprecated
    public void setPlayerListHeaderFooter(@Nullable String header, @Nullable String footer) {
        player.setPlayerListHeaderFooter(header, footer);
    }

    public void setCompassTarget(@NotNull Location loc) {
        player.setCompassTarget(loc);
    }

    public @NotNull Location getCompassTarget() {
        return player.getCompassTarget();
    }

    public @Nullable InetSocketAddress getAddress() {
        return player.getAddress();
    }

    public void sendRawMessage(@NotNull String message) {
        player.sendRawMessage(message);
    }

    @Deprecated
    public void kickPlayer(@Nullable String message) {
        player.kickPlayer(message);
    }

    public void kick(@Nullable Component message) {
        player.kick(message);
    }

    public void kick(@Nullable Component message, PlayerKickEvent.@NotNull Cause cause) {
        player.kick(message, cause);
    }

    public void chat(@NotNull String msg) {
        player.chat(msg);
    }

    public boolean performCommand(@NotNull String command) {
        return player.performCommand(command);
    }

    @Deprecated
    public boolean isOnGround() {
        return player.isOnGround();
    }

    public boolean isSneaking() {
        return player.isSneaking();
    }

    public void setSneaking(boolean sneak) {
        player.setSneaking(sneak);
    }

    public boolean isSprinting() {
        return player.isSprinting();
    }

    public void setSprinting(boolean sprinting) {
        player.setSprinting(sprinting);
    }

    public void saveData() {
        player.saveData();
    }

    public void loadData() {
        player.loadData();
    }

    public void setSleepingIgnored(boolean isSleeping) {
        player.setSleepingIgnored(isSleeping);
    }

    public boolean isSleepingIgnored() {
        return player.isSleepingIgnored();
    }

    public @Nullable Location getBedSpawnLocation() {
        return player.getBedSpawnLocation();
    }

    public void setBedSpawnLocation(@Nullable Location location) {
        player.setBedSpawnLocation(location);
    }

    public void setBedSpawnLocation(@Nullable Location location, boolean force) {
        player.setBedSpawnLocation(location, force);
    }

    @Deprecated
    public void playNote(@NotNull Location loc, byte instrument, byte note) {
        player.playNote(loc, instrument, note);
    }

    public void playNote(@NotNull Location loc, @NotNull Instrument instrument, @NotNull Note note) {
        player.playNote(loc, instrument, note);
    }

    public void playSound(@NotNull Location location, @NotNull Sound sound, float volume, float pitch) {
        player.playSound(location, sound, volume, pitch);
    }

    public void playSound(@NotNull Location location, @NotNull String sound, float volume, float pitch) {
        player.playSound(location, sound, volume, pitch);
    }

    public void playSound(@NotNull Location location, @NotNull Sound sound, @NotNull SoundCategory category, float volume, float pitch) {
        player.playSound(location, sound, category, volume, pitch);
    }

    public void playSound(@NotNull Location location, @NotNull String sound, @NotNull SoundCategory category, float volume, float pitch) {
        player.playSound(location, sound, category, volume, pitch);
    }

    public void stopSound(@NotNull Sound sound) {
        player.stopSound(sound);
    }

    public void stopSound(@NotNull String sound) {
        player.stopSound(sound);
    }

    public void stopSound(@NotNull Sound sound, @Nullable SoundCategory category) {
        player.stopSound(sound, category);
    }

    public void stopSound(@NotNull String sound, @Nullable SoundCategory category) {
        player.stopSound(sound, category);
    }

    @Deprecated
    public void playEffect(@NotNull Location loc, @NotNull Effect effect, int data) {
        player.playEffect(loc, effect, data);
    }

    public <T> void playEffect(@NotNull Location loc, @NotNull Effect effect, @Nullable T data) {
        player.playEffect(loc, effect, data);
    }

    @Deprecated
    public void sendBlockChange(@NotNull Location loc, @NotNull Material material, byte data) {
        player.sendBlockChange(loc, material, data);
    }

    public void sendBlockChange(@NotNull Location loc, @NotNull BlockData block) {
        player.sendBlockChange(loc, block);
    }

    public void sendBlockDamage(@NotNull Location loc, float progress) {
        player.sendBlockDamage(loc, progress);
    }

    @Deprecated
    public boolean sendChunkChange(@NotNull Location loc, int sx, int sy, int sz, @NotNull byte[] data) {
        return player.sendChunkChange(loc, sx, sy, sz, data);
    }

    public void sendSignChange(@NotNull Location loc, @Nullable List<Component> lines) throws IllegalArgumentException {
        player.sendSignChange(loc, lines);
    }

    public void sendSignChange(@NotNull Location loc, @Nullable List<Component> lines, @NotNull DyeColor dyeColor) throws IllegalArgumentException {
        player.sendSignChange(loc, lines, dyeColor);
    }

    @Deprecated
    public void sendSignChange(@NotNull Location loc, @Nullable String[] lines) throws IllegalArgumentException {
        player.sendSignChange(loc, lines);
    }

    @Deprecated
    public void sendSignChange(@NotNull Location loc, @Nullable String[] lines, @NotNull DyeColor dyeColor) throws IllegalArgumentException {
        player.sendSignChange(loc, lines, dyeColor);
    }

    public void sendMap(@NotNull MapView map) {
        player.sendMap(map);
    }

    public @Nullable BanEntry banPlayerFull(@Nullable String reason) {
        return player.banPlayerFull(reason);
    }

    public @Nullable BanEntry banPlayerFull(@Nullable String reason, @Nullable String source) {
        return player.banPlayerFull(reason, source);
    }

    public @Nullable BanEntry banPlayerFull(@Nullable String reason, @Nullable Date expires) {
        return player.banPlayerFull(reason, expires);
    }

    public @Nullable BanEntry banPlayerFull(@Nullable String reason, @Nullable Date expires, @Nullable String source) {
        return player.banPlayerFull(reason, expires, source);
    }

    public @Nullable BanEntry banPlayerIP(@Nullable String reason, boolean kickPlayer) {
        return player.banPlayerIP(reason, kickPlayer);
    }

    public @Nullable BanEntry banPlayerIP(@Nullable String reason, @Nullable String source, boolean kickPlayer) {
        return player.banPlayerIP(reason, source, kickPlayer);
    }

    public @Nullable BanEntry banPlayerIP(@Nullable String reason, @Nullable Date expires, boolean kickPlayer) {
        return player.banPlayerIP(reason, expires, kickPlayer);
    }

    public @Nullable BanEntry banPlayerIP(@Nullable String reason) {
        return player.banPlayerIP(reason);
    }

    public @Nullable BanEntry banPlayerIP(@Nullable String reason, @Nullable String source) {
        return player.banPlayerIP(reason, source);
    }

    public @Nullable BanEntry banPlayerIP(@Nullable String reason, @Nullable Date expires) {
        return player.banPlayerIP(reason, expires);
    }

    public @Nullable BanEntry banPlayerIP(@Nullable String reason, @Nullable Date expires, @Nullable String source) {
        return player.banPlayerIP(reason, expires, source);
    }

    public @Nullable BanEntry banPlayerIP(@Nullable String reason, @Nullable Date expires, @Nullable String source, boolean kickPlayer) {
        return player.banPlayerIP(reason, expires, source, kickPlayer);
    }

    @Deprecated
    public void sendActionBar(@NotNull String message) {
        player.sendActionBar(message);
    }

    @Deprecated
    public void sendActionBar(char alternateChar, @NotNull String message) {
        player.sendActionBar(alternateChar, message);
    }

    @Deprecated
    public void sendActionBar(@NotNull BaseComponent... message) {
        player.sendActionBar(message);
    }

    @Deprecated
    public void sendMessage(@NotNull BaseComponent component) {
        player.sendMessage(component);
    }

    @Deprecated
    public void sendMessage(@NotNull BaseComponent... components) {
        player.sendMessage(components);
    }

    @Deprecated
    public void sendMessage(ChatMessageType position, BaseComponent... components) {
        player.sendMessage(position, components);
    }

    @Deprecated
    public void setPlayerListHeaderFooter(@Nullable BaseComponent[] header, @Nullable BaseComponent[] footer) {
        player.setPlayerListHeaderFooter(header, footer);
    }

    @Deprecated
    public void setPlayerListHeaderFooter(@Nullable BaseComponent header, @Nullable BaseComponent footer) {
        player.setPlayerListHeaderFooter(header, footer);
    }

    @Deprecated
    public void setTitleTimes(int fadeInTicks, int stayTicks, int fadeOutTicks) {
        player.setTitleTimes(fadeInTicks, stayTicks, fadeOutTicks);
    }

    @Deprecated
    public void setSubtitle(BaseComponent[] subtitle) {
        player.setSubtitle(subtitle);
    }

    @Deprecated
    public void setSubtitle(BaseComponent subtitle) {
        player.setSubtitle(subtitle);
    }

    @Deprecated
    public void showTitle(@Nullable BaseComponent[] title) {
        player.showTitle(title);
    }

    @Deprecated
    public void showTitle(@Nullable BaseComponent title) {
        player.showTitle(title);
    }

    @Deprecated
    public void showTitle(@Nullable BaseComponent[] title, @Nullable BaseComponent[] subtitle, int fadeInTicks, int stayTicks, int fadeOutTicks) {
        player.showTitle(title, subtitle, fadeInTicks, stayTicks, fadeOutTicks);
    }

    @Deprecated
    public void showTitle(@Nullable BaseComponent title, @Nullable BaseComponent subtitle, int fadeInTicks, int stayTicks, int fadeOutTicks) {
        player.showTitle(title, subtitle, fadeInTicks, stayTicks, fadeOutTicks);
    }

    @Deprecated
    public void sendTitle(@NotNull Title title) {
        player.sendTitle(title);
    }

    @Deprecated
    public void updateTitle(@NotNull Title title) {
        player.updateTitle(title);
    }

    @Deprecated
    public void hideTitle() {
        player.hideTitle();
    }

    public void updateInventory() {
        player.updateInventory();
    }

    public void setPlayerTime(long time, boolean relative) {
        player.setPlayerTime(time, relative);
    }

    public long getPlayerTime() {
        return player.getPlayerTime();
    }

    public long getPlayerTimeOffset() {
        return player.getPlayerTimeOffset();
    }

    public boolean isPlayerTimeRelative() {
        return player.isPlayerTimeRelative();
    }

    public void resetPlayerTime() {
        player.resetPlayerTime();
    }

    public void setPlayerWeather(@NotNull WeatherType type) {
        player.setPlayerWeather(type);
    }

    public @Nullable WeatherType getPlayerWeather() {
        return player.getPlayerWeather();
    }

    public void resetPlayerWeather() {
        player.resetPlayerWeather();
    }

    public void giveExp(int amount) {
        player.giveExp(amount);
    }

    public void giveExp(int amount, boolean applyMending) {
        player.giveExp(amount, applyMending);
    }

    public int applyMending(int amount) {
        return player.applyMending(amount);
    }

    public void giveExpLevels(int amount) {
        player.giveExpLevels(amount);
    }

    public float getExp() {
        return player.getExp();
    }

    public void setExp(float exp) {
        player.setExp(exp);
    }

    public int getLevel() {
        return player.getLevel();
    }

    public void setLevel(int level) {
        player.setLevel(level);
    }

    public int getTotalExperience() {
        return player.getTotalExperience();
    }

    public void setTotalExperience(int exp) {
        player.setTotalExperience(exp);
    }

    public void sendExperienceChange(float progress) {
        player.sendExperienceChange(progress);
    }

    public void sendExperienceChange(float progress, int level) {
        player.sendExperienceChange(progress, level);
    }

    public boolean getAllowFlight() {
        return player.getAllowFlight();
    }

    public void setAllowFlight(boolean flight) {
        player.setAllowFlight(flight);
    }

    @Deprecated
    public void hidePlayer(@NotNull Player player) {
        this.player.hidePlayer(player);
    }

    public void hidePlayer(@NotNull Plugin plugin, @NotNull Player player) {
        this.player.hidePlayer(plugin, player);
    }

    @Deprecated
    public void showPlayer(@NotNull Player player) {
        this.player.showPlayer(player);
    }

    public void showPlayer(@NotNull Plugin plugin, @NotNull Player player) {
        this.player.showPlayer(plugin, player);
    }

    public boolean canSee(@NotNull Player player) {
        return this.player.canSee(player);
    }

    public boolean isFlying() {
        return player.isFlying();
    }

    public void setFlying(boolean value) {
        player.setFlying(value);
    }

    public void setFlySpeed(float value) throws IllegalArgumentException {
        player.setFlySpeed(value);
    }

    public void setWalkSpeed(float value) throws IllegalArgumentException {
        player.setWalkSpeed(value);
    }

    public float getFlySpeed() {
        return player.getFlySpeed();
    }

    public float getWalkSpeed() {
        return player.getWalkSpeed();
    }

    @Deprecated
    public void setTexturePack(@NotNull String url) {
        player.setTexturePack(url);
    }

    @Deprecated
    public void setResourcePack(@NotNull String url) {
        player.setResourcePack(url);
    }

    public void setResourcePack(@NotNull String url, @NotNull byte[] hash) {
        player.setResourcePack(url, hash);
    }

    public @NotNull Scoreboard getScoreboard() {
        return player.getScoreboard();
    }

    public void setScoreboard(@NotNull Scoreboard scoreboard) throws IllegalArgumentException, IllegalStateException {
        player.setScoreboard(scoreboard);
    }

    public boolean isHealthScaled() {
        return player.isHealthScaled();
    }

    public void setHealthScaled(boolean scale) {
        player.setHealthScaled(scale);
    }

    public void setHealthScale(double scale) throws IllegalArgumentException {
        player.setHealthScale(scale);
    }

    public double getHealthScale() {
        return player.getHealthScale();
    }

    public @Nullable Entity getSpectatorTarget() {
        return player.getSpectatorTarget();
    }

    public void setSpectatorTarget(@Nullable Entity entity) {
        player.setSpectatorTarget(entity);
    }

    @Deprecated
    public void sendTitle(@Nullable String title, @Nullable String subtitle) {
        player.sendTitle(title, subtitle);
    }

    public void sendTitle(@Nullable String title, @Nullable String subtitle, int fadeIn, int stay, int fadeOut) {
        player.sendTitle(title, subtitle, fadeIn, stay, fadeOut);
    }

    public void resetTitle() {
        player.resetTitle();
    }

    public void spawnParticle(@NotNull Particle particle, @NotNull Location location, int count) {
        player.spawnParticle(particle, location, count);
    }

    public void spawnParticle(@NotNull Particle particle, double x, double y, double z, int count) {
        player.spawnParticle(particle, x, y, z, count);
    }

    public <T> void spawnParticle(@NotNull Particle particle, @NotNull Location location, int count, @Nullable T data) {
        player.spawnParticle(particle, location, count, data);
    }

    public <T> void spawnParticle(@NotNull Particle particle, double x, double y, double z, int count, @Nullable T data) {
        player.spawnParticle(particle, x, y, z, count, data);
    }

    public void spawnParticle(@NotNull Particle particle, @NotNull Location location, int count, double offsetX, double offsetY, double offsetZ) {
        player.spawnParticle(particle, location, count, offsetX, offsetY, offsetZ);
    }

    public void spawnParticle(@NotNull Particle particle, double x, double y, double z, int count, double offsetX, double offsetY, double offsetZ) {
        player.spawnParticle(particle, x, y, z, count, offsetX, offsetY, offsetZ);
    }

    public <T> void spawnParticle(@NotNull Particle particle, @NotNull Location location, int count, double offsetX, double offsetY, double offsetZ, @Nullable T data) {
        player.spawnParticle(particle, location, count, offsetX, offsetY, offsetZ, data);
    }

    public <T> void spawnParticle(@NotNull Particle particle, double x, double y, double z, int count, double offsetX, double offsetY, double offsetZ, @Nullable T data) {
        player.spawnParticle(particle, x, y, z, count, offsetX, offsetY, offsetZ, data);
    }

    public void spawnParticle(@NotNull Particle particle, @NotNull Location location, int count, double offsetX, double offsetY, double offsetZ, double extra) {
        player.spawnParticle(particle, location, count, offsetX, offsetY, offsetZ, extra);
    }

    public void spawnParticle(@NotNull Particle particle, double x, double y, double z, int count, double offsetX, double offsetY, double offsetZ, double extra) {
        player.spawnParticle(particle, x, y, z, count, offsetX, offsetY, offsetZ, extra);
    }

    public <T> void spawnParticle(@NotNull Particle particle, @NotNull Location location, int count, double offsetX, double offsetY, double offsetZ, double extra, @Nullable T data) {
        player.spawnParticle(particle, location, count, offsetX, offsetY, offsetZ, extra, data);
    }

    public <T> void spawnParticle(@NotNull Particle particle, double x, double y, double z, int count, double offsetX, double offsetY, double offsetZ, double extra, @Nullable T data) {
        player.spawnParticle(particle, x, y, z, count, offsetX, offsetY, offsetZ, extra, data);
    }

    public @NotNull AdvancementProgress getAdvancementProgress(@NotNull Advancement advancement) {
        return player.getAdvancementProgress(advancement);
    }

    public int getClientViewDistance() {
        return player.getClientViewDistance();
    }

    public @NotNull Locale locale() {
        return player.locale();
    }

    public int getPing() {
        return player.getPing();
    }

    @Deprecated
    @NotNull
    public String getLocale() {
        return player.getLocale();
    }

    public boolean getAffectsSpawning() {
        return player.getAffectsSpawning();
    }

    public void setAffectsSpawning(boolean affects) {
        player.setAffectsSpawning(affects);
    }

    @Deprecated
    public int getViewDistance() {
        return player.getViewDistance();
    }

    @Deprecated
    public void setViewDistance(int viewDistance) {
        player.setViewDistance(viewDistance);
    }

    public void updateCommands() {
        player.updateCommands();
    }

    public void openBook(@NotNull ItemStack book) {
        player.openBook(book);
    }

    public @NotNull HoverEvent<HoverEvent.ShowEntity> asHoverEvent(@NotNull UnaryOperator<HoverEvent.ShowEntity> op) {
        return player.asHoverEvent(op);
    }

    public void setResourcePack(@NotNull String url, @NotNull String hash) {
        player.setResourcePack(url, hash);
    }

    public PlayerResourcePackStatusEvent.@Nullable Status getResourcePackStatus() {
        return player.getResourcePackStatus();
    }

    @Deprecated
    @Nullable
    public String getResourcePackHash() {
        return player.getResourcePackHash();
    }

    public boolean hasResourcePack() {
        return player.hasResourcePack();
    }

    public @NotNull PlayerProfile getPlayerProfile() {
        return player.getPlayerProfile();
    }

    public void setPlayerProfile(@NotNull PlayerProfile profile) {
        player.setPlayerProfile(profile);
    }

    public float getCooldownPeriod() {
        return player.getCooldownPeriod();
    }

    public float getCooledAttackStrength(float adjustTicks) {
        return player.getCooledAttackStrength(adjustTicks);
    }

    public void resetCooldown() {
        player.resetCooldown();
    }

    public <T> @NotNull T getClientOption(@NotNull ClientOption<T> option) {
        return player.getClientOption(option);
    }

    public @Nullable Firework boostElytra(@NotNull ItemStack firework) {
        return player.boostElytra(firework);
    }

    public void sendOpLevel(byte level) {
        player.sendOpLevel(level);
    }

    public @NotNull Set<Player> getTrackedPlayers() {
        return player.getTrackedPlayers();
    }

    @Nullable
    public String getClientBrandName() {
        return player.getClientBrandName();
    }

    public Player.@NotNull Spigot spigot() {
        return player.spigot();
    }

    @NotNull
    public String getName() {
        return player.getName();
    }

    public @NotNull PlayerInventory getInventory() {
        return player.getInventory();
    }

    public @NotNull Inventory getEnderChest() {
        return player.getEnderChest();
    }

    public @NotNull MainHand getMainHand() {
        return player.getMainHand();
    }

    public boolean setWindowProperty(InventoryView.@NotNull Property prop, int value) {
        return player.setWindowProperty(prop, value);
    }

    public @NotNull InventoryView getOpenInventory() {
        return player.getOpenInventory();
    }

    public @Nullable InventoryView openInventory(@NotNull Inventory inventory) {
        return player.openInventory(inventory);
    }

    public @Nullable InventoryView openWorkbench(@Nullable Location location, boolean force) {
        return player.openWorkbench(location, force);
    }

    public @Nullable InventoryView openEnchanting(@Nullable Location location, boolean force) {
        return player.openEnchanting(location, force);
    }

    public void openInventory(@NotNull InventoryView inventory) {
        player.openInventory(inventory);
    }

    public @Nullable InventoryView openMerchant(@NotNull Villager trader, boolean force) {
        return player.openMerchant(trader, force);
    }

    public @Nullable InventoryView openMerchant(@NotNull Merchant merchant, boolean force) {
        return player.openMerchant(merchant, force);
    }

    public @Nullable InventoryView openAnvil(@Nullable Location location, boolean force) {
        return player.openAnvil(location, force);
    }

    public @Nullable InventoryView openCartographyTable(@Nullable Location location, boolean force) {
        return player.openCartographyTable(location, force);
    }

    public @Nullable InventoryView openGrindstone(@Nullable Location location, boolean force) {
        return player.openGrindstone(location, force);
    }

    public @Nullable InventoryView openLoom(@Nullable Location location, boolean force) {
        return player.openLoom(location, force);
    }

    public @Nullable InventoryView openSmithingTable(@Nullable Location location, boolean force) {
        return player.openSmithingTable(location, force);
    }

    public @Nullable InventoryView openStonecutter(@Nullable Location location, boolean force) {
        return player.openStonecutter(location, force);
    }

    public void closeInventory() {
        player.closeInventory();
    }

    public void closeInventory(InventoryCloseEvent.@NotNull Reason reason) {
        player.closeInventory(reason);
    }

    @Deprecated
    public @NotNull ItemStack getItemInHand() {
        return player.getItemInHand();
    }

    @Deprecated
    public void setItemInHand(@Nullable ItemStack item) {
        player.setItemInHand(item);
    }

    public @NotNull ItemStack getItemOnCursor() {
        return player.getItemOnCursor();
    }

    public void setItemOnCursor(@Nullable ItemStack item) {
        player.setItemOnCursor(item);
    }

    public boolean hasCooldown(@NotNull Material material) {
        return player.hasCooldown(material);
    }

    public int getCooldown(@NotNull Material material) {
        return player.getCooldown(material);
    }

    public void setCooldown(@NotNull Material material, int ticks) {
        player.setCooldown(material, ticks);
    }

    public boolean isDeeplySleeping() {
        return player.isDeeplySleeping();
    }

    public int getSleepTicks() {
        return player.getSleepTicks();
    }

    public @Nullable Location getPotentialBedLocation() {
        return player.getPotentialBedLocation();
    }

    public boolean sleep(@NotNull Location location, boolean force) {
        return player.sleep(location, force);
    }

    public void wakeup(boolean setSpawnLocation) {
        player.wakeup(setSpawnLocation);
    }

    public @NotNull Location getBedLocation() {
        return player.getBedLocation();
    }

    public @NotNull GameMode getGameMode() {
        return player.getGameMode();
    }

    public void setGameMode(@NotNull GameMode mode) {
        player.setGameMode(mode);
    }

    public boolean isBlocking() {
        return player.isBlocking();
    }

    public boolean isHandRaised() {
        return player.isHandRaised();
    }

    public int getExpToLevel() {
        return player.getExpToLevel();
    }

    public @Nullable Entity releaseLeftShoulderEntity() {
        return player.releaseLeftShoulderEntity();
    }

    public @Nullable Entity releaseRightShoulderEntity() {
        return player.releaseRightShoulderEntity();
    }

    public float getAttackCooldown() {
        return player.getAttackCooldown();
    }

    public boolean discoverRecipe(@NotNull NamespacedKey recipe) {
        return player.discoverRecipe(recipe);
    }

    public int discoverRecipes(@NotNull Collection<NamespacedKey> recipes) {
        return player.discoverRecipes(recipes);
    }

    public boolean undiscoverRecipe(@NotNull NamespacedKey recipe) {
        return player.undiscoverRecipe(recipe);
    }

    public int undiscoverRecipes(@NotNull Collection<NamespacedKey> recipes) {
        return player.undiscoverRecipes(recipes);
    }

    public boolean hasDiscoveredRecipe(@NotNull NamespacedKey recipe) {
        return player.hasDiscoveredRecipe(recipe);
    }

    public @NotNull Set<NamespacedKey> getDiscoveredRecipes() {
        return player.getDiscoveredRecipes();
    }

    @Deprecated
    public @Nullable Entity getShoulderEntityLeft() {
        return player.getShoulderEntityLeft();
    }

    @Deprecated
    public void setShoulderEntityLeft(@Nullable Entity entity) {
        player.setShoulderEntityLeft(entity);
    }

    @Deprecated
    public @Nullable Entity getShoulderEntityRight() {
        return player.getShoulderEntityRight();
    }

    @Deprecated
    public void setShoulderEntityRight(@Nullable Entity entity) {
        player.setShoulderEntityRight(entity);
    }

    public void openSign(@NotNull Sign sign) {
        player.openSign(sign);
    }

    public boolean dropItem(boolean dropAll) {
        return player.dropItem(dropAll);
    }

    public float getExhaustion() {
        return player.getExhaustion();
    }

    public void setExhaustion(float value) {
        player.setExhaustion(value);
    }

    public float getSaturation() {
        return player.getSaturation();
    }

    public void setSaturation(float value) {
        player.setSaturation(value);
    }

    public int getFoodLevel() {
        return player.getFoodLevel();
    }

    public void setFoodLevel(int value) {
        player.setFoodLevel(value);
    }

    public int getSaturatedRegenRate() {
        return player.getSaturatedRegenRate();
    }

    public void setSaturatedRegenRate(int ticks) {
        player.setSaturatedRegenRate(ticks);
    }

    public int getUnsaturatedRegenRate() {
        return player.getUnsaturatedRegenRate();
    }

    public void setUnsaturatedRegenRate(int ticks) {
        player.setUnsaturatedRegenRate(ticks);
    }

    public int getStarvationRate() {
        return player.getStarvationRate();
    }

    public void setStarvationRate(int ticks) {
        player.setStarvationRate(ticks);
    }

    public double getEyeHeight() {
        return player.getEyeHeight();
    }

    public double getEyeHeight(boolean ignorePose) {
        return player.getEyeHeight(ignorePose);
    }

    public @NotNull Location getEyeLocation() {
        return player.getEyeLocation();
    }

    public @NotNull List<Block> getLineOfSight(@Nullable Set<Material> transparent, int maxDistance) {
        return player.getLineOfSight(transparent, maxDistance);
    }

    public @NotNull Block getTargetBlock(@Nullable Set<Material> transparent, int maxDistance) {
        return player.getTargetBlock(transparent, maxDistance);
    }

    public @Nullable Block getTargetBlock(int maxDistance) {
        return player.getTargetBlock(maxDistance);
    }

    public @Nullable Block getTargetBlock(int maxDistance, TargetBlockInfo.@NotNull FluidMode fluidMode) {
        return player.getTargetBlock(maxDistance, fluidMode);
    }

    public @Nullable BlockFace getTargetBlockFace(int maxDistance) {
        return player.getTargetBlockFace(maxDistance);
    }

    public @Nullable BlockFace getTargetBlockFace(int maxDistance, TargetBlockInfo.@NotNull FluidMode fluidMode) {
        return player.getTargetBlockFace(maxDistance, fluidMode);
    }

    public @Nullable TargetBlockInfo getTargetBlockInfo(int maxDistance) {
        return player.getTargetBlockInfo(maxDistance);
    }

    public @Nullable TargetBlockInfo getTargetBlockInfo(int maxDistance, TargetBlockInfo.@NotNull FluidMode fluidMode) {
        return player.getTargetBlockInfo(maxDistance, fluidMode);
    }

    public @Nullable Entity getTargetEntity(int maxDistance) {
        return player.getTargetEntity(maxDistance);
    }

    public @Nullable Entity getTargetEntity(int maxDistance, boolean ignoreBlocks) {
        return player.getTargetEntity(maxDistance, ignoreBlocks);
    }

    public @Nullable TargetEntityInfo getTargetEntityInfo(int maxDistance) {
        return player.getTargetEntityInfo(maxDistance);
    }

    public @Nullable TargetEntityInfo getTargetEntityInfo(int maxDistance, boolean ignoreBlocks) {
        return player.getTargetEntityInfo(maxDistance, ignoreBlocks);
    }

    public @NotNull List<Block> getLastTwoTargetBlocks(@Nullable Set<Material> transparent, int maxDistance) {
        return player.getLastTwoTargetBlocks(transparent, maxDistance);
    }

    public @Nullable Block getTargetBlockExact(int maxDistance) {
        return player.getTargetBlockExact(maxDistance);
    }

    public @Nullable Block getTargetBlockExact(int maxDistance, @NotNull FluidCollisionMode fluidCollisionMode) {
        return player.getTargetBlockExact(maxDistance, fluidCollisionMode);
    }

    public @Nullable RayTraceResult rayTraceBlocks(double maxDistance) {
        return player.rayTraceBlocks(maxDistance);
    }

    public @Nullable RayTraceResult rayTraceBlocks(double maxDistance, @NotNull FluidCollisionMode fluidCollisionMode) {
        return player.rayTraceBlocks(maxDistance, fluidCollisionMode);
    }

    public int getRemainingAir() {
        return player.getRemainingAir();
    }

    public void setRemainingAir(int ticks) {
        player.setRemainingAir(ticks);
    }

    public int getMaximumAir() {
        return player.getMaximumAir();
    }

    public void setMaximumAir(int ticks) {
        player.setMaximumAir(ticks);
    }

    public int getArrowCooldown() {
        return player.getArrowCooldown();
    }

    public void setArrowCooldown(int ticks) {
        player.setArrowCooldown(ticks);
    }

    public int getArrowsInBody() {
        return player.getArrowsInBody();
    }

    public void setArrowsInBody(int count) {
        player.setArrowsInBody(count);
    }

    public int getMaximumNoDamageTicks() {
        return player.getMaximumNoDamageTicks();
    }

    public void setMaximumNoDamageTicks(int ticks) {
        player.setMaximumNoDamageTicks(ticks);
    }

    public double getLastDamage() {
        return player.getLastDamage();
    }

    public void setLastDamage(double damage) {
        player.setLastDamage(damage);
    }

    public int getNoDamageTicks() {
        return player.getNoDamageTicks();
    }

    public void setNoDamageTicks(int ticks) {
        player.setNoDamageTicks(ticks);
    }

    @Nullable
    public Player getKiller() {
        return player.getKiller();
    }

    public void setKiller(@Nullable Player killer) {
        player.setKiller(killer);
    }

    public boolean addPotionEffect(@NotNull PotionEffect effect) {
        return player.addPotionEffect(effect);
    }

    @Deprecated
    public boolean addPotionEffect(@NotNull PotionEffect effect, boolean force) {
        return player.addPotionEffect(effect, force);
    }

    public boolean addPotionEffects(@NotNull Collection<PotionEffect> effects) {
        return player.addPotionEffects(effects);
    }

    public boolean hasPotionEffect(@NotNull PotionEffectType type) {
        return player.hasPotionEffect(type);
    }

    public @Nullable PotionEffect getPotionEffect(@NotNull PotionEffectType type) {
        return player.getPotionEffect(type);
    }

    public void removePotionEffect(@NotNull PotionEffectType type) {
        player.removePotionEffect(type);
    }

    public @NotNull Collection<PotionEffect> getActivePotionEffects() {
        return player.getActivePotionEffects();
    }

    public boolean hasLineOfSight(@NotNull Entity other) {
        return player.hasLineOfSight(other);
    }

    public boolean hasLineOfSight(@NotNull Location location) {
        return player.hasLineOfSight(location);
    }

    public boolean getRemoveWhenFarAway() {
        return player.getRemoveWhenFarAway();
    }

    public void setRemoveWhenFarAway(boolean remove) {
        player.setRemoveWhenFarAway(remove);
    }

    public @Nullable EntityEquipment getEquipment() {
        return player.getEquipment();
    }

    public void setCanPickupItems(boolean pickup) {
        player.setCanPickupItems(pickup);
    }

    public boolean getCanPickupItems() {
        return player.getCanPickupItems();
    }

    public boolean isLeashed() {
        return player.isLeashed();
    }

    public @NotNull Entity getLeashHolder() throws IllegalStateException {
        return player.getLeashHolder();
    }

    public boolean setLeashHolder(@Nullable Entity holder) {
        return player.setLeashHolder(holder);
    }

    public boolean isGliding() {
        return player.isGliding();
    }

    public void setGliding(boolean gliding) {
        player.setGliding(gliding);
    }

    public boolean isSwimming() {
        return player.isSwimming();
    }

    public void setSwimming(boolean swimming) {
        player.setSwimming(swimming);
    }

    public boolean isRiptiding() {
        return player.isRiptiding();
    }

    public boolean isSleeping() {
        return player.isSleeping();
    }

    public void setAI(boolean ai) {
        player.setAI(ai);
    }

    public boolean hasAI() {
        return player.hasAI();
    }

    public void attack(@NotNull Entity target) {
        player.attack(target);
    }

    public void swingMainHand() {
        player.swingMainHand();
    }

    public void swingOffHand() {
        player.swingOffHand();
    }

    public void setCollidable(boolean collidable) {
        player.setCollidable(collidable);
    }

    public boolean isCollidable() {
        return player.isCollidable();
    }

    public @NotNull Set<UUID> getCollidableExemptions() {
        return player.getCollidableExemptions();
    }

    public <T> @Nullable T getMemory(@NotNull MemoryKey<T> memoryKey) {
        return player.getMemory(memoryKey);
    }

    public <T> void setMemory(@NotNull MemoryKey<T> memoryKey, @Nullable T memoryValue) {
        player.setMemory(memoryKey, memoryValue);
    }

    public @NotNull EntityCategory getCategory() {
        return player.getCategory();
    }

    public void setInvisible(boolean invisible) {
        player.setInvisible(invisible);
    }

    public boolean isInvisible() {
        return player.isInvisible();
    }

    public int getArrowsStuck() {
        return player.getArrowsStuck();
    }

    public void setArrowsStuck(int arrows) {
        player.setArrowsStuck(arrows);
    }

    public int getShieldBlockingDelay() {
        return player.getShieldBlockingDelay();
    }

    public void setShieldBlockingDelay(int delay) {
        player.setShieldBlockingDelay(delay);
    }

    public @Nullable ItemStack getActiveItem() {
        return player.getActiveItem();
    }

    public void clearActiveItem() {
        player.clearActiveItem();
    }

    public int getItemUseRemainingTime() {
        return player.getItemUseRemainingTime();
    }

    public int getHandRaisedTime() {
        return player.getHandRaisedTime();
    }

    public @NotNull EquipmentSlot getHandRaised() {
        return player.getHandRaised();
    }

    public boolean isJumping() {
        return player.isJumping();
    }

    public void setJumping(boolean jumping) {
        player.setJumping(jumping);
    }

    public void playPickupItemAnimation(@NotNull Item item) {
        player.playPickupItemAnimation(item);
    }

    public void playPickupItemAnimation(@NotNull Item item, int quantity) {
        player.playPickupItemAnimation(item, quantity);
    }

    public float getHurtDirection() {
        return player.getHurtDirection();
    }

    public void setHurtDirection(float hurtDirection) {
        player.setHurtDirection(hurtDirection);
    }

    public @Nullable AttributeInstance getAttribute(@NotNull Attribute attribute) {
        return player.getAttribute(attribute);
    }

    public void registerAttribute(@NotNull Attribute attribute) {
        player.registerAttribute(attribute);
    }

    public void damage(double amount) {
        player.damage(amount);
    }

    public void damage(double amount, @Nullable Entity source) {
        player.damage(amount, source);
    }

    public double getHealth() {
        return player.getHealth();
    }

    public void setHealth(double health) {
        player.setHealth(health);
    }

    public double getAbsorptionAmount() {
        return player.getAbsorptionAmount();
    }

    public void setAbsorptionAmount(double amount) {
        player.setAbsorptionAmount(amount);
    }

    @Deprecated
    public double getMaxHealth() {
        return player.getMaxHealth();
    }

    @Deprecated
    public void setMaxHealth(double health) {
        player.setMaxHealth(health);
    }

    @Deprecated
    public void resetMaxHealth() {
        player.resetMaxHealth();
    }

    public @NotNull Location getLocation() {
        return player.getLocation();
    }

    @Contract("null -> null; !null -> !null")
    public @Nullable Location getLocation(@Nullable Location loc) {
        return player.getLocation(loc);
    }

    public void setVelocity(@NotNull Vector velocity) {
        player.setVelocity(velocity);
    }

    public @NotNull Vector getVelocity() {
        return player.getVelocity();
    }

    public double getHeight() {
        return player.getHeight();
    }

    public double getWidth() {
        return player.getWidth();
    }

    public @NotNull BoundingBox getBoundingBox() {
        return player.getBoundingBox();
    }

    public boolean isInWater() {
        return player.isInWater();
    }

    public @NotNull World getWorld() {
        return player.getWorld();
    }

    public void setRotation(float yaw, float pitch) {
        player.setRotation(yaw, pitch);
    }

    public boolean teleport(@NotNull Location location) {
        return player.teleport(location);
    }

    public boolean teleport(@NotNull Location location, PlayerTeleportEvent.@NotNull TeleportCause cause) {
        return player.teleport(location, cause);
    }

    public boolean teleport(@NotNull Entity destination) {
        return player.teleport(destination);
    }

    public boolean teleport(@NotNull Entity destination, PlayerTeleportEvent.@NotNull TeleportCause cause) {
        return player.teleport(destination, cause);
    }

    public @NotNull CompletableFuture<Boolean> teleportAsync(@NotNull Location loc) {
        return player.teleportAsync(loc);
    }

    public @NotNull CompletableFuture<Boolean> teleportAsync(@NotNull Location loc, PlayerTeleportEvent.@NotNull TeleportCause cause) {
        return player.teleportAsync(loc, cause);
    }

    public @NotNull List<Entity> getNearbyEntities(double x, double y, double z) {
        return player.getNearbyEntities(x, y, z);
    }

    public int getEntityId() {
        return player.getEntityId();
    }

    public int getFireTicks() {
        return player.getFireTicks();
    }

    public int getMaxFireTicks() {
        return player.getMaxFireTicks();
    }

    public void setFireTicks(int ticks) {
        player.setFireTicks(ticks);
    }

    public void remove() {
        player.remove();
    }

    public boolean isDead() {
        return player.isDead();
    }

    public boolean isValid() {
        return player.isValid();
    }

    public @NotNull Server getServer() {
        return player.getServer();
    }

    public boolean isPersistent() {
        return player.isPersistent();
    }

    public void setPersistent(boolean persistent) {
        player.setPersistent(persistent);
    }

    @Deprecated
    public @Nullable Entity getPassenger() {
        return player.getPassenger();
    }

    @Deprecated
    public boolean setPassenger(@NotNull Entity passenger) {
        return player.setPassenger(passenger);
    }

    public @NotNull List<Entity> getPassengers() {
        return player.getPassengers();
    }

    public boolean addPassenger(@NotNull Entity passenger) {
        return player.addPassenger(passenger);
    }

    public boolean removePassenger(@NotNull Entity passenger) {
        return player.removePassenger(passenger);
    }

    public boolean isEmpty() {
        return player.isEmpty();
    }

    public boolean eject() {
        return player.eject();
    }

    public float getFallDistance() {
        return player.getFallDistance();
    }

    public void setFallDistance(float distance) {
        player.setFallDistance(distance);
    }

    public void setLastDamageCause(@Nullable EntityDamageEvent event) {
        player.setLastDamageCause(event);
    }

    public @Nullable EntityDamageEvent getLastDamageCause() {
        return player.getLastDamageCause();
    }

    public @NotNull UUID getUniqueId() {
        return player.getUniqueId();
    }

    public int getTicksLived() {
        return player.getTicksLived();
    }

    public void setTicksLived(int value) {
        player.setTicksLived(value);
    }

    public void playEffect(@NotNull EntityEffect type) {
        player.playEffect(type);
    }

    public @NotNull EntityType getType() {
        return player.getType();
    }

    public boolean isInsideVehicle() {
        return player.isInsideVehicle();
    }

    public boolean leaveVehicle() {
        return player.leaveVehicle();
    }

    public @Nullable Entity getVehicle() {
        return player.getVehicle();
    }

    public void setCustomNameVisible(boolean flag) {
        player.setCustomNameVisible(flag);
    }

    public boolean isCustomNameVisible() {
        return player.isCustomNameVisible();
    }

    public void setGlowing(boolean flag) {
        player.setGlowing(flag);
    }

    public boolean isGlowing() {
        return player.isGlowing();
    }

    public void setInvulnerable(boolean flag) {
        player.setInvulnerable(flag);
    }

    public boolean isInvulnerable() {
        return player.isInvulnerable();
    }

    public boolean isSilent() {
        return player.isSilent();
    }

    public void setSilent(boolean flag) {
        player.setSilent(flag);
    }

    public boolean hasGravity() {
        return player.hasGravity();
    }

    public void setGravity(boolean gravity) {
        player.setGravity(gravity);
    }

    public int getPortalCooldown() {
        return player.getPortalCooldown();
    }

    public void setPortalCooldown(int cooldown) {
        player.setPortalCooldown(cooldown);
    }

    public @NotNull Set<String> getScoreboardTags() {
        return player.getScoreboardTags();
    }

    public boolean addScoreboardTag(@NotNull String tag) {
        return player.addScoreboardTag(tag);
    }

    public boolean removeScoreboardTag(@NotNull String tag) {
        return player.removeScoreboardTag(tag);
    }

    public @NotNull PistonMoveReaction getPistonMoveReaction() {
        return player.getPistonMoveReaction();
    }

    public @NotNull BlockFace getFacing() {
        return player.getFacing();
    }

    public @NotNull Pose getPose() {
        return player.getPose();
    }

    public @Nullable Location getOrigin() {
        return player.getOrigin();
    }

    public boolean fromMobSpawner() {
        return player.fromMobSpawner();
    }

    public @NotNull Chunk getChunk() {
        return player.getChunk();
    }

    public CreatureSpawnEvent.@NotNull SpawnReason getEntitySpawnReason() {
        return player.getEntitySpawnReason();
    }

    public boolean isInRain() {
        return player.isInRain();
    }

    public boolean isInBubbleColumn() {
        return player.isInBubbleColumn();
    }

    public boolean isInWaterOrRain() {
        return player.isInWaterOrRain();
    }

    public boolean isInWaterOrBubbleColumn() {
        return player.isInWaterOrBubbleColumn();
    }

    public boolean isInWaterOrRainOrBubbleColumn() {
        return player.isInWaterOrRainOrBubbleColumn();
    }

    public boolean isInLava() {
        return player.isInLava();
    }

    public boolean isTicking() {
        return player.isTicking();
    }

    public void setMetadata(@NotNull String metadataKey, @NotNull MetadataValue newMetadataValue) {
        player.setMetadata(metadataKey, newMetadataValue);
    }

    public @NotNull List<MetadataValue> getMetadata(@NotNull String metadataKey) {
        return player.getMetadata(metadataKey);
    }

    public boolean hasMetadata(@NotNull String metadataKey) {
        return player.hasMetadata(metadataKey);
    }

    public void removeMetadata(@NotNull String metadataKey, @NotNull Plugin owningPlugin) {
        player.removeMetadata(metadataKey, owningPlugin);
    }

    public void sendMessage(@NotNull String message) {
        player.sendMessage(message);
    }

    public void sendMessage(@NotNull String[] messages) {
        player.sendMessage(messages);
    }

    public void sendMessage(@Nullable UUID sender, @NotNull String message) {
        player.sendMessage(sender, message);
    }

    public void sendMessage(@Nullable UUID sender, @NotNull String[] messages) {
        player.sendMessage(sender, messages);
    }

    public void sendMessage(@NotNull Identity identity, @NotNull Component message, @NotNull MessageType type) {
        player.sendMessage(identity, message, type);
    }

    public void sendMessage(@NonNull ComponentLike message) {
        player.sendMessage(message);
    }

    public void sendMessage(@NonNull Identified source, @NonNull ComponentLike message) {
        player.sendMessage(source, message);
    }

    public void sendMessage(@NonNull Identity source, @NonNull ComponentLike message) {
        player.sendMessage(source, message);
    }

    public void sendMessage(@NonNull Component message) {
        player.sendMessage(message);
    }

    public void sendMessage(@NonNull Identified source, @NonNull Component message) {
        player.sendMessage(source, message);
    }

    public void sendMessage(@NonNull Identity source, @NonNull Component message) {
        player.sendMessage(source, message);
    }

    public void sendMessage(@NonNull ComponentLike message, @NonNull MessageType type) {
        player.sendMessage(message, type);
    }

    public void sendMessage(@NonNull Identified source, @NonNull ComponentLike message, @NonNull MessageType type) {
        player.sendMessage(source, message, type);
    }

    public void sendMessage(@NonNull Identity source, @NonNull ComponentLike message, @NonNull MessageType type) {
        player.sendMessage(source, message, type);
    }

    public void sendMessage(@NonNull Component message, @NonNull MessageType type) {
        player.sendMessage(message, type);
    }

    public void sendMessage(@NonNull Identified source, @NonNull Component message, @NonNull MessageType type) {
        player.sendMessage(source, message, type);
    }

    public void sendActionBar(@NonNull ComponentLike message) {
        player.sendActionBar(message);
    }

    public void sendActionBar(@NonNull Component message) {
        player.sendActionBar(message);
    }

    public void sendPlayerListHeader(@NonNull ComponentLike header) {
        player.sendPlayerListHeader(header);
    }

    public void sendPlayerListHeader(@NonNull Component header) {
        player.sendPlayerListHeader(header);
    }

    public void sendPlayerListFooter(@NonNull ComponentLike footer) {
        player.sendPlayerListFooter(footer);
    }

    public void sendPlayerListFooter(@NonNull Component footer) {
        player.sendPlayerListFooter(footer);
    }

    public void sendPlayerListHeaderAndFooter(@NonNull ComponentLike header, @NonNull ComponentLike footer) {
        player.sendPlayerListHeaderAndFooter(header, footer);
    }

    public void sendPlayerListHeaderAndFooter(@NonNull Component header, @NonNull Component footer) {
        player.sendPlayerListHeaderAndFooter(header, footer);
    }

    public void showTitle(net.kyori.adventure.title.@NonNull Title title) {
        player.showTitle(title);
    }

    public void clearTitle() {
        player.clearTitle();
    }

    public void showBossBar(@NonNull BossBar bar) {
        player.showBossBar(bar);
    }

    public void hideBossBar(@NonNull BossBar bar) {
        player.hideBossBar(bar);
    }

    public void playSound(net.kyori.adventure.sound.@NonNull Sound sound) {
        player.playSound(sound);
    }

    public void playSound(net.kyori.adventure.sound.@NonNull Sound sound, double x, double y, double z) {
        player.playSound(sound, x, y, z);
    }

    public void stopSound(@NonNull SoundStop stop) {
        player.stopSound(stop);
    }

    public void openBook(Book.@NonNull Builder book) {
        player.openBook(book);
    }

    public void openBook(@NonNull Book book) {
        player.openBook(book);
    }

    public boolean isPermissionSet(@NotNull String name) {
        return player.isPermissionSet(name);
    }

    public boolean isPermissionSet(@NotNull Permission perm) {
        return player.isPermissionSet(perm);
    }

    public boolean hasPermission(@NotNull String name) {
        return player.hasPermission(name);
    }

    public boolean hasPermission(@NotNull Permission perm) {
        return player.hasPermission(perm);
    }

    public @NotNull PermissionAttachment addAttachment(@NotNull Plugin plugin, @NotNull String name, boolean value) {
        return player.addAttachment(plugin, name, value);
    }

    public @NotNull PermissionAttachment addAttachment(@NotNull Plugin plugin) {
        return player.addAttachment(plugin);
    }

    public @Nullable PermissionAttachment addAttachment(@NotNull Plugin plugin, @NotNull String name, boolean value, int ticks) {
        return player.addAttachment(plugin, name, value, ticks);
    }

    public @Nullable PermissionAttachment addAttachment(@NotNull Plugin plugin, int ticks) {
        return player.addAttachment(plugin, ticks);
    }

    public void removeAttachment(@NotNull PermissionAttachment attachment) {
        player.removeAttachment(attachment);
    }

    public void recalculatePermissions() {
        player.recalculatePermissions();
    }

    public @NotNull Set<PermissionAttachmentInfo> getEffectivePermissions() {
        return player.getEffectivePermissions();
    }

    public boolean isOp() {
        return player.isOp();
    }

    public void setOp(boolean value) {
        player.setOp(value);
    }

    public @Nullable Component customName() {
        return player.customName();
    }

    public void customName(@Nullable Component customName) {
        player.customName(customName);
    }

    @Nullable
    public String getCustomName() {
        return player.getCustomName();
    }

    public void setCustomName(@Nullable String name) {
        player.setCustomName(name);
    }

    public @NotNull PersistentDataContainer getPersistentDataContainer() {
        return player.getPersistentDataContainer();
    }

    public @NonNull HoverEvent<HoverEvent.ShowEntity> asHoverEvent() {
        return player.asHoverEvent();
    }

    public <T extends Projectile> @NotNull T launchProjectile(@NotNull Class<? extends T> projectile) {
        return player.launchProjectile(projectile);
    }

    public <T extends Projectile> @NotNull T launchProjectile(@NotNull Class<? extends T> projectile, @Nullable Vector velocity) {
        return player.launchProjectile(projectile, velocity);
    }

    public boolean isConversing() {
        return player.isConversing();
    }

    public void acceptConversationInput(@NotNull String input) {
        player.acceptConversationInput(input);
    }

    public boolean beginConversation(@NotNull Conversation conversation) {
        return player.beginConversation(conversation);
    }

    public void abandonConversation(@NotNull Conversation conversation) {
        player.abandonConversation(conversation);
    }

    public void abandonConversation(@NotNull Conversation conversation, @NotNull ConversationAbandonedEvent details) {
        player.abandonConversation(conversation, details);
    }

    public void sendRawMessage(@Nullable UUID sender, @NotNull String message) {
        player.sendRawMessage(sender, message);
    }

    public boolean isOnline() {
        return player.isOnline();
    }

    public boolean isBanned() {
        return player.isBanned();
    }

    public @NotNull BanEntry banPlayer(@Nullable String reason) {
        return player.banPlayer(reason);
    }

    public @NotNull BanEntry banPlayer(@Nullable String reason, @Nullable String source) {
        return player.banPlayer(reason, source);
    }

    public @NotNull BanEntry banPlayer(@Nullable String reason, @Nullable Date expires) {
        return player.banPlayer(reason, expires);
    }

    public @NotNull BanEntry banPlayer(@Nullable String reason, @Nullable Date expires, @Nullable String source) {
        return player.banPlayer(reason, expires, source);
    }

    public @NotNull BanEntry banPlayer(@Nullable String reason, @Nullable Date expires, @Nullable String source, boolean kickIfOnline) {
        return player.banPlayer(reason, expires, source, kickIfOnline);
    }

    public boolean isWhitelisted() {
        return player.isWhitelisted();
    }

    public void setWhitelisted(boolean value) {
        player.setWhitelisted(value);
    }

    @Nullable
    public Player getPlayer() {
        return player.getPlayer();
    }

    public long getFirstPlayed() {
        return player.getFirstPlayed();
    }

    @Deprecated
    public long getLastPlayed() {
        return player.getLastPlayed();
    }

    public boolean hasPlayedBefore() {
        return player.hasPlayedBefore();
    }

    public long getLastLogin() {
        return player.getLastLogin();
    }

    public long getLastSeen() {
        return player.getLastSeen();
    }

    public void incrementStatistic(@NotNull Statistic statistic) throws IllegalArgumentException {
        player.incrementStatistic(statistic);
    }

    public void decrementStatistic(@NotNull Statistic statistic) throws IllegalArgumentException {
        player.decrementStatistic(statistic);
    }

    public void incrementStatistic(@NotNull Statistic statistic, int amount) throws IllegalArgumentException {
        player.incrementStatistic(statistic, amount);
    }

    public void decrementStatistic(@NotNull Statistic statistic, int amount) throws IllegalArgumentException {
        player.decrementStatistic(statistic, amount);
    }

    public void setStatistic(@NotNull Statistic statistic, int newValue) throws IllegalArgumentException {
        player.setStatistic(statistic, newValue);
    }

    public int getStatistic(@NotNull Statistic statistic) throws IllegalArgumentException {
        return player.getStatistic(statistic);
    }

    public void incrementStatistic(@NotNull Statistic statistic, @NotNull Material material) throws IllegalArgumentException {
        player.incrementStatistic(statistic, material);
    }

    public void decrementStatistic(@NotNull Statistic statistic, @NotNull Material material) throws IllegalArgumentException {
        player.decrementStatistic(statistic, material);
    }

    public int getStatistic(@NotNull Statistic statistic, @NotNull Material material) throws IllegalArgumentException {
        return player.getStatistic(statistic, material);
    }

    public void incrementStatistic(@NotNull Statistic statistic, @NotNull Material material, int amount) throws IllegalArgumentException {
        player.incrementStatistic(statistic, material, amount);
    }

    public void decrementStatistic(@NotNull Statistic statistic, @NotNull Material material, int amount) throws IllegalArgumentException {
        player.decrementStatistic(statistic, material, amount);
    }

    public void setStatistic(@NotNull Statistic statistic, @NotNull Material material, int newValue) throws IllegalArgumentException {
        player.setStatistic(statistic, material, newValue);
    }

    public void incrementStatistic(@NotNull Statistic statistic, @NotNull EntityType entityType) throws IllegalArgumentException {
        player.incrementStatistic(statistic, entityType);
    }

    public void decrementStatistic(@NotNull Statistic statistic, @NotNull EntityType entityType) throws IllegalArgumentException {
        player.decrementStatistic(statistic, entityType);
    }

    public int getStatistic(@NotNull Statistic statistic, @NotNull EntityType entityType) throws IllegalArgumentException {
        return player.getStatistic(statistic, entityType);
    }

    public void incrementStatistic(@NotNull Statistic statistic, @NotNull EntityType entityType, int amount) throws IllegalArgumentException {
        player.incrementStatistic(statistic, entityType, amount);
    }

    public void decrementStatistic(@NotNull Statistic statistic, @NotNull EntityType entityType, int amount) {
        player.decrementStatistic(statistic, entityType, amount);
    }

    public void setStatistic(@NotNull Statistic statistic, @NotNull EntityType entityType, int newValue) {
        player.setStatistic(statistic, entityType, newValue);
    }

    public @NotNull Map<String, Object> serialize() {
        return player.serialize();
    }

    public void sendPluginMessage(@NotNull Plugin source, @NotNull String channel, @NotNull byte[] message) {
        player.sendPluginMessage(source, channel, message);
    }

    public @NotNull Set<String> getListeningPluginChannels() {
        return player.getListeningPluginChannels();
    }

    public int getProtocolVersion() {
        return player.getProtocolVersion();
    }

    public @Nullable InetSocketAddress getVirtualHost() {
        return player.getVirtualHost();
    }
}
