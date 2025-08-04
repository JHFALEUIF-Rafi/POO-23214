package conduccionapp;

public class ConduccionApp {

    public static void main(String[] args) {
        Sport BMW = new Sport();
        Comfort AveoFamily = new Comfort();
        System.out.println("BMW:::" + "Power: " + BMW.getPower() + " " + "Suspension: " + BMW.getSuspensionHeight());
        System.out.println("Chevrolet::::" + "Power: " + AveoFamily.getPower() + " " + "Suspension: " + AveoFamily.getSuspensionHeight());
    }

}
