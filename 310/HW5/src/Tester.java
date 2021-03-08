import java.util.ArrayList;

public class Tester {
    public static void main(String[] args) {

        ArrayList<TestResult> tests;

        System.out.println("Testing CircularBufferInterface");

        System.out.println("S-Linked Buffer");
        tests = new ArrayList<>();
        runCommonTests(tests, new DLinkedBuffer());
        TestResult.reportTestResults(tests);

    }

    /*
     * Test all methods specified in the MyList Interface.
     */
    public static void runCommonTests(ArrayList<TestResult> tests, CircularBufferInterface buffer){

        // Run the tests on DLinkedBuffer buffer
        runConstructorTests(tests); // Doesn't use DLinkedBuffer buffer
        runInitializeTests(tests, buffer);
        runAddRemoveTests(tests, buffer);
        runClearTests(tests, buffer);
        runIsEmptyTests(tests, buffer);
        runExceptionTests(tests, buffer);

    }

    public static void runConstructorTests(ArrayList<TestResult> tests){

        CircularBufferInterface buffer;

        // Constructing DLinkedBuffer
        buffer = new DLinkedBuffer();
        tests.add(new TestResult("Constructor part 1", "R [] F", buffer.toString()));
        tests.add(new TestResult("Constructor part 2", "0", "" + (buffer.size())));
        tests.add(new TestResult("Constructor part 3", "" + buffer.DEFAULT_CAPACITY, "" + (buffer.free())));
        tests.add(new TestResult("Constructor part 4", "true", "" + (buffer.capacity() == CircularBufferInterface.DEFAULT_CAPACITY)));

        buffer = new DLinkedBuffer(42);
        tests.add(new TestResult("Constructor part 5", "R [] F", buffer.toString()));
        tests.add(new TestResult("Constructor part 6", "0", "" + (buffer.size())));
        tests.add(new TestResult("Constructor part 7", "42", "" + buffer.free()));
        tests.add(new TestResult("Constructor part 8", "42", "" + buffer.capacity()));
    }


    public static void runCapacityTests(ArrayList<TestResult> tests, CircularBufferInterface buffer){
        buffer.clear();

        tests.add(new TestResult("Capacity part 1", "true", "" + (buffer.capacity() > 0)));

        for(int i = 0; i < buffer.DEFAULT_CAPACITY; i++){
            buffer.add(i);
        }
        tests.add(new TestResult("Capacity part 3", "true", "" + (buffer.capacity() == buffer.size())));
        tests.add(new TestResult("Capacity part 4", "true", "" + (buffer.free() == 0)));
    }

    public static void runInitializeTests(ArrayList<TestResult> tests, CircularBufferInterface buffer){
        buffer.clear();
        tests.add(new TestResult("Initial part 1", "R [] F", buffer.toString()));
        tests.add(new TestResult("initial part 2", "true", "" + buffer.isEmpty()));
        tests.add(new TestResult("Initial part 3", "0", "" + buffer.size()));
        tests.add(new TestResult("Initial part 4", "" + buffer.DEFAULT_CAPACITY, "" + buffer.free()));
        tests.add(new TestResult("Initial part 5", "" + buffer.DEFAULT_CAPACITY, "" + buffer.capacity()));

    }

    public static void runAddRemoveTests(ArrayList<TestResult> tests, CircularBufferInterface buffer){
        Integer result;
        buffer.clear();
        buffer.add(1);
        tests.add(new TestResult("add part 1", "R [1] F", buffer.toString()));
        
        buffer.add(2);
        tests.add(new TestResult("add part 2", "R [2, 1] F", buffer.toString()));
        
        buffer.add(3);
        tests.add(new TestResult("add part 3", "R [3, 2, 1] F", buffer.toString()));
        
        buffer.add(4);
        tests.add(new TestResult("add part 4", "R [4, 3, 2, 1] F", buffer.toString()));
        
        result = buffer.remove();
        
        tests.add(new TestResult("remove part 1a", "result == 1", "result == " + result));
        tests.add(new TestResult("remove part 1b", "R [4, 3, 2] F", buffer.toString()));

        result = buffer.remove();
        tests.add(new TestResult("remove part 2a", "result == 2", "result == " + result));
        tests.add(new TestResult("remove part 2b", "R [4, 3] F", buffer.toString()));

        result = buffer.remove();
        tests.add(new TestResult("remove part 2a", "result == 3", "result == " + result));
        tests.add(new TestResult("remove part 2b", "R [4] F", buffer.toString()));

        result = buffer.remove();
        tests.add(new TestResult("remove part 2a", "result == 4", "result == " + result));
        tests.add(new TestResult("remove part 2b", "R [] F", buffer.toString()));
    }

