
public class Car {
    
    private double fuelEfficiency;
    private double fuelCapacity;
    private double fuelLevel;
    private int odometer;
    
    public Car(){
        this(20, 35);
    }
    
    public Car(double fuelEfficiency, double fuelCapacity) {
        this.fuelEfficiency = fuelEfficiency;
        this.fuelCapacity = fuelCapacity;
        this.fuelLevel = 0;
        this.odometer = 0;
    }
    
    public double getFuelEfficiency() {
        return this.fuelEfficiency;
    }
    
    public double getFuelCapacity() {
        return this.fuelCapacity;
    }
    
    public double getFuelLevel() {
        return this.fuelLevel;
    }
    
    public int getOdometer() {
        return this.odometer;
    }
    
    public void drive(double miles) {
        if (miles >= 0){
           double totalFuel = (miles/this.getFuelEfficiency());
           if (totalFuel > this.getFuelLevel()) {
               drive(this.getFuelLevel() * this.getFuelEfficiency()); 
           } else {
               this.fuelLevel -= miles / this.getFuelEfficiency();
               this.odometer += miles;
           }
        } 
    }
    
    public void addFuel(double amt) {
        if ((amt + this.getFuelLevel() <= this.getFuelCapacity()) && amt > 0) {
            this.fuelLevel += amt;
        }
    }
    
    public double tripRange() {
        return this.getFuelLevel() * this.getFuelEfficiency();
    }
    
    @Override
    public String toString() {
        return "Fuel Efficiency: " + this.getFuelEfficiency() + " Fuel Capacity: "
                + this.getFuelCapacity() + " Fuel Level: " + this.getFuelLevel() + 
                " Odometer: " + this.getOdometer();
    }
    
}
