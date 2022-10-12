package ichoco.dontfall.runnables;

import java.util.ArrayList;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class UpdateItems implements Runnable {

    private ArrayList<Location> strong;
    private ArrayList<Location> heal;

    private ItemStack strong_ITEM = new ItemStack(Material.REDSTONE);
    private ItemStack heal_ITEM = new ItemStack(Material.COOKIE);

    public UpdateItems(ArrayList<Location> naturaleza, ArrayList<Location> puente){
        this.strong = naturaleza;
        this.heal = puente;
    }
    
    @Override
    public void run() {
        strong.forEach(location -> location.getWorld().dropItem(location,  strong_ITEM));
        heal.forEach(location -> location.getWorld().dropItem(location,  heal_ITEM));
    }
}
