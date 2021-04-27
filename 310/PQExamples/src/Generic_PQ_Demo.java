
import java.util.Arrays;
import java.util.Comparator;


/**
 *
 * @author Dr. Lillis
 */
public class Generic_PQ_Demo {
    public static void main(String[] args) {
//        stringTest();
        integerTest();
    }
    
    public static void stringTest() {
        String[] items = {"Pill", "Hat", "Cat", "Able", "Darling", "Fat", "Mark"};
        System.out.println(Arrays.toString(items));
        Comparator<String> comp;
        GenericPQInterface<String> pq;

        //--------------------------------------------
        System.out.println();
        System.out.println("Sorted Array Priority Queue - Reverse String Comparator");
        comp = new ReverseStringComparator();
        pq = new SortedArrayPQGeneric(comp);
        
        for(String item : items){
            pq.add(item);
        }
        
        while(!pq.isEmpty()){
            System.out.println("   " + pq.remove());
        }
        
        
        //--------------------------------------------
        System.out.println();
        System.out.println("Sorted Array Priority Queue - String LengthComparator");
        comp = new StringLengthComparator();
        pq = new SortedArrayPQGeneric(comp);
        
        for(String item : items){
            pq.add(item);
        }
        
        while(!pq.isEmpty()){
            System.out.println("   " + pq.remove());
        }        

        //======================================================================

        System.out.println();
        System.out.println("Unsorted Array Priority Queue - Reverse String Comparator");
        comp = new ReverseStringComparator();
        pq = new UnsortedArrayPQGeneric(comp);
        
        for(String item : items){
            pq.add(item);
        }
        
        while(!pq.isEmpty()){
            System.out.println("   " + pq.remove());
        }
        
        
        //--------------------------------------------
        System.out.println();
        System.out.println("Unsorted Array Priority Queue - String LengthComparator");
        comp = new StringLengthComparator();
        pq = new UnsortedArrayPQGeneric(comp);
        
        for(String item : items){
            pq.add(item);
        }
        
        while(!pq.isEmpty()){
            System.out.println("   " + pq.remove());
        }        
    

    }

    

    public static void integerTest() {
        Integer[] items = {3, 7, 5, 6, 9, 4, 32, 43, 22, 43, 11};
        System.out.println(Arrays.toString(items));
        Comparator<Integer> comp;
        GenericPQInterface<Integer> pq;

        //--------------------------------------------
        System.out.println();
        System.out.println("Sorted Array Priority Queue - Reverse Integer Comparator");
        comp = new ReverseIntegerComparator();
        pq = new SortedArrayPQGeneric(comp);
        
        for(Integer item : items){
            pq.add(item);
        }
        
        while(!pq.isEmpty()){
            System.out.println("   " + pq.remove());
        }
        
        
        //--------------------------------------------
        System.out.println();
        System.out.println("Sorted Array Priority Queue - Odd-Even Comparator");
        comp = new OddEvenComparator();
        pq = new SortedArrayPQGeneric(comp);
        
        for(Integer item : items){
            pq.add(item);
        }
        
        while(!pq.isEmpty()){
            System.out.println("   " + pq.remove());
        }        
        
        //======================================================================

        //--------------------------------------------
        System.out.println();
        System.out.println("Unsorted Array Priority Queue - Reverse String Comparator");
        comp = new ReverseIntegerComparator();
        pq = new UnsortedArrayPQGeneric(comp);
        
        for(Integer item : items){
            pq.add(item);
        }
        
        while(!pq.isEmpty()){
            System.out.println("   " + pq.remove());
        }
        
        
        //--------------------------------------------
        System.out.println();
        System.out.println("Unsorted Array Priority Queue - Odd-Even Comparator");
        comp = new OddEvenComparator();
        pq = new UnsortedArrayPQGeneric(comp);
        
        for(Integer item : items){
            pq.add(item);
        }
        
        while(!pq.isEmpty()){
            System.out.println("   " + pq.remove());
        }        
        
    }
    
}
