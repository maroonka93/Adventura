/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import utils.Observer;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import logic.IGame;

/**
 * shows a map of game plan, uses a dot to signify the current room
 * @author mp
 */
public class Map extends AnchorPane implements Observer {
    
    private IGame game;
    private Circle dot;

    public Map(IGame game) {
        this.game = game;
        game.getGamePlan().registerObserver(this);
        init();
    }

    /*
    * initializes map - picture and dot
    */
    private void init() {
        ImageView pictureImageView = new ImageView(new Image(adventura.Adventura.class.getResourceAsStream("/sources/SpaceMap.png")) {});

        dot = new Circle(12, Paint.valueOf("pink"));
        
        this.getChildren().addAll(pictureImageView, dot);
        update();
        
    }
    
    /*
    * on new game removes previous Observer and registers a new one, updates
    */
    public void newGame(IGame newGame) {
        game.getGamePlan().removeObserver(this);
        game = newGame;
        game.getGamePlan().registerObserver(this);
        update();
    }

    /*
    * sets location of dot, updates with change of current room
    */
    @Override
    public void update() {
        this.setTopAnchor(dot, game.getGamePlan().getCurrentRoom().getPosTop());
        this.setLeftAnchor(dot, game.getGamePlan().getCurrentRoom().getPosLeft());
    }
    
}
