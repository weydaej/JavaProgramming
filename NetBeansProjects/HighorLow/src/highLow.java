/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author weydae
 */
import java.util.Scanner;
import java.util.Random;
public class highLow {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Random rnd = new Random();
        int num = rnd.nextInt(10) + 1;
        int guess = 0;
        String trash = "";
        System.out.print("Guess the number: ");
        if (in.hasNextInt()) {
            guess = in.nextInt();
            in.nextLine();
        } else {
            trash = in.nextLine();
            System.out.println(String.format("Invalid input. (%s) "
                    + "Run the program again and enter a valid value."
                    + "", trash));
            System.exit(0);
        }
        if (guess == num) {
            System.out.println("Congrats! Your guess is on the money!");
        } else if (guess > num) {
            System.out.println(String.format("Your guess was too high. The number was %d.", num));
        } else {
            System.out.println(String.format("Your guess was too low. The number was %d.", num));
        }
    }
    
}
