/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import main.Dragoland;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyCombination;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import logic.Game;
import logic.IGame;

/**
 * creates a menu with game and help properties
 * @author mp
 */
public class Menu extends MenuBar{
    
    private IGame game;
    
    private Dragoland adventura;

    public Menu(IGame game, Dragoland adventura) {
        this.game = game;
        this.adventura = adventura;
        init();
    }

    /*
    * sets up menu
    * menu consists of Game (New Game, End Game) and Help (About, Help)
    * New Game resets the entire game, End Game ends the game instantly and closes the window
    * About gives basic information about game in a pop-up window, Help opens a new window with HTML file
    */
    private void init() {
        javafx.scene.control.Menu newFile = new javafx.scene.control.Menu("Game");
        javafx.scene.control.Menu help = new javafx.scene.control.Menu("Help");
        
        MenuItem newGame = new MenuItem("New Game");
        newGame.setAccelerator(KeyCombination.keyCombination("Ctrl+R"));
        
        MenuItem endGame = new MenuItem("End Game");
        endGame.setAccelerator(KeyCombination.keyCombination("Ctrl+Q"));
        
        newFile.getItems().addAll(newGame, endGame);
        
        MenuItem about = new MenuItem("About");
        newGame.setAccelerator(KeyCombination.keyCombination("Ctrl+A"));
        
        MenuItem helpItem = new MenuItem("Help");
        newGame.setAccelerator(KeyCombination.keyCombination("Ctrl+H"));
        
        help.getItems().addAll(about, helpItem);
        
        this.getMenus().addAll(newFile, help);
        
        endGame.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                System.exit(0);
            }
        });
        
        newGame.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                game = new Game();
                adventura.getMap().newGame(game);
                adventura.setGame(game);
                adventura.getCentralText().setText(game.returnWelcomeMessage());
                adventura.getMap().newGame(game);
                adventura.getExitsBar().newGame(game);
                adventura.getInvBar().newGame(game);
                adventura.getThings().newGame(game);
            }
        });
        
        about.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
            
                Alert aboutAlert = new Alert(Alert.AlertType.INFORMATION);
                
                aboutAlert.setTitle("About");
                aboutAlert.setHeaderText("Dragoland adventure");
                aboutAlert.setContentText("by Michaela Pavlickova (pavm05)");
                aboutAlert.initOwner(adventura.getStage());
                
                aboutAlert.showAndWait();
            }
        });
        
        helpItem.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                Stage stage = new Stage();
                stage.setTitle("Help");
                
                WebView webView = new WebView();
                
                webView.getEngine().load(Dragoland.class.getResource("/sources/help.html").toExternalForm());
                
                stage.setScene(new Scene(webView, 500,500));
                stage.show();
            
            }
        });
        
        
    }

    
}
