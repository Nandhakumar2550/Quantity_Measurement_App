package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    private static final double EPSILON = 0.01;

    // FEET TARGET UNIT

    @Test
    public void testAddition_ExplicitTargetUnit_Feet() {

        QuantityMeasurementApp.QuantityLength result =
                QuantityMeasurementApp.QuantityLength.add(

                        new QuantityMeasurementApp.QuantityLength(
                                1.0,
                                QuantityMeasurementApp.LengthUnit.FEET),

                        new QuantityMeasurementApp.QuantityLength(
                                12.0,
                                QuantityMeasurementApp.LengthUnit.INCHES),

                        QuantityMeasurementApp.LengthUnit.FEET);

        assertEquals(
                2.0,
                result.getValue(),
                EPSILON);

        assertEquals(
                QuantityMeasurementApp.LengthUnit.FEET,
                result.getUnit());
    }

    // INCHES TARGET UNIT

    @Test
    public void testAddition_ExplicitTargetUnit_Inches() {

        QuantityMeasurementApp.QuantityLength result =
                QuantityMeasurementApp.QuantityLength.add(

                        new QuantityMeasurementApp.QuantityLength(
                                1.0,
                                QuantityMeasurementApp.LengthUnit.FEET),

                        new QuantityMeasurementApp.QuantityLength(
                                12.0,
                                QuantityMeasurementApp.LengthUnit.INCHES),

                        QuantityMeasurementApp.LengthUnit.INCHES);

        assertEquals(
                24.0,
                result.getValue(),
                EPSILON);
    }

    // YARDS TARGET UNIT

    @Test
    public void testAddition_ExplicitTargetUnit_Yards() {

        QuantityMeasurementApp.QuantityLength result =
                QuantityMeasurementApp.QuantityLength.add(

                        new QuantityMeasurementApp.QuantityLength(
                                1.0,
                                QuantityMeasurementApp.LengthUnit.FEET),

                        new QuantityMeasurementApp.QuantityLength(
                                12.0,
                                QuantityMeasurementApp.LengthUnit.INCHES),

                        QuantityMeasurementApp.LengthUnit.YARDS);

        assertEquals(
                0.667,
                result.getValue(),
                0.01);
    }

    // CENTIMETERS TARGET UNIT

    @Test
    public void testAddition_ExplicitTargetUnit_Centimeters() {

        QuantityMeasurementApp.QuantityLength result =
                QuantityMeasurementApp.QuantityLength.add(

                        new QuantityMeasurementApp.QuantityLength(
                                1.0,
                                QuantityMeasurementApp.LengthUnit.INCHES),

                        new QuantityMeasurementApp.QuantityLength(
                                1.0,
                                QuantityMeasurementApp.LengthUnit.INCHES),

                        QuantityMeasurementApp.LengthUnit.CENTIMETERS);

        assertEquals(
                5.08,
                result.getValue(),
                0.01);
    }

    // SAME AS FIRST OPERAND

    @Test
    public void testAddition_ExplicitTargetUnit_SameAsFirstOperand() {

        QuantityMeasurementApp.QuantityLength result =
                QuantityMeasurementApp.QuantityLength.add(

                        new QuantityMeasurementApp.QuantityLength(
                                2.0,
                                QuantityMeasurementApp.LengthUnit.YARDS),

                        new QuantityMeasurementApp.QuantityLength(
                                3.0,
                                QuantityMeasurementApp.LengthUnit.FEET),

                        QuantityMeasurementApp.LengthUnit.YARDS);

        assertEquals(
                3.0,
                result.getValue(),
                EPSILON);
    }

    // SAME AS SECOND OPERAND

    @Test
    public void testAddition_ExplicitTargetUnit_SameAsSecondOperand() {

        QuantityMeasurementApp.QuantityLength result =
                QuantityMeasurementApp.QuantityLength.add(

                        new QuantityMeasurementApp.QuantityLength(
                                2.0,
                                QuantityMeasurementApp.LengthUnit.YARDS),

                        new QuantityMeasurementApp.QuantityLength(
                                3.0,
                                QuantityMeasurementApp.LengthUnit.FEET),

                        QuantityMeasurementApp.LengthUnit.FEET);

        assertEquals(
                9.0,
                result.getValue(),
                EPSILON);
    }

    // COMMUTATIVITY

    @Test
    public void testAddition_ExplicitTargetUnit_Commutativity() {

        QuantityMeasurementApp.QuantityLength result1 =
                QuantityMeasurementApp.QuantityLength.add(

                        new QuantityMeasurementApp.QuantityLength(
                                1.0,
                                QuantityMeasurementApp.LengthUnit.FEET),

                        new QuantityMeasurementApp.QuantityLength(
                                12.0,
                                QuantityMeasurementApp.LengthUnit.INCHES),

                        QuantityMeasurementApp.LengthUnit.YARDS);

        QuantityMeasurementApp.QuantityLength result2 =
                QuantityMeasurementApp.QuantityLength.add(

                        new QuantityMeasurementApp.QuantityLength(
                                12.0,
                                QuantityMeasurementApp.LengthUnit.INCHES),

                        new QuantityMeasurementApp.QuantityLength(
                                1.0,
                                QuantityMeasurementApp.LengthUnit.FEET),

                        QuantityMeasurementApp.LengthUnit.YARDS);

        assertTrue(result1.equals(result2));
    }

    // ZERO VALUE

    @Test
    public void testAddition_ExplicitTargetUnit_WithZero() {

        QuantityMeasurementApp.QuantityLength result =
                QuantityMeasurementApp.QuantityLength.add(

                        new QuantityMeasurementApp.QuantityLength(
                                5.0,
                                QuantityMeasurementApp.LengthUnit.FEET),

                        new QuantityMeasurementApp.QuantityLength(
                                0.0,
                                QuantityMeasurementApp.LengthUnit.INCHES),

                        QuantityMeasurementApp.LengthUnit.YARDS);

        assertEquals(
                1.667,
                result.getValue(),
                0.01);
    }

    // NEGATIVE VALUES

    @Test
    public void testAddition_ExplicitTargetUnit_NegativeValues() {

        QuantityMeasurementApp.QuantityLength result =
                QuantityMeasurementApp.QuantityLength.add(

                        new QuantityMeasurementApp.QuantityLength(
                                5.0,
                                QuantityMeasurementApp.LengthUnit.FEET),

                        new QuantityMeasurementApp.QuantityLength(
                                -2.0,
                                QuantityMeasurementApp.LengthUnit.FEET),

                        QuantityMeasurementApp.LengthUnit.INCHES);

        assertEquals(
                36.0,
                result.getValue(),
                EPSILON);
    }

    // NULL TARGET UNIT

    @Test
    public void testAddition_ExplicitTargetUnit_NullTargetUnit() {

        assertThrows(
                IllegalArgumentException.class,
                () -> {

                    QuantityMeasurementApp.QuantityLength.add(

                            new QuantityMeasurementApp.QuantityLength(
                                    1.0,
                                    QuantityMeasurementApp.LengthUnit.FEET),

                            new QuantityMeasurementApp.QuantityLength(
                                    12.0,
                                    QuantityMeasurementApp.LengthUnit.INCHES),

                            null);
                });
    }
}