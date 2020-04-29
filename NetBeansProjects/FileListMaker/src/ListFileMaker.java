/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author weydaej
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.ArrayList;
import javax.swing.JFileChooser;

public class ListFileMaker {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<String> arrList = new ArrayList<>();
        String ans = "";
        boolean run = true;
        boolean needsToBeSaved = false;
        
        do {
            ans = printMenu(in, arrList);
            switch (ans) {
                case "A":
                    addToList(in, arrList);
                    needsToBeSaved = true;
                    break;
                case "C":
                    clearList(arrList);
                    needsToBeSaved = true;
                    break;
                case "D":
                    deleteFromList(in, arrList);
                    needsToBeSaved = true;
                    break;
                case "O":
                    openListFile(arrList);
                    break;
                case "S":
                    // saves list to txt file
                    // or saves to the current file 
                    break;
                case "V":
                    displayList(arrList);
                    break;
                case "Q":
                    if (needsToBeSaved) {
                        saveCurrentFile(arrList);
                    }
                    if (SafeInput.getYNConfirm(in, "Are you sure")) {
                        run = false;
                    } else {
                        System.out.println("Returning to menu...");
                    }
                    break;
            }
        } while (run);
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
    
    public static void addToList(Scanner in, ArrayList arrList) {
        String itemToAdd = SafeInput.getNonZeroLenString(in, "What would you like to add to the array list");
        arrList.add(itemToAdd);
    }
    
    public static void clearList(ArrayList arrList) {
        arrList.clear();
    }
    
    public static void deleteFromList(Scanner in, ArrayList arrList) {
        int itemToDelete = SafeInput.getRangedInt(in, "What item do you want to delete", 1, arrList.size());
        arrList.remove(itemToDelete - 1);
    }
    
    public static void displayList(ArrayList arrList) {
        for (int i = 0; i < arrList.size(); i++) {
            System.out.println(arrList.get(i));
        }
    }
    
    private static void openListFile(ArrayList arrList) {
        // add code for if a list is already open
        Scanner inFile;
        JFileChooser chooser = new JFileChooser();
        String line;
        
        Path target = new File(System.getProperty("user.dir")).toPath();
        target = target.resolve("src");
        chooser.setCurrentDirectory(target.toFile());
        
        try {
            if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                target = chooser.getSelectedFile().toPath();
                inFile = new Scanner(target);
                System.out.println("Opening File: " + target.getFileName());
                while (inFile.hasNextLine()) {
                    line = inFile.nextLine();
                    arrList.add(line);
                }
                inFile.close();
            } else { // user did not select a file
                System.out.println("You must select a file! Returning to menu...");
            }
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found!");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("IOException Error");
            e.printStackTrace();
        }
    }
    
    public static void saveCurrentFile(ArrayList arrList) {
        
    }
}
