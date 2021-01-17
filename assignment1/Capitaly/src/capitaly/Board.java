/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capitaly;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author rasul
 */
public class Board {
    private int numberOfPlayers;
    private int numberOfFields;
    private ArrayList<Player> players;
    private ArrayList<Field> fields;
    private ArrayList<Integer> dices;
    
    /**
    * This is a constructor for creating Board
    * We assign every ArrayList empty.
    */
    public Board() {
        players = new ArrayList<>();
        fields = new ArrayList<>();
        dices = new ArrayList<>();
    }
    
    /**
    * @param filename
    * Here we are getting @param filename and reading from it.
    * Assigning class attributes fields, players and at the end dices respectively.
    * @throws FileNotFoundException
    * @throws InvalidInputException
    * @throws InputMismatchException
    */
    public void read(String filename) throws FileNotFoundException, InvalidInputException,InputMismatchException {
        Scanner sc = new Scanner(new BufferedReader(new FileReader(filename)));
        numberOfFields = sc.nextInt();
        for (int i = 0; i < numberOfFields; i++) {
            Field field;
            switch (sc.next()) {
                case "P":
                    field = new PropertyField();
                    fields.add(field);
                    break;
                case "L":
                    field = new LuckyField(sc.nextInt());
                    fields.add(field);
                    break;
                case "S":
                    field = new ServiceField(sc.nextInt());
                    fields.add(field);
                    break;
                default:
                    throw new InvalidInputException();
            }
        }
        numberOfPlayers = sc.nextInt();
        for (int i = 0; i < numberOfPlayers; i++) {
            Player player;
            String name = sc.next();
            switch (sc.next()) {
                case "G":
                    player = new GreedyPlayer(name);
                    players.add(player);
                    break;
                case "T":
                    player = new TacticalPlayer(name);
                    players.add(player);
                    break;
                case "C":
                    player = new CarefulPlayer(name);
                    players.add(player);
                    break;
                default:
                    throw new InvalidInputException();
            }
        }
        while (sc.hasNext()) {
            int number = sc.nextInt();
            while(number > numberOfFields){
                number = number - numberOfFields;
            }
            dices.add(number);
        }
    }
    
    /**
    * This method goes round by round, reads dice number, and increases position of player
    * by that number. Then it looks which field is it and does operations.
    */
    public void run(){
        int rounds = dices.size() / numberOfPlayers;
        int turn = 0;
        for(int i = 1; i <= rounds;i++){
            System.out.println(" " + i + " Round");
            for(Player p : players){
                if(!p.isRunOutOfMoney()){
                    if(p.getPosition()+dices.get(turn)>numberOfFields){
                    p.setPosition((p.getPosition()+(dices.get(turn)))-numberOfFields);
                    }
                    else{
                    p.setPosition(p.getPosition()+(dices.get(turn)));
                    }  
                    if (fields.get(p.getPosition()-1).stepped(p)){
                        
                    } else {
                        resetforPlayer(p);
                    }
                }
                turn++;  
                System.out.println(p);
            }
            System.out.println(" End of the " + i + " Round.");
        }
    }

    /**
    * @param player
    * This method search in fields which is owned by this player and resets that fields.
    */
    public void resetforPlayer(Player player){
        player.setRunOutOfMoney();
        for(Field field : fields){
            if(field.getOwner() == player){
                field.reset();
            }
        }
    }
    
}
