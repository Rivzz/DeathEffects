package com.mtjanney.deatheffects.listeners;

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
        }
        else if (view.getTitle().equalsIgnoreCase(InventoryHandler.CLASSIC_PARTICLES_1))
        {
            event.setCancelled(true);

            if (!player.hasPermission(Permissions.FIREWORK))
            {
                MessageUtil.message(player, MessageUtil.NO_PERMISSION);

                return;
            }

            if (event.getRawSlot() == 10)
            {
                PlayerWrapper wrapper;
                if (PlayerData.exists(player.getUniqueId())) wrapper = PlayerData.loadWrapper(player.getUniqueId());
                else wrapper = new PlayerWrapper();

                wrapper.setDeathEffect("FIREWORK");

                PlayerData.create(player.getUniqueId(), wrapper);
            }

            player.openInventory(InventoryHandler.classicParticles(player, 1));
        }
    }
}
