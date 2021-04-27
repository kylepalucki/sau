public class EmptyHeapException extends RuntimeException {
    public EmptyHeapException() {
        super("Heap is empty");
    }
}
