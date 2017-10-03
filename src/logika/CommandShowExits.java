/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logika;

/**
 * Command that gives the player a list of exists from the room he currently finds himself in.
 * @author Míša
 */
public class CommandShowExits implements ICommand {
    
    private static final String NAZEV = "show exits";

    private GamePlan plan;

    /**
     *
     * @param plan game plan, where rooms with exits are
     */
    public CommandShowExits(GamePlan plan) {
        this.plan = plan;
    }
    
    

    @Override
    public String proved(String... parametry) {
        // nothing should be after this command
        if (parametry.length > 0) {
            return "Show what? I don't understand, why there's another word after this command.";
        }
        else {
            return this.plan.getCurrentRoom().listingOfExits();
        }
    }

    @Override
    public String getNazev() {
        return this.NAZEV;
    }
    
}
