import java.util.ArrayList;

/**
 *
 * @author Tom.Wulf@uc.edu
 */
public class ArrayLists 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
       // int - Integer
       // char - Character
       // double - Double
        
       ArrayList<String> folks = new ArrayList<>();
       
       folks.add("Tom");
       folks.add("Hazem");
       folks.add("Britney");
       
       // no indexing with the enhanced for loop
       for(String f : folks)
       {
           System.out.println(f);
       }
       
       for(int x = 0; x < folks.size(); x++)
       {
           System.out.println(folks.get(x));   // get(x)  array[x]
       }
       
       folks.set(0, "Bob");  // Overwrite Tom with Bob
       for(String f : folks)
       {
           System.out.println(f);
       }

       folks.add(1, "Tom");
       for(String f : folks)
       {
           System.out.println(f);
       }

       ArrayList<Integer> nums = new ArrayList<>();
       
       nums.add(1);
       nums.add(2);
       nums.add(3);
       
       for(Integer f : nums)
       {
           System.out.println(f);
       }  
       
       for(int x = 0; x < nums.size(); x++)
       {
           System.out.println(nums.get(x));  // same as numbs[x] in an array
       }
       
       
       for(int x = 0; x < nums.size(); x++)
       {
           System.out.println(nums.get(x) * 100);  // same as numbs[x] in an array
       }
              
       ArrayList<Double> doubs = new ArrayList<>();
       
       doubs.add(3.14);
       doubs.add(2.25);
       doubs.add(4.20);
 
       for(int x = 0; x < doubs.size(); x++)
       {
           System.out.println(doubs.get(x));  // same as numbs[x] in an array
       }
              
       
       
        
    }
    
}
