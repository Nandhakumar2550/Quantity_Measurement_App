package org.example;

public class QuantityMeasurementApp {

    // DEMONSTRATE SUBTRACTION

    public static <U extends IMeasurable>
    void demonstrateSubtraction(
            Quantity<U> q1,
            Quantity<U> q2,
            U targetUnit) {

        System.out.println(
                q1 + " - " +
                        q2 + " = " +
                        q1.subtract(
                                q2,
                                targetUnit));
    }

    // DEMONSTRATE DIVISION

    public static <U extends IMeasurable>
    void demonstrateDivision(
            Quantity<U> q1,
            Quantity<U> q2) {

        System.out.println(
                q1 + " / " +
                        q2 + " = " +
                        q1.divide(q2));
    }

    // MAIN METHOD

    public static void main(String[] args) {

        // LENGTH SUBTRACTION

        Quantity<LengthUnit> feet =
                new Quantity<>(
                        10.0,
                        LengthUnit.FEET);

        Quantity<LengthUnit> inches =
                new Quantity<>(
                        6.0,
                        LengthUnit.INCHES);

        demonstrateSubtraction(
                feet,
                inches,
                LengthUnit.FEET);

        demonstrateDivision(
                new Quantity<>(
                        24.0,
                        LengthUnit.INCHES),

                new Quantity<>(
                        2.0,
                        LengthUnit.FEET));

        // WEIGHT SUBTRACTION

        Quantity<WeightUnit> kilogram =
                new Quantity<>(
                        10.0,
                        WeightUnit.KILOGRAM);

        Quantity<WeightUnit> gram =
                new Quantity<>(
                        5000.0,
                        WeightUnit.GRAM);

        demonstrateSubtraction(
                kilogram,
                gram,
                WeightUnit.KILOGRAM);

        demonstrateDivision(
                kilogram,
                new Quantity<>(
                        5.0,
                        WeightUnit.KILOGRAM));

        // VOLUME SUBTRACTION

        Quantity<VolumeUnit> litre =
                new Quantity<>(
                        5.0,
                        VolumeUnit.LITRE);

        Quantity<VolumeUnit> millilitre =
                new Quantity<>(
                        500.0,
                        VolumeUnit.MILLILITRE);

        demonstrateSubtraction(
                litre,
                millilitre,
                VolumeUnit.LITRE);

        demonstrateDivision(
                litre,
                new Quantity<>(
                        10.0,
                        VolumeUnit.LITRE));
    }
}