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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import logika.Game;
import logika.IGame;
import uiText.TextoveRozhrani;

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
        /*IGame hra = new Game();
        TextoveRozhrani ui = new TextoveRozhrani(hra);
        ui.hraj();*/
        if (args.length == 0) {
            launch(args);
        }
        else{
            if (args[0].equals("-txt")) {
                IGame game = new Game();
                TextoveRozhrani textHra = new TextoveRozhrani(game);
                textHra.hraj();
            }
            else{
                System.out.println("Neplatny parametr");
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
        centralText.setMaxSize(600, 400);
        centralText.setText(game.vratUvitani());
        centralText.setEditable(false);
        borderPane.setCenter(centralText);
        
        Label enterCommandLabel = new Label("Enter command: ");
        enterCommandLabel.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        
        enterCommand = new TextField("...");
        enterCommand.setOnAction(new EventHandler<ActionEvent>() {
        
        @Override
            public void handle(ActionEvent event) {

                String vstupniPrikaz = enterCommand.getText();
                String odpovedHry = game.zpracujPrikaz(vstupniPrikaz);
                
                centralText.appendText("\n" + vstupniPrikaz + "\n");
                centralText.appendText("\n" + odpovedHry + "\n");
                
                enterCommand.setText("");
                
                if (game.getHerniPlan().getPlayer().getInventory().isInInventory("princess")) {
                    game.setKonecHry(true);
                    enterCommand.setEditable(false);
                    centralText.appendText(game.vratEpilog());
                }
            }
    });
        
        FlowPane bottomPane = new FlowPane();
        bottomPane.setAlignment(Pos.CENTER);
        bottomPane.getChildren().addAll(enterCommandLabel, enterCommand);
        
        //borderPane.setLeft(map);
        borderPane.setBottom(bottomPane);
        borderPane.setTop(menu);
        //borderPane.setRight(invBar);
        
        
        invBar.update();
        //borderPane.setLeft(invBar);
        
        //borderPane.getChildren().addAll(invBar, invLabel);
        Label invLabel = new Label("Inventory: ");
        invLabel.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        invLabel.setAlignment(Pos.TOP_LEFT);
        VBox vbox = new VBox();
        vbox.getChildren().addAll(invLabel, invBar);
        vbox.setMinWidth(100);
        //vbox.autosize();
        //vbox.visibleProperty();
        borderPane.setRight(vbox);
        
        Label exitsLabel = new Label("Exits: ");
        exitsLabel.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        Label thingsLabel = new Label("Things in this room: ");
        thingsLabel.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        HBox hboxExits = new HBox();
        hboxExits.getChildren().addAll(exitsBar);
        /*HBox hboxThings = new HBox();
        hboxThings.setLayoutX(1);
        hboxThings.getChildren().addAll(things);*/
        GridPane grid = new GridPane();
        grid.setLayoutX(1);
        grid.setLayoutY(2);
        grid.getChildren().addAll(things);
        VBox buttons = new VBox();
        buttons.getChildren().addAll(map, exitsLabel, hboxExits, thingsLabel, grid);
        //vbox.autosize();
        //vbox.visibleProperty();
        borderPane.setLeft(buttons);
        
        Scene scene = new Scene(borderPane, 1200, 500);
        primaryStage.setTitle("Adventura");
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

    /*public void setCentralTextAppend(String appended) {
        centralText.appendText(appended);
    }*/
    
    public void textCenterPrikaz(String radek) 
    {
         centralText.appendText("\n\n" + radek + "\n");;   
    }
    
    public void textCenterText(String text) 
    {
         centralText.appendText("\n\n" + text + "\n");;   
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
