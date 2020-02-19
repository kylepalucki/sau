
public class Car implements CarInterface {
	private int arrivalTime;
	private int id;
	private int startWashTime;

	public Car(int arrivalTime, int id) {
		this.arrivalTime = arrivalTime;
		this.id = id;
	}
	
	@Override
	public void startWash(int time) {
            startWashTime = time;
		
	}

	@Override
	public int waitTime() {
            return startWashTime-arrivalTime;
	}
	
        @Override
	public String toString() {
		return "Car " + id;
	}

}
