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
public class CarefulPlayer extends Player{
    
    /**
    * This is a constructor for creating Careful player with a given name
    * We call constructor from its super class
    * @param name
    */
    public CarefulPlayer(String name) {
        super(name);
    }
    
    /**
    * In this method I am overriding canBuyProperty from its super class.
    */
    @Override
    public boolean canBuyProperty() {
        return (this.balance > 1000) && (this.balance / 2 > 1000);
    }
    
}
