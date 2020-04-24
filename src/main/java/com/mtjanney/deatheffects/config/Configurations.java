package com.mtjanney.deatheffects.config;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Configurations
{
    public static String BOOK_TITLE;
    public static List<String> BOOK_LORE;

    public Configurations(Plugin plugin)
    {
        init(plugin);

        BOOK_TITLE = config.getString("book.title");
        BOOK_LORE = config.getStringList("book.lore");
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
