/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.util.Observable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import utils.Observer;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import logika.IGame;

/**
 *
 * @author mp
 */
public class Map extends AnchorPane implements Observer {
    
    private IGame game;
    private Circle dot;

    public Map(IGame game) {
        this.game = game;
        game.getHerniPlan().registerObserver(this);
        init();
    }


    private void init() {
        ImageView pictureImageView = new ImageView(new Image(adventura.Adventura.class.getResourceAsStream("/sources/SpaceMap.png")) {});

        dot = new Circle(12, Paint.valueOf("pink"));
        
        this.getChildren().addAll(pictureImageView, dot);
        update();
        
    }
    
    public void newGame(IGame newGame) {
        game.getHerniPlan().removeObserver(this);
        game = newGame;
        game.getHerniPlan().registerObserver(this);
        update();
    }

    @Override
    public void update() {
        this.setTopAnchor(dot, game.getHerniPlan().getCurrentRoom().getPosTop());
        this.setLeftAnchor(dot, game.getHerniPlan().getCurrentRoom().getPosLeft());
    }
    
}
