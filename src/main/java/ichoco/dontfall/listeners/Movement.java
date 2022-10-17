package ichoco.dontfall.listeners;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class Movement implements Listener {
    
    @EventHandler
    public void PlayerMove(PlayerMoveEvent event) {
        if (event.getTo().getBlock().isLiquid()){
            event.getPlayer().setHealth(0.0D); 
        }
    }
    
    @EventHandler
    public void PlayerDeath(PlayerDeathEvent event) {
        Player player = event.getEntity();
        Location location = player.getLocation().getWorld().getSpawnLocation();
        
        new BukkitRunnable() {

            @Override
            public void run() {
                player.spigot().respawn();
                player.teleport(location);
                cancel();
            }
            
        };

        event.setDeathMessage(null);
    }
}
