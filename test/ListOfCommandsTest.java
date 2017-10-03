/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import logika.CommandDrawMap;
import logika.Game;
import logika.CommandGoTo;
import logika.CommandEndGame;
import logika.CommandLookInto;
import logika.CommandPickUp;
import logika.CommandShowExits;
import logika.CommandShowInventory;
import logika.ListOfCommands;
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
        prJdi = new CommandGoTo(hra.getHerniPlan());
        prPickUp = new CommandPickUp(hra.getHerniPlan());
        prLookInto = new CommandLookInto(hra.getHerniPlan());
        prShowIn = new CommandShowInventory(hra.getHerniPlan());
        prShowEx = new CommandShowExits(hra.getHerniPlan());
        prDrawMap = new CommandDrawMap();
    }

    @Test
    public void testVlozeniVybrani() {
        ListOfCommands seznPrikazu = new ListOfCommands();
        seznPrikazu.vlozPrikaz(prKonec);
        seznPrikazu.vlozPrikaz(prJdi);
        seznPrikazu.vlozPrikaz(prPickUp);
        seznPrikazu.vlozPrikaz(prLookInto);
        seznPrikazu.vlozPrikaz(prShowIn);
        seznPrikazu.vlozPrikaz(prShowEx);
        seznPrikazu.vlozPrikaz(prDrawMap);
        assertEquals(prKonec, seznPrikazu.vratPrikaz("end game"));
        assertEquals(prJdi, seznPrikazu.vratPrikaz("go to"));
        assertEquals(null, seznPrikazu.vratPrikaz("get help"));
        assertEquals(prPickUp, seznPrikazu.vratPrikaz("pick up"));
        assertEquals(prLookInto, seznPrikazu.vratPrikaz("look into"));
        assertEquals(prShowIn, seznPrikazu.vratPrikaz("show inventory"));
        assertEquals(prShowEx, seznPrikazu.vratPrikaz("show exits"));
        assertEquals(prDrawMap, seznPrikazu.vratPrikaz("draw map"));
    }
    @Test
    public void testJePlatnyPrikaz() {
        ListOfCommands seznPrikazu = new ListOfCommands();
        seznPrikazu.vlozPrikaz(prKonec);
        seznPrikazu.vlozPrikaz(prJdi);
        assertEquals(true, seznPrikazu.jePlatnyPrikaz("end game"));
        assertEquals(true, seznPrikazu.jePlatnyPrikaz("go to"));
        assertEquals(false, seznPrikazu.jePlatnyPrikaz("lookInto"));
        assertEquals(false, seznPrikazu.jePlatnyPrikaz("Konec"));
    }
    
    @Test
    public void testNazvyPrikazu() {
        ListOfCommands seznPrikazu = new ListOfCommands();
        seznPrikazu.vlozPrikaz(prKonec);
        seznPrikazu.vlozPrikaz(prJdi);
        String nazvy = seznPrikazu.vratNazvyPrikazu();
        assertEquals(true, nazvy.contains("end game"));
        assertEquals(true, nazvy.contains("go to"));
        assertEquals(false, nazvy.contains("napoveda"));
        assertEquals(false, nazvy.contains("Konec"));
    }
    
}
