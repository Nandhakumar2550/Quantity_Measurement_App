package org.example.measurable;

import java.util.function.Function;

public enum TemperatureUnit
        implements IMeasurable {

    CELSIUS(

            celsius -> celsius,

            celsius -> celsius
    ),

    FAHRENHEIT(

            fahrenheit ->
                    (fahrenheit - 32)
                            * 5 / 9,

            celsius ->
                    (celsius * 9 / 5)
                            + 32
    ),

    KELVIN(

            kelvin ->
                    kelvin - 273.15,

            celsius ->
                    celsius + 273.15
    );

    private final
    Function<Double, Double>
            toCelsiusConverter;

    private final
    Function<Double, Double>
            fromCelsiusConverter;

    private final
    SupportsArithmetic
            supportsArithmetic =
            () -> false;

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

    @Override
    public double
    getConversionFactor() {

        return 1.0;
    }

    @Override
    public double
    convertToBaseUnit(
            double value) {

        return toCelsiusConverter
                .apply(value);
    }

    @Override
    public double
    convertFromBaseUnit(
            double baseValue) {

        return fromCelsiusConverter
                .apply(baseValue);
    }

    @Override
    public String
    getUnitName() {

        return name();
    }

    @Override
    public String
    getMeasurementType() {

        return "TEMPERATURE";
    }

    @Override
    public boolean
    supportsArithmetic() {

        return supportsArithmetic
                .isSupported();
    }

    @Override
    public void
    validateOperationSupport(
            String operation) {

        throw new
                UnsupportedOperationException(

                "Temperature does not support "
                        + operation);
    }
}