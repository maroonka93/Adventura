/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.util.HashMap;
import java.util.Map;

/**
 *Class ListOfCommands - 
 * @author MP
 */
public class ListOfCommands {
    
   
    private  Map<String,ICommand> mapOfCommands;
    
   
    
    /**
     * Konstruktor
     */
    public ListOfCommands() {
        mapOfCommands = new HashMap<>();
    }
    
    
    /**
     * 
     *
     *@param command  
     */
    public void addCommand(ICommand command) {
        mapOfCommands.put(command.getName(),command);
    }
    
    /**
     * 
     *
     *@param string  
     *@return ICommand
     */
    public ICommand returnCommand(String string) {
        if (mapOfCommands.containsKey(string)) {
            return mapOfCommands.get(string);
        }
        else {
            return null;
        }
    }

    /**
     * 
     *
     *@param string  
     *@return boolean
     */
    public boolean isCommandValid(String string) {
        return mapOfCommands.containsKey(string);
    }

    /**
     *  
     *  
     *  @return String
     */
    public String returnNamesOfCommands() {
        String list = "";
        for (String wordOfCommand : mapOfCommands.keySet()){
            list += wordOfCommand + " ";
        }
        return list;
    }
    
}
