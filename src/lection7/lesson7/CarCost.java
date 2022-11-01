package lection7.lesson7;

public abstract class CarCost {
    public double countPrimeCost() {
        return 50000.0;
    }

    public abstract double countTransportationCosts(String country);

    public abstract double countLocaleCost();
}
