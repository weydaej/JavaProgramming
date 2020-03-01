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
public class compareNumbers {
    /*
    class ComparingMachine
        main()
            // define vars
            num obj1
            num obj2
            // prompt and input
            output “Enter an object: ”
            input obj1
            output “Enter another object: ”
            input obj2
            // process and output 
            if obj1 == obj2 then 
                    output “The two objects are equal.”
            else if obj1 < obj2 then
                    output obj1 + “ is the smaller of the two objects.”
            else if obj2 < obj1 then 
                    output obj2 + “ is the smaller of the two objects.”
            end if
        return 
    end class
    */
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        double num1 = 0;
        double num2 = 0;
        Scanner input = new Scanner(System.in);
        try {
            System.out.print("Please enter a number: ");
            num1 = input.nextInt();
            System.out.print("Please enter a number: ");
            num2 = input.nextInt();
        } catch (Exception e) {
            System.out.println(e + ". Invalid input. Please try again. Ending program now...");
            System.exit(0);
        }
        if (num1 == num2) {
            System.out.println("The two numbers are equal.");
        } else if (num1 < num2){
            System.out.println(num1 + " is the smaller of the two objects.");
        } else {
            System.out.println(num2 + " is the smaller of the two objects.");
        }
    }
}
