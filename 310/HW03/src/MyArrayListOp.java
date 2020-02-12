
/**
 *
 * @author kyle
 */
public class MyArrayListOp<E> extends MyArrayList<E> {
    public MyArrayListOp() {
        super();
    }
    
    public MyArrayListOp(E[] eArr) {
        super(eArr);
    }
    
    @Override
    public void clear() {
        for (int i = 0; i < size(); i++){
            arr[i] = null;
        }
        trimToSize();
    }
    
    public E removeLast() {
        E obj = !isEmpty() ? getLast() : null;
        if (!isEmpty()) arr[size-1] = null;
        trimToSize();
        return obj;
    }
}
