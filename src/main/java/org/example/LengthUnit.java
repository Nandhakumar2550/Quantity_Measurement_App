package org.example;

// STANDALONE ENUM CLASS

public enum LengthUnit {

    FEET(1.0),
    INCHES(1.0 / 12.0),
    YARDS(3.0),
    CENTIMETERS(1.0 / 30.48);

    // CONVERSION FACTOR

    private final double conversionFactor;

    // ENUM CONSTRUCTOR

    LengthUnit(double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    // GETTER METHOD

    public double getConversionFactor() {
        return conversionFactor;
    }

    // CONVERT TO BASE UNIT (FEET)

    public double convertToBaseUnit(double value) {

        return value * conversionFactor;
    }

    // CONVERT FROM BASE UNIT (FEET)

    public double convertFromBaseUnit(double baseValue) {

        return baseValue / conversionFactor;
    }
}