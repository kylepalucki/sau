/**
 * Kyle Palucki
 * Homework 03
 * 09/17/2018
 */

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import java.text.DecimalFormat;

public class Millionare {
    public static void main(String[] args) {
        //reads in string variables from JOptionPane
        String pmtString = (String) JOptionPane.showInputDialog(null, "Enter amount saved per month", "Input", 0, UIManager.getIcon("FileView.computerIcon"), null, null);
        String nString = (String) JOptionPane.showInputDialog(null, "Enter number of years", "Input", 0, UIManager.getIcon("FileView.computerIcon"), null, null);
        String iString = (String) JOptionPane.showInputDialog(null, "Enter interest rate", "Input", 0, UIManager.getIcon("FileView.computerIcon"), null, null);
        
        //converts vars into appropriate types
        double pmt = Double.parseDouble(pmtString);
        int n = Integer.parseInt(nString);
        double i = Double.parseDouble(iString);
        
        //calls calculate method, formats output string, prints msgString to JOptionPane message box
        DecimalFormat formatter = new DecimalFormat("#,###.00");
        String moneyString = formatter.format(Millionare.calculate(pmt,n,i));
        
        String msgString = "Amount at the end: $" + moneyString;
        JOptionPane.showMessageDialog(null, msgString, "Output", 0, UIManager.getIcon("Tree.closedIcon"));  
    }

    public static double calculate(double pmt, int n, double i) {
        double in = i/1200; // this is just a variable placeholder for i/2000
        
        double x = (Math.pow((1+in),(12*n))-1)/in; //the rest of the function inside of the Pmt()
        
        double fv = pmt*x; //pmt * rest of the function
        
        return fv;
    }
}
