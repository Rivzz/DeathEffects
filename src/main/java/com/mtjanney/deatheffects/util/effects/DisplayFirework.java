package com.mtjanney.deatheffects.util.effects;

import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.FireworkMeta;

import java.util.ArrayList;
import java.util.List;

public class DisplayFirework
{
    public static void display(Player player)
    {
        Firework firework = (Firework) player.getWorld().spawnEntity(player.getLocation(), EntityType.FIREWORK);
        FireworkMeta meta = firework.getFireworkMeta();

        List<Color> colors = new ArrayList<>();

        colors.add(Color.RED);

        FireworkEffect effect = FireworkEffect.builder().flicker(false).withColor(colors).with(FireworkEffect.Type.BALL_LARGE).build();

        meta.addEffect(effect);
        meta.setPower(0);

        firework.setFireworkMeta(meta);
    }
}
