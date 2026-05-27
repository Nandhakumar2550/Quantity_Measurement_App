package org.example;

public class QuantityMeasurementApp {

    // GENERIC EQUALITY DEMONSTRATION

    public static <U extends IMeasurable>
    void demonstrateEquality(
            Quantity<U> q1,
            Quantity<U> q2) {

        System.out.println(
                q1 + " equals " +
                        q2 + " : " +
                        q1.equals(q2));
    }

    // GENERIC CONVERSION DEMONSTRATION

    public static <U extends IMeasurable>
    void demonstrateConversion(
            Quantity<U> quantity,
            U targetUnit) {

        System.out.println(
                quantity + " -> " +
                        quantity.convertTo(
                                targetUnit));
    }

    // GENERIC ADDITION DEMONSTRATION

    public static <U extends IMeasurable>
    void demonstrateAddition(
            Quantity<U> q1,
            Quantity<U> q2,
            U targetUnit) {

        System.out.println(
                q1 + " + " +
                        q2 + " = " +
                        q1.add(
                                q2,
                                targetUnit));
    }

    // MAIN METHOD

    public static void main(String[] args) {

        // LENGTH

        Quantity<LengthUnit> feet =
                new Quantity<>(
                        1.0,
                        LengthUnit.FEET);

        Quantity<LengthUnit> inches =
                new Quantity<>(
                        12.0,
                        LengthUnit.INCHES);

        demonstrateEquality(
                feet,
                inches);

        demonstrateConversion(
                feet,
                LengthUnit.INCHES);

        demonstrateAddition(
                feet,
                inches,
                LengthUnit.FEET);

        // WEIGHT

        Quantity<WeightUnit> kilogram =
                new Quantity<>(
                        1.0,
                        WeightUnit.KILOGRAM);

        Quantity<WeightUnit> gram =
                new Quantity<>(
                        1000.0,
                        WeightUnit.GRAM);

        demonstrateEquality(
                kilogram,
                gram);

        demonstrateConversion(
                kilogram,
                WeightUnit.GRAM);

        demonstrateAddition(
                kilogram,
                gram,
                WeightUnit.KILOGRAM);

        // VOLUME

        Quantity<VolumeUnit> litre =
                new Quantity<>(
                        1.0,
                        VolumeUnit.LITRE);

        Quantity<VolumeUnit> millilitre =
                new Quantity<>(
                        1000.0,
                        VolumeUnit.MILLILITRE);

        Quantity<VolumeUnit> gallon =
                new Quantity<>(
                        1.0,
                        VolumeUnit.GALLON);

        demonstrateEquality(
                litre,
                millilitre);

        demonstrateConversion(
                litre,
                VolumeUnit.MILLILITRE);

        demonstrateConversion(
                gallon,
                VolumeUnit.LITRE);

        demonstrateAddition(
                litre,
                millilitre,
                VolumeUnit.LITRE);

        demonstrateAddition(
                gallon,
                litre,
                VolumeUnit.GALLON);
    }
}