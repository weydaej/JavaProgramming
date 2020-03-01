package MonthlyCCBalance;

import java.text.DecimalFormat;

/**
 *
 * @author weydaej
 */
public class MonthlyCCBalance 
{
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        /*

        output “Interest due after one month is “ + oneMonth “, and “ + twoMonth “ after two months”
        */
        DecimalFormat numberFormat = new DecimalFormat("#.00");
        double cardBalance = 5000;
        double interest = 0.17;
        double oneMonth = cardBalance * interest;
        double twoMonth = (cardBalance + oneMonth) * interest;
        String output = String.format("Interest due after one month is $" + numberFormat.format(oneMonth) + " and $" + numberFormat.format(twoMonth) + " after two months.");
        System.out.println("Your card balance is $5000 with 0.17% interest.");
        System.out.println(output);
    }
}
