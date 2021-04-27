/**
 * @author Kyle Palucki
 */
public class Job {
    String name;
    int length;
    int startTime;
    int finishTime;
    int executionTime;
    int waitTime;

    public Job(String n, int l, int timeSlice) {
        this.name = n;
        this.length = l;
        this.startTime = timeSlice;
        this.executionTime = 0;

    }
    void execute(int timeSlice) {
        if (executionTime ==0) this.executionTime = timeSlice;
        this.executionTime++;
        if (isFinished()) {
            finishTime = timeSlice;
        }
    }

    int remainingTime() {
        return length - executionTime;
    }

    boolean isFinished() {
        return remainingTime()==0;
    }

    void incrementWaitTime(){
        this.waitTime++;
    }

    double responseRatio() {
        return (waitTime+length) / length;
    }

    public String toString() {
        return "[Name:" + name + " Length:" + length
                + " Execution:" + executionTime + " Remaining:" + remainingTime() + " Wait:" + waitTime +"]";
    }


}
