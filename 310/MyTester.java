
public class MyTester {
	public static void main(String[] args) {
		String[] strings = {"a", "b", "c", "d", "e"};
		MyDLinkedList<String> list = new MyDLinkedList<>(strings);
		System.out.println(list);
		System.out.println(list.tail.prev.prev.prev.e);
		System.out.println(list.head.next.next.e);
	}
}
