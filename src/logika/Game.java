/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logika;

/**
 * Game puts together the game's necessities like Game Plan with Rooms and Things, List Of Commands.
 * 
 * 
 * @author MP
 */
public class Game implements IGame {
 
    private ListOfCommands platnePrikazy;    // list of commands that can be used
    private GamePlan herniPlan;
    private boolean konecHry = false;

    /**
     *  Creates game, initializes rooms and things (via class GamePlan) and list of commands
     */
    public Game() {
        herniPlan = new GamePlan();
        platnePrikazy = new ListOfCommands();
        platnePrikazy.vlozPrikaz(new CommandGetHelp(platnePrikazy));
        platnePrikazy.vlozPrikaz(new CommandGoTo(herniPlan));
        platnePrikazy.vlozPrikaz(new CommandEndGame(this));
        this.platnePrikazy.vlozPrikaz(new CommandPickUp(herniPlan));
        this.platnePrikazy.vlozPrikaz(new CommandLookInto(herniPlan));
        this.platnePrikazy.vlozPrikaz(new CommandShowInventory(herniPlan));
        this.platnePrikazy.vlozPrikaz(new CommandShowExits(herniPlan));
        //this.platnePrikazy.vlozPrikaz(new CommandDrawMap());
    }

    /**
     *  Returns introduction to the game
     * @return String introduction
     */
    @Override
    public String vratUvitani() {
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
    public String vratEpilog() {
        return "You reach for the bread in your bag and throw it as far away as you can! The dragon," + "\n"
                + "under the impression it's a precious stone, chases after it. You grab the princess and you both run" + "\n" 
                        + " as fast as you can toward the castle!"+ "\n" + "Thx for playing. Hope to see you here again!";
    }
    
    /** 
     * returns true if game is over;
     * @return boolean konecHry
     */
    @Override
     public boolean konecHry() {
        return konecHry;
    }

    /**
     *  splits line into 2 words of command and given parameter
     *  than finds out what command it is (if it is one)
     *  than does the command
     *
     *@param  radek  text that the player has entered
     *@return          message that is shown to player
     */
    
    @Override
     public String zpracujPrikaz(String radek) {
        String [] slova = radek.split("[ \t]+");
        String slovoPrikazu = slova[0] + " " + slova[1];
        String []parametry = new String[slova.length-2];
        for(int i=0 ;i<parametry.length;i++){
           	parametry[i]= slova[i+2];  	
        }
        String textKVypsani=" .... ";
        if (platnePrikazy.jePlatnyPrikaz(slovoPrikazu)) {
            ICommand prikaz = platnePrikazy.vratPrikaz(slovoPrikazu);
            textKVypsani = prikaz.proved(parametry);
        }
        else {
            textKVypsani="I don't know this command.";
        }
        return textKVypsani;
    }
    
    
     /**
     *  sets end of the game
     *  
     *  @param  konecHry  hodnota false= konec hry, true = hra pokraÄŤuje
     */
    @Override
    public void setKonecHry(boolean konecHry) {
        this.konecHry = konecHry;
    }
    
     /**
     *  returns game plan used in this game
     *  
     *  @return     game plan
     */
    @Override
     public GamePlan getHerniPlan(){
        return herniPlan;
     }
    
     /*public void gameIsWon() {
         this.setKonecHry(true);
         this.vratEpilog();
     }*/
     
}
