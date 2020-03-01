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
public class rectInfo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double length = 0;
        double width = 0;
        double area = 0;
        double perimeter = 0;
        double diagonal = 0;
        String trash = "";
        System.out.print("Enter the length of the rectangle: ");
        if (in.hasNextDouble()) {
            length = in.nextDouble();
            in.nextLine();
        } else {
            trash = in.nextLine();
            System.out.println(String.format("Invalid input. (%s) "
                    + "Run the program again and enter a valid value."
                    + "", trash));
            System.exit(0);
        }
        System.out.print("Enter the width of the rectangle: ");
        if (in.hasNextDouble()) {
            width = in.nextDouble();
            in.nextLine();
        } else {
            trash = in.nextLine();
            System.out.println(String.format("Invalid input. (%s) "
                    + "Run the program again and enter a valid value."
                    + "", trash));
            System.exit(0);
        }
        area = length * width;
        perimeter = (2 * length) + (2 * width);
        diagonal = (length * length) + (width * width);
        System.out.println(String.format("With %.1f length and %.1f width, the area is %.1f, \nthe permimeter is %.1f and the diagonal is %.1f.", length, width, area, perimeter, diagonal));
    }
}
