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
public class PropertyField extends Field{
    private boolean isThereHouse;
    private boolean isItOwned;

    /**
    * This is a constructor for creating Property
    * We are calling constructor from its super class.
    * Because it is created new there is neither owner nor house.
    */
    public PropertyField() {
        super();
        this.owner = null;
        this.isItOwned = false;
        this.isThereHouse = false;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
        this.isItOwned = true;
    }

    /**
    * By calling this method we are changing isThereHouse from false to true.
    */
    public void buildHouse() {
        this.isThereHouse = true;
    }

    /**
    * @param player
    * This method sees if the Property is owned or not. If it is owned by somebody you are paying fee to the owner
    * If it is not owned Player decides if he wants to buy or not.
    */
    @Override
    public boolean stepped(Player player) {
        if(isItOwned && !isThereHouse && owner != player){
            if(player.canPay(500)){
                player.substractBalance(500);
                owner.addBalance(500);
            }
            else{
                return false;
            }
        }
        else if(isItOwned && isThereHouse && owner != player){
            if(player.canPay(2000)){
                player.substractBalance(2000);
                owner.addBalance(2000);
            }
            else{
                return false;
            }
        }
        else if(owner == player && !isThereHouse && player.canBuildHouse()){
            player.buildHouse();
            buildHouse();
        }
        else if(!isItOwned && player.canBuyProperty()){
            player.buyProperty();
            setOwner(player);
        }
        return true;
    }

    /**
    * By calling this method we are resetting all its attributes.
    */
    @Override
    public void reset() {
        this.owner = null;
        this.isItOwned = false;
        this.isThereHouse = false;
    }
    
}
