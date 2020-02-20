
public class SimRunner {

    public static void main(String[] args) {
        CarWashSimulator cws = new CarWashSimulator(20,4,0.09);
        cws.runSimulation();
        System.out.println("" + cws.getLog());

    }
}
