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
public class TacticalPlayer extends Player{
    private int counter;
    
    /**
    * This is a constructor for creating Tactical player with a given name
    * We call constructor from its super class and assign counter to 0.
    * @param name
    */
    public TacticalPlayer(String name) {
        super(name);
        counter = 0;
    }
    
    /**
    * In this method I am overriding canBuyProperty from its super class.
    */
    @Override
    public boolean canBuyProperty() {
        counter++;
        return (this.balance > 1000) && (counter % 2 == 1);
    }
    
}
