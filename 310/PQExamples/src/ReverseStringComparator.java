
import java.util.Comparator;

/**
 *
 * @author Dr. Lillis
 */
public class ReverseStringComparator implements Comparator<String>{

    @Override
    public int compare(String s1, String s2) {
        return -s1.compareTo(s2);
    }

}
