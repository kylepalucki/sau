public class LinearBinarySearch {
	
	public static int linearSearch(int[] arr, int key) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i]==key) return i;
		} return -1;
	}
	
	public static int binarySearch(int[] arr, int key) {
		int low = 0;
		int high = arr.length -1;
		while (low <= high) {
			int middle = (low + high) /2;
			if (arr[middle] == key) {
				return middle;
			} else if (key > arr[middle]) {
				low = middle + 1;
			} else {
				high = middle - 1;
			} 
		} return -low-1;
	}
}