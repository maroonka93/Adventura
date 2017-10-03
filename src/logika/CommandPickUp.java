/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logika;

/**
 * Command used for picking up things. Picked up things are stored in the inventory.
 * @author MP
 */
public class CommandPickUp implements ICommand {
    
    private GamePlan plan;
    private static final String NAZEV = "pick up";

    /**
     *
     * @param plan game plan, where things in rooms are picked up
     */
    public CommandPickUp(GamePlan plan) {
        this.plan = plan;
    }
    
    

    @Override
    public String proved(String... parametry) {
        if (parametry.length == 0) {
            // if no thing is given
            return "What am I supposed to pick up?";
        }
        String nameOfPickedUp = parametry[0];
        Thing toBePickedUp = plan.getCurrentRoom().returnThingInRoom(nameOfPickedUp);
        if (toBePickedUp == null) {
            return nameOfPickedUp + " isn't here.";
        }
        // if a condition has to be met for the thing to be picked up
        if (this.plan.conditionForPickingUp(toBePickedUp)) {
            plan.getPlayer().getInventory().removeFromInventory(toBePickedUp.getCondition());
        }
        if (toBePickedUp.isPickable()) {
            plan.getPlayer().getInventory().addToInventory(toBePickedUp);
            plan.getCurrentRoom().thingGetsPickedUp(toBePickedUp);
            //return toBePickedUp.getName() + " has been picked up.";
            return plan.getCurrentRoom().listingOfExits();
        }
        return toBePickedUp.getName() + " can't be picked up.";
    }

    @Override
    public String getNazev() {
        return NAZEV;
    }
    
}
