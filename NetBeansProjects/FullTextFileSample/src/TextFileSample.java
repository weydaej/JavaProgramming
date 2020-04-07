
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Tom Wulf more or less, combines sample code from Big Java 4th edition
 * This sample program shows how to open a file and process it line by line
 */
public class TextFileSample 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        PrintWriter out; 
        Scanner in; // in is the file we are reading  
        Scanner console = new Scanner(System.in);
        File selectedFile;
        JFileChooser chooser = new JFileChooser();
        String line;
        String outFileName = "";
        String defaultFileName = "default.txt";
        int lineCount = 0;
        
        try
        {
            // Display FileChooser Wizard for user to select a file to open
            // check to make sure user actually picked a file to open
            // if they did, go ahead and read it and dump it to the screen
            
            // Set the JFileChooser to use the Netbeans projcet folder
            File workingDirectory = new File(System.getProperty("user.dir"));
            chooser.setCurrentDirectory(workingDirectory);
            
            if(chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
            {
                selectedFile = chooser.getSelectedFile();  // this is a File object not a String filename 
                in = new Scanner(selectedFile);  // Open the file for reading
                
                // OK we got a file to read before we do let's prompt the user for the
                // name of the file to write.
                outFileName = JOptionPane.showInputDialog(null, "Enter filename to write: ");
                if(outFileName.trim().equals(""))
                {
                  outFileName = defaultFileName;            
                }
                // Now open the file for output:
                out = new PrintWriter(outFileName);
                
                // Now process the file.  Here we just dump it line by line to the console
                while(in.hasNextLine())
                {
                    line = in.nextLine();
                    lineCount++;
                    // Show the file on the console
                    System.out.printf("\nLine %3d: %-30s", lineCount, line);
                    // But write the numbered line to the output file
                    out.printf("Line %3d: %-30s", lineCount, line);
                    out.println("\n");
                    
                }  
                System.out.println("");
                // Don't forget to close the file
                in.close();
                out.close();
            }
            else  // they didn't select a file so exit...
            {
                JOptionPane.showMessageDialog(null, "Cancelled by User.  Exiting...");
                System.exit(0);
            }
        }
        catch (FileNotFoundException ex)
        {
            System.out.println("File not found error!");
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }
        
    }
}
