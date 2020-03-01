package YearlyMaintenanceCost;

import java.text.DecimalFormat;

/**
 *
 * @author weydaej
 */
public class YearlyMaintenanceCost 
{
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        DecimalFormat numberFormat = new DecimalFormat("#.00");
        double winterCost = 2030.76;
        double summerCost = 409.34;
        double springCost = 523.95;
        double fallCost = 620.32;

        double yearlyCost = winterCost + summerCost + springCost + fallCost;
        System.out.println("Winter = $2030.76, Summer = $409.34, Spring = $523.95, Fall = $620.32.");
        System.out.println("Your yearly home maintenance cost is $" + numberFormat.format(yearlyCost) + ".");
    }
}
