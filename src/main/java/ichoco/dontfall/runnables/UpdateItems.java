package ichoco.dontfall.runnables;

import java.util.ArrayList;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class UpdateItems implements Runnable {

    private ArrayList<Location> heal;
    private ItemStack heal_ITEM = new ItemStack(Material.COOKIE);

    private ArrayList<Location> strength;
    private ItemStack strength_ITEM = new ItemStack(Material.REDSTONE);

    public UpdateItems(ArrayList<Location> heal, ArrayList<Location> strength){
        this.heal = heal;
        this.strength = strength;
    }
    
    @Override
    public void run() {
        heal.forEach(location -> location.getWorld().dropItem(location, heal_ITEM));
        strength.forEach(location -> location.getWorld().dropItem(location, strength_ITEM));
    }
}
