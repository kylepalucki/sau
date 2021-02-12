public class SearchTester {
    public static void main(String[] args) {
        int[] data;
        int key, result, expected, testNo;
        boolean errorsFound = false;
        String algo;
        String formatString = "ERROR: Test #%d %s Search. Expected %d got %d.%n";

        // Test 1 - Empty array
        data = new int[] {};
        testNo = 1;
        key = 8;
        expected = -1;
        result = LinearBinarySearch.linearSearch(data, key);
        algo = "Linear";

        if (result != expected) {
            System.out.printf(formatString, testNo, algo, expected, result);
            errorsFound = true;
        }

        expected = -1;
        result = LinearBinarySearch.binarySearch(data, key);
        algo = "Binary";

        if (result != expected) {
            System.out.printf(formatString, testNo, algo, expected, result);
            errorsFound = true;
        }

        // Test 2 - Not found, smaller than smallest in array
        data = new int[] { 2, 4, 6, 8 };
        testNo = 2;
        key = 1;
        expected = -1;
        result = LinearBinarySearch.linearSearch(data, key);
        algo = "Linear";

        if (result != expected) {
            System.out.printf(formatString, testNo, algo, expected, result);
            errorsFound = true;
        }

        expected = -1;
        result = LinearBinarySearch.binarySearch(data, key);
        algo = "Binary";

        if (result != expected) {
            System.out.printf(formatString, testNo, algo, expected, result);
            errorsFound = true;
        }

        // Test 3 - Not found, larger than largest in array
        data = new int[] { 2, 4, 6, 8 };
        testNo = 3;
        key = 9;
        expected = -1;
        result = LinearBinarySearch.linearSearch(data, key);
        algo = "Linear";

        if (result != expected) {
            System.out.printf(formatString, testNo, algo, expected, result);
            errorsFound = true;
        }

        expected = -5;
        result = LinearBinarySearch.binarySearch(data, key);
        algo = "Binary";

        if (result != expected) {
            System.out.printf(formatString, testNo, algo, expected, result);
            errorsFound = true;
        }

        // Test 4 - Not found, somewhere in the middle
        data = new int[] { 2, 4, 6, 8 };
        testNo = 4;
        key = 3;
        expected = -1;
        result = LinearBinarySearch.linearSearch(data, key);
        algo = "Linear";

        if (result != expected) {
            System.out.printf(formatString, testNo, algo, expected, result);
            errorsFound = true;
        }

        expected = -2;
        result = LinearBinarySearch.binarySearch(data, key);
        algo = "Binary";

        if (result != expected) {
            System.out.printf(formatString, testNo, algo, expected, result);
            errorsFound = true;
        }

        // Test 5 - Found, First element
        data = new int[] { 2, 4, 6, 8 };
        testNo = 5;
        key = 2;
        expected = 0;
        result = LinearBinarySearch.linearSearch(data, key);
        algo = "Linear";

        if (result != expected) {
            System.out.printf(formatString, testNo, algo, expected, result);
            errorsFound = true;
        }

        expected = 0;
        result = LinearBinarySearch.binarySearch(data, key);
        algo = "Binary";

        if (result != expected) {
            System.out.printf(formatString, testNo, algo, expected, result);
            errorsFound = true;
        }

        // Test 6 - Found, Last element
        data = new int[] { 2, 4, 6, 8 };
        testNo = 5;
        key = 8;
        expected = 3;
        result = LinearBinarySearch.linearSearch(data, key);
        algo = "Linear";

        if (result != expected) {
            System.out.printf(formatString, testNo, algo, expected, result);
            errorsFound = true;
        }

        expected = 3;
        result = LinearBinarySearch.binarySearch(data, key);
        algo = "Binary";

        if (result != expected) {
            System.out.printf(formatString, testNo, algo, expected, result);
            errorsFound = true;
        }

        // Test 7 - Found, Last element
        data = new int[] { 2, 4, 6, 8 };
        testNo = 5;
        key = 6;
        expected = 2;
        result = LinearBinarySearch.linearSearch(data, key);
        algo = "Linear";

        if (result != expected) {
            System.out.printf(formatString, testNo, algo, expected, result);
            errorsFound = true;
        }

        expected = 2;
        result = LinearBinarySearch.binarySearch(data, key);
        algo = "Binary";

        if (result != expected) {
            System.out.printf(formatString, testNo, algo, expected, result);
            errorsFound = true;
        }

        // The End
        if (!errorsFound) {
            System.out.println("All tests passed");
        }

    }
}