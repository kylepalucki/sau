
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
    
    public void clear() {
        for (int i = 0; i < super.size; i++) {
            this.remove(i);
        }
    }
    
    public E removeLast() {
        int c=0;
        for (int i = size-1; i>=0; i--){
            if (arr[i] != null) c = i;
        }
        E obj = arr[c];
        arr[c] = null;
        return obj;
    }
}
