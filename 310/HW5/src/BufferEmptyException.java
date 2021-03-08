/**
 * Thrown when an application attempts to add an object from a full buffer.
 * @author Dr. Lillis
 */
public class BufferEmptyException extends RuntimeException {

    /**
     * Constructs a BufferFullException with the specified detail message.
     * @param s the detail message
     */
    public BufferEmptyException(String s) {
        super(s);
    }

}
