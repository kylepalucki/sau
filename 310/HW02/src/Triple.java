
/**
 *
 * @author paluck9ui
 */
public class Triple<E1 extends Comparable, E2 extends Comparable, E3 extends Comparable> implements MyTriple<E1, E2, E3> {
    private E1 first;
    private E2 second;
    private E3 third;
    
    public Triple(E1 e1, E2 e2, E3 e3) {
        this.first = e1;
        this.second = e2;
        this.third = e3;
    }
    
    public E1 getFirst() {
        return this.first;
    }
    
    public E2 getSecond() {
        return this.second;
    }
    
    public E3 getThird() {
        return this.third;
    }
    
    public E1 setFirst(E1 e) {
        E1 r = this.first;
        this.first = e;
        return r;
    }
    
    public E2 setSecond(E2 e) {
        E2 r = this.second;
        this.second = e;
        return r;
        
    }
    
    public E3 setThird(E3 e) {
        E3 r = this.third;
        this.third = e;
        return r;
    }
    
    @Override
    public String toString() {
        return "("+this.first+","+this.second+","+this.third+")";
    }

    @Override
    public int compareTo(Object otherObject) {
        if (otherObject == null) {
            return -1;
        }
        if (this.getClass() != otherObject.getClass()) {
            return -1;
        }
        Triple other = (Triple) otherObject;
        if (this.getFirst().compareTo(other.getFirst())==0) {
            if(this.getSecond().compareTo(other.getSecond())==0) {
                return this.getThird().compareTo(other.getThird());
            }
            return this.getSecond().compareTo(other.getSecond());
        }
        return this.getFirst().compareTo(other.getFirst());
    }

}