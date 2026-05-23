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

        // CONSTRUCTOR

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

        // GETTER METHODS

        public double getValue() {
            return value;
        }

        public LengthUnit getUnit() {
            return unit;
        }

        // CONVERT TO BASE UNIT

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

        // UC6 ADD METHOD

        public QuantityLength add(
                QuantityLength other) {

            if (other == null)
                throw new IllegalArgumentException(
                        "Second operand cannot be null");

            double firstBase =
                    this.toBaseUnit();

            double secondBase =
                    other.toBaseUnit();

            double sumBase =
                    firstBase + secondBase;

            double resultValue =
                    sumBase /
                            this.unit.getConversionFactor();

            return new QuantityLength(
                    resultValue,
                    this.unit);
        }

        // PRIVATE UTILITY METHOD

        private static double addBaseValues(
                QuantityLength first,
                QuantityLength second) {

            return first.toBaseUnit() +
                    second.toBaseUnit();
        }

        // UC7 ADD METHOD

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

            double sumBase =
                    addBaseValues(first, second);

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

    // MAIN METHOD

    public static void main(String[] args) {

        QuantityLength result1 =
                QuantityLength.add(
                        new QuantityLength(
                                1.0,
                                LengthUnit.FEET),

                        new QuantityLength(
                                12.0,
                                LengthUnit.INCHES),

                        LengthUnit.FEET);

        System.out.println(result1);

        QuantityLength result2 =
                QuantityLength.add(
                        new QuantityLength(
                                1.0,
                                LengthUnit.FEET),

                        new QuantityLength(
                                12.0,
                                LengthUnit.INCHES),

                        LengthUnit.INCHES);

        System.out.println(result2);

        QuantityLength result3 =
                QuantityLength.add(
                        new QuantityLength(
                                1.0,
                                LengthUnit.FEET),

                        new QuantityLength(
                                12.0,
                                LengthUnit.INCHES),

                        LengthUnit.YARDS);

        System.out.println(result3);

        QuantityLength result4 =
                QuantityLength.add(
                        new QuantityLength(
                                1.0,
                                LengthUnit.YARDS),

                        new QuantityLength(
                                3.0,
                                LengthUnit.FEET),

                        LengthUnit.YARDS);

        System.out.println(result4);

        QuantityLength result5 =
                QuantityLength.add(
                        new QuantityLength(
                                36.0,
                                LengthUnit.INCHES),

                        new QuantityLength(
                                1.0,
                                LengthUnit.YARDS),

                        LengthUnit.FEET);

        System.out.println(result5);

        QuantityLength result6 =
                QuantityLength.add(
                        new QuantityLength(
                                2.54,
                                LengthUnit.CENTIMETERS),

                        new QuantityLength(
                                1.0,
                                LengthUnit.INCHES),

                        LengthUnit.CENTIMETERS);

        System.out.println(result6);
    }
}