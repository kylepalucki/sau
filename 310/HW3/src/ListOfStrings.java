import java.util.*;

public class ListOfStrings implements ListOfStringInterface{
    static final int DEFAULT_CAPACITY = 4;

    public String[] arr;
    private int size;

    public ListOfStrings() {
        arr = new String[DEFAULT_CAPACITY];
        size = 0;
    }

    public ListOfStrings(int initCap) {
        arr = new String[initCap];
        size = 0;
    }
    /**
     * Adds the given element to the end of this list.
     *
     * @param str element to be added to the end of this list
     */
    @Override
    public void add(String str) {
        this.addLast(str);
        //size++;
    }

    /**
     * Adds the given element at the given index position i.
     *
     * @param i   index position where the given element will be added
     * @param str element to be added at the given index position
     * @throws IndexOutOfBoundsException if i &lt; 0 or i &gt; size()
     *                                   Note: It is OK for i to equal size()
     */
    @Override
    public void add(int i, String str) throws IndexOutOfBoundsException {
        if (i < 0 || i > getCapacity()) throw new IndexOutOfBoundsException();
        else if (i == getCapacity()) {
            ensureCapacity(getCapacity()+DEFAULT_CAPACITY);
            arr[i] = str;
            size++;
            return;
        }
        if (arr[i] == null) {
            arr[i] = str;
            size++;
            return;
        }
        else {
            if (size()==getCapacity()) {
                ensureCapacity(getCapacity()+DEFAULT_CAPACITY);
            }
            String[] s1 = new String[i];
            String[] s2 = new String[size];
            if (i==0) {
                for(int j = getCapacity()-1; j > 0; j--){
                    arr[j] = arr[j-1];
                }
                arr[0] = str;
                size++;
                return;
            }
            else {
                int c = 0;
                for (int j = 0; j < s1.length; j++) {
                    s1[j] = arr[j];
                }
                for (int j = i; j < s2.length; j++) {
                    s2[c++] = arr[j];
                }

                for (int j = 0; j < i; j++) {
                    arr[j] = s1[j];
                }
                arr[i] = str;
                c = 0;
                for (int j = i + 1; j < s2.length; j++) {
                    arr[j] = s2[c++];
                }
                size++;
            }
        }
    }

    /**
     * Adds the given element to the beginning of this list.
     *
     * @param str element to be added to the beginning of this list
     */
    @Override
    public void addFirst(String str) {
        String[] temp = new String[getCapacity()+1];
        int c=0;
        for (int i = 1; i < temp.length; i++) {
            temp[i] = arr[c++];
        }
        arr = temp;
        add(0, str);

    }

    /**
     * Adds the given element to the end of this list.
     *
     * @param str element to be added to the end of this list
     */
    @Override
    public void addLast(String str) {
        for (int i = 0; i < getCapacity(); i++) {
            if (arr[i]==null) {
                arr[i] = str;
                size++;
                return;
            }
        }
        ensureCapacity(getCapacity()+DEFAULT_CAPACITY);
        arr[getCapacity()-DEFAULT_CAPACITY] = str;
        size++;
    }

    /**
     * Removes all list elements, if any exist.
     */
    @Override
    public void clear() {
        Arrays.fill(arr, null);
        size = 0;
    }

    /**
     * Removes unused capacity by making the capacity equal to the size.
     */
    @Override
    public void compress() {
        if (getCapacity() > size) {
            String[] temp = new String[size];
            int c=0;
            for (String s : arr) {
                if (s == null) continue;
                else temp[c++] = s;
            }
            arr = temp;
        }
    }

    /**
     * Returns true if the specified element in in this list, returns false
     * otherwise.
     *
     * @param str element that is being searched for
     * @return true if the specified element is in this list, returns false
     * otherwise
     */
    @Override
    public boolean contains(String str) {
        for (int i = 0; i < getCapacity(); i++) {
            if (arr[i]==null) continue;
            else if (arr[i].equals(str)) return true;
        } return false;
    }

    /**
     * Increases the capacity of this list, if necessary, to ensure
     * that it can hold at least the number of elements specified by the minimum
     * capacity argument.
     *
     * @param minCapacity the desired minimum capacity
     */
    @Override
    public void ensureCapacity(int minCapacity) {
        if (minCapacity > getCapacity()) {
            String[] temp = new String[minCapacity];
            System.arraycopy(arr, 0, temp, 0, getCapacity());
            arr = temp;
        }
    }

    /**
     * Returns the index of the first occurrence of the specified element,
     * -1 if the element is not in this list.
     *
     * @param str element being searched for
     * @return index of the first occurrence of the specified element,
     * returns -1 if the element is not in this list
     */
    @Override
    public int firstIndexOf(String str) {
        compress();
        for (int i = 0; i < getCapacity(); i++) {
            if (arr[i]==null) continue;
            else if (arr[i].equals(str)) return i;
        } return -1;
    }

