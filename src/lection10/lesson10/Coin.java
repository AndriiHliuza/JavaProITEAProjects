package lection10.lesson10;

public class Coin {
    private double diameter;
    private double weight;

    public double getDiameter() {
        return diameter;
    }

    public void setDiameter(double diameter) throws CoinLogicException{
        if (diameter <= 0) {
            throw new CoinLogicException("diameter is incorrect");
        }
        this.diameter = diameter;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
