package ichoco.dontfall.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class ItemPickup implements Listener{
    PotionEffect strength = new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 100, 2);

    @EventHandler
    public void PlayerPickup(PlayerPickupItemEvent event) {
      Player player = event.getPlayer();

      switch (event.getItem().getItemStack().getType()) {

        case COOKIE:
          player.setHealth(20.0D);
          player.sendMessage("§fla §6§lGALLETITA §ftan buena que te comiste!, se te ha §erellenado§f la §avida");
          break;

        case REDSTONE:
          player.addPotionEffect(strength);
          player.sendMessage("§c§lMAMADISIMO!§f, ahora tengo §6fuerza 2 §fpor §e5 segundos ");
          break;

        default:
      } 
    }
}
