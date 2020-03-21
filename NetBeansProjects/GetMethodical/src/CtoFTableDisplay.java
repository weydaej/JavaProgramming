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
public class CtoFTableDisplay {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        SafeInput.getInt(in, "Enter int");
        SafeInput.getDouble(in, "Enter double");
        SafeInput.getRangedInt(in, "Enter double", 2, 7);
        SafeInput.getRangedDouble(in, "Enter int", 2.3, 4.9);
    }
    
}
