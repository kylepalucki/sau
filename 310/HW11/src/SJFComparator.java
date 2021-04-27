import java.util.*;
//Kyle Palucki
public class SJFComparator implements Comparator<Job> {
    @Override
    public int compare(Job o1, Job o2) {
        if (o1.length < o2.length) {
            return -1;
        } else return 1;
    }

    public String toString() {
        return "Shortest Job First Scheduling";
    }
}

