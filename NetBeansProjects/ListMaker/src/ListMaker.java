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
public class ListMaker {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        String option1 = "Add";
        String option2 = "Delete";
        String option3 = "Print";
        String option4 = "Quit";

        String opt1 = option1.substring(0, 1);
        String opt2 = option2.substring(0, 1);
        String opt3 = option3.substring(0, 1);
        String opt4 = option4.substring(0, 1);
        System.out.printf("Select a menu option:\n    %s: %s\n    %s: %s\n    %s: %s\n    %s: %s\n", opt1, option1, opt2, option2, opt3, option3, opt4, option4);
        String ans = "";
        boolean run = true;
        do {
            if (in.hasNext()) {
                ans = in.nextLine().toUpperCase();
                if (ans.equals(opt1) || ans.equals(opt2) || ans.equals(opt3) || ans.equals(opt4)) {
                    run = false;
                    if (ans.equals(opt4)) {
                        if (!SafeInput.getYNConfirm(in, "Are you sure")) {
                            run = true;
                        } 
                    }
                }
            }
        } while (run);
        
        
    }
    
//    public static String menu(Scanner pipe, String option1, String option2, String option3, String option4) {
//        String opt1 = option1.substring(0, 1);
//        String opt2 = option2.substring(0, 1);
//        String opt3 = option3.substring(0, 1);
//        String opt4 = option4.substring(0, 1);
//        System.out.printf("Select a menu option:\n    %s: %s\n    %s: %s\n    %s: %s\n    %s: %s\n", opt1, option1, opt2, option2, opt3, option3, opt4, option4);
//        String ans = "";
//        boolean run = true;
//        do {
//            if (pipe.hasNext()) {
//                ans = pipe.nextLine().toUpperCase();
//                if (ans.equals(opt1) || ans.equals(opt2) || ans.equals(opt3) || ans.equals(opt4)) {
//                    run = false;
//                }
//            }
//        } while (run);
//        return ans;
//    }
}
