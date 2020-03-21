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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
*   Examples of how to use this library:
*       SafeInput.getNonZeroLenString(in, "Enter your non-zero length string");
*       SafeInput.getInt(in, "Enter an int");
*       SafeInput.getDouble(in, "Enter a double");      
*       SafeInput.getRangedInt(in, "Enter ranged int", 15, 25);
*       SafeInput.getRangedDouble(in, "Enter ranged double", 24.1, 78.3);
*       SafeInput.getYNConfirm(in, "Enter Y or N");
*       SafeInput.getRegExString(in, "Enter regex string", "(M|m)\\d{8}");
*/

public class SafeInput {
    /**
    * 
    * @param pipe a Scanner opened to read from System.in
    * @param prompt prompt for the user
    * @return a String response that is not zero length
    */ 
    public static String getNonZeroLenString(Scanner pipe, String prompt) {
        String retString = "";  // Set this to zero length. Loop runs until it isn’t
        do {
            System.out.print("\n" + prompt + ": "); // show prompt add space
            retString = pipe.nextLine();
        } while(retString.length() == 0);
        return retString;
    }
    
    /**
    * 
    * @param pipe a Scanner opened to read from System.in
    * @param prompt prompt for the user
    * @return an int
    */ 
    public static int getInt(Scanner pipe, String prompt) {
        int retInt = -1;
        boolean run = true;
        do {
            System.out.print("\n" + prompt + ": ");
            if (pipe.hasNextInt()) {
                retInt = pipe.nextInt();
                pipe.nextLine();
                run = false;
            } else {
                pipe.nextLine();
            }
        } while (run);
        return retInt;
    }
    
    /**
    * 
    * @param pipe a Scanner opened to read from System.in
    * @param prompt prompt for the user
    * @return a double
    */ 
    public static double getDouble(Scanner pipe, String prompt) {
        double retDouble = -1;
        boolean run = true;
        do {
            System.out.print("\n" + prompt + ": ");
            if (pipe.hasNextDouble()) {
                retDouble = pipe.nextDouble();
                pipe.nextLine();
                run = false;
            } else {
                pipe.nextLine();
            }
        } while (run);
        return retDouble;
//        double retDouble = -1;
//        boolean hasDouble = false;
//        do {
//            System.out.print("\n" + prompt + ": ");
//            hasDouble = pipe.hasNextDouble();
//            if (!hasDouble) {
//                pipe.nextLine();
//            }
//        } while (!hasDouble);
//        retDouble = pipe.nextDouble();
//        return retDouble;
    }
    
    /**
    * 
    * @param num an int to compare
    * @param low an int representing the lower bound
    * @param high an int representing the upper bound
    * @return true if number is between low and high
    */ 
    private static boolean isInRangeInt(int num, int low, int high) {
        return (num >= low && num <= high);
    }
    
    /**
    * 
    * @param pipe a Scanner opened to read from System.in
    * @param prompt prompt for the user
    * @param low an int representing the lower bound
    * @param high an int representing the upper bound
    * @return an int within the provided bounds
    */ 
    public static int getRangedInt(Scanner pipe, String prompt, int low, int high) {
        int retInt = -1;
        boolean run = true;
        String trash = "";
        do {
            System.out.print("\n" + prompt + " [" + low + ", " + high + "]: ");
            if (pipe.hasNextInt()) {
                retInt = pipe.nextInt();
                pipe.nextLine();
                if (isInRangeInt(retInt, low, high)) {
                    run = false;
                }
            } else {
                pipe.nextLine();
            }
        } while (run);
        return retInt;
    }
    
    /**
    * 
    * @param num a double to compare
    * @param low a double representing the lower bound
    * @param high a double representing the upper bound
    * @return true if number is between low and high
    */ 
    private static boolean isInRangeDouble(double num, double low, double high) {
       return (num >= low && num <= high);
    }
    
    /**
    * 
    * @param pipe a Scanner opened to read from System.in
    * @param prompt prompt for the user
    * @param low a double representing the lower bound
    * @param high a double representing the upper bound
    * @return a double within the provided bounds
    */ 
    public static double getRangedDouble(Scanner pipe, String prompt, double low, double high) {
        double retDouble = -1;
        boolean run = true;
        
        do {
            System.out.print("\n" + prompt + " [" + low + ", " + high + "]: ");
            if (pipe.hasNextDouble()) {
                retDouble = pipe.nextDouble();
                pipe.nextLine();
                if (isInRangeDouble(retDouble, low, high)) {
                    run = false;
                }
            } else {
                pipe.nextLine();
            }
        } while (run);
        return retDouble;
    }
    
    /**
    * 
    * @param pipe a Scanner opened to read from System.in
    * @param prompt prompt for the user
    * @return true if "Y" and false for "N"
    */ 
    public static boolean getYNConfirm(Scanner pipe, String prompt) {
        boolean retBool = false;
        String ans;
        do {
            System.out.print("\n" + prompt + "? [Y/N] ");
            ans = pipe.nextLine().toUpperCase();
            pipe.nextLine();
        } while (!ans.equals("Y") && !ans.equals("N"));
        if (ans.equals("Y")) {
            retBool = true;
        }
        
        return retBool;
    }
    
    /**
    * 
    * @param pipe a Scanner opened to read from System.in
    * @param prompt prompt for the user
    * @param RegEx string representing the desired regex
    * @return a valid RegEx string
    */ 
    
    public static String getRegExString(Scanner pipe, String prompt, String RegEx) {
        String stringToSearch = "";
        do {
            System.out.print("\n" + prompt + ": "); // show prompt add space
            stringToSearch = pipe.nextLine();
            Pattern regexPattern = Pattern.compile(RegEx);
            Matcher regexMatcher = regexPattern.matcher(stringToSearch);
            if (regexMatcher.find()) {
                return regexMatcher.group();
            } 
        } while(true);
    }
}
