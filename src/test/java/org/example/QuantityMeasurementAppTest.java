package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    @Test
    public void testFeetEquality_SameValue() {

        assertTrue(
                QuantityMeasurementApp
                        .checkFeetEquality(1.0, 1.0));
    }

    @Test
    public void testFeetEquality_DifferentValue() {

        assertFalse(
                QuantityMeasurementApp
                        .checkFeetEquality(1.0, 2.0));
    }

    @Test
    public void testInchesEquality_SameValue() {

        assertTrue(
                QuantityMeasurementApp
                        .checkInchesEquality(1.0, 1.0));
    }

    @Test
    public void testInchesEquality_DifferentValue() {

        assertFalse(
                QuantityMeasurementApp
                        .checkInchesEquality(1.0, 2.0));
    }

    @Test
    public void testEquality_NullComparison() {

        QuantityMeasurementApp.Feet f1 =
                new QuantityMeasurementApp.Feet(1.0);

        assertFalse(f1.equals(null));
    }

    @Test
    public void testEquality_NonNumericInput() {

        QuantityMeasurementApp.Inches i1 =
                new QuantityMeasurementApp.Inches(1.0);

        assertFalse(i1.equals("abc"));
    }

    @Test
    public void testEquality_SameReference() {

        QuantityMeasurementApp.Feet f1 =
                new QuantityMeasurementApp.Feet(1.0);

        assertTrue(f1.equals(f1));
    }
}
