
public class SimRunner {

    public static void main(String[] args) {
        CarWashSimulator cws = new CarWashSimulator(60,5,0.25);
        //cws.runSimulation(1234);
        cws.runSimulation();
        System.out.println(cws.getLog());

    }
}
