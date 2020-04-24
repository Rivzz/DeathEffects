package com.mtjanney.deatheffects.commands;

import com.mtjanney.deatheffects.handlers.InventoryHandler;
import com.mtjanney.deatheffects.util.MessageUtil;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Command_DeathEffects implements CommandExecutor
{
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
    {
        if (!command.getName().equals("deatheffects") || !(sender instanceof Player)) return false;

        Player player = (Player) sender;

        if (args.length == 0) MessageUtil.help(player, 1);
        else if (args.length == 1)
        {
            if (args[0].equalsIgnoreCase("gui"))
            {
                player.playSound(player.getLocation(), Sound.CHEST_OPEN, 2F, 1F);
                player.openInventory(InventoryHandler.mainMenu(1));
            }
        }
        else
            MessageUtil.help(player, 1);

        return false;
    }
}
