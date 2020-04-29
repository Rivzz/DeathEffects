package com.mtjanney.deatheffects.config;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.IOException;

public class Language
{
    public static String GENERAL_NO_PERMISSION;
    public static String GENERAL_ERROR_OFFLINE;

    public static String EFFECT_EQUIP_SELF;
    public static String EFFECT_EQUIP_OTHER;
    public static String EFFECT_EQUIP_FROM_OTHER;
    public static String EFFECT_REMOVE_SELF;
    public static String EFFECT_REMOVE_OTHER;
    public static String EFFECT_REMOVE_FROM_OTHER;
    public static String EFFECT_NO_ACTIVE;
    public static String EFFECT_NO_ACTIVE_OTHER;

    public Language(Plugin plugin)
    {
        init(plugin);

        GENERAL_NO_PERMISSION = language.getString("general.no-permission");
        GENERAL_ERROR_OFFLINE = language.getString("general.error-offline");

        EFFECT_EQUIP_SELF = language.getString("effect.equip-self");
        EFFECT_EQUIP_OTHER = language.getString("effect.equip-other");
        EFFECT_EQUIP_FROM_OTHER = language.getString("effect.equip-from-other");
        EFFECT_REMOVE_SELF = language.getString("effect.remove-self");
        EFFECT_REMOVE_OTHER = language.getString("effect.remove-other");
        EFFECT_REMOVE_FROM_OTHER = language.getString("effect.remove-from-other");
        EFFECT_NO_ACTIVE = language.getString("effect.no-active");
        EFFECT_NO_ACTIVE_OTHER = language.getString("effect.no-active-other");
    }

    private FileConfiguration language;

    private void init(Plugin plugin)
    {
        File file = new File(plugin.getDataFolder(), "language.yml");

        if (!file.exists())
        {
            file.getParentFile().mkdirs();
            plugin.saveResource("language.yml", false);
            plugin.getLogger().info("Creating language.yml");
        }

        language = new YamlConfiguration();

        try {
            language.load(file);
        } catch (IOException | InvalidConfigurationException exception) {
            exception.printStackTrace();
        }

        plugin.getLogger().info("Loaded language values.");
    }
}
