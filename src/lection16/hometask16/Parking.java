package lection16.hometask16;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Semaphore;

public class Parking {

    private Semaphore permitToFindOutNumberOfCarsOnTheParking = new Semaphore(1);
    private ArrayBlockingQueue<Car> carsOnTheParking;

    public Parking(int numberOfParkingPlaces) {
        carsOnTheParking =new ArrayBlockingQueue<>(numberOfParkingPlaces);
    }

    public ArrayBlockingQueue<Car> getCarsOnTheParking() {
        return carsOnTheParking;
    }

    public Semaphore getPermitToFindOutNumberOfCarsOnTheParking() {
        return permitToFindOutNumberOfCarsOnTheParking;
    }
}
