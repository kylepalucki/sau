import java.util.*;
//Kyle Palucki
public class FCFSComparator implements Comparator<Job> {
    @Override
    public int compare(Job o1, Job o2) {
        if (o1.startTime < o2.startTime) {
            return -1;
        } else return 1;
    }

    public String toString() {
        return "First Come First Served Scheduling";
    }
}

