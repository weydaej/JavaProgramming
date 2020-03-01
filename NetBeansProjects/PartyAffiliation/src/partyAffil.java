/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author weydaej
 */
public class partyAffil {
    /*
    class PartyAffiliation
	main()
		String partyAffiliation
		output “Please enter your party affiliation [Democrat, Republican, Independent]: ”
		input partyAffiliation
		if partyAffiliation == “Democrat” then 
			output “You get a Democratic Donkey.”
		else if partyAffiliation == “Republican” then 
			output “You get a Republican Elephant.”
		else if partyAffiliation == “Independent” then 
			output “You get an Independent Man.”
		else
			output “You did not enter a valid option.”
		end if
        return  
    end class
    */
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String partyAffiliation = "r";
        partyAffiliation = partyAffiliation.toUpperCase();
        System.out.println("Please enter your party affiliation [Democrat (D), Republican (R), Independent (I)]: " + partyAffiliation);
        if (partyAffiliation.equals("D")) {
            System.out.println("You get a Democratic Donkey.");
        } else if (partyAffiliation.equals("R")) {
            System.out.println("You get a Republican Elephant.");
        } else if (partyAffiliation.equals("I")) {
            System.out.println("You get an Independent Man.");
        } else {
            System.out.println("You did not enter a valid option.");
        }
    }
}
