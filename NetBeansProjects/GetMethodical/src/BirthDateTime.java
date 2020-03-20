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
public class BirthDateTime {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        SafeInput.getNonZeroLenString(in, "Enter your non-zero length string");
        SafeInput.getInt(in, "Enter an int");
        SafeInput.getDouble(in, "Enter a double");
        SafeInput.getRangedInt(in, "Enter ranged int", 15, 25);
        SafeInput.getRangedDouble(in, "Enter ranged double", 24.1, 78.3);
        SafeInput.getYNConfirm(in, "Enter Y or N");
//        SafeInput.getRegExString(in, "Enter regex string", "[abc]");
    }
    
}
