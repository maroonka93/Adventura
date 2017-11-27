/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import adventura.Adventura;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import logika.IGame;
import logika.Room;
import logika.Thing;
import utils.Observer;

/**
 *
 * @author mp
 */
public class ExitsBar extends VBox implements Observer {
    
    private IGame game;
    private Adventura adventura;

    public ExitsBar(IGame game) {
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
        for (Room r : this.game.getHerniPlan().getCurrentRoom().getExits()) {
            item = new Button(r.getName());
            //ImageView pictureImageView = new ImageView(new Image(adventura.Adventura.class.getResourceAsStream("/source/SpaceMap.png")) {});
            
            item.setOnAction(new EventHandler <ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    /*String txt = ExitsBar.this.game.zpracujPrikaz("go to " + r.getName());
                adventura.Adventura.setCentralTextAppend(txt);*/
                    if (!game.konecHry()){
                String tx = "go to "+r.getName(); 
                String hotovo = game.zpracujPrikaz(tx); 
                adventura.textCenterPrikaz(tx);
                adventura.textCenterText(hotovo);
                //ExitsBar.this.update();
                }
                }
                });
                    
             this.getChildren().add(item);       
        
    }

    
    
}

    public void setAdventura(Adventura adventura) {
        this.adventura = adventura;
    }
    
}
