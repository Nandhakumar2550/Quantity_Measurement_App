package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    private static final double EPSILON = 0.01;

    // SUBTRACTION SAME UNIT

    @Test
    public void testSubtraction_SameUnit_FeetMinusFeet() {

        Quantity<LengthUnit> q1 =
                new Quantity<>(
                        10.0,
                        LengthUnit.FEET);

        Quantity<LengthUnit> q2 =
                new Quantity<>(
                        5.0,
                        LengthUnit.FEET);

        Quantity<LengthUnit> result =
                q1.subtract(q2);

        assertEquals(
                5.0,
                result.getValue(),
                EPSILON);
    }

    // SUBTRACTION CROSS UNIT

    @Test
    public void testSubtraction_CrossUnit_FeetMinusInches() {

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

    // SUBTRACTION TARGET UNIT

    @Test
    public void testSubtraction_ExplicitTargetUnit_Inches() {

        Quantity<LengthUnit> q1 =
                new Quantity<>(
                        10.0,
                        LengthUnit.FEET);

        Quantity<LengthUnit> q2 =
                new Quantity<>(
                        6.0,
                        LengthUnit.INCHES);

        Quantity<LengthUnit> result =
                q1.subtract(
                        q2,
                        LengthUnit.INCHES);

        assertEquals(
                114.0,
                result.getValue(),
                EPSILON);
    }

    // SUBTRACTION NEGATIVE RESULT

    @Test
    public void testSubtraction_ResultingInNegative() {

        Quantity<LengthUnit> q1 =
                new Quantity<>(
                        5.0,
                        LengthUnit.FEET);

        Quantity<LengthUnit> q2 =
                new Quantity<>(
                        10.0,
                        LengthUnit.FEET);

        Quantity<LengthUnit> result =
                q1.subtract(q2);

        assertEquals(
                -5.0,
                result.getValue(),
                EPSILON);
    }

    // SUBTRACTION ZERO RESULT

    @Test
    public void testSubtraction_ResultingInZero() {

        Quantity<LengthUnit> q1 =
                new Quantity<>(
                        10.0,
                        LengthUnit.FEET);

        Quantity<LengthUnit> q2 =
                new Quantity<>(
                        120.0,
                        LengthUnit.INCHES);

        Quantity<LengthUnit> result =
                q1.subtract(q2);

        assertEquals(
                0.0,
                result.getValue(),
                EPSILON);
    }

    // DIVISION SAME UNIT

    @Test
    public void testDivision_SameUnit_FeetDividedByFeet() {

        Quantity<LengthUnit> q1 =
                new Quantity<>(
                        10.0,
                        LengthUnit.FEET);

        Quantity<LengthUnit> q2 =
                new Quantity<>(
                        2.0,
                        LengthUnit.FEET);

        assertEquals(
                5.0,
                q1.divide(q2),
                EPSILON);
    }

    // DIVISION CROSS UNIT

    @Test
    public void testDivision_CrossUnit_FeetDividedByInches() {

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

    // DIVISION RATIO LESS THAN ONE

    @Test
    public void testDivision_RatioLessThanOne() {

        Quantity<LengthUnit> q1 =
                new Quantity<>(
                        5.0,
                        LengthUnit.FEET);

        Quantity<LengthUnit> q2 =
                new Quantity<>(
                        10.0,
                        LengthUnit.FEET);

        assertEquals(
                0.5,
                q1.divide(q2),
                EPSILON);
    }

    // DIVISION BY ZERO

    @Test
    public void testDivision_ByZero() {

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

    // NULL OPERAND SUBTRACTION

    @Test
    public void testSubtraction_NullOperand() {

        Quantity<LengthUnit> q1 =
                new Quantity<>(
                        10.0,
                        LengthUnit.FEET);

        assertThrows(
                IllegalArgumentException.class,
                () -> q1.subtract(null));
    }

    // NULL OPERAND DIVISION

    @Test
    public void testDivision_NullOperand() {

        Quantity<LengthUnit> q1 =
                new Quantity<>(
                        10.0,
                        LengthUnit.FEET);

        assertThrows(
                IllegalArgumentException.class,
                () -> q1.divide(null));
    }

    // IMMUTABILITY TEST

    @Test
    public void testSubtraction_Immutability() {

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

    // ADDITION SUBTRACTION INVERSE

    @Test
    public void testSubtractionAddition_Inverse() {

        Quantity<LengthUnit> original =
                new Quantity<>(
                        10.0,
                        LengthUnit.FEET);

        Quantity<LengthUnit> added =
                original.add(
                        new Quantity<>(
                                5.0,
                                LengthUnit.FEET));

        Quantity<LengthUnit> result =
                added.subtract(
                        new Quantity<>(
                                5.0,
                                LengthUnit.FEET));

        assertEquals(
                original.getValue(),
                result.getValue(),
                EPSILON);
    }

    // WEIGHT DIVISION

    @Test
    public void testDivision_WeightCategory() {

        Quantity<WeightUnit> q1 =
                new Quantity<>(
                        10.0,
                        WeightUnit.KILOGRAM);

        Quantity<WeightUnit> q2 =
                new Quantity<>(
                        5.0,
                        WeightUnit.KILOGRAM);

        assertEquals(
                2.0,
                q1.divide(q2),
                EPSILON);
    }

    // VOLUME DIVISION

    @Test
    public void testDivision_VolumeCategory() {

        Quantity<VolumeUnit> q1 =
                new Quantity<>(
                        5.0,
                        VolumeUnit.LITRE);

        Quantity<VolumeUnit> q2 =
                new Quantity<>(
                        10.0,
                        VolumeUnit.LITRE);

        assertEquals(
                0.5,
                q1.divide(q2),
                EPSILON);
    }
}