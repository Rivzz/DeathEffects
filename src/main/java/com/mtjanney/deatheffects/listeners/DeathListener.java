package com.mtjanney.deatheffects.listeners;

import com.mtjanney.deatheffects.config.PlayerData;
import com.mtjanney.deatheffects.util.PlayerWrapper;
import com.mtjanney.deatheffects.util.effects.DisplayFirework;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class DeathListener implements Listener
{
    @EventHandler
    public void onDeath(PlayerDeathEvent event)
    {
        Player player = event.getEntity();

        if (!PlayerData.exists(player.getUniqueId())) return;

        PlayerWrapper wrapper = PlayerData.loadWrapper(player.getUniqueId());

        switch (wrapper.getDeathEffect())
        {
            case "FIREWORK":
            {
                DisplayFirework.display(player);
                break;
            }
        }
    }
}
