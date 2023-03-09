package org.redkiller.event;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.redkiller.entity.livingentity.player.NewPlayer;
import org.redkiller.item.ban.BanItem;
import org.redkiller.item.ban.BanItemAct;
import org.redkiller.system.gamerule.CustomGameRule;
import org.redkiller.system.world.AreaAct;
import org.redkiller.system.world.InterfaceArea;
import org.redkiller.system.world.WorldDataMap;

public abstract class AbstractEventListener implements Listener {

    protected <T> T getCustomGameRuleValue(CustomGameRule<T> customGameRule, World world) {
        WorldDataMap worldDataMap = WorldDataMap.getWorldDataMap(world);
        return worldDataMap.getCustomGameRuleValue(customGameRule);
    }

    protected <T> T getCustomGameRuleValue(CustomGameRule<T> customGameRule, Entity entity) {
        if (entity instanceof Player player) {
            NewPlayer newPlayer = NewPlayer.getNewPlayer(player);

            if (newPlayer.isRedKillerMode() && newPlayer.isIgnoreEvent()) {
                return customGameRule.getDefaultValue();
            }
        }
        return getCustomGameRuleValue(customGameRule, entity.getWorld());
    }

    protected boolean getBooleanCustomGameRuleValue(CustomGameRule<Boolean> customGameRule, Entity entity) {
        if (entity instanceof Player player) {
            NewPlayer newPlayer = NewPlayer.getNewPlayer(player);

            if (newPlayer.isRedKillerMode() && newPlayer.isIgnoreEvent()) {
                return customGameRule.getDefaultValue();
            }
        }

        return getCustomGameRuleValue(customGameRule, entity);
    }

    protected boolean getBooleanCustomGameRuleValue(CustomGameRule<Boolean> customGameRule, World world) {
        return getCustomGameRuleValue(customGameRule, world);
    }

    protected boolean banItemAllow(ItemStack itemStack, BanItemAct act) {
        if (itemStack == null) {
            return true;
        }

        return this.banItemAllow(itemStack.getType(), act);
    }

    protected boolean banItemAllow(Material material, BanItemAct act) {
        BanItem banItem = BanItem.getInstance();
        return !banItem.getAllow(material, act);
    }

    protected boolean playerAreaActAllow(NewPlayer newPlayer, AreaAct act) {
        return this.playerAreaActAllow(newPlayer, act, newPlayer.getLocation());
    }

    protected boolean playerAreaActAllow(NewPlayer newPlayer, AreaAct act, Location location) {
        WorldDataMap worldDataMap = WorldDataMap.getWorldDataMap(location.getWorld());
        for (InterfaceArea area : worldDataMap.containArea(location)) {
            if (!area.playerAct(newPlayer, act))
                return true;
        }

        return false;
    }
}
