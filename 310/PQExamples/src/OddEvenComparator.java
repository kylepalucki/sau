
import java.util.Comparator;

/**
 *
 * @author Dr. Lillis
 */
public class OddEvenComparator implements Comparator<Integer> {

    @Override
    public int compare(Integer i1, Integer i2) {
        // i1 is odd and i2 is even, i1 comes first
        if(i1 % 2 == 1 && i2 % 2 == 0){
            return -1;
        }
        
        // i1 is even and i2 is odd, i2 comes first
        if(i1 % 2 == 0 && i2 % 2 == 1){
            return +1;
        }
        
        // Both are odd, or both are even.
        
        // i1 is smaller, i1 comes first
        if(i1 < i2){
            return -1;
        }
        
        // i2 is smaller, i2 comes first
        if(i1 > i2){
            return +1;
        }
        
        // i1 == i2
        return 0;
    }

}
