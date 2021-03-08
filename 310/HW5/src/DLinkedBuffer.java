import java.util.*;
/**
 * @author Kyle Palucki
 * @version 02/21
 */

public class DLinkedBuffer implements CircularBufferInterface {
    public static final int DEFAULT_CAPACITY = 10;

    protected DNode front;
    protected DNode rear;
    int capacity;
    int size;

    public DLinkedBuffer(){
        capacity = DEFAULT_CAPACITY;
        size = 0;
    }

    public DLinkedBuffer(int initCap) {
        capacity = initCap;
        size = 0;
    }
    /**
     * Add element to the rear of the buffer.
     *
     * @param e Element added to the buffer.
     * @throws BufferFullException if buffer is full.
     */
    @Override
    public void add(Integer e) throws BufferFullException {
        if (isFull()) throw new BufferFullException("Buffer full");
        addRear(e);
    }

    /**
     * Add element to the front of the buffer.
     *
     * @param e Element added to the buffer.
     * @throws BufferFullException if buffer is full.
     */
    @Override
    public void addFront(Integer e) throws BufferFullException {
        if (isFull()) throw new BufferFullException("Buffer full");
        DNode insert = new DNode(e);
        if (isEmpty()) {
            this.front =  insert;
            this.rear = insert;
            this.front.next = this.rear;
            this.rear.prev = this.front;
            size++;
        } else if (size == 1) {
            this.rear = insert;
            this.rear.prev = this.front;
            this.front.next = this.rear;
            size++;
        } else {
            this.rear.next = insert;
            insert.prev = this.rear;
            this.rear = insert;
            size++;
        }
    }

    /**
     * Add element to the rear of the buffer.
     *
     * @param e Element added to the buffer.
     * @throws BufferFullException if buffer is full.
     */
    @Override
    public void addRear(Integer e) throws BufferFullException {
        if (isFull()) throw new BufferFullException("Buffer full");
        DNode insert = new DNode(e);
        if (isEmpty()) {
            this.front =  insert;
            this.rear = insert;
            this.front.next = this.rear;
            this.rear.prev = this.front;
            size++;
        } else if (size == 1) {
            this.rear = insert;
            this.rear.prev = this.front;
            this.front.next = this.rear;
            size++;
        } else {
            this.rear.next = insert;
            insert.prev = this.rear;
            this.rear = insert;
            size++;
        }
    }

    /**
     * Remove and return element at the front of the buffer.
     *
     * @return Element at the front of the buffer.
     * @throws BufferEmptyException if buffer is empty.
     */
    @Override
    public Integer remove() throws BufferEmptyException {
        if (isEmpty()) throw new BufferEmptyException("Buffer empty");
        return removeFront();
    }

    /**
     * Remove and return element at the front of the buffer.
     *
     * @return Element at the front of the buffer.
     * @throws BufferEmptyException if buffer is empty.
     */
    @Override
    public Integer removeFront() throws BufferEmptyException {
        if (isEmpty()) throw new BufferEmptyException("Buffer empty");
        if (size() == 1) {
            DNode remove = this.front;
            clear();
            return remove.e;
        } else {
            DNode remove = this.front;
            DNode newFront = this.front.next;
            newFront.prev = null;
            this.front = newFront;
            size--;
            return remove.e;
        }
    }

    /**
     * Remove and return element at the rear of the buffer.
     *
     * @return Element at the rear of the buffer.
     * @throws BufferEmptyException if buffer is empty.
     */
    @Override
    public Integer removeRear() throws BufferEmptyException {
        if (isEmpty()) throw new BufferEmptyException("Buffer empty");
        DNode remove;
        if (size() == 1) {
            remove = this.front;
            clear();
        } else {
            remove = this.rear;
            DNode newRear = this.rear.prev;
            newRear.next = null;
            this.rear = newRear;
            size--;
        }
        return remove.e;
    }

    /**
     * Returns true if this buffer is empty, returns false otherwise.
     *
     * @return true if this buffer is empty, returns false otherwise
     */
    @Override
    public boolean isEmpty() {
        return size==0;
    }

    /**
     * Returns true if this buffer is full, returns false otherwise.
     *
     * @return true if this buffer is full, returns false otherwise
     */
    @Override
    public boolean isFull() {
        return size==capacity;
    }

    /**
     * Returns the capacity of this buffer.
     *
     * @return capacity of this buffer
     */
    @Override
    public int capacity() {
        return this.capacity;
    }

    /**
     * Returns the number of elements in this buffer.
     *
     * @return number of elements in this buffer
     */
    @Override
    public int size() {
        return this.size;
    }

    /**
     * Returns the number of elements that can be added to this buffer before
     * it becomes full.
     *
     * @return the number of element that can be added to this buffer before it
     * becomes full
     */
    @Override
    public int free() {
        return capacity() - size();
    }

    /**
     * Removes all items from this buffer, if any exist.
     */
    @Override
    public void clear() {
        this.front = null;
        this.rear = null;
        size = 0;
    }
    @Override
    public String toString() {
        ArrayList<Integer> printer = new ArrayList<>();
        DNode n = this.front;
        switch (size()) {
            case 0:
                break;
            case 1:
                printer.add(n.e);
                break;
            default:
                while(n.next!=null) {
                    printer.add(n.e);
                    n = n.next;
                }     break;
        }
        String s = "R [";
        for (int i = printer.size()-1; i>=0; i--) {
            s+=printer.get(i);
            if (i>0) s+= ", ";
        }
        s+= "] F";
        return s;


    }
}
