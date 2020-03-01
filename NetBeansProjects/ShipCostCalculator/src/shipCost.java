/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author weydaej
 */
public class shipCost {
    /*
    class ShippingCost
	main()
            num price
            num shippingCost
            num priceWithShipping
            output “Input the price of the item: ”
            input price
            if price >= 100 then 
                    output “Shipping is free ($0) for this product so your total is $” + price
            else 
                    shippingCost = price * 0.02
                    priceWithShipping = price + shippingCost
                    output “Shipping is $” + shippingCost + “ which gives you a total of $” +  priceWithShipping + “ for this product.”
            end if
        return
    end class
    */
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        double price = 150;
        double shippingCost = 0;
        double priceWithShipping = 0;
        System.out.println("Input the price of the item: " + price);
        if (price >= 100) {
            System.out.println("Shipping is free for this product so your total is $" + price);
        } else {
            shippingCost = price * 0.02;
            priceWithShipping = price + shippingCost;
            System.out.println("Shipping is $" + shippingCost + " which gives you a total of $" + priceWithShipping + " for this product.");
        }
    }
}
