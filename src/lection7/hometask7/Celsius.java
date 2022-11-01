package lection7.hometask7;

public class Celsius extends TemperatureUnit {


    /**
     * Converts Celsium to Kelvin, Fahrenheit or Celsius
     * @param temperatureUnit System to convert to. (Kelvin, Fahrenheit or Celsius)
     * @return Converted temperature to Kelvin, Fahrenheit or Celsius
     */
    @Override
    public TemperatureUnit convert(TemperatureUnit temperatureUnit) {
        if (temperatureUnit instanceof Kelvin) {
            temperatureUnit.setDegrees(getDegrees() + 273.15);
        } else if (temperatureUnit instanceof Fahrenheit) {
            temperatureUnit.setDegrees((getDegrees() * 1.8) + 32);
        } else if (temperatureUnit instanceof Celsius) {
            temperatureUnit.setDegrees(getDegrees());
        }
        return temperatureUnit;
    }

}
