/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capitaly;

import java.io.FileNotFoundException;
import java.util.InputMismatchException;

/**
 *
 * @author rasul
 */
public class Main {

    /**
     * The starting point of the Java application.
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Board game = new Board();
        try {
            game.read("input.txt");
            game.run();
        } catch (FileNotFoundException ex) {
            System.out.println("File not found!");
            System.exit(-1);
        } catch (InvalidInputException ex) {
            System.out.println("Invalid input!");
            System.exit(-1);
        } catch (InputMismatchException ex) {
            System.out.println("Invalid input!");
            System.exit(-1);
        }
    /**
     * <p>It creates Board class named game and firstly it reads from file. Then
     * it performs second method which is called run.</p>
     * @throws FileNotFoundException if there isn't file like filename
     * @throws InvalidInputException if there is an attempt of incorrect data
     * @throws InputMismatchException if there is an attempt of getting char instead of integer
     */
    }
}
