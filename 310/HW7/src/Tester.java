import java.util.ArrayList;

public class Tester {
    public static void main(String[] args) {

        ArrayList<TestResult> tests;

        System.out.println("Testing D-Linked Stack");

        tests = new ArrayList<>();
        runCommonTests(tests, new SLinkedStack<Integer>());
        TestResult.reportTestResults(tests);

    }

    /*
     * Test all methods specified in the MyList Interface.
     */
    public static void runCommonTests(ArrayList<TestResult> tests, StackInterface<Integer> stack){

        // Run the tests on Stack Interface
        runConstructorTests(tests); // Doesn't use DLinkedBuffer buffer
        runInitializeTests(tests, stack);
        runPushPopTests(tests, stack);
        runClearTests(tests, stack);
        runIsEmptyTests(tests, stack);
        runExceptionTests(tests, stack);

    }

    public static void runConstructorTests(ArrayList<TestResult> stack){

        StackInterface buffer;

        // Constructing DLinkedBuffer
        buffer = new SLinkedStack();
        stack.add(new TestResult("Constructor part 1", "[] TOS", buffer.toString()));
        stack.add(new TestResult("Constructor part 2", "0", "" + (buffer.size())));

    }


    public static void runInitializeTests(ArrayList<TestResult> tests, StackInterface<Integer> stack){
        stack.clear();

        tests.add(new TestResult("Initial part 1", "[] TOS", stack.toString()));
        tests.add(new TestResult("initial part 2", "true", "" + stack.isEmpty()));
        tests.add(new TestResult("Initial part 3", "0", "" + stack.size()));

    }

    public static void runPushPopTests(ArrayList<TestResult> tests, StackInterface<Integer> stack){
        Integer result;
        stack.clear();
        stack.push(1);
        tests.add(new TestResult("add part 1", "[1] TOS", stack.toString()));

        stack.push(2);
        tests.add(new TestResult("add part 2", "[1, 2] TOS", stack.toString()));

        stack.push(3);
        tests.add(new TestResult("add part 3", "[1, 2, 3] TOS", stack.toString()));

        stack.push(4);
        tests.add(new TestResult("add part 4", "[1, 2, 3, 4] TOS", stack.toString()));

        result = stack.pop();
        tests.add(new TestResult("remove part 1a", "result == 4", "result == " + result));
        tests.add(new TestResult("remove part 1b", "[1, 2, 3] TOS", stack.toString()));

        result = stack.pop();
        tests.add(new TestResult("remove part 2a", "result == 3", "result == " + result));
        tests.add(new TestResult("remove part 2b", "[1, 2] TOS", stack.toString()));

        result = stack.pop();
        tests.add(new TestResult("remove part 2a", "result == 2", "result == " + result));
        tests.add(new TestResult("remove part 2b", "[1] TOS", stack.toString()));

        result = stack.pop();
        tests.add(new TestResult("remove part 2a", "result == 1", "result == " + result));
        tests.add(new TestResult("remove part 2b", "[] TOS", stack.toString()));
    }

    public static void runClearTests(ArrayList<TestResult> tests, StackInterface<Integer> stack){
        stack.clear();

        tests.add(new TestResult("clear part 1", "[] TOS", stack.toString()));
        tests.add(new TestResult("clear part 2", "0", "" + stack.size()));
        tests.add(new TestResult("clear part 4", "true", "" + stack.isEmpty()));

        stack.push(1);
        stack.clear();
        tests.add(new TestResult("clear part 5", "[] TOS", stack.toString()));
        tests.add(new TestResult("clear part 6", "0", "" + stack.size()));
        tests.add(new TestResult("clear part 8", "true", "" + stack.isEmpty()));

        stack.push(1);
        stack.push(2);
        stack.clear();
        tests.add(new TestResult("clear part 9", "[] TOS", stack.toString()));
        tests.add(new TestResult("clear part 10", "0", "" + stack.size()));
        tests.add(new TestResult("clear part 12", "true", "" + stack.isEmpty()));
    }


    public static void runIsEmptyTests(ArrayList<TestResult> tests, StackInterface<Integer> buffer){
        buffer.clear();
        tests.add(new TestResult("isEmpty part 1", "true", "" + buffer.isEmpty()));

        buffer.push(1);
        tests.add(new TestResult("isEmpty part 2", "false", "" + buffer.isEmpty()));

        buffer.push(2);
        tests.add(new TestResult("isEmpty part 3", "false", "" + buffer.isEmpty()));
    }

    public static void runExceptionTests(ArrayList<TestResult> tests, StackInterface<Integer> buffer){
        // -------------- add BufferFullException
        buffer.clear();

        // -------------- add BufferEmptyException
        // Empty out the buffer
        buffer.clear();

        try{
            buffer.pop();
            tests.add(new TestResult("Exceptions part 1", "exception expected", "exception not thrown"));
        } catch (EmptyStackException e) {
            tests.add(new TestResult("Exceptions part 2", "exception thrown", "exception thrown"));
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