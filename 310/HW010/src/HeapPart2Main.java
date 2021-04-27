import java.util.Comparator;

/**
 * @author Kyle Palucki
 */
public class HeapPart2Main {
    public static void main(String[] args) {
        Heap<String> heap1 = new Heap<>(new Comparator1());
        Heap<Integer> heap2 = new Heap<>(new Comparator2());
        Heap<Integer> heap3 = new Heap<>(new Comparator3());
        heap1.add("Jack Harkness");
        heap1.add("The Doctor");
        heap1.add("Martha Jones");
        heap1.add("Mickey Smith");
        heap1.add("Donna Noble");
        heap1.add("Rose Tyler");
        heap1.add("Sally Sparrow");
        heap1.add("River Song");
        heap1.add("Sarah Jane Smith");
        heap1.add("Amy Pond");
        while (!heap1.isEmpty()) {
            System.out.println(heap1.remove());
        }
        heap2.add(12);
        heap2.add(5);
        heap2.add(43);
        heap2.add(54);
        heap2.add(23);
        heap2.add(43);
        heap2.add(12);
        heap2.add(65);
        heap2.add(76);
        heap2.add(45);
        heap2.add(34);
        heap2.add(54);
        heap2.add(23);
        heap2.add(43);
        heap2.add(54);
        while (!heap2.isEmpty()) {
            System.out.println(heap2.remove());
        }
        heap3.add(12);
        heap3.add(5);
        heap3.add(43);
        heap3.add(54);
        heap3.add(23);
        heap3.add(43);
        heap3.add(12);
        heap3.add(65);
        heap3.add(76);
        heap3.add(45);
        heap3.add(34);
        heap3.add(54);
        heap3.add(23);
        heap3.add(43);
        heap3.add(54);
        while (!heap3.isEmpty()) {
            System.out.println(heap3.remove());
        }
    }
}

class Comparator1 implements Comparator<String> {
    @Override
    public int compare(String s1, String s2) {
        if (s1.length()>s2.length()) {
            return 1;
        } else if (s2.length() > s1.length()) {
            return -1;
        } else {
            return -s1.compareTo(s2);
        }
    }
}

class Comparator2 implements Comparator<Integer> {
    @Override
    public int compare(Integer i1, Integer i2) {
        if (i1%2==0 && i2%2!=0) {
            return -1;
        } else if (i1%2 !=0 && i2%2==0) {
            return 1;
        } else {
            if (i1 >= i2) {
                return 1;
            } return -1;
        }
    }
}

class Comparator3 implements Comparator<Integer> {
    @Override
    public int compare(Integer i1, Integer i2) {
        if (i1%2==0 && i2%2!=0) {
            return 1;
        } else if (i1%2 !=0 && i2%2==0) {
            return -1;
        } else {
            if (i1 <= i2) {
                return -1;
            } return 1;
        }
    }
}
