package com.mtjanney.deatheffects.util.effects;

import com.mtjanney.deatheffects.config.Configurations;
import com.mtjanney.deatheffects.util.libraries.ParticleEffect;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.Random;

public class DisplayEffect
{
    public static void display(Player player, ParticleEffect effect)
    {
        Location location = player.getLocation().add(0, 1, 0);

        for (int i = 0; i < Configurations.OPTIONS_EFFECT_AMOUNT; i++)
        {
            Random random = new Random();
            int x = random.nextInt((2 + 1) - 1);
            int y = random.nextInt((2 + 1) - 1);
            int z = random.nextInt((2 + 1) - 1);

            if (effect == ParticleEffect.CLOUD) effect.display(x, y + 1, z, 0, 1, location, 25);
            else effect.display(x, y, z, 0, 1, location, 25);
        }
    }
}
