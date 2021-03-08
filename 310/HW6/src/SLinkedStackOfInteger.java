import java.util.*;
/**
 * KYLE PALUCKI
 */

public class SLinkedStackOfInteger implements StackOfIntegerInterface {
    private SNode head;
    private int size;

    public SLinkedStackOfInteger() {
        this.head = null;
        this.size = 0;
    }

    /**
     * Adds the given element to the top of the stack.
     *
     * @param e element to be added at to the stack
     */
    @Override
    public void push(Integer e) {
        SNode insert = new SNode(e);
        if (isEmpty()) {
            this.head = insert;
        } else {
            insert.next = head;
            head = insert;
        } size++;
    }

    /**
     * Removes and returns the element on the top of the stack.
     *
     * @return element stored on the top of the stack
     * @throws EmptyStackException if the stack is empty
     */
    @Override
    public Integer pop() throws EmptyStackException {
        if (isEmpty()) throw new EmptyStackException();
        Integer remove = this.head.e;
        this.head = head.next;
        size--;
        return remove;
    }

    /**
     * Returns, but does not remove, the element at the top of the stack.
     *
     * @return element at the top of the stack.
     * @throws EmptyStackException if the stack is empty
     */
    @Override
    public Integer peek() throws EmptyStackException {
        if (isEmpty()) throw new EmptyStackException();
        return this.head.e;
    }

    /**
     * Returns true if this stack is empty, returns false otherwise. This method
     * may not use the size() method or a size variable.
     *
     * @return true if this stack is empty, returns false otherwise
     */
    @Override
    public boolean isEmpty() {
        return size()==0;
    }

    /**
     * Returns the number of elements in this stack.
     *
     * @return the number of elements in this stack.
     */
    @Override
    public int size() {
        return this.size;
    }

    /**
     * Pops all elements off this stack, if any exist.
     */
    @Override
    public void clear() { //I still don't understand the benefits of the way you wrote this method in class
        this.size = 0;    //Wouldn't doing it this way be more efficient because it is a constant complexity?
        this.head = null;
    }

    @Override
    public String toString() {
        SNode node = this.head;
        String s = "";
        for (int i = 0; i < size(); i++) {
            s = node.e + s;
            if (i < size() -1) {
                s = ", " + s;
            }
            node = node.next;
        }
        return "[" + s + "] TOS";
    }
}
