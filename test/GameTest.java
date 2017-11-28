/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import logic.Game;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author MP
 */
public class GameTest {
    
    private Game hra1;

    
     
    @Before
    public void setUp() {
        hra1 = new Game();
    }

    /***************************************************************************
     * 
     */
    @After
    public void tearDown() {
    }

    
 
    @Test
    public void testPrubehHry() {
        assertEquals("throne room", hra1.getGamePlan().getCurrentRoom().getName());
        hra1.executeCommand("go to surroundings");
        assertEquals(false, hra1.endOfGame());
        assertEquals("surroundings", hra1.getGamePlan().getCurrentRoom().getName());
        hra1.executeCommand("go to church");
        assertEquals(false, hra1.endOfGame());
        assertEquals("church", hra1.getGamePlan().getCurrentRoom().getName());
        
        assertEquals("beggarsCoat", hra1.getGamePlan().getCurrentRoom().returnThingInRoom("beggarsCoat").getName());
        hra1.executeCommand("pick up beggarsCoat");
        assertEquals(false, hra1.endOfGame());    
        assertEquals("church", hra1.getGamePlan().getCurrentRoom().getName());
        assertEquals(null, hra1.getGamePlan().getCurrentRoom().returnThingInRoom("beggarsCoat"));
        assertTrue(hra1.getGamePlan().getPlayer().getInventory().isInInventory("beggarsCoat"));

        hra1.executeCommand("end game");
        assertEquals(true, hra1.endOfGame());
    }

}
