package com.mtjanney.deatheffects.util;

import com.mtjanney.deatheffects.config.Configurations;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class InventoryItems
{
    public static ItemStack classicParticles()
    {
        ItemStack item = new ItemStack(Material.NETHER_STAR);
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName(MessageUtil.format("&eClassic Particles"));

        List<String> lore = new ArrayList<>();

        lore.add(MessageUtil.format("&aTotal Particles&7: &b26"));
        lore.add(MessageUtil.format("&7&m---------------------"));
        lore.add(MessageUtil.format("&7Select an effect to appear"));
        lore.add(MessageUtil.format("&7when you die!"));
        lore.add(MessageUtil.format("&7&m---------------------"));

        meta.setLore(lore);

        item.setItemMeta(meta);

        return item;
    }

    public static ItemStack specialParticles()
    {
        ItemStack item = new ItemStack(Material.EYE_OF_ENDER);
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName(MessageUtil.format("&eSpecial Particles"));

        List<String> lore = new ArrayList<>();

        lore.add(MessageUtil.format("&aTotal Particles&7: &b4"));
        lore.add(MessageUtil.format("&7&m---------------------"));
        lore.add(MessageUtil.format("&7Select a special effect to"));
        lore.add(MessageUtil.format("&7appear when you die!"));
        lore.add(MessageUtil.format("&7&m---------------------"));

        meta.setLore(lore);

        item.setItemMeta(meta);

        return item;
    }

    public static ItemStack soundEffects()
    {
        ItemStack item = new ItemStack(Material.JUKEBOX);
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName(MessageUtil.format("&eSound Effects"));

        List<String> lore = new ArrayList<>();

        lore.add(MessageUtil.format("&aTotal Effects&7: &b15"));
        lore.add(MessageUtil.format("&7&m---------------------"));
        lore.add(MessageUtil.format("&7Select a death sound"));
        lore.add(MessageUtil.format("&7&m---------------------"));

        meta.setLore(lore);

        item.setItemMeta(meta);

        return item;
    }

    public static ItemStack removeEffect()
    {
        ItemStack item = new ItemStack(Material.REDSTONE_BLOCK);
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName(MessageUtil.format("&cRemove Death Effect"));

        item.setItemMeta(meta);

        return item;
    }

    public static ItemStack information()
    {
        ItemStack item = new ItemStack(Material.BOOK);
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName(MessageUtil.format(Configurations.BOOK_TITLE));
        meta.setLore(MessageUtil.formatList(Configurations.BOOK_LORE));

        item.setItemMeta(meta);

        return item;
    }
}
