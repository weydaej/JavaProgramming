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
public class fuelCosts {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double numGallonsInTank = 0;
        double fuelEfficiencyMPG = 0;
        double gasPricePerGallon = 0;
        double numMiles = 100;

        String trash = "";
        System.out.print("Enter the number of gallons in the tank: ");
        if (in.hasNextDouble()) {
            numGallonsInTank = in.nextDouble();
            in.nextLine();
        } else {
            trash = in.nextLine();
            System.out.println(String.format("Invalid input. (%s) "
                    + "Run the program again and enter a valid value."
                    + "", trash));
            System.exit(0);
        }
        System.out.print("Enter the fuel efficiency in mpg: ");
        if (in.hasNextDouble()) {
            fuelEfficiencyMPG = in.nextDouble();
            in.nextLine();
        } else {
            trash = in.nextLine();
            System.out.println(String.format("Invalid input. (%s) "
                    + "Run the program again and enter a valid value."
                    + "", trash));
            System.exit(0);
        }
        System.out.print("Enter the price of gas per gallon: ");
        if (in.hasNextDouble()) {
            gasPricePerGallon = in.nextDouble();
            in.nextLine();
        } else {
            trash = in.nextLine();
            System.out.println(String.format("Invalid input. (%s) "
                    + "Run the program again and enter a valid value."
                    + "", trash));
            System.exit(0);
        }
        double costPer100 = (numMiles/fuelEfficiencyMPG) * gasPricePerGallon;
        double howFar = numGallonsInTank * fuelEfficiencyMPG;
        System.out.println(String.format("With the given number of gallons in the tank, fuel efficiency in MPG and gas price, \nthe cost per 100 miles is %.2f, and the car can go %.2f miles with the gas in the tank.", costPer100, howFar));
    } 
}
