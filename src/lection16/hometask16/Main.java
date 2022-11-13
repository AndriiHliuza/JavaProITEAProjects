package lection16.hometask16;

public class Main {
    public static void main(String[] args) {
        Parking parking = new Parking(5);
        for (int i = 1; i < 11; i++) {
            Car car = new Car(i, parking);
            car.rideIntoParking(parking);
            car.start();
        }
    }
}
