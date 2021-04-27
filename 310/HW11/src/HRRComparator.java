import java.util.*;
//Kyle Palucki
public class HRRComparator implements Comparator<Job> {
    @Override
    public int compare(Job o1, Job o2) {
        if (o1.responseRatio() < o2.responseRatio()) {
            return -1;
        } else return 1;
    }

    public String toString() {
        return "Highest Response Ratio Scheduling";
    }
}

