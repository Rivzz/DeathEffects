package com.mtjanney.deatheffects.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.reflect.TypeToken;
import com.mtjanney.deatheffects.DeathEffects;
import com.mtjanney.deatheffects.util.PlayerWrapper;
import org.bukkit.plugin.Plugin;

import java.io.*;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class PlayerData
{
    private final static Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private static Map<String, PlayerWrapper> data = new HashMap<>();

    public PlayerData(Plugin plugin)
    {
        init(plugin);

        try {
            data = (Map<String, PlayerWrapper>) gson.fromJson(new FileReader(file), new HashMap<String, PlayerWrapper>().getClass());
            plugin.getLogger().info("Loaded data.json");
        } catch (FileNotFoundException ignored) {}
    }

    private static File file;

    private void init(Plugin plugin)
    {
        file = new File(plugin.getDataFolder(), "data.json");

        if (!file.exists())
        {
            file.getParentFile().mkdirs();
            plugin.saveResource("data.json", false);
            plugin.getLogger().info("Creating data.json");
        }
    }

    public static void save()
    {
        try (FileWriter writer = new FileWriter(file))
        {
            gson.toJson(data, writer);
        } catch (IOException ignored) {}
    }

    public static void create(UUID uuid, PlayerWrapper wrapper)
    {
        data.put(uuid.toString(), wrapper);
        save();
        DeathEffects.getInstance().getLogger().info("Writing to data.json");
    }

    public static void delete(UUID uuid)
    {
        data.remove(uuid.toString());
        save();
        DeathEffects.getInstance().getLogger().info("Writing to data.json");
    }

    public static boolean exists(UUID uuid)
    {
        return data.containsKey(uuid.toString());
    }

    public static PlayerWrapper loadWrapper(UUID uuid)
    {
        try {
            Type type = new TypeToken<Map<String, PlayerWrapper>>() {}.getType();
            LinkedTreeMap<String, PlayerWrapper> objects = gson.fromJson(new FileReader(file), type);

            return objects.get(uuid.toString());
        } catch (FileNotFoundException ignored) {}

        return new PlayerWrapper();
    }

    public static PlayerWrapper initialize()
    {
        PlayerWrapper wrapper = new PlayerWrapper();

        wrapper.setDeathEffect("NONE");
        wrapper.setSoundEffect("NONE");

        return wrapper;
    }
}
