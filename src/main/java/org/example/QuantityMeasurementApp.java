package org.example;

public class QuantityMeasurementApp {

    // Enum for Units
    enum LengthUnit {

        FEET(1.0),
        INCH(1.0 / 12);

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

        // Convert into feet
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

    // Main Method
    public static void main(String[] args) {

        QuantityLength q1 =
                new QuantityLength(
                        1.0,
                        LengthUnit.FEET);

        QuantityLength q2 =
                new QuantityLength(
                        12.0,
                        LengthUnit.INCH);

        System.out.println(q1.equals(q2));

        QuantityLength q3 =
                new QuantityLength(
                        1.0,
                        LengthUnit.INCH);

        QuantityLength q4 =
                new QuantityLength(
                        1.0,
                        LengthUnit.INCH);

        System.out.println(q3.equals(q4));
    }
}