    public static void runClearTests(ArrayList<TestResult> tests, CircularBufferInterface buffer){
        buffer.clear();
        tests.add(new TestResult("clear part 1", "R [] F", buffer.toString()));
        tests.add(new TestResult("clear part 2", "0", "" + buffer.size()));
        tests.add(new TestResult("clear part 3", ""+buffer.DEFAULT_CAPACITY, "" + buffer.free()));
        tests.add(new TestResult("clear part 4", "true", "" + buffer.isEmpty()));

        buffer.add(1);
        buffer.clear();
        tests.add(new TestResult("clear part 5", "R [] F", buffer.toString()));
        tests.add(new TestResult("clear part 6", "0", "" + buffer.size()));
        tests.add(new TestResult("clear part 7", ""+buffer.DEFAULT_CAPACITY, "" + buffer.free()));
        tests.add(new TestResult("clear part 8", "true", "" + buffer.isEmpty()));

        buffer.add(1);
        buffer.add(2);
        buffer.clear();
        tests.add(new TestResult("clear part 9", "R [] F", buffer.toString()));
        tests.add(new TestResult("clear part 10", "0", "" + buffer.size()));
        tests.add(new TestResult("clear part 11", ""+buffer.DEFAULT_CAPACITY, "" + buffer.free()));
        tests.add(new TestResult("clear part 12", "true", "" + buffer.isEmpty()));
    }


    public static void runIsEmptyTests(ArrayList<TestResult> tests, CircularBufferInterface buffer){
        buffer.clear();
        tests.add(new TestResult("isEmpty part 1", "true", "" + buffer.isEmpty()));

        buffer.add(1);
        tests.add(new TestResult("isEmpty part 2", "false", "" + buffer.isEmpty()));

        buffer.add(2);
        tests.add(new TestResult("isEmpty part 3", "false", "" + buffer.isEmpty()));
    }

    public static void runExceptionTests(ArrayList<TestResult> tests, CircularBufferInterface buffer){
        // -------------- add BufferFullException
        buffer.clear();

        // Full up the buffer
        while(!buffer.isFull()){
            buffer.add(0);
        }

        try{
            buffer.add(1);
            tests.add(new TestResult("Exceptions part 1", "exception expected", "exception not thrown"));
        } catch (BufferFullException e) {
            tests.add(new TestResult("Exceptions part 2", "exception thrown", "exception thrown"));
        }

        // -------------- add BufferEmptyException
        // Empty out the buffer
        buffer.clear();

        try{
            buffer.remove();
            tests.add(new TestResult("Exceptions part 3", "exception expected", "exception not thrown"));
        } catch (BufferEmptyException e) {
            tests.add(new TestResult("Exceptions part 4", "exception thrown", "exception thrown"));
        }

    }

}

/* Holds results of a single result */
class TestResult {

    private String message;
    private String expected;
    private String received;

    public TestResult(String message, String expected, String received) {
        this.message = message;
        this.expected = expected;
        this.received = received;
    }

    private boolean passed() {
        return expected.equals(received);
    }

    public static void reportTestResults(ArrayList<TestResult> testResults) {
        System.out.println("Results of " + testResults.size() + " tests:");
        boolean errorsFound = false;
        for (TestResult result : testResults) {
            if (!result.passed()) {
                System.out.println("Error: " + result.message);
                System.out.println("\tExpected: \"" + result.expected + "\"");
                System.out.println("\tReceived: \"" + result.received + "\"");
                errorsFound = true;
            }
        }

        if(!errorsFound){
            System.out.println("No Errors Found.");
        }
    }
} // End of class TestResult