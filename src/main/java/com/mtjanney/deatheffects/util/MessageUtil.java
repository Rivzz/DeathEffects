package com.mtjanney.deatheffects.util;

import com.mtjanney.deatheffects.config.Configurations;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import java.util.ArrayList;
import java.util.List;

public class MessageUtil
{
    public static String format(String message)
    {
        return ChatColor.translateAlternateColorCodes('&', message);
    }

    public static List<String> formatList(List<String> text)
    {
        List<String> newList = new ArrayList<>();

        for (String element : text) newList.add(MessageUtil.format(element));

        return newList;
    }

    public static void message(CommandSender sender, String message, boolean prefix)
    {
        if (prefix) sender.sendMessage(format(Configurations.OPTIONS_CHAT_PREFIX + message));
        else sender.sendMessage(format(message));
    }

    public static void help(CommandSender sender, int page)
    {
        switch (page)
        {
            case 1:
            {
                message(sender, "&7&m------------------=&7[ &bDeath Effects &7]&7&m=------------------", false);
                message(sender, "&b&l» &aDE USAGES &8- &7Lists out each command syntax", false);
                message(sender, "&b&l» &eDE SET &8- &7Give a player a death effect", false);
                message(sender, "&b&l» &eDE ADD &8- &7Give yourself a death effect", false);
                message(sender, "&b&l» &eDE REMOVE &8- &7Remove a player's death effect", false);
                message(sender, "&b&l» &eDE GUI &8- &7Opens the effects GUI", false);
                message(sender, "&b&l» &eDE EFFECTS &8- &7Displays text list of all effects", false);
                message(sender, "&b&l» &eDE RELOAD &8- &7Reloads the config.", false);
                message(sender, "&7&m----------------------------------------------------", false);
                break;
            }
            case 2:
            {
                message(sender, "&7&m-----------------=&7[ &bUsages &7]&7&m=-------------------------", false);
                message(sender, "&b&l» &eDE SET&8: &cREQUIRED (de.set)", false);
                message(sender, "&b&l• &7/de set (player) (effect)", false);
                message(sender, "&b&l» &eDE ADD&8: &cREQUIRED (de.add)", false);
                message(sender, "&b&l• &7/de add (effect)", false);
                message(sender, "&b&l» &eDE REMOVE&8: &cREQUIRED (de.remove)", false);
                message(sender, "&b&l• &7/de remove | /de remove (player)", false);
                message(sender, "&b&l» &eDE GUI&8:", false);
                message(sender, "&b&l• &7/de gui", false);
                message(sender, "&b&l» &eDE EFFECTS&8:", false);
                message(sender, "&b&l• &7/de effects", false);
                message(sender, "&b&l» &eDE RELOAD&8: &cREQUIRED (de.admin)", false);
                message(sender, "&b&l• &7/de reload", false);
                message(sender, "&7&m----------------------------------------------------", false);
                break;
            }
        }
    }

    public static void usages(CommandSender sender, String command)
    {
        switch (command)
        {
            case "set":
            {
                message(sender, "&cUSAGE: /de set (player) (effect)", false);
                break;
            }
            case "add":
            {
                message(sender, "&cUSAGE: /de add (effect)", false);
                break;
            }
        }
    }

    public static void effects(CommandSender sender)
    {
        message(sender, "&aEffects: &7Firework&a, &8Barrier&a, &7Cloud&a, &8Critical&a, &7Magic&a, &8Lava&a, &7Water&a, &8Enchantment&a, " +
                "&7SmallExplosion&a, &8MediumExplosion&a, &7LargeExplosion&a, &8Spark&a, &7Flame&a, &8Heart&a, &7LavaPop&a, &8Note&a, &7Portal&a, " +
                "&8Redstone&a, &7Slime&a, &8SmallSmoke&a, &7LargeSmoke&a, &8Spell&a, &7Snow&a, &8HappyVillager&a, &7AngryVillager&a, &8Splash", false);
    }
}
