import java.util.*;
//Kyle Palucki
public class SRTComparator implements Comparator<Job> {
    @Override
    public int compare(Job o1, Job o2) {
        if (o1.remainingTime() < o2.remainingTime()) {
            return -1;
        } else return 1;
    }

    public String toString() {
        return "Shortest Remaining Time Scheduling";
    }
}

