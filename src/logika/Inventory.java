/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logika;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import utils.Observer;

/**
 * Creates an inventory of things for player
 * @author MP
 */
public class Inventory {
    
    private List<Thing> inInventory;

    /**
     * Constructor for inventory
     * inventory is limited to 5 items
     */
    public Inventory() {
        this.inInventory = new ArrayList<>(5);
    }
    
    /**
     * adds thing to inventory if inventory isn't full yet
     * @param thing
     * @return 
     */
    public String addToInventory(Thing thing) {
        if (this.inInventory.size() > 5) {
            return "Your inventory is full.";
        }
        else {
            this.inInventory.add(thing);
            
            return thing.getName() + " has been added to your inventory.";
        }
    }
    
    /**
     * finds a thing in inventory based on its name
     * @param name
     * @return Thing thing
     */
    public Thing findInInventory(String name) {
        Thing found = null;
        for (Thing t : this.inInventory) {
            if (t.getName() == name) {
                found = t;
                break;
            }
        }
        if (found == null) {
            System.out.println("This thing is not in your inventory");
        }
        return found;
    }
    
    /**
     * removes a thing from invenotry based on its name
     * @param name
     */
    public String removeFromInventory(String name) {
        this.inInventory.remove(findInInventory(name));
        return "The " + name + " has been removed from your inventory.";
    }
    
    /**
     * returns whether a thing is in inventory based on its name
     * @param name
     * @return boolean
     */
    public boolean isInInventory(String name) {
        for (Thing t : this.inInventory) {
            if (t.getName() == name) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * returns a listing of things in inventory
     * @return String
     */
    public String listingThingsInInventory() {
        String output = "";
        for (Thing t : this.inInventory) {
            output += t.getName() + " ";
        }
        return output;
    }

    public List<Thing> getInInventory() {
        return inInventory;
    }

    public void setInInventory(List<Thing> inInventory) {
        this.inInventory = inInventory;
    }

    
    
}
