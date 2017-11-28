/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

/**
 * Class CommandEndGame implements command "end game".
 * 
 * @author MP
 */
public class CommandEndGame implements ICommand {
    
    private static final String NAME = "end game";

    private Game game;

    /**
     *  Constructor
     *  
     *  @param game game that is to be ended
     */    
    public CommandEndGame(Game game) {
        this.game = game;
    }

    /**
     * If command has two words "end game", it ends, otherwise it keeps running.
     * 
     * @return message for player
     */

    @Override
    public String doCommand(String... parametry) {
        if (parametry.length > 0) {
            return "End what? I don't understand why there's a word after the command.";
        }
        else {
            game.setEndOfGame(true);
            return "Game ended with command end game.";
        }
    }

    /**
     *  return name of the command
     *  
     *  @ return NAME
     */
    @Override
    public String getName() {
        return NAME;
    }
    
}
