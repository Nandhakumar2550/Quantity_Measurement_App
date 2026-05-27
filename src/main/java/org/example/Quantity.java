package org.example;

import java.util.Objects;
import java.util.function.DoubleBinaryOperator;

public class Quantity<U extends IMeasurable> {

    private static final double EPSILON =
            0.0001;

    private final double value;

    private final U unit;

    // ARITHMETIC OPERATION ENUM

    private enum ArithmeticOperation {

        ADD((a, b) -> a + b),

        SUBTRACT((a, b) -> a - b),

        DIVIDE((a, b) -> {

            if (Math.abs(b) < EPSILON)
                throw new ArithmeticException(
                        "Cannot divide by zero");

            return a / b;
        });

        private final DoubleBinaryOperator
                operation;

        ArithmeticOperation(
                DoubleBinaryOperator operation) {

            this.operation = operation;
        }

        public double compute(
                double first,
                double second) {

            return operation.applyAsDouble(
                    first,
                    second);
        }
    }

    // CONSTRUCTOR

    public Quantity(double value,
                    U unit) {

        if (!Double.isFinite(value))
            throw new IllegalArgumentException(
                    "Invalid numeric value");

        if (unit == null)
            throw new IllegalArgumentException(
                    "Unit cannot be null");

        this.value = value;
        this.unit = unit;
    }

    // GETTERS

    public double getValue() {
        return value;
    }

    public U getUnit() {
        return unit;
    }

    // BASE UNIT

    private double toBaseUnit() {

        return unit.convertToBaseUnit(
                value);
    }

    // ROUNDING HELPER

    private double roundToTwoDecimals(
            double value) {

        return Math.round(value * 100.0)
                / 100.0;
    }

    // VALIDATION HELPER

    private void validateArithmeticOperands(
            Quantity<U> other,
            U targetUnit,
            boolean targetUnitRequired,
            String operation) {

        if (other == null)
            throw new IllegalArgumentException(
                    "Operand cannot be null");

        if (this.unit.getClass() !=
                other.unit.getClass())
            throw new IllegalArgumentException(
                    "Cross-category operations not allowed");

        if (!Double.isFinite(this.value) ||
                !Double.isFinite(other.value))
            throw new IllegalArgumentException(
                    "Invalid numeric value");

        if (targetUnitRequired &&
                targetUnit == null)
            throw new IllegalArgumentException(
                    "Target unit cannot be null");

        // OPERATION VALIDATION

        this.unit.validateOperationSupport(
                operation);
    }

    // CENTRALIZED ARITHMETIC

    private double performBaseArithmetic(
            Quantity<U> other,
            ArithmeticOperation operation) {

        double firstBase =
                this.toBaseUnit();

        double secondBase =
                other.toBaseUnit();

        return operation.compute(
                firstBase,
                secondBase);
    }

    // CONVERT METHOD

    public Quantity<U> convertTo(
            U targetUnit) {

        if (targetUnit == null)
            throw new IllegalArgumentException(
                    "Target unit cannot be null");

        double baseValue =
                this.toBaseUnit();

        double convertedValue =
                targetUnit.convertFromBaseUnit(
                        baseValue);

        convertedValue =
                roundToTwoDecimals(
                        convertedValue);

        return new Quantity<>(
                convertedValue,
                targetUnit);
    }

    // ADD METHOD

    public Quantity<U> add(
            Quantity<U> other) {

        validateArithmeticOperands(
                other,
                null,
                false,
                "addition");

        double sumBase =
                performBaseArithmetic(
                        other,
                        ArithmeticOperation.ADD);

        double resultValue =
                unit.convertFromBaseUnit(
                        sumBase);

        return new Quantity<>(
                roundToTwoDecimals(
                        resultValue),
                unit);
    }

    // SUBTRACT METHOD

    public Quantity<U> subtract(
            Quantity<U> other) {

        validateArithmeticOperands(
                other,
                null,
                false,
                "subtraction");

        double differenceBase =
                performBaseArithmetic(
                        other,
                        ArithmeticOperation.SUBTRACT);

        double resultValue =
                unit.convertFromBaseUnit(
                        differenceBase);

        return new Quantity<>(
                roundToTwoDecimals(
                        resultValue),
                unit);
    }

    // DIVIDE METHOD

    public double divide(
            Quantity<U> other) {

        validateArithmeticOperands(
                other,
                null,
                false,
                "division");

        return performBaseArithmetic(
                other,
                ArithmeticOperation.DIVIDE);
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

        Quantity<?> other =
                (Quantity<?>) obj;

        if (this.unit.getClass() !=
                other.unit.getClass())
            return false;

        double difference =
                Math.abs(
                        this.toBaseUnit() -
                                other.toBaseUnit());

        return difference < EPSILON;
    }

    // HASHCODE

    @Override
    public int hashCode() {

        return Objects.hash(
                Math.round(
                        toBaseUnit() * 1000));
    }

    // TOSTRING

    @Override
    public String toString() {

        return "Quantity(" +
                value +
                ", " +
                unit.getUnitName() +
                ")";
    }
}