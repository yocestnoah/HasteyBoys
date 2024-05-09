package net.noah.hasteyboys;

import net.noah.hasteyboys.commands.HasteyBoysCommand;

import net.noah.hasteyboys.listeners.CraftListener;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class HasteyBoys extends JavaPlugin {

    public static final String PERMISSION = "scenario.hasteyboys";
    public static final String PREFIX = ChatColor.GRAY + "Hastey Boys" + ChatColor.DARK_GRAY + " » " + ChatColor.WHITE;
    public static final String DESCRIPTION = "hastey boys";

    public static boolean status = false;

    @Override
    public void onEnable() {

        getCommand("hasteyboys").setExecutor(new HasteyBoysCommand(this));

        getServer().getPluginManager().registerEvents(new CraftListener(this), this);

        saveDefaultConfig();
    }
}
