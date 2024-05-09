package net.noah.hasteyboys.commands;

import net.noah.hasteyboys.HasteyBoys;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class HasteyBoysCommand implements CommandExecutor {

    public HasteyBoysCommand(HasteyBoys hasteyBoys) {}

    @Override
    public boolean onCommand(CommandSender sender, Command command, String string, String[] args) {
        if(!sender.hasPermission(HasteyBoys.PERMISSION)) {
            sender.sendMessage(HasteyBoys.PREFIX + ChatColor.RED + "You do not have permission to use this command."); return true;
        }

        if (args.length == 0) {
            sender.sendMessage(HasteyBoys.PREFIX + "Usage: /hasteyboys <enable/disable/description>"); return true;
        }

        if(args[0].equalsIgnoreCase("description")) {
            sender.sendMessage(HasteyBoys.PREFIX + HasteyBoys.DESCRIPTION); return true;
        }

        if(args[0].equalsIgnoreCase("enable")) {
            if(HasteyBoys.status) {
                sender.sendMessage(HasteyBoys.PREFIX + "Hastey Boys is already enabled."); return true;
            }
            HasteyBoys.status = true;
            Bukkit.broadcastMessage(HasteyBoys.PREFIX + "Hastey Boys has been enabled."); return true;
        }

        if(args[0].equalsIgnoreCase("disable")) {
            if(!HasteyBoys.status) {
                sender.sendMessage(HasteyBoys.PREFIX + "Hastey Boys is not enabled."); return true;
            }
            HasteyBoys.status = false;
            Bukkit.broadcastMessage(HasteyBoys.PREFIX + "Hastey Boys has been disabled."); return true;
        }

        sender.sendMessage(HasteyBoys.PREFIX + "Usage: /hasteyboys <enable/disable/description>"); return true;
    }
}
