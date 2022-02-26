package com.hypernite.plugin.os.nospawnkill.listener;

import com.hypernite.plugin.os.nospawnkill.main.NoSpawnKill;
import com.hypernite.plugin.os.nospawnkill.manager.ConfigManager;
import com.hypernite.plugin.os.nospawnkill.utils.ColorConfigurator;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

public class RespawnListener implements Listener {
    @EventHandler
    public void onPlayerRespawn(PlayerRespawnEvent e) {
        e.getPlayer().setNoDamageTicks(ConfigManager.duration * 20);
        e.getPlayer().sendMessage(ColorConfigurator.replace(ConfigManager.prefix) + " " + ColorConfigurator.replace(ConfigManager.startRespawn));

        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(NoSpawnKill.getPlugin(NoSpawnKill.class), ()->{
            e.getPlayer().sendMessage(ColorConfigurator.replace(ConfigManager.prefix) + " " + ColorConfigurator.replace(ConfigManager.endProtection));
        },(ConfigManager.duration * 20) * 1L);
    }
}
