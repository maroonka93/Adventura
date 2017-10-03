/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logika;

/**
 *Class GamePlan - includes the map and current situation of the game
 * 
 *  initializes rooms, things included in the rooms, conditions for both
 * rooms and things, keeps track of current room
 * @author MP
 */
public class GamePlan {
    
    private Room currentRoom;
    private Player player = new Player(null, null);
    
    Room throneRoom;
    Room castle;
    Room surroundings;
    Room forrest;
        
    Room wardrobe;
    Room bedroom;
    Room kitchen;
        
    Room stables;
    Room church;
    Room inn;
        
    Room cemetery;
    Room trail;
    Room cliff;
    
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
     * @return Room throneRoom
     */
    public Room getThroneRoom() {
        return throneRoom;
    }
    
    /**
     * setter for current room
     *@param prostor 
     */
    public void setCurrentRoom(Room prostor) {
       currentRoom = prostor;
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
        this.throneRoom = new Room("throne room");
        this.castle = new Room("castle");
        this.surroundings = new Room("surroundings");
        this.forrest = new Room("forrest");
        
        this.wardrobe = new Room("wardrobe");
        this.bedroom = new Room("bedroom");
        this.kitchen = new Room("kitchen");
        
        this.stables = new Room("stables");
        this.church = new Room("church");
        this.inn = new Room("inn");
        
        this.cemetery = new Room("cemetery");
        this.trail = new Room("trail");
        this.cliff = new Room("cliff");
        
        currentRoom = throneRoom;
    }
    
    
    /*
     * sets exits from the room
     */
    private void setExitsInRooms() {
        throneRoom.setExit(castle);
        throneRoom.setExit(surroundings);
        castle.setExit(wardrobe);
        castle.setExit(bedroom);
        castle.setExit(kitchen);
        castle.setExit(surroundings);
        surroundings.setExit(stables);
        surroundings.setExit(church);
        surroundings.setExit(inn);
        surroundings.setExit(forrest);
        surroundings.setExit(castle);
        forrest.setExit(cemetery);
        forrest.setExit(trail);
        trail.setExit(cliff);
        wardrobe.setExit(castle);
        bedroom.setExit(castle);
        kitchen.setExit(castle);
        stables.setExit(surroundings);
        church.setExit(surroundings);
        inn.setExit(surroundings);
        cemetery.setExit(forrest);
        trail.setExit(forrest);
        forrest.setExit(surroundings);
        cliff.setExit(trail);
    }
    
    /*
     * sets descriptions to rooms
     */
    private void setDescriptionsToRooms() {
        throneRoom.setDescription("A devastated king paces in the throne room. 'Please, please, our most beloved savior, bring her back to me!'");
        castle.setDescription("The castle is princess' home. Maybe a look around for some helpful clues?");
        wardrobe.setDescription("Only the chosen ones can enter the wardrobe... or at least those with a key.");
        bedroom.setDescription("A guard is on the watch before princess' chamber! However, he looks very thirsty. Maybe he would accept a bribe?");
        kitchen.setDescription("Royal kitchen has the best chef in the entire kingdom. She makes heavenly bread and she does have a soft spot for poor people.");
        surroundings.setDescription("The village that surrounds the castle's wall is full of all kinds of people... and suprises.");
        this.stables.setDescription("Lots and lots of horses... and a stable boy guarding them. He looks even more devastated than the king. " + "\n" 
                + "A family tragedy or does he have a thing for our princess? If the latter, he could use something to remind him of her... or not.");
        this.church.setDescription("A beggar sits on the bench, praying silently. 'Our chef, she has the kindest of hearts." + "\n" 
                + "The more pitiful you look, the more bread she gives you!");
        this.inn.setDescription("The innkeeper gives you a stern look. 'If you don't have anything to pay with, don't even bother coming in!'");
        this.forrest.setDescription("The forrest is dark and full of terrors... or bunnies. I love bunnies.");
        this.trail.setDescription("There is no way you're making it on this trail on your own two feet!");
        this.cemetery.setDescription("OOOOHHH! A scary ghost emerges from the tomb! 'Off to save our princess, aye? Lost forever she is... " + "\n" 
                + "a terrible dragon took her to its home! Not a very bright one tho, thinks anything big and round is a precious stone! Ha-ha!'");
        this.cliff.setDescription("You found her! Our poor princess is right down the cliff! You climb down to rescue her...");
    }
    
    /*
    * sets things in rooms
    */
    private void setThingsInRooms() {
        Thing closet = new Thing (false, "closet", true);
        this.wardrobe.setThingsInRoom(closet);
        Thing chest = new Thing (false, "chest", true);
        Thing money = new Thing (true, "money", false);
        this.wardrobe.setThingsInRoom(chest);
        chest.setContent(money);
        closet.setContent(null);
        
        Thing mirror = new Thing (false, "mirror", true);
        //mirror.setContent(null);
        Thing jeweleryBox = new Thing (false, "jeweleryBox", true);
        Thing medalion = new Thing (true, "medalion", true);
        jeweleryBox.setContent(medalion);
        this.bedroom.setThingsInRoom(mirror);
        this.bedroom.setThingsInRoom(jeweleryBox);
        
        Thing horse = new Thing (false, "horse", false);
        this.stables.setThingsInRoom(horse);
        horse.setCondition("medalion");
        
        Thing beggarsCoat = new Thing (true, "beggarsCoat", false);
        this.church.setThingsInRoom(beggarsCoat);
         
        Thing beer = new Thing (false, "beer", false);
        this.inn.setThingsInRoom(beer);
        beer.setCondition("money");
        
        Thing tree = new Thing (false, "tree", true);
        Thing bush = new Thing (false, "bush", true);
        this.forrest.setThingsInRoom(tree);
        this.forrest.setThingsInRoom(bush);
        
    }
    
    /**
     * exceptions that have to made once player chooses his character and gets a free thing
     */
    public void characterThingsSetUpExceptions() {
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
    }
    
    /*
    * sets locked rooms and things that have to be in players inventory for the
    * room to unlock
    */
    private void setRoomConditions() {
        this.wardrobe.setAccessible(false);
        this.wardrobe.setCondition("key");
        
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
            System.out.println("You have the right item. You can pick up " + thing.getName() + " now.");
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
        if (this.player.getInventory().isInInventory(room.getCondition())) {
            System.out.println("You have the right item. You can enter the room now.");
            this.player.getInventory().removeFromInventory(room.getCondition());
            room.setAccessible(true);
            return true;
        }
        //System.out.println(room.getDescription());
        return false;
    }
    
    /**
     * returns true if player has the right item in the last room for ending the game
     * @return boolean
     */
    public boolean cliffFinale() {
        if (this.currentRoom.equals(cliff)) {
            System.out.println("The terrible dragon shifts his focus to your direction. Quickly, think of something!");
            if (this.player.getInventory().isInInventory("bread")) {
                System.out.println("You reach for the bread in your bag and throw it as far away as you can! The dragon," + "\n"
                + "under the impression it's a precious stone, chases after it. You grab the princess and you both run" + "\n" 
                        + " as fast as you can toward the castle!");
                return true;
            }
            System.out.println("OMG you forgot to bring something! Hurry back and find it!");
            return false;
        }
        return false;
    }
    
}
