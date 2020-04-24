package com.mtjanney.deatheffects.util;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import java.util.ArrayList;
import java.util.List;

public class MessageUtil
{
    public static String NO_PERMISSION = "You don't have the required permission.";

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

    public static void message(CommandSender sender, String message)
    {
        sender.sendMessage(format(message));
    }

    public static void help(CommandSender sender, int page)
    {
        switch (page)
        {
            case 1:
            {
                message(sender, "&7&m------------------=&7[ &bDeath Effects &7]&7&m=------------------");
                message(sender, "&b&l» &aDE USAGES &8- &7Lists out each command syntax");
                message(sender, "&b&l» &eDE SET &8- &7Give a player a death effect");
                message(sender, "&b&l» &eDE GIVE &8- &7Give yourself a death effect");
                message(sender, "&b&l» &eDE REMOVE &8- &7Remove a player's death effect");
                message(sender, "&b&l» &eDE GUI &8- &7Opens the effects GUI");
                message(sender, "&b&l» &eDE EFFECTS &8- &7Displays text list of all effects");
                message(sender, "&b&l» &eDE COLORS &8- &7Displays a list of all firework colors");
                message(sender, "&7&m----------------------------------------------------");
                break;
            }
            case 2:
            {
                message(sender, "&7&m-----------------=&7[ &bUsages &7]&7&m=-----------------");
                message(sender, "&b&l» &eDE SET&8: &cREQUIRED (de.set)");
                message(sender, "&b&l• &7/de set (player) (effect) (fireworkcolor) (fireworktype)");
                message(sender, "&b&l» &eDE ADD&8:");
                message(sender, "&b&l• &7/de add (effect) (fireworkcolor) (fireworktype)");
                message(sender, "&b&l» &eDE REMOVE SELF&8:");
                message(sender, "&b&l• &7/de remove");
                message(sender, "&b&l» &eDE REMOVE OTHER&8:");
                message(sender, "&b&l• &7/de remove (player)");
                message(sender, "&b&l» &eDE GUI&8:");
                message(sender, "&b&l• &7/de gui");
                message(sender, "&b&l» &eDE EFFECTS&8:");
                message(sender, "&b&l• &7/de effects");
                message(sender, "&b&l» &eDE COLORS&8:");
                message(sender, "&b&l• &7/de colors");
                message(sender, "&7&m----------------------------------------------------");
                break;
            }
        }
    }
}
