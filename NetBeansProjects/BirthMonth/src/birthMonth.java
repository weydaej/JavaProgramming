/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author weydaej
 */
public class birthMonth {
    /*
    class BirthMonth
	main()
		num birthMonth
		output “Enter your birth month [1-12]: ”
		input birthMonth 
		if birthMonth > 0 && birthMonth < 13 then
			output “Your birth month is: ” + birthMonth
		else
			output “You entered an incorrect month value: ” + birthMonth
		end if
	return 
    end class
    */
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int birthMonth = 110;
        System.out.println("Enter your birthmonth: " + birthMonth);
        if (birthMonth > 0 && birthMonth < 13) {
            System.out.println("Your birth month is: " + birthMonth);
        } else {
            System.out.println("You entered an incorrect month value: " + birthMonth);
        }
    }
    
}
