package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    private static final double EPSILON = 0.0001;


    // BASIC UNIT CONVERSION TESTS


    @Test
    public void testConversion_FeetToInches() {

        double result =
                QuantityMeasurementApp.QuantityLength.convert(
                        1.0,
                        QuantityMeasurementApp.LengthUnit.FEET,
                        QuantityMeasurementApp.LengthUnit.INCHES);

        assertEquals(12.0, result, EPSILON);
    }

    @Test
    public void testConversion_InchesToFeet() {

        double result =
                QuantityMeasurementApp.QuantityLength.convert(
                        24.0,
                        QuantityMeasurementApp.LengthUnit.INCHES,
                        QuantityMeasurementApp.LengthUnit.FEET);

        assertEquals(2.0, result, EPSILON);
    }

    @Test
    public void testConversion_YardsToFeet() {

        double result =
                QuantityMeasurementApp.QuantityLength.convert(
                        3.0,
                        QuantityMeasurementApp.LengthUnit.YARDS,
                        QuantityMeasurementApp.LengthUnit.FEET);

        assertEquals(9.0, result, EPSILON);
    }

    @Test
    public void testConversion_FeetToYards() {

        double result =
                QuantityMeasurementApp.QuantityLength.convert(
                        6.0,
                        QuantityMeasurementApp.LengthUnit.FEET,
                        QuantityMeasurementApp.LengthUnit.YARDS);

        assertEquals(2.0, result, EPSILON);
    }

    @Test
    public void testConversion_YardsToInches() {

        double result =
                QuantityMeasurementApp.QuantityLength.convert(
                        1.0,
                        QuantityMeasurementApp.LengthUnit.YARDS,
                        QuantityMeasurementApp.LengthUnit.INCHES);

        assertEquals(36.0, result, EPSILON);
    }

    @Test
    public void testConversion_InchesToYards() {

        double result =
                QuantityMeasurementApp.QuantityLength.convert(
                        72.0,
                        QuantityMeasurementApp.LengthUnit.INCHES,
                        QuantityMeasurementApp.LengthUnit.YARDS);

        assertEquals(2.0, result, EPSILON);
    }

    @Test
    public void testConversion_CentimetersToInches() {

        double result =
                QuantityMeasurementApp.QuantityLength.convert(
                        2.54,
                        QuantityMeasurementApp.LengthUnit.CENTIMETERS,
                        QuantityMeasurementApp.LengthUnit.INCHES);

        assertEquals(1.0, result, 0.001);
    }

    @Test
    public void testConversion_InchesToCentimeters() {

        double result =
                QuantityMeasurementApp.QuantityLength.convert(
                        1.0,
                        QuantityMeasurementApp.LengthUnit.INCHES,
                        QuantityMeasurementApp.LengthUnit.CENTIMETERS);

        assertEquals(2.54, result, 0.01);
    }

    @Test
    public void testConversion_CentimetersToFeet() {

        double result =
                QuantityMeasurementApp.QuantityLength.convert(
                        30.48,
                        QuantityMeasurementApp.LengthUnit.CENTIMETERS,
                        QuantityMeasurementApp.LengthUnit.FEET);

        assertEquals(1.0, result, 0.01);
    }

    @Test
    public void testConversion_FeetToCentimeters() {

        double result =
                QuantityMeasurementApp.QuantityLength.convert(
                        1.0,
                        QuantityMeasurementApp.LengthUnit.FEET,
                        QuantityMeasurementApp.LengthUnit.CENTIMETERS);

        assertEquals(30.48, result, 0.1);
    }


    // SAME UNIT CONVERSION TESTS


    @Test
    public void testConversion_SameUnit_Feet() {

        double result =
                QuantityMeasurementApp.QuantityLength.convert(
                        5.0,
                        QuantityMeasurementApp.LengthUnit.FEET,
                        QuantityMeasurementApp.LengthUnit.FEET);

        assertEquals(5.0, result, EPSILON);
    }

    @Test
    public void testConversion_SameUnit_Inches() {

        double result =
                QuantityMeasurementApp.QuantityLength.convert(
                        10.0,
                        QuantityMeasurementApp.LengthUnit.INCHES,
                        QuantityMeasurementApp.LengthUnit.INCHES);

        assertEquals(10.0, result, EPSILON);
    }

    @Test
    public void testConversion_SameUnit_Yards() {

        double result =
                QuantityMeasurementApp.QuantityLength.convert(
                        2.0,
                        QuantityMeasurementApp.LengthUnit.YARDS,
                        QuantityMeasurementApp.LengthUnit.YARDS);

        assertEquals(2.0, result, EPSILON);
    }

    @Test
    public void testConversion_SameUnit_Centimeters() {

        double result =
                QuantityMeasurementApp.QuantityLength.convert(
                        100.0,
                        QuantityMeasurementApp.LengthUnit.CENTIMETERS,
                        QuantityMeasurementApp.LengthUnit.CENTIMETERS);

        assertEquals(100.0, result, EPSILON);
    }


    // ZERO VALUE TESTS


    @Test
    public void testConversion_ZeroValue_FeetToInches() {

        double result =
                QuantityMeasurementApp.QuantityLength.convert(
                        0.0,
                        QuantityMeasurementApp.LengthUnit.FEET,
                        QuantityMeasurementApp.LengthUnit.INCHES);

        assertEquals(0.0, result, EPSILON);
    }

    @Test
    public void testConversion_ZeroValue_YardsToFeet() {

        double result =
                QuantityMeasurementApp.QuantityLength.convert(
                        0.0,
                        QuantityMeasurementApp.LengthUnit.YARDS,
                        QuantityMeasurementApp.LengthUnit.FEET);

        assertEquals(0.0, result, EPSILON);
    }


    // NEGATIVE VALUE TESTS


    @Test
    public void testConversion_NegativeValue_FeetToInches() {

        double result =
                QuantityMeasurementApp.QuantityLength.convert(
                        -1.0,
                        QuantityMeasurementApp.LengthUnit.FEET,
                        QuantityMeasurementApp.LengthUnit.INCHES);

        assertEquals(-12.0, result, EPSILON);
    }

    @Test
    public void testConversion_NegativeValue_YardsToFeet() {

        double result =
                QuantityMeasurementApp.QuantityLength.convert(
                        -2.0,
                        QuantityMeasurementApp.LengthUnit.YARDS,
                        QuantityMeasurementApp.LengthUnit.FEET);

        assertEquals(-6.0, result, EPSILON);
    }


    // ROUND TRIP TESTS


    @Test
    public void testConversion_RoundTrip_FeetToInchesToFeet() {

        double inches =
                QuantityMeasurementApp.QuantityLength.convert(
                        1.0,
                        QuantityMeasurementApp.LengthUnit.FEET,
                        QuantityMeasurementApp.LengthUnit.INCHES);

        double feet =
                QuantityMeasurementApp.QuantityLength.convert(
                        inches,
                        QuantityMeasurementApp.LengthUnit.INCHES,
                        QuantityMeasurementApp.LengthUnit.FEET);

        assertEquals(1.0, feet, EPSILON);
    }

    @Test
    public void testConversion_RoundTrip_YardsToFeetToYards() {

        double feet =
                QuantityMeasurementApp.QuantityLength.convert(
                        2.0,
                        QuantityMeasurementApp.LengthUnit.YARDS,
                        QuantityMeasurementApp.LengthUnit.FEET);

        double yards =
                QuantityMeasurementApp.QuantityLength.convert(
                        feet,
                        QuantityMeasurementApp.LengthUnit.FEET,
                        QuantityMeasurementApp.LengthUnit.YARDS);

        assertEquals(2.0, yards, EPSILON);
    }


    // LARGE VALUE TESTS


    @Test
    public void testConversion_LargeValue() {

        double result =
                QuantityMeasurementApp.QuantityLength.convert(
                        1000000.0,
                        QuantityMeasurementApp.LengthUnit.FEET,
                        QuantityMeasurementApp.LengthUnit.INCHES);

        assertEquals(12000000.0, result, EPSILON);
    }


    // SMALL VALUE TESTS


    @Test
    public void testConversion_SmallValue() {

        double result =
                QuantityMeasurementApp.QuantityLength.convert(
                        0.0001,
                        QuantityMeasurementApp.LengthUnit.FEET,
                        QuantityMeasurementApp.LengthUnit.INCHES);

        assertEquals(0.0012, result, 0.0001);
    }

    // INVALID UNIT TESTS


    @Test
    public void testConversion_NullSourceUnit_Throws() {

        assertThrows(
                IllegalArgumentException.class,
                () -> {

                    QuantityMeasurementApp.QuantityLength.convert(
                            1.0,
                            null,
                            QuantityMeasurementApp.LengthUnit.FEET);
                });
    }

    @Test
    public void testConversion_NullTargetUnit_Throws() {

        assertThrows(
                IllegalArgumentException.class,
                () -> {

                    QuantityMeasurementApp.QuantityLength.convert(
                            1.0,
                            QuantityMeasurementApp.LengthUnit.FEET,
                            null);
                });
    }


    // INVALID VALUE TESTS


    @Test
    public void testConversion_NaN_Throws() {

        assertThrows(
                IllegalArgumentException.class,
                () -> {

                    QuantityMeasurementApp.QuantityLength.convert(
                            Double.NaN,
                            QuantityMeasurementApp.LengthUnit.FEET,
                            QuantityMeasurementApp.LengthUnit.INCHES);
                });
    }

    @Test
    public void testConversion_PositiveInfinity_Throws() {

        assertThrows(
                IllegalArgumentException.class,
                () -> {

                    QuantityMeasurementApp.QuantityLength.convert(
                            Double.POSITIVE_INFINITY,
                            QuantityMeasurementApp.LengthUnit.FEET,
                            QuantityMeasurementApp.LengthUnit.INCHES);
                });
    }

    @Test
    public void testConversion_NegativeInfinity_Throws() {

        assertThrows(
                IllegalArgumentException.class,
                () -> {

                    QuantityMeasurementApp.QuantityLength.convert(
                            Double.NEGATIVE_INFINITY,
                            QuantityMeasurementApp.LengthUnit.FEET,
                            QuantityMeasurementApp.LengthUnit.INCHES);
                });
    }


    // EQUALITY TESTS


    @Test
    public void testEquality_FeetAndInches_Equivalent() {

        QuantityMeasurementApp.QuantityLength q1 =
                new QuantityMeasurementApp.QuantityLength(
                        1.0,
                        QuantityMeasurementApp.LengthUnit.FEET);

        QuantityMeasurementApp.QuantityLength q2 =
                new QuantityMeasurementApp.QuantityLength(
                        12.0,
                        QuantityMeasurementApp.LengthUnit.INCHES);

        assertTrue(q1.equals(q2));
    }

    @Test
    public void testEquality_YardsAndFeet_Equivalent() {

        QuantityMeasurementApp.QuantityLength q1 =
                new QuantityMeasurementApp.QuantityLength(
                        1.0,
                        QuantityMeasurementApp.LengthUnit.YARDS);

        QuantityMeasurementApp.QuantityLength q2 =
                new QuantityMeasurementApp.QuantityLength(
                        3.0,
                        QuantityMeasurementApp.LengthUnit.FEET);

        assertTrue(q1.equals(q2));
    }

    @Test
    public void testEquality_CentimetersAndInches_Equivalent() {

        QuantityMeasurementApp.QuantityLength q1 =
                new QuantityMeasurementApp.QuantityLength(
                        2.54,
                        QuantityMeasurementApp.LengthUnit.CENTIMETERS);

        QuantityMeasurementApp.QuantityLength q2 =
                new QuantityMeasurementApp.QuantityLength(
                        1.0,
                        QuantityMeasurementApp.LengthUnit.INCHES);

        assertTrue(q1.equals(q2));
    }

    @Test
    public void testEquality_DifferentValues() {

        QuantityMeasurementApp.QuantityLength q1 =
                new QuantityMeasurementApp.QuantityLength(
                        1.0,
                        QuantityMeasurementApp.LengthUnit.FEET);

        QuantityMeasurementApp.QuantityLength q2 =
                new QuantityMeasurementApp.QuantityLength(
                        2.0,
                        QuantityMeasurementApp.LengthUnit.FEET);

        assertFalse(q1.equals(q2));
    }

    @Test
    public void testEquality_SameReference() {

        QuantityMeasurementApp.QuantityLength q1 =
                new QuantityMeasurementApp.QuantityLength(
                        1.0,
                        QuantityMeasurementApp.LengthUnit.FEET);

        assertTrue(q1.equals(q1));
    }

    @Test
    public void testEquality_NullComparison() {

        QuantityMeasurementApp.QuantityLength q1 =
                new QuantityMeasurementApp.QuantityLength(
                        1.0,
                        QuantityMeasurementApp.LengthUnit.FEET);

        assertFalse(q1.equals(null));
    }


    // TOSTRING TEST


    @Test
    public void testToString() {

        QuantityMeasurementApp.QuantityLength q1 =
                new QuantityMeasurementApp.QuantityLength(
                        1.0,
                        QuantityMeasurementApp.LengthUnit.FEET);

        assertEquals(
                "1.0 FEET",
                q1.toString());
    }
}