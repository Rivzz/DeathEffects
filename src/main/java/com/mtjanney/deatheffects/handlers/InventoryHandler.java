package com.mtjanney.deatheffects.handlers;

import com.mtjanney.deatheffects.util.InventoryItems;
import com.mtjanney.deatheffects.util.MessageUtil;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class InventoryHandler
{
    public static String MAIN_MENU = MessageUtil.format("&bEffects &7// &eMain Menu");
    public static String CLASSIC_PARTICLES_1 = MessageUtil.format("&eParticle Effects &7: &a1&7/&a2");
    public static String CLASSIC_PARTICLES_2 = MessageUtil.format("&eParticle Effects &7: &a2&7/&a2");

    public static Inventory mainMenu(int page)
    {
        Inventory inventory = Bukkit.createInventory(null, 54, MAIN_MENU);

        switch (page)
        {
            case 1:
            {
                inventory.setItem(11, InventoryItems.classicParticles());
                inventory.setItem(15, InventoryItems.specialParticles());
                inventory.setItem(22, InventoryItems.soundEffects());
                inventory.setItem(48, InventoryItems.removeEffect());
                inventory.setItem(50, InventoryItems.information());
                break;
            }
        }

        return inventory;
    }

    public static Inventory classicParticles(Player player, int page)
    {
        Inventory inventory;

        switch (page)
        {
            case 1:
            {
                inventory = Bukkit.createInventory(null, 54, CLASSIC_PARTICLES_1);

                inventory.setItem(10, InventoryItems.firework(player));
                inventory.setItem(11, InventoryItems.barrier(player));
                inventory.setItem(12, InventoryItems.cloud(player));
                inventory.setItem(13, InventoryItems.critical(player));
                inventory.setItem(14, InventoryItems.magic(player));
                inventory.setItem(15, InventoryItems.lava(player));
                inventory.setItem(16, InventoryItems.water(player));

                inventory.setItem(19, InventoryItems.enchantment(player));
                inventory.setItem(20, InventoryItems.smallExplosion(player));
                inventory.setItem(21, InventoryItems.mediumExplosion(player));
                inventory.setItem(22, InventoryItems.largeExplosion(player));
                inventory.setItem(23, InventoryItems.spark(player));
                inventory.setItem(24, InventoryItems.flame(player));
                inventory.setItem(25, InventoryItems.heart(player));

                inventory.setItem(28, InventoryItems.lavaPop(player));
                inventory.setItem(29, InventoryItems.note(player));
                inventory.setItem(30, InventoryItems.portal(player));
                inventory.setItem(31, InventoryItems.redstone(player));
                inventory.setItem(32, InventoryItems.slime(player));
                inventory.setItem(33, InventoryItems.smokeSmall(player));
                inventory.setItem(34, InventoryItems.smokeLarge(player));

                inventory.setItem(45, InventoryItems.backToMenu());
                inventory.setItem(48, InventoryItems.removeEffect());
                inventory.setItem(50, InventoryItems.information());
                inventory.setItem(53, InventoryItems.next());

                return inventory;
            }
            case 2:
            {
                inventory = Bukkit.createInventory(null, 54, CLASSIC_PARTICLES_2);

                inventory.setItem(10, InventoryItems.spell(player));
                inventory.setItem(11, InventoryItems.snow(player));
                inventory.setItem(12, InventoryItems.villagerHappy(player));
                inventory.setItem(13, InventoryItems.villagerAngry(player));
                inventory.setItem(14, InventoryItems.splash(player));

                inventory.setItem(45, InventoryItems.backToMenu());
                inventory.setItem(48, InventoryItems.removeEffect());
                inventory.setItem(50, InventoryItems.information());

                return inventory;
            }
        }

        return Bukkit.createInventory(null, 54);
    }
}
