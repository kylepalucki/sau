
/**
 * Runtime exception thrown when the remove operation is attempted on
 * an empty Priority Queue.
 * @author Dr. Lillis
 */
public class EmptyPriorityQueueException extends RuntimeException {

    public EmptyPriorityQueueException(String e) {
        super(e);
    }
}
