package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    private static final double EPSILON = 0.0001;


    // SAME UNIT ADDITION


    @Test
    public void testAddition_SameUnit_FeetPlusFeet() {

        QuantityMeasurementApp.QuantityLength q1 =
                new QuantityMeasurementApp.QuantityLength(
                        1.0,
                        QuantityMeasurementApp.LengthUnit.FEET);

        QuantityMeasurementApp.QuantityLength q2 =
                new QuantityMeasurementApp.QuantityLength(
                        2.0,
                        QuantityMeasurementApp.LengthUnit.FEET);

        QuantityMeasurementApp.QuantityLength result =
                q1.add(q2);

        assertEquals(3.0,
                result.getValue(),
                EPSILON);

        assertEquals(
                QuantityMeasurementApp.LengthUnit.FEET,
                result.getUnit());
    }

    @Test
    public void testAddition_SameUnit_InchPlusInch() {

        QuantityMeasurementApp.QuantityLength q1 =
                new QuantityMeasurementApp.QuantityLength(
                        6.0,
                        QuantityMeasurementApp.LengthUnit.INCHES);

        QuantityMeasurementApp.QuantityLength q2 =
                new QuantityMeasurementApp.QuantityLength(
                        6.0,
                        QuantityMeasurementApp.LengthUnit.INCHES);

        QuantityMeasurementApp.QuantityLength result =
                q1.add(q2);

        assertEquals(12.0,
                result.getValue(),
                EPSILON);
    }


    // CROSS UNIT ADDITION


    @Test
    public void testAddition_CrossUnit_FeetPlusInches() {

        QuantityMeasurementApp.QuantityLength feet =
                new QuantityMeasurementApp.QuantityLength(
                        1.0,
                        QuantityMeasurementApp.LengthUnit.FEET);

        QuantityMeasurementApp.QuantityLength inches =
                new QuantityMeasurementApp.QuantityLength(
                        12.0,
                        QuantityMeasurementApp.LengthUnit.INCHES);

        QuantityMeasurementApp.QuantityLength result =
                feet.add(inches);

        assertEquals(2.0,
                result.getValue(),
                EPSILON);

        assertEquals(
                QuantityMeasurementApp.LengthUnit.FEET,
                result.getUnit());
    }

    @Test
    public void testAddition_CrossUnit_InchPlusFeet() {

        QuantityMeasurementApp.QuantityLength inches =
                new QuantityMeasurementApp.QuantityLength(
                        12.0,
                        QuantityMeasurementApp.LengthUnit.INCHES);

        QuantityMeasurementApp.QuantityLength feet =
                new QuantityMeasurementApp.QuantityLength(
                        1.0,
                        QuantityMeasurementApp.LengthUnit.FEET);

        QuantityMeasurementApp.QuantityLength result =
                inches.add(feet);

        assertEquals(24.0,
                result.getValue(),
                EPSILON);

        assertEquals(
                QuantityMeasurementApp.LengthUnit.INCHES,
                result.getUnit());
    }

    @Test
    public void testAddition_CrossUnit_YardPlusFeet() {

        QuantityMeasurementApp.QuantityLength yard =
                new QuantityMeasurementApp.QuantityLength(
                        1.0,
                        QuantityMeasurementApp.LengthUnit.YARDS);

        QuantityMeasurementApp.QuantityLength feet =
                new QuantityMeasurementApp.QuantityLength(
                        3.0,
                        QuantityMeasurementApp.LengthUnit.FEET);

        QuantityMeasurementApp.QuantityLength result =
                yard.add(feet);

        assertEquals(2.0,
                result.getValue(),
                EPSILON);

        assertEquals(
                QuantityMeasurementApp.LengthUnit.YARDS,
                result.getUnit());
    }

    @Test
    public void testAddition_CrossUnit_CentimeterPlusInch() {

        QuantityMeasurementApp.QuantityLength cm =
                new QuantityMeasurementApp.QuantityLength(
                        2.54,
                        QuantityMeasurementApp.LengthUnit.CENTIMETERS);

        QuantityMeasurementApp.QuantityLength inch =
                new QuantityMeasurementApp.QuantityLength(
                        1.0,
                        QuantityMeasurementApp.LengthUnit.INCHES);

        QuantityMeasurementApp.QuantityLength result =
                cm.add(inch);

        assertEquals(5.08,
                result.getValue(),
                0.01);
    }


    // COMMUTATIVITY


    @Test
    public void testAddition_Commutativity() {

        QuantityMeasurementApp.QuantityLength feet =
                new QuantityMeasurementApp.QuantityLength(
                        1.0,
                        QuantityMeasurementApp.LengthUnit.FEET);

        QuantityMeasurementApp.QuantityLength inches =
                new QuantityMeasurementApp.QuantityLength(
                        12.0,
                        QuantityMeasurementApp.LengthUnit.INCHES);

        QuantityMeasurementApp.QuantityLength result1 =
                QuantityMeasurementApp.QuantityLength.add(
                        feet,
                        inches,
                        QuantityMeasurementApp.LengthUnit.INCHES);

        QuantityMeasurementApp.QuantityLength result2 =
                QuantityMeasurementApp.QuantityLength.add(
                        inches,
                        feet,
                        QuantityMeasurementApp.LengthUnit.INCHES);

        assertTrue(result1.equals(result2));
    }


    // ZERO VALUE


    @Test
    public void testAddition_WithZero() {

        QuantityMeasurementApp.QuantityLength feet =
                new QuantityMeasurementApp.QuantityLength(
                        5.0,
                        QuantityMeasurementApp.LengthUnit.FEET);

        QuantityMeasurementApp.QuantityLength zero =
                new QuantityMeasurementApp.QuantityLength(
                        0.0,
                        QuantityMeasurementApp.LengthUnit.INCHES);

        QuantityMeasurementApp.QuantityLength result =
                feet.add(zero);

        assertEquals(5.0,
                result.getValue(),
                EPSILON);
    }


    // NEGATIVE VALUES


    @Test
    public void testAddition_NegativeValues() {

        QuantityMeasurementApp.QuantityLength q1 =
                new QuantityMeasurementApp.QuantityLength(
                        5.0,
                        QuantityMeasurementApp.LengthUnit.FEET);

        QuantityMeasurementApp.QuantityLength q2 =
                new QuantityMeasurementApp.QuantityLength(
                        -2.0,
                        QuantityMeasurementApp.LengthUnit.FEET);

        QuantityMeasurementApp.QuantityLength result =
                q1.add(q2);

        assertEquals(3.0,
                result.getValue(),
                EPSILON);
    }


    // NULL OPERAND


    @Test
    public void testAddition_NullSecondOperand() {

        QuantityMeasurementApp.QuantityLength q1 =
                new QuantityMeasurementApp.QuantityLength(
                        1.0,
                        QuantityMeasurementApp.LengthUnit.FEET);

        assertThrows(
                IllegalArgumentException.class,
                () -> {
                    q1.add(null);
                });
    }


    // LARGE VALUES


    @Test
    public void testAddition_LargeValues() {

        QuantityMeasurementApp.QuantityLength q1 =
                new QuantityMeasurementApp.QuantityLength(
                        1e6,
                        QuantityMeasurementApp.LengthUnit.FEET);

        QuantityMeasurementApp.QuantityLength q2 =
                new QuantityMeasurementApp.QuantityLength(
                        1e6,
                        QuantityMeasurementApp.LengthUnit.FEET);

        QuantityMeasurementApp.QuantityLength result =
                q1.add(q2);

        assertEquals(2e6,
                result.getValue(),
                EPSILON);
    }


    // SMALL VALUES


    @Test
    public void testAddition_SmallValues() {

        QuantityMeasurementApp.QuantityLength q1 =
                new QuantityMeasurementApp.QuantityLength(
                        0.001,
                        QuantityMeasurementApp.LengthUnit.FEET);

        QuantityMeasurementApp.QuantityLength q2 =
                new QuantityMeasurementApp.QuantityLength(
                        0.002,
                        QuantityMeasurementApp.LengthUnit.FEET);

        QuantityMeasurementApp.QuantityLength result =
                q1.add(q2);

        assertEquals(0.003,
                result.getValue(),
                EPSILON);
    }
}