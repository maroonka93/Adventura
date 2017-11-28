/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

/**
 * Game puts together the game's necessities like Game Plan with Rooms and Things, List Of Commands.
 * 
 * 
 * @author MP
 */
public class Game implements IGame {
 
    private ListOfCommands validCommands;    // list of commands that can be used
    private GamePlan gamePlan;
    private boolean endOfGame = false;

    /**
     *  Creates game, initializes rooms and things (via class GamePlan) and list of commands
     */
    public Game() {
        gamePlan = new GamePlan();
        validCommands = new ListOfCommands();
        validCommands.addCommand(new CommandGetHelp(validCommands));
        validCommands.addCommand(new CommandGoTo(gamePlan));
        validCommands.addCommand(new CommandEndGame(this));
        this.validCommands.addCommand(new CommandPickUp(gamePlan));
        this.validCommands.addCommand(new CommandLookInto(gamePlan));
        this.validCommands.addCommand(new CommandShowInventory(gamePlan));
        this.validCommands.addCommand(new CommandShowExits(gamePlan));
        this.validCommands.addCommand(new CommandDrawMap());
    }

    /**
     *  Returns introduction to the game
     * @return String introduction
     */
    @Override
    public String returnWelcomeMessage() {
        return "There was once a princess, charming and stunning past " + "\n"
                + "anyones imagination, a delicate creature everyone adored." + "\n"
                + "She lived in a humble castle, in country which was " + "\n"
                + "neither big or small. One day, she went for a walk around the castle " + "\n"
                + "walls where there was a forrest full of trees. As she entered the forest, she noticed " + "\n"
                + "something moving among the tree branches, but couldn’t see who or what it was… " + "\n"
                + "Suddenly, an enormous dragon came flying out of the undergrowth and grabbed " + "\n"
                + "her with his claws. 'The one time i go out *sigh*' were the last words " + "\n"
                + "the poor girl has uttered as the notoriously fearceful and incredibly " + "\n"
                + "dull flying lizard carried her away. Some speculate dragons are evil princess" + "\n"
                + "possesed by dark witch craft on a eternal hunt for Princesses, others say " + "\n"
                + "the stupid dragon confused her hair for gold and her eyes for emeralds." + "\n"
                + "Imediately the King called upon the brave men of Dragoland to find the princess " + "\n"
                + "and the dragon that took her.";
               
    }
    
    /**
     *  returns a goodbye
     * @return String epilogue
     */
    @Override
    public String returnEpilogue() {
        return "You reach for the bread in your bag and throw it as far away as you can! The dragon," + "\n"
                + "under the impression it's a precious stone, chases after it. You grab the princess and you both run" + "\n" 
                        + " as fast as you can toward the castle!"+ "\n" + 
                "\n" +"YOU WIN!!!"+ "\n" +"Thx for playing. Hope to see you here again!";
    }
    
    /** 
     * returns true if game is over;
     * @return boolean endOfGame
     */
    @Override
     public boolean endOfGame() {
        return endOfGame;
    }

    /**
     *  splits line into 2 words of command and given parameter
     *  than finds out what command it is (if it is one)
     *  than does the command
     *
     *@param  line  text that the player has entered
     *@return          message that is shown to player
     */
    
    @Override
     public String executeCommand(String line) {
        String [] words = line.split("[ \t]+");
        String wordsOfCommand = words[0] + " " + words[1];
        String []parametres = new String[words.length-2];
        for(int i=0 ;i<parametres.length;i++){
           	parametres[i]= words[i+2];  	
        }
        String textToReturn=" .... ";
        if (validCommands.isCommandValid(wordsOfCommand)) {
            ICommand command = validCommands.returnCommand(wordsOfCommand);
            textToReturn = command.doCommand(parametres);
        }
        else {
            textToReturn="I don't know this command.";
        }
        return textToReturn;
    }
    
    
     /**
     *  sets end of the game
     *  
     *  @param  endOfGame  hodnota false= konec hry, true = hra pokraÄŤuje
     */
    @Override
    public void setEndOfGame(boolean endOfGame) {
        this.endOfGame = endOfGame;
    }
    
     /**
     *  returns game plan used in this game
     *  
     *  @return     game plan
     */
    @Override
     public GamePlan getGamePlan(){
        return gamePlan;
     }
     
}
