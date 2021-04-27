
import java.util.Comparator;

/**
 *
 * @author Dr. Lillis
 */
public class ReverseIntegerComparator implements Comparator<Integer> {

    @Override
    public int compare(Integer i1, Integer i2) {
        return -i1.compareTo(i2);
    }

}
