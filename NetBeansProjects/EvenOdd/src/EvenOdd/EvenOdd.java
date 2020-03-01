package EvenOdd;
/**
 *
 * @author weydaej
 */
public class EvenOdd {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        int numToExamine = 2;
        System.out.println("Number entered is " + numToExamine + ".");
        if (numToExamine % 2 == 0){
            System.out.println("Your number is even!");
        } else {
            System.out.println("Your number is odd!");
        }
    }
}
