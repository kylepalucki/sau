import java.util.Scanner;
/**
 * HW-04
 * @author Kyle Palucki
 */

public class CreditCardCheck {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter credit card number: ");
        String ccString = in.nextLine();
        if (ccString.length() != 16) {
            System.out.println("Invalid Number");
        } else {
            String format = "";
            for (int i = 0; i < ccString.length(); i+=4) {
                format += ccString.substring(i, i+4);
                format += " ";
            }
            String f = format.trim();
            System.out.println(f);
            
            int[] numsEven = new int[8];
            int[] numsOdd = new int[8];
            
            int c = 0;
            for (int i = 0; i < ccString.length(); i+=2) {
                numsEven[c] = Integer.parseInt(ccString.substring(i, i+1));
                c++;
            }
            for (int i = 0; i < numsEven.length; i++) {
                numsEven[i] = numsEven[i]*2;
                if (numsEven[i] >= 10) {
                    numsEven[i] -= 9;
                }
            }
            c = 0;
            for (int i = 1; i < ccString.length(); i+=2) {
                numsOdd[c] = Integer.parseInt(ccString.substring(i, i+1));
                c++;
            }
            int sum = 0;
            for (int i = 0; i < numsEven.length; i++) {
                sum += numsEven[i] + numsOdd[i];
            }
            
            if (sum % 10 == 0){
                System.out.println("This is a valid credit card number.");
            } else {
                System.out.println("This is an invalid credit card number.");
            }
        }
    }
}
