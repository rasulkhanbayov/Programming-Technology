/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capitaly;

/**
 *
 * @author rasul
 */
public abstract class Field {
    protected Player owner;
    
    /**
    * This is a constructor for creating basic Field
    */
    public Field() {
        
    }
    
    public Player getOwner() {
        return owner;
    }
    
    public abstract boolean stepped(Player player);
    public abstract void reset();
    
}
