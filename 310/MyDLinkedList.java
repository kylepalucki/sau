
public class MyDLinkedList<E> extends MyAbstractList<E>{
	
	protected DNode<E> head;
	protected DNode<E> tail;
	
	public MyDLinkedList() {
		head = null;
		tail = null;
		size = 0;
	}
	
	public MyDLinkedList(E[] eArr) {
		size = eArr.length;
		switch (size) {
	        case 0:
	            head = null;
	            tail = null;
	            break;
	        case 1:
	        	head = new DNode<>(eArr[0]);
	        	tail = new DNode<>(eArr[0]);
	        	break;
	        case 2:
	        	head = new DNode<>(eArr[0]);
	        	tail = new DNode<>(eArr[1]);
	        	head.next = tail;
	        	tail.prev = head;
	        	break;
	        default:
	        	head = new DNode<>(eArr[0]);
	        	head.next = new DNode<>(eArr[1]);
	        	tail = new DNode<>(eArr[size-1]);
	        	tail.prev = new DNode<>(eArr[size-2]);
	        	
	        	DNode<E> h = head.next;
	        	DNode<E> t = tail;
	        	int c=0;
	        	
	        	for (int i = 2; i < size; i++) {
	        		h.next = new DNode<>(eArr[i]);
	        		h=h.next;
	        	}
	        	//t.prev = h;
	        	for (int i = size-2; i > 0; i--) {
	        		t.prev = new DNode<>(eArr[i]);
	        		t=t.prev;
	        	}
	        	break;
	        
	    }
	}

	@Override
	public void add(int i, E e) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int firstIndexOf(E e) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public E get(int i) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int lastIndexOf(E e) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public E remove(int i) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E set(int i, E e) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public void add(E e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addFirst(E e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addLast(E e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean contains(E e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public E getFirst() throws IllegalStateException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E getLast() throws IllegalStateException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public E removeFirst() throws IllegalStateException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E removeLast() throws IllegalStateException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E setFirst(E e) throws IllegalStateException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E setLast(E e) throws IllegalStateException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toString() {
		String s = "";
        DNode<E> node = head;
        s += "[";
        switch (size) {
            case 0:
                s+="";
                break;
            case 1:
                s+=head.e;
                break;
            default:
                while(node.next!=null) {
                    s += node.e.toString() + ", ";
                    node = node.next;
                }     break;
        }
        if (size>1) s += tail.e;
        s+= "]";
        return s;
	}
	
	

}
