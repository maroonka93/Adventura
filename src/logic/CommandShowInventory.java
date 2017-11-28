/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

/**
 * Command that shows things currently in the inventory.
 * @author Míša
 */
public class CommandShowInventory implements ICommand {
    
    private static final String NAME = "show inventory";

    private GamePlan plan;

    /**
     *
     * @param plan game plan, where player with his inventory is
     */
    public CommandShowInventory(GamePlan plan) {
        this.plan = plan;
    }

    @Override
    public String doCommand(String... parametres) {
        // there should be no word behind this command
        if (parametres.length > 0) {
            return "Show what? I don't understand, why there's another word after this command.";
        }
        else {
            return this.plan.getPlayer().getInventory().listingThingsInInventory();
        }
    }

    @Override
    public String getName() {
        return this.NAME;
    }
    
}
