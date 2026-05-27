package org.example;

public interface IMeasurable {

    // DEFAULT LAMBDA

    SupportsArithmetic supportsArithmetic =
            () -> true;

    // ABSTRACT METHODS

    double getConversionFactor();

    double convertToBaseUnit(double value);

    double convertFromBaseUnit(double baseValue);

    String getUnitName();

    // DEFAULT METHODS

    default boolean supportsArithmetic() {

        return supportsArithmetic.isSupported();
    }

    default void validateOperationSupport(
            String operation) {

        // DEFAULT IMPLEMENTATION
    }
}