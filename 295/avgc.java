import java.util.Scanner;
import java.util.ArrayList;
public class avgc {
	public static void main(String[] args) {
		System.out.println("---------------------------AVERAGE CALCULATOR-------------------");
		System.out.println("   Enter numbers separated by enter key to add to average calc  ");
		System.out.println("------------------------------commands--------------------------");
		System.out.println("r - remove | q - quit | g - calculate/continue | v - get added values");
		Scanner in = new Scanner(System.in);
		boolean run = true;
		double total = 0;
		double counter = 0;
		ArrayList<Double> values = new ArrayList<Double>();
		String v = "";
		while (run) {
			System.out.print("$: ");
			v = in.nextLine();
			if ( v.equalsIgnoreCase("r")) {
				System.out.print("_$: ");
				String str = in.nextLine();
				double rem = Double.parseDouble(str);
				if (rem<0 || rem > total) {
					System.out.println("invalid"); 
				} else {
					if (values.indexOf(rem)!=-1) {
						values.remove(values.indexOf(rem));
						total -= rem;
						counter--;
					}
				}
			}
			else if (v.equalsIgnoreCase("q")) {
				run = false;
				return;
			} else if (v.equalsIgnoreCase("g")) {
				System.out.println("items: " + counter);
				System.out.println("total: " + total);
				System.out.println("average: " + total/counter);
			} else if (v.equalsIgnoreCase("v")) {
				System.out.print("[");
				for (int i = 0; i < values.size(); i++){
					if (i==values.size()-1) {
						System.out.print(values.get(i));
					} else {
						System.out.print(values.get(i) + ", ");
					}
				}
				System.out.println("]");
			}
			else {
				try {
					Double val = Double.parseDouble(v);
					total += val;
					values.add(val);
					counter++;
				}catch (NumberFormatException e) {
				}
			} //average qd = 56.755
		}
	}
}