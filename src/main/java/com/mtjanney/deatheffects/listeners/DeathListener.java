package com.mtjanney.deatheffects.listeners;

import com.mtjanney.deatheffects.config.PlayerData;
import com.mtjanney.deatheffects.util.PlayerWrapper;
import com.mtjanney.deatheffects.util.effects.DisplayEffect;
import com.mtjanney.deatheffects.util.effects.DisplayFirework;
import com.mtjanney.deatheffects.util.libraries.ParticleEffect;
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
            case "BARRIER":
            {
                DisplayEffect.display(player, ParticleEffect.BARRIER);
                break;
            }
            case "CLOUD":
            {
                DisplayEffect.display(player, ParticleEffect.CLOUD);
                break;
            }
            case "CRITICAL":
            {
                DisplayEffect.display(player, ParticleEffect.CRIT);
                break;
            }
            case "MAGIC":
            {
                DisplayEffect.display(player, ParticleEffect.CRIT_MAGIC);
                break;
            }
            case "LAVA":
            {
                DisplayEffect.display(player, ParticleEffect.DRIP_LAVA);
                break;
            }
            case "WATER":
            {
                DisplayEffect.display(player, ParticleEffect.DRIP_WATER);
                break;
            }
            case "ENCHANTMENT":
            {
                DisplayEffect.display(player, ParticleEffect.ENCHANTMENT_TABLE);
                break;
            }
            case "EXPLOSION-SMALL":
            {
                DisplayEffect.display(player, ParticleEffect.EXPLOSION_NORMAL);
                break;
            }
            case "EXPLOSION-MEDIUM":
            {
                DisplayEffect.display(player, ParticleEffect.EXPLOSION_LARGE);
                break;
            }
            case "EXPLOSION-LARGE":
            {
                DisplayEffect.display(player, ParticleEffect.EXPLOSION_HUGE);
                break;
            }
            case "SPARK":
            {
                DisplayEffect.display(player, ParticleEffect.FIREWORKS_SPARK);
                break;
            }
            case "FLAME":
            {
                DisplayEffect.display(player, ParticleEffect.FLAME);
                break;
            }
            case "HEART":
            {
                DisplayEffect.display(player, ParticleEffect.HEART);
                break;
            }
            case "LAVA-POP":
            {
                DisplayEffect.display(player, ParticleEffect.LAVA);
                break;
            }
            case "NOTE":
            {
                DisplayEffect.display(player, ParticleEffect.NOTE);
                break;
            }
            case "PORTAL":
            {
                DisplayEffect.display(player, ParticleEffect.PORTAL);
                break;
            }
            case "REDSTONE":
            {
                DisplayEffect.display(player, ParticleEffect.REDSTONE);
                break;
            }
            case "SLIME":
            {
                DisplayEffect.display(player, ParticleEffect.SLIME);
                break;
            }
            case "SMOKE-SMALL":
            {
                DisplayEffect.display(player, ParticleEffect.SMOKE_NORMAL);
                break;
            }
            case "SMOKE-LARGE":
            {
                DisplayEffect.display(player, ParticleEffect.SMOKE_LARGE);
                break;
            }
            case "SPELL":
            {
                DisplayEffect.display(player, ParticleEffect.SPELL);
                break;
            }
            case "SNOW":
            {
                DisplayEffect.display(player, ParticleEffect.SNOWBALL);
                break;
            }
            case "HAPPY-VILLAGER":
            {
                DisplayEffect.display(player, ParticleEffect.VILLAGER_HAPPY);
                break;
            }
            case "ANGRY-VILLAGER":
            {
                DisplayEffect.display(player, ParticleEffect.VILLAGER_ANGRY);
                break;
            }
            case "SPLASH":
            {
                DisplayEffect.display(player, ParticleEffect.WATER_SPLASH);
                break;
            }
        }
    }
}
