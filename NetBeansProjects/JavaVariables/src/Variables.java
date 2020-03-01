/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author weydaej
 */
public class Variables {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int intOperandA = 1;
        int intOperandB = 5;
        int intSum = 13;
        int intProduct = 24;
        int intDifference = 45;
        int intQuotient = 56;
        int intModulo = 68;
        double doubleOperandA = 1.5;
        double doubleOperandB = 3.14;
        double doubleSum = 34;
        double doubleProduct = 48;
        double doubleDifference = 23;
        double doubleQuotient = 34;
        double doubleModulo = 4;
        intSum = intOperandA + intOperandB;
        System.out.println("The sum using ints of " + intOperandA + " and " + intOperandB + " is " + intSum + ".");
        intProduct = intOperandA * intOperandB;
        System.out.println("The product using ints of " + intOperandA + " and " + intOperandB + " is " + intProduct + ".");
        intDifference = intOperandA - intOperandB;
        System.out.println("The difference using ints of " + intOperandA + " and " + intOperandB + " is " + intDifference + ".");
        intQuotient = intOperandA / intOperandB;
        System.out.println("The quotient using ints of " + intOperandA + " and " + intOperandB + " is " + intQuotient + ".");
        intModulo = intOperandA % intOperandB;
        System.out.println("The remainder using ints of " + intOperandA + " and " + intOperandB + " is " + intModulo + ".");
        doubleSum = doubleOperandA + doubleOperandB;
        System.out.println("The sum using double of " + doubleOperandA + " and " + doubleOperandB + " is " + doubleSum + ".");
        doubleProduct = doubleOperandA * doubleOperandB;
        System.out.println("The product using double of " + doubleOperandA + " and " + doubleOperandB + " is " + doubleProduct + ".");
        doubleDifference = doubleOperandA - doubleOperandB;
        System.out.println("The difference using double of " + doubleOperandA + " and " + doubleOperandB + " is " + doubleDifference + ".");
        doubleQuotient = doubleOperandA / doubleOperandB;
        System.out.println("The quotient using double of " + doubleOperandA + " and " + doubleOperandB + " is " + doubleQuotient + ".");
        doubleModulo = doubleOperandA % doubleOperandB;
        System.out.println("The remainder using double of " + doubleOperandA + " and " + doubleOperandB + " is " + doubleModulo + ".");
    
        int numFamilyKids = 3;
        boolean isRaining = false; 
        double gasPrice = 2.38;
        int myFavNum = 7;
        int myShoeSize = 7;
        String myBirthMonth = "November";
        String myFullName = "Emily Weyda";
        System.out.println(numFamilyKids);
        System.out.println(isRaining);
        System.out.println(gasPrice);
        System.out.println(myFavNum);
        System.out.println(myShoeSize);
        System.out.println(myBirthMonth);
        System.out.println(myFullName);
    }
    
}
