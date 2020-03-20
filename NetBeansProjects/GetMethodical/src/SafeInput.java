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
   
   public static int getInt(Scanner pipe, String prompt) {
        int retInt;
        String trash = "";
        System.out.print("\n" + prompt + ": ");
        do {
            if (!pipe.hasNextInt()) {
                trash = pipe.nextLine();
                System.out.print("\n" + prompt + ": ");
            }
        } while (!pipe.hasNextInt());
        retInt = pipe.nextInt();
        return retInt;
   }
   
    public static double getDouble(Scanner pipe, String prompt) {
        double retDouble;
        String trash = "";
        System.out.print("\n" + prompt + ": ");
        do {
            if (!pipe.hasNextDouble()) {
                trash = pipe.nextLine();
                System.out.print("\n" + prompt + ": ");
            }
        } while (!pipe.hasNextDouble());
        retDouble = pipe.nextDouble();
        return retDouble;
   }
    public static boolean isInRangeInt(int num, int low, int high) {
        return (num >= low && num <= high);
    }
   
    public static int getRangedInt(Scanner pipe, String prompt, int low, int high) {
        int retInt = -1;
        String trash = "";
        boolean run = true;
        while (run) {
            System.out.print("\n" + prompt + " [" + low + ", " + high + "]: ");
            if (pipe.hasNextInt()) {
                retInt = pipe.nextInt();
                if (isInRangeInt(retInt, low, high)) {
                    run = false;
                }
            } else {
                trash = pipe.nextLine();
            }
        }
        return retInt;
    }
    
    public static boolean isInRangeDouble(double num, double low, double high) {
       return (num >= low && num <= high);
    }
    
    public static double getRangedDouble(Scanner pipe, String prompt, double low, double high) {
        double retDouble = -1;
        String trash = "";
        boolean run = true;
        while (run) {
            System.out.print("\n" + prompt + " [" + low + ", " + high + "]: ");
            if (pipe.hasNextDouble()) {
                retDouble = pipe.nextDouble();
                if (isInRangeDouble(retDouble, low, high)) {
                    run = false;
                }
            } else {
                trash = pipe.nextLine();
            }
        }
        return retDouble;
   }
   
   public static boolean getYNConfirm(Scanner pipe, String prompt) {
        boolean retBool = false;
        String ans;
        System.out.print("\n" + prompt + " [Y/N]: ");
        do {
            ans = pipe.nextLine().toUpperCase();
            if (ans.equals("Y")) {
                retBool = true;
            } else if (ans.equals("N")) {
                retBool = true;
            } else {
                System.out.print("\n" + prompt + " [Y/N]: ");
            }
        } while (!ans.equals("Y") && !ans.equals("N"));
        return retBool;
   }
   
   public static String getRegExString(Scanner pipe, String prompt, String RegEx) {
        return "";
   }
}
