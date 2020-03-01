package SalesTax;

import java.text.DecimalFormat;

/**
 *
 * @author weydaej
 */
public class SalesTax 
{
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        DecimalFormat numberFormat = new DecimalFormat("#.00");
        double purchasePrice = 5432.75;
        double salesTax = purchasePrice * .05;
        System.out.println("Purchase price = $5432.75.");
        System.out.println("5% sales tax on your purchase price is " + numberFormat.format(salesTax) + ".");
    }
}
