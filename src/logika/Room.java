/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logika;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;
import java.util.HashSet;

/**
 * Class Room - implements rooms in game
 *
 * 'Room' is a room in gameplay. It holds a list of exits, each exit is a reference
 * to another room. Room can be locked up and is unlocked, if player meets a condition
 * (has a certain thing in his or her inventory). Rooms can contain things.
 * @author MP
 */
public class Room {
    
    private String name;
    private String description;
    private Set<Room> exits;   
    private Set<Thing> thingsInRoom;
    private boolean accessible = true;
    private String condition = null;
    private double posLeft;
    private double posTop;

    /**
     * Constructor for room
     *
     * @param nazev 
     * @param posLeft 
     * @param posTop 
     */
    public Room(String nazev, double posLeft, double posTop) {
        this.name = nazev;
        exits = new HashSet<>();
        this.thingsInRoom = new HashSet<>();
        this.posLeft = posLeft;
        this.posTop = posTop;
    }

    public double getPosLeft() {
        return posLeft;
    }

    public double getPosTop() {
        return posTop;
    }

    public void setPosLeft(double posLeft) {
        this.posLeft = posLeft;
    }

    public void setPosTop(double posTop) {
        this.posTop = posTop;
    }
    
    
    
    /**
     * getter for name
     *
     * @return String name
     */
    public String getName() {
        return name;       
    }

    /**
     * getter for description
     * @return String description
     */
    public String getDescription() {
        return description;
    }
    
    /**
     * getter for list of thing in room
     * @return thingsInRoom
     */
    public Set<Thing> getThingsInRoom() {
        return thingsInRoom;
    }
    
    /**
     * getter for boolean accessible
     * @return accessible
     */
    public boolean isAccessible() {
        return accessible;
    }
     
    /**
     * getter for condition
     * @return String condition
     */
    public String getCondition() {
        return condition;
    }
    
    /**
     * getter for Collection of exits
     *
     * @return Collections.unmodifiableCollection(exits)
     * 
     */
    public Collection<Room> getExits() {
        return Collections.unmodifiableCollection(exits);
    }
    
    /**
     * adds exit to the list of exits
     * @param next 
     *
     */
    public void setExit(Room next) {
        exits.add(next);
    }

    /**
     * sets description of the room
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }
    
    /**
     * sets accessibility of room
     * @param accessible
     */
    public void setAccessible(boolean accessible) {
        this.accessible = accessible;
    }
    
    /**
     * setter for condition
     * @param condition
     */
    public void setCondition(String condition) {
        this.condition = condition;
    }
    
    /**
     * setter for things in room
     * @param thing
     */
    public void setThingsInRoom(Thing thing) {
        this.thingsInRoom.add(thing);
    }
    
    /**
     * metoda hashCode vraci ciselny identifikator instance, ktery se pouziva
     * pro optimalizaci ukladani v dynamickych datovych strukturach. Pri
     * prekryti metody equals je potreba prekryt i metodu hashCode. Podrobny
     * description pravidel pro vytvareni metody hashCode je u metody hashCode ve
     * tride Object
     * @return 
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + java.util.Objects.hashCode(this.name);
        return hash;
    }

    /**
     * 
     *
     * @param o 
     * @return 
     */  
      @Override
    public boolean equals(Object o) {
        
        if (this == o) {
            return true;
        }
        
        if (!(o instanceof Room)) {
            return false;    
        }
        
        Room second = (Room) o;


       return (java.util.Objects.equals(this.name, second.name));       
    }
    
    /**
     * returns a sentence informing the player of his current room
     *
     * @return String
     */
    public String shortRoomDescription() {
        return "You are in " + this.name+ ".\n";
    }

    /**
     * returns a listing of all the available exits in the room
     *
     * @return String
     */
    public String listingOfExits() {
        String output = "exits: ";
        for (Room r : exits) {
            output += r.getName() + "; ";
        }
        return output;
    }

    /**
     * returns a neighbor room based on its name
     *
     * @param nameOfNeighbor 
     * @return Room room
     */
    public Room returnNeighbor(String nameOfNeighbor) {
        if (nameOfNeighbor == null) {
            return null;
        }
        for (Room r : exits) {
            if (r.getName().equals(nameOfNeighbor)) {
                return r;
            }
        }
        return null;  // prostor nenalezen
    }

    /**
     * returns a thing from this room based on its name
     * @param nameOfTheThing
     * @return Thing thing
     */
    public Thing returnThingInRoom(String nameOfTheThing) {
        if (nameOfTheThing == null) {
            return null;
        }
        for (Thing t : this.thingsInRoom) {
            if (t.getName().equals(nameOfTheThing)) {
                return t;
            }
        }
        return null;  // prostor nenalezen
    }
    
    /**
     * picked up thing is removed from Set Thing thingsInRoom of this room
     * @param thing
     */
    public void thingGetsPickedUp(Thing thing) {
        this.thingsInRoom.remove(thing);
    }
    
    /**
     * returns a listing of things in current room
     * @return String
     */
    public String listThingsInRoom() {
        String output = "things in room: ";
        for (Thing t : this.thingsInRoom) {
            output += t.getName() + "; ";
        }
        return output;
    }
    
}
