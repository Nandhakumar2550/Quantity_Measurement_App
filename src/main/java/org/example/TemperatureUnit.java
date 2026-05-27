package org.example;

import java.util.function.Function;

public enum TemperatureUnit
        implements IMeasurable {

    CELSIUS(

            celsius -> celsius,

            celsius -> celsius
    ),

    FAHRENHEIT(

            fahrenheit ->
                    (fahrenheit - 32) * 5 / 9,

            celsius ->
                    (celsius * 9 / 5) + 32
    ),

    KELVIN(

            kelvin ->
                    kelvin - 273.15,

            celsius ->
                    celsius + 273.15
    );

    // FUNCTIONAL INTERFACES

    private final Function<Double, Double>
            toCelsiusConverter;

    private final Function<Double, Double>
            fromCelsiusConverter;

    // LAMBDA FOR ARITHMETIC SUPPORT

    private final SupportsArithmetic
            supportsArithmetic =
            () -> false;

    // CONSTRUCTOR

    TemperatureUnit(

            Function<Double, Double>
                    toCelsiusConverter,

            Function<Double, Double>
                    fromCelsiusConverter) {

        this.toCelsiusConverter =
                toCelsiusConverter;

        this.fromCelsiusConverter =
                fromCelsiusConverter;
    }

    // CONVERSION FACTOR

    @Override
    public double getConversionFactor() {

        return 1.0;
    }

    // CONVERT TO BASE UNIT

    @Override
    public double convertToBaseUnit(
            double value) {

        return toCelsiusConverter
                .apply(value);
    }

    // CONVERT FROM BASE UNIT

    @Override
    public double convertFromBaseUnit(
            double baseValue) {

        return fromCelsiusConverter
                .apply(baseValue);
    }

    // UNIT NAME

    @Override
    public String getUnitName() {

        return name();
    }

    // SUPPORTS ARITHMETIC

    @Override
    public boolean supportsArithmetic() {

        return supportsArithmetic
                .isSupported();
    }

    // VALIDATE OPERATION SUPPORT

    @Override
    public void validateOperationSupport(
            String operation) {

        throw new UnsupportedOperationException(

                "Temperature does not support "
                        + operation +
                        " operation");
    }
}