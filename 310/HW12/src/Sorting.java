
/**
 * Kyle Palucki
 * @author Dr. Lillis
 */
public class Sorting {

    public static enum Algorithm {
        MERGE_SORT,
        SELECTION_SORT,
        INSERTION_SORT,
        QUICK_SORT,
        GNOME_SORT,
        MEDIAN_QUICK_SORT,
        BUBBLE_SORT
    }

    public static void sort(int[] array, Algorithm algo) {
        switch (algo) {
            case MERGE_SORT:
                mergeSort(array);
                break;
            case SELECTION_SORT:
                selectionSort(array);
                break;
            case INSERTION_SORT:
                insertionSort(array);
                break;
            case QUICK_SORT :
                quickSort(array, 0, array.length - 1);
                break;
            case GNOME_SORT:
                gnomeSort(array);
                break;
            case MEDIAN_QUICK_SORT:
                medianQuickSort(array , 0, array.length-1);
                break;
            case BUBBLE_SORT:
                bubbleSort(array);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + algo);
        }
    }


//============================================================================
// Selection Sort
    /**
     * Selection Sort, Sorts the parameter array in place.
     * @param array the array that will be sorted.
     */
    private static void selectionSort(int[] array) {
        int minIndex;

        for(int i = 0; i < array.length - 1; i++){
            // Find index of smallest array element, starting at i
            minIndex = i;
            for(int j = i; j < array.length; j++){
                if(array[j] < array[minIndex])
                    minIndex = j;
            }

            swap(array, minIndex, i);
        }
    }

// END Selection Sort
//============================================================================


//============================================================================
// Insertion Sort
    /**
     * Insertion Sort. Sorts the parameter array in place.
     * @param arr The array to be sorted.
     */
    private static void insertionSort(int arr[]) {
        int temp, j;
        for(int i = 1; i < arr.length; i++){
            temp = arr[i];

            j = i;
            while(j > 0 && arr[j-1] > temp){
                arr[j] = arr[j-1];
                j--;
            }

            arr[j] = temp;
        }
    }

// END Insertion Sort
//============================================================================


    //============================================================================
// Quick Sort
    private static void quickSort(int[] array, int low, int high) {
        int pivotpoint;

        if (high > low) {
            pivotpoint = partition(array, low, high);
            quickSort(array, low, pivotpoint - 1);
            quickSort(array, pivotpoint + 1, high);
        }
    }

    private static int partition(int[] array, int low, int high) {
        int i, j, pivotpoint;
        int pivotitem;

        pivotitem = array[low];  // Choose first item as pivotitem
        j = low;

        for (i = low + 1; i <= high; i++) {
            if (array[i] < pivotitem) {
                j++;
                swap(array, i, j);
            }
        }

        pivotpoint = j;
        swap(array, low, pivotpoint); // Put pivotitem at pivotpoint

        return pivotpoint;
    }

// END Quick Sort
//============================================================================

//============================================================================
// Merge Sort

    // Merge Sort
    private static void mergeSort(int array[]) {
        // Check base case
        if(array.length == 1)
            return;

        int lenLeft = array.length / 2;
        int lenRight = array.length - lenLeft;

        int[] left = new int[lenLeft];
        int[] right = new int[lenRight];

        System.arraycopy(array, 0, left, 0, lenLeft);
        System.arraycopy(array, lenLeft, right, 0, lenRight);

        mergeSort(left);
        mergeSort(right);
        merge(left, right, array);
    }

    private static void merge(int[] arr1, int[] arr2, int[] merged){
        int i=0, j=0, k=0;

        while(i < arr1.length && j < arr2.length){
            if(arr1[i] < arr2[j]){
                merged[k] = arr1[i];
                i++;
                k++;
            } else {
                merged[k] = arr2[j];
                j++;
                k++;
            }
        }

        // See which one finished first
        if(i == arr1.length){
            // arr1 finished first. Copy rest of arr2
            System.arraycopy(arr2, j, merged, k, arr2.length - j);
        } else {
            // arr2 finished first. Copy rest of arr1
            System.arraycopy(arr1, i, merged, k, arr1.length - i);
        }
    }

// END Merge Sort
//============================================================================

//============================================================================
// Gnome Sort

    private static void gnomeSort(int array[]) {
        int i = 0;

        while (i < array.length) {
            if (i == 0 || array[i - 1] <= array[i]) {
                i++;
            } else {
                int tmp = array[i];
                array[i] = array[i - 1];
                array[--i] = tmp;
            }
        }
    }

// END Gnome Sort
//============================================================================

//============================================================================
//Quick Sort median-of-three optimization
    private static void medianQuickSort(int arr[], int l, int r) {
        if (l>=r) {
            return;
        }
        int p = getMedian(arr, l, r);
        int partition = medianPartition(arr, l, r,p);

        medianQuickSort(arr, l, partition-1);
        medianQuickSort(arr,partition+1, r);
    }

    private static int medianPartition(int[] arr, int l, int r, int pivot) {
        int leftItem = l;
        int rightItem = r-1;
        while (leftItem<rightItem) {
            while (arr[++leftItem] < pivot) ;
            while (rightItem > 0 && arr[--rightItem] > pivot);
            if (leftItem >= rightItem) {
                break;
            } else {
                swap(arr, leftItem, rightItem);
            }
        }
        swap(arr,leftItem,r-1);
        return leftItem;
    }

    private static int getMedian(int[] arr, int l, int r) {
        int c = (l+r)/2;
        if (arr[l] > arr[c]) {
            swap(arr, l,c);
        }
        if (arr[l] > arr[r]) {
            swap(arr,l,r);
        }
        if (arr[c] > arr[r]) {
            swap(arr, c, r);
        }
        swap(arr, c, r-1);
        return arr[r-1];
    }

//END Median Quick Sort
//============================================================================

//============================================================================
//Bubble Sort

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-i-1; j++) {
                if (arr[j] > arr[j+1]){
                    swap(arr, j+1, j);
                }
            }
        }
    }

//END Bubble Sort
//============================================================================

//============================================================================
// Three Static Helper Methods (one private and two public)

    /**
     * Swaps two array elements i and j
     * @param arr The array
     * @param i Index of 1st element
     * @param j Index of 2nd element
     */
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * Checks to see if an array of int values is sorted.
     *
     * @param arr the array to be checked
     * @return true of the given array is sorted, false if it is not sorted.
     */
    public static boolean isSorted(int[] arr){
        for(int i = 0; i < arr.length - 1; i++){
            if(arr[i] > arr[i+1])
                return false;
        }

        return true;
    }

    /**
     * Creates and returns an int array of length n filled with random numbers;
     * Each random value r is in the range low <= r <= high.
     * @param n Size of the array that will be returned
     * @param low lowest possible value in the array
     * @param high highest possible value in the array
     * @return an int array of length n fill with random number from [low, high]
     */
    public static int[] randomIntArray(int n, int low, int high) {
        // Set up for generating random numbers
        int range = high - low + 1;
        int shift = low;

        // Create and fill the anArray
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * range) + shift;
        }

        return arr;
    }

}



