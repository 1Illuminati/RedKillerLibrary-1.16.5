package org.redkiller.event.listeners;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.entity.EntityBreedEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.redkiller.entity.livingentity.player.NewPlayer;
import org.redkiller.item.ban.BanItemAct;
import org.redkiller.item.event.ItemEventAnnotation;
import org.redkiller.item.event.ItemEventRegister;
import org.redkiller.system.world.AreaAct;
import org.spigotmc.event.entity.EntityMountEvent;
import org.redkiller.event.AbstractEventListener;
import org.redkiller.system.gamerule.CustomGameRule;

public class EntityEvent extends AbstractEventListener {
    @EventHandler(priority = EventPriority.HIGHEST)
    public void entityBreedEvent(EntityBreedEvent event) {
        if (super.getBooleanCustomGameRuleValue(CustomGameRule.SEX, event.getEntity())) {
            event.setCancelled(true);
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void entityMountEvent(EntityMountEvent event) {
        if (super.getBooleanCustomGameRuleValue(CustomGameRule.RIDING, event.getEntity())) {
            event.setCancelled(true);
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void entityPickUpItemEvent(EntityPickupItemEvent event) {
        Entity entity = event.getEntity();
        if (entity instanceof Player player) {
            if (super.getBooleanCustomGameRuleValue(CustomGameRule.PICK_UP, entity) ||
                    banItemAllow(event.getItem().getItemStack(), BanItemAct.PICKUP) ||
                    super.playerAreaActAllow(NewPlayer.getNewPlayer(player), AreaAct.PICKUP, event.getItem().getLocation()))
                event.setCancelled(true);
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void entityDamagedByEntityEvent(EntityDamageByEntityEvent event) {
        Entity atk = event.getDamager();
        Entity def = event.getEntity();

        if (atk instanceof Player atkPlayer && def instanceof Player &&
                (super.getBooleanCustomGameRuleValue(CustomGameRule.PVP, atk) || super.playerAreaActAllow(NewPlayer.getNewPlayer(atkPlayer), AreaAct.PVP))) {
            event.setCancelled(true);
            return;
        }

        if (atk instanceof Player player) {
            ItemEventRegister.runItemEvent((player).getInventory().getItemInMainHand(), ItemEventAnnotation.Act.HIT, event);
        }
    }
}
