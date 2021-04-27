
import java.util.Comparator;

/**
 *
 * @author Dr. Lillis
 */
public class SortedArrayPQGeneric<E> implements GenericPQInterface<E> {

    public final static int DEFAULT_CAPACITY = 5;
    private E[] sortedArr;
    private int size;
    private Comparator<E> comparator;

    public SortedArrayPQGeneric(Comparator<E> comp) {
        this(DEFAULT_CAPACITY, comp);
    }

    public SortedArrayPQGeneric(int capacity, Comparator<E> comp) {
        sortedArr = (E[]) new Object[capacity];
        comparator = comp;
        size = 0;
    }

    @Override
    public void add(E item) {
        if (size == sortedArr.length) {
            E[] temp = (E[]) new Object[sortedArr.length * 2];
            System.arraycopy(sortedArr, 0, temp, 0, sortedArr.length);
            sortedArr = temp;
        }

        int i = size;
        while(i > 0 && comparator.compare(sortedArr[i-1], item) < 0){
            sortedArr[i] = sortedArr[i-1];
            i--;
        }
        sortedArr[i] = item;
        size++;
    }

    @Override
    public void clear() {
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public E peek() {
        if (this.isEmpty()) {
            throw new EmptyPriorityQueueException("Cannot peek from empty PQ");
        }
        return sortedArr[size - 1];
    }

    @Override
    public E remove() {
        if (this.isEmpty()) {
            throw new EmptyPriorityQueueException("Cannot remove from empty PQ");
        }
        size--;
        return sortedArr[size];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString(){
        String s = "";
        
        s += "[";
        
        boolean firstItem = true;
        for(int i = 0; i < this.size; i++){
            if(firstItem){
                s += sortedArr[i];
                firstItem = false;
            } else {
                s += ", ";
                s += sortedArr[i];
            }
        }
        
        s += "]";
        
        return s;
    }

}
