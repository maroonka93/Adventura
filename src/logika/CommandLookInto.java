/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logika;

/**
 * Command, that allows player to look into things (for example chests)
 * @author Míša
 */
public class CommandLookInto implements ICommand {
    
    private GamePlan plan;
    private static final String NAZEV = "look into";

    /**
     *
     * @param plan game plan where given things are placed in rooms
     */
    public CommandLookInto(GamePlan plan) {
        this.plan = plan;
    }
    
    

    @Override
    public String proved(String... parametry) {
        if (parametry.length == 0) {
            // if a word after command is missing
            return "What am I supposed to look into?";
        }
        String nameOfLookedInto = parametry[0];
        Thing toBeLookedInto = plan.getCurrentRoom().returnThingInRoom(nameOfLookedInto);
        if (toBeLookedInto == null) {
            return nameOfLookedInto + " isn't here.";
        }
        // some things can't be looked into
        // if inside this thing another thing is discovered, it is automatically picked up
        if (toBeLookedInto.isLookableInto()) {
            if(toBeLookedInto.getContent() == null) {
                return toBeLookedInto.getName() + " is empty.";
            }
            System.out.println("You have found " + toBeLookedInto.getContent().getName() + ".");
            this.plan.getPlayer().getInventory().addToInventory(toBeLookedInto.getContent());
            this.plan.getCurrentRoom().returnThingInRoom(nameOfLookedInto).removeContent();
            return this.plan.getCurrentRoom().listingOfExits();
        }
        return toBeLookedInto.getName() + " can't be looked into.";
    
    }

    @Override
    public String getNazev() {
        return NAZEV;
    }
    
}
