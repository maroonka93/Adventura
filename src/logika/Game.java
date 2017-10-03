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
        this.platnePrikazy.vlozPrikaz(new CommandDrawMap());
    }

    /**
     *  Returns introduction to the game
     * @return String introduction
     */
    public String vratUvitani() {
        return "There was once a princess, charming and stunning past " + "\n"
                + "anyones imagination, a delicate creature everyone adored. The " + "\n"
                + "Princess was named Little Beast because when her mother gave birth, " + "\n"
                + "the first words she uttered were: 'that little beast almost gave me a hemorrhoid'. " + "\n"
                + "So as it was in tradition, she had to be named something out of the mother's " + "\n"
                + "first words, and Princess Hemorrhoid was just too horrid to inflict " + "\n"
                + "on the royal get. She lived in a humble castle, in country which was " + "\n"
                + "neither big or small. Her father, the King of Dragoland, was a wise old man" + "\n"
                + " and thus survived his daily rutine and conversation with the " + "\n"
                + "Queen by aiming for the bottom of the cup. The young princess usually " + "\n"
                + "spent her days playing in the castle dungeons. 'It is only apropriate for a beast' " + "\n"
                + "as her mother often said. One day however, she went for a walk around the castle " + "\n"
                + "walls where there was a forest full of trees. Little Beast was the most beautiful" + "\n"
                + " of all the land. Her long blonde hair and big green eyes meant that people " + "\n"
                + "noticed her wherever she went. As she entered the forest, she noticed " + "\n"
                + "something moving among the tree branches, but couldn’t see who or what it was… " + "\n"
                + "Suddenly, an enormous dragon came flying out of the undergrowth and grabbed " + "\n"
                + "her with his claws. 'The one time i go out *sigh*' were the last words " + "\n"
                + "the poor girl has uttered as the notoriously fearceful and incredibly " + "\n"
                + "dull flying lizard carried her away. Some speculate dragons are evil princess" + "\n"
                + "possesed by dark witch craft on a eternal hunt for Princesses, others say " + "\n"
                + "the stupid dragon confused her hair for gold and her eyes for emeralds." + "\n"
                + "Imediately the King called upon the brave men of Dragoland to find the Beast ... " + "\n"
                + "and the dragon that took her. A Priest, Wise man and a Brave Warrior feel " + "\n"
                + "the call of duty resonate in their chest and come to aid the King ... " + "\n\n"
                + "We all gotta have a profession, eh? How about you chose what you'd wanna be..." + "\n" 
                + "But I gotta warn you, each profession has its perks, choose wisely!" + "\n"
                + "You can become a Priest (1), a Wise Man (2) or a Brave Warrior (3)." + "\n"
                + "A Priest gets a free bread, a Wise Man a free key and a Brave Warrior a free rope." + "\n"
                + "And trust me, they will come in handy! Which is it going to be? (Type number of chosen profession.)";
               
    }
    
    /**
     *  returns a goodbye
     * @return String epilogue
     */
    public String vratEpilog() {
        return "Thx for playing. Hope to see you here again!";
    }
    
    /** 
     * returns true if game is over;
     * @return boolean konecHry
     */
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
    public void setKonecHry(boolean konecHry) {
        this.konecHry = konecHry;
    }
    
     /**
     *  returns game plan used in this game
     *  
     *  @return     game plan
     */
     public GamePlan getHerniPlan(){
        return herniPlan;
     }
    
}
