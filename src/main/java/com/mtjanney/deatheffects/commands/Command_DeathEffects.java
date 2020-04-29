package com.mtjanney.deatheffects.commands;

import com.mtjanney.deatheffects.DeathEffects;
import com.mtjanney.deatheffects.config.Configurations;
import com.mtjanney.deatheffects.config.Language;
import com.mtjanney.deatheffects.config.PlayerData;
import com.mtjanney.deatheffects.handlers.InventoryHandler;
import com.mtjanney.deatheffects.util.MessageUtil;
import com.mtjanney.deatheffects.util.Permissions;
import com.mtjanney.deatheffects.util.PlayerWrapper;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
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
                    MessageUtil.message(player, Language.GENERAL_NO_PERMISSION, true);

                    return false;
                }

                new Configurations(DeathEffects.getInstance());
                new Language(DeathEffects.getInstance());

                MessageUtil.message(player, "&7Reloaded &bDeath Effects &e" + DeathEffects.getInstance().getDescription().getVersion(), true);
            }
            else if (args[0].equalsIgnoreCase("remove"))
            {
                if (!player.hasPermission(Permissions.REMOVE))
                {
                    MessageUtil.message(player, Language.GENERAL_NO_PERMISSION, true);

                    return false;
                }

                if (!PlayerData.exists(player.getUniqueId()))
                {
                    MessageUtil.message(player, Language.EFFECT_NO_ACTIVE, true);

                    return false;
                }

                PlayerWrapper wrapper = PlayerData.loadWrapper(player.getUniqueId());

                if (wrapper.getDeathEffect().equalsIgnoreCase("NONE"))
                {
                    MessageUtil.message(player, Language.EFFECT_NO_ACTIVE, true);

                    return false;
                }

                wrapper.setDeathEffect("NONE");

                PlayerData.create(player.getUniqueId(), wrapper);

                player.playSound(player.getLocation(), Configurations.SOUNDS_REMOVE, 2F, 1F);

                MessageUtil.message(player, Language.EFFECT_REMOVE_SELF, true);
            }
            else if (args[0].equalsIgnoreCase("usages")) MessageUtil.help(player, 2);
            else if (args[0].equalsIgnoreCase("effects")) MessageUtil.effects(player);
            else if (args[0].equalsIgnoreCase("set")) MessageUtil.usages(player, "set");
            else if (args[0].equalsIgnoreCase("add")) MessageUtil.usages(player, "add");
            else
                MessageUtil.help(player, 1);
        }
        else if (args.length == 2)
        {
            if (args[0].equalsIgnoreCase("remove"))
            {
                if (!player.hasPermission(Permissions.REMOVE))
                {
                    MessageUtil.message(player, Language.GENERAL_NO_PERMISSION, true);

                    return false;
                }

                if (!PlayerData.exists(Bukkit.getOfflinePlayer(args[1]).getUniqueId()))
                {
                    MessageUtil.message(player, Language.EFFECT_NO_ACTIVE_OTHER, true);

                    return false;
                }

                OfflinePlayer offlinePlayer = Bukkit.getOfflinePlayer(args[1]);

                PlayerWrapper wrapper = PlayerData.loadWrapper(offlinePlayer.getUniqueId());

                if (wrapper.getDeathEffect().equalsIgnoreCase("NONE"))
                {
                    MessageUtil.message(player, Language.EFFECT_NO_ACTIVE_OTHER, true);

                    return false;
                }

                wrapper.setDeathEffect("NONE");

                PlayerData.create(player.getUniqueId(), wrapper);

                MessageUtil.message(player, Language.EFFECT_REMOVE_OTHER.replace("%Player%", offlinePlayer.getName()), true);

                if (offlinePlayer.isOnline())
                {
                    MessageUtil.message(Bukkit.getPlayer(args[1]), Language.EFFECT_REMOVE_FROM_OTHER, true);

                    player.playSound(Bukkit.getPlayer(args[1]).getLocation(), Configurations.SOUNDS_REMOVE, 2F, 1F);
                }
            }
            else if (args[0].equalsIgnoreCase("add"))
            {
                if (!player.hasPermission(Permissions.ADD))
                {
                    MessageUtil.message(player, Language.GENERAL_NO_PERMISSION, true);

                    return false;
                }

                switch (args[1].toLowerCase())
                {
                    case "firework":
                    {
                        if (!player.hasPermission(Permissions.FIREWORK) && !player.hasPermission(Permissions.ALL_PARTICLES))
                        {
                            MessageUtil.message(player, Language.GENERAL_NO_PERMISSION, true);

                            return false;
                        }

                        PlayerWrapper wrapper;
                        if (PlayerData.exists(player.getUniqueId())) wrapper = PlayerData.loadWrapper(player.getUniqueId());
                        else wrapper = new PlayerWrapper();

                        wrapper.setDeathEffect("FIREWORK");

                        PlayerData.create(player.getUniqueId(), wrapper);

                        player.playSound(player.getLocation(), Configurations.SOUNDS_ADD, 2F, 1F);

                        MessageUtil.message(player, Language.EFFECT_EQUIP_SELF.replace("%Effect%", "Firework"), true);

                        break;
                    }
                    case "barrier":
                    {
                        if (!player.hasPermission(Permissions.BARRIER) && !player.hasPermission(Permissions.ALL_PARTICLES))
                        {
                            MessageUtil.message(player, Language.GENERAL_NO_PERMISSION, true);

                            return false;
                        }

                        PlayerWrapper wrapper;
                        if (PlayerData.exists(player.getUniqueId())) wrapper = PlayerData.loadWrapper(player.getUniqueId());
                        else wrapper = new PlayerWrapper();

                        wrapper.setDeathEffect("BARRIER");

                        PlayerData.create(player.getUniqueId(), wrapper);

                        player.playSound(player.getLocation(), Configurations.SOUNDS_ADD, 2F, 1F);

                        MessageUtil.message(player, Language.EFFECT_EQUIP_SELF.replace("%Effect%", "Barrier"), true);

                        break;
                    }
                    case "cloud":
                    {
                        if (!player.hasPermission(Permissions.CLOUD) && !player.hasPermission(Permissions.ALL_PARTICLES))
                        {
                            MessageUtil.message(player, Language.GENERAL_NO_PERMISSION, true);

                            return false;
                        }

                        PlayerWrapper wrapper;
                        if (PlayerData.exists(player.getUniqueId())) wrapper = PlayerData.loadWrapper(player.getUniqueId());
                        else wrapper = new PlayerWrapper();

                        wrapper.setDeathEffect("CLOUD");

                        PlayerData.create(player.getUniqueId(), wrapper);

                        player.playSound(player.getLocation(), Configurations.SOUNDS_ADD, 2F, 1F);

                        MessageUtil.message(player, Language.EFFECT_EQUIP_SELF.replace("%Effect%", "Cloud"), true);

                        break;
                    }
                    case "critical":
                    {
                        if (!player.hasPermission(Permissions.CRITICAL) && !player.hasPermission(Permissions.ALL_PARTICLES))
                        {
                            MessageUtil.message(player, Language.GENERAL_NO_PERMISSION, true);

                            return false;
                        }

                        PlayerWrapper wrapper;
                        if (PlayerData.exists(player.getUniqueId())) wrapper = PlayerData.loadWrapper(player.getUniqueId());
                        else wrapper = new PlayerWrapper();

                        wrapper.setDeathEffect("CRITICAL");

                        PlayerData.create(player.getUniqueId(), wrapper);

                        player.playSound(player.getLocation(), Configurations.SOUNDS_ADD, 2F, 1F);

                        MessageUtil.message(player, Language.EFFECT_EQUIP_SELF.replace("%Effect%", "Critical"), true);

                        break;
                    }
                    case "magic":
                    {
                        if (!player.hasPermission(Permissions.CRITICAL_MAGIC) && !player.hasPermission(Permissions.ALL_PARTICLES))
                        {
                            MessageUtil.message(player, Language.GENERAL_NO_PERMISSION, true);

                            return false;
                        }

                        PlayerWrapper wrapper;
                        if (PlayerData.exists(player.getUniqueId())) wrapper = PlayerData.loadWrapper(player.getUniqueId());
                        else wrapper = new PlayerWrapper();

                        wrapper.setDeathEffect("MAGIC");

                        PlayerData.create(player.getUniqueId(), wrapper);

                        player.playSound(player.getLocation(), Configurations.SOUNDS_ADD, 2F, 1F);

                        MessageUtil.message(player, Language.EFFECT_EQUIP_SELF.replace("%Effect%", "Magic"), true);

                        break;
                    }
                    case "lava":
                    {
                        if (!player.hasPermission(Permissions.LAVA) && !player.hasPermission(Permissions.ALL_PARTICLES))
                        {
                            MessageUtil.message(player, Language.GENERAL_NO_PERMISSION, true);

                            return false;
                        }

                        PlayerWrapper wrapper;
                        if (PlayerData.exists(player.getUniqueId())) wrapper = PlayerData.loadWrapper(player.getUniqueId());
                        else wrapper = new PlayerWrapper();

                        wrapper.setDeathEffect("LAVA");

                        PlayerData.create(player.getUniqueId(), wrapper);

                        player.playSound(player.getLocation(), Configurations.SOUNDS_ADD, 2F, 1F);

                        MessageUtil.message(player, Language.EFFECT_EQUIP_SELF.replace("%Effect%", "Lava"), true);

                        break;
                    }
                    case "water":
                    {
                        if (!player.hasPermission(Permissions.WATER) && !player.hasPermission(Permissions.ALL_PARTICLES))
                        {
                            MessageUtil.message(player, Language.GENERAL_NO_PERMISSION, true);

                            return false;
                        }

                        PlayerWrapper wrapper;
                        if (PlayerData.exists(player.getUniqueId())) wrapper = PlayerData.loadWrapper(player.getUniqueId());
                        else wrapper = new PlayerWrapper();

                        wrapper.setDeathEffect("WATER");

                        PlayerData.create(player.getUniqueId(), wrapper);

                        player.playSound(player.getLocation(), Configurations.SOUNDS_ADD, 2F, 1F);

                        MessageUtil.message(player, Language.EFFECT_EQUIP_SELF.replace("%Effect%", "Water"), true);

                        break;
                    }
                    case "enchantment":
                    {
                        if (!player.hasPermission(Permissions.ENCHANTMENT) && !player.hasPermission(Permissions.ALL_PARTICLES))
                        {
                            MessageUtil.message(player, Language.GENERAL_NO_PERMISSION, true);

                            return false;
                        }

                        PlayerWrapper wrapper;
                        if (PlayerData.exists(player.getUniqueId())) wrapper = PlayerData.loadWrapper(player.getUniqueId());
                        else wrapper = new PlayerWrapper();

                        wrapper.setDeathEffect("ENCHANTMENT");

                        PlayerData.create(player.getUniqueId(), wrapper);

                        player.playSound(player.getLocation(), Configurations.SOUNDS_ADD, 2F, 1F);

                        MessageUtil.message(player, Language.EFFECT_EQUIP_SELF.replace("%Effect%", "Enchantment"), true);

                        break;
                    }
                    case "smallexplosion":
                    {
                        if (!player.hasPermission(Permissions.EXPLOSION_SMALL) && !player.hasPermission(Permissions.ALL_PARTICLES))
                        {
                            MessageUtil.message(player, Language.GENERAL_NO_PERMISSION, true);

                            return false;
                        }

                        PlayerWrapper wrapper;
                        if (PlayerData.exists(player.getUniqueId())) wrapper = PlayerData.loadWrapper(player.getUniqueId());
                        else wrapper = new PlayerWrapper();

                        wrapper.setDeathEffect("EXPLOSION-SMALL");

                        PlayerData.create(player.getUniqueId(), wrapper);

                        player.playSound(player.getLocation(), Configurations.SOUNDS_ADD, 2F, 1F);

                        MessageUtil.message(player, Language.EFFECT_EQUIP_SELF.replace("%Effect%", "Small Explosion"), true);

                        break;
                    }
                    case "mediumexplosion":
                    {
                        if (!player.hasPermission(Permissions.EXPLOSION_MEDIUM) && !player.hasPermission(Permissions.ALL_PARTICLES))
                        {
                            MessageUtil.message(player, Language.GENERAL_NO_PERMISSION, true);

                            return false;
                        }

                        PlayerWrapper wrapper;
                        if (PlayerData.exists(player.getUniqueId())) wrapper = PlayerData.loadWrapper(player.getUniqueId());
                        else wrapper = new PlayerWrapper();

                        wrapper.setDeathEffect("EXPLOSION-MEDIUM");

                        PlayerData.create(player.getUniqueId(), wrapper);

                        player.playSound(player.getLocation(), Configurations.SOUNDS_ADD, 2F, 1F);

                        MessageUtil.message(player, Language.EFFECT_EQUIP_SELF.replace("%Effect%", "Medium Explosion"), true);

                        break;
                    }
                    case "largeexplosion":
                    {
                        if (!player.hasPermission(Permissions.EXPLOSION_LARGE) && !player.hasPermission(Permissions.ALL_PARTICLES))
                        {
                            MessageUtil.message(player, Language.GENERAL_NO_PERMISSION, true);

                            return false;
                        }

                        PlayerWrapper wrapper;
                        if (PlayerData.exists(player.getUniqueId())) wrapper = PlayerData.loadWrapper(player.getUniqueId());
                        else wrapper = new PlayerWrapper();

                        wrapper.setDeathEffect("EXPLOSION-LARGE");

                        PlayerData.create(player.getUniqueId(), wrapper);

                        player.playSound(player.getLocation(), Configurations.SOUNDS_ADD, 2F, 1F);

                        MessageUtil.message(player, Language.EFFECT_EQUIP_SELF.replace("%Effect%", "Large Explosion"), true);

                        break;
                    }
                    case "spark":
                    {
                        if (!player.hasPermission(Permissions.SPARK) && !player.hasPermission(Permissions.ALL_PARTICLES))
                        {
                            MessageUtil.message(player, Language.GENERAL_NO_PERMISSION, true);

                            return false;
                        }

                        PlayerWrapper wrapper;
                        if (PlayerData.exists(player.getUniqueId())) wrapper = PlayerData.loadWrapper(player.getUniqueId());
                        else wrapper = new PlayerWrapper();

                        wrapper.setDeathEffect("SPARK");

                        PlayerData.create(player.getUniqueId(), wrapper);

                        player.playSound(player.getLocation(), Configurations.SOUNDS_ADD, 2F, 1F);

                        MessageUtil.message(player, Language.EFFECT_EQUIP_SELF.replace("%Effect%", "Spark"), true);

                        break;
                    }
                    case "flame":
                    {
                        if (!player.hasPermission(Permissions.FLAME) && !player.hasPermission(Permissions.ALL_PARTICLES))
                        {
                            MessageUtil.message(player, Language.GENERAL_NO_PERMISSION, true);

                            return false;
                        }

                        PlayerWrapper wrapper;
                        if (PlayerData.exists(player.getUniqueId())) wrapper = PlayerData.loadWrapper(player.getUniqueId());
                        else wrapper = new PlayerWrapper();

                        wrapper.setDeathEffect("FLAME");

                        PlayerData.create(player.getUniqueId(), wrapper);

                        player.playSound(player.getLocation(), Configurations.SOUNDS_ADD, 2F, 1F);

                        MessageUtil.message(player, Language.EFFECT_EQUIP_SELF.replace("%Effect%", "Flame"), true);

                        break;
                    }
                    case "heart":
                    {
                        if (!player.hasPermission(Permissions.HEART) && !player.hasPermission(Permissions.ALL_PARTICLES))
                        {
                            MessageUtil.message(player, Language.GENERAL_NO_PERMISSION, true);

                            return false;
                        }

                        PlayerWrapper wrapper;
                        if (PlayerData.exists(player.getUniqueId())) wrapper = PlayerData.loadWrapper(player.getUniqueId());
                        else wrapper = new PlayerWrapper();

                        wrapper.setDeathEffect("HEART");

                        PlayerData.create(player.getUniqueId(), wrapper);

                        player.playSound(player.getLocation(), Configurations.SOUNDS_ADD, 2F, 1F);

                        MessageUtil.message(player, Language.EFFECT_EQUIP_SELF.replace("%Effect%", "Heart"), true);

                        break;
                    }
                    case "lavapop":
                    {
                        if (!player.hasPermission(Permissions.LAVA_POP) && !player.hasPermission(Permissions.ALL_PARTICLES))
                        {
                            MessageUtil.message(player, Language.GENERAL_NO_PERMISSION, true);

                            return false;
                        }

                        PlayerWrapper wrapper;
                        if (PlayerData.exists(player.getUniqueId())) wrapper = PlayerData.loadWrapper(player.getUniqueId());
                        else wrapper = new PlayerWrapper();

                        wrapper.setDeathEffect("LAVA-POP");

                        PlayerData.create(player.getUniqueId(), wrapper);

                        player.playSound(player.getLocation(), Configurations.SOUNDS_ADD, 2F, 1F);

                        MessageUtil.message(player, Language.EFFECT_EQUIP_SELF.replace("%Effect%", "Lava Pop"), true);

                        break;
                    }
                    case "note":
                    {
                        if (!player.hasPermission(Permissions.NOTE) && !player.hasPermission(Permissions.ALL_PARTICLES))
                        {
                            MessageUtil.message(player, Language.GENERAL_NO_PERMISSION, true);

                            return false;
                        }

                        PlayerWrapper wrapper;
                        if (PlayerData.exists(player.getUniqueId())) wrapper = PlayerData.loadWrapper(player.getUniqueId());
                        else wrapper = new PlayerWrapper();

                        wrapper.setDeathEffect("NOTE");

                        PlayerData.create(player.getUniqueId(), wrapper);

                        player.playSound(player.getLocation(), Configurations.SOUNDS_ADD, 2F, 1F);

                        MessageUtil.message(player, Language.EFFECT_EQUIP_SELF.replace("%Effect%", "Note"), true);

                        break;
                    }
                    case "portal":
                    {
                        if (!player.hasPermission(Permissions.PORTAL) && !player.hasPermission(Permissions.ALL_PARTICLES))
                        {
                            MessageUtil.message(player, Language.GENERAL_NO_PERMISSION, true);

                            return false;
                        }

                        PlayerWrapper wrapper;
                        if (PlayerData.exists(player.getUniqueId())) wrapper = PlayerData.loadWrapper(player.getUniqueId());
                        else wrapper = new PlayerWrapper();

                        wrapper.setDeathEffect("PORTAL");

                        PlayerData.create(player.getUniqueId(), wrapper);

                        player.playSound(player.getLocation(), Configurations.SOUNDS_ADD, 2F, 1F);

                        MessageUtil.message(player, Language.EFFECT_EQUIP_SELF.replace("%Effect%", "Portal"), true);

                        break;
                    }
                    case "redstone":
                    {
                        if (!player.hasPermission(Permissions.REDSTONE) && !player.hasPermission(Permissions.ALL_PARTICLES))
                        {
                            MessageUtil.message(player, Language.GENERAL_NO_PERMISSION, true);

                            return false;
                        }

                        PlayerWrapper wrapper;
                        if (PlayerData.exists(player.getUniqueId())) wrapper = PlayerData.loadWrapper(player.getUniqueId());
                        else wrapper = new PlayerWrapper();

                        wrapper.setDeathEffect("REDSTONE");

                        PlayerData.create(player.getUniqueId(), wrapper);

                        player.playSound(player.getLocation(), Configurations.SOUNDS_ADD, 2F, 1F);

                        MessageUtil.message(player, Language.EFFECT_EQUIP_SELF.replace("%Effect%", "Redstone"), true);

                        break;
                    }
                    case "slime":
                    {
                        if (!player.hasPermission(Permissions.SLIME) && !player.hasPermission(Permissions.ALL_PARTICLES))
                        {
                            MessageUtil.message(player, Language.GENERAL_NO_PERMISSION, true);

                            return false;
                        }

                        PlayerWrapper wrapper;
                        if (PlayerData.exists(player.getUniqueId())) wrapper = PlayerData.loadWrapper(player.getUniqueId());
                        else wrapper = new PlayerWrapper();

                        wrapper.setDeathEffect("SLIME");

                        PlayerData.create(player.getUniqueId(), wrapper);

                        player.playSound(player.getLocation(), Configurations.SOUNDS_ADD, 2F, 1F);

                        MessageUtil.message(player, Language.EFFECT_EQUIP_SELF.replace("%Effect%", "Slime"), true);

                        break;
                    }
                    case "smallsmoke":
                    {
                        if (!player.hasPermission(Permissions.SMOKE_SMALL) && !player.hasPermission(Permissions.ALL_PARTICLES))
                        {
                            MessageUtil.message(player, Language.GENERAL_NO_PERMISSION, true);

                            return false;
                        }

                        PlayerWrapper wrapper;
                        if (PlayerData.exists(player.getUniqueId())) wrapper = PlayerData.loadWrapper(player.getUniqueId());
                        else wrapper = new PlayerWrapper();

                        wrapper.setDeathEffect("SMOKE-SMALL");

                        PlayerData.create(player.getUniqueId(), wrapper);

                        player.playSound(player.getLocation(), Configurations.SOUNDS_ADD, 2F, 1F);

                        MessageUtil.message(player, Language.EFFECT_EQUIP_SELF.replace("%Effect%", "Small Smoke"), true);

                        break;
                    }
                    case "largesmoke":
                    {
                        if (!player.hasPermission(Permissions.SMOKE_LARGE) && !player.hasPermission(Permissions.ALL_PARTICLES))
                        {
                            MessageUtil.message(player, Language.GENERAL_NO_PERMISSION, true);

                            return false;
                        }

                        PlayerWrapper wrapper;
                        if (PlayerData.exists(player.getUniqueId())) wrapper = PlayerData.loadWrapper(player.getUniqueId());
                        else wrapper = new PlayerWrapper();

                        wrapper.setDeathEffect("SMOKE-LARGE");

                        PlayerData.create(player.getUniqueId(), wrapper);

                        player.playSound(player.getLocation(), Configurations.SOUNDS_ADD, 2F, 1F);

                        MessageUtil.message(player, Language.EFFECT_EQUIP_SELF.replace("%Effect%", "Large Smoke"), true);

                        break;
                    }
                    case "spell":
                    {
                        if (!player.hasPermission(Permissions.SPELL) && !player.hasPermission(Permissions.ALL_PARTICLES))
                        {
                            MessageUtil.message(player, Language.GENERAL_NO_PERMISSION, true);

                            return false;
                        }

                        PlayerWrapper wrapper;
                        if (PlayerData.exists(player.getUniqueId())) wrapper = PlayerData.loadWrapper(player.getUniqueId());
                        else wrapper = new PlayerWrapper();

                        wrapper.setDeathEffect("SPELL");

                        PlayerData.create(player.getUniqueId(), wrapper);

                        player.playSound(player.getLocation(), Configurations.SOUNDS_ADD, 2F, 1F);

                        MessageUtil.message(player, Language.EFFECT_EQUIP_SELF.replace("%Effect%", "Spell"), true);

                        break;
                    }
                    case "snow":
                    {
                        if (!player.hasPermission(Permissions.SNOW) && !player.hasPermission(Permissions.ALL_PARTICLES))
                        {
                            MessageUtil.message(player, Language.GENERAL_NO_PERMISSION, true);

                            return false;
                        }

                        PlayerWrapper wrapper;
                        if (PlayerData.exists(player.getUniqueId())) wrapper = PlayerData.loadWrapper(player.getUniqueId());
                        else wrapper = new PlayerWrapper();

                        wrapper.setDeathEffect("SNOW");

                        PlayerData.create(player.getUniqueId(), wrapper);

                        player.playSound(player.getLocation(), Configurations.SOUNDS_ADD, 2F, 1F);

                        MessageUtil.message(player, Language.EFFECT_EQUIP_SELF.replace("%Effect%", "Snow"), true);

                        break;
                    }
                    case "happyvillager":
                    {
                        if (!player.hasPermission(Permissions.HAPPY_VILLAGER) && !player.hasPermission(Permissions.ALL_PARTICLES))
                        {
                            MessageUtil.message(player, Language.GENERAL_NO_PERMISSION, true);

                            return false;
                        }

                        PlayerWrapper wrapper;
                        if (PlayerData.exists(player.getUniqueId())) wrapper = PlayerData.loadWrapper(player.getUniqueId());
                        else wrapper = new PlayerWrapper();

                        wrapper.setDeathEffect("HAPPY-VILLAGER");

                        PlayerData.create(player.getUniqueId(), wrapper);

                        player.playSound(player.getLocation(), Configurations.SOUNDS_ADD, 2F, 1F);

                        MessageUtil.message(player, Language.EFFECT_EQUIP_SELF.replace("%Effect%", "Happy Villager"), true);

                        break;
                    }
                    case "angryvillager":
                    {
                        if (!player.hasPermission(Permissions.ANGRY_VILLAGER) && !player.hasPermission(Permissions.ALL_PARTICLES))
                        {
                            MessageUtil.message(player, Language.GENERAL_NO_PERMISSION, true);

                            return false;
                        }

                        PlayerWrapper wrapper;
                        if (PlayerData.exists(player.getUniqueId())) wrapper = PlayerData.loadWrapper(player.getUniqueId());
                        else wrapper = new PlayerWrapper();

                        wrapper.setDeathEffect("ANGRY-VILLAGER");

                        PlayerData.create(player.getUniqueId(), wrapper);

                        player.playSound(player.getLocation(), Configurations.SOUNDS_ADD, 2F, 1F);

                        MessageUtil.message(player, Language.EFFECT_EQUIP_SELF.replace("%Effect%", "Angry Villager"), true);

                        break;
                    }
                    case "splash":
                    {
                        if (!player.hasPermission(Permissions.SPLASH) && !player.hasPermission(Permissions.ALL_PARTICLES))
                        {
                            MessageUtil.message(player, Language.GENERAL_NO_PERMISSION, true);

                            return false;
                        }

                        PlayerWrapper wrapper;
                        if (PlayerData.exists(player.getUniqueId())) wrapper = PlayerData.loadWrapper(player.getUniqueId());
                        else wrapper = new PlayerWrapper();

                        wrapper.setDeathEffect("SPLASH");

                        PlayerData.create(player.getUniqueId(), wrapper);

                        player.playSound(player.getLocation(), Configurations.SOUNDS_ADD, 2F, 1F);

                        MessageUtil.message(player, Language.EFFECT_EQUIP_SELF.replace("%Effect%", "Splash"), true);

                        break;
                    }
                    default:
                    {
                        MessageUtil.effects(player);
                    }
                }
            }
            else
                MessageUtil.help(player, 1);
        }
        else if (args.length == 3)
        {
            if (args[0].equalsIgnoreCase("set"))
            {
                if (!player.hasPermission(Permissions.SET))
                {
                    MessageUtil.message(player, Language.GENERAL_NO_PERMISSION, true);

                    return false;
                }

                if (!Bukkit.getOfflinePlayer(args[1]).isOnline())
                {
                    MessageUtil.message(player, Language.GENERAL_ERROR_OFFLINE, true);

                    return false;
                }

                Player target = Bukkit.getPlayer(args[1]);

                switch (args[2].toLowerCase())
                {
                    case "firework":
                    {
                        if (!player.hasPermission(Permissions.FIREWORK) && !player.hasPermission(Permissions.ALL_PARTICLES))
                        {
                            MessageUtil.message(player, Language.GENERAL_NO_PERMISSION, true);

                            return false;
                        }

                        PlayerWrapper wrapper;
                        if (PlayerData.exists(target.getUniqueId())) wrapper = PlayerData.loadWrapper(target.getUniqueId());
                        else wrapper = new PlayerWrapper();

                        wrapper.setDeathEffect("FIREWORK");

                        PlayerData.create(target.getUniqueId(), wrapper);

                        target.playSound(target.getLocation(), Configurations.SOUNDS_ADD, 2F, 1F);

                        MessageUtil.message(target, Language.EFFECT_EQUIP_FROM_OTHER.replace("%Effect%", "Firework"), true);

                        MessageUtil.message(player, Language.EFFECT_EQUIP_OTHER
                                .replace("%Player%", target.getName())
                                .replace("%Effect%", "Firework"), true);

                        break;
                    }
                    case "barrier":
                    {
                        if (!player.hasPermission(Permissions.BARRIER) && !player.hasPermission(Permissions.ALL_PARTICLES))
                        {
                            MessageUtil.message(player, Language.GENERAL_NO_PERMISSION, true);

                            return false;
                        }

                        PlayerWrapper wrapper;
                        if (PlayerData.exists(target.getUniqueId())) wrapper = PlayerData.loadWrapper(target.getUniqueId());
                        else wrapper = new PlayerWrapper();

                        wrapper.setDeathEffect("BARRIER");

                        PlayerData.create(target.getUniqueId(), wrapper);

                        target.playSound(target.getLocation(), Configurations.SOUNDS_ADD, 2F, 1F);

                        MessageUtil.message(target, Language.EFFECT_EQUIP_FROM_OTHER.replace("%Effect%", "Barrier"), true);

                        MessageUtil.message(player, Language.EFFECT_EQUIP_OTHER
                                .replace("%Player%", target.getName())
                                .replace("%Effect%", "Barrier"), true);

                        break;
                    }
                    case "cloud":
                    {
                        if (!player.hasPermission(Permissions.CLOUD) && !player.hasPermission(Permissions.ALL_PARTICLES))
                        {
                            MessageUtil.message(player, Language.GENERAL_NO_PERMISSION, true);

                            return false;
                        }

                        PlayerWrapper wrapper;
                        if (PlayerData.exists(target.getUniqueId())) wrapper = PlayerData.loadWrapper(target.getUniqueId());
                        else wrapper = new PlayerWrapper();

                        wrapper.setDeathEffect("CLOUD");

                        PlayerData.create(target.getUniqueId(), wrapper);

                        target.playSound(target.getLocation(), Configurations.SOUNDS_ADD, 2F, 1F);

                        MessageUtil.message(target, Language.EFFECT_EQUIP_FROM_OTHER.replace("%Effect%", "Cloud"), true);

                        MessageUtil.message(player, Language.EFFECT_EQUIP_OTHER
                                .replace("%Player%", target.getName())
                                .replace("%Effect%", "Cloud"), true);

                        break;
                    }
                    case "critical":
                    {
                        if (!player.hasPermission(Permissions.CRITICAL) && !player.hasPermission(Permissions.ALL_PARTICLES))
                        {
                            MessageUtil.message(player, Language.GENERAL_NO_PERMISSION, true);

                            return false;
                        }

                        PlayerWrapper wrapper;
                        if (PlayerData.exists(target.getUniqueId())) wrapper = PlayerData.loadWrapper(target.getUniqueId());
                        else wrapper = new PlayerWrapper();

                        wrapper.setDeathEffect("CRITICAL");

                        PlayerData.create(target.getUniqueId(), wrapper);

                        target.playSound(target.getLocation(), Configurations.SOUNDS_ADD, 2F, 1F);

                        MessageUtil.message(target, Language.EFFECT_EQUIP_FROM_OTHER.replace("%Effect%", "Critical"), true);

                        MessageUtil.message(player, Language.EFFECT_EQUIP_OTHER
                                .replace("%Player%", target.getName())
                                .replace("%Effect%", "Critical"), true);

                        break;
                    }
                    case "magic":
                    {
                        if (!player.hasPermission(Permissions.CRITICAL_MAGIC) && !player.hasPermission(Permissions.ALL_PARTICLES))
                        {
                            MessageUtil.message(player, Language.GENERAL_NO_PERMISSION, true);

                            return false;
                        }

                        PlayerWrapper wrapper;
                        if (PlayerData.exists(target.getUniqueId())) wrapper = PlayerData.loadWrapper(target.getUniqueId());
                        else wrapper = new PlayerWrapper();

                        wrapper.setDeathEffect("MAGIC");

                        PlayerData.create(target.getUniqueId(), wrapper);

                        target.playSound(target.getLocation(), Configurations.SOUNDS_ADD, 2F, 1F);

                        MessageUtil.message(target, Language.EFFECT_EQUIP_FROM_OTHER.replace("%Effect%", "Magic"), true);

                        MessageUtil.message(player, Language.EFFECT_EQUIP_OTHER
                                .replace("%Player%", target.getName())
                                .replace("%Effect%", "Magic"), true);

                        break;
                    }
                    case "lava":
                    {
                        if (!player.hasPermission(Permissions.LAVA) && !player.hasPermission(Permissions.ALL_PARTICLES))
                        {
                            MessageUtil.message(player, Language.GENERAL_NO_PERMISSION, true);

                            return false;
                        }

                        PlayerWrapper wrapper;
                        if (PlayerData.exists(target.getUniqueId())) wrapper = PlayerData.loadWrapper(target.getUniqueId());
                        else wrapper = new PlayerWrapper();

                        wrapper.setDeathEffect("LAVA");

                        PlayerData.create(target.getUniqueId(), wrapper);

                        target.playSound(target.getLocation(), Configurations.SOUNDS_ADD, 2F, 1F);

                        MessageUtil.message(target, Language.EFFECT_EQUIP_FROM_OTHER.replace("%Effect%", "Lava"), true);

                        MessageUtil.message(player, Language.EFFECT_EQUIP_OTHER
                                .replace("%Player%", target.getName())
                                .replace("%Effect%", "Lava"), true);

                        break;
                    }
                    case "water":
                    {
                        if (!player.hasPermission(Permissions.WATER) && !player.hasPermission(Permissions.ALL_PARTICLES))
                        {
                            MessageUtil.message(player, Language.GENERAL_NO_PERMISSION, true);

                            return false;
                        }

                        PlayerWrapper wrapper;
                        if (PlayerData.exists(target.getUniqueId())) wrapper = PlayerData.loadWrapper(target.getUniqueId());
                        else wrapper = new PlayerWrapper();

                        wrapper.setDeathEffect("WATER");

                        PlayerData.create(target.getUniqueId(), wrapper);

                        target.playSound(target.getLocation(), Configurations.SOUNDS_ADD, 2F, 1F);

                        MessageUtil.message(target, Language.EFFECT_EQUIP_FROM_OTHER.replace("%Effect%", "Water"), true);

                        MessageUtil.message(player, Language.EFFECT_EQUIP_OTHER
                                .replace("%Player%", target.getName())
                                .replace("%Effect%", "Water"), true);

                        break;
                    }
                    case "enchantment":
                    {
                        if (!player.hasPermission(Permissions.ENCHANTMENT) && !player.hasPermission(Permissions.ALL_PARTICLES))
                        {
                            MessageUtil.message(player, Language.GENERAL_NO_PERMISSION, true);

                            return false;
                        }

                        PlayerWrapper wrapper;
                        if (PlayerData.exists(target.getUniqueId())) wrapper = PlayerData.loadWrapper(target.getUniqueId());
                        else wrapper = new PlayerWrapper();

                        wrapper.setDeathEffect("ENCHANTMENT");

                        PlayerData.create(target.getUniqueId(), wrapper);

                        target.playSound(target.getLocation(), Configurations.SOUNDS_ADD, 2F, 1F);

                        MessageUtil.message(target, Language.EFFECT_EQUIP_FROM_OTHER.replace("%Effect%", "Enchantment"), true);

                        MessageUtil.message(player, Language.EFFECT_EQUIP_OTHER
                                .replace("%Player%", target.getName())
                                .replace("%Effect%", "Enchantment"), true);

                        break;
                    }
                    case "smallexplosion":
                    {
                        if (!player.hasPermission(Permissions.EXPLOSION_SMALL) && !player.hasPermission(Permissions.ALL_PARTICLES))
                        {
                            MessageUtil.message(player, Language.GENERAL_NO_PERMISSION, true);

                            return false;
                        }

                        PlayerWrapper wrapper;
                        if (PlayerData.exists(target.getUniqueId())) wrapper = PlayerData.loadWrapper(target.getUniqueId());
                        else wrapper = new PlayerWrapper();

                        wrapper.setDeathEffect("EXPLOSION-SMALL");

                        PlayerData.create(target.getUniqueId(), wrapper);

                        target.playSound(target.getLocation(), Configurations.SOUNDS_ADD, 2F, 1F);

                        MessageUtil.message(target, Language.EFFECT_EQUIP_FROM_OTHER.replace("%Effect%", "Small Explosion"), true);

                        MessageUtil.message(player, Language.EFFECT_EQUIP_OTHER
                                .replace("%Player%", target.getName())
                                .replace("%Effect%", "Small Explosion"), true);

                        break;
                    }
                    case "mediumexplosion":
                    {
                        if (!player.hasPermission(Permissions.EXPLOSION_MEDIUM) && !player.hasPermission(Permissions.ALL_PARTICLES))
                        {
                            MessageUtil.message(player, Language.GENERAL_NO_PERMISSION, true);

                            return false;
                        }

                        PlayerWrapper wrapper;
                        if (PlayerData.exists(target.getUniqueId())) wrapper = PlayerData.loadWrapper(target.getUniqueId());
                        else wrapper = new PlayerWrapper();

                        wrapper.setDeathEffect("EXPLOSION-MEDIUM");

                        PlayerData.create(target.getUniqueId(), wrapper);

                        target.playSound(target.getLocation(), Configurations.SOUNDS_ADD, 2F, 1F);

                        MessageUtil.message(target, Language.EFFECT_EQUIP_FROM_OTHER.replace("%Effect%", "Medium Explosion"), true);

                        MessageUtil.message(player, Language.EFFECT_EQUIP_OTHER
                                .replace("%Player%", target.getName())
                                .replace("%Effect%", "Medium Explosion"), true);

                        break;
                    }
                    case "largeexplosion":
                    {
                        if (!player.hasPermission(Permissions.EXPLOSION_LARGE) && !player.hasPermission(Permissions.ALL_PARTICLES))
                        {
                            MessageUtil.message(player, Language.GENERAL_NO_PERMISSION, true);

                            return false;
                        }

                        PlayerWrapper wrapper;
                        if (PlayerData.exists(target.getUniqueId())) wrapper = PlayerData.loadWrapper(target.getUniqueId());
                        else wrapper = new PlayerWrapper();

                        wrapper.setDeathEffect("EXPLOSION-LARGE");

                        PlayerData.create(target.getUniqueId(), wrapper);

                        target.playSound(target.getLocation(), Configurations.SOUNDS_ADD, 2F, 1F);

                        MessageUtil.message(target, Language.EFFECT_EQUIP_FROM_OTHER.replace("%Effect%", "Large Explosion"), true);

                        MessageUtil.message(player, Language.EFFECT_EQUIP_OTHER
                                .replace("%Player%", target.getName())
                                .replace("%Effect%", "Large Explosion"), true);

                        break;
                    }
                    case "spark":
                    {
                        if (!player.hasPermission(Permissions.SPARK) && !player.hasPermission(Permissions.ALL_PARTICLES))
                        {
                            MessageUtil.message(player, Language.GENERAL_NO_PERMISSION, true);

                            return false;
                        }

                        PlayerWrapper wrapper;
                        if (PlayerData.exists(target.getUniqueId())) wrapper = PlayerData.loadWrapper(target.getUniqueId());
                        else wrapper = new PlayerWrapper();

                        wrapper.setDeathEffect("SPARK");

                        PlayerData.create(target.getUniqueId(), wrapper);

                        target.playSound(target.getLocation(), Configurations.SOUNDS_ADD, 2F, 1F);

                        MessageUtil.message(target, Language.EFFECT_EQUIP_FROM_OTHER.replace("%Effect%", "Spark"), true);

                        MessageUtil.message(player, Language.EFFECT_EQUIP_OTHER
                                .replace("%Player%", target.getName())
                                .replace("%Effect%", "Spark"), true);

                        break;
                    }
                    case "flame":
                    {
                        if (!player.hasPermission(Permissions.FLAME) && !player.hasPermission(Permissions.ALL_PARTICLES))
                        {
                            MessageUtil.message(player, Language.GENERAL_NO_PERMISSION, true);

                            return false;
                        }

                        PlayerWrapper wrapper;
                        if (PlayerData.exists(target.getUniqueId())) wrapper = PlayerData.loadWrapper(target.getUniqueId());
                        else wrapper = new PlayerWrapper();

                        wrapper.setDeathEffect("FLAME");

                        PlayerData.create(target.getUniqueId(), wrapper);

                        target.playSound(target.getLocation(), Configurations.SOUNDS_ADD, 2F, 1F);

                        MessageUtil.message(target, Language.EFFECT_EQUIP_FROM_OTHER.replace("%Effect%", "Flame"), true);

                        MessageUtil.message(player, Language.EFFECT_EQUIP_OTHER
                                .replace("%Player%", target.getName())
                                .replace("%Effect%", "Flame"), true);

                        break;
                    }
                    case "heart":
                    {
                        if (!player.hasPermission(Permissions.HEART) && !player.hasPermission(Permissions.ALL_PARTICLES))
                        {
                            MessageUtil.message(player, Language.GENERAL_NO_PERMISSION, true);

                            return false;
                        }

                        PlayerWrapper wrapper;
                        if (PlayerData.exists(target.getUniqueId())) wrapper = PlayerData.loadWrapper(target.getUniqueId());
                        else wrapper = new PlayerWrapper();

                        wrapper.setDeathEffect("HEART");

                        PlayerData.create(target.getUniqueId(), wrapper);

                        target.playSound(target.getLocation(), Configurations.SOUNDS_ADD, 2F, 1F);

                        MessageUtil.message(target, Language.EFFECT_EQUIP_FROM_OTHER.replace("%Effect%", "Heart"), true);

                        MessageUtil.message(player, Language.EFFECT_EQUIP_OTHER
                                .replace("%Player%", target.getName())
                                .replace("%Effect%", "Heart"), true);

                        break;
                    }
                    case "lavapop":
                    {
                        if (!player.hasPermission(Permissions.LAVA_POP) && !player.hasPermission(Permissions.ALL_PARTICLES))
                        {
                            MessageUtil.message(player, Language.GENERAL_NO_PERMISSION, true);

                            return false;
                        }

                        PlayerWrapper wrapper;
                        if (PlayerData.exists(target.getUniqueId())) wrapper = PlayerData.loadWrapper(target.getUniqueId());
                        else wrapper = new PlayerWrapper();

                        wrapper.setDeathEffect("LAVA-POP");

                        PlayerData.create(target.getUniqueId(), wrapper);

                        target.playSound(target.getLocation(), Configurations.SOUNDS_ADD, 2F, 1F);

                        MessageUtil.message(target, Language.EFFECT_EQUIP_FROM_OTHER.replace("%Effect%", "Lava Pop"), true);

                        MessageUtil.message(player, Language.EFFECT_EQUIP_OTHER
                                .replace("%Player%", target.getName())
                                .replace("%Effect%", "Lava Pop"), true);

                        break;
                    }
                    case "note":
                    {
                        if (!player.hasPermission(Permissions.NOTE) && !player.hasPermission(Permissions.ALL_PARTICLES))
                        {
                            MessageUtil.message(player, Language.GENERAL_NO_PERMISSION, true);

                            return false;
                        }

                        PlayerWrapper wrapper;
                        if (PlayerData.exists(target.getUniqueId())) wrapper = PlayerData.loadWrapper(target.getUniqueId());
                        else wrapper = new PlayerWrapper();

                        wrapper.setDeathEffect("NOTE");

                        PlayerData.create(target.getUniqueId(), wrapper);

                        target.playSound(target.getLocation(), Configurations.SOUNDS_ADD, 2F, 1F);

                        MessageUtil.message(target, Language.EFFECT_EQUIP_FROM_OTHER.replace("%Effect%", "Note"), true);

                        MessageUtil.message(player, Language.EFFECT_EQUIP_OTHER
                                .replace("%Player%", target.getName())
                                .replace("%Effect%", "Note"), true);

                        break;
                    }
                    case "portal":
                    {
                        if (!player.hasPermission(Permissions.PORTAL) && !player.hasPermission(Permissions.ALL_PARTICLES))
                        {
                            MessageUtil.message(player, Language.GENERAL_NO_PERMISSION, true);

                            return false;
                        }

                        PlayerWrapper wrapper;
                        if (PlayerData.exists(target.getUniqueId())) wrapper = PlayerData.loadWrapper(target.getUniqueId());
                        else wrapper = new PlayerWrapper();

                        wrapper.setDeathEffect("PORTAL");

                        PlayerData.create(target.getUniqueId(), wrapper);

                        target.playSound(target.getLocation(), Configurations.SOUNDS_ADD, 2F, 1F);

                        MessageUtil.message(target, Language.EFFECT_EQUIP_FROM_OTHER.replace("%Effect%", "Portal"), true);

                        MessageUtil.message(player, Language.EFFECT_EQUIP_OTHER
                                .replace("%Player%", target.getName())
                                .replace("%Effect%", "Portal"), true);

                        break;
                    }
                    case "redstone":
                    {
                        if (!player.hasPermission(Permissions.REDSTONE) && !player.hasPermission(Permissions.ALL_PARTICLES))
                        {
                            MessageUtil.message(player, Language.GENERAL_NO_PERMISSION, true);

                            return false;
                        }

                        PlayerWrapper wrapper;
                        if (PlayerData.exists(target.getUniqueId())) wrapper = PlayerData.loadWrapper(target.getUniqueId());
                        else wrapper = new PlayerWrapper();

                        wrapper.setDeathEffect("REDSTONE");

                        PlayerData.create(target.getUniqueId(), wrapper);

                        target.playSound(target.getLocation(), Configurations.SOUNDS_ADD, 2F, 1F);

                        MessageUtil.message(target, Language.EFFECT_EQUIP_FROM_OTHER.replace("%Effect%", "Redstone"), true);

                        MessageUtil.message(player, Language.EFFECT_EQUIP_OTHER
                                .replace("%Player%", target.getName())
                                .replace("%Effect%", "Redstone"), true);

                        break;
                    }
                    case "slime":
                    {
                        if (!player.hasPermission(Permissions.SLIME) && !player.hasPermission(Permissions.ALL_PARTICLES))
                        {
                            MessageUtil.message(player, Language.GENERAL_NO_PERMISSION, true);

                            return false;
                        }

                        PlayerWrapper wrapper;
                        if (PlayerData.exists(target.getUniqueId())) wrapper = PlayerData.loadWrapper(target.getUniqueId());
                        else wrapper = new PlayerWrapper();

                        wrapper.setDeathEffect("SLIME");

                        PlayerData.create(target.getUniqueId(), wrapper);

                        target.playSound(target.getLocation(), Configurations.SOUNDS_ADD, 2F, 1F);

                        MessageUtil.message(target, Language.EFFECT_EQUIP_FROM_OTHER.replace("%Effect%", "Slime"), true);

                        MessageUtil.message(player, Language.EFFECT_EQUIP_OTHER
                                .replace("%Player%", target.getName())
                                .replace("%Effect%", "Slime"), true);

                        break;
                    }
                    case "smallsmoke":
                    {
                        if (!player.hasPermission(Permissions.SMOKE_SMALL) && !player.hasPermission(Permissions.ALL_PARTICLES))
                        {
                            MessageUtil.message(player, Language.GENERAL_NO_PERMISSION, true);

                            return false;
                        }

                        PlayerWrapper wrapper;
                        if (PlayerData.exists(target.getUniqueId())) wrapper = PlayerData.loadWrapper(target.getUniqueId());
                        else wrapper = new PlayerWrapper();

                        wrapper.setDeathEffect("SMOKE-SMALL");

                        PlayerData.create(target.getUniqueId(), wrapper);

                        target.playSound(target.getLocation(), Configurations.SOUNDS_ADD, 2F, 1F);

                        MessageUtil.message(target, Language.EFFECT_EQUIP_FROM_OTHER.replace("%Effect%", "Small Smoke"), true);

                        MessageUtil.message(player, Language.EFFECT_EQUIP_OTHER
                                .replace("%Player%", target.getName())
                                .replace("%Effect%", "Small Smoke"), true);

                        break;
                    }
                    case "largesmoke":
                    {
                        if (!player.hasPermission(Permissions.SMOKE_LARGE) && !player.hasPermission(Permissions.ALL_PARTICLES))
                        {
                            MessageUtil.message(player, Language.GENERAL_NO_PERMISSION, true);

                            return false;
                        }

                        PlayerWrapper wrapper;
                        if (PlayerData.exists(target.getUniqueId())) wrapper = PlayerData.loadWrapper(target.getUniqueId());
                        else wrapper = new PlayerWrapper();

                        wrapper.setDeathEffect("SMOKE-LARGE");

                        PlayerData.create(target.getUniqueId(), wrapper);

                        target.playSound(target.getLocation(), Configurations.SOUNDS_ADD, 2F, 1F);

                        MessageUtil.message(target, Language.EFFECT_EQUIP_FROM_OTHER.replace("%Effect%", "Large Smoke"), true);

                        MessageUtil.message(player, Language.EFFECT_EQUIP_OTHER
                                .replace("%Player%", target.getName())
                                .replace("%Effect%", "Large Smoke"), true);

                        break;
                    }
                    case "spell":
                    {
                        if (!player.hasPermission(Permissions.SPELL) && !player.hasPermission(Permissions.ALL_PARTICLES))
                        {
                            MessageUtil.message(player, Language.GENERAL_NO_PERMISSION, true);

                            return false;
                        }

                        PlayerWrapper wrapper;
                        if (PlayerData.exists(target.getUniqueId())) wrapper = PlayerData.loadWrapper(target.getUniqueId());
                        else wrapper = new PlayerWrapper();

                        wrapper.setDeathEffect("SPELL");

                        PlayerData.create(target.getUniqueId(), wrapper);

                        target.playSound(target.getLocation(), Configurations.SOUNDS_ADD, 2F, 1F);

                        MessageUtil.message(target, Language.EFFECT_EQUIP_FROM_OTHER.replace("%Effect%", "Spell"), true);

                        MessageUtil.message(player, Language.EFFECT_EQUIP_OTHER
                                .replace("%Player%", target.getName())
                                .replace("%Effect%", "Spell"), true);

                        break;
                    }
                    case "snow":
                    {
                        if (!player.hasPermission(Permissions.SNOW) && !player.hasPermission(Permissions.ALL_PARTICLES))
                        {
                            MessageUtil.message(player, Language.GENERAL_NO_PERMISSION, true);

                            return false;
                        }

                        PlayerWrapper wrapper;
                        if (PlayerData.exists(target.getUniqueId())) wrapper = PlayerData.loadWrapper(target.getUniqueId());
                        else wrapper = new PlayerWrapper();

                        wrapper.setDeathEffect("SNOW");

                        PlayerData.create(target.getUniqueId(), wrapper);

                        target.playSound(target.getLocation(), Configurations.SOUNDS_ADD, 2F, 1F);

                        MessageUtil.message(target, Language.EFFECT_EQUIP_FROM_OTHER.replace("%Effect%", "Snow"), true);

                        MessageUtil.message(player, Language.EFFECT_EQUIP_OTHER
                                .replace("%Player%", target.getName())
                                .replace("%Effect%", "Snow"), true);

                        break;
                    }
                    case "happyvillager":
                    {
                        if (!player.hasPermission(Permissions.HAPPY_VILLAGER) && !player.hasPermission(Permissions.ALL_PARTICLES))
                        {
                            MessageUtil.message(player, Language.GENERAL_NO_PERMISSION, true);

                            return false;
                        }

                        PlayerWrapper wrapper;
                        if (PlayerData.exists(target.getUniqueId())) wrapper = PlayerData.loadWrapper(target.getUniqueId());
                        else wrapper = new PlayerWrapper();

                        wrapper.setDeathEffect("HAPPY-VILLAGER");

                        PlayerData.create(target.getUniqueId(), wrapper);

                        target.playSound(target.getLocation(), Configurations.SOUNDS_ADD, 2F, 1F);

                        MessageUtil.message(target, Language.EFFECT_EQUIP_FROM_OTHER.replace("%Effect%", "Happy Villager"), true);

                        MessageUtil.message(player, Language.EFFECT_EQUIP_OTHER
                                .replace("%Player%", target.getName())
                                .replace("%Effect%", "Happy Villager"), true);

                        break;
                    }
                    case "angryvillager":
                    {
                        if (!player.hasPermission(Permissions.ANGRY_VILLAGER) && !player.hasPermission(Permissions.ALL_PARTICLES))
                        {
                            MessageUtil.message(player, Language.GENERAL_NO_PERMISSION, true);

                            return false;
                        }

                        PlayerWrapper wrapper;
                        if (PlayerData.exists(target.getUniqueId())) wrapper = PlayerData.loadWrapper(target.getUniqueId());
                        else wrapper = new PlayerWrapper();

                        wrapper.setDeathEffect("ANGRY-VILLAGER");

                        PlayerData.create(target.getUniqueId(), wrapper);

                        target.playSound(target.getLocation(), Configurations.SOUNDS_ADD, 2F, 1F);

                        MessageUtil.message(target, Language.EFFECT_EQUIP_FROM_OTHER.replace("%Effect%", "Angry Villager"), true);

                        MessageUtil.message(player, Language.EFFECT_EQUIP_OTHER
                                .replace("%Player%", target.getName())
                                .replace("%Effect%", "Angry Villager"), true);

                        break;
                    }
                    case "splash":
                    {
                        if (!player.hasPermission(Permissions.SPLASH) && !player.hasPermission(Permissions.ALL_PARTICLES))
                        {
                            MessageUtil.message(player, Language.GENERAL_NO_PERMISSION, true);

                            return false;
                        }

                        PlayerWrapper wrapper;
                        if (PlayerData.exists(target.getUniqueId())) wrapper = PlayerData.loadWrapper(target.getUniqueId());
                        else wrapper = new PlayerWrapper();

                        wrapper.setDeathEffect("SPLASH");

                        PlayerData.create(target.getUniqueId(), wrapper);

                        target.playSound(target.getLocation(), Configurations.SOUNDS_ADD, 2F, 1F);

                        MessageUtil.message(target, Language.EFFECT_EQUIP_FROM_OTHER.replace("%Effect%", "Splash"), true);

                        MessageUtil.message(player, Language.EFFECT_EQUIP_OTHER
                                .replace("%Player%", target.getName())
                                .replace("%Effect%", "Splash"), true);

                        break;
                    }
                    default:
                    {
                        MessageUtil.effects(player);
                    }
                }
            }
            else
                MessageUtil.help(player, 1);
        }
        else
            MessageUtil.help(player, 1);

        return false;
    }
}
