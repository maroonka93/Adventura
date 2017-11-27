/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logika;

/**
 * Implements command "go to" that is used for moving around between rooms.
 * 
 * @author MP
 */
public class CommandGoTo implements ICommand {
    
    private static final String NAZEV = "go to";
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
     *@param parametry name of the room player  wants to go to
     *@return message to player
     */ 
    @Override
    public String proved(String... parametry) {
        if (parametry.length == 0) {
            // if a room is not given
            return "Where am I supposed to go again? You have to enter a valid exit.";
        }

        String smer = parametry[0];

        Room sousedniProstor = plan.getCurrentRoom().returnNeighbor(smer);

        if (sousedniProstor == null) {
            return "You can't go there.";
        }
        else {
            if (this.plan.conditionForGoingTo(sousedniProstor)) {
               sousedniProstor.setAccessible(true);
               plan.setCurrentRoom(sousedniProstor);
               this.plan.notifyObservers();
                return "You have the right item. You can enter the room now." +
                sousedniProstor.shortRoomDescription() + sousedniProstor.getDescription() + "\n"
                    + sousedniProstor.listingOfExits() + "\n" + sousedniProstor.listThingsInRoom();
            }
            if (sousedniProstor.isAccessible()) {
                plan.setCurrentRoom(sousedniProstor);
                plan.notifyObservers();
            return sousedniProstor.shortRoomDescription() + sousedniProstor.getDescription() + "\n"
                    + sousedniProstor.listingOfExits() + "\n" + sousedniProstor.listThingsInRoom();
            }
            else {
                return "You don't have the necessary item to enter this room.";
            }
            
        }
    }
    
    /**
     *  returns name of the command
     *  
     *  @ return NAZEV
     */
    @Override
    public String getNazev() {
        return NAZEV;
    }
    
}
