package org.example;

public class QuantityMeasurementApp {

    // QUANTITY LENGTH CLASS

    static class QuantityLength {

        private static final double EPSILON = 0.0001;

        private final double value;
        private final LengthUnit unit;

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

        public double getValue() {
            return value;
        }

        public LengthUnit getUnit() {
            return unit;
        }

        private double toBaseUnit() {

            return unit.convertToBaseUnit(value);
        }

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

        public QuantityLength add(
                QuantityLength other,
                LengthUnit targetUnit) {

            if (other == null)
                throw new IllegalArgumentException(
                        "Operand cannot be null");

            double sumBase =
                    this.toBaseUnit() +
                            other.toBaseUnit();

            double resultValue =
                    targetUnit.convertFromBaseUnit(
                            sumBase);

            return new QuantityLength(
                    resultValue,
                    targetUnit);
        }

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

        @Override
        public String toString() {

            return "Quantity(" +
                    value +
                    ", " +
                    unit +
                    ")";
        }
    }

    // QUANTITY WEIGHT CLASS

    static class QuantityWeight {

        private static final double EPSILON = 0.0001;

        private final double value;
        private final WeightUnit unit;

        public QuantityWeight(double value,
                              WeightUnit unit) {

            if (!Double.isFinite(value))
                throw new IllegalArgumentException(
                        "Invalid numeric value");

            if (unit == null)
                throw new IllegalArgumentException(
                        "Unit cannot be null");

            this.value = value;
            this.unit = unit;
        }

        public double getValue() {
            return value;
        }

        public WeightUnit getUnit() {
            return unit;
        }

        private double toBaseUnit() {

            return unit.convertToBaseUnit(value);
        }

        public QuantityWeight convertTo(
                WeightUnit targetUnit) {

            double baseValue =
                    unit.convertToBaseUnit(value);

            double convertedValue =
                    targetUnit.convertFromBaseUnit(
                            baseValue);

            return new QuantityWeight(
                    convertedValue,
                    targetUnit);
        }

        public QuantityWeight add(
                QuantityWeight other) {

            if (other == null)
                throw new IllegalArgumentException(
                        "Operand cannot be null");

            double sumBase =
                    this.toBaseUnit() +
                            other.toBaseUnit();

            double resultValue =
                    this.unit.convertFromBaseUnit(
                            sumBase);

            return new QuantityWeight(
                    resultValue,
                    this.unit);
        }

        public QuantityWeight add(
                QuantityWeight other,
                WeightUnit targetUnit) {

            if (other == null)
                throw new IllegalArgumentException(
                        "Operand cannot be null");

            double sumBase =
                    this.toBaseUnit() +
                            other.toBaseUnit();

            double resultValue =
                    targetUnit.convertFromBaseUnit(
                            sumBase);

            return new QuantityWeight(
                    resultValue,
                    targetUnit);
        }

        @Override
        public boolean equals(Object obj) {

            if (this == obj)
                return true;

            if (obj == null)
                return false;

            if (getClass() != obj.getClass())
                return false;

            QuantityWeight other =
                    (QuantityWeight) obj;

            double difference =
                    Math.abs(
                            this.toBaseUnit() -
                                    other.toBaseUnit());

            return difference < EPSILON;
        }

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

        QuantityWeight kilogram =
                new QuantityWeight(
                        1.0,
                        WeightUnit.KILOGRAM);

        QuantityWeight gram =
                new QuantityWeight(
                        1000.0,
                        WeightUnit.GRAM);

        QuantityWeight pound =
                new QuantityWeight(
                        2.20462,
                        WeightUnit.POUND);

        // EQUALITY

        System.out.println(
                kilogram.equals(gram));

        // CONVERSION

        System.out.println(
                kilogram.convertTo(
                        WeightUnit.GRAM));

        // ADDITION

        System.out.println(
                kilogram.add(
                        gram));

        // ADDITION WITH TARGET UNIT

        System.out.println(
                kilogram.add(
                        gram,
                        WeightUnit.GRAM));

        // POUND TO KG

        System.out.println(
                pound.convertTo(
                        WeightUnit.KILOGRAM));
    }
}