package com.mtjanney.deatheffects.commands;

import com.mtjanney.deatheffects.DeathEffects;
import com.mtjanney.deatheffects.config.Configurations;
import com.mtjanney.deatheffects.config.PlayerData;
import com.mtjanney.deatheffects.handlers.InventoryHandler;
import com.mtjanney.deatheffects.util.MessageUtil;
import com.mtjanney.deatheffects.util.Permissions;
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
            else if (args[0].equalsIgnoreCase("reload"))
            {
                if (!player.hasPermission(Permissions.ADMIN))
                {
                    MessageUtil.message(player, MessageUtil.NO_PERMISSION);

                    return false;
                }

                new Configurations(DeathEffects.getInstance());

                MessageUtil.message(player, "&7Reloaded &bDeath Effects &e" + DeathEffects.getInstance().getDescription().getVersion());
            }
            else
                MessageUtil.help(player, 1);
        }
        else
            MessageUtil.help(player, 1);

        return false;
    }
}
