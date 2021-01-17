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
public class Player {
    protected String name;
    protected int balance;
    protected boolean runOutOfMoney;
    protected int position;
    protected int numOfProperties;
    
    /**
    * This is a constructor for creating player with a given name
    * @param name
    */
    public Player(String name) {
        this.balance = 10000;
        this.name = name;
        this.runOutOfMoney = false;
        this.position = 0;
        this.numOfProperties = 0;
    }
    
    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
    
    public boolean isRunOutOfMoney() {
        return runOutOfMoney;
    }
    
    /**
    * @return true if the balance is above or equal to 1000, false otherwise
    */
    public boolean canBuyProperty() {
        return this.balance >= 1000;
    }
    
    /**
    * @return true if the balance is above or equal to 4000, false otherwise
    */
    public boolean canBuildHouse() {
        return this.balance >= 4000;
    }
    
    /**
    * This method increases numOfProperties by one and subtracts the 1000 from Balance.
    */
    public void buyProperty(){
        this.numOfProperties++;
        substractBalance(1000);
    }
    
    /**
    * This method subtracts the 4000 from Balance.
    */
    public void buildHouse(){
        substractBalance(4000);
    }
    
    /**
    * @param cash
    * It increases the balance with the given parameter.
    */
    public void addBalance(int cash) {
        this.balance += cash;
    }
    
    /**
    * @param cash
    * It decreases the balance with the given parameter.
    */
    public void substractBalance(int cash) {
        this.balance -= cash;
    }
    
    /**
    * If player runs out of money then he loses properties.
    * We also set runOutOfMoney to true as well as the balance to 0.
    */
    public void setRunOutOfMoney() {
        this.runOutOfMoney = true;
        this.numOfProperties = 0;
        this.balance = 0;
    }
    
    /**
    * @param fee
    * @return true if player can pay given fee
    * otherwise it will return false.
    */
    public boolean canPay(int fee){
        return this.balance >= fee;
    }

    @Override
    public String toString() {
        return name + " has " + balance + " money and " + numOfProperties + " properties ";
    }
  
}
