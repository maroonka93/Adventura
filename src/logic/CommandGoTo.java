/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

/**
 * Implements command "go to" that is used for moving around between rooms.
 * 
 * @author MP
 */
public class CommandGoTo implements ICommand {
    
    private static final String NAME = "go to";
    private GamePlan plan;
    
    /**
    *  Constructor
    *  
    *  @param plan game plan, that will be "walked" in
    */    
    public CommandGoTo(GamePlan plan) {
        this.plan = plan;
    }

    /**
     *  Tries to move to given room. If no room is given or given room isn't accessible
     * from current room, command won't take place. Rooms, that are only accessible
     * if player already discovered an object, can be gone to only if room is already
     * accessible or if player has rewuired object in his inventory.
     *
     *@param parametres name of the room player  wants to go to
     *@return message to player
     */ 
    @Override
    public String doCommand(String... parametres) {
        if (parametres.length == 0) {
            // if a room is not given
            return "Where am I supposed to go again? You have to enter a valid exit.";
        }

        String direction = parametres[0];

        Room neighbour = plan.getCurrentRoom().returnNeighbor(direction);

        if (neighbour == null) {
            return "You can't go there.";
        }
        else {
            if (this.plan.conditionForGoingTo(neighbour)) {
               neighbour.setAccessible(true);
               plan.setCurrentRoom(neighbour);
               this.plan.notifyObservers();
                return "You have the right item. You can enter the room now." +
                neighbour.shortRoomDescription() + neighbour.getDescription() + "\n"
                    + neighbour.listingOfExits() + "\n" + neighbour.listThingsInRoom();
            }
            if (neighbour.isAccessible()) {
                plan.setCurrentRoom(neighbour);
                plan.notifyObservers();
            return neighbour.shortRoomDescription() + neighbour.getDescription() + "\n"
                    + neighbour.listingOfExits() + "\n" + neighbour.listThingsInRoom();
            }
            else {
                return "You don't have the necessary item to enter this room." + "\n" + neighbour.getDescription();
            }
            
        }
    }
    
    /**
     *  returns name of the command
     *  
     *  @ return NAME
     */
    @Override
    public String getName() {
        return NAME;
    }
    
}
