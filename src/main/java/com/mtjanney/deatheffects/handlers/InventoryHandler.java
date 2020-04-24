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
        Inventory inventory = Bukkit.createInventory(null, 54, CLASSIC_PARTICLES_1);

        switch (page)
        {
            case 1:
            {
                inventory.setItem(10, InventoryItems.firework(player));
                break;
            }
        }

        return inventory;
    }
}
