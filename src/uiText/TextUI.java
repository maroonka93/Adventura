/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uiText;

import java.util.Scanner;
import logic.IGame;

/**
 *lass TextUI
 * 
 *  
 * @author MP
 */
public class TextUI {
    
    private IGame game;

    /**
     *  
     * @param game
     */
    public TextUI(IGame game) {
        this.game = game;
    }

    /**
     *  
     */
    public void hraj() {
        System.out.println(game.returnWelcomeMessage());
        System.out.println("Let the games begin!");
        System.out.println(this.game.getGamePlan().getBeforeGates().shortRoomDescription() 
                + this.game.getGamePlan().getCurrentRoom().getDescription() + "\n"
                    + this.game.getGamePlan().getCurrentRoom().listingOfExits() + "\n" + 
                    this.game.getGamePlan().getCurrentRoom().listThingsInRoom());
        while (!game.endOfGame()) {
            String line = readString();
            System.out.println(game.executeCommand(line));
            if (this.game.getGamePlan().getCurrentRoom().getName().matches("cliff") && 
                    this.game.getGamePlan().getPlayer().getInventory().isInInventory("princess")) {
                 this.game.setEndOfGame(true);
            }
        }

        System.out.println(game.returnEpilogue());
    }

    /**
     *  
     *
     *@return    
     */
    private String readString() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("> ");
        return scanner.nextLine();
    }
    
    private int readInt() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("> ");
        return scanner.nextInt();
    }
    
}
