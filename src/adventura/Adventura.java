/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adventura;

import GUI.ExitsBar;
import GUI.InventoryBar;
import GUI.Map;
import GUI.Menu;
import GUI.ThingsInRoomBar;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import logic.Game;
import logic.IGame;
import uiText.TextUI;

/**
 * Runnable file of adventure. Contains main.
 * @author MP
 */
public class Adventura extends Application {
    
    private TextArea centralText;
    private IGame game;

    public void setGame(IGame game) {
        this.game = game;
    }
    
    private TextField enterCommand;
    
    private Map map;
    private Menu menu;
    private InventoryBar invBar;
    private ExitsBar exitsBar;
    private ThingsInRoomBar things;
    private Stage stage;
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        if (args.length == 0) {
            launch(args);
        }
        else{
            if (args[0].equals("-txt")) {
                IGame game = new Game();
                TextUI textGame = new TextUI(game);
                textGame.hraj();
            }
            else{
                System.out.println("Wrong parameter");
                System.exit(1);
            }
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.setStage(primaryStage);
        game = new Game();
        map = new Map(game);
        menu = new Menu (game, this);
        invBar = new InventoryBar(game);
        exitsBar = new ExitsBar(game);
        exitsBar.setAdventura(this);
        things = new ThingsInRoomBar(game);
        things.setAdventura(this);
        BorderPane borderPane = new BorderPane();
        
        centralText = new TextArea();
        centralText.setPrefHeight(400);
        centralText.setPrefWidth(600);
        centralText.setMaxSize(600, 600);
        centralText.setText(game.returnWelcomeMessage());
        centralText.setEditable(false);
        borderPane.setCenter(centralText);
        
        Label enterCommandLabel = new Label("Enter command: ");
        enterCommandLabel.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        
        enterCommand = new TextField("...");
        enterCommand.setOnAction(new EventHandler<ActionEvent>() {
        
            @Override
            public void handle(ActionEvent event) {

                String enteredCommand = enterCommand.getText();
                String gameReply = game.executeCommand(enteredCommand);
                
                centralText.appendText("\n" + enteredCommand + "\n");
                centralText.appendText("\n" + gameReply + "\n");
                
                enterCommand.setText("");
                
                if (game.getGamePlan().getPlayer().getInventory().isInInventory("princess")) {
                    game.setEndOfGame(true);
                    enterCommand.setEditable(false);
                    centralText.appendText(game.returnEpilogue());
                }
            }
    });
        
        FlowPane bottomPane = new FlowPane();
        bottomPane.setAlignment(Pos.CENTER);
        bottomPane.getChildren().addAll(enterCommandLabel, enterCommand);
        
        borderPane.setBottom(bottomPane);
        borderPane.setTop(menu);
        
        invBar.update();
        
        Label invLabel = new Label("Inventory: ");
        invLabel.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        invLabel.setAlignment(Pos.TOP_LEFT);
        VBox vbox = new VBox();
        vbox.getChildren().addAll(invLabel, invBar);
        vbox.setMinWidth(150);
        borderPane.setRight(vbox);
        
        Label exitsLabel = new Label("Exits: ");
        exitsLabel.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        Label thingsLabel = new Label("Things in this room: " + "\n" + "(left click - pick up/right click - look into)");
        thingsLabel.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        HBox hboxExits = new HBox();
        hboxExits.getChildren().addAll(exitsBar);
        GridPane grid = new GridPane();
        grid.getChildren().addAll(things);
        VBox buttons = new VBox();
        buttons.getChildren().addAll(map, exitsLabel, hboxExits, thingsLabel, grid);
        borderPane.setLeft(buttons);
        
        Scene scene = new Scene(borderPane, 1200, 700);
        primaryStage.setTitle("Dragoland");
        primaryStage.setScene(scene);
        primaryStage.show();
        enterCommand.requestFocus();
        
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public TextArea getCentralText() {
        return centralText;
    }

    public Map getMap() {
        return map;
    }
    
    public void appendCommandFromButton(String line) 
    {
         centralText.appendText("\n" + line + "\n");;   
    }
    
    public void appendGameReplyToButtonAction(String reply) 
    {
         centralText.appendText("\n" + reply + "\n");;   
    }

    public TextField getEnterCommand() {
        return enterCommand;
    }

    public InventoryBar getInvBar() {
        return invBar;
    }

    public ExitsBar getExitsBar() {
        return exitsBar;
    }

    public ThingsInRoomBar getThings() {
        return things;
    }
    
    
    
}
