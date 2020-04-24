package com.mtjanney.deatheffects;

import com.mtjanney.deatheffects.commands.Command_DeathEffects;
import com.mtjanney.deatheffects.config.Configurations;
import com.mtjanney.deatheffects.config.PlayerData;
import com.mtjanney.deatheffects.listeners.DeathListener;
import com.mtjanney.deatheffects.listeners.InventoryListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class DeathEffects extends JavaPlugin
{
    private static DeathEffects instance;

    @Override
    public void onLoad()
    {
        instance = this;
    }

    @Override
    public void onEnable()
    {
        new Configurations(this);
        new PlayerData(this);

        getCommand("deatheffects").setExecutor(new Command_DeathEffects());

        getServer().getPluginManager().registerEvents(new InventoryListener(), this);
        getServer().getPluginManager().registerEvents(new DeathListener(), this);
    }

    @Override
    public void onDisable()
    {

    }

    public static DeathEffects getInstance()
    {
        return instance;
    }
}
