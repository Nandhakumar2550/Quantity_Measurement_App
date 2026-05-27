package org.example.measurable;

public interface IMeasurable {

    SupportsArithmetic supportsArithmetic =
            () -> true;

    double getConversionFactor();

    double convertToBaseUnit(
            double value);

    double convertFromBaseUnit(
            double baseValue);

    String getUnitName();

    String getMeasurementType();

    default boolean supportsArithmetic() {

        return supportsArithmetic
                .isSupported();
    }

    default void validateOperationSupport(
            String operation) {

        // DEFAULT
    }
}