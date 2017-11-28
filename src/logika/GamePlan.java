/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logika;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import utils.Observer;
import utils.Subject;

/**
 *Class GamePlan - includes the map and current situation of the game
 * 
 *  initializes rooms, things included in the rooms, conditions for both
 * rooms and things, keeps track of current room
 * @author MP
 */
public class GamePlan implements Subject {
    
    private Room currentRoom;
    private Player player = new Player(null, null);
    
    Room beforeGates;
    Room castle;
    Room village;
    Room forrest;
        
    Room closet;
    Room bedroom;
    Room kitchen;
        
    Room stables;
    Room church;
    Room inn;
        
    Room cemetery;
    Room trail;
    Room cliff;
    
    private List<Observer> listOfObservers = new ArrayList<Observer>();
    
     /**
     *  Constructor creates all the rooms and things in them. It sets "throne room"
     * as starting position.
     */
    public GamePlan() {
        this.zalozProstoryHry();
        this.setExitsInRooms();
        this.setDescriptionsToRooms();
        this.setThingsInRooms();
        this.setRoomConditions();
        this.listOfObservers = new ArrayList();
    }
    
    /**
     *  getter for current room
     *
     *@return Room currentRoom
     */
    public Room getCurrentRoom() {
        return currentRoom;
    }
    
    /**
     * getter for player
     * @return Player player
     */
    public Player getPlayer() {
        return player;
    }
    
    /**
     * getter for throne room
     * @return Room beforeGates
     */
    public Room getBeforeGates() {
        return beforeGates;
    }
    
    /**
     * setter for current room
     *@param prostor 
     */
    public void setCurrentRoom(Room prostor) {
       currentRoom = prostor;
       notifyObservers();
    }

    /**
     * setter for player
     * @param player
     */
    public void setPlayer(Player player) {
        this.player = player;
    }
    
    /**
     *  Creates rooms. Sets "throne room" as starting position.
     */
    private void zalozProstoryHry() {
        // vytvĂˇĹ™ejĂ­ se jednotlivĂ© prostory
        this.beforeGates = new Room("before gates",30,120);
        this.castle = new Room("castle",90,80);
        this.village = new Room("village",90,155);
        this.forrest = new Room("forrest",200,155);
        
        this.closet = new Room("closet",130,20);
        this.bedroom = new Room("bedroom",170,85);
        this.kitchen = new Room("kitchen",75,20);
        
        this.stables = new Room("stables",80,220);
        this.church = new Room("church",130,220);
        this.inn = new Room("inn",25,165);
        
        this.cemetery = new Room("cemetery",200,220);
        this.trail = new Room("trail",247,110);
        this.cliff = new Room("cliff",260,70);
        
        currentRoom = beforeGates;
    }
    
    
    /*
     * sets exits from the room
     */
    private void setExitsInRooms() {
        beforeGates.setExit(castle);
        beforeGates.setExit(village);
        castle.setExit(closet);
        castle.setExit(bedroom);
        castle.setExit(kitchen);
        castle.setExit(village);
        village.setExit(stables);
        village.setExit(church);
        village.setExit(inn);
        village.setExit(forrest);
        village.setExit(castle);
        forrest.setExit(cemetery);
        forrest.setExit(trail);
        trail.setExit(cliff);
        closet.setExit(castle);
        bedroom.setExit(castle);
        kitchen.setExit(castle);
        stables.setExit(village);
        church.setExit(village);
        inn.setExit(village);
        cemetery.setExit(forrest);
        trail.setExit(forrest);
        forrest.setExit(village);
        cliff.setExit(trail);
    }
    
    /*
     * sets descriptions to rooms
     */
    private void setDescriptionsToRooms() {
        beforeGates.setDescription("A devastated king paces in the throne room. 'Please, please, our most beloved savior, bring her back to me!'");
        castle.setDescription("The castle is princess' home. Maybe a look around for some helpful clues?");
        closet.setDescription("Only the chosen ones can enter the wardrobe... or at least those with a key.");
        bedroom.setDescription("A guard is on the watch before princess' chamber! However, he looks very thirsty. Maybe he would accept a bribe?");
        kitchen.setDescription("Royal kitchen has the best chef in the entire kingdom. She makes heavenly bread and she does have a soft spot for poor people.");
        village.setDescription("The village that surrounds the castle's wall is full of all kinds of people... and suprises.");
        this.stables.setDescription("Lots and lots of horses... and a stable boy guarding them. He looks even more devastated than the king. " + "\n" 
                + "A family tragedy or does he have a thing for our princess? If the latter, he could use something to remind him of her... or not.");
        this.church.setDescription("A beggar sits on the bench, praying silently. 'Our chef, she has the kindest of hearts." + "\n" 
                + "The more pitiful you look, the more bread she gives you!");
        this.inn.setDescription("The innkeeper gives you a stern look. 'If you don't have anything to pay with, don't even bother coming in!'");
        this.forrest.setDescription("The forrest is dark and full of terrors... or bunnies. I love bunnies.");
        this.trail.setDescription("There is no way you're making it on this trail on your own two feet!");
        this.cemetery.setDescription("OOOOHHH! A scary ghost emerges from the tomb! 'Off to save our princess, aye? Lost forever she is... " + "\n" 
                + "a terrible dragon took her to its home! Not a very bright one tho, thinks anything big and round is a precious stone! Ha-ha!'");
        this.cliff.setDescription("You found her! Our poor princess is right down the cliff! You climb down to rescue her... "+ "\n"
                + "The terrible dragon shifts his focus to your direction. Quickly, think of something!");
    }
    
