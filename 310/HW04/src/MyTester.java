
public class MyTester {
    public static void main(String[] args) {
        MySLinkedList<String> list = new MySLinkedList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        System.out.println(list.toString());
        System.out.println(list);
        System.out.println("head: " +list.head.e);
        System.out.println("tail: " +list.tail.e);
        System.out.println(list.size());
        list.addFirst("x");
        list.addFirst("y");  
        System.out.println(list);
        
        
        Integer[] arr1 = {1};
        Integer[] arr2 = {1, 2};
        Integer[] arr3 = {1, 2, 3};
        MySLinkedList<Integer> list1 = new MySLinkedList<>(arr1);
        MySLinkedList<Integer> list2 = new MySLinkedList<>(arr2);
        MySLinkedList<Integer> list3 = new MySLinkedList<>(arr3);
        System.out.println(list1);
        System.out.println(list2);
        System.out.println(list3);
       
        System.out.println(list);
        
        System.out.println(list.contains("a"));
        System.out.println(list.contains("g"));
        
        System.out.println(list.set(3, "z"));
        System.out.println(list);
        System.out.println(list.size);
        //list1.set(1, 3);
        System.out.println(list.get(3));
        
        System.out.println(list.removeFirst());
        System.out.println(list);
        System.out.println(list.size);
        
        System.out.println(list.removeLast());
        System.out.println(list);
        
        list.add("z");
        System.out.println(list);
        System.out.println(list.size);
        
        list.removeFirst();
        System.out.println(list);
        System.out.println(list.size);
        
        list.add("f");
        list.add("r");
        System.out.println(list);
        System.out.println(list.size);
        System.out.println(list.removeLast());


        
    }
}
