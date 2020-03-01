/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author weydae
 */
import java.util.Random;
import java.util.Scanner;

public class craps {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*
        Roll the dice.
            - if sum of dice is 2, 3 or 12 it is called "craps" or 
                "crapping out", and the game is over with a loss
            - If the sum is 7 or 11 is it called a "natural" and the game is
                over with a win. 
            - For all other values, the sum becomes "the point" and the user 
                makes subsequent rolls until they either throw a 7 in which 
                case they lose or they make the point sum in which case they
                win 
        After a win or loss the next player rolls the die for a new game.
                in our simulation, the program will simply ask the user if they
                want to continue to play.
        For each roll show the value for each die and the sum.
            - for winning or crapping out, indicate that it has happened, and
                then prompt to play again 
        For other values indicate that the sum is now the point.
        For each subsequent roll indicate the status:
            1. Trying for point. 
            2. Made point and won. 
            3. Got a seven and lost. 
        */
        Random rnd = new Random();
        Scanner in = new Scanner(System.in);
        boolean run = true;
        String response = "";
        while (run) {
            System.out.println("Welcome to Craps!");
            System.out.println("Rolling the dice...");
            int die1 = rnd.nextInt(6) + 1;
            int die2 = rnd.nextInt(6) + 1;
            int sum = die1 + die2;
            System.out.println("Die 1: " + die1);
            System.out.println("Die 2: " + die2);
            System.out.println("  Sum: " + sum);
            if (sum == 2 || sum == 3 || sum == 12) {
                System.out.print("Crapped out! - Would you like to play again? (y/n) ");
                response = in.nextLine();
            } else if (sum == 7 || sum == 11) {
                System.out.print("You're a \"natural\" -- you win! Would you like to play again? (y/n) ");
                response = in.nextLine();
            } else {
                
            }
        }
    }
    
}
