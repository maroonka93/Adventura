/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import main.Dragoland;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import logic.IGame;
import logic.Thing;
import utils.Observer;

/**
 * creates a grid of buttons, one button for each thing in current room
 * @author mp
 */
public class ThingsInRoomBar extends GridPane implements Observer {

    private IGame game;
    private Dragoland adventura;

    public ThingsInRoomBar(IGame game) {
        this.game = game;
        game.getGamePlan().registerObserver(this);
        update();
    }
    
    /*
    * 
    */
    public void newGame(IGame newGame) {
        game.getGamePlan().removeObserver(this);
        game = newGame;
        game.getGamePlan().registerObserver(this);
        update();
    }

    /*
    * creates a grid of buttons, 2 buttons in first row, each button contains image
    * of the thing and its name below it
    * assigns command to left click (pick up) and right click (look into)
    */ 
    @Override
    public void update() {
        this.getChildren().removeAll(getChildren());
        Button item = null;
        if (!this.game.getGamePlan().getCurrentRoom().getThingsInRoom().isEmpty()) {
            
        for (Thing i : this.game.getGamePlan().getCurrentRoom().getThingsInRoom()) {
            item = new Button(i.getName(), new ImageView(new Image(main.Dragoland.class.getResourceAsStream(i.getPicture()),100,100,false,false) {}));
            item.setContentDisplay(ContentDisplay.TOP);
        
            
            
        item.setOnMouseClicked(new EventHandler <MouseEvent>() {
                @Override
                public void handle(MouseEvent click) {
 
                    if (!game.endOfGame()){
                        String command = "";
                        String gameAnswer = "";
                        
                        
                        if (click.getButton() == MouseButton.PRIMARY) {
                            command = "pick up "+i.getName(); 
                            gameAnswer = game.executeCommand(command);
                            adventura.appendCommandFromButton(command);
                            
                            if (game.getGamePlan().getPlayer().getInventory().isInInventory("princess")) {
                                game.setEndOfGame(true);
                                adventura.appendGameReplyToButtonAction(gameAnswer + "\n" + game.returnEpilogue());
                                adventura.getEnterCommand().setEditable(false);
                            }
                            else {
                                adventura.appendGameReplyToButtonAction(gameAnswer);
                            }
                        }
                        else if (click.getButton() == MouseButton.SECONDARY) {
                            command = "look into "+i.getName(); 
                            gameAnswer = game.executeCommand(command); 
                            adventura.appendCommandFromButton(command);
                adventura.appendGameReplyToButtonAction(gameAnswer);
                        }
                
                
                
                //ExitsBar.this.update();
                }
                }
                });
            
            
            if (this.getChildren().size() == 1) {
                this.addColumn(2, item);
            } 
            else if (this.getChildren().size() == 2) {
                this.addRow(2, item);
            }
            else {
                this.getChildren().add(item);
            }
        }
        }
        }



    public void setAdventura(Dragoland adventura) {
        this.adventura = adventura;
    }
    
}
