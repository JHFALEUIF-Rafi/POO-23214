package carrerasapp;

public class Driver {

    private Car racingCar;

    public Driver(final Car racingCar) {
        this.racingCar = new RacingCar(100);
    }

    public void increaseSpeed() {
        this.racingCar.accelerate();
    }
}
