
public class MyTester {
	public static void main(String[] args) {
		String[] strings = {"a", "b", "c", "d", "e"};
		MyDLinkedList<String> list = new MyDLinkedList<>(strings);
		System.out.println(list);
		
                list.add(0, "f");
                
                System.out.println(list);
                list.add(3, "g");
                list.add(6, "q");
                System.out.println(list);
                
                list.set(1, "t");
                
                list.set(list.size()-1, "x");
                System.out.println(list);
                
                list.addFirst("4");
                System.out.println(list);
                list.clear();
                System.out.println(list);
                System.out.println(list.size);
                list.add("4");
                System.out.println(list);
                
                list.add("b");
                System.out.println(list);
                System.out.println(list.size);
	}
}