/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logika;

/**
 *
 * 
 * @author MP
 */
public interface ICommand {
    
    /**
     *  
     *  
     *  @param parametry 
     * @return  String output
     *  
     */
    public String proved(String... parametry);
    
    /**
     *  
     *  
     *  @return nazev prikazu
     */
	public String getNazev();
    
}
