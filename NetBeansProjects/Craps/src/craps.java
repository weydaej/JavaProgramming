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
    public static void main(String[] args) {
        Random rnd = new Random();
        Scanner in = new Scanner(System.in);
        boolean run = true;
        int point;
        int numWins = 0;
        int numLosses = 0;
        String response = "";
        System.out.println("Welcome to Craps!");
        while (run) {
            System.out.println("Rolling the dice...");
            int die1 = rnd.nextInt(6) + 1;
            int die2 = rnd.nextInt(6) + 1;
            int sum = die1 + die2;
            int incorrectInput = 0;
            System.out.println("Die 1: " + die1);
            System.out.println("Die 2: " + die2);
            System.out.println("  Sum: " + sum);
            if (sum == 2 || sum == 3 || sum == 12) {
                System.out.println("Crapped out! ");
                numLosses += 1;
                incorrectInput = 0;
                do {
                    if (incorrectInput > 0) {
                        System.out.print("Invalid input. ");
                    }
                    System.out.print("Would you like to play again? (y/n) ");
                    incorrectInput += 1;
                    response = in.nextLine();
                } while (!response.equals("n") && !response.equals("y"));
            } else if (sum == 7 || sum == 11) {
                System.out.println("You're a \"natural\" -- you win!");
                numWins += 1;
                incorrectInput = 0;
                do {
                    if (incorrectInput > 0) {
                        System.out.print("Invalid input. ");
                    }
                    System.out.print("Would you like to play again? (y/n) ");
                    incorrectInput += 1;
                    response = in.nextLine();
                } while (!response.equals("n") && !response.equals("y"));
            } else {
                point = sum;
                System.out.println("Point is now " + point);
                do {
                    die1 = rnd.nextInt(6) + 1;
                    die2 = rnd.nextInt(6) + 1;
                    sum = die1 + die2;
                    System.out.println("Roll: " + sum);
                    if (sum == 7) {
                        System.out.println("Crapped out!");
                        numLosses += 1;
                        incorrectInput = 0;
                        do {
                            if (incorrectInput > 0) {
                                System.out.print("Invalid input. ");
                            }
                            System.out.print("Would you like to play again? (y/n) ");
                            incorrectInput += 1;
                            response = in.nextLine();
                        } while (!response.equals("n") && !response.equals("y"));
                    } else if (sum == point) {
                        System.out.println("You're a \"natural\" -- you win!");
                        numWins += 1;
                        incorrectInput = 0;
                        do {
                            if (incorrectInput > 0) {
                                System.out.print("Invalid input. ");
                            }
                            System.out.print("Would you like to play again? (y/n) ");
                            incorrectInput += 1;
                            response = in.nextLine();
                        } while (!response.equals("n") && !response.equals("y"));
                    } else {
                        System.out.println("Trying for point. Rolling again...");
                        die1 = rnd.nextInt(6) + 1;
                        die2 = rnd.nextInt(6) + 1;
                        sum = die1 + die2;
                    }
                } while (sum != 7 && sum != point);   
            }
            if (response.equals("n")) {
                System.out.println(String.format("Thanks for playing! You played %d games: %dW & %dL!", numWins + numLosses, numWins, numLosses));
                System.exit(0);
            }
        }
    }
}
