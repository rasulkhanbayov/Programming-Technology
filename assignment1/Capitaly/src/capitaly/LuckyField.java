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
public class LuckyField extends Field{
    private int fee;
    
    /**
     * @param fee
     * This is a constructor for creating Lucky Field with given fee
     */
    public LuckyField(int fee) {
        super();
        this.fee = fee;
    }

    /**
     * @param player
     * @return true and adds fee of Lucky field to the player. 
     */
    @Override
    public boolean stepped(Player player) {
        player.addBalance(fee);
        return true;
    }

    /**
     * It is empty. Because we don't need to reset Lucky field.
     */
    @Override
    public void reset() {
        
    }
    
}
