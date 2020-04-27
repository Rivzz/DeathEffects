package com.mtjanney.deatheffects.util;

import com.mtjanney.deatheffects.config.Configurations;
import com.mtjanney.deatheffects.config.PlayerData;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
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

    public static ItemStack firework(Player player)
    {
        ItemStack item = new ItemStack(Material.FIREWORK);
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName(MessageUtil.format("&aFirework"));

        List<String> lore = new ArrayList<>();

        lore.add(MessageUtil.format(player.hasPermission(Permissions.FIREWORK) ? "&a» UNLOCKED" : "&c» LOCKED"));

        meta.setLore(lore);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_ATTRIBUTES);

        item.setItemMeta(meta);

        if (PlayerData.exists(player.getUniqueId()))
        {
            if (PlayerData.loadWrapper(player.getUniqueId()).getDeathEffect().equals("FIREWORK"))
                item.addUnsafeEnchantment(Enchantment.DURABILITY, 0);
        }

        return item;
    }

    public static ItemStack barrier(Player player)
    {
        ItemStack item = new ItemStack(Material.BARRIER);
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName(MessageUtil.format("&aBarrier"));

        List<String> lore = new ArrayList<>();

        lore.add(MessageUtil.format(player.hasPermission(Permissions.BARRIER) ? "&a» UNLOCKED" : "&c» LOCKED"));

        meta.setLore(lore);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_ATTRIBUTES);

        item.setItemMeta(meta);

        if (PlayerData.exists(player.getUniqueId()))
        {
            if (PlayerData.loadWrapper(player.getUniqueId()).getDeathEffect().equals("BARRIER"))
                item.addUnsafeEnchantment(Enchantment.DURABILITY, 0);
        }

        return item;
    }

    public static ItemStack cloud(Player player)
    {
        ItemStack item = new ItemStack(Material.FEATHER);
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName(MessageUtil.format("&aCloud"));

        List<String> lore = new ArrayList<>();

        lore.add(MessageUtil.format(player.hasPermission(Permissions.CLOUD) ? "&a» UNLOCKED" : "&c» LOCKED"));

        meta.setLore(lore);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_ATTRIBUTES);

        item.setItemMeta(meta);

        if (PlayerData.exists(player.getUniqueId()))
        {
            if (PlayerData.loadWrapper(player.getUniqueId()).getDeathEffect().equals("CLOUD"))
                item.addUnsafeEnchantment(Enchantment.DURABILITY, 0);
        }

        return item;
    }

    public static ItemStack critical(Player player)
    {
        ItemStack item = new ItemStack(Material.IRON_SWORD);
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName(MessageUtil.format("&aCritical"));

        List<String> lore = new ArrayList<>();

        lore.add(MessageUtil.format(player.hasPermission(Permissions.CRITICAL) ? "&a» UNLOCKED" : "&c» LOCKED"));

        meta.setLore(lore);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_ATTRIBUTES);

        item.setItemMeta(meta);

        if (PlayerData.exists(player.getUniqueId()))
        {
            if (PlayerData.loadWrapper(player.getUniqueId()).getDeathEffect().equals("CRITICAL"))
                item.addUnsafeEnchantment(Enchantment.DURABILITY, 0);
        }

        return item;
    }

    public static ItemStack magic(Player player)
    {
        ItemStack item = new ItemStack(379);
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName(MessageUtil.format("&aMagic"));

        List<String> lore = new ArrayList<>();

        lore.add(MessageUtil.format(player.hasPermission(Permissions.CRITICAL_MAGIC) ? "&a» UNLOCKED" : "&c» LOCKED"));

        meta.setLore(lore);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_POTION_EFFECTS);

        item.setItemMeta(meta);

        if (PlayerData.exists(player.getUniqueId()))
        {
            if (PlayerData.loadWrapper(player.getUniqueId()).getDeathEffect().equals("MAGIC"))
                item.addUnsafeEnchantment(Enchantment.DURABILITY, 0);
        }

        return item;
    }

    public static ItemStack lava(Player player)
    {
        ItemStack item = new ItemStack(Material.LAVA_BUCKET);
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName(MessageUtil.format("&aLava"));

        List<String> lore = new ArrayList<>();

        lore.add(MessageUtil.format(player.hasPermission(Permissions.LAVA) ? "&a» UNLOCKED" : "&c» LOCKED"));

        meta.setLore(lore);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_ATTRIBUTES);

        item.setItemMeta(meta);

        if (PlayerData.exists(player.getUniqueId()))
        {
            if (PlayerData.loadWrapper(player.getUniqueId()).getDeathEffect().equals("LAVA"))
                item.addUnsafeEnchantment(Enchantment.DURABILITY, 0);
        }

        return item;
    }

    public static ItemStack water(Player player)
    {
        ItemStack item = new ItemStack(Material.WATER_BUCKET);
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName(MessageUtil.format("&aWater"));

        List<String> lore = new ArrayList<>();

        lore.add(MessageUtil.format(player.hasPermission(Permissions.WATER) ? "&a» UNLOCKED" : "&c» LOCKED"));

        meta.setLore(lore);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_ATTRIBUTES);

        item.setItemMeta(meta);

        if (PlayerData.exists(player.getUniqueId()))
        {
            if (PlayerData.loadWrapper(player.getUniqueId()).getDeathEffect().equals("WATER"))
                item.addUnsafeEnchantment(Enchantment.DURABILITY, 0);
        }

        return item;
    }

    public static ItemStack enchantment(Player player)
    {
        ItemStack item = new ItemStack(Material.ENCHANTMENT_TABLE);
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName(MessageUtil.format("&aEnchantment"));

        List<String> lore = new ArrayList<>();

        lore.add(MessageUtil.format(player.hasPermission(Permissions.ENCHANTMENT) ? "&a» UNLOCKED" : "&c» LOCKED"));

        meta.setLore(lore);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_ATTRIBUTES);

        item.setItemMeta(meta);

        if (PlayerData.exists(player.getUniqueId()))
        {
            if (PlayerData.loadWrapper(player.getUniqueId()).getDeathEffect().equals("ENCHANTMENT"))
                item.addUnsafeEnchantment(Enchantment.DURABILITY, 0);
        }

        return item;
    }

    public static ItemStack smallExplosion(Player player)
    {
        ItemStack item = new ItemStack(Material.GHAST_TEAR);
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName(MessageUtil.format("&aSmall Explosion"));

        List<String> lore = new ArrayList<>();

        lore.add(MessageUtil.format(player.hasPermission(Permissions.EXPLOSION_SMALL) ? "&a» UNLOCKED" : "&c» LOCKED"));

        meta.setLore(lore);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_ATTRIBUTES);

        item.setItemMeta(meta);

        if (PlayerData.exists(player.getUniqueId()))
        {
            if (PlayerData.loadWrapper(player.getUniqueId()).getDeathEffect().equals("EXPLOSION-SMALL"))
                item.addUnsafeEnchantment(Enchantment.DURABILITY, 0);
        }

        return item;
    }

    public static ItemStack mediumExplosion(Player player)
    {
        ItemStack item = new ItemStack(Material.SUGAR);
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName(MessageUtil.format("&aMedium Explosion"));

        List<String> lore = new ArrayList<>();

        lore.add(MessageUtil.format(player.hasPermission(Permissions.EXPLOSION_MEDIUM) ? "&a» UNLOCKED" : "&c» LOCKED"));

        meta.setLore(lore);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_ATTRIBUTES);

        item.setItemMeta(meta);

        if (PlayerData.exists(player.getUniqueId()))
        {
            if (PlayerData.loadWrapper(player.getUniqueId()).getDeathEffect().equals("EXPLOSION-MEDIUM"))
                item.addUnsafeEnchantment(Enchantment.DURABILITY, 0);
        }

        return item;
    }

    public static ItemStack largeExplosion(Player player)
    {
        ItemStack item = new ItemStack(Material.INK_SACK, 1, (byte) 15);
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName(MessageUtil.format("&aLarge Explosion"));

        List<String> lore = new ArrayList<>();

        lore.add(MessageUtil.format(player.hasPermission(Permissions.EXPLOSION_LARGE) ? "&a» UNLOCKED" : "&c» LOCKED"));

        meta.setLore(lore);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_ATTRIBUTES);

        item.setItemMeta(meta);

        if (PlayerData.exists(player.getUniqueId()))
        {
            if (PlayerData.loadWrapper(player.getUniqueId()).getDeathEffect().equals("EXPLOSION-LARGE"))
                item.addUnsafeEnchantment(Enchantment.DURABILITY, 0);
        }

        return item;
    }

    public static ItemStack spark(Player player)
    {
        ItemStack item = new ItemStack(Material.FIREWORK_CHARGE);
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName(MessageUtil.format("&aSpark"));

        List<String> lore = new ArrayList<>();

        lore.add(MessageUtil.format(player.hasPermission(Permissions.SPARK) ? "&a» UNLOCKED" : "&c» LOCKED"));

        meta.setLore(lore);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_ATTRIBUTES);

        item.setItemMeta(meta);

        if (PlayerData.exists(player.getUniqueId()))
        {
            if (PlayerData.loadWrapper(player.getUniqueId()).getDeathEffect().equals("SPARK"))
                item.addUnsafeEnchantment(Enchantment.DURABILITY, 0);
        }

        return item;
    }

    public static ItemStack flame(Player player)
    {
        ItemStack item = new ItemStack(Material.FLINT_AND_STEEL);
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName(MessageUtil.format("&aFlame"));

        List<String> lore = new ArrayList<>();

        lore.add(MessageUtil.format(player.hasPermission(Permissions.FLAME) ? "&a» UNLOCKED" : "&c» LOCKED"));

        meta.setLore(lore);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_ATTRIBUTES);

        item.setItemMeta(meta);

        if (PlayerData.exists(player.getUniqueId()))
        {
            if (PlayerData.loadWrapper(player.getUniqueId()).getDeathEffect().equals("FLAME"))
                item.addUnsafeEnchantment(Enchantment.DURABILITY, 0);
        }

        return item;
    }

    public static ItemStack heart(Player player)
    {
        ItemStack item = new ItemStack(Material.INK_SACK, 1, (byte) 1);
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName(MessageUtil.format("&aHeart"));

        List<String> lore = new ArrayList<>();

        lore.add(MessageUtil.format(player.hasPermission(Permissions.HEART) ? "&a» UNLOCKED" : "&c» LOCKED"));

        meta.setLore(lore);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_ATTRIBUTES);

        item.setItemMeta(meta);

        if (PlayerData.exists(player.getUniqueId()))
        {
            if (PlayerData.loadWrapper(player.getUniqueId()).getDeathEffect().equals("HEART"))
                item.addUnsafeEnchantment(Enchantment.DURABILITY, 0);
        }

        return item;
    }

    public static ItemStack lavaPop(Player player)
    {
        ItemStack item = new ItemStack(372);
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName(MessageUtil.format("&aLava Pop"));

        List<String> lore = new ArrayList<>();

        lore.add(MessageUtil.format(player.hasPermission(Permissions.LAVA_POP) ? "&a» UNLOCKED" : "&c» LOCKED"));

        meta.setLore(lore);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_ATTRIBUTES);

        item.setItemMeta(meta);

        if (PlayerData.exists(player.getUniqueId()))
        {
            if (PlayerData.loadWrapper(player.getUniqueId()).getDeathEffect().equals("LAVA-POP"))
                item.addUnsafeEnchantment(Enchantment.DURABILITY, 0);
        }

        return item;
    }

    public static ItemStack note(Player player)
    {
        ItemStack item = new ItemStack(Material.JUKEBOX);
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName(MessageUtil.format("&aNote"));

        List<String> lore = new ArrayList<>();

        lore.add(MessageUtil.format(player.hasPermission(Permissions.NOTE) ? "&a» UNLOCKED" : "&c» LOCKED"));

        meta.setLore(lore);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_ATTRIBUTES);

        item.setItemMeta(meta);

        if (PlayerData.exists(player.getUniqueId()))
        {
            if (PlayerData.loadWrapper(player.getUniqueId()).getDeathEffect().equals("NOTE"))
                item.addUnsafeEnchantment(Enchantment.DURABILITY, 0);
        }

        return item;
    }

    public static ItemStack portal(Player player)
    {
        ItemStack item = new ItemStack(Material.OBSIDIAN);
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName(MessageUtil.format("&aPortal"));

        List<String> lore = new ArrayList<>();

        lore.add(MessageUtil.format(player.hasPermission(Permissions.PORTAL) ? "&a» UNLOCKED" : "&c» LOCKED"));

        meta.setLore(lore);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_ATTRIBUTES);

        item.setItemMeta(meta);

        if (PlayerData.exists(player.getUniqueId()))
        {
            if (PlayerData.loadWrapper(player.getUniqueId()).getDeathEffect().equals("PORTAL"))
                item.addUnsafeEnchantment(Enchantment.DURABILITY, 0);
        }

        return item;
    }

    public static ItemStack redstone(Player player)
    {
        ItemStack item = new ItemStack(Material.REDSTONE);
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName(MessageUtil.format("&aRedstone"));

        List<String> lore = new ArrayList<>();

        lore.add(MessageUtil.format(player.hasPermission(Permissions.REDSTONE) ? "&a» UNLOCKED" : "&c» LOCKED"));

        meta.setLore(lore);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_ATTRIBUTES);

        item.setItemMeta(meta);

        if (PlayerData.exists(player.getUniqueId()))
        {
            if (PlayerData.loadWrapper(player.getUniqueId()).getDeathEffect().equals("REDSTONE"))
                item.addUnsafeEnchantment(Enchantment.DURABILITY, 0);
        }

        return item;
    }

    public static ItemStack slime(Player player)
    {
        ItemStack item = new ItemStack(Material.SLIME_BALL);
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName(MessageUtil.format("&aSlime"));

        List<String> lore = new ArrayList<>();

        lore.add(MessageUtil.format(player.hasPermission(Permissions.SLIME) ? "&a» UNLOCKED" : "&c» LOCKED"));

        meta.setLore(lore);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_ATTRIBUTES);

        item.setItemMeta(meta);

        if (PlayerData.exists(player.getUniqueId()))
        {
            if (PlayerData.loadWrapper(player.getUniqueId()).getDeathEffect().equals("SLIME"))
                item.addUnsafeEnchantment(Enchantment.DURABILITY, 0);
        }

        return item;
    }

    public static ItemStack smokeSmall(Player player)
    {
        ItemStack item = new ItemStack(Material.COAL);
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName(MessageUtil.format("&aSmall Smoke"));

        List<String> lore = new ArrayList<>();

        lore.add(MessageUtil.format(player.hasPermission(Permissions.SMOKE_SMALL) ? "&a» UNLOCKED" : "&c» LOCKED"));

        meta.setLore(lore);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_ATTRIBUTES);

        item.setItemMeta(meta);

        if (PlayerData.exists(player.getUniqueId()))
        {
            if (PlayerData.loadWrapper(player.getUniqueId()).getDeathEffect().equals("SMOKE-SMALL"))
                item.addUnsafeEnchantment(Enchantment.DURABILITY, 0);
        }

        return item;
    }

    public static ItemStack smokeLarge(Player player)
    {
        ItemStack item = new ItemStack(Material.COAL, 1, (byte) 1);
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName(MessageUtil.format("&aLarge Smoke"));

        List<String> lore = new ArrayList<>();

        lore.add(MessageUtil.format(player.hasPermission(Permissions.SMOKE_LARGE) ? "&a» UNLOCKED" : "&c» LOCKED"));

        meta.setLore(lore);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_ATTRIBUTES);

        item.setItemMeta(meta);

        if (PlayerData.exists(player.getUniqueId()))
        {
            if (PlayerData.loadWrapper(player.getUniqueId()).getDeathEffect().equals("SMOKE-LARGE"))
                item.addUnsafeEnchantment(Enchantment.DURABILITY, 0);
        }

        return item;
    }

    public static ItemStack spell(Player player)
    {
        ItemStack item = new ItemStack(380);
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName(MessageUtil.format("&aSpell"));

        List<String> lore = new ArrayList<>();

        lore.add(MessageUtil.format(player.hasPermission(Permissions.SPELL) ? "&a» UNLOCKED" : "&c» LOCKED"));

        meta.setLore(lore);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_POTION_EFFECTS);

        item.setItemMeta(meta);

        if (PlayerData.exists(player.getUniqueId()))
        {
            if (PlayerData.loadWrapper(player.getUniqueId()).getDeathEffect().equals("SPELL"))
                item.addUnsafeEnchantment(Enchantment.DURABILITY, 0);
        }

        return item;
    }

    public static ItemStack snow(Player player)
    {
        ItemStack item = new ItemStack(Material.SNOW_BALL);
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName(MessageUtil.format("&aSnow"));

        List<String> lore = new ArrayList<>();

        lore.add(MessageUtil.format(player.hasPermission(Permissions.SNOW) ? "&a» UNLOCKED" : "&c» LOCKED"));

        meta.setLore(lore);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_ATTRIBUTES);

        item.setItemMeta(meta);

        if (PlayerData.exists(player.getUniqueId()))
        {
            if (PlayerData.loadWrapper(player.getUniqueId()).getDeathEffect().equals("SNOW"))
                item.addUnsafeEnchantment(Enchantment.DURABILITY, 0);
        }

        return item;
    }

    public static ItemStack villagerHappy(Player player)
    {
        ItemStack item = new ItemStack(Material.MONSTER_EGG, 1, (byte) 120);
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName(MessageUtil.format("&aHappy Villager"));

        List<String> lore = new ArrayList<>();

        lore.add(MessageUtil.format(player.hasPermission(Permissions.HAPPY_VILLAGER) ? "&a» UNLOCKED" : "&c» LOCKED"));

        meta.setLore(lore);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_ATTRIBUTES);

        item.setItemMeta(meta);

        if (PlayerData.exists(player.getUniqueId()))
        {
            if (PlayerData.loadWrapper(player.getUniqueId()).getDeathEffect().equals("HAPPY-VILLAGER"))
                item.addUnsafeEnchantment(Enchantment.DURABILITY, 0);
        }

        return item;
    }

    public static ItemStack villagerAngry(Player player)
    {
        ItemStack item = new ItemStack(Material.MONSTER_EGG, 1, (byte) 54);
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName(MessageUtil.format("&aAngry Villager"));

        List<String> lore = new ArrayList<>();

        lore.add(MessageUtil.format(player.hasPermission(Permissions.ANGRY_VILLAGER) ? "&a» UNLOCKED" : "&c» LOCKED"));

        meta.setLore(lore);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_ATTRIBUTES);

        item.setItemMeta(meta);

        if (PlayerData.exists(player.getUniqueId()))
        {
            if (PlayerData.loadWrapper(player.getUniqueId()).getDeathEffect().equals("ANGRY-VILLAGER"))
                item.addUnsafeEnchantment(Enchantment.DURABILITY, 0);
        }

        return item;
    }

    public static ItemStack splash(Player player)
    {
        ItemStack item = new ItemStack(Material.BOAT);
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName(MessageUtil.format("&aSplash"));

        List<String> lore = new ArrayList<>();

        lore.add(MessageUtil.format(player.hasPermission(Permissions.SPLASH) ? "&a» UNLOCKED" : "&c» LOCKED"));

        meta.setLore(lore);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_POTION_EFFECTS);

        item.setItemMeta(meta);

        if (PlayerData.exists(player.getUniqueId()))
        {
            if (PlayerData.loadWrapper(player.getUniqueId()).getDeathEffect().equals("SPLASH"))
                item.addUnsafeEnchantment(Enchantment.DURABILITY, 0);
        }

        return item;
    }

    public static ItemStack backToMenu()
    {
        ItemStack item = new ItemStack(Material.ARROW);
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName(MessageUtil.format("&aBack to Menu"));

        List<String> lore = new ArrayList<>();

        lore.add(MessageUtil.format("&7Click to return"));

        meta.setLore(lore);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_ATTRIBUTES);

        item.setItemMeta(meta);

        return item;
    }

    public static ItemStack previous()
    {
        ItemStack item = new ItemStack(Material.ARROW);
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName(MessageUtil.format("&aPrevious Page"));

        List<String> lore = new ArrayList<>();

        lore.add(MessageUtil.format("&7Click to go"));

        meta.setLore(lore);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_ATTRIBUTES);

        item.setItemMeta(meta);

        return item;
    }

    public static ItemStack next()
    {
        ItemStack item = new ItemStack(Material.ARROW);
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName(MessageUtil.format("&aNext Page"));

        List<String> lore = new ArrayList<>();

        lore.add(MessageUtil.format("&7Click to go"));

        meta.setLore(lore);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_ATTRIBUTES);

        item.setItemMeta(meta);

        return item;
    }
}
