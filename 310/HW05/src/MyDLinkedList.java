/*

@author KYLE PALUCKI
*/
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
            for (int i = size-2; i > 0; i--) {
                t.prev = new DNode<>(eArr[i]);
                t=t.prev;
            }
            break;
        }
    }

    @Override
    public void add(int i, E e) throws IndexOutOfBoundsException {
        if (i<0) throw new IndexOutOfBoundsException();
        DNode<E> newLink = new DNode<>(e);
        if (isEmpty()) {
            if (i==0) {
                head = newLink;
                tail = newLink;
                head.next = tail;
                tail.prev = head;
            } else throw new IndexOutOfBoundsException();
        } else if (size==1) {
            switch(i) {
                case 0:
                    head = newLink;
                    head.next = tail;
                    tail.prev = head;
                    break;
                case 1:
                    tail = newLink;
                    head.next = tail;
                    tail.prev = head;
                    break;
                default:
                    throw new IndexOutOfBoundsException();
            }
        } else {
            if (i==0) {
               newLink.next = head;
               head.prev = newLink;
               head = newLink;
            } else if (i==size-1) {
                
                DNode<E> tailPrev = tail.prev;
                tailPrev.next = newLink;
                newLink.prev = tailPrev;
                newLink.next = tail;
                tail.prev = newLink;
                
            } else if (i==size) {
                tail.next = newLink;
                newLink.prev = tail;
                tail = newLink;
                
            }else {
                DNode<E> node = head;
                for (int j = 0; j < i-1;j++) {
                	if (node.next==null) throw new IndexOutOfBoundsException();
                    node = node.next;
                }
                DNode<E> next = node.next;
                newLink.next = next;
                newLink.prev = node;
                next.prev = newLink;
                node.next = newLink;
            }
        }
        size++;
    }

    @Override
    public int firstIndexOf(E e) {
        if (isEmpty()) {
            return -1;
        } else if (size ==1){ 
            return head.e.equals(e) ? 0 : -1;
        } else {
            DNode<E> node = head;
            for (int i = 0; i < size; i++) {
                if (node.e.equals(e)) return i;
                node = node.next;
            }
            return tail.e.equals(e) ? size-1 : -1;
        }
    }

    @Override
    public E get(int i) throws IndexOutOfBoundsException {
        if (i<0||i>size-1) throw new IndexOutOfBoundsException();
        DNode<E> node = head;
        for (int j = 0; j < i; j++){
            node = node.next;
        }
        return node.e;
    }

    @Override
    public int lastIndexOf(E e) {
        if (isEmpty()) {
            return -1;
        } else if (size ==1){ 
            return head.e.equals(e) ? 0 : -1;
        } else {
            DNode<E> node = head;
            int c=-1;
            for (int i = 0; i < size; i++) {
                if (node.e.equals(e)) c=i;
                node = node.next;
            }
            if (tail.e.equals(e)) c=size-1;
            return c;
        }
    }

    @Override
    public E remove(int i) throws IndexOutOfBoundsException {
        DNode<E> node = head;
        if (i<0||i>size-1) throw new IndexOutOfBoundsException();
        if (isEmpty()) throw new IndexOutOfBoundsException();
        else if (size == 1) {
            if (i == 0) {
                clear();
                return node.e;
            } else throw new IndexOutOfBoundsException();
        } else if (size==2) {
            switch (i) {
                case 0:
                    DNode<E> h = head;
                    head = tail;
                    size--;
                    return h.e;
                case 1:
                    DNode<E> t = tail;
                    tail = head;
                    size--;
                    return t.e;
                default:
                    throw new IndexOutOfBoundsException();
                
            }
        }
        
        else {
          if (i == 0) {
              DNode<E> headNext = head.next;
              head = headNext;
              head.prev = null;
              size--;
              return node.e;
          } else if (i==size-1) {
              DNode<E> temp = tail;
              DNode<E> tailPrev = tail.prev;
              tail = tailPrev;
              tail.next = null;
              size--;
              return temp.e;
          } else {
                DNode<E> temp = head;
                for (int j = 0; j < i; j++) {
                    node= node.next;
                }
                temp = node;
                DNode<E> nodePrev = node.prev;
                DNode<E> nodeNext = node.next;
                nodePrev.next = nodeNext;
                nodeNext.prev = nodePrev;
                size--;
                return temp.e;
            }
          
        }
    }

    @Override
    public E set(int i, E e) throws IndexOutOfBoundsException {
        if (i<0||i>size-1) throw new IndexOutOfBoundsException();
        DNode<E> newLink = new DNode<>(e);
        DNode<E> node = head;
        if (isEmpty()) {
           throw new IndexOutOfBoundsException();
        }else if (size==1) {
            if (i==0) {
                DNode<E> temp = head;
                head = newLink;
                tail = newLink;
                head.next = tail;
                tail.prev = head;
                return temp.e;
            } else throw new IndexOutOfBoundsException();
        } else {
            if (i==0) {
                DNode<E> temp = head;
                DNode<E> headNext = head.next;
                head = newLink;
                headNext.prev = head;
                head.next = headNext;
                return temp.e;
            } else if (i==size-1) {
               DNode<E> temp = tail;
               DNode<E> tailPrev = tail.prev;
               tail = newLink;
               tailPrev.next = tail;
               tail.prev = tailPrev;
               return temp.e;
            } else {
                for (int j = 0; j < i; j++) {
                    if (node.next==null) throw new IndexOutOfBoundsException();
                    node = node.next;
                }
                DNode<E> temp = node;
                DNode<E> nodeNext = node.next;
                DNode<E> nodePrev = node.prev;
                newLink.next = nodeNext;
                newLink.prev = nodePrev;
                nodePrev.next = newLink;
                nodeNext.prev = newLink;
                return temp.e;
            }
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(E e) {
        DNode<E> newLink = new DNode<>(e);
        if (isEmpty()) {
            head = newLink;
            tail = newLink;
            head.next = tail;
            tail.prev = head;
        } else if (size==1) {
            tail = newLink;
            tail.prev = head;
            head.next = tail;
        } else {
            tail.next = newLink;
            newLink.prev = tail;
            tail = newLink;
        }
        size++;
    }

    @Override
    public void addFirst(E e) {
    	DNode<E> newLink = new DNode<>(e);
    	if (isEmpty()){
            head = newLink;
            tail = head;    
            
        }else if (size == 1) {
            newLink.next = tail;
            head = newLink;
            tail.prev = head;
        } else {
            head.prev = newLink;
            newLink.next = head;
            head = newLink;
        }
        size++;
    }

    @Override
    public void addLast(E e) {
        DNode<E> newLink = new DNode<>(e);
        if (isEmpty()) {
            head = newLink;
            tail = newLink;
            head.next = tail;
            tail.prev = head;
        } else if (size==1) {
            tail = newLink;
            tail.prev = head;
            head.next = tail;
        } else {
            tail.next = newLink;
            newLink.prev = tail;
            tail = newLink;
        }
        size++;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;

    }

    @Override
    public boolean contains(E e) {
        if (size==0) {
            return false;
        } else {
            DNode<E> node = head;
            for (int i = 0; i < size; i++) {
                if (node.e.equals(e)) return true;
                else node=node.next;
            }
        }
        return false;
    }

    @Override
    public E getFirst() throws IllegalStateException {
    	if (isEmpty()) throw new IllegalStateException();
        return get(0);
    }

    @Override
    public E getLast() throws IllegalStateException {
    	if (isEmpty()) throw new IllegalStateException();
        return get(size-1);
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public E removeFirst() throws IllegalStateException {
    	if (isEmpty()) throw new IllegalStateException();
        return remove(0);
    }

    @Override
    public E removeLast() throws IllegalStateException {
    	if (isEmpty()) throw new IllegalStateException();
        return remove(size-1);
    }

    @Override
    public E setFirst(E e) throws IllegalStateException {
    	if (isEmpty()) throw new IllegalStateException();
        DNode<E> newLink = new DNode<>(e);
        switch (size) {
            case 1:
            {
                DNode<E> node = head;
                head = newLink;
                tail = newLink;
                return node.e;
            }
            case 2:
            {
                DNode<E> node = head;
                head = newLink;
                head.next = tail;
                tail.prev = head;
                return node.e;
            }
            default:
            {
                DNode<E> node = head;
                DNode<E> headNext = head.next;
                headNext.prev = newLink;
                head = newLink;
                head.next = headNext;
                return node.e;
            }
        }
    }

    @Override
    public E setLast(E e) throws IllegalStateException {
        if (isEmpty()) {
            throw new IllegalStateException();
        } 
        DNode<E> newLink = new DNode<>(e);
        switch (size) {
            case 1:
            {
                DNode<E> node = head;
                head = newLink;
                tail = newLink;
                return node.e;
            }
            case 2:
            {
                DNode<E> node = tail;
                tail = newLink;
                head.next = tail;
                tail.prev = head;
                return node.e;
            }
            default:
            {
                DNode<E> tailPrev = tail.prev;
                DNode<E> node = tail;
                tailPrev.next = newLink;
                tail = newLink;
                tail.prev = tailPrev;
                return node.e;
                
            }
        }
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
                s+=node.e;
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