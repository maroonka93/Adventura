/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

/**
 * Implements command for getting help.
 * @author MP
 */
public class CommandGetHelp implements ICommand {
    
    private static final String NAME = "get help";
    private ListOfCommands validCommands;
    
    
     /**
    *  Constructor
    *  
    *  @param validCommands ListOfCommands that can be used in the game, that is shown as help to the player
    */    
    public CommandGetHelp(ListOfCommands validCommands) {
        this.validCommands = validCommands;
    }
    
    /**
     *  Basic help for player
     *  
     *  @return help
     */
    @Override
    public String doCommand(String... parametres) {
        return "Your task is to find the princess. Many things hidden in the rooms\n"
        + "will help you do it.\n"
        + "\n"
        + "You can use these commands: \n"
        + validCommands.returnNamesOfCommands();
    }
    
     /**
     *  returns name of command (that player writes when he wants to use that command)
     *  
     *  @ return NAME
     */
    @Override
      public String getName() {
        return NAME;
     }
    
}
