/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import main.Dragoland;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import logic.IGame;
import logic.Room;
import utils.Observer;

/**
 *Creates a bar filled with buttons, each with one exit
 * 
 * @author mp
 */
public class ExitsBar extends HBox implements Observer {
    
    private IGame game;
    private Dragoland adventura;

    public ExitsBar(IGame game) {
        this.game = game;
        game.getGamePlan().registerObserver(this);
        update();
    }
    
    public void newGame(IGame newGame) {
        game.getGamePlan().removeObserver(this);
        game = newGame;
        game.getGamePlan().registerObserver(this);
        update();
    }

    /*
    * updates buttons every time current room changes,
    * assigns command "go to" to each button
    */
    @Override
    public void update() {
        this.getChildren().removeAll(getChildren());
        
        Button item = null;
        for (Room r : this.game.getGamePlan().getCurrentRoom().getExits()) {
            item = new Button(r.getName());
            
            item.setOnAction(new EventHandler <ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    if (!game.endOfGame()){
                        String command = "go to "+r.getName(); 
                        String gameAnswer = game.executeCommand(command); 
                        adventura.appendCommandFromButton(command);
                        adventura.appendGameReplyToButtonAction(gameAnswer);
                }
                }
                });
                    
             this.getChildren().add(item);       
        
    }
    
}

    public void setAdventura(Dragoland adventura) {
        this.adventura = adventura;
    }
    
}
