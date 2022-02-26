package com.hypernite.plugin.os.nospawnkill.main;

import com.hypernite.plugin.os.nospawnkill.listener.RespawnListener;
import com.hypernite.plugin.os.nospawnkill.manager.ConfigManager;
import org.bukkit.ChatColor;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class NoSpawnKill extends JavaPlugin {

    public static Plugin plugin;
    public static ConsoleCommandSender consoleCommandSender;

    @Override
    public void onEnable() {
        plugin = this;
        consoleCommandSender = this.getServer().getConsoleSender();

        //Load Configuration
        ConfigManager.getInstance(this).loadConfig();

        //Register the Event Listener
        this.getServer().getPluginManager().registerEvents(new RespawnListener(), this);

        this.getLogger().info(ChatColor.BLUE + "[NoSpawnKill]" + ChatColor.GREEN + " NoSpawnKill Loaded Successfully");
    }

    @Override
    public void onDisable() {
        this.getLogger().info(ChatColor.BLUE + "[NoSpawnKill]" + ChatColor.RED + " NoSpawnKill Unloaded Successfully");
    }
}
