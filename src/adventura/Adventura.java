/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adventura;

import logika.Game;
import logika.IGame;
import uiText.TextoveRozhrani;

/**
 * Runnable file of adventure. Contains main.
 * @author MP
 */
public class Adventura {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        IGame hra = new Game();
        TextoveRozhrani ui = new TextoveRozhrani(hra);
        ui.hraj();
    }
    
}
