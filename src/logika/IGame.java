/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logika;

/**
 *
 * @author MP
 */
public interface IGame {
    
   
    /**
     *  
     * @return String
     */
    public String vratUvitani();
    
    /**
     *  
     * @return String
     */
    public String vratEpilog();
    
    /** 
     * 
     * @return boolean
     */
     public boolean konecHry();
     
      /**
     *  
     *
     *@param radek  
     *@return String
     */
     public String zpracujPrikaz(String radek);
   
    
     /**
     *  
     *  
     *  @return GamePlan
     */
     public GamePlan getHerniPlan();

    public void setKonecHry(boolean b);
    
}
