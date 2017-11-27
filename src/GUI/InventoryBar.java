/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Paint;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import logika.IGame;
import logika.Thing;
import utils.Observer;

/**
 *
 * @author mp
 */
public class InventoryBar extends VBox implements Observer{
    
    private IGame game;

    public InventoryBar(IGame game) {
        this.game = game;
        game.getHerniPlan().registerObserver(this);
        //this.newGame(game);
        update();
    }


    /*private void init() {
        ImageView pictureImageView = new ImageView(new Image(adventura.Adventura.class.getResourceAsStream("/source/SpaceMap.png")) {});
        
        this.getChildren().addAll(pictureImageView);
        update();
        
    }*/
    
    public void newGame(IGame newGame) {
        game.getHerniPlan().removeObserver(this);
        game = newGame;
        game.getHerniPlan().registerObserver(this);
        update();
    }

    @Override
    public void update() {
        this.getChildren().removeAll(getChildren());
        Button item = null;
        for (Thing i : this.game.getHerniPlan().getPlayer().getInventory().getInInventory()) {
            item = new Button(i.getName(), new ImageView(new Image(adventura.Adventura.class.getResourceAsStream(i.getPicture()),100,100,false,false) {}));
            //ImageView pictureImageView = new ImageView(new Image(adventura.Adventura.class.getResourceAsStream("/source/SpaceMap.png")) {});
            this.getChildren().add(item);
        }
        
    }
    
}
