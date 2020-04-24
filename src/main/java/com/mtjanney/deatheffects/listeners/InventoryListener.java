package com.mtjanney.deatheffects.listeners;

import com.mtjanney.deatheffects.handlers.InventoryHandler;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.InventoryView;

public class InventoryListener implements Listener
{
    @EventHandler
    public void onInventoryClick(InventoryClickEvent event)
    {
        InventoryView view = event.getView();

        if (view.getTitle().equals(InventoryHandler.MAIN_MENU))
        {
            event.setCancelled(true);

            // Todo add more here
        }
    }
}
