package org.example;

public class QuantityMeasurementApp {

    // Enum for Units
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

    // Generic Quantity Class
    static class QuantityLength {

        private final double value;
        private final LengthUnit unit;

        public QuantityLength(double value,
                              LengthUnit unit) {

            if (unit == null)
                throw new IllegalArgumentException(
                        "Unit cannot be null");

            this.value = value;
            this.unit = unit;
        }

        // Convert to inches
        public double toBaseUnit() {

            return value *
                    unit.getConversionFactor();
        }

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

            return Double.compare(
                    this.toBaseUnit(),
                    measurement.toBaseUnit()
            ) == 0;
        }
    }

    public static void main(String[] args) {

        QuantityLength q1 =
                new QuantityLength(
                        1.0,
                        LengthUnit.YARDS);

        QuantityLength q2 =
                new QuantityLength(
                        3.0,
                        LengthUnit.FEET);

        System.out.println(q1.equals(q2));

        QuantityLength q3 =
                new QuantityLength(
                        1.0,
                        LengthUnit.CENTIMETERS);

        QuantityLength q4 =
                new QuantityLength(
                        0.393701,
                        LengthUnit.INCHES);

        System.out.println(q3.equals(q4));
    }
}