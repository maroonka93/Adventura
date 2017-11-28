/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import adventura.Adventura;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyCombination;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import logika.Game;
import logika.IGame;

/**
 *
 * @author mp
 */
public class Menu extends MenuBar{
    
    private IGame game;
    
    private Adventura adventura;

    public Menu(IGame game, Adventura adventura) {
        this.game = game;
        this.adventura = adventura;
        init();
    }

    private void init() {
        javafx.scene.control.Menu newFile = new javafx.scene.control.Menu("Adventura");
        javafx.scene.control.Menu help = new javafx.scene.control.Menu("Help");
        
        MenuItem newGame = new MenuItem("New Game");
        //, new ImageView(new Image(Main.class.getResourceAsStream("/zdroje/ikona.png")))
        
        newGame.setAccelerator(KeyCombination.keyCombination("Ctrl+G"));
        MenuItem endGame = new MenuItem("End Game");
        
        newFile.getItems().addAll(newGame, endGame);
        
        MenuItem about = new MenuItem("About");
        MenuItem helpItem = new MenuItem("Help");
        
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
                adventura.getCentralText().setText(game.vratUvitani());
                adventura.getMap().newGame(game);
                adventura.getExitsBar().newGame(game);
                adventura.getInvBar().newGame(game);
                adventura.getThings().newGame(game);
            }
        });
        
        about.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
            
                Alert oProgramuAlert = new Alert(Alert.AlertType.INFORMATION);
                
                oProgramuAlert.setTitle("About");
                oProgramuAlert.setHeaderText("Dragoland adventure");
                oProgramuAlert.setContentText("by Michaela Pavlickova (pavm05)");
                oProgramuAlert.initOwner(adventura.getStage());
                
                oProgramuAlert.showAndWait();
            }
        });
        
        helpItem.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                Stage stage = new Stage();
                stage.setTitle("Napoveda");
                
                WebView webView = new WebView();
                
                webView.getEngine().load(Adventura.class.getResource("/source/help.html").toExternalForm());
                
                stage.setScene(new Scene(webView, 500,500));
                stage.show();
            
            }
        });
        
        
    }

    
}
