
public interface StackInterface<E> {

    /**
     * Return the number of elements in the stack.
     * @return number of elements in the stack. 
     */
    int size();

    /**
     * Return whether the stack is empty.
     * @return true if the stack is empty, false otherwise. 
     */
    boolean isEmpty();

    /**
     * Inspect the element at the top of the stack.
     * @return top element in the stack.  
     * @throws EmptyStackException if the stack is empty. 
     */
    E peek()
            throws EmptyStackException;

    /**
     * Insert an element at the top of the stack.
     * @param element to be inserted.
     */
    void push(E element);

    /**
     * Remove the top element from the stack.
     * @return element removed.
     * @throws EmptyStackException if stack is empty
     */
    E pop()
            throws EmptyStackException;

    /**
     * Pops all items from this stack, if any exist.
     */
    void clear();
}