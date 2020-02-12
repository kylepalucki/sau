
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
    public void clear() {
        for (int i = 0; i < size(); i++){
            arr[i] = null;
        }
        trimToSize();
    }


    @Override
    public E getFirst() throws IndexOutOfBoundsException {
        return arr.length>0 ? arr[0] : null;
    }
    @Override
     public E getLast() throws IndexOutOfBoundsException {
         return arr.length>0 ? arr[size-1] : null;
     }

    public void ensureCapacity(int newCap) {
        if (newCap>size) {
        E[] a = (E[])new Object[newCap];
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
        E last = !isEmpty() ? arr[size-1] : null;
        if (!isEmpty()) arr[size-1] = null;
        trimToSize();
        return last;
    }

    @Override
    public boolean isEmpty() {
    	if (arr.length==0) return true;
        for (E arr1 : arr) {
            if (arr1 != null) {
                return false;
            }
        }
        return true;
    }

    @Override
    public E removeFirst() {
        E first = !isEmpty() ? arr[0] : null;
        if (!isEmpty()) arr[0]=null;
        
        trimToSize();
        return first;
    }
    
    @Override
    public E remove(int i) {
        if (i<0||i>size()) return null;
        E remove = !isEmpty() ? arr[i] : null;
        arr[i] = null;
        trimToSize();
        return remove;
    }

    @Override
    public E setLast(E e) {
        E obj = !isEmpty() ? arr[size-1] : null;
        if (!isEmpty()) arr[size-1]=e;
        return obj;
    }


    @Override
    public void add(int i, E e) throws IndexOutOfBoundsException{
        if (i<0||i>size)return;
        if (isEmpty()) {
        	ensureCapacity(size+1);
        	arr[0] = e;
        	trimToSize();
        	return;
        } else {
	        trimToSize();
	        E[] first = (E[])new Object[i];
	        E[] last = (E[])new Object[size];
	        for (int j = 0; j < first.length; j++) {
	        	first[j] = arr[j];
	        }
	        int c = 0;
	        for (int j = i; j < size; j++) {
	        	last[c] = arr[j];
	        	c++;
	        }
	        ensureCapacity(size+1);
	        for (int j = 0; j < i; j++) {
	        	arr[j] = first[j];
	        }
	        arr[i] = e;
	        c=0;
	        for (int j = i+1; j < size; j++) {
	        	arr[j] = last[c];
	        	c++;
	        }
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
    	if (arr.length < 1) return;
        int c = 0;
        for (int i = 0; i < size; i++) {
            if (arr[i]!=null) c++;
        }
        E[] es = (E[])new Object[c];
		E[] a = es;
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
    	if (isEmpty()) return -1;
        for (int i = size-1; i >= 0; i--) {
            if (arr[i]==e) return i;
        } return -1;
    }

    @Override
    public void add(E e) {
    	trimToSize();
    	E[] s = (E[]) new Object[size];
    	for (int i = 0; i < arr.length; i++) {
    		s[i] = arr[i];
    	}
        ensureCapacity(size+1);
        for (int i = 0; i < s.length; i++) {
        	arr[i]=s[i];
        }
        arr[size-1] = e;
    }
    
    @Override
    public E setFirst(E e) {
        E obj = arr.length>0 ? arr[0] : null;
        trimToSize();
        E[] s = !isEmpty() ? (E[])new Object[size-1] : (E[]) new Object[0];

    	ensureCapacity(size+1);
    	int c = 0;
    	for (int i = 1; i < s.length; i++) {
    		s[c] = arr[i];
    		c++;
    	}
    	arr[0] = e;
    	c=0;
    	for (int i = 1; i < s.length; i++) {
            arr[i] = s[c];
            c++;
        }
       
        trimToSize();
        return obj;
    }

    @Override
    public void addFirst(E e) {
    	trimToSize();
    	E[] s = (E[]) new Object[size];
    	for (int i = 0; i < arr.length; i++) {
    		s[i] = arr[i];
    	}
        ensureCapacity(size+1);
        int c = 1;
        for (int i = 0; i < s.length; i++) {
        	arr[c]=s[i];
        	c++;
        }
        arr[0] = e;
    }

    @Override
    public void addLast(E e) {
    	trimToSize();
    	E[] s = (E[]) new Object[size];
    	for (int i = 0; i < arr.length; i++) {
    		s[i] = arr[i];
    	}
        ensureCapacity(size+1);
        for (int i = 0; i < s.length; i++) {
        	arr[i]=s[i];
        }
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