/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

/**
 * Command used for picking up things. Picked up things are stored in the inventory.
 * @author MP
 */
public class CommandPickUp implements ICommand {
    
    private GamePlan plan;
    private static final String NAME = "pick up";

    /**
     *
     * @param plan game plan, where things in rooms are picked up
     */
    public CommandPickUp(GamePlan plan) {
        this.plan = plan;
    }
    
    

    @Override
    public String doCommand(String... parametres) {
        String answer = "";
        if (parametres.length == 0) {
            // if no thing is given
            return "What am I supposed to pick up?";
        }
        String nameOfPickedUp = parametres[0];
        Thing toBePickedUp = plan.getCurrentRoom().returnThingInRoom(nameOfPickedUp);
        if (toBePickedUp == null) {
            return nameOfPickedUp + " isn't here.";
        }
        // if a condition has to be met for the thing to be picked up
        if (this.plan.conditionForPickingUp(toBePickedUp)) {
            String added = "You have the right item. You can pick up " + toBePickedUp.getName() + " now." + 
                    "\n" + plan.getPlayer().getInventory().removeFromInventory(toBePickedUp.getCondition())
                    + "\n" + plan.getPlayer().getInventory().addToInventory(toBePickedUp);
            this.plan.notifyObservers();
            answer =  added
                    + "\n" + plan.getCurrentRoom().listingOfExits();
            plan.getCurrentRoom().thingGetsPickedUp(toBePickedUp);
            this.plan.notifyObservers();
            return answer;
        }
        if (toBePickedUp.isPickable()) {
            answer = plan.getPlayer().getInventory().addToInventory(toBePickedUp);
            plan.getCurrentRoom().thingGetsPickedUp(toBePickedUp);
            plan.notifyObservers();
            //return toBePickedUp.getName() + " has been picked up.";
            return answer+ "\n" + plan.getCurrentRoom().listingOfExits();
        }
        return toBePickedUp.getName() + " can't be picked up.";
    }

    @Override
    public String getName() {
        return NAME;
    }
    
}
