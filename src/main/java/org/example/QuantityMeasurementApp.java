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


    // QUANTITY LENGTH CLASS


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

        // Getter Methods
        public double getValue() {
            return value;
        }

        public LengthUnit getUnit() {
            return unit;
        }


        // CONVERT TO BASE UNIT (INCHES)


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


        // ADDITION METHOD


        public QuantityLength add(
                QuantityLength other) {

            if (other == null)
                throw new IllegalArgumentException(
                        "Second operand cannot be null");

            // Convert both to base unit
            double firstBase =
                    this.toBaseUnit();

            double secondBase =
                    other.toBaseUnit();

            // Add base values
            double sumBase =
                    firstBase + secondBase;

            // Convert result back to unit
            double resultValue =
                    sumBase /
                            this.unit.getConversionFactor();

            return new QuantityLength(
                    resultValue,
                    this.unit);
        }


        // STATIC ADD METHOD

        public static QuantityLength add(
                QuantityLength first,
                QuantityLength second,
                LengthUnit targetUnit) {

            if (first == null || second == null)
                throw new IllegalArgumentException(
                        "Operands cannot be null");

            if (targetUnit == null)
                throw new IllegalArgumentException(
                        "Target unit cannot be null");

            // Convert to base unit
            double firstBase =
                    first.toBaseUnit();

            double secondBase =
                    second.toBaseUnit();

            // Add values
            double sumBase =
                    firstBase + secondBase;

            // Convert to target unit
            double resultValue =
                    sumBase /
                            targetUnit.getConversionFactor();

            return new QuantityLength(
                    resultValue,
                    targetUnit);
        }


        // OVERLOADED ADD METHOD


        public static QuantityLength add(
                double value1,
                LengthUnit unit1,
                double value2,
                LengthUnit unit2,
                LengthUnit targetUnit) {

            QuantityLength q1 =
                    new QuantityLength(
                            value1,
                            unit1);

            QuantityLength q2 =
                    new QuantityLength(
                            value2,
                            unit2);

            return add(
                    q1,
                    q2,
                    targetUnit);
        }


        // EQUALS METHOD


        @Override
        public boolean equals(Object obj) {

            if (this == obj)
                return true;

            if (obj == null)
                return false;

            if (getClass() != obj.getClass())
                return false;

            QuantityLength measurement =
                    (QuantityLength) obj;

            double difference =
                    Math.abs(
                            this.toBaseUnit() -
                                    measurement.toBaseUnit());

            return difference < EPSILON;
        }


        // TOSTRING METHOD


        @Override
        public String toString() {

            return "Quantity(" +
                    value +
                    ", " +
                    unit +
                    ")";
        }
    }


    // DEMONSTRATION METHODS


    public static void demonstrateLengthAddition(
            QuantityLength q1,
            QuantityLength q2) {

        QuantityLength result =
                q1.add(q2);

        System.out.println(
                q1 + " + " +
                        q2 + " = " +
                        result);
    }

    public static void demonstrateLengthAddition(
            double value1,
            LengthUnit unit1,
            double value2,
            LengthUnit unit2,
            LengthUnit targetUnit) {

        QuantityLength result =
                QuantityLength.add(
                        value1,
                        unit1,
                        value2,
                        unit2,
                        targetUnit);

        System.out.println(
                "Result : " + result);
    }


    // MAIN METHOD


    public static void main(String[] args) {

        QuantityLength feet =
                new QuantityLength(
                        1.0,
                        LengthUnit.FEET);

        QuantityLength inches =
                new QuantityLength(
                        12.0,
                        LengthUnit.INCHES);

        demonstrateLengthAddition(
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

        demonstrateLengthAddition(
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

        demonstrateLengthAddition(
                cm,
                inch);
    }
}