/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logika;

/**
 * implements player of the game
 * Player can choose his or her name, type of character and has its own inventory
 * @author Míša
 */
public class Player {
    
    private String name;
    private String character;
    private Inventory inventory;

    /**
     * Constructor for player
     * initializes a new inventory
     * @param name
     * @param character
     */
    public Player(String name, String character) {
        this.name = name;
        this.character = character;
        this.inventory = new Inventory();
    }

    /**
     * getter for name
     * @return String name
     */
    public String getName() {
        return name;
    }
    
    /**
     * getter for character
     * @return String character
     */
    public String getCharacter() {
        return character;
    }
    
    /**
     * getter for inventory
     * @return Inventory
     */
    public Inventory getInventory() {
        return inventory;
    }
    
    /**
     * setter for name
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * setter for character
     * depending on the number sets a name of character and adds an item to inventory
     * @param choice
     */
    /*public void setCharacter(int choice) {
        if (choice == 1) {
            this.character = "Priest";
            this.inventory.addToInventory(new Thing (true, "bread", false));
        }
        if (choice == 2) {
            this.character = "Wise Man";
            this.inventory.addToInventory(new Thing (true, "key", false));
        }
        if (choice == 3) {
            this.character = "Brave Warrior";
            this.inventory.addToInventory(new Thing (true, "rope", false));
        }
    }*/

    /**
     * setter for inventory
     * @param inventory
     */
    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
    
    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Player other = (Player) obj;
        return true;
    }
    
}
