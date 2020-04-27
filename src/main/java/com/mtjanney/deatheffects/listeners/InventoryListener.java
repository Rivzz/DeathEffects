package com.mtjanney.deatheffects.listeners;

import com.mtjanney.deatheffects.config.Configurations;
import com.mtjanney.deatheffects.config.PlayerData;
import com.mtjanney.deatheffects.handlers.InventoryHandler;
import com.mtjanney.deatheffects.util.MessageUtil;
import com.mtjanney.deatheffects.util.Permissions;
import com.mtjanney.deatheffects.util.PlayerWrapper;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.InventoryView;

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
            }
        }
        else if (view.getTitle().equalsIgnoreCase(InventoryHandler.CLASSIC_PARTICLES_1))
        {
            event.setCancelled(true);

            if (event.getRawSlot() == 10)
            {
                if (!player.hasPermission(Permissions.FIREWORK))
                {
                    MessageUtil.message(player, MessageUtil.NO_PERMISSION);

                    return;
                }

                PlayerWrapper wrapper;
                if (PlayerData.exists(player.getUniqueId())) wrapper = PlayerData.loadWrapper(player.getUniqueId());
                else wrapper = new PlayerWrapper();

                wrapper.setDeathEffect("FIREWORK");

                PlayerData.create(player.getUniqueId(), wrapper);

                player.openInventory(InventoryHandler.classicParticles(player, 1));

                player.playSound(player.getLocation(), Configurations.SOUNDS_ADD, 2F, 1F);
            }
            else if (event.getRawSlot() == 11)
            {
                if (!player.hasPermission(Permissions.BARRIER))
                {
                    MessageUtil.message(player, MessageUtil.NO_PERMISSION);

                    return;
                }

                PlayerWrapper wrapper;
                if (PlayerData.exists(player.getUniqueId())) wrapper = PlayerData.loadWrapper(player.getUniqueId());
                else wrapper = new PlayerWrapper();

                wrapper.setDeathEffect("BARRIER");

                PlayerData.create(player.getUniqueId(), wrapper);

                player.openInventory(InventoryHandler.classicParticles(player, 1));

                player.playSound(player.getLocation(), Configurations.SOUNDS_ADD, 2F, 1F);
            }
            else if (event.getRawSlot() == 12)
            {
                if (!player.hasPermission(Permissions.CLOUD))
                {
                    MessageUtil.message(player, MessageUtil.NO_PERMISSION);

                    return;
                }

                PlayerWrapper wrapper;
                if (PlayerData.exists(player.getUniqueId())) wrapper = PlayerData.loadWrapper(player.getUniqueId());
                else wrapper = new PlayerWrapper();

                wrapper.setDeathEffect("CLOUD");

                PlayerData.create(player.getUniqueId(), wrapper);

                player.openInventory(InventoryHandler.classicParticles(player, 1));

                player.playSound(player.getLocation(), Configurations.SOUNDS_ADD, 2F, 1F);
            }
            else if (event.getRawSlot() == 13)
            {
                if (!player.hasPermission(Permissions.CRITICAL))
                {
                    MessageUtil.message(player, MessageUtil.NO_PERMISSION);

                    return;
                }

                PlayerWrapper wrapper;
                if (PlayerData.exists(player.getUniqueId())) wrapper = PlayerData.loadWrapper(player.getUniqueId());
                else wrapper = new PlayerWrapper();

                wrapper.setDeathEffect("CRITICAL");

                PlayerData.create(player.getUniqueId(), wrapper);

                player.openInventory(InventoryHandler.classicParticles(player, 1));

                player.playSound(player.getLocation(), Configurations.SOUNDS_ADD, 2F, 1F);
            }
            else if (event.getRawSlot() == 14)
            {
                if (!player.hasPermission(Permissions.CRITICAL_MAGIC))
                {
                    MessageUtil.message(player, MessageUtil.NO_PERMISSION);

                    return;
                }

                PlayerWrapper wrapper;
                if (PlayerData.exists(player.getUniqueId())) wrapper = PlayerData.loadWrapper(player.getUniqueId());
                else wrapper = new PlayerWrapper();

                wrapper.setDeathEffect("MAGIC");

                PlayerData.create(player.getUniqueId(), wrapper);

                player.openInventory(InventoryHandler.classicParticles(player, 1));

                player.playSound(player.getLocation(), Configurations.SOUNDS_ADD, 2F, 1F);
            }
            else if (event.getRawSlot() == 15)
            {
                if (!player.hasPermission(Permissions.LAVA))
                {
                    MessageUtil.message(player, MessageUtil.NO_PERMISSION);

                    return;
                }

                PlayerWrapper wrapper;
                if (PlayerData.exists(player.getUniqueId())) wrapper = PlayerData.loadWrapper(player.getUniqueId());
                else wrapper = new PlayerWrapper();

                wrapper.setDeathEffect("LAVA");

                PlayerData.create(player.getUniqueId(), wrapper);

                player.openInventory(InventoryHandler.classicParticles(player, 1));

                player.playSound(player.getLocation(), Configurations.SOUNDS_ADD, 2F, 1F);
            }
            else if (event.getRawSlot() == 16)
            {
                if (!player.hasPermission(Permissions.WATER))
                {
                    MessageUtil.message(player, MessageUtil.NO_PERMISSION);

                    return;
                }

                PlayerWrapper wrapper;
                if (PlayerData.exists(player.getUniqueId())) wrapper = PlayerData.loadWrapper(player.getUniqueId());
                else wrapper = new PlayerWrapper();

                wrapper.setDeathEffect("WATER");

                PlayerData.create(player.getUniqueId(), wrapper);

                player.openInventory(InventoryHandler.classicParticles(player, 1));

                player.playSound(player.getLocation(), Configurations.SOUNDS_ADD, 2F, 1F);
            }
            else if (event.getRawSlot() == 19)
            {
                if (!player.hasPermission(Permissions.ENCHANTMENT))
                {
                    MessageUtil.message(player, MessageUtil.NO_PERMISSION);

                    return;
                }

                PlayerWrapper wrapper;
                if (PlayerData.exists(player.getUniqueId())) wrapper = PlayerData.loadWrapper(player.getUniqueId());
                else wrapper = new PlayerWrapper();

                wrapper.setDeathEffect("ENCHANTMENT");

                PlayerData.create(player.getUniqueId(), wrapper);

                player.openInventory(InventoryHandler.classicParticles(player, 1));

                player.playSound(player.getLocation(), Configurations.SOUNDS_ADD, 2F, 1F);
            }
            else if (event.getRawSlot() == 20)
            {
                if (!player.hasPermission(Permissions.EXPLOSION_SMALL))
                {
                    MessageUtil.message(player, MessageUtil.NO_PERMISSION);

                    return;
                }

                PlayerWrapper wrapper;
                if (PlayerData.exists(player.getUniqueId())) wrapper = PlayerData.loadWrapper(player.getUniqueId());
                else wrapper = new PlayerWrapper();

                wrapper.setDeathEffect("EXPLOSION-SMALL");

                PlayerData.create(player.getUniqueId(), wrapper);

                player.openInventory(InventoryHandler.classicParticles(player, 1));

                player.playSound(player.getLocation(), Configurations.SOUNDS_ADD, 2F, 1F);
            }
            else if (event.getRawSlot() == 21)
            {
                if (!player.hasPermission(Permissions.EXPLOSION_MEDIUM))
                {
                    MessageUtil.message(player, MessageUtil.NO_PERMISSION);

                    return;
                }

                PlayerWrapper wrapper;
                if (PlayerData.exists(player.getUniqueId())) wrapper = PlayerData.loadWrapper(player.getUniqueId());
                else wrapper = new PlayerWrapper();

                wrapper.setDeathEffect("EXPLOSION-MEDIUM");

                PlayerData.create(player.getUniqueId(), wrapper);

                player.openInventory(InventoryHandler.classicParticles(player, 1));

                player.playSound(player.getLocation(), Configurations.SOUNDS_ADD, 2F, 1F);
            }
            else if (event.getRawSlot() == 22)
            {
                if (!player.hasPermission(Permissions.EXPLOSION_LARGE))
                {
                    MessageUtil.message(player, MessageUtil.NO_PERMISSION);

                    return;
                }

                PlayerWrapper wrapper;
                if (PlayerData.exists(player.getUniqueId())) wrapper = PlayerData.loadWrapper(player.getUniqueId());
                else wrapper = new PlayerWrapper();

                wrapper.setDeathEffect("EXPLOSION-LARGE");

                PlayerData.create(player.getUniqueId(), wrapper);

                player.openInventory(InventoryHandler.classicParticles(player, 1));

                player.playSound(player.getLocation(), Configurations.SOUNDS_ADD, 2F, 1F);
            }
            else if (event.getRawSlot() == 23)
            {
                if (!player.hasPermission(Permissions.SPARK))
                {
                    MessageUtil.message(player, MessageUtil.NO_PERMISSION);

                    return;
                }

                PlayerWrapper wrapper;
                if (PlayerData.exists(player.getUniqueId())) wrapper = PlayerData.loadWrapper(player.getUniqueId());
                else wrapper = new PlayerWrapper();

                wrapper.setDeathEffect("SPARK");

                PlayerData.create(player.getUniqueId(), wrapper);

                player.openInventory(InventoryHandler.classicParticles(player, 1));

                player.playSound(player.getLocation(), Configurations.SOUNDS_ADD, 2F, 1F);
            }
            else if (event.getRawSlot() == 24)
            {
                if (!player.hasPermission(Permissions.FLAME))
                {
                    MessageUtil.message(player, MessageUtil.NO_PERMISSION);

                    return;
                }

                PlayerWrapper wrapper;
                if (PlayerData.exists(player.getUniqueId())) wrapper = PlayerData.loadWrapper(player.getUniqueId());
                else wrapper = new PlayerWrapper();

                wrapper.setDeathEffect("FLAME");

                PlayerData.create(player.getUniqueId(), wrapper);

                player.openInventory(InventoryHandler.classicParticles(player, 1));

                player.playSound(player.getLocation(), Configurations.SOUNDS_ADD, 2F, 1F);
            }
            else if (event.getRawSlot() == 25)
            {
                if (!player.hasPermission(Permissions.HEART))
                {
                    MessageUtil.message(player, MessageUtil.NO_PERMISSION);

                    return;
                }

                PlayerWrapper wrapper;
                if (PlayerData.exists(player.getUniqueId())) wrapper = PlayerData.loadWrapper(player.getUniqueId());
                else wrapper = new PlayerWrapper();

                wrapper.setDeathEffect("HEART");

                PlayerData.create(player.getUniqueId(), wrapper);

                player.openInventory(InventoryHandler.classicParticles(player, 1));

                player.playSound(player.getLocation(), Configurations.SOUNDS_ADD, 2F, 1F);
            }
            else if (event.getRawSlot() == 28)
            {
                if (!player.hasPermission(Permissions.LAVA_POP))
                {
                    MessageUtil.message(player, MessageUtil.NO_PERMISSION);

                    return;
                }

                PlayerWrapper wrapper;
                if (PlayerData.exists(player.getUniqueId())) wrapper = PlayerData.loadWrapper(player.getUniqueId());
                else wrapper = new PlayerWrapper();

                wrapper.setDeathEffect("LAVA-POP");

                PlayerData.create(player.getUniqueId(), wrapper);

                player.openInventory(InventoryHandler.classicParticles(player, 1));

                player.playSound(player.getLocation(), Configurations.SOUNDS_ADD, 2F, 1F);
            }
            else if (event.getRawSlot() == 29)
            {
                if (!player.hasPermission(Permissions.NOTE))
                {
                    MessageUtil.message(player, MessageUtil.NO_PERMISSION);

                    return;
                }

                PlayerWrapper wrapper;
                if (PlayerData.exists(player.getUniqueId())) wrapper = PlayerData.loadWrapper(player.getUniqueId());
                else wrapper = new PlayerWrapper();

                wrapper.setDeathEffect("NOTE");

                PlayerData.create(player.getUniqueId(), wrapper);

                player.openInventory(InventoryHandler.classicParticles(player, 1));

                player.playSound(player.getLocation(), Configurations.SOUNDS_ADD, 2F, 1F);
            }
            else if (event.getRawSlot() == 30)
            {
                if (!player.hasPermission(Permissions.PORTAL))
                {
                    MessageUtil.message(player, MessageUtil.NO_PERMISSION);

                    return;
                }

                PlayerWrapper wrapper;
                if (PlayerData.exists(player.getUniqueId())) wrapper = PlayerData.loadWrapper(player.getUniqueId());
                else wrapper = new PlayerWrapper();

                wrapper.setDeathEffect("PORTAL");

                PlayerData.create(player.getUniqueId(), wrapper);

                player.openInventory(InventoryHandler.classicParticles(player, 1));

                player.playSound(player.getLocation(), Configurations.SOUNDS_ADD, 2F, 1F);
            }
            else if (event.getRawSlot() == 31)
            {
                if (!player.hasPermission(Permissions.REDSTONE))
                {
                    MessageUtil.message(player, MessageUtil.NO_PERMISSION);

                    return;
                }

                PlayerWrapper wrapper;
                if (PlayerData.exists(player.getUniqueId())) wrapper = PlayerData.loadWrapper(player.getUniqueId());
                else wrapper = new PlayerWrapper();

                wrapper.setDeathEffect("REDSTONE");

                PlayerData.create(player.getUniqueId(), wrapper);

                player.openInventory(InventoryHandler.classicParticles(player, 1));

                player.playSound(player.getLocation(), Configurations.SOUNDS_ADD, 2F, 1F);
            }
            else if (event.getRawSlot() == 32)
            {
                if (!player.hasPermission(Permissions.SLIME))
                {
                    MessageUtil.message(player, MessageUtil.NO_PERMISSION);

                    return;
                }

                PlayerWrapper wrapper;
                if (PlayerData.exists(player.getUniqueId())) wrapper = PlayerData.loadWrapper(player.getUniqueId());
                else wrapper = new PlayerWrapper();

                wrapper.setDeathEffect("SLIME");

                PlayerData.create(player.getUniqueId(), wrapper);

                player.openInventory(InventoryHandler.classicParticles(player, 1));

                player.playSound(player.getLocation(), Configurations.SOUNDS_ADD, 2F, 1F);
            }
            else if (event.getRawSlot() == 33)
            {
                if (!player.hasPermission(Permissions.SMOKE_SMALL))
                {
                    MessageUtil.message(player, MessageUtil.NO_PERMISSION);

                    return;
                }

                PlayerWrapper wrapper;
                if (PlayerData.exists(player.getUniqueId())) wrapper = PlayerData.loadWrapper(player.getUniqueId());
                else wrapper = new PlayerWrapper();

                wrapper.setDeathEffect("SMOKE-SMALL");

                PlayerData.create(player.getUniqueId(), wrapper);

                player.openInventory(InventoryHandler.classicParticles(player, 1));

                player.playSound(player.getLocation(), Configurations.SOUNDS_ADD, 2F, 1F);
            }
            else if (event.getRawSlot() == 34)
            {
                if (!player.hasPermission(Permissions.SMOKE_LARGE))
                {
                    MessageUtil.message(player, MessageUtil.NO_PERMISSION);

                    return;
                }

                PlayerWrapper wrapper;
                if (PlayerData.exists(player.getUniqueId())) wrapper = PlayerData.loadWrapper(player.getUniqueId());
                else wrapper = new PlayerWrapper();

                wrapper.setDeathEffect("SMOKE-LARGE");

                PlayerData.create(player.getUniqueId(), wrapper);

                player.openInventory(InventoryHandler.classicParticles(player, 1));

                player.playSound(player.getLocation(), Configurations.SOUNDS_ADD, 2F, 1F);
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
            }
            else if (event.getRawSlot() == 53) player.openInventory(InventoryHandler.classicParticles(player, 2));
        }
        else if (view.getTitle().equalsIgnoreCase(InventoryHandler.CLASSIC_PARTICLES_2))
        {
            event.setCancelled(true);

            if (event.getRawSlot() == 10)
            {
                if (!player.hasPermission(Permissions.SPELL))
                {
                    MessageUtil.message(player, MessageUtil.NO_PERMISSION);

                    return;
                }

                PlayerWrapper wrapper;
                if (PlayerData.exists(player.getUniqueId())) wrapper = PlayerData.loadWrapper(player.getUniqueId());
                else wrapper = new PlayerWrapper();

                wrapper.setDeathEffect("SPELL");

                PlayerData.create(player.getUniqueId(), wrapper);

                player.openInventory(InventoryHandler.classicParticles(player, 2));

                player.playSound(player.getLocation(), Configurations.SOUNDS_ADD, 2F, 1F);
            }
            else if (event.getRawSlot() == 11)
            {
                if (!player.hasPermission(Permissions.SNOW))
                {
                    MessageUtil.message(player, MessageUtil.NO_PERMISSION);

                    return;
                }

                PlayerWrapper wrapper;
                if (PlayerData.exists(player.getUniqueId())) wrapper = PlayerData.loadWrapper(player.getUniqueId());
                else wrapper = new PlayerWrapper();

                wrapper.setDeathEffect("SNOW");

                PlayerData.create(player.getUniqueId(), wrapper);

                player.openInventory(InventoryHandler.classicParticles(player, 2));

                player.playSound(player.getLocation(), Configurations.SOUNDS_ADD, 2F, 1F);
            }
            else if (event.getRawSlot() == 12)
            {
                if (!player.hasPermission(Permissions.HAPPY_VILLAGER))
                {
                    MessageUtil.message(player, MessageUtil.NO_PERMISSION);

                    return;
                }

                PlayerWrapper wrapper;
                if (PlayerData.exists(player.getUniqueId())) wrapper = PlayerData.loadWrapper(player.getUniqueId());
                else wrapper = new PlayerWrapper();

                wrapper.setDeathEffect("HAPPY-VILLAGER");

                PlayerData.create(player.getUniqueId(), wrapper);

                player.openInventory(InventoryHandler.classicParticles(player, 2));

                player.playSound(player.getLocation(), Configurations.SOUNDS_ADD, 2F, 1F);
            }
            else if (event.getRawSlot() == 13)
            {
                if (!player.hasPermission(Permissions.ANGRY_VILLAGER))
                {
                    MessageUtil.message(player, MessageUtil.NO_PERMISSION);

                    return;
                }

                PlayerWrapper wrapper;
                if (PlayerData.exists(player.getUniqueId())) wrapper = PlayerData.loadWrapper(player.getUniqueId());
                else wrapper = new PlayerWrapper();

                wrapper.setDeathEffect("ANGRY-VILLAGER");

                PlayerData.create(player.getUniqueId(), wrapper);

                player.openInventory(InventoryHandler.classicParticles(player, 2));

                player.playSound(player.getLocation(), Configurations.SOUNDS_ADD, 2F, 1F);
            }
            else if (event.getRawSlot() == 14)
            {
                if (!player.hasPermission(Permissions.SPLASH))
                {
                    MessageUtil.message(player, MessageUtil.NO_PERMISSION);

                    return;
                }

                PlayerWrapper wrapper;
                if (PlayerData.exists(player.getUniqueId())) wrapper = PlayerData.loadWrapper(player.getUniqueId());
                else wrapper = new PlayerWrapper();

                wrapper.setDeathEffect("SPLASH");

                PlayerData.create(player.getUniqueId(), wrapper);

                player.openInventory(InventoryHandler.classicParticles(player, 2));

                player.playSound(player.getLocation(), Configurations.SOUNDS_ADD, 2F, 1F);
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
            }
        }
    }
}
