/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uiText;

import java.util.Scanner;
import logika.Game;
import logika.IGame;

/**
 *lass TextoveRozhrani
 * 
 *  
 * @author MP
 */
public class TextoveRozhrani {
    
    private IGame hra;

    /**
     *  
     * @param hra
     */
    public TextoveRozhrani(IGame hra) {
        this.hra = hra;
    }

    /**
     *  
     */
    public void hraj() {
        System.out.println(hra.vratUvitani());
        /*int choice = 0;
        while (choice != 1 ^ choice != 2 ^ choice != 3) {
            choice = this.prectiInt();
        }
        this.hra.getHerniPlan().getPlayer().setCharacter(choice);
        System.out.println("Now choose a name for your " + this.hra.getHerniPlan().getPlayer().getCharacter() + ":");
        this.hra.getHerniPlan().getPlayer().setName(this.prectiString());
       
        this.hra.getHerniPlan().characterThingsSetUpExceptions();*/
        System.out.println("Let the games begin!");
        System.out.println(this.hra.getHerniPlan().getBeforeGates().shortRoomDescription() 
                + this.hra.getHerniPlan().getCurrentRoom().getDescription() + "\n"
                    + this.hra.getHerniPlan().getCurrentRoom().listingOfExits() + "\n" + 
                    this.hra.getHerniPlan().getCurrentRoom().listThingsInRoom());
        while (!hra.konecHry()) {
         
            String radek = prectiString();
            System.out.println(hra.zpracujPrikaz(radek));
            if (this.hra.getHerniPlan().getPlayer().getInventory().isInInventory("princess")) {
                //this.hra.setKonecHry(true);
                break;
            }
        }

        System.out.println(hra.vratEpilog());
    }

    /**
     *  
     *
     *@return    
     */
    private String prectiString() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("> ");
        return scanner.nextLine();
    }
    
    private int prectiInt() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("> ");
        return scanner.nextInt();
    }
    
}
