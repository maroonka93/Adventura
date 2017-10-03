/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logika;

/**
 * Implements command for getting help.
 * @author MP
 */
public class CommandGetHelp implements ICommand {
    
    private static final String NAZEV = "get help";
    private ListOfCommands platnePrikazy;
    
    
     /**
    *  Constructor
    *  
    *  @param platnePrikazy ListOfCommands that can be used in the game, that is shown as help to the player
    */    
    public CommandGetHelp(ListOfCommands platnePrikazy) {
        this.platnePrikazy = platnePrikazy;
    }
    
    /**
     *  Basic help for player
     *  
     *  @return help
     */
    @Override
    public String proved(String... parametry) {
        return "Your task is to find the princess. Many things hidden in the rooms\n"
        + "will help you do it.\n"
        + "\n"
        + "You can use these commands: \n"
        + platnePrikazy.vratNazvyPrikazu();
    }
    
     /**
     *  returns name of command (that player writes when he wants to use that command)
     *  
     *  @ return NAZEV
     */
    @Override
      public String getNazev() {
        return NAZEV;
     }
    
}
