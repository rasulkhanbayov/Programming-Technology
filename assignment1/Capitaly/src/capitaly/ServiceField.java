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
public class ServiceField extends Field{
    private int fee;
    
    /**
     * @param fee
     * We are calling constructor from super class.
     * This is a constructor for creating Service Field with given fee
     */
    public ServiceField(int fee) {
        super();
        this.fee = fee;
    }

    /**
     * @param player
     * @return true if we can pay with fee of Service and subtracts if yes.
     * otherwise returns false.
     */
    @Override
    public boolean stepped(Player player) {
        if(player.canPay(fee)){
            player.substractBalance(fee);
            return true;
        } else { 
            return false;
        }
    }
    /**
     * It is empty. Because we don't need to reset Service field.
     */
    @Override
    public void reset() {
        
    }
    
}
