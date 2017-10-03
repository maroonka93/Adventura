/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logika;

import java.util.HashMap;
import java.util.Map;

/**
 *Class ListOfCommands - 
 * @author MP
 */
public class ListOfCommands {
    
   
    private  Map<String,ICommand> mapaSPrikazy;
    
   
    
    /**
     * Konstruktor
     */
    public ListOfCommands() {
        mapaSPrikazy = new HashMap<>();
    }
    
    
    /**
     * 
     *
     *@param prikaz  
     */
    public void vlozPrikaz(ICommand prikaz) {
        mapaSPrikazy.put(prikaz.getNazev(),prikaz);
    }
    
    /**
     * 
     *
     *@param retezec  
     *@return ICommand
     */
    public ICommand vratPrikaz(String retezec) {
        if (mapaSPrikazy.containsKey(retezec)) {
            return mapaSPrikazy.get(retezec);
        }
        else {
            return null;
        }
    }

    /**
     * 
     *
     *@param retezec  
     *@return boolean
     */
    public boolean jePlatnyPrikaz(String retezec) {
        return mapaSPrikazy.containsKey(retezec);
    }

    /**
     *  
     *  
     *  @return String
     */
    public String vratNazvyPrikazu() {
        String seznam = "";
        for (String slovoPrikazu : mapaSPrikazy.keySet()){
            seznam += slovoPrikazu + " ";
        }
        return seznam;
    }
    
}
