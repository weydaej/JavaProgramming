/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author weydaej
 */
public class CtoFTableDisplay {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        double prettyNumberF = 0;
        int lengthOfNumC = 0;
        int lengthOfNumF = 0;
        int positionC = 0;
        int positionF = 0;
        boolean isEvenLengthC = false;
        boolean isEvenLengthF = false;
        int valSpacesAfter = 0;
        
        System.out.println("______________________________________________");
        System.out.println("|       Celsius        |      Fahrenheit      |");
        System.out.println("|---------------------------------------------|");
        for (int celsius = -100; celsius < 101; celsius++) {
            prettyNumberF = Math.round(CtoF(celsius) * 100.0)/100.0;
            lengthOfNumC = String.valueOf(celsius).length();
            lengthOfNumF = String.valueOf(prettyNumberF).length();
            isEvenLengthC = (lengthOfNumC % 2 == 0);
            isEvenLengthF = (lengthOfNumF % 2 == 0);
            positionC = 21 - lengthOfNumC;
            positionF = 22 - lengthOfNumF;
            
            if (lengthOfNumC % 2 == 0) {
                System.out.print("|");
                for (int k = 0; k < positionC / 2; k++) {
                    System.out.print(" ");
                }
                System.out.print(" " + celsius + " ");
                if (isEvenLengthC) {
                    valSpacesAfter = positionC / 2;
                } else {
                    valSpacesAfter = positionC / 2 + 1;
                }
                for (int l = 0; l < valSpacesAfter; l++) {
                    System.out.print(" ");
                }
                System.out.print("|");
            } else {
                System.out.print("|");
                for (int k = 0; k < positionC / 2; k++) {
                    System.out.print(" ");
                }
                System.out.print(celsius);
                if (isEvenLengthC) {
                    valSpacesAfter = positionC / 2;
                } else {
                    valSpacesAfter = positionC / 2 + 1;
                }
                for (int l = 0; l < valSpacesAfter; l++) {
                    System.out.print(" ");
                }
                System.out.print("|");
            }
            
            for (int k = 0; k < positionF / 2; k++) {
                System.out.print(" ");
            }
            System.out.print(prettyNumberF);
            if (isEvenLengthF) {
                valSpacesAfter = positionF / 2;
            } else {
                valSpacesAfter = positionF / 2 + 1;
            }
            for (int l = 0; l < valSpacesAfter; l++) {
                System.out.print(" ");
            }
            System.out.println("|");
        }
        System.out.println("-----------------------------------------------");
    }
    
    public static double CtoF (double celsius) {
        return ((celsius * 9)/5) + 32;
    }
}
