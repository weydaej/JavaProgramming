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
public class CtoF {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double cTemp = 0;
        double fTemp = 0;
        String trash = "";

        System.out.print("Enter a temperature in Celsius that you would like "
                + "to convert to Fahrenheit: ");
        do {
            if (!in.hasNextDouble()) {
                trash = in.nextLine();
                System.out.print(String.format("Invalid input (%s). Please enter a valid temperature: ", trash));
            }
        } while (!in.hasNextDouble());

        cTemp = in.nextDouble();
        fTemp = ((cTemp * 9)/5) + 32;
        System.out.println(String.format("%.1f degrees Celsius converts to %.1f degrees Fahrenheit.", cTemp, fTemp));
    }    
}
