package com.mtjanney.deatheffects.listeners;

import com.mtjanney.deatheffects.config.Configurations;
import com.mtjanney.deatheffects.config.Language;
import com.mtjanney.deatheffects.config.PlayerData;
import com.mtjanney.deatheffects.handlers.InventoryHandler;
import com.mtjanney.deatheffects.util.InventoryItems;
import com.mtjanney.deatheffects.util.MessageUtil;
import com.mtjanney.deatheffects.util.Permissions;
import com.mtjanney.deatheffects.util.PlayerWrapper;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.InventoryView;
import sun.security.krb5.Config;

public class InventoryListener implements Listener
{
    @EventHandler
    public void onInventoryClick(InventoryClickEvent event)
    {
        Player player = (Player) event.getWhoClicked();
        InventoryView view = event.getView();

        if (view.getTitle().equals(InventoryHandler.MAIN_MENU))
        {
            event.setCancelled(true);

            if (event.getRawSlot() == 11) player.openInventory(InventoryHandler.classicParticles(player, 1));
            else if (event.getRawSlot() == 48)
            {
                PlayerWrapper wrapper;
                if (PlayerData.exists(player.getUniqueId())) wrapper = PlayerData.loadWrapper(player.getUniqueId());
                else wrapper = new PlayerWrapper();

                wrapper.setDeathEffect("NONE");

                PlayerData.create(player.getUniqueId(), wrapper);

                player.openInventory(InventoryHandler.mainMenu(1));

                player.playSound(player.getLocation(), Configurations.SOUNDS_REMOVE, 2F, 1F);

                MessageUtil.message(player, Language.EFFECT_REMOVE_SELF, true);
            }
        }
        else if (view.getTitle().equalsIgnoreCase(InventoryHandler.CLASSIC_PARTICLES_1))
        {
            event.setCancelled(true);

            if (event.getRawSlot() == 10)
            {
                if (!player.hasPermission(Permissions.FIREWORK) && !player.hasPermission(Permissions.ALL_PARTICLES))
                {
                    MessageUtil.message(player, Language.GENERAL_NO_PERMISSION, true);

                    return;
                }

                PlayerWrapper wrapper;
                if (PlayerData.exists(player.getUniqueId())) wrapper = PlayerData.loadWrapper(player.getUniqueId());
                else wrapper = new PlayerWrapper();

                wrapper.setDeathEffect("FIREWORK");

                PlayerData.create(player.getUniqueId(), wrapper);

                player.openInventory(InventoryHandler.classicParticles(player, 1));

                player.playSound(player.getLocation(), Configurations.SOUNDS_ADD, 2F, 1F);

                MessageUtil.message(player, Language.EFFECT_EQUIP_SELF.replace("%Effect%", "Firework"), true);
            }
            else if (event.getRawSlot() == 11)
            {
                if (!player.hasPermission(Permissions.BARRIER) && !player.hasPermission(Permissions.ALL_PARTICLES))
                {
                    MessageUtil.message(player, Language.GENERAL_NO_PERMISSION, true);

                    return;
                }

                PlayerWrapper wrapper;
                if (PlayerData.exists(player.getUniqueId())) wrapper = PlayerData.loadWrapper(player.getUniqueId());
                else wrapper = new PlayerWrapper();

                wrapper.setDeathEffect("BARRIER");

                PlayerData.create(player.getUniqueId(), wrapper);

                player.openInventory(InventoryHandler.classicParticles(player, 1));

                player.playSound(player.getLocation(), Configurations.SOUNDS_ADD, 2F, 1F);

                MessageUtil.message(player, Language.EFFECT_EQUIP_SELF.replace("%Effect%", "Barrier"), true);
            }
            else if (event.getRawSlot() == 12)
            {
                if (!player.hasPermission(Permissions.CLOUD) && !player.hasPermission(Permissions.ALL_PARTICLES))
                {
                    MessageUtil.message(player, Language.GENERAL_NO_PERMISSION, true);

                    return;
                }

                PlayerWrapper wrapper;
                if (PlayerData.exists(player.getUniqueId())) wrapper = PlayerData.loadWrapper(player.getUniqueId());
                else wrapper = new PlayerWrapper();

                wrapper.setDeathEffect("CLOUD");

                PlayerData.create(player.getUniqueId(), wrapper);

                player.openInventory(InventoryHandler.classicParticles(player, 1));

                player.playSound(player.getLocation(), Configurations.SOUNDS_ADD, 2F, 1F);

                MessageUtil.message(player, Language.EFFECT_EQUIP_SELF.replace("%Effect%", "Cloud"), true);
            }
            else if (event.getRawSlot() == 13)
            {
                if (!player.hasPermission(Permissions.CRITICAL) && !player.hasPermission(Permissions.ALL_PARTICLES))
                {
                    MessageUtil.message(player, Language.GENERAL_NO_PERMISSION, true);

                    return;
                }

                PlayerWrapper wrapper;
                if (PlayerData.exists(player.getUniqueId())) wrapper = PlayerData.loadWrapper(player.getUniqueId());
                else wrapper = new PlayerWrapper();

                wrapper.setDeathEffect("CRITICAL");

                PlayerData.create(player.getUniqueId(), wrapper);

                player.openInventory(InventoryHandler.classicParticles(player, 1));

                player.playSound(player.getLocation(), Configurations.SOUNDS_ADD, 2F, 1F);

                MessageUtil.message(player, Language.EFFECT_EQUIP_SELF.replace("%Effect%", "Critical"), true);
            }
            else if (event.getRawSlot() == 14)
            {
                if (!player.hasPermission(Permissions.CRITICAL_MAGIC) && !player.hasPermission(Permissions.ALL_PARTICLES))
                {
                    MessageUtil.message(player, Language.GENERAL_NO_PERMISSION, true);

                    return;
                }

                PlayerWrapper wrapper;
                if (PlayerData.exists(player.getUniqueId())) wrapper = PlayerData.loadWrapper(player.getUniqueId());
                else wrapper = new PlayerWrapper();

                wrapper.setDeathEffect("MAGIC");

                PlayerData.create(player.getUniqueId(), wrapper);

                player.openInventory(InventoryHandler.classicParticles(player, 1));

                player.playSound(player.getLocation(), Configurations.SOUNDS_ADD, 2F, 1F);

                MessageUtil.message(player, Language.EFFECT_EQUIP_SELF.replace("%Effect%", "Magic"), true);
            }
            else if (event.getRawSlot() == 15)
            {
                if (!player.hasPermission(Permissions.LAVA) && !player.hasPermission(Permissions.ALL_PARTICLES))
                {
                    MessageUtil.message(player, Language.GENERAL_NO_PERMISSION, true);

                    return;
                }

                PlayerWrapper wrapper;
                if (PlayerData.exists(player.getUniqueId())) wrapper = PlayerData.loadWrapper(player.getUniqueId());
                else wrapper = new PlayerWrapper();

                wrapper.setDeathEffect("LAVA");

                PlayerData.create(player.getUniqueId(), wrapper);

                player.openInventory(InventoryHandler.classicParticles(player, 1));

                player.playSound(player.getLocation(), Configurations.SOUNDS_ADD, 2F, 1F);

                MessageUtil.message(player, Language.EFFECT_EQUIP_SELF.replace("%Effect%", "Lava"), true);
            }
            else if (event.getRawSlot() == 16)
            {
                if (!player.hasPermission(Permissions.WATER) && !player.hasPermission(Permissions.ALL_PARTICLES))
                {
                    MessageUtil.message(player, Language.GENERAL_NO_PERMISSION, true);

                    return;
                }

                PlayerWrapper wrapper;
                if (PlayerData.exists(player.getUniqueId())) wrapper = PlayerData.loadWrapper(player.getUniqueId());
                else wrapper = new PlayerWrapper();

                wrapper.setDeathEffect("WATER");

                PlayerData.create(player.getUniqueId(), wrapper);

                player.openInventory(InventoryHandler.classicParticles(player, 1));

                player.playSound(player.getLocation(), Configurations.SOUNDS_ADD, 2F, 1F);

                MessageUtil.message(player, Language.EFFECT_EQUIP_SELF.replace("%Effect%", "Water"), true);
            }
            else if (event.getRawSlot() == 19)
            {
                if (!player.hasPermission(Permissions.ENCHANTMENT) && !player.hasPermission(Permissions.ALL_PARTICLES))
                {
                    MessageUtil.message(player, Language.GENERAL_NO_PERMISSION, true);

                    return;
                }

                PlayerWrapper wrapper;
                if (PlayerData.exists(player.getUniqueId())) wrapper = PlayerData.loadWrapper(player.getUniqueId());
                else wrapper = new PlayerWrapper();

                wrapper.setDeathEffect("ENCHANTMENT");

                PlayerData.create(player.getUniqueId(), wrapper);

                player.openInventory(InventoryHandler.classicParticles(player, 1));

                player.playSound(player.getLocation(), Configurations.SOUNDS_ADD, 2F, 1F);

                MessageUtil.message(player, Language.EFFECT_EQUIP_SELF.replace("%Effect%", "Enchantment"), true);
            }
            else if (event.getRawSlot() == 20)
            {
                if (!player.hasPermission(Permissions.EXPLOSION_SMALL) && !player.hasPermission(Permissions.ALL_PARTICLES))
                {
                    MessageUtil.message(player, Language.GENERAL_NO_PERMISSION, true);

                    return;
                }

                PlayerWrapper wrapper;
                if (PlayerData.exists(player.getUniqueId())) wrapper = PlayerData.loadWrapper(player.getUniqueId());
                else wrapper = new PlayerWrapper();

                wrapper.setDeathEffect("EXPLOSION-SMALL");

                PlayerData.create(player.getUniqueId(), wrapper);

                player.openInventory(InventoryHandler.classicParticles(player, 1));

                player.playSound(player.getLocation(), Configurations.SOUNDS_ADD, 2F, 1F);

                MessageUtil.message(player, Language.EFFECT_EQUIP_SELF.replace("%Effect%", "Small Explosion"), true);
            }
            else if (event.getRawSlot() == 21)
            {
                if (!player.hasPermission(Permissions.EXPLOSION_MEDIUM) && !player.hasPermission(Permissions.ALL_PARTICLES))
                {
                    MessageUtil.message(player, Language.GENERAL_NO_PERMISSION, true);

                    return;
                }

                PlayerWrapper wrapper;
                if (PlayerData.exists(player.getUniqueId())) wrapper = PlayerData.loadWrapper(player.getUniqueId());
                else wrapper = new PlayerWrapper();

                wrapper.setDeathEffect("EXPLOSION-MEDIUM");

                PlayerData.create(player.getUniqueId(), wrapper);

                player.openInventory(InventoryHandler.classicParticles(player, 1));

                player.playSound(player.getLocation(), Configurations.SOUNDS_ADD, 2F, 1F);

                MessageUtil.message(player, Language.EFFECT_EQUIP_SELF.replace("%Effect%", "Medium Explosion"), true);
            }
            else if (event.getRawSlot() == 22)
            {
                if (!player.hasPermission(Permissions.EXPLOSION_LARGE) && !player.hasPermission(Permissions.ALL_PARTICLES))
                {
                    MessageUtil.message(player, Language.GENERAL_NO_PERMISSION, true);

                    return;
                }

                PlayerWrapper wrapper;
                if (PlayerData.exists(player.getUniqueId())) wrapper = PlayerData.loadWrapper(player.getUniqueId());
                else wrapper = new PlayerWrapper();

                wrapper.setDeathEffect("EXPLOSION-LARGE");

                PlayerData.create(player.getUniqueId(), wrapper);

                player.openInventory(InventoryHandler.classicParticles(player, 1));

                player.playSound(player.getLocation(), Configurations.SOUNDS_ADD, 2F, 1F);

                MessageUtil.message(player, Language.EFFECT_EQUIP_SELF.replace("%Effect%", "Large Explosion"), true);
            }
            else if (event.getRawSlot() == 23)
            {
                if (!player.hasPermission(Permissions.SPARK) && !player.hasPermission(Permissions.ALL_PARTICLES))
                {
                    MessageUtil.message(player, Language.GENERAL_NO_PERMISSION, true);

                    return;
                }

                PlayerWrapper wrapper;
                if (PlayerData.exists(player.getUniqueId())) wrapper = PlayerData.loadWrapper(player.getUniqueId());
                else wrapper = new PlayerWrapper();

                wrapper.setDeathEffect("SPARK");

                PlayerData.create(player.getUniqueId(), wrapper);

                player.openInventory(InventoryHandler.classicParticles(player, 1));

                player.playSound(player.getLocation(), Configurations.SOUNDS_ADD, 2F, 1F);

                MessageUtil.message(player, Language.EFFECT_EQUIP_SELF.replace("%Effect%", "Spark"), true);
            }
            else if (event.getRawSlot() == 24)
            {
                if (!player.hasPermission(Permissions.FLAME) && !player.hasPermission(Permissions.ALL_PARTICLES))
                {
                    MessageUtil.message(player, Language.GENERAL_NO_PERMISSION, true);

                    return;
                }

                PlayerWrapper wrapper;
                if (PlayerData.exists(player.getUniqueId())) wrapper = PlayerData.loadWrapper(player.getUniqueId());
                else wrapper = new PlayerWrapper();

                wrapper.setDeathEffect("FLAME");

                PlayerData.create(player.getUniqueId(), wrapper);

                player.openInventory(InventoryHandler.classicParticles(player, 1));

                player.playSound(player.getLocation(), Configurations.SOUNDS_ADD, 2F, 1F);

                MessageUtil.message(player, Language.EFFECT_EQUIP_SELF.replace("%Effect%", "Flame"), true);
            }
            else if (event.getRawSlot() == 25)
            {
                if (!player.hasPermission(Permissions.HEART) && !player.hasPermission(Permissions.ALL_PARTICLES))
                {
                    MessageUtil.message(player, Language.GENERAL_NO_PERMISSION, true);

                    return;
                }

                PlayerWrapper wrapper;
                if (PlayerData.exists(player.getUniqueId())) wrapper = PlayerData.loadWrapper(player.getUniqueId());
                else wrapper = new PlayerWrapper();

                wrapper.setDeathEffect("HEART");

                PlayerData.create(player.getUniqueId(), wrapper);

                player.openInventory(InventoryHandler.classicParticles(player, 1));

                player.playSound(player.getLocation(), Configurations.SOUNDS_ADD, 2F, 1F);

                MessageUtil.message(player, Language.EFFECT_EQUIP_SELF.replace("%Effect%", "Heart"), true);
            }
            else if (event.getRawSlot() == 28)
            {
                if (!player.hasPermission(Permissions.LAVA_POP) && !player.hasPermission(Permissions.ALL_PARTICLES))
                {
                    MessageUtil.message(player, Language.GENERAL_NO_PERMISSION, true);

                    return;
                }

                PlayerWrapper wrapper;
                if (PlayerData.exists(player.getUniqueId())) wrapper = PlayerData.loadWrapper(player.getUniqueId());
                else wrapper = new PlayerWrapper();

                wrapper.setDeathEffect("LAVA-POP");

                PlayerData.create(player.getUniqueId(), wrapper);

                player.openInventory(InventoryHandler.classicParticles(player, 1));

                player.playSound(player.getLocation(), Configurations.SOUNDS_ADD, 2F, 1F);

                MessageUtil.message(player, Language.EFFECT_EQUIP_SELF.replace("%Effect%", "Lava Pop"), true);
            }
            else if (event.getRawSlot() == 29)
            {
                if (!player.hasPermission(Permissions.NOTE) && !player.hasPermission(Permissions.ALL_PARTICLES))
                {
                    MessageUtil.message(player, Language.GENERAL_NO_PERMISSION, true);

                    return;
                }

                PlayerWrapper wrapper;
                if (PlayerData.exists(player.getUniqueId())) wrapper = PlayerData.loadWrapper(player.getUniqueId());
                else wrapper = new PlayerWrapper();

                wrapper.setDeathEffect("NOTE");

                PlayerData.create(player.getUniqueId(), wrapper);

                player.openInventory(InventoryHandler.classicParticles(player, 1));

                player.playSound(player.getLocation(), Configurations.SOUNDS_ADD, 2F, 1F);

                MessageUtil.message(player, Language.EFFECT_EQUIP_SELF.replace("%Effect%", "Note"), true);
            }
            else if (event.getRawSlot() == 30)
            {
                if (!player.hasPermission(Permissions.PORTAL) && !player.hasPermission(Permissions.ALL_PARTICLES))
                {
                    MessageUtil.message(player, Language.GENERAL_NO_PERMISSION, true);

                    return;
                }

                PlayerWrapper wrapper;
                if (PlayerData.exists(player.getUniqueId())) wrapper = PlayerData.loadWrapper(player.getUniqueId());
                else wrapper = new PlayerWrapper();

                wrapper.setDeathEffect("PORTAL");

                PlayerData.create(player.getUniqueId(), wrapper);

                player.openInventory(InventoryHandler.classicParticles(player, 1));

                player.playSound(player.getLocation(), Configurations.SOUNDS_ADD, 2F, 1F);

                MessageUtil.message(player, Language.EFFECT_EQUIP_SELF.replace("%Effect%", "Portal"), true);
            }
            else if (event.getRawSlot() == 31)
            {
                if (!player.hasPermission(Permissions.REDSTONE) && !player.hasPermission(Permissions.ALL_PARTICLES))
                {
                    MessageUtil.message(player, Language.GENERAL_NO_PERMISSION, true);

                    return;
                }

                PlayerWrapper wrapper;
                if (PlayerData.exists(player.getUniqueId())) wrapper = PlayerData.loadWrapper(player.getUniqueId());
                else wrapper = new PlayerWrapper();

                wrapper.setDeathEffect("REDSTONE");

                PlayerData.create(player.getUniqueId(), wrapper);

                player.openInventory(InventoryHandler.classicParticles(player, 1));

                player.playSound(player.getLocation(), Configurations.SOUNDS_ADD, 2F, 1F);

                MessageUtil.message(player, Language.EFFECT_EQUIP_SELF.replace("%Effect%", "Redstone"), true);
            }
            else if (event.getRawSlot() == 32)
            {
                if (!player.hasPermission(Permissions.SLIME) && !player.hasPermission(Permissions.ALL_PARTICLES))
                {
                    MessageUtil.message(player, Language.GENERAL_NO_PERMISSION, true);

                    return;
                }

                PlayerWrapper wrapper;
                if (PlayerData.exists(player.getUniqueId())) wrapper = PlayerData.loadWrapper(player.getUniqueId());
                else wrapper = new PlayerWrapper();

                wrapper.setDeathEffect("SLIME");

                PlayerData.create(player.getUniqueId(), wrapper);

                player.openInventory(InventoryHandler.classicParticles(player, 1));

                player.playSound(player.getLocation(), Configurations.SOUNDS_ADD, 2F, 1F);

                MessageUtil.message(player, Language.EFFECT_EQUIP_SELF.replace("%Effect%", "Slime"), true);
            }
            else if (event.getRawSlot() == 33)
            {
                if (!player.hasPermission(Permissions.SMOKE_SMALL) && !player.hasPermission(Permissions.ALL_PARTICLES))
                {
                    MessageUtil.message(player, Language.GENERAL_NO_PERMISSION, true);

                    return;
                }

                PlayerWrapper wrapper;
                if (PlayerData.exists(player.getUniqueId())) wrapper = PlayerData.loadWrapper(player.getUniqueId());
                else wrapper = new PlayerWrapper();

                wrapper.setDeathEffect("SMOKE-SMALL");

                PlayerData.create(player.getUniqueId(), wrapper);

                player.openInventory(InventoryHandler.classicParticles(player, 1));

                player.playSound(player.getLocation(), Configurations.SOUNDS_ADD, 2F, 1F);

                MessageUtil.message(player, Language.EFFECT_EQUIP_SELF.replace("%Effect%", "Small Smoke"), true);
            }
            else if (event.getRawSlot() == 34)
            {
                if (!player.hasPermission(Permissions.SMOKE_LARGE) && !player.hasPermission(Permissions.ALL_PARTICLES))
                {
                    MessageUtil.message(player, Language.GENERAL_NO_PERMISSION, true);

                    return;
                }

                PlayerWrapper wrapper;
                if (PlayerData.exists(player.getUniqueId())) wrapper = PlayerData.loadWrapper(player.getUniqueId());
                else wrapper = new PlayerWrapper();

                wrapper.setDeathEffect("SMOKE-LARGE");

                PlayerData.create(player.getUniqueId(), wrapper);

                player.openInventory(InventoryHandler.classicParticles(player, 1));

                player.playSound(player.getLocation(), Configurations.SOUNDS_ADD, 2F, 1F);

                MessageUtil.message(player, Language.EFFECT_EQUIP_SELF.replace("%Effect%", "Large Smoke"), true);
            }

            // Utilities
            if (event.getRawSlot() == 45) player.openInventory(InventoryHandler.mainMenu(1));
            else if (event.getRawSlot() == 48)
            {
                PlayerWrapper wrapper;
                if (PlayerData.exists(player.getUniqueId())) wrapper = PlayerData.loadWrapper(player.getUniqueId());
                else wrapper = new PlayerWrapper();

                wrapper.setDeathEffect("NONE");

                PlayerData.create(player.getUniqueId(), wrapper);

                player.openInventory(InventoryHandler.classicParticles(player, 1));

                player.playSound(player.getLocation(), Configurations.SOUNDS_REMOVE, 2F, 1F);

                MessageUtil.message(player, Language.EFFECT_REMOVE_SELF, true);
            }
            else if (event.getRawSlot() == 53) player.openInventory(InventoryHandler.classicParticles(player, 2));
        }
        else if (view.getTitle().equalsIgnoreCase(InventoryHandler.CLASSIC_PARTICLES_2))
        {
            event.setCancelled(true);

            if (event.getRawSlot() == 10)
            {
                if (!player.hasPermission(Permissions.SPELL) && !player.hasPermission(Permissions.ALL_PARTICLES))
                {
                    MessageUtil.message(player, Language.GENERAL_NO_PERMISSION, true);

                    return;
                }

                PlayerWrapper wrapper;
                if (PlayerData.exists(player.getUniqueId())) wrapper = PlayerData.loadWrapper(player.getUniqueId());
                else wrapper = new PlayerWrapper();

                wrapper.setDeathEffect("SPELL");

                PlayerData.create(player.getUniqueId(), wrapper);

                player.openInventory(InventoryHandler.classicParticles(player, 2));

                player.playSound(player.getLocation(), Configurations.SOUNDS_ADD, 2F, 1F);

                MessageUtil.message(player, Language.EFFECT_EQUIP_SELF.replace("%Effect%", "Spell"), true);
            }
            else if (event.getRawSlot() == 11)
            {
                if (!player.hasPermission(Permissions.SNOW) && !player.hasPermission(Permissions.ALL_PARTICLES))
                {
                    MessageUtil.message(player, Language.GENERAL_NO_PERMISSION, true);

                    return;
                }

                PlayerWrapper wrapper;
                if (PlayerData.exists(player.getUniqueId())) wrapper = PlayerData.loadWrapper(player.getUniqueId());
                else wrapper = new PlayerWrapper();

                wrapper.setDeathEffect("SNOW");

                PlayerData.create(player.getUniqueId(), wrapper);

                player.openInventory(InventoryHandler.classicParticles(player, 2));

                player.playSound(player.getLocation(), Configurations.SOUNDS_ADD, 2F, 1F);

                MessageUtil.message(player, Language.EFFECT_EQUIP_SELF.replace("%Effect%", "Snow"), true);
            }
            else if (event.getRawSlot() == 12)
            {
                if (!player.hasPermission(Permissions.HAPPY_VILLAGER) && !player.hasPermission(Permissions.ALL_PARTICLES))
                {
                    MessageUtil.message(player, Language.GENERAL_NO_PERMISSION, true);

                    return;
                }

                PlayerWrapper wrapper;
                if (PlayerData.exists(player.getUniqueId())) wrapper = PlayerData.loadWrapper(player.getUniqueId());
                else wrapper = new PlayerWrapper();

                wrapper.setDeathEffect("HAPPY-VILLAGER");

                PlayerData.create(player.getUniqueId(), wrapper);

                player.openInventory(InventoryHandler.classicParticles(player, 2));

                player.playSound(player.getLocation(), Configurations.SOUNDS_ADD, 2F, 1F);

                MessageUtil.message(player, Language.EFFECT_EQUIP_SELF.replace("%Effect%", "Happy Villager"), true);
            }
            else if (event.getRawSlot() == 13)
            {
                if (!player.hasPermission(Permissions.ANGRY_VILLAGER) && !player.hasPermission(Permissions.ALL_PARTICLES))
                {
                    MessageUtil.message(player, Language.GENERAL_NO_PERMISSION, true);

                    return;
                }

                PlayerWrapper wrapper;
                if (PlayerData.exists(player.getUniqueId())) wrapper = PlayerData.loadWrapper(player.getUniqueId());
                else wrapper = new PlayerWrapper();

                wrapper.setDeathEffect("ANGRY-VILLAGER");

                PlayerData.create(player.getUniqueId(), wrapper);

                player.openInventory(InventoryHandler.classicParticles(player, 2));

                player.playSound(player.getLocation(), Configurations.SOUNDS_ADD, 2F, 1F);

                MessageUtil.message(player, Language.EFFECT_EQUIP_SELF.replace("%Effect%", "Angry Villager"), true);
            }
            else if (event.getRawSlot() == 14)
            {
                if (!player.hasPermission(Permissions.SPLASH) && !player.hasPermission(Permissions.ALL_PARTICLES))
                {
                    MessageUtil.message(player, Language.GENERAL_NO_PERMISSION, true);

                    return;
                }

                PlayerWrapper wrapper;
                if (PlayerData.exists(player.getUniqueId())) wrapper = PlayerData.loadWrapper(player.getUniqueId());
                else wrapper = new PlayerWrapper();

                wrapper.setDeathEffect("SPLASH");

                PlayerData.create(player.getUniqueId(), wrapper);

                player.openInventory(InventoryHandler.classicParticles(player, 2));

                player.playSound(player.getLocation(), Configurations.SOUNDS_ADD, 2F, 1F);

                MessageUtil.message(player, Language.EFFECT_EQUIP_SELF.replace("%Effect%", "Splash"), true);
            }

            if (event.getRawSlot() == 45) player.openInventory(InventoryHandler.classicParticles(player, 1));
            else if (event.getRawSlot() == 48)
            {
                PlayerWrapper wrapper;
                if (PlayerData.exists(player.getUniqueId())) wrapper = PlayerData.loadWrapper(player.getUniqueId());
                else wrapper = new PlayerWrapper();

                wrapper.setDeathEffect("NONE");

                PlayerData.create(player.getUniqueId(), wrapper);

                player.openInventory(InventoryHandler.classicParticles(player, 2));

                player.playSound(player.getLocation(), Configurations.SOUNDS_REMOVE, 2F, 1F);
                
                MessageUtil.message(player, Language.EFFECT_REMOVE_SELF, true);
            }
        }
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event)
    {
        Player player = event.getPlayer();

        if (!Configurations.JOIN_ITEM_ENABLED) return;

        if (player.getInventory().contains(InventoryItems.chest())) return;

        player.getInventory().setItem(Configurations.JOIN_ITEM_SLOT, InventoryItems.chest());
    }

    @EventHandler
    public void onRightClick(PlayerInteractEvent event)
    {
        Player player = event.getPlayer();

        if (player.getInventory().getItemInHand().getType().equals(Material.AIR)) return;

        if (player.getInventory().getItemInHand().getItemMeta().getDisplayName().equals(MessageUtil.format(Configurations.JOIN_ITEM_NAME)))
        {
            player.playSound(player.getLocation(), Sound.CHEST_OPEN, 2F, 1F);
            player.openInventory(InventoryHandler.mainMenu(1));
        }
    }
}