    /*
    * sets things in rooms
    */
    private void setThingsInRooms() {
        Thing wardrobe = new Thing (false, "wardrobe", true, "/sources/closet.jpg");
        this.closet.setThingsInRoom(wardrobe);
        Thing chest = new Thing (false, "chest", true, "/sources/chest.jpg");
        Thing money = new Thing (true, "money", false, "/sources/money.jpg");
        this.closet.setThingsInRoom(chest);
        chest.setContent(money);
        wardrobe.setContent(null);
        
        Thing mirror = new Thing (false, "mirror", true, "/sources/mirror.jpg");
        //mirror.setContent(null);
        Thing jeweleryBox = new Thing (false, "jeweleryBox", true, "/sources/jeweleryBox.jpg");
        Thing medalion = new Thing (true, "medalion", true, "/sources/medalion.jpg");
        jeweleryBox.setContent(medalion);
        this.bedroom.setThingsInRoom(mirror);
        this.bedroom.setThingsInRoom(jeweleryBox);
        
        Thing horse = new Thing (false, "horse", false, "/sources/horse.png");
        this.stables.setThingsInRoom(horse);
        horse.setCondition("medalion");
        
        Thing beggarsCoat = new Thing (true, "beggarsCoat", false, "/sources/beggarsCoat.jpg");
        this.church.setThingsInRoom(beggarsCoat);
         
        Thing beer = new Thing (false, "beer", false, "/sources/beer.jpg");
        this.inn.setThingsInRoom(beer);
        beer.setCondition("money");
        
        Thing tree = new Thing (false, "tree", true, "/sources/tree.jpeg");
        Thing bush = new Thing (false, "bush", true, "/sources/bush.jpg");
        this.forrest.setThingsInRoom(tree);
        this.forrest.setThingsInRoom(bush);
        
        Thing bread = new Thing (false, "bread", false, "/sources/bread.jpg");
            this.kitchen.setThingsInRoom(bread);
            bread.setCondition("beggarsCoat");
            
        Thing tomb = new Thing (false, "tomb", true, "/sources/tomb.jpg");
        Thing rope = new Thing (true, "rope", false, "/sources/rope.jpg");
            tomb.setContent(rope);
            this.cemetery.setThingsInRoom(tomb);
            Thing rabbitHole = new Thing (false, "rabbitHole", true, "/sources/rabbitHole.jpg");
            Thing key = new Thing (true, "key", false, "/sources/key.png");
            rabbitHole.setContent(key);
            this.forrest.setThingsInRoom(rabbitHole);
            
        Thing princess = new Thing(true, "princess", false, "/sources/princess.jpg");
        princess.setCondition("bread");
        this.cliff.setThingsInRoom(princess);
        
            //this.player.getInventory().addToInventory(key);
    }
    
    /**
     * exceptions that have to made once player chooses his character and gets a free thing
     */
    /*public void characterThingsSetUpExceptions() {
        if (!this.player.getCharacter().equalsIgnoreCase("Priest")) {
            Thing bread = new Thing (false, "bread", false);
            this.kitchen.setThingsInRoom(bread);
            bread.setCondition("beggarsCoat");
            
        }
        Thing tomb = new Thing (false, "tomb", true);
        if (!this.player.getCharacter().equalsIgnoreCase("Brave Warrior")) {
            Thing rope = new Thing (true, "rope", false);
            tomb.setContent(rope);
        }
        this.cemetery.setThingsInRoom(tomb);
        Thing rabbitHole = new Thing (false, "rabbitHole", true);
        if (!this.player.getCharacter().equalsIgnoreCase("Wise Man")) {
            Thing key = new Thing (true, "key", false);
            rabbitHole.setContent(key);
        }
        this.forrest.setThingsInRoom(rabbitHole);
    }*/
    
    /*
    * sets locked rooms and things that have to be in players inventory for the
    * room to unlock
    */
    private void setRoomConditions() {
        this.closet.setAccessible(false);
        this.closet.setCondition("key");
        
        this.bedroom.setAccessible(false);
        this.bedroom.setCondition("beer");
        
        this.trail.setAccessible(false);
        this.trail.setCondition("horse");
        
        this.cliff.setAccessible(false);
        this.cliff.setCondition("rope");
        
    }
    
    
    
    /**
     * returns true if condition for picking up an item is met
     * @param thing
     * @return boolean
     */
    public boolean conditionForPickingUp(Thing thing) {
        if (this.player.getInventory().isInInventory(thing.getCondition())) {
            thing.setPickable(true);
            //System.out.println("You have the right item. You can pick up " + thing.getName() + " now.");
            return true;
        }
        return false;
    }
    
    /**
     * returns true if condition for entering a room is met
     * @param room
     * @return boolean
     */
    public boolean conditionForGoingTo(Room room) {
        /*if (room.getCondition().isEmpty()) {
            return true;
        }*/
        if (this.player.getInventory().isInInventory(room.getCondition())) {
            this.player.getInventory().removeFromInventory(room.getCondition());
            //room.setAccessible(true);
            return true;
        }
        //System.out.println(room.getDescription());
        return false;
    }
    
    /**
     * returns true if player has the right item in the last room for ending the game
     * @return boolean
     */
    /*public boolean cliffFinale() {
        if (this.currentRoom.equals(cliff)) {
            System.out.println();
            if (this.player.getInventory().isInInventory("bread")) {
                System.out.println();
                return true;
            }
            System.out.println("OMG you forgot to bring something! Hurry back and find it!");
            return false;
        }
        return false;
    }*/
    
    @Override
    public void registerObserver(Observer observer) {
        listOfObservers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        listOfObservers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer listOfObserversItem : listOfObservers) {
            listOfObserversItem.update();
        }
    }

    
}
