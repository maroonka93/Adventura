/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import logic.IGame;
import logic.Thing;
import utils.Observer;

/**
 * A vertical bar of buttons with pictures of things in player's inventory
 * @author mp
 */
public class InventoryBar extends VBox implements Observer{
    
    private IGame game;

    public InventoryBar(IGame game) {
        this.game = game;
        game.getGamePlan().registerObserver(this);
        update();
    }

    /*
    * for a new game registers a new Observer and updates
    */
    public void newGame(IGame newGame) {
        game.getGamePlan().removeObserver(this);
        game = newGame;
        game.getGamePlan().registerObserver(this);
        update();
    }

    /*
    * on update creates new Button for each thing in player's inventory
    * buttons consist of an image on top and name of the thing underneath it
    */
    @Override
    public void update() {
        this.getChildren().removeAll(getChildren());
        Button item = null;
        for (Thing i : this.game.getGamePlan().getPlayer().getInventory().getInInventory()) {
            item = new Button(i.getName(), new ImageView(new Image(adventura.Adventura.class.getResourceAsStream(i.getPicture()),100,100,false,false) {}));
            this.getChildren().add(item);
            item.setContentDisplay(ContentDisplay.TOP);
        }
        
    }
    
}
