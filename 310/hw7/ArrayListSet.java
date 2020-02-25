package hw7;
import java.util.ArrayList ;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Dr. Lillis
 */
public class ArrayListSet<E> implements SetI<E>, Cloneable {

    private ArrayList<E> list;
    // Four Constructors
    
    /**
     * Constructs an empty set.
     */
    public ArrayListSet(){
        this.list = new ArrayList<>();
    }
    
    /**
     * Constructs a set which contains a single element.
     * @param e The element to be added to this new set.
     */
    public ArrayListSet(E e){
        this.list = new ArrayList<>();
        this.list.add(e);
    }
    
    /**
     * Constructs a set which contains all elements in the provided list.
     * @param list Contains all elements that are to be added to this new set.
     */
    public ArrayListSet(List<E> list){
        for (E e : list) if (!this.list.contains(e)) list.add(e);
    }
    
    /**
     * Constructs a set which contains all elements in the provided array.
     * @param array Contains all elements that are to be added to this new set.
     */
    public ArrayListSet(E[] array){
    	for (E e : array) if (!this.list.contains(e)) list.add(e);
    }
    
    @Override
    public void add(E e) {
        for (E element : this.list) {
        	if (this.list.contains(element)) return;
        } this.list.add(e);
    }

    @Override
    public int card() {
        return this.list.size();
    }

    @Override
    public void clear() {
        this.list.clear();
    }

    @Override
    public boolean contains(E e) {
        return list.contains(e);
    }

    @Override
    public SetI<E> difference(SetI<E> other) {
        SetI<E> diff = new ArrayListSet<E>();
        for (E element : this.list) {
        	if (this.list.contains(element) && !other.contains(element)) diff.add(element);
        }
        return diff;
    }

    @Override
    public void discard(E e) {
        if (this.list.contains(e)) this.list.remove(e);
    }

    @Override
    public SetI<E> intersection(SetI<E> other) {
    	SetI<E> inter = new ArrayListSet<E>();
        for (E element : this.list) {
        	if (this.list.contains(element) && other.contains(element)) inter.add(element);
        }
        return inter;
    }

    @Override
    public boolean isDisjoint(SetI<E> other) {
        int c=0;
        for (E element : this.list) {
        	c = this.list.contains(element)&&other.contains(element)?c+1:c;
        }
        return c!=0;
    }
    
    @Override
    public boolean isProperSubset(SetI<E> other) {
        boolean containsAll=false;
        int c = 0;
        for (E element : this.list) {
        	c = this.list.contains(element)&&other.contains(element)?c+1:c;
        }
        containsAll = c==this.card();
        return containsAll&&other.card()>this.card();
    }

    @Override
    public boolean isProperSuperset(SetI<E> other) {
        boolean containsAll = false;
        int c = 0;
        for (E element : this.list) {
        	c = this.list.contains(element)&&other.contains(element)?c+1:c;
        }
        containsAll = c==other.card();
        return containsAll&&other.card()<this.card();
    }

    @Override
    public boolean isSubset(SetI<E> other) {
    	boolean containsAll=false;
        int c = 0;
        for (E element : this.list) {
        	c = this.list.contains(element)&&other.contains(element)?c+1:c;
        }
        containsAll = c==this.card();
        return containsAll;
    }

    @Override
    public boolean isSuperset(SetI<E> other) {
    	boolean containsAll = false;
        int c = 0;
        for (E element : this.list) {
        	c = this.list.contains(element)&&other.contains(element)?c+1:c;
        }
        containsAll = c==other.card();
        return containsAll;
    }

    @Override
    public E pop() {
    	E element = null;
    	if (!isEmpty() ) {
    		element = this.list.get(0);
    		this.list.remove(0);
    		
    	}
    	return element;
    }

    
    @Override
    public SetI<SetI<E>> powerSet() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    

    
    @Override
    public SetI<E> symmetricDifference(SetI<E> other) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public E[] toArray(E[] arr) {
        return list.toArray(arr);
    }

    
    @Override
    public SetI<E> union(SetI<E> other) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @Override
    public boolean equals(Object otherObject) {
        if (otherObject == null){
            return false;
        }
        
        if(this.getClass() != otherObject.getClass()){
            return false;
        }
        
        SetI otherSet = (SetI) otherObject;
        
        return this.isSubset(otherSet) && otherSet.isSubset(this);
    }    
    
    
    @Override
    public String toString(){
        String s = list.toString();
        s = "{" + s.substring(1,s.length()-1) + "}";
        return s;
    }
    
    @Override
    public List<E> toList(){
        return (ArrayList<E>)list.clone();
    }

    @Override
    public Object clone() {
        try {
            SetI<E> cloned = (SetI<E>) super.clone(); // makes shallow copy

            // Deep copy
            this.list = (ArrayList<E>) list.clone();
            return cloned;
        } catch (CloneNotSupportedException e){
            // We'll never get here because we implement Cloneable
            return null;
        }
    }    
    
    @Override
    public boolean isEmpty(){
        return this.card() == 0;
    }
    
    @Override
    public SetI<E> factory(E [] array){
        ArrayListSet<E> set = new ArrayListSet<>(array);
        return set;
    }

}