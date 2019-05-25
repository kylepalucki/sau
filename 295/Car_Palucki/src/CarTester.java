public class CarTester {
    // errorCount is a class variable so all methods can access it.
    static int errorCount = 0;
    
    public static void main(String[] args) {
        Car c = new Car();
        check(c, 20, 35, 0, 0, "Test 1");
        
        c = new Car(25,15);
        check(c.tripRange(), 0, "Test 2");
        
        check(c, 25, 15, 0, 0, "Test 3");
        
        c.addFuel(-1);
        check(c, 25, 15, 0, 0, "Test 4");
        
        c.addFuel(1000);
        check(c, 25, 15, 0, 0, "Test 5");
                
        c.addFuel(0);
        check(c, 25, 15, 0, 0, "Test 6");
        
        c.addFuel(15);
        check(c, 25, 15, 15, 0, "Test 7");
        
        c.drive(50);
        check(c, 25, 15, 13, 50, "Test 8");
        
        c.drive(1000);
        check(c, 25, 15, 0, 375, "Test 9");

        c.drive(5);
        check(c, 25, 15, 0, 375, "Test 10");
        
        c.addFuel(10);
        check(c, 25, 15, 10, 375, "Test 11");

        c.drive(-1);
        check(c, 25, 15, 10, 375, "Test 12");

        c.drive(0);
        check(c, 25, 15, 10, 375, "Test 13");
        
        check(c.tripRange(), 250, "Test 14");
        
        
        // Print summary
        if(errorCount == 0){
            System.out.println("\nNo Errors Found");
        } else {
            System.out.println("\n" + errorCount + " test(s) failed");
        }
    }
    
    // check method that takes a car, expected values for the car, and a message
    public static void check(Car c, double eff, double cap, double level, 
                                                    double odo, String message){
        
        boolean gotError = false;
        
        if(c.getFuelEfficiency() != eff){
            if(!gotError){
                System.out.println(message + ": " + c);
                gotError = true;
            }
            System.out.println("\tEfficiency: got " + c.getFuelEfficiency() +
                    " expected " + eff);
        }
        
        if(c.getFuelCapacity() != cap){
            if(!gotError){
                System.out.println(message + ": " + c);
                gotError = true;
            }
            System.out.println("\tCapacity: got " + c.getFuelCapacity() +
                    " expected " + cap);
        }

        if(c.getFuelLevel() != level){
            if(!gotError){
                System.out.println(message + ": " + c);
                gotError = true;
            }
            System.out.println("\tLevel: got " + c.getFuelLevel() +
                    " expected " + level);
        }

        if(c.getOdometer() != odo){
            if(!gotError){
                System.out.println(message + ": " + c);
                gotError = true;
            }
            System.out.println("\tOdometer: got " + c.getOdometer() +
                    " expected " + odo);
        }
        if(gotError){
            errorCount++;
        }
    }
    
    // check method that takes an int, the expected value, and a messge
    public static void check(int value, int expected, String message ){
        if (value != expected){
            errorCount++;
            System.out.println(message);
            System.out.println("\tgot " + value + " expected " + expected);
        }
        
    }

    // check method that takes a double, the expected value, and a messgae
    public static void check(double value, double expected, String message ){
        if (value != expected){
            errorCount++;
            System.out.println(message + ": got " + value + " expected " + expected);
        }
        
    }

}
    
