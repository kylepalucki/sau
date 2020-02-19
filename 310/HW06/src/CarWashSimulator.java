
import java.util.logging.Level;
import java.util.logging.Logger;


public class CarWashSimulator implements SimulatorInterface{
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
		this.cycleTime = washTime;
		this.arrivalProb = arrivalProb;
	}

	@Override
	public void runSimulation(int seed) {
            generator = new java.util.Random();
            generator.setSeed(seed);
		
	}

	@Override
	public void runSimulation() {
            Q = new LinkedQueue<>();
            carCounter=0;
            log="";
            generator = new java.util.Random();
            simulatedMinute = 1;
            while (simulatedMinute <= duration) {
                log+="Minute " + getSimulatedMinutes();
                int r = generator.nextInt(99)+1;
                if (r<arrivalProb*100) {
                    carCounter++;
                    Car inputCar = new Car(simulatedMinute, carCounter);
                    Q.enqueue(inputCar);
                    log+=", " + inputCar + " arrived";
                    if (carBeingWashed==null) {
                        cycleTime = 0;
                        carBeingWashed = inputCar;
                        log+=", " + inputCar + " being washed";
                        carBeingWashed.startWash(simulatedMinute);       
                        zeroWaitCounter++;
                    }
                }
                if (carBeingWashed!=null) {
                    if (cycleTime>=washTimer) {
                        Car front;
                        try {
                            front = Q.front();
                            Q.dequeue();
                            System.out.println(", Finished washing "+ front);
                        } catch (EmptyQueueException ex) {
                        }
                    }
                }
                log+="\n";
                simulatedMinute++;
            }
            
		
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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getAverageWaitTime() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getCarsWithZeroWait() {
		// TODO Auto-generated method stub
		return zeroWaitCounter;
	}

	@Override
	public String getLog() {
		return log;
	}

}
