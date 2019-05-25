
import java.util.ArrayList;

public class ClockTester {

    // Array lists to hold the results of the tests
    private static ArrayList<String> got = new ArrayList<>();
    private static ArrayList<String> expected = new ArrayList<>();
    private static ArrayList<Boolean> results = new ArrayList<>();

    public static void main(String[] args) {
        //////////////////////////////////////////////////
        // Test Constructors

        // 0
        addResult((new Clock()).toString(), "(0:0:0)");

        // 1
        addResult((new Clock(10)).toString(), "(10:0:0)");
        // 2
        addResult((new Clock(10, 15)).toString(), "(10:15:0)");

        // 3
        addResult((new Clock(10, 15, 20)).toString(), "(10:15:20)");

        //////////////////////////////////////////////////
        // Test set methods
        Clock c;

        // 4
        c = new Clock();
        c.set(20);
        addResult(c.toString(), "(20:0:0)");

        // 5 
        c = new Clock(20);
        c.set(30);
        addResult(c.toString(), "(20:0:0)");

        // 6
        c = new Clock();
        c.set(3, 25, 0);
        addResult(c.toString(), "(3:25:0)");

        // 7
        c = new Clock();
        c.set(7, 45, 22);
        addResult(c.toString(), "(7:45:22)");

        // 8
        c = new Clock();
        c.setHour(13);
        addResult(c.toString(), "(13:0:0)");

        // 9
        c = new Clock(16);
        c.setHour(-7);
        addResult(c.toString(), "(16:0:0)");

        // 10
        c = new Clock(19);
        c.setHour(24);
        addResult(c.toString(), "(19:0:0)");

        // 11
        c = new Clock(22);
        c.setMinute(45);
        addResult(c.toString(), "(22:45:0)");

        // 12
        c = new Clock(16, 59, 12);
        c.setMinute(-7);
        addResult(c.toString(), "(16:59:12)");

        // 13
        c = new Clock(19);
        c.setMinute(24);
        addResult(c.toString(), "(19:24:0)");

        // 14
        c = new Clock(22);
        c.setSecond(45);
        addResult(c.toString(), "(22:0:45)");

        // 15
        c = new Clock(16, 59, 12);
        c.setSecond(-7);
        addResult(c.toString(), "(16:59:12)");

        // 16
        c = new Clock(19);
        c.setSecond(24);
        addResult(c.toString(), "(19:0:24)");

        
        // More set methods
        
        // 17
        c = new Clock();
        c.set(10);
        addResult(c.toString(), "(10:0:0)");

        // 18
        c.set(8,12);
        addResult(c.toString(), "(8:12:0)");

        // 19
        c.set(13,45,52);
        addResult(c.toString(), "(13:45:52)");
        
        // 20
        c.set(-13,-45,-52);
        addResult(c.toString(), "(13:45:52)");

        
        // 21
        c.reset();
        addResult(c.toString(), "(0:0:0)");
        
        
        // get Methods
        // 22
        c = new Clock(1, 2, 3);
        addResult("" + c.getHour(), "1");
        
        // 23
        addResult("" + c.getMinute(), "2");

        // 24
        addResult("" + c.getSecond(), "3");
        
        //////////////////////////////////////////////////
        // Display results of the tests
        if (allTestsPassed()) {
            System.out.println("All Tests Passed");
        } else {
            System.out.println("The following tests failed:");
            printFailedTests();
        }

        //////////////////////////////////////////////////
        // Display all test details

        // Uncomment the following lines to print all test results
        // System.out.println("\n\nAll Test Results:");
        // printAllTests();


    } // end method: main

    public static void addResult(String result, String exp) {
        got.add(result);
        expected.add(exp);
        results.add(result.equals(exp));
    } // end methd: addResult

    public static boolean allTestsPassed() {
        for (Boolean result : results) {
            if (result == false) {
                return false;
            }
        }

        return true;
    } // end method: allTestsPassed

    public static void printFailedTests() {
        for (int i = 0; i < results.size(); i++) {
            if (results.get(i) == false) {
                System.out.printf("%3d) %-4s - %-10s  -  Expected  %s\n",
                        i,
                        (results.get(i) ? "PASS" : "FAIL"),
                        got.get(i), expected.get(i));

            }
        }
    } // end method printFailedTests

    public static void printAllTests() {
        for (int i = 0; i < results.size(); i++) {
            System.out.printf("%3d) %-4s - %-10s  -  Expected  %s\n",
                    i,
                    (results.get(i) ? "PASS" : "FAIL"),
                    got.get(i), expected.get(i));

        }
    } // end method: printAllTests

} // end class: ClockTester
