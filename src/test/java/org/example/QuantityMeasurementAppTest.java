package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    private static final double EPSILON = 0.01;

    // ADDITION TEST

    @Test
    public void testAdd_UC12_BehaviorPreserved() {

        Quantity<LengthUnit> q1 =
                new Quantity<>(
                        1.0,
                        LengthUnit.FEET);

        Quantity<LengthUnit> q2 =
                new Quantity<>(
                        12.0,
                        LengthUnit.INCHES);

        Quantity<LengthUnit> result =
                q1.add(q2);

        assertEquals(
                2.0,
                result.getValue(),
                EPSILON);
    }

    // SUBTRACTION TEST

    @Test
    public void testSubtract_UC12_BehaviorPreserved() {

        Quantity<LengthUnit> q1 =
                new Quantity<>(
                        10.0,
                        LengthUnit.FEET);

        Quantity<LengthUnit> q2 =
                new Quantity<>(
                        6.0,
                        LengthUnit.INCHES);

        Quantity<LengthUnit> result =
                q1.subtract(q2);

        assertEquals(
                9.5,
                result.getValue(),
                EPSILON);
    }

    // DIVISION TEST

    @Test
    public void testDivide_UC12_BehaviorPreserved() {

        Quantity<LengthUnit> q1 =
                new Quantity<>(
                        24.0,
                        LengthUnit.INCHES);

        Quantity<LengthUnit> q2 =
                new Quantity<>(
                        2.0,
                        LengthUnit.FEET);

        assertEquals(
                1.0,
                q1.divide(q2),
                EPSILON);
    }

    // NULL OPERAND VALIDATION

    @Test
    public void testValidation_NullOperand_ConsistentAcrossOperations() {

        Quantity<LengthUnit> q1 =
                new Quantity<>(
                        10.0,
                        LengthUnit.FEET);

        assertThrows(
                IllegalArgumentException.class,
                () -> q1.add(null));

        assertThrows(
                IllegalArgumentException.class,
                () -> q1.subtract(null));

        assertThrows(
                IllegalArgumentException.class,
                () -> q1.divide(null));
    }

    // CROSS CATEGORY VALIDATION

    @Test
    public void testValidation_CrossCategory_ConsistentAcrossOperations() {

        Quantity<LengthUnit> length =
                new Quantity<>(
                        10.0,
                        LengthUnit.FEET);

        Quantity<WeightUnit> weight =
                new Quantity<>(
                        5.0,
                        WeightUnit.KILOGRAM);

        assertFalse(
                length.equals(weight));
    }

    // DIVIDE BY ZERO

    @Test
    public void testArithmeticOperation_DivideByZero_EnumThrows() {

        Quantity<LengthUnit> q1 =
                new Quantity<>(
                        10.0,
                        LengthUnit.FEET);

        Quantity<LengthUnit> q2 =
                new Quantity<>(
                        0.0,
                        LengthUnit.FEET);

        assertThrows(
                ArithmeticException.class,
                () -> q1.divide(q2));
    }

    // ROUNDING TEST

    @Test
    public void testRounding_AddSubtract_TwoDecimalPlaces() {

        Quantity<LengthUnit> q1 =
                new Quantity<>(
                        1.235,
                        LengthUnit.FEET);

        Quantity<LengthUnit> q2 =
                new Quantity<>(
                        0.111,
                        LengthUnit.FEET);

        Quantity<LengthUnit> result =
                q1.add(q2);

        assertEquals(
                1.35,
                result.getValue(),
                EPSILON);
    }

    // IMMUTABILITY TEST

    @Test
    public void testImmutability_AfterSubtract_ViaCentralizedHelper() {

        Quantity<LengthUnit> original =
                new Quantity<>(
                        10.0,
                        LengthUnit.FEET);

        Quantity<LengthUnit> result =
                original.subtract(
                        new Quantity<>(
                                5.0,
                                LengthUnit.FEET));

        assertNotSame(
                original,
                result);

        assertEquals(
                10.0,
                original.getValue(),
                EPSILON);
    }

    // WEIGHT CATEGORY TEST

    @Test
    public void testAllOperations_AcrossWeightCategory() {

        Quantity<WeightUnit> q1 =
                new Quantity<>(
                        10.0,
                        WeightUnit.KILOGRAM);

        Quantity<WeightUnit> q2 =
                new Quantity<>(
                        5000.0,
                        WeightUnit.GRAM);

        assertEquals(
                15.0,
                q1.add(q2).getValue(),
                EPSILON);

        assertEquals(
                5.0,
                q1.subtract(q2).getValue(),
                EPSILON);

        assertEquals(
                2.0,
                q1.divide(
                        new Quantity<>(
                                5.0,
                                WeightUnit.KILOGRAM)),
                EPSILON);
    }

    // VOLUME CATEGORY TEST

    @Test
    public void testAllOperations_AcrossVolumeCategory() {

        Quantity<VolumeUnit> q1 =
                new Quantity<>(
                        5.0,
                        VolumeUnit.LITRE);

        Quantity<VolumeUnit> q2 =
                new Quantity<>(
                        500.0,
                        VolumeUnit.MILLILITRE);

        assertEquals(
                5.5,
                q1.add(q2).getValue(),
                EPSILON);

        assertEquals(
                4.5,
                q1.subtract(q2).getValue(),
                EPSILON);

        assertEquals(
                0.5,
                q1.divide(
                        new Quantity<>(
                                10.0,
                                VolumeUnit.LITRE)),
                EPSILON);
    }
}