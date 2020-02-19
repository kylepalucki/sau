
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public int waitTime() {
		return startWashTime-arrivalTime;
	}
	
	public String toString() {
		return "Car" + id;
	}

}
