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
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import javax.swing.JFileChooser;

public class ListFileMaker {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter outFile;
        String line;
        int numLines = 0;
        String ans = "";
        boolean run = true;
        boolean needsToBeSaved = false; // initializing dirty flag
        File fileName;
        
        do {
            ans = printMenu(in);
            switch (ans) {
                case "A":
                    addToList(in);
                    needsToBeSaved = true;
                    
                    break;
                case "C":
                    // update clearAllElements using file instead of arraylist
                    clearAllElements(fileName);
                    needsToBeSaved = true;
                    break;
                case "D":
                    // update deleteFromList using file instead of arraylist
                    deleteFromList(in);
                    needsToBeSaved = true;
                    break;
                case "O":
                    // save existing list if needed
                    fileName = openFile();
                    break;
                case "S":
                    // Figure out if this should just trigger the dirty flag or actually call the save function
                    // if file exists, save it
                    // else allow user to save as new list
                    saveCurrentFile();
                    break;
                case "V":
//                    displayList(numLines);
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
    
    public static void addToList(Scanner in) {
        String itemToAdd = SafeInput.getNonZeroLenString(in, "What would you like to add to the array list");
        // add itemToAdd to end of file
    }
    
    public static void clearAllElements(File file) {
        // deletes all lines in the list
        try {
            PrintWriter writer = new PrintWriter(file);
            writer.print("");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void deleteFromList(Scanner in) {
//        int itemToDelete = SafeInput.getRangedInt(in, "What item do you want to delete", 1, numLines);
//        remove item from list
    }
    
    public static void saveCurrentFile() {
        // close file on save
    }
    
    public static void displayList(int numLines) {
        // print list line by line
        for (int i = 0; i < numLines; i++) {
            // print #: + line
        }
    }
    
    private static File openFile() { // will return fileName
        Scanner inFile;
        File fileName;
        JFileChooser chooser = new JFileChooser();
        Path target = new File(System.getProperty("user.dir")).toPath();
        target = target.resolve("src");
        chooser.setCurrentDirectory(target.toFile());
        try {
            if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                target = chooser.getSelectedFile().toPath();
                inFile = new Scanner(target);
                fileName = target.getFileName().toFile();
                System.out.println("File: " + target.getFileName());
                return fileName;
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
        return null;
    }
    
    private static String printMenu(Scanner in) {
        // if list is empty {
            // System.out.println("Your list is currently empty.");
        //} else {
            // System.out.println("Current list:");
                // should print out list, adding "#: " 
        // } 
        // figure out how to use for each with file .. may want to loop through with hasNextLine?
        try  {
            FileWriter writer = new FileWriter("output.txt");
            // prints line by line with #: in front
            //for (String str: arrList) {
            //    writer.write(str + System.lineSeparator());
            //}
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // returns the selected regex option 
        return SafeInput.getRegExString(in, "Select a menu option:\n    A: Add\n    C: Clear\n    D: Delete\n    O: Open\n    S: Save\n    V: View\n    Q: Quit\n", "[AaCcDdOoVvQq]").toUpperCase();
    }
}
