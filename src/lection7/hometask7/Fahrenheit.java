package lection7.hometask7;

public class Fahrenheit extends TemperatureUnit {

    /**
     * Converts Fahrenheit to Kelvin, Celsius or Fahrenheit
     * @param temperatureUnit System to convert to. (Kelvin, Fahrenheit or Celsius)
     * @return Converted temperature to Kelvin, Fahrenheit or Celsius
     */
    @Override
    public TemperatureUnit convert(TemperatureUnit temperatureUnit) {
        if (temperatureUnit instanceof Celsius) {
            temperatureUnit.setDegrees((getDegrees() - 32) / 1.8);
        } else if (temperatureUnit instanceof Kelvin) {
            temperatureUnit.setDegrees((getDegrees() + 459.67) * 5 / 9);
        } else if (temperatureUnit instanceof Fahrenheit) {
            temperatureUnit.setDegrees(getDegrees());
        }
        return temperatureUnit;
    }

}
