
public class KyleTester {
	public static void main(String[] args) {
		MyList<String> list;
		MyArrayListOp a;
		
		list = new MyArrayListOp<>();
		
		
		System.out.println(list); //[]
		
		list.add("a");
		System.out.println(list); //[a]
		
		list.add("a");
		System.out.println(list); //[a,a]
		
		list.add("a");
		System.out.println(list); //[a,a,a]
		
		list.add("a");
		System.out.println(list); //[a,a,a,a]
		
		list.add("a");
		System.out.println(list); //[a,a,a,a,a]
		
		list.add(3, "b");
		System.out.println(list); //[a,a,a,b,a,a]
		
		list.add(1, "c");
		System.out.println(list); //[a,c,a,a,b,a,a]
		
		//list[4] = null;
		
		list.clear();
		System.out.println(list); //[]
		
	}
}
