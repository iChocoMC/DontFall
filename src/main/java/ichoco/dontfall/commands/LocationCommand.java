package ichoco.dontfall.commands;

import java.util.HashMap;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import ichoco.dontfall.othersUtils.Formats;
import ichoco.dontfall.othersUtils.Messages;

public class LocationCommand implements CommandExecutor {

    private HashMap<Material, Location> locations = new HashMap<>();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)){
            return true; 
        }
        
        Player player = (Player)sender;

        if (args.length < 1){
            player.sendMessage(Messages.getMessage(Formats.Location_Format));
            return true; 
        }

        switch (args[0]){
            case "add":
                Material item = player.getItemInHand().getType();
                Location playerLocation = player.getLocation();

                locations.put(item, playerLocation);

                player.sendMessage("label");
            break;

            case "clear":
                locations.clear();
                player.sendMessage("label");
            break;

            case "list":
                player.sendMessage(locations.values().toString());
            break;
        }


        return false;
    }
}
