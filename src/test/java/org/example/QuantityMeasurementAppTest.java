package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    private static final double EPSILON = 0.01;

    // FEET CONSTANT

    @Test
    public void testLengthUnitEnum_FeetConstant() {

        assertEquals(
                1.0,
                LengthUnit.FEET
                        .getConversionFactor(),
                EPSILON);
    }

    // INCHES CONSTANT

    @Test
    public void testLengthUnitEnum_InchesConstant() {

        assertEquals(
                1.0 / 12.0,
                LengthUnit.INCHES
                        .getConversionFactor(),
                EPSILON);
    }

    // YARDS CONSTANT

    @Test
    public void testLengthUnitEnum_YardsConstant() {

        assertEquals(
                3.0,
                LengthUnit.YARDS
                        .getConversionFactor(),
                EPSILON);
    }

    // CENTIMETERS CONSTANT

    @Test
    public void testLengthUnitEnum_CentimetersConstant() {

        assertEquals(
                1.0 / 30.48,
                LengthUnit.CENTIMETERS
                        .getConversionFactor(),
                EPSILON);
    }

    // FEET TO FEET

    @Test
    public void testConvertToBaseUnit_FeetToFeet() {

        assertEquals(
                5.0,
                LengthUnit.FEET
                        .convertToBaseUnit(5.0),
                EPSILON);
    }

    // INCHES TO FEET

    @Test
    public void testConvertToBaseUnit_InchesToFeet() {

        assertEquals(
                1.0,
                LengthUnit.INCHES
                        .convertToBaseUnit(12.0),
                EPSILON);
    }

    // YARDS TO FEET

    @Test
    public void testConvertToBaseUnit_YardsToFeet() {

        assertEquals(
                3.0,
                LengthUnit.YARDS
                        .convertToBaseUnit(1.0),
                EPSILON);
    }

    // CENTIMETERS TO FEET

    @Test
    public void testConvertToBaseUnit_CentimetersToFeet() {

        assertEquals(
                1.0,
                LengthUnit.CENTIMETERS
                        .convertToBaseUnit(30.48),
                EPSILON);
    }

    // FEET FROM BASE UNIT

    @Test
    public void testConvertFromBaseUnit_FeetToFeet() {

        assertEquals(
                2.0,
                LengthUnit.FEET
                        .convertFromBaseUnit(2.0),
                EPSILON);
    }

    // FEET TO INCHES

    @Test
    public void testConvertFromBaseUnit_FeetToInches() {

        assertEquals(
                12.0,
                LengthUnit.INCHES
                        .convertFromBaseUnit(1.0),
                EPSILON);
    }

    // FEET TO YARDS

    @Test
    public void testConvertFromBaseUnit_FeetToYards() {

        assertEquals(
                1.0,
                LengthUnit.YARDS
                        .convertFromBaseUnit(3.0),
                EPSILON);
    }

    // FEET TO CENTIMETERS

    @Test
    public void testConvertFromBaseUnit_FeetToCentimeters() {

        assertEquals(
                30.48,
                LengthUnit.CENTIMETERS
                        .convertFromBaseUnit(1.0),
                EPSILON);
    }

    // EQUALITY TEST

    @Test
    public void testQuantityLengthRefactored_Equality() {

        QuantityMeasurementApp.QuantityLength q1 =
                new QuantityMeasurementApp.QuantityLength(
                        1.0,
                        LengthUnit.FEET);

        QuantityMeasurementApp.QuantityLength q2 =
                new QuantityMeasurementApp.QuantityLength(
                        12.0,
                        LengthUnit.INCHES);

        assertTrue(q1.equals(q2));
    }

    // CONVERT TO TEST

    @Test
    public void testQuantityLengthRefactored_ConvertTo() {

        QuantityMeasurementApp.QuantityLength q1 =
                new QuantityMeasurementApp.QuantityLength(
                        1.0,
                        LengthUnit.FEET);

        QuantityMeasurementApp.QuantityLength result =
                q1.convertTo(
                        LengthUnit.INCHES);

        assertEquals(
                12.0,
                result.getValue(),
                EPSILON);
    }

    // ADD TEST

    @Test
    public void testQuantityLengthRefactored_Add() {

        QuantityMeasurementApp.QuantityLength q1 =
                new QuantityMeasurementApp.QuantityLength(
                        1.0,
                        LengthUnit.FEET);

        QuantityMeasurementApp.QuantityLength q2 =
                new QuantityMeasurementApp.QuantityLength(
                        12.0,
                        LengthUnit.INCHES);

        QuantityMeasurementApp.QuantityLength result =
                q1.add(
                        q2,
                        LengthUnit.FEET);

        assertEquals(
                2.0,
                result.getValue(),
                EPSILON);
    }

    // ADD WITH TARGET UNIT

    @Test
    public void testQuantityLengthRefactored_AddWithTargetUnit() {

        QuantityMeasurementApp.QuantityLength q1 =
                new QuantityMeasurementApp.QuantityLength(
                        1.0,
                        LengthUnit.FEET);

        QuantityMeasurementApp.QuantityLength q2 =
                new QuantityMeasurementApp.QuantityLength(
                        12.0,
                        LengthUnit.INCHES);

        QuantityMeasurementApp.QuantityLength result =
                q1.add(
                        q2,
                        LengthUnit.YARDS);

        assertEquals(
                0.667,
                result.getValue(),
                EPSILON);
    }

    // NULL UNIT TEST

    @Test
    public void testQuantityLengthRefactored_NullUnit() {

        assertThrows(
                IllegalArgumentException.class,
                () -> {

                    new QuantityMeasurementApp.QuantityLength(
                            1.0,
                            null);
                });
    }

    // INVALID VALUE TEST

    @Test
    public void testQuantityLengthRefactored_InvalidValue() {

        assertThrows(
                IllegalArgumentException.class,
                () -> {

                    new QuantityMeasurementApp.QuantityLength(
                            Double.NaN,
                            LengthUnit.FEET);
                });
    }

    // ROUND TRIP CONVERSION

    @Test
    public void testRoundTripConversion_RefactoredDesign() {

        QuantityMeasurementApp.QuantityLength q1 =
                new QuantityMeasurementApp.QuantityLength(
                        1.0,
                        LengthUnit.FEET);

        QuantityMeasurementApp.QuantityLength converted =
                q1.convertTo(
                        LengthUnit.INCHES);

        QuantityMeasurementApp.QuantityLength result =
                converted.convertTo(
                        LengthUnit.FEET);

        assertEquals(
                1.0,
                result.getValue(),
                EPSILON);
    }

    // UNIT IMMUTABILITY

    @Test
    public void testUnitImmutability() {

        assertNotNull(
                LengthUnit.FEET);

        assertNotNull(
                LengthUnit.INCHES);

        assertNotNull(
                LengthUnit.YARDS);

        assertNotNull(
                LengthUnit.CENTIMETERS);
    }
}