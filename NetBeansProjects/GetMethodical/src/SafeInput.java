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
       return 0;
   }
   
   public static double getDouble(Scanner pipe, String prompt) {
       return 0;
   }
   
   public static int getRangedInt(Scanner pipe, String prompt, int low, int high) {
       return 0;
   }
   
   public static double getRangedDouble(Scanner pipe, String prompt, double low, double high) {
       return 0;
   }
   
   public static boolean getYNConfirm(Scanner pipe, String prompt) {
       return false;
   }
   
   public static String getRegExString(Scanner pipe, String prompt, String RegEx) {
       return "";
   }
}
