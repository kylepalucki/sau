public class SearchTimer {
	static long start = 0;
	static long end = 0;
	
	public static void main(String[] args) {
		for (int i = 0; i < 250000000; i+=10000000) {
			int[] arr = buildArray(i);
			start = System.currentTimeMillis();
			LinearBinarySearch.binarySearch(arr, i);
			end = System.currentTimeMillis();
			System.out.println("Time: " + (end-start));
			start = System.currentTimeMillis();
			LinearBinarySearch.linearSearch(arr, i+1);
			end = System.currentTimeMillis();
			System.out.println("Time: " + (end-start));
		}
	}
	private static int[] buildArray(int size) {
		int[] arr = new int[size];
		for (int i = 0; i < size; i++) {
			arr[i] = i;
		} return arr;
	}
}