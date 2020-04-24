package com.mtjanney.deatheffects;

import com.mtjanney.deatheffects.commands.Command_DeathEffects;
import com.mtjanney.deatheffects.config.Configurations;
import com.mtjanney.deatheffects.listeners.InventoryListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class DeathEffects extends JavaPlugin
{
    @Override
    public void onEnable()
    {
        new Configurations(this);

        getCommand("deatheffects").setExecutor(new Command_DeathEffects());

        getServer().getPluginManager().registerEvents(new InventoryListener(), this);
    }

    @Override
    public void onDisable()
    {

    }
}
