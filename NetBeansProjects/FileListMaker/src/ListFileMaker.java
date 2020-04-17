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
import java.util.ArrayList;
import java.io.File;
import java.io.PrintWriter;
import java.nio.file.Path;
import javax.swing.JFileChooser;

public class ListFileMaker {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Scanner inFile;
        PrintWriter outFile;
        JFileChooser chooser = new JFileChooser();
        String line;
        ArrayList<String> arrList = new ArrayList<>();
        String ans = "";
        boolean run = true;
        boolean needsToBeSaved = false;
        
        Path target = new File(System.getProperty("user.dir")).toPath();
        target = target.resolve("src");
        chooser.setCurrentDirectory(target.toFile());
        
        
        do {
            ans = printMenu(in, arrList);
            switch (ans) {
                case "A":
                    addToArrList(in, arrList);
                    needsToBeSaved = true;
                    break;
                case "C":
                    needsToBeSaved = true;
                    break;
                case "D":
                    needsToBeSaved = true;
                    deleteFromArrList(in, arrList);
                    break;
                case "O":
                    break;
                case "S":
                    break;
                case "V":
                    displayArrList(arrList);
                    break;
                case "Q":
                    if (SafeInput.getYNConfirm(in, "Are you sure")) {
                        run = false;
                    } else {
                        System.out.println("Returning to menu...");
                    }
                    break;
                    
//                if (needsToBeSaved) {
//                    // save program state
//                }
            }
        } while (run);
    }
    
    public static void addToArrList(Scanner in, ArrayList arrList) {
        String itemToAdd = SafeInput.getNonZeroLenString(in, "What would you like to add to the array list");
        arrList.add(itemToAdd);
    }
    
    public static void clearAllElements(Scanner in, ArrayList arrList) {
        
    }
    
    public static void deleteFromArrList(Scanner in, ArrayList arrList) {
        int itemToDelete = SafeInput.getRangedInt(in, "What item do you want to delete", 1, arrList.size());
        arrList.remove(itemToDelete - 1);
    }
    
    public static void openListFromFile() {
        
    }
    
    public static void saveCurrentFile() {
        
    }
    
    public static void displayArrList(ArrayList arrList) {
        for (int i = 0; i < arrList.size(); i++) {
            System.out.println(arrList.get(i));
        }
    }
    
    private static String printMenu(Scanner in, ArrayList arrList) {
        if (arrList.isEmpty()) {
            System.out.println("Your list is currently empty.");
        } else {
            System.out.println("Current list:");
            for (int i = 0; i < arrList.size(); i++) {
                System.out.printf("    %d. %s\n", i + 1 , arrList.get(i));
            }
        }
        return SafeInput.getRegExString(in, "Select a menu option:\n    A: Add\n    C: Clear\n    D: Delete\n    O: Open\n    S: Save\n    V: View\n    Q: Quit\n", "[AaCcDdOoVvQq]").toUpperCase();
    }
}