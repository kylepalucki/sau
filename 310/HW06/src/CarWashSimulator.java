/**
 * @author palucki
 */
import java.util.*;

public class CarWashSimulator implements SimulatorInterface {

    private double arrivalProb;
    private double averageWaitTime;
    private Car carBeingWashed;
    private int carCounter;
    private int cycleTime;
    private int duration;
    private java.util.Random generator;
    private java.lang.String log;
    private QueueInterface<Car> Q;
    private int simulatedMinute;
    private java.util.List<Car> washedCars;
    private int washTimer;
    private int zeroWaitCounter;

    public CarWashSimulator(int duration, int washTime, double arrivalProb) {
        this.duration = duration;
        this.washTimer = washTime;
        this.arrivalProb = arrivalProb;
    }

    @Override
    public void runSimulation(int seed) {
        boolean running = false;
        Q = new LinkedQueue<>();
        cycleTime = 0;
        carCounter = 0;
        log = "";
        generator = new java.util.Random();
        generator.setSeed(seed);
        washedCars = new ArrayList<>();
        zeroWaitCounter = 0;
        if (washTimer <= 0 || arrivalProb <= 0 || arrivalProb > 1 || duration <= 0) {
            throw new IllegalArgumentException();
        }
        for (simulatedMinute = 0; simulatedMinute < duration; simulatedMinute++) {
            log += "Minute " + (simulatedMinute + 1);
            if (carArrived()) {
                carCounter++;
                log += ", Car " + carCounter + " arrived";

                Q.enqueue(new Car(simulatedMinute, carCounter));
            }
            if (Q.size() == 1 && !running) {
                try {
                    running = true;
                    zeroWaitCounter++;
                    carBeingWashed = Q.front();
                    carBeingWashed.startWash(simulatedMinute);
                    cycleTime = simulatedMinute;
                    log += ", Started washing " + carBeingWashed;

                } catch (EmptyQueueException ex) {
                    System.out.println(ex);
                }
            } else if (Q.size() >= 1) {
                try {
                    carBeingWashed = Q.front();
                    if (Math.abs(cycleTime - simulatedMinute) >= washTimer) {
                        Car d = Q.dequeue();
                        log += ", Finished washing " + d;
                        washedCars.add(d);
                        if (!Q.isEmpty()) {
                            Car newFront = Q.front();
                            newFront.startWash(simulatedMinute);
                            log += ", Started washing " + newFront;
                            cycleTime = simulatedMinute;
                        } else {
                            running = false;
                        }
                    }
                } catch (EmptyQueueException ex) {
                    System.out.println(ex);
                }
            }
            log += "\n";
        }
        while (running) {
            log += "Minute " + (simulatedMinute + 1);
            try {
                carBeingWashed = Q.front();
                if (Math.abs(cycleTime - simulatedMinute) >= washTimer) {
                    Car d = Q.dequeue();
                    log += ", Finished washing " + d;
                    washedCars.add(d);
                    if (!Q.isEmpty()) {
                        Car newFront = Q.front();
                        newFront.startWash(simulatedMinute);
                        log += ", Started washing " + newFront;
                        cycleTime = simulatedMinute;
                    } else {
                        running = false;
                    }
                }
            } catch (EmptyQueueException ex) {
                System.out.println(ex);
            }
            log += "\n";
            simulatedMinute++;
        }
        summarizeResults();
    }

    @Override
    public void runSimulation() {
        boolean running = false;
        Q = new LinkedQueue<>();
        cycleTime = 0;
        carCounter = 0;
        log = "";
        generator = new java.util.Random();
        washedCars = new ArrayList<>();
        zeroWaitCounter = 0;
        if (washTimer <= 0 || arrivalProb <= 0 || arrivalProb > 1 || duration <= 0) {
            throw new IllegalArgumentException();
        }
        for (simulatedMinute = 0; simulatedMinute < duration; simulatedMinute++) {
            log += "Minute " + (simulatedMinute + 1);
            int r = generator.nextInt(99);
            if (carArrived()) {
                carCounter++;
                log += ", Car " + carCounter + " arrived";
                Q.enqueue(new Car(simulatedMinute, carCounter));
            }
            if (Q.size() == 1 && !running) {
                try {
                    running = true;
                    zeroWaitCounter++;
                    carBeingWashed = Q.front();
                    carBeingWashed.startWash(simulatedMinute);
                    cycleTime = simulatedMinute;
                    log += ", Started washing " + carBeingWashed;

                } catch (EmptyQueueException ex) {
                    System.out.println(ex);
                }
            } else if (Q.size() >= 1) {
                try {
                    carBeingWashed = Q.front();
                    if (Math.abs(cycleTime - simulatedMinute) >= washTimer) {
                        Car d = Q.dequeue();
                        log += ", Finished washing " + d;
                        washedCars.add(d);
                        if (!Q.isEmpty()) {
                            Car newFront = Q.front();
                            newFront.startWash(simulatedMinute);
                            log += ", Started washing " + newFront;
                            cycleTime = simulatedMinute;
                        } else {
                            running = false;
                        }
                    }
                } catch (EmptyQueueException ex) {
                    System.out.println(ex);
                }
            }
            log += "\n";
        }
        while (running) {
            log += "Minute " + (simulatedMinute + 1);
            try {
                carBeingWashed = Q.front();
                if (Math.abs(cycleTime - simulatedMinute) >= washTimer) {
                    Car d = Q.dequeue();
                    log += ", Finished washing " + d;
                    washedCars.add(d);
                    if (!Q.isEmpty()) {
                        Car newFront = Q.front();
                        newFront.startWash(simulatedMinute);
                        log += ", Started washing " + newFront;
                        cycleTime = simulatedMinute;
                    } else {
                        running = false;
                    }
                }
            } catch (EmptyQueueException ex) {
                System.out.println(ex);
            }
            log += "\n";
            simulatedMinute++;
        }
        summarizeResults();

    }
    

    private void summarizeResults() {
        log+="\n";
        log += "===========================================================\n";
        log += "                    SUMMARY\n";
        log += "===========================================================\n";
        log += "Simulated time: " + getSimulatedMinutes() + " minutes\n";
        log += "Cars washed: " + getNumberOfCarsWashed() + "\n";
        log += "Max wait time: " + getMaxWaitTime() + " minutes \n";
        String w = String.format("%.1f", getAverageWaitTime());
        log += "Average wait time: " + w + " minutes \n";
        double pct = getNumberOfCarsWashed() > 0 ? (double) getCarsWithZeroWait() / getNumberOfCarsWashed() * 100 : 0;
        String p = String.format("%.1f", pct);
        log += "Cars with zero wait: " + getCarsWithZeroWait() + " (" + p + "%)\n";
    }
    
    private boolean carArrived() {
        return (generator.nextDouble()<arrivalProb);
    }

    @Override
    public int getSimulatedMinutes() {
        return simulatedMinute;
    }

    @Override
    public int getNumberOfCarsWashed() {
        return washedCars.size();
    }

    @Override
    public int getMaxWaitTime() {
        int max = 0;

        for (Car c : washedCars) {
            if (c.waitTime() > max) {
                max = c.waitTime();
            }
        }
        return max;
    }

    @Override
    public double getAverageWaitTime() {
        double total = 0;
        if (getNumberOfCarsWashed()==0) {
            return 0;
        }
        for (Car c : washedCars) {
            total += c.waitTime();
        }
        averageWaitTime = (double) total / washedCars.size();
        return averageWaitTime;
    }

    @Override
    public int getCarsWithZeroWait() {
        return zeroWaitCounter;
    }

    @Override
    public String getLog() {
        return log;
    }

}
