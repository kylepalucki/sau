/**
 * @author Dr. Lillis
 */
public interface GenericPQInterface<E> {
    /**
     * Adds the given item to this priority queue.
     * 
     * @param item The item that will be added to this priority queue.
     */
    void add(E item);

    /**
     * Removes and returns the item with the highest priority. If this priority
     * queue is empty, throws a custom exception called EmptyPriorityQueueException.
     * 
     * @return The item with the highest priority.
     * @throws EmptyPriorityQueueException
     */
    E remove();

    /**
     * Returns but does not remove the item with the highest priority. If this
     * priority queue is empty, throws a custom exception called
     * EmptyPriorityQueueException.
     * 
     * @return The item with the highest priority.
     * @throws EmptyPriorityQueueException
     */
    E peek();

    /**
     * Removes all items from this priority queue.
     */
    void clear();

    /**
     * Returns the number of items in this priority queue.
     * 
     * @return the number of items in this priority queue.
     */
    int size();

    /**
     * Returns true if this priority queue contains no items and returns false
     * otherwise.
     * 
     * @return true if this priority queue contains no items, returns false
     *         otherwise.
     */
    boolean isEmpty();

}