
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
	
	private CarWashSimulator(int duration, int washTime, double arrivalProb) {
		this.duration = duration;
		this.cycleTime = washTime;
		this.arrivalProb = arrivalProb;
	}

	@Override
	public void runSimulation(int seed) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void runSimulation() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getSimulatedMinutes() {
		return simulatedMinute;
	}

	@Override
	public int getNumberOfCarsWashed() {
		// TODO Auto-generated method stub
		return 0;
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
