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
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import javax.swing.JFileChooser;

/* TODO
* saveCurrentFile needs to be finished
* open file ... not sure if it makes sense to do it this way
* need to do something with the dirty flag.. thinking call saveCurrentFile 
    for anything with the flag marked true
*/

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
        boolean needsToBeSaved = false; // initializing dirty flag
        
        Path target = new File(System.getProperty("user.dir")).toPath();
        target = target.resolve("src");
        chooser.setCurrentDirectory(target.toFile());
        
        do {
            ans = printMenu(in, arrList);
            switch (ans) {
                case "A":
                    addToArrList(in, arrList);
                    needsToBeSaved = true;
                    try  {
                        FileWriter writer = new FileWriter("output.txt");
                        for (String str: arrList) {
                            writer.write(str + System.lineSeparator());
                        }
                        writer.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case "C":
                    clearAllElements(arrList);
                    needsToBeSaved = true;
                    break;
                case "D":
                    needsToBeSaved = true;
                    deleteFromArrList(in, arrList);
                    break;
                case "O":
                    try {
                        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                            target = chooser.getSelectedFile().toPath();
                            inFile = new Scanner(target);
                            System.out.println("File: " + target.getFileName());
                        } else { // user did not select a file
                            System.out.println("You must select a file! Terminating program...");
                            System.exit(0);
                        }
                    } catch (FileNotFoundException e) {
                        System.out.println("File Not Found Error!");
                        e.printStackTrace();
                    } catch (IOException e) {
                        System.out.println("IOException Error!");
                        e.printStackTrace();
                    }
                    break;
                case "S":
                    // Figure out if this should just trigger the dirty flag or actually call the save function
                    saveCurrentFile();
                    break;
                case "V":
                    displayArrList(arrList);
                    break;
                case "Q":
                    if (needsToBeSaved) {
                        saveCurrentFile();
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
    
    public static void addToArrList(Scanner in, ArrayList arrList) {
        // add item to end of file 
        String itemToAdd = SafeInput.getNonZeroLenString(in, "What would you like to add to the array list");
        arrList.add(itemToAdd);
    }
    
    public static void clearAllElements(ArrayList arrList) {
        // deletes all lines in the list
        arrList.removeAll(arrList);
    }
    
    public static void deleteFromArrList(Scanner in, ArrayList arrList) {
        // delete selected line
        int itemToDelete = SafeInput.getRangedInt(in, "What item do you want to delete", 1, arrList.size());
        arrList.remove(itemToDelete - 1);
    }
    
    public static void saveCurrentFile() {
        // save and close?
        // or save and keep open until quit?
    }
    
    public static void displayArrList(ArrayList arrList) {
        // print list line by line
        for (int i = 0; i < arrList.size(); i++) {
            System.out.println(arrList.get(i));
        }
    }
    
    private static String printMenu(Scanner in, ArrayList arrList) {
        // should print out list, adding "#: " 
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
