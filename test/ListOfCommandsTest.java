/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import logic.CommandDrawMap;
import logic.Game;
import logic.CommandGoTo;
import logic.CommandEndGame;
import logic.CommandLookInto;
import logic.CommandPickUp;
import logic.CommandShowExits;
import logic.CommandShowInventory;
import logic.ListOfCommands;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author MP
 */
public class ListOfCommandsTest {
    
    private Game hra;
    private CommandEndGame prKonec;
    private CommandGoTo prJdi;
    private CommandPickUp prPickUp;
    private CommandLookInto prLookInto;
    private CommandShowInventory prShowIn;
    private CommandShowExits prShowEx;
    private CommandDrawMap prDrawMap;
    
    @Before
    public void setUp() {
        hra = new Game();
        prKonec = new CommandEndGame(hra);
        prJdi = new CommandGoTo(hra.getGamePlan());
        prPickUp = new CommandPickUp(hra.getGamePlan());
        prLookInto = new CommandLookInto(hra.getGamePlan());
        prShowIn = new CommandShowInventory(hra.getGamePlan());
        prShowEx = new CommandShowExits(hra.getGamePlan());
        prDrawMap = new CommandDrawMap();
    }

    @Test
    public void testVlozeniVybrani() {
        ListOfCommands seznPrikazu = new ListOfCommands();
        seznPrikazu.addCommand(prKonec);
        seznPrikazu.addCommand(prJdi);
        seznPrikazu.addCommand(prPickUp);
        seznPrikazu.addCommand(prLookInto);
        seznPrikazu.addCommand(prShowIn);
        seznPrikazu.addCommand(prShowEx);
        seznPrikazu.addCommand(prDrawMap);
        assertEquals(prKonec, seznPrikazu.returnCommand("end game"));
        assertEquals(prJdi, seznPrikazu.returnCommand("go to"));
        assertEquals(null, seznPrikazu.returnCommand("get help"));
        assertEquals(prPickUp, seznPrikazu.returnCommand("pick up"));
        assertEquals(prLookInto, seznPrikazu.returnCommand("look into"));
        assertEquals(prShowIn, seznPrikazu.returnCommand("show inventory"));
        assertEquals(prShowEx, seznPrikazu.returnCommand("show exits"));
        assertEquals(prDrawMap, seznPrikazu.returnCommand("draw map"));
    }
    @Test
    public void testJePlatnyPrikaz() {
        ListOfCommands seznPrikazu = new ListOfCommands();
        seznPrikazu.addCommand(prKonec);
        seznPrikazu.addCommand(prJdi);
        assertEquals(true, seznPrikazu.isCommandValid("end game"));
        assertEquals(true, seznPrikazu.isCommandValid("go to"));
        assertEquals(false, seznPrikazu.isCommandValid("lookInto"));
        assertEquals(false, seznPrikazu.isCommandValid("Konec"));
    }
    
    @Test
    public void testNazvyPrikazu() {
        ListOfCommands seznPrikazu = new ListOfCommands();
        seznPrikazu.addCommand(prKonec);
        seznPrikazu.addCommand(prJdi);
        String nazvy = seznPrikazu.returnNamesOfCommands();
        assertEquals(true, nazvy.contains("end game"));
        assertEquals(true, nazvy.contains("go to"));
        assertEquals(false, nazvy.contains("napoveda"));
        assertEquals(false, nazvy.contains("Konec"));
    }
    
}
