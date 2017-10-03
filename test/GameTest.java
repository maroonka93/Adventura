/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import logika.Game;
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
        assertEquals("throne room", hra1.getHerniPlan().getCurrentRoom().getName());
        hra1.zpracujPrikaz("go to surroundings");
        assertEquals(false, hra1.konecHry());
        assertEquals("surroundings", hra1.getHerniPlan().getCurrentRoom().getName());
        hra1.zpracujPrikaz("go to church");
        assertEquals(false, hra1.konecHry());
        assertEquals("church", hra1.getHerniPlan().getCurrentRoom().getName());
        
        assertEquals("beggarsCoat", hra1.getHerniPlan().getCurrentRoom().returnThingInRoom("beggarsCoat").getName());
        hra1.zpracujPrikaz("pick up beggarsCoat");
        assertEquals(false, hra1.konecHry());    
        assertEquals("church", hra1.getHerniPlan().getCurrentRoom().getName());
        assertEquals(null, hra1.getHerniPlan().getCurrentRoom().returnThingInRoom("beggarsCoat"));
        assertTrue(hra1.getHerniPlan().getPlayer().getInventory().isInInventory("beggarsCoat"));

        hra1.zpracujPrikaz("end game");
        assertEquals(true, hra1.konecHry());
    }

}
