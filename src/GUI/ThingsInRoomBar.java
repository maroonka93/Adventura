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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import logika.IGame;
import logika.Room;
import logika.Thing;
import utils.Observer;

/**
 *
 * @author mp
 */
public class ThingsInRoomBar extends VBox implements Observer {

    private IGame game;
    private Adventura adventura;

    public ThingsInRoomBar(IGame game) {
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
        if (!this.game.getHerniPlan().getCurrentRoom().getThingsInRoom().isEmpty()) {
            
        for (Thing i : this.game.getHerniPlan().getCurrentRoom().getThingsInRoom()) {
            item = new Button(i.getName(), new ImageView(new Image(adventura.Adventura.class.getResourceAsStream(i.getPicture()),100,100,false,false) {}));
            //ImageView pictureImageView = new ImageView(new Image(adventura.Adventura.class.getResourceAsStream("/source/SpaceMap.png")) {});
            //this.getChildren().add(item);
        
            
            
        item.setOnMouseClicked(new EventHandler <MouseEvent>() {
                @Override
                public void handle(MouseEvent click) {
                    /*String txt = ExitsBar.this.game.zpracujPrikaz("go to " + r.getName());
                adventura.Adventura.setCentralTextAppend(txt);*/
                    if (!game.konecHry()){
                        String tx = "";
                        String hotovo = "";
                        
                        
                        if (click.getButton() == MouseButton.PRIMARY) {
                            tx = "pick up "+i.getName(); 
                            hotovo = game.zpracujPrikaz(tx); 
                            adventura.textCenterPrikaz(tx);
                adventura.textCenterText(hotovo);
                        }
                        else if (click.getButton() == MouseButton.SECONDARY) {
                            tx = "look into "+i.getName(); 
                            hotovo = game.zpracujPrikaz(tx); 
                            adventura.textCenterPrikaz(tx);
                adventura.textCenterText(hotovo);
                        }
                
                
                
                //ExitsBar.this.update();
                }
                }
                });
                    
            this.getChildren().add(item);
        }
        }
        }



    public void setAdventura(Adventura adventura) {
        this.adventura = adventura;
    }
    
}
