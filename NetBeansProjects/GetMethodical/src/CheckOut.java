/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author weydaej
 */
import java.util.Scanner;
public class CheckOut {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*
        At the 10$ store nothing is more than $10.00.  
        Prompt the user for the price of their item (.50 cents to $9.99 dollars) 
        using the getRangedDouble method and continue to input items as long as 
        they indicate that they have more using your getYNConfirm method.  
        Display the total cost of the item(s) to 2 decimal places with printf.  
        */
        Scanner in = new Scanner(System.in);
        double totalPrice = 0;
        boolean ans;
        do {
            totalPrice += SafeInput.getRangedDouble(in, "Enter the price of your item", 0.50, 9.99);
            ans = SafeInput.getYNConfirm(in, "Do you have more items");
        } while (ans);
        System.out.printf("The total cost: %f", totalPrice);
    }
    
}
