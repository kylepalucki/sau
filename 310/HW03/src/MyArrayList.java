
import java.util.Arrays;

public class MyArrayList<E> extends MyAbstractList<E> {
    protected E[] arr;

    static int INITIAL_CAPACITY = 0;

    public MyArrayList() {
        super();
        arr = (E[])new Object[INITIAL_CAPACITY];
        super.size = INITIAL_CAPACITY;
    }

    public MyArrayList(E[] eList) {
        super();
        arr = eList;
        super.size = eList.length;
    }

    @Override
    public boolean contains(E e) {
        for (E arr1 : arr) {
            if (arr1==e) {
                return true;
            }
        }
        return false;
    }

    @Override
    public E setFirst(E e) {
        E obj = arr[0];
        arr[0] = e;
        return obj;
    }

    @Override
    public E getFirst() {
        return arr[0];
    }
    @Override
     public E getLast() {
         return arr[arr.length-1];
     }

    public void ensureCapacity(int newCap) {
        if (newCap>size) {
        E[] a = (E[])new Object[newCap];
        //System.arraycopy(arr, 0, a, 0, arr.length);
        int c=0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null) a[c] = arr[i];
        }
        arr = a;
        super.size = arr.length;
        }
    }

    @Override
    public int firstIndexOf(E e) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]==e) return i;
        } return -1;
    }

    @Override
    public E removeLast() {
        E last = arr[arr.length-1];
        arr[arr.length-1] = null;
        trimToSize();
        return last;
    }

    @Override
    public boolean isEmpty() {
        for (E arr1 : arr) {
            if (arr1 != null) {
                return false;
            }
        }
        return true;
    }

    @Override
    public E removeFirst() {
        E first = arr[0];
        arr[0] = null;
        return first;
    }
    @Override
    public E remove(int i) {
        try {
            E obj = arr[i];
            arr[i] = null;
            return obj;
        } catch (ArrayIndexOutOfBoundsException ex) {
            return null;
        }
    }

    @Override
    public E setLast(E e) {
        E obj = arr[arr.length-1];
        arr[arr.length-1]=e;
        return obj;
    }


    @Override
    public void add(int i, E e) {
        if (i<0||i>size)return;
        try {
            arr[i] = e;
        } catch (ArrayIndexOutOfBoundsException ex) {
            ensureCapacity(size+1);
            add(i, e);
        }
    }

    @Override
    public void clear() {
        for (int i = 0; i < arr.length; i++){
            arr[i] = null;
        }
    }

    public int capacity() {
        return arr.length;
    }

    @Override
    public String toString() {
        return Arrays.toString(arr);
    }

    public void trimToSize() {
        int c = 0;
        for (int i = 0; i < size; i++) {
            if (arr[i]!=null) c++;
        }
        E[] a = (E[])new Object[c];
        c=0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]!=null){
                a[c] = arr[i];
                c++;
            }
        }
        arr = a;
        super.size = arr.length;
    }

    @Override
    public int lastIndexOf(E e) {
        for (int i = size-1; i >= 0; i--) {
            if (arr[i]==e) return i;
        } return -1;
    }

    @Override
    public void add(E e) {
        int c=0;
        for (int i = 0; i < size; i++) {
            if (arr[i] == null) c = i;
        } 
        try{
            if (arr[c] == null) { 
                arr[c] = e;
            }
        } catch (ArrayIndexOutOfBoundsException ex) {
            ensureCapacity(size+1);
            add(e);
        }
        //trimToSize();
    }

    @Override
    public void addFirst(E e) {
        arr[0] = e;
    }

    @Override
    public void addLast(E e) {
        ensureCapacity(size+1);
        arr[size-1] = e;
    }

    @Override
    public E get(int i) throws IndexOutOfBoundsException {
        try {
            return arr[i];
        } catch (ArrayIndexOutOfBoundsException ex) {
            return null;
        }
    }

    @Override
    public E set(int i, E e) throws IndexOutOfBoundsException {
        try {
            arr[i] = e;
        } catch (ArrayIndexOutOfBoundsException ex) {
        }
        return e;

    }
}