

public abstract class MyAbstractList<E> implements MyList<E> {
    protected int size;
    @Override
    public abstract int size();
    
    public abstract void add(E e);
	public abstract void addFirst(E e);
	
	public abstract void addLast(E e);
	
	public abstract void clear();
	
	public abstract boolean contains(E e);
	
	public abstract E getFirst() throws IllegalStateException;
	
	public abstract E getLast() throws IllegalStateException;
	
	public abstract boolean isEmpty();

	public abstract E removeFirst() throws IllegalStateException;
	
	public abstract E removeLast() throws IllegalStateException;
	
	public abstract E setFirst(E e) throws IllegalStateException;
	
	public abstract E setLast(E e) throws IllegalStateException;
	
	
	@Override
	public abstract String toString();
	
	
}
