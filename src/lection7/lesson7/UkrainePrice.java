package lection7.lesson7;

public class UkrainePrice extends CarTransportationCosts{

    @Override
    public double countLocaleCost() {
        double ukLocaleCosts = 15800.0;

        double price = countPrimeCost() + countTransportationCosts("Ukraine") + ukLocaleCosts;

        return price;
    }
}
