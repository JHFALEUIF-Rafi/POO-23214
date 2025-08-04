package carrerasapp;

public class CarrerasApp {

    public static void main(String[] args) {
        RacingCar ae=new RacingCar(23);
        Driver daniel=new Driver(ae);
        
        daniel.increaseSpeed();
    }
    
}
