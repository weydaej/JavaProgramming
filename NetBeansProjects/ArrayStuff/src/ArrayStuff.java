/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author weydaej
 */
import java.util.Random;
import java.util.Scanner;
public class ArrayStuff {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Random rnd = new Random();
        /* Part 1: DataPoints Array */
        int[] dataPoints = new int[100];
        int sum = 0;
        double mean = 0;
        for (int i = 0; i < dataPoints.length; i++) {
            dataPoints[i] = rnd.nextInt(100) + 1;
        }
        for (int j = 0; j < dataPoints.length; j++) {
            if (j < dataPoints.length - 1) {
                System.out.print(dataPoints[j] + " | ");
            } else {
                System.out.print(dataPoints[j]);
            }
        }
        for (int k = 0; k < dataPoints.length; k++) {
            sum += dataPoints[k];
        }
        mean = sum/dataPoints.length;
        System.out.printf("\nThe sum of the datapoints is %d and the average is %.2f.\n", sum, mean);
    
        /* Part 2: Linear Search */
        Scanner in = new Scanner(System.in);
        int count = 0;
        /* (a) */
        int ans = SafeInput.getRangedInt(in, "Enter an integer value between 1 and 100", 1, 100);
        /* (b) */
        for (int l = 0; l < dataPoints.length; l++) {
            if (ans == dataPoints[l]) {
                count++;
            }
        }
        System.out.printf("\n%d appeared in the DataPoints array %d times.\n", ans, count);
        
        /* (c) */
        int matches = -1;
        int val = SafeInput.getRangedInt(in, "Enter an integer value between 1 and 100", 1, 100);
        for (int m = 0; m < dataPoints.length; m++) {
            if (val == dataPoints[m]) {
                matches = m;
                break;
            }
        }
        if (matches != -1) {
            System.out.printf("\nThe value %d was found at array index %d.\n", val, matches);
        } else {
            System.out.printf("\nThe value %d was not found.\n", val);
        }
    }
}
