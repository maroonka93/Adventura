/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

/**
 *
 * 
 * @author MP
 */
public interface ICommand {
    
    /**
     *  
     *  
     *  @param parametres 
     * @return  String output
     *  
     */
    public String doCommand(String... parametres);
    
    /**
     *  
     *  
     *  @return name of command
     */
	public String getName();
    
}
