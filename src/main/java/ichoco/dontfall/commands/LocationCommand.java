package ichoco.dontfall.commands;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import ichoco.dontfall.othersUtils.LocationUtil;
import ichoco.dontfall.othersUtils.Messages;

public class LocationCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)){
            return true; 
        }
        
        Player player = (Player)sender;

        if (args.length < 1){
            player.sendMessage(Messages.Location_Format);
            return true; 
        }
        Location playerLocation = player.getLocation();                

        switch (args[0]){
            case "heal":
                LocationUtil.addLocation_Heal(playerLocation);
                player.sendMessage("Location añadida en: §e" + 
                playerLocation.getBlockX() + ", " + playerLocation.getBlockY() + ", " + playerLocation.getBlockZ());
            break;
            
            case "strength":
                LocationUtil.addLocation_Strength(playerLocation);
                player.sendMessage("Location añadida en: §e" + 
                playerLocation.getBlockX() + ", " + playerLocation.getBlockY() + ", " + playerLocation.getBlockZ());
        }
        return false;
    }
}
