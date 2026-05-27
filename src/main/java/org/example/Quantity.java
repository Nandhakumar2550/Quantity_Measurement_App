package org.example;

import java.util.Objects;

public class Quantity<U extends IMeasurable> {

    private static final double EPSILON = 0.0001;

    private final double value;

    private final U unit;

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

    // BASE UNIT CONVERSION

    private double toBaseUnit() {

        return unit.convertToBaseUnit(value);
    }

    // CONVERT METHOD

    public Quantity<U> convertTo(U targetUnit) {

        if (targetUnit == null)
            throw new IllegalArgumentException(
                    "Target unit cannot be null");

        double baseValue =
                unit.convertToBaseUnit(value);

        double convertedValue =
                targetUnit.convertFromBaseUnit(
                        baseValue);

        convertedValue =
                Math.round(convertedValue * 100.0)
                        / 100.0;

        return new Quantity<>(
                convertedValue,
                targetUnit);
    }

    // ADD METHOD

    public Quantity<U> add(
            Quantity<U> other) {

        if (other == null)
            throw new IllegalArgumentException(
                    "Operand cannot be null");

        double sumBase =
                this.toBaseUnit() +
                        other.toBaseUnit();

        double resultValue =
                unit.convertFromBaseUnit(
                        sumBase);

        resultValue =
                Math.round(resultValue * 100.0)
                        / 100.0;

        return new Quantity<>(
                resultValue,
                unit);
    }

    // ADD METHOD WITH TARGET UNIT

    public Quantity<U> add(
            Quantity<U> other,
            U targetUnit) {

        if (other == null)
            throw new IllegalArgumentException(
                    "Operand cannot be null");

        if (targetUnit == null)
            throw new IllegalArgumentException(
                    "Target unit cannot be null");

        double sumBase =
                this.toBaseUnit() +
                        other.toBaseUnit();

        double resultValue =
                targetUnit.convertFromBaseUnit(
                        sumBase);

        resultValue =
                Math.round(resultValue * 100.0)
                        / 100.0;

        return new Quantity<>(
                resultValue,
                targetUnit);
    }

    // SUBTRACT METHOD

    public Quantity<U> subtract(
            Quantity<U> other) {

        if (other == null)
            throw new IllegalArgumentException(
                    "Operand cannot be null");

        double differenceBase =
                this.toBaseUnit() -
                        other.toBaseUnit();

        double resultValue =
                unit.convertFromBaseUnit(
                        differenceBase);

        resultValue =
                Math.round(resultValue * 100.0)
                        / 100.0;

        return new Quantity<>(
                resultValue,
                unit);
    }

    // SUBTRACT METHOD WITH TARGET UNIT

    public Quantity<U> subtract(
            Quantity<U> other,
            U targetUnit) {

        if (other == null)
            throw new IllegalArgumentException(
                    "Operand cannot be null");

        if (targetUnit == null)
            throw new IllegalArgumentException(
                    "Target unit cannot be null");

        double differenceBase =
                this.toBaseUnit() -
                        other.toBaseUnit();

        double resultValue =
                targetUnit.convertFromBaseUnit(
                        differenceBase);

        resultValue =
                Math.round(resultValue * 100.0)
                        / 100.0;

        return new Quantity<>(
                resultValue,
                targetUnit);
    }

    // DIVIDE METHOD

    public double divide(
            Quantity<U> other) {

        if (other == null)
            throw new IllegalArgumentException(
                    "Operand cannot be null");

        double divisor =
                other.toBaseUnit();

        if (Math.abs(divisor) < EPSILON)
            throw new ArithmeticException(
                    "Cannot divide by zero");

        return this.toBaseUnit() / divisor;
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

    // HASHCODE METHOD

    @Override
    public int hashCode() {

        return Objects.hash(
                Math.round(toBaseUnit() * 1000));
    }

    // TOSTRING METHOD

    @Override
    public String toString() {

        return "Quantity(" +
                value +
                ", " +
                unit.getUnitName() +
                ")";
    }
}