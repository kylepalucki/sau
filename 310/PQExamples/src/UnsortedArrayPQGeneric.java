import java.util.Comparator;
/**
 *
 * @author Dr. Lillis
 */
public class UnsortedArrayPQGeneric<E> implements GenericPQInterface<E> {

    public final static int DEFAULT_CAPACITY = 5;
    private E[] unsortedArr;
    int size;
    private Comparator<E> comparator;
    
    public UnsortedArrayPQGeneric(Comparator<E> comp){
        this(DEFAULT_CAPACITY,comp);
    }
    
    public UnsortedArrayPQGeneric(int capacity, Comparator<E> comp){
        unsortedArr = (E[]) new Object[capacity];
        comparator = comp;
        size = 0;
    }
    
    @Override
    public void add(E item) {
        if (size == unsortedArr.length) {
            E[] temp = (E[]) new Object[unsortedArr.length * 2];
            System.arraycopy(unsortedArr, 0, temp, 0, unsortedArr.length);
            unsortedArr = temp;
        }
        unsortedArr[size] = item;
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
        if(this.isEmpty()){
            throw new EmptyPriorityQueueException("Cannot peek from empty PQ");
        }
        E min = unsortedArr[0];
        for(int i = 1; i < size; i++){
            if (comparator.compare(unsortedArr[i],min) < 0){
                min = unsortedArr[i];
            }
        }
        return min;
    }

    @Override
    public E remove() {
        if(this.isEmpty()){
            throw new EmptyPriorityQueueException("Cannot remove from empty PQ");
        }
        
        // Find the index of the item with the highest priority
        int minIndex = 0; // index of item with highest priority
        for(int i = 1; i < size; i++){
            if(comparator.compare(unsortedArr[i], unsortedArr[minIndex]) < 0){
                minIndex = i;
            }
        }
        
        // Save the item with highest priority so we can return it at the end
        E hpItem = unsortedArr[minIndex];

        // Remove the highest prioity item frm the array
        for(int i = minIndex; i < size - 1; i++){
            unsortedArr[i] = unsortedArr[i+1];
        }
        size--;

        // return the highest priority item
        return hpItem;        
        
        
//        int minIndex = 0;
//        for(int i = 0; i < size; i++){
//            if(unsortedArr[i] < unsortedArr[minIndex]){
//                minIndex = i;
//            }
//        }
//        // at this point, minIndex is the index of the smallest item.
//        
//        int minValue = unsortedArr[minIndex];
//        
//        System.arraycopy(unsortedArr, minIndex+1, unsortedArr, minIndex, /*unsortedArr.length*/size - minIndex - 1);
//        size--;
//        return minValue;
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
                s += unsortedArr[i];
                firstItem = false;
            } else {
                s += ", ";
                s += unsortedArr[i];
            }
        }
        
        s += "]";
        
        return s;
    }
    
}
