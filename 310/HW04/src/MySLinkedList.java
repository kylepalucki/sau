/*
@author Kyle Palucki
*/
public class MySLinkedList<E> extends MyAbstractList<E>{
    protected SNode<E> head;
    protected SNode<E> tail;

    public MySLinkedList() {
        head = null;
        tail = null;
        super.size = 0;
    }
    
    public MySLinkedList(E[] eArr) {
        super.size = eArr.length;
        switch (size) {
            case 0:
                head = null;
                tail = null;
                break;
            case 1:
                head = new SNode<>(eArr[0]);
                break;
            case 2:
                head = new SNode<>(eArr[0]);
                tail = new SNode<>(eArr[1]);
                head.next = tail;
                break;
            default:
                head = new SNode<>(eArr[0]);
                head.next = new SNode<>(eArr[1]);
                SNode<E> node = head.next;
                for (int i = 2; i < size; i++) { 
                    node.next = new SNode<>(eArr[i]);
                }   tail = new SNode<>(eArr[size-1]);
                break;
        }
    }
    @Override
    public void add(E e) {
        SNode<E> newLink = new SNode<>(e);
        if (isEmpty()){
            head = newLink;
            tail = head;    
        }
        else if (size == 1) {
            tail = newLink;
            head.next = tail;
        }else {
            SNode<E> node = head;
            while(node.next != null) {
                node = node.next;
            }
            tail = newLink;
            node.next = tail;  
        }
        size++;
    }
    
    @Override
    public int size() {
        return size;
    }

    @Override
    public void addFirst(E e) {
        SNode<E> newLink = new SNode<>(e);
        if (isEmpty()){
            head = newLink;
            tail = head;    
        }else if (size == 1) {
            head = newLink;
            head.next = tail;
        } else {
            newLink.next = head;
            head = newLink;
        }
        size++;
        
    }

    @Override
    public void addLast(E e) {
        SNode<E> newLink = new SNode<>(e);
        if (isEmpty()){
            head = newLink;
            tail = head;    
        }
        else if (size == 1) {
            tail = newLink;
            head.next = tail;
        }else {
            SNode<E> node = head;
            while(node.next != null) {
                node = node.next;
            }
            tail = newLink;
            node.next = tail;  
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
            SNode<E> node = head;
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
        return head.e;
    }

    @Override
    public E getLast() throws IllegalStateException {
        if (isEmpty()) throw new IllegalStateException();
        return tail.e;
    }

    @Override
    public E removeFirst() throws IllegalStateException {
        SNode<E> temp = head;
        if (isEmpty()) {
            throw new IllegalStateException();
        }
        else if (size==1){
            clear();
        } else {
            head = head.next;
            size--;
        }
        return temp.e;
    }

    @Override
    public E removeLast() throws IllegalStateException {
        SNode<E> temp = tail;
        SNode<E> node = head;
        if (isEmpty()){
            throw new IllegalStateException();
        } else if (size==1) {
            clear();
        } else {
            for (int i = 0; i < size-2; i++) {
                node=node.next;
            }
             node.next = null;
            tail = node;
            size--;
        }
        return temp.e;  
    }
    
    
    @Override
    public E remove(int i) throws IndexOutOfBoundsException {
        SNode<E> temp = head;
        if (i < 0) {
            throw new IndexOutOfBoundsException();
        } else if (i > size-1) {
            throw new IndexOutOfBoundsException();
        }
        if (isEmpty()) {
            throw new IndexOutOfBoundsException();
        } else if (size==1) {
            if (i==0){
                clear();
                return temp.e;
            }
            else throw new IndexOutOfBoundsException();
        } else {
            if (i == 0) return removeFirst();
            else if (i==size-1) return removeLast();
            else {
                SNode<E> rem = temp;
                for (int j = 0; j < i-1; j++) {
                    temp = temp.next;
                }
                rem = temp.next;
                temp.next = temp.next.next;
                size--;
                return rem.e;
            }
        }
    }

    @Override
    public E setFirst(E e) throws IllegalStateException {
        if (isEmpty()) throw new IllegalStateException();
        SNode<E> temp = head;
        SNode<E> newLink = new SNode<>(e);
        if (size==1) {
            head = newLink;
            tail = head;
            head.next = tail;
        } else {
            head = newLink;
            head.next = temp.next;
        }
        return temp.e;
    }

    @Override
    public E setLast(E e) throws IllegalStateException {
       SNode<E> newLink = new SNode<>(e);
       SNode<E> temp = tail;
       SNode<E> node = head;
       if (isEmpty()) throw new IllegalStateException();
       
       else if (size==1) {
           tail = newLink;
           head.next = tail;
           head = tail;
       }else {
            for (int i = 0; i < size-1; i++) {
                node = node.next;
            }
            node.next = newLink;
            tail = newLink;
       }
       return temp.e;
    }

    @Override
    public void add(int i, E e) throws IndexOutOfBoundsException {
        if (i<0||(i>size-1&&size>0)) throw new IndexOutOfBoundsException();
        SNode<E> newLink = new SNode<>(e);
        if (isEmpty()) {
            if(i==0) addFirst(e);
            else throw new IndexOutOfBoundsException();
            
        } else if (size == 1) {
            switch (i) {
                case 0:
                    head = newLink;
                    head.next = tail;
                    break;
                case 1:
                    tail = newLink;
                    head.next = tail;
                    break;
                default:
                    throw new IndexOutOfBoundsException();
            }
        } else {
            if (i==0) {
                addFirst(e);
            }else if (i==size-1){
                addLast(e);
            }else {
                SNode<E> node = head;
                for (int j = 0; j < i-1; j++) {
                    node = node.next;
                }
                newLink.next = node.next;
                node.next = newLink;
            }
        }
        size++;   
    }

    @Override
    public boolean isEmpty() {
        return size ==0;
    }

    @Override
    public int firstIndexOf(E e) {
        if (isEmpty()) {
            return -1;
        } else if (size ==1){ 
            return head.e.equals(e) ? 0 : -1;
        } else {
            SNode<E> node = head;
            for (int i = 0; i < size; i++) {
                if (node.e.equals(e)) return i;
                node = node.next;
            }
            return tail.e.equals(e) ? size-1 : -1;
        }
        //return -1;
    }
    
    @Override
    public int lastIndexOf(E e) {
        if (isEmpty()) {
            return -1;
        } else if (size ==1){ 
            return head.e.equals(e) ? 0 : -1;
        } else {
            SNode<E> node = head;
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
    public E get(int i) throws IndexOutOfBoundsException {
        if (i<0||i>size-1) throw new IndexOutOfBoundsException();
        SNode<E> node = head;
        for (int j = 0; j < i; j++){
            node = node.next;
        }
        return node.e;
    }

    @Override
    public E set(int i, E e) throws IndexOutOfBoundsException {
        if (i<0||i>size-1) throw new IndexOutOfBoundsException();
        SNode<E> newLink = new SNode<>(e);
        SNode<E> node = head;
        for (int j = 0; j < i-1; j++) {
            if (node.next==null) throw new IndexOutOfBoundsException();
            node = node.next;
        }
        SNode<E> temp = node.next;
        newLink.next = temp.next;
        node.next = newLink;
        newLink = temp;
        return temp.e;
        
    }

     
    @Override
    public String toString() {
        String s = "";
        SNode<E> node = head;
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
