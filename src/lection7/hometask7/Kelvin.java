package lection7.hometask7;

public class Kelvin extends TemperatureUnit {

    /**
     * Converts Kelvin to Kelvin, Celsius or Fahrenheit
     * @param temperatureUnit System to convert to. (Kelvin, Fahrenheit or Celsius)
     * @return Converted temperature to Kelvin, Fahrenheit or Celsius
     */
    @Override
    public TemperatureUnit convert(TemperatureUnit temperatureUnit) {
        if (temperatureUnit instanceof Celsius) {
            temperatureUnit.setDegrees(getDegrees() - 273.15);
        } else if (temperatureUnit instanceof Fahrenheit) {
            temperatureUnit.setDegrees((getDegrees() - 273.15) * 1.8 + 32);
        } else if (temperatureUnit instanceof Kelvin) {
            temperatureUnit.setDegrees(getDegrees());
        }
        return temperatureUnit;
    }

}
