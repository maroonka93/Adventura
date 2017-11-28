/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

/**
 *
 * @author MP
 */
public interface IGame {
    
   
    /**
     *  
     * @return String
     */
    public String returnWelcomeMessage();
    
    /**
     *  
     * @return String
     */
    public String returnEpilogue();
    
    /** 
     * 
     * @return boolean
     */
     public boolean endOfGame();
     
      /**
     *  
     *
     *@param line  
     *@return String
     */
     public String executeCommand(String line);
   
    
     /**
     *  
     *  
     *  @return GamePlan
     */
     public GamePlan getGamePlan();

    public void setEndOfGame(boolean b);
    
}
