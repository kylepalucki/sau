import java.io.*;
public class SearchTimer {
	static long start = 0;
	static long end = 0;
	public static void main(String[] args) {
		try (PrintWriter pw = new PrintWriter(new File("searches.csv"))) {
			StringBuilder sb = new StringBuilder();
			sb.append("Running Time (ms)");
			sb.append(",");
			sb.append("Array Size (n)");
			sb.append(",");
			sb.append("Search (binary/linear)");
			sb.append("\n");
			for (int i = 0; i < 250000000; i+=10000000) {
				int[] arr = buildArray(i);
				start = System.currentTimeMillis();
				LinearBinarySearch.binarySearch(arr, i);
				end = System.currentTimeMillis();
				sb.append(""+(end-start));
				sb.append(",");
				sb.append(""+i);
				sb.append(",");
				sb.append("Binary");
				sb.append("\n");
			}
			for (int i = 0; i < 250000000; i+=10000000) {
				int[] arr = buildArray(i);
				start = System.currentTimeMillis();
				LinearBinarySearch.linearSearch(arr, i);
				end = System.currentTimeMillis();
				sb.append(""+(end-start));
				sb.append(",");
				sb.append(""+i);
				sb.append(",");
				sb.append("Linear");
				sb.append("\n");
			}
			pw.write(sb.toString());
		} catch (FileNotFoundException e) {
			System.out.println(e);
		}
	}
	private static int[] buildArray(int size) {
		int[] arr = new int[size];
		for (int i = 0; i < size; i++) {
			arr[i] = i;
		} return arr;
	}
}