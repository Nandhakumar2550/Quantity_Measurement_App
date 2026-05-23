package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    private static final double EPSILON = 0.01;

    // KILOGRAM TO KILOGRAM

    @Test
    public void testEquality_KilogramToKilogram_SameValue() {

        QuantityMeasurementApp.QuantityWeight q1 =
                new QuantityMeasurementApp.QuantityWeight(
                        1.0,
                        WeightUnit.KILOGRAM);

        QuantityMeasurementApp.QuantityWeight q2 =
                new QuantityMeasurementApp.QuantityWeight(
                        1.0,
                        WeightUnit.KILOGRAM);

        assertTrue(q1.equals(q2));
    }

    // KILOGRAM TO GRAM

    @Test
    public void testEquality_KilogramToGram_EquivalentValue() {

        QuantityMeasurementApp.QuantityWeight q1 =
                new QuantityMeasurementApp.QuantityWeight(
                        1.0,
                        WeightUnit.KILOGRAM);

        QuantityMeasurementApp.QuantityWeight q2 =
                new QuantityMeasurementApp.QuantityWeight(
                        1000.0,
                        WeightUnit.GRAM);

        assertTrue(q1.equals(q2));
    }

    // POUND TO KILOGRAM

    @Test
    public void testConversion_PoundToKilogram() {

        QuantityMeasurementApp.QuantityWeight q1 =
                new QuantityMeasurementApp.QuantityWeight(
                        2.20462,
                        WeightUnit.POUND);

        QuantityMeasurementApp.QuantityWeight result =
                q1.convertTo(
                        WeightUnit.KILOGRAM);

        assertEquals(
                1.0,
                result.getValue(),
                EPSILON);
    }

    // KILOGRAM TO POUND

    @Test
    public void testConversion_KilogramToPound() {

        QuantityMeasurementApp.QuantityWeight q1 =
                new QuantityMeasurementApp.QuantityWeight(
                        1.0,
                        WeightUnit.KILOGRAM);

        QuantityMeasurementApp.QuantityWeight result =
                q1.convertTo(
                        WeightUnit.POUND);

        assertEquals(
                2.20462,
                result.getValue(),
                EPSILON);
    }

    // SAME UNIT ADDITION

    @Test
    public void testAddition_SameUnit_KilogramPlusKilogram() {

        QuantityMeasurementApp.QuantityWeight q1 =
                new QuantityMeasurementApp.QuantityWeight(
                        1.0,
                        WeightUnit.KILOGRAM);

        QuantityMeasurementApp.QuantityWeight q2 =
                new QuantityMeasurementApp.QuantityWeight(
                        2.0,
                        WeightUnit.KILOGRAM);

        QuantityMeasurementApp.QuantityWeight result =
                q1.add(q2);

        assertEquals(
                3.0,
                result.getValue(),
                EPSILON);
    }

    // CROSS UNIT ADDITION

    @Test
    public void testAddition_CrossUnit_KilogramPlusGram() {

        QuantityMeasurementApp.QuantityWeight q1 =
                new QuantityMeasurementApp.QuantityWeight(
                        1.0,
                        WeightUnit.KILOGRAM);

        QuantityMeasurementApp.QuantityWeight q2 =
                new QuantityMeasurementApp.QuantityWeight(
                        1000.0,
                        WeightUnit.GRAM);

        QuantityMeasurementApp.QuantityWeight result =
                q1.add(q2);

        assertEquals(
                2.0,
                result.getValue(),
                EPSILON);
    }

    // ADDITION WITH TARGET UNIT

    @Test
    public void testAddition_ExplicitTargetUnit_Kilogram() {

        QuantityMeasurementApp.QuantityWeight q1 =
                new QuantityMeasurementApp.QuantityWeight(
                        1.0,
                        WeightUnit.KILOGRAM);

        QuantityMeasurementApp.QuantityWeight q2 =
                new QuantityMeasurementApp.QuantityWeight(
                        1000.0,
                        WeightUnit.GRAM);

        QuantityMeasurementApp.QuantityWeight result =
                q1.add(
                        q2,
                        WeightUnit.GRAM);

        assertEquals(
                2000.0,
                result.getValue(),
                EPSILON);
    }

    // ZERO VALUE

    @Test
    public void testEquality_ZeroValue() {

        QuantityMeasurementApp.QuantityWeight q1 =
                new QuantityMeasurementApp.QuantityWeight(
                        0.0,
                        WeightUnit.KILOGRAM);

        QuantityMeasurementApp.QuantityWeight q2 =
                new QuantityMeasurementApp.QuantityWeight(
                        0.0,
                        WeightUnit.GRAM);

        assertTrue(q1.equals(q2));
    }

    // NEGATIVE VALUE

    @Test
    public void testEquality_NegativeWeight() {

        QuantityMeasurementApp.QuantityWeight q1 =
                new QuantityMeasurementApp.QuantityWeight(
                        -1.0,
                        WeightUnit.KILOGRAM);

        QuantityMeasurementApp.QuantityWeight q2 =
                new QuantityMeasurementApp.QuantityWeight(
                        -1000.0,
                        WeightUnit.GRAM);

        assertTrue(q1.equals(q2));
    }

    // NULL UNIT

    @Test
    public void testEquality_NullUnit() {

        assertThrows(
                IllegalArgumentException.class,
                () -> {

                    new QuantityMeasurementApp.QuantityWeight(
                            1.0,
                            null);
                });
    }

    // SAME REFERENCE

    @Test
    public void testEquality_SameReference() {

        QuantityMeasurementApp.QuantityWeight q1 =
                new QuantityMeasurementApp.QuantityWeight(
                        1.0,
                        WeightUnit.KILOGRAM);

        assertTrue(q1.equals(q1));
    }

    // NULL COMPARISON

    @Test
    public void testEquality_NullComparison() {

        QuantityMeasurementApp.QuantityWeight q1 =
                new QuantityMeasurementApp.QuantityWeight(
                        1.0,
                        WeightUnit.KILOGRAM);

        assertFalse(q1.equals(null));
    }
}