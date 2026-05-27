package org.example;

public class QuantityMeasurementApp {

    public static void main(String[] args) {

        // TEMPERATURE EQUALITY

        Quantity<TemperatureUnit> celsius =
                new Quantity<>(
                        0.0,
                        TemperatureUnit.CELSIUS);

        Quantity<TemperatureUnit> fahrenheit =
                new Quantity<>(
                        32.0,
                        TemperatureUnit.FAHRENHEIT);

        System.out.println(
                celsius.equals(
                        fahrenheit));

        // TEMPERATURE CONVERSION

        Quantity<TemperatureUnit> boiling =
                new Quantity<>(
                        100.0,
                        TemperatureUnit.CELSIUS);

        System.out.println(
                boiling.convertTo(
                        TemperatureUnit.FAHRENHEIT));

        // UNSUPPORTED OPERATION

        try {

            Quantity<TemperatureUnit> t1 =
                    new Quantity<>(
                            100.0,
                            TemperatureUnit.CELSIUS);

            Quantity<TemperatureUnit> t2 =
                    new Quantity<>(
                            50.0,
                            TemperatureUnit.CELSIUS);

            System.out.println(
                    t1.add(t2));

        } catch (
                UnsupportedOperationException e) {

            System.out.println(
                    e.getMessage());
        }
    }
}