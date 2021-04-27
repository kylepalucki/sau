import java.util.*;
import java.io.*;

/**
 * @author Kyle Palucki
 */
public class CPUSimulator {
    private Comparator<Job> comparator;
    private String inFileName;
    private String outFileName;
    private ArrayList<String> commands;
    private ArrayList<Job> finishedJobs;
    private Heap<Job> readyQueue;
    private String out = "";
    private int continuousIdleTime = 0;
    private int totalIdleTime = 0;
    private int totalBusyTime = 0;
    private int timeSlice = 0;
    private final int MAX_IDLE_TIME = 50;

    public CPUSimulator() {
        this.comparator = new SRTComparator();
        this.readyQueue = new Heap(this.comparator);
        this.commands = new ArrayList<>();
        this.finishedJobs = new ArrayList<>();
    }

    public CPUSimulator(Comparator<Job> comparator) {
        this.comparator = comparator;
        this.readyQueue = new Heap(this.comparator);
        this.commands = new ArrayList<>();
        this.finishedJobs = new ArrayList<>();
    }

    public CPUSimulator(String inFileName, Comparator<Job> comparator) {
        this.comparator = comparator;
        this.readyQueue = new Heap(this.comparator);
        this.commands = new ArrayList<>();
        this.finishedJobs = new ArrayList<>();
        this.inFileName = inFileName;
        try {
            File inF = new File(inFileName);
            Scanner input = new Scanner(inF);
            while (input.hasNextLine()) {
                commands.add(input.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public CPUSimulator(String inFileName, String outFileName, Comparator<Job> comparator) {
        this.comparator = comparator;
        this.readyQueue = new Heap(this.comparator);
        this.commands = new ArrayList<>();
        this.finishedJobs = new ArrayList<>();
        this.inFileName = inFileName;
        this.outFileName = outFileName;
        try {
            File inF = new File(inFileName);
            Scanner input = new Scanner(inF);
            while (input.hasNextLine()) {
                commands.add(input.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
    }

    String getNextCommand() {
        if (this.commands.size()==0) {
            return "no new jobs in this slice";
        } else {
            return this.commands.remove(0);
        }
    }

    void start() {
        out += "Starting CPU Simulation with " + this.comparator.toString() +"\n";
        while (continuousIdleTime < this.MAX_IDLE_TIME) {
            timeSlice++;
            out += "Time Slice: " + timeSlice + "\n";
            String command = getNextCommand();
            if (command.equals("no new jobs in this slice")) {
                out+= command + "\n";
            }
            if (!command.equals("no new jobs in this slice")) {
                out += command + "\n";
                String[] arr = command.split(" ", 0);
                String name = arr[2];
                int length = Integer.parseInt(arr[5]);
                Job job = new Job(name, length, timeSlice);
                out += "Adding to queue: " + job.toString()  + "\n";
                readyQueue.add(job);
            }
            if (readyQueue.isEmpty()) {
                continuousIdleTime++;

            } else {
                totalIdleTime += continuousIdleTime;
                continuousIdleTime = 0;
                totalBusyTime++;
                Job next = readyQueue.remove();
                next.execute(this.timeSlice);
                if (next.isFinished()) {
                    out += "Removed from queue: " + next.toString() + "\n";
                    finishedJobs.add(next);
                } else {
                    out += "Adding to queue: " + next.toString() + "\n";
                    next.incrementWaitTime();
                    readyQueue.add(next);
                }
            }
        }
        String summary = "\n";
        summary += "-----Summary-----";
        summary += "CPU Simulator with " + this.comparator.toString() +"\n";
        summary += "Simulation Run Time: " + this.timeSlice + "\n";
        summary += "CPU Idle Time: " + this.totalIdleTime + "\n";
        summary += "CPU Busy Time: " + this.totalBusyTime + "\n";
        summary += "CPU Utilization: " + this.totalIdleTime/this.totalBusyTime + "% \n";
        summary += "Average Wait Time: " + this.timeSlice/this.totalBusyTime + "\n";
        summary += "List of Jobs in Order of Completion\n";
        for (Job j : finishedJobs) {
            summary += "Job " + j.name + "\n";
            summary += "Start Time: " + j.startTime + "\n";
            summary += "Finish Time: " + j.finishTime + "\n";
            summary += "Execution Time: " + j.executionTime + "\n";
            summary += "Wait Time: " + j.waitTime + "\n";
            summary += "Response Ratio: " + j.responseRatio() + "\n";
            summary += "\n";
        }
        out += summary;
        if (this.outFileName != null) {
            try {
                FileWriter writer = new FileWriter(outFileName);
                writer.write(out);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println(out);
        }
    }
}