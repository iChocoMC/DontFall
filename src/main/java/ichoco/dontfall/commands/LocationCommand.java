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

        switch (args[0]){
            case "add":
                Location playerLocation = player.getLocation();                
                String locString =
                playerLocation.getBlockX() + ", " + playerLocation.getBlockY() + ", " + playerLocation.getBlockZ();
                if (args.length == 2){
                    switch(args[2]){
                        case "strong": 
                            LocationUtil.addLocation_Strong(playerLocation);
                            player.sendMessage("Location añadida en: §e" + locString);
                        break;

                        case "heal": 
                            LocationUtil.addLocation_Heal(playerLocation);
                            player.sendMessage("Location añadida en: §e" + locString);
                        break;

                        default: player.sendMessage("§&4&lERROR: §cSolo para los mundos: Naturaleza y puente");
                    }
                }
        }
        return false;
    }
}
