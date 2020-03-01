/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author weydaej
 */
public class theaterAge {
    /*
    class Wristband
	main()
		num age
		output “Enter your age: ”
		input age
		if age >= 21 then
			output “You get a paper wristband!”
		end if
	return
    end class
    */
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int age = 17;
        System.out.println("Enter your age: " + age);
        if (age >= 21) {
            System.out.println("You get a paper wristband!");
        }
    }
    
}
