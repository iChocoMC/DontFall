package ichoco.dontfall.listeners;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Others implements Listener {
  ItemStack Golden_Apple = new ItemStack(Material.GOLDEN_APPLE);

  @EventHandler
  public void OnPlayerJoin(PlayerJoinEvent event) {
    event.setJoinMessage("§8[§a+§8] §f" + event.getPlayer().getDisplayName());
  }
    
  @EventHandler
  public void OnPlayerQuit(PlayerQuitEvent event) {
    event.setQuitMessage("§8[§c-§8] §f" + event.getPlayer().getDisplayName());
  }
    
  @EventHandler
  public void PlayerDrop(PlayerDropItemEvent event) {
    if (!event.getPlayer().isOp()){
      event.setCancelled(true); 
    }
  }
  
  @EventHandler
  public void onKillPlayer(PlayerDeathEvent event) {
    Player killer = event.getEntity().getKiller();
    if (killer instanceof Player) {
      killer.getInventory().addItem(Golden_Apple);
      killer.sendMessage("§c§lKill §8| §6+1 §eManzana dorada");
      killer.setHealth(20.0D);
    } 
  }
}
