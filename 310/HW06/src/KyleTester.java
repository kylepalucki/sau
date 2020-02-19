/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author CSStudent
 */
import java.util.Random;

public class KyleTester {

    public static void main(String[] args) {
        /*
        double probability = 0.25;
        Random generator = new Random();
        for (int i = 0; i < 10; i++) {
            int r = generator.nextInt(99) + 1;
            System.out.println(r);
            if (r < probability*100) {
                System.out.println(true);
            } else {
                System.out.println(false);
            }
        }
        */
        
        CarWashSimulator cws = new CarWashSimulator(20,4,0.09);
        cws.runSimulation();
        System.out.println(""+cws.getLog());
        
    }
}
