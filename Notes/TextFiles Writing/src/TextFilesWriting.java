
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;

/**
 *
 * @author Tom Wulf Tom.Wulf@uc.edu
 */
public class TextFilesWriting 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        PrintWriter outFile;
        Path target = new File(System.getProperty("user.dir")).toPath();
        target = target.resolve("src\\testWrite.txt");
  
        
        try  // Code that might trigger the exception goes here
        {
            outFile = new PrintWriter(target.toString());
            for(int l=0; l < 10;l++)
            {
                outFile.println("Java Textfiles Rule!!!");
            }
            
            outFile.close();
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File Not Found Error");
            e.printStackTrace();           
        }
        catch (IOException e) // code to handle this exception
        {
            System.out.println("IOException Error");
            e.printStackTrace();
        }
    }
    
}
