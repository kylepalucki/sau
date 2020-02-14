/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class MySLinkedListOp<E> extends MySLinkedList<E> {
    public MySLinkedListOp() {
        super();
    }
    public MySLinkedListOp(E[] eArr) {
        super(eArr);
    }
    
     @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
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
