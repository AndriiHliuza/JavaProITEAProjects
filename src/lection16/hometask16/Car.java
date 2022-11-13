package lection16.hometask16;

import java.util.concurrent.TimeUnit;

public class Car extends Thread {
    private int carNumber;

    private Parking parking;

    public Car(int carNumber, Parking parking) {
        this.carNumber = carNumber;
        this.parking = parking;
    }

    @Override
    public void run() {
        parkCar();
        try {
            sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        rideAway();
    }

    public void parkCar() {
        try {
            parking.getPermitToFindOutNumberOfCarsOnTheParking().acquire();
            if (parking.getCarsOnTheParking().offer(this, 1, TimeUnit.MICROSECONDS)) {
                System.out.println("Car " + carNumber + " has parked");
            } else {
                System.out.println("Car " + carNumber + " was waiting to long");
            }
            parking.getPermitToFindOutNumberOfCarsOnTheParking().release();
        } catch (InterruptedException e) {
            System.out.println("Parking exception: " + e.getMessage());
        }
    }

    public void rideAway() {
        parking.getCarsOnTheParking().remove(this);
        System.out.println("Car " + carNumber + " has left the parking");
        parking = null;
    }

    public void rideIntoParking(Parking parking) {
        this.parking = parking;
    }

    @Override
    public String toString() {
        return "Car <" +
                "carNumber: " + carNumber + ">";
    }
}
