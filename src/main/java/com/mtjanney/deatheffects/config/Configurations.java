package com.mtjanney.deatheffects.config;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Configurations
{
    public static String VERSION;

    public static boolean OPTIONS_VERSION_NOTIFICATION;
    public static int OPTIONS_EFFECT_AMOUNT;
    public static String OPTIONS_CHAT_PREFIX;

    public static String BOOK_TITLE;
    public static List<String> BOOK_LORE;

    public static Sound SOUNDS_ADD;
    public static Sound SOUNDS_REMOVE;

    public static boolean JOIN_ITEM_ENABLED;
    public static int JOIN_ITEM_SLOT;
    public static Material JOIN_ITEM_ITEM;
    public static String JOIN_ITEM_NAME;
    public static List<String> JOIN_ITEM_LORE;

    public Configurations(Plugin plugin)
    {
        init(plugin);

        VERSION = config.getString("version");

        OPTIONS_VERSION_NOTIFICATION = config.getBoolean("options.version-notification");
        OPTIONS_EFFECT_AMOUNT = config.getInt("options.effect-amount");
        OPTIONS_CHAT_PREFIX = config.getString("options.chat-prefix");

        BOOK_TITLE = config.getString("book.title");
        BOOK_LORE = config.getStringList("book.lore");

        SOUNDS_ADD = Sound.valueOf(config.getString("sounds.add"));
        SOUNDS_REMOVE = Sound.valueOf(config.getString("sounds.remove"));

        JOIN_ITEM_ENABLED = config.getBoolean("join-item.enabled");
        JOIN_ITEM_SLOT = config.getInt("join-item.slot");
        JOIN_ITEM_ITEM = Material.valueOf(config.getString("join-item.item"));
        JOIN_ITEM_NAME = config.getString("join-item.name");
        JOIN_ITEM_LORE = config.getStringList("join-item.lore");
    }

    private FileConfiguration config;

    private void init(Plugin plugin)
    {
        File file = new File(plugin.getDataFolder(), "config.yml");

        if (!file.exists())
        {
            file.getParentFile().mkdirs();
            plugin.saveResource("config.yml", false);
            plugin.getLogger().info("Creating config.yml");
        }

        config = new YamlConfiguration();

        try {
            config.load(file);
        } catch (IOException | InvalidConfigurationException exception) {
            exception.printStackTrace();
        }

        plugin.getLogger().info("Loaded config values.");
    }
}
