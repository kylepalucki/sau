import java.util.Comparator;

/**
 * @author KYLE PALUCKI
 * @param <E>
 */
public class Heap<E> implements HeapInterface<E> {
    Comparator<E> comparator;
    E[] arr;
    int size;
    public Heap(Comparator<E> comparator) {
        this.comparator = comparator;
        arr = (E[]) new Object[5];
        this.size = 0;
    }
    /**
     * Adds the specified element to this heap.
     *
     * @param element the element to add to this heap.
     */

    @Override
    public void add(E element) {
        if (size() == arr.length - 1) {
            E[] temp = (E[]) new Object[size() * 2];
            System.arraycopy(arr, 0, temp, 0, arr.length);
            arr = temp;
        }
        sizeUp();
        arr[size()] = element;
        int child = size();
        int parent = (child)/2;
        while (parent > 0 && comparator.compare(arr[child],arr[parent])<0) {
            swap(child,parent);
            child = parent;
            parent = (child)/2;
        }
    }

    private void swap(int x, int y) {
        E temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    /**
     * Removes and returns the element with the highest priority.
     *
     * @return element with the highest priority.
     * @throws EmptyHeapException when trying to remove from an empty heap.
     */
    @Override
    public E remove() throws EmptyHeapException{
        if (isEmpty()) throw new EmptyHeapException();
        E minVal = arr[1];
        swap(1, size());
        sizeDown();
        int current = 1;
        boolean done = false;
        while (2 * current - 1 < size() && !done) {
            if (2*current == size()) {
                int left = 2*current;
                if (comparator.compare(arr[left], arr[current])<0) {
                    swap(left, current);
                } else done=true;
            } else {
                int left = 2 * current;
                int right = 2 * current+1;
                int minC = comparator.compare(arr[left], arr[right])<0 ? left : right;
                if (comparator.compare(arr[minC], arr[current])<0) {
                    swap(minC, current);
                    current = minC;
                } else done = true;
            }
        }
        return minVal;
    }
    /**
     * Returns the number of elements stored in this heap.
     *
     * @return number of elements in this heap.
     */
    @Override
    public int size() {
        return this.size;
    }

    /**
     * Returns true if there are no elements in this heap, false otherwise.
     *
     * @return true if there are no elements in this heap, false otherwise.
     */
    @Override
    public boolean isEmpty() {
        return size()==0;
    }

    private void sizeUp() { this.size++; }

    private void sizeDown() { this.size--; }
}

