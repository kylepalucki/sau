
public class MyTester {
    public static void main(String[] args) {
        MySLinkedList<String> list = new MySLinkedList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");     
        
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
        System.out.println(list);
        
        list.addFirst("h");
        list.addFirst("k");
        
        System.out.println(list);
        
        list.add(2, "u");
        System.out.println(list);
        System.out.println(list.size);
        
        System.out.println(list.firstIndexOf("u"));
        System.out.println(list.firstIndexOf("x"));
        
        System.out.println(list.firstIndexOf("f"));
        list.add("f");
        list.add("f");
        list.add("f");
        list.add("z");
        System.out.println(list);
        System.out.println(list.remove(4));
        
        

        
    }
}
