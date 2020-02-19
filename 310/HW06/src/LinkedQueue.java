
public class LinkedQueue<E> implements QueueInterface<E> {
	SNode<E> front;
	SNode<E> rear;
	int size;
	
	public LinkedQueue() {
		front = null;
		rear = null;
		size = 0;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size==0;
	}

	@Override
	public E front() throws EmptyQueueException {
		if (isEmpty()) throw new EmptyQueueException();
		else return front.e;
	}

	@Override
	public void enqueue(E element) {
		SNode<E> newLink = new SNode<>(element);
		if (isEmpty()) {
			front = newLink;
			rear = newLink;
		} else if (size==1) {
			rear = newLink;
			front.next = rear;
		} else {
			rear.next = newLink;
			rear = newLink;
		}
		size++;
		
	}

	@Override
	public E dequeue() throws EmptyQueueException {
		if (isEmpty()) throw new EmptyQueueException();
		else if (size==1) {
			SNode<E> node = front;
			front = null;
			rear = null;
			size = 0;
			return node.e;
		} else {
			SNode<E> node = rear;
			rear = null;
			size--;
			return node.e;
		}
	}
	
	@Override
    public String toString() {
        String s = "";
        SNode<E> node = front;
        s += "[";
        switch (size) {
            case 0:
                s+="";
                break;
            case 1:
                s+=node.e;
                break;
            default:
                while(node.next!=null) {
                    s += node.e.toString() + ", ";
                    node = node.next;
                }     break;
        }
        if (size>1) s += rear.e;
        s+= "]";
        return s;
    }
	
	

}