    /**
     * Returns the element at the given index position.
     *
     * @param i index of the list element to return
     * @return the element located at the given index position
     * @throws IndexOutOfBoundsException if i &lt; 0 or i &ge; size()
     */
    @Override
    public String get(int i) throws IndexOutOfBoundsException {
        if (i < 0 || i > getCapacity() -1) throw new IndexOutOfBoundsException();
        return arr[i];
    }

    /**
     * Returns the current capacity of this list.
     *
     * @return the current capacity of this list.
     */
    @Override
    public int getCapacity() {
        return arr.length;
    }

    /**
     * Returns the first element in this list.
     *
     * @return the first element in this list.
     * @throws IllegalStateException if this list is empty.
     */
    @Override
    public String getFirst() throws IllegalStateException {
        compress();
        if (isEmpty()) throw new IllegalStateException();
        for (int i = 0; i < getCapacity(); i++) {
            if (arr[i]==null) continue;
            else return arr[i];
        } throw new IllegalStateException();
    }


    @Override
    public String toString() {
        ArrayList<String> printer = new ArrayList<>();
        for (int i = 0; i < getCapacity(); i++) {
            if (arr[i]==null) continue;
            else printer.add(arr[i]);
        }
        return printer.toString();
        //return Arrays.toString(arr);
    }

    /**
     * Returns the last element in this list.
     *
     * @return the last element in this list
     * @throws IllegalStateException if this list is empty.
     */
    @Override
    public String getLast() throws IllegalStateException {
        compress();
        if (isEmpty()) throw new IllegalStateException();
        for (int i = getCapacity()-1; i >=0; i--){
            if (arr[i]==null) continue;
            else return arr[i];
        } throw new IllegalStateException();
    }

    /**
     * Returns true if this list is empty, returns false otherwise.
     *
     * @return true if this list is empty, returns false otherwise
     */
    @Override
    public boolean isEmpty() {
        return size()==0;
    }

    /**
     * Returns the index of the last occurrence of the specified element,
     * -1 if the element is not in this list not found.
     *
     * @param str element being searched for
     * @return index of the last occurrence of the specified element, returns
     * -1 if the element is not in this list
     */
    @Override
    public int lastIndexOf(String str) {
        compress();
        for (int i = getCapacity()-1; i >= 0; i--) {
            if (arr[i].equals(str)) return i;
        } return -1;
    }

    /**
     * Removes and returns the first occurrence of the specified element.
     * Returns null if the element is not in this list.
     *
     * @param str element to be removed from this list
     * @return the element that was removed or null if list is empty
     */
    @Override
    public String remove(String str) {
        return arr[firstIndexOf(str)];
    }

    /**
     * Removes and returns the element at the specified index position
     * in the list.
     *
     * @param i index of element to be removed and returned
     * @return element stored at the given index position
     * @throws IndexOutOfBoundsException if i &lt; 0 or i &ge; size()
     */
    @Override
    public String remove(int i) throws IndexOutOfBoundsException {
        if (i < 0 || i > getCapacity()-1) throw new IndexOutOfBoundsException();
        compress();
        String s = arr[i];
        arr[i] = null;
        size--;
        compress();
        return s;
    }

    /**
     * Removes and returns the first element in this list.
     *
     * @return first element in this list
     * @throws IllegalStateException if this list is empty.
     */
    @Override
    public String removeFirst() throws IllegalStateException {
        if (isEmpty()) throw new IllegalStateException();
        return remove(0);
    }

    /**
     * Removes and returns the last element in this list.
     *
     * @return last element in this list
     * @throws IllegalStateException if this list is empty.
     */
    @Override
    public String removeLast() throws IllegalStateException {
        if (isEmpty()) throw new IllegalStateException();
        compress();
        return remove(getCapacity()-1);
    }

    /**
     * Replaces the element at the given index position with the given element
     * and returns the old element.
     *
     * @param i   index of the element to be replaced
     * @param str new element that will be stored at the given index position
     * @return element that was previously stored at the given index position
     * @throws IndexOutOfBoundsException if i &lt; 0 or i &ge; size()
     */
    @Override
    public String set(int i, String str) throws IndexOutOfBoundsException {
        compress();
        if (i < 0 || i > getCapacity()-1) throw new IndexOutOfBoundsException();
        String s = arr[i];
        arr[i] = str;
        return s;
    }

    /**
     * Replaces the first element with the given element and returns the old
     * element.
     *
     * @param str new element that will be stored as the first list element
     * @return element that was previously stored as the first list element
     * @throws IllegalStateException if list is empty.
     */
    @Override
    public String setFirst(String str) throws IllegalStateException {
        if (isEmpty()) throw new IllegalStateException();
        return set(0, str);
    }

    /**
     * Replaces the last element with the given element and returns the old
     * element.
     *
     * @param str new element that will be stored as the last list element
     * @return element that was previously stored as the last list element
     * @throws IllegalStateException if list is empty.
     */
    @Override
    public String setLast(String str) throws IllegalStateException {
        if (isEmpty()) throw new IllegalStateException();
        compress();
        return set(getCapacity()-1, str);
    }

    /**
     * Returns the number of elements in this list.
     *
     * @return number of elements in this list
     */
    @Override
    public int size() {
        return size;
    }
}
