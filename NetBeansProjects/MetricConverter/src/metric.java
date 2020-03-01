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
public class metric {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double measurementMeters = 0;
        double miles = 0;
        double feet = 0;
        double inches = 0;
        String trash = "";
        
        System.out.print("Enter a measurement in meters: ");
        if (in.hasNextDouble()) {
            measurementMeters = in.nextDouble();
            in.nextLine();
        } else {
            trash = in.nextLine();
            System.out.println(String.format("Invalid input. (%s) "
                    + "Run the program again and enter a valid value."
                    + "", trash));
            System.exit(0);
        }
        miles = measurementMeters * 0.00062137119224;
        feet = measurementMeters * 3.2808;
        inches = measurementMeters * 39.37007874;
        System.out.println(String.format("%.3f meters converts to %.3f miles, %.3f feet, %.3f inches",measurementMeters, miles, feet, inches));
    }
    
}
