/**
 * @author Kyle Palucki
 * @param <E>
 */

public class SLinkedStack<E> implements StackInterface<E> {
    private int size;
    private SNode<E> head;

    public SLinkedStack() {
        this.size=0;
        this.head = null;
    }

    /**
     * Return the number of elements in the stack.
     *
     * @return number of elements in the stack.
     */
    @Override
    public int size() {
        return this.size;
    }

    /**
     * Return whether the stack is empty.
     *
     * @return true if the stack is empty, false otherwise.
     */
    @Override
    public boolean isEmpty() {
        return size()==0;
    }

    /**
     * Inspect the element at the top of the stack.
     *
     * @return top element in the stack.
     * @throws EmptyStackException if the stack is empty.
     */
    @Override
    public E peek() throws EmptyStackException {
        if (isEmpty()) throw new EmptyStackException();
        return this.head.e;
    }

    /**
     * Insert an element at the top of the stack.
     *
     * @param element to be inserted.
     */
    @Override
    public void push(E element) {
        SNode<E> insert = new SNode<>(element);
        if (isEmpty()) {
            this.head = insert;
        } else {
            insert.next = head;
            head = insert;
        } size++;
    }

    /**
     * Remove the top element from the stack.
     *
     * @return element removed.
     * @throws EmptyStackException if stack is empty
     */
    @Override
    public E pop() throws EmptyStackException {
        if (isEmpty()) throw new EmptyStackException();
        E remove = this.head.e;
        this.head = head.next;
        size--;
        return remove;
    }

    /**
     * Pops all items from this stack, if any exist.
     */
    @Override
    public void clear() {
        this.size=0;
        this.head=null;
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
