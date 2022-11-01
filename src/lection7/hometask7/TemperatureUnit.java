package lection7.hometask7;

/**
 *  Represents the temperature measurement system
 */
public abstract class TemperatureUnit implements Converter<TemperatureUnit>{

    private double degrees;

    public void setDegrees(double degrees) {
        this.degrees = degrees;
    }

    public double getDegrees() {
        return degrees;
    }

    @Override
    public String toString() {
        return degrees + "";
    }
}
