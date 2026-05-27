package org.example.measurable;

public enum WeightUnit
        implements IMeasurable {

    GRAM(0.001),

    KILOGRAM(1.0),

    POUND(0.453592),

    OUNCE(0.0283495);

    private final double
            conversionFactor;

    WeightUnit(
            double conversionFactor) {

        this.conversionFactor =
                conversionFactor;
    }

    @Override
    public double
    getConversionFactor() {

        return conversionFactor;
    }

    @Override
    public double
    convertToBaseUnit(
            double value) {

        return value *
                conversionFactor;
    }

    @Override
    public double
    convertFromBaseUnit(
            double baseValue) {

        return baseValue /
                conversionFactor;
    }

    @Override
    public String
    getUnitName() {

        return name();
    }

    @Override
    public String
    getMeasurementType() {

        return "WEIGHT";
    }
}