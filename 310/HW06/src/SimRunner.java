
public class SimRunner {

    public static void main(String[] args) {
        CarWashSimulator cws = new CarWashSimulator(20,4,0.09);
        cws.runSimulation(1234);
        System.out.println("" + cws.getLog());

    }
}
