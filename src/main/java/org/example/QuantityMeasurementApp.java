package org.example;

public class QuantityMeasurementApp {

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

            return unit.convertToBaseUnit(value);
        }

        // CONVERT TO TARGET UNIT

        public QuantityLength convertTo(
                LengthUnit targetUnit) {

            double baseValue =
                    unit.convertToBaseUnit(value);

            double convertedValue =
                    targetUnit.convertFromBaseUnit(
                            baseValue);

            return new QuantityLength(
                    convertedValue,
                    targetUnit);
        }

        // ADD METHOD

        public QuantityLength add(
                QuantityLength other,
                LengthUnit targetUnit) {

            if (other == null)
                throw new IllegalArgumentException(
                        "Operand cannot be null");

            if (targetUnit == null)
                throw new IllegalArgumentException(
                        "Target unit cannot be null");

            double firstBase =
                    this.toBaseUnit();

            double secondBase =
                    other.toBaseUnit();

            double sumBase =
                    firstBase + secondBase;

            double resultValue =
                    targetUnit.convertFromBaseUnit(
                            sumBase);

            return new QuantityLength(
                    resultValue,
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

            QuantityLength other =
                    (QuantityLength) obj;

            double difference =
                    Math.abs(
                            this.toBaseUnit() -
                                    other.toBaseUnit());

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

        QuantityLength feet =
                new QuantityLength(
                        1.0,
                        LengthUnit.FEET);

        QuantityLength inches =
                new QuantityLength(
                        12.0,
                        LengthUnit.INCHES);

        QuantityLength yards =
                new QuantityLength(
                        1.0,
                        LengthUnit.YARDS);

        QuantityLength centimeters =
                new QuantityLength(
                        2.54,
                        LengthUnit.CENTIMETERS);

        // CONVERSION

        System.out.println(
                feet.convertTo(
                        LengthUnit.INCHES));

        // ADDITION

        System.out.println(
                feet.add(
                        inches,
                        LengthUnit.FEET));

        // EQUALITY

        System.out.println(
                new QuantityLength(
                        36.0,
                        LengthUnit.INCHES)
                        .equals(
                                new QuantityLength(
                                        1.0,
                                        LengthUnit.YARDS)));

        // YARD + FEET

        System.out.println(
                yards.add(
                        new QuantityLength(
                                3.0,
                                LengthUnit.FEET),
                        LengthUnit.YARDS));

        // CM TO INCHES

        System.out.println(
                centimeters.convertTo(
                        LengthUnit.INCHES));

        // ADD WITH ZERO

        System.out.println(
                new QuantityLength(
                        5.0,
                        LengthUnit.FEET)
                        .add(
                                new QuantityLength(
                                        0.0,
                                        LengthUnit.INCHES),
                                LengthUnit.FEET));

        // ENUM CONVERSION METHODS

        System.out.println(
                LengthUnit.FEET
                        .convertToBaseUnit(12.0));

        System.out.println(
                LengthUnit.INCHES
                        .convertToBaseUnit(12.0));
    }
}