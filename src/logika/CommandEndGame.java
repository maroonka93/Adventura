/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logika;

/**
 * Class CommandEndGame implements command "end game".
 * 
 * @author MP
 */
public class CommandEndGame implements ICommand {
    
    private static final String NAZEV = "end game";

    private Game hra;

    /**
     *  Constructor
     *  
     *  @param hra game that is to be ended
     */    
    public CommandEndGame(Game hra) {
        this.hra = hra;
    }

    /**
     * If command has one word "konec", it ends, otherwise it keeps running.
     * 
     * @return message for player
     */

    @Override
    public String proved(String... parametry) {
        if (parametry.length > 0) {
            return "UkonÄŤit co? NechĂˇpu, proÄŤ jste zadal druhĂ© slovo.";
        }
        else {
            hra.setKonecHry(true);
            return "hra ukonÄŤena pĹ™Ă­kazem konec";
        }
    }

    /**
     *  return name of the command
     *  
     *  @ return NAZEV
     */
    @Override
    public String getNazev() {
        return NAZEV;
    }
    
}
