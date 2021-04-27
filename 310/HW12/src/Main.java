
import java.util.Arrays;

/**
 * Kyle Palucki
 * @author Dr. Lillis
 */
public class Main {

    public static void main(String[] args) {
        int[] arrayMaster = Sorting.randomIntArray(15, 1, 10);
        Sorting.Algorithm[] algorithms = Sorting.Algorithm.values();

        int[] array;
        String message;
        for (Sorting.Algorithm algo : algorithms) {
            array = Arrays.copyOf(arrayMaster, arrayMaster.length);

            System.out.println("---------------------------------------------");
            message = "" + algo + "\n";
            message += "Before " + Arrays.toString(array);
            message += (Sorting.isSorted(array) ? " " : " Not") + " Sorted\n";
            System.out.print(message);

            Sorting.sort(array, algo);

            message = "After  " + Arrays.toString(array);
            message += (Sorting.isSorted(array) ? "" : "Not") + " Sorted\n";
            System.out.print(message);

        }

    } // End of main()

}