package org.example;

public class QuantityMeasurementApp {

    static class Feet {

        private final double value;

        public Feet(double value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object obj) {

            // Same reference check
            if (this == obj)
                return true;

            // Null check
            if (obj == null)
                return false;

            // Type check
            if (getClass() != obj.getClass())
                return false;

            // Type casting
            Feet measurement = (Feet) obj;

            // Value comparison
            return Double.compare(measurement.value, value) == 0;
        }
    }

    public static void main(String[] args) {

        Feet f1 = new Feet(1.0);
        Feet f2 = new Feet(1.0);

        System.out.println(f1.equals(f2));
    }
}
