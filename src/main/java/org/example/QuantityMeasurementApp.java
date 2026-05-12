package org.example;

public class QuantityMeasurementApp {


    // ENUM FOR LENGTH UNITS

    enum LengthUnit {

        INCHES(1.0),
        FEET(12.0),
        YARDS(36.0),
        CENTIMETERS(0.393701);

        private final double conversionFactor;

        LengthUnit(double conversionFactor) {
            this.conversionFactor = conversionFactor;
        }

        public double getConversionFactor() {
            return conversionFactor;
        }
    }


    // GENERIC QUANTITY LENGTH CLASS

    static class QuantityLength {

        private static final double EPSILON = 0.0001;

        private final double value;
        private final LengthUnit unit;

        // Constructor
        public QuantityLength(double value,
                              LengthUnit unit) {

            if (!Double.isFinite(value))
                throw new IllegalArgumentException(
                        "Invalid numeric value");

            if (unit == null)
                throw new IllegalArgumentException(
                        "Unit cannot be null");

            this.value = value;
            this.unit = unit;
        }

        // Convert to base unit (INCHES)
        private double toBaseUnit() {

            return value *
                    unit.getConversionFactor();
        }


        // STATIC CONVERSION METHOD


        public static double convert(
                double value,
                LengthUnit source,
                LengthUnit target) {

            if (!Double.isFinite(value))
                throw new IllegalArgumentException(
                        "Invalid value");

            if (source == null || target == null)
                throw new IllegalArgumentException(
                        "Unit cannot be null");

            return value *
                    (source.getConversionFactor()
                            / target.getConversionFactor());
        }


        // INSTANCE CONVERSION METHOD

        public QuantityLength convertTo(
                LengthUnit targetUnit) {

            double convertedValue =
                    convert(
                            this.value,
                            this.unit,
                            targetUnit);

            return new QuantityLength(
                    convertedValue,
                    targetUnit);
        }


        // EQUALS METHOD


        @Override
        public boolean equals(Object obj) {

            // Same reference
            if (this == obj)
                return true;

            // Null check
            if (obj == null)
                return false;

            // Type check
            if (getClass() != obj.getClass())
                return false;

            QuantityLength measurement =
                    (QuantityLength) obj;

            // Floating-point comparison
            double difference =
                    Math.abs(
                            this.toBaseUnit() -
                                    measurement.toBaseUnit());

            return difference < EPSILON;
        }


        // TOSTRING METHOD


        @Override
        public String toString() {

            return value + " " + unit;
        }
    }


    // METHOD OVERLOADING

    // Method 1
    public static void demonstrateLengthConversion(
            double value,
            LengthUnit from,
            LengthUnit to) {

        double result =
                QuantityLength.convert(
                        value,
                        from,
                        to);

        System.out.println(
                value + " " + from +
                        " = " +
                        result + " " + to);
    }

    // Method 2
    public static void demonstrateLengthConversion(
            QuantityLength quantity,
            LengthUnit target) {

        QuantityLength converted =
                quantity.convertTo(target);

        System.out.println(
                quantity +
                        " = " +
                        converted);
    }

    // EQUALITY DEMONSTRATION


    public static void demonstrateLengthEquality(
            QuantityLength q1,
            QuantityLength q2) {

        System.out.println(
                q1 + " equals " + q2 +
                        " : " +
                        q1.equals(q2));
    }

    // COMPARISON DEMONSTRATION

    public static void demonstrateLengthComparison(
            double value1,
            LengthUnit unit1,
            double value2,
            LengthUnit unit2) {

        QuantityLength q1 =
                new QuantityLength(
                        value1,
                        unit1);

        QuantityLength q2 =
                new QuantityLength(
                        value2,
                        unit2);

        demonstrateLengthEquality(q1, q2);
    }

    // MAIN METHOD

    public static void main(String[] args) {


        // CONVERSION TESTS


        demonstrateLengthConversion(
                1.0,
                LengthUnit.FEET,
                LengthUnit.INCHES);

        demonstrateLengthConversion(
                3.0,
                LengthUnit.YARDS,
                LengthUnit.FEET);

        demonstrateLengthConversion(
                36.0,
                LengthUnit.INCHES,
                LengthUnit.YARDS);

        demonstrateLengthConversion(
                2.54,
                LengthUnit.CENTIMETERS,
                LengthUnit.INCHES);

        // INSTANCE CONVERSION


        QuantityLength q1 =
                new QuantityLength(
                        36.0,
                        LengthUnit.INCHES);

        demonstrateLengthConversion(
                q1,
                LengthUnit.YARDS);


        // EQUALITY TESTS


        QuantityLength feet =
                new QuantityLength(
                        1.0,
                        LengthUnit.FEET);

        QuantityLength inches =
                new QuantityLength(
                        12.0,
                        LengthUnit.INCHES);

        demonstrateLengthEquality(
                feet,
                inches);

        QuantityLength yard =
                new QuantityLength(
                        1.0,
                        LengthUnit.YARDS);

        QuantityLength feet3 =
                new QuantityLength(
                        3.0,
                        LengthUnit.FEET);

        demonstrateLengthEquality(
                yard,
                feet3);

        QuantityLength cm =
                new QuantityLength(
                        2.54,
                        LengthUnit.CENTIMETERS);

        QuantityLength inch =
                new QuantityLength(
                        1.0,
                        LengthUnit.INCHES);

        demonstrateLengthEquality(
                cm,
                inch);
    }
}