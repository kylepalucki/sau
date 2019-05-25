/*
 * Kyle Palucki
 * HW02 09/05/2018
 */
package car.cost;

import java.util.Scanner;
//

public class CarCost {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter Purchase Price: $");
        int purchasePrice = in.nextInt();
        in.nextLine();
        System.out.print("Enter miles driven per year: ");
        int miles = in.nextInt();
        in.nextLine();
        System.out.print("Enter gas price: $");
        double gasPrice = in.nextDouble();
        in.nextLine();
        System.out.print("Enter fuel efficiency: ");
        int fuel = in.nextInt();
        in.nextLine();
        System.out.print("Enter resale value after 5 years: $");
        int resalePrice = in.nextInt();
        in.nextLine();

        System.out.println();
        double gasPurchased = (miles / fuel) * gasPrice * 5;
        double cost = purchasePrice + gasPurchased - resalePrice;

        System.out.println("Total cost of ownership is: $" + cost);

    }
}
