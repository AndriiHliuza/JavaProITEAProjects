package lection7.lesson7;

public abstract class CarTransportationCosts extends CarCost{
    @Override
    public double countTransportationCosts(String country) {
        if (country.compareTo("Ukraine") == 0) {
            return 3000;
        }
        if (country.compareTo("England") == 0) {
            return 2000;
        }
        return -1.0;
    }
}
