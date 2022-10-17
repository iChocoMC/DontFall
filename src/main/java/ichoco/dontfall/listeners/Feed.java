package ichoco.dontfall.listeners;

import java.util.Collection;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import ichoco.dontfall.othersUtils.Messages;

public class Feed implements Listener {
    Collection<PotionEffect> golden_head;
    PotionEffect golden_apple = new PotionEffect(PotionEffectType.SPEED, 100, 2);

    public Feed(){
        golden_head.add(new PotionEffect(PotionEffectType.SPEED, 200, 2));
        golden_head.add(new PotionEffect(PotionEffectType.HEAL, 200, 1));
        golden_head.add(new PotionEffect(PotionEffectType.ABSORPTION, 200, 1));
    }

    @EventHandler
    public void interact(PlayerInteractEvent event){
        if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK){
            Player player = event.getPlayer();

            switch(event.getItem().getType()){
                case MUSHROOM_SOUP:
                    player.setItemInHand(null);
                    if (player.getHealth() <= 14.0D) {
                        player.setHealth(player.getHealth() + 6.0D);
                        return;
                    }
                    player.setHealth(20.0D);
                break;

                case SKULL_ITEM:
                    player.addPotionEffects(golden_head);
                    player.sendMessage(Messages.Golden_Head);
                break;

                default:
            } 
        }
    }

    @EventHandler
    public void golden_apple(PlayerItemConsumeEvent event){
        if(event.getItem().getType() == Material.GOLDEN_APPLE){
            Player player = event.getPlayer();
            player.addPotionEffect(golden_apple);
            player.sendMessage(Messages.Golden_Apple);
        }
    }
}

