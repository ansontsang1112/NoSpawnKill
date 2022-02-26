package com.hypernite.plugin.os.nospawnkill.manager;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;

public class ConfigManager {
    public static String startRespawn, endProtection, prefix;
    public static int duration;

    private static ConfigManager configManager;
    private File configFile;
    private FileConfiguration fileConfiguration;

    private ConfigManager(Plugin plugin) {
        configFile = new File(plugin.getDataFolder(), "config.yml");
        if(!configFile.exists()) {
            plugin.saveResource("config.yml", true);
        }
        fileConfiguration = YamlConfiguration.loadConfiguration(configFile);
    }

    public static ConfigManager getInstance(Plugin plugin) {
        if(configManager == null) {
            configManager = new ConfigManager(plugin);
        }

        return configManager;
    }

    public void loadConfig() {
        duration = fileConfiguration.getInt("settings.protected-duration");

        startRespawn = fileConfiguration.getString("message.start-respawn").replace("%duration%", String.valueOf(duration));
        endProtection = fileConfiguration.getString("message.end-protection");
        prefix = fileConfiguration.getString("message.prefix");

    }
}
