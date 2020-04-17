/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.StringTokenizer;
import javax.swing.JFileChooser;

/**
 *
 * @author weydaej
 */
public class FileAway {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner inFile;
        JFileChooser chooser = new JFileChooser();
        String line;
        int numLines = 0;
        int numWords = 0;
        int numChars = 0;

        Path target = new File(System.getProperty("user.dir")).toPath();
        target = target.resolve("src");
        chooser.setCurrentDirectory(target.toFile());
        
        
        try {
            if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                target = chooser.getSelectedFile().toPath();
                inFile = new Scanner(target);
                System.out.println("File: " + target.getFileName());
                while (inFile.hasNextLine()) {
                    line = inFile.nextLine();
                    numLines++;
                    numChars += line.length();
                    numWords += new StringTokenizer(line, " ,").countTokens();
                }
                inFile.close();
                System.out.printf("Lines: %d\nWords: %d\nCharacters: %d\n", numLines, numWords, numChars);
            } else { // user did not select a file
                System.out.println("You must select a file! Terminating program...");
                System.exit(0);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found!");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("IOException Error");
            e.printStackTrace();
        }
    }
}
