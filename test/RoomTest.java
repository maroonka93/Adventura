/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import logika.Room;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author MP
 */
public class RoomTest {
    
    public RoomTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test
    public  void testLzeProjit() {		
        Room prostor1 = new Room("hala");
        Room prostor2 = new Room("bufet");
        prostor1.setExit(prostor2);
        prostor2.setExit(prostor1);
        assertEquals(prostor2, prostor1.returnNeighbor("bufet"));
        assertEquals(null, prostor2.returnNeighbor("pokoj"));
    }
    
}
