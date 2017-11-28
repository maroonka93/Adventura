/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

/**
 * Draws map of the adventure.
 * @author Míša
 */
public class CommandDrawMap implements ICommand {
    
    private static final String NAME = "draw map";

    @Override
    public String doCommand(String... parametres) {
        if (parametres.length > 0) {
            return "Show what? I don't understand, why there's another word after this command.";
        }
        else {
            System.out.println("-------------------------------------------------------------------------------------");
            System.out.println("| |          |  |          | | |          |  |          | | |          |        |   |");
            System.out.println("| | bedroom  |  | kitchen  | | | stables  |  |  church  | | | cemetery |        |   |");
            System.out.println("| |          |  |          | | |          |  |          | | |          |        | c |");
            System.out.println("|  ----------    ----------  |  ----------    ----------  |  ----------         | l |");
            System.out.println("|           CASTLE           |        SURROUNDINGS        |         FORREST     | i |");
            System.out.println("|  ----------                                 ----------  |  -------------------| f |");
            System.out.println("| |          |               |               |          | | |       trail       | f |");
            System.out.println("| | wardrobe |               |               |    inn   | |  -------------------|   |");
            System.out.println("| |          |               |               |          | |                     |   |");
            System.out.println(" ----------------------------------------------------------------------------------- ");
            System.out.println("               |                          |                                          ");
            System.out.println("               |       throne room        |                                          ");
            System.out.println("               |                          |                                          ");
            System.out.println("                --------------------------                                           ");
            return "";
        }
    }

    @Override
    public String getName() {
        return this.NAME;
    }
    
}
