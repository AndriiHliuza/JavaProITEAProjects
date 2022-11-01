package lection7.lesson7;

public class EnglandPrice extends CarTransportationCosts{

    @Override
    public double countLocaleCost() {
        double enLocaleCosts = 15800.0;

        double price = countPrimeCost() + countTransportationCosts("England") + enLocaleCosts;

        return price;
    }
}
