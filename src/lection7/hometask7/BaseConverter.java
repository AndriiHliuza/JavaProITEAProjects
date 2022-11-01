package lection7.hometask7;

public class BaseConverter implements Converter<Double> {

    private TemperatureUnit baseTemperatureUnit;
    private TemperatureUnit finalTemperatureUnit;

    /**
     * Creates converter to convert from baseTemperatureUnit system to finalTemperatureUnit system
     * @param baseTemperatureUnit Temperature system to convert from
     * @param finalTemperatureUnit Temperature system to convert to
     */
    public BaseConverter(TemperatureUnit baseTemperatureUnit, TemperatureUnit finalTemperatureUnit) {
        this.baseTemperatureUnit = baseTemperatureUnit;
        this.finalTemperatureUnit = finalTemperatureUnit;
    }

    /**
     * Converts degrees from baseTemperature system to finalTemperature system
     * @param degrees degrees in baseTemperature system
     * @return degrees in finalTemperature system
     */
    @Override
    public Double convert(Double degrees) {
        baseTemperatureUnit.setDegrees(degrees);
        return baseTemperatureUnit.convert(finalTemperatureUnit).getDegrees();
    }




    public static void main(String[] args) {
        System.out.println("------Конвертатори з Кельвіна------");
        // Конвертор з Кельвіна в Фаренгейт
        BaseConverter kelvinToFahrenheitConverter = new BaseConverter(new Kelvin(), new Fahrenheit());
        System.out.println(kelvinToFahrenheitConverter.convert(32.0));
        // Конвертор з Кельвіна в Цельсій
        BaseConverter kelvinToCelsiusConverter = new BaseConverter(new Kelvin(), new Celsius());
        System.out.println(kelvinToCelsiusConverter.convert(32.0));

        System.out.println("------Конвертатори з Фаренгейту------");
        // Конвертор з Фаренгейта в Цельсій
        BaseConverter fahrenheitToCelsiusConverter = new BaseConverter(new Fahrenheit(), new Celsius());
        System.out.println(fahrenheitToCelsiusConverter.convert(20.0));
        // Конвертор Фаренгейта в Кельвін
        BaseConverter fahrenheitToKelvinConverter = new BaseConverter(new Fahrenheit(), new Kelvin());
        System.out.println(fahrenheitToKelvinConverter.convert(20.0));

        System.out.println("------Конвертатори з Цельсію------");
        // Конвертор з Цельсія в Фаренгейт
        BaseConverter celsiusToFahrenheitConverter = new BaseConverter(new Celsius(), new Fahrenheit());
        System.out.println(celsiusToFahrenheitConverter.convert(20.0));
        // Конвертор Фаренгейта в Кельвін
        BaseConverter celsiusToKelvinConverter = new BaseConverter(new Celsius(), new Kelvin());
        System.out.println(celsiusToKelvinConverter.convert(20.0));
    }
}
