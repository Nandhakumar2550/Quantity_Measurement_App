package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    private static final double EPSILON = 0.01;

    // LITRE TO LITRE

    @Test
    public void testEquality_LitreToLitre_SameValue() {

        Quantity<VolumeUnit> q1 =
                new Quantity<>(
                        1.0,
                        VolumeUnit.LITRE);

        Quantity<VolumeUnit> q2 =
                new Quantity<>(
                        1.0,
                        VolumeUnit.LITRE);

        assertTrue(q1.equals(q2));
    }

    // LITRE TO MILLILITRE

    @Test
    public void testEquality_LitreToMillilitre_EquivalentValue() {

        Quantity<VolumeUnit> q1 =
                new Quantity<>(
                        1.0,
                        VolumeUnit.LITRE);

        Quantity<VolumeUnit> q2 =
                new Quantity<>(
                        1000.0,
                        VolumeUnit.MILLILITRE);

        assertTrue(q1.equals(q2));
    }

    // GALLON TO LITRE

    @Test
    public void testEquality_GallonToLitre_EquivalentValue() {

        Quantity<VolumeUnit> q1 =
                new Quantity<>(
                        1.0,
                        VolumeUnit.GALLON);

        Quantity<VolumeUnit> q2 =
                new Quantity<>(
                        3.78541,
                        VolumeUnit.LITRE);

        assertTrue(q1.equals(q2));
    }

    // VOLUME VS LENGTH

    @Test
    public void testEquality_VolumeVsLength_Incompatible() {

        Quantity<VolumeUnit> volume =
                new Quantity<>(
                        1.0,
                        VolumeUnit.LITRE);

        Quantity<LengthUnit> length =
                new Quantity<>(
                        1.0,
                        LengthUnit.FEET);

        assertFalse(volume.equals(length));
    }

    // VOLUME VS WEIGHT

    @Test
    public void testEquality_VolumeVsWeight_Incompatible() {

        Quantity<VolumeUnit> volume =
                new Quantity<>(
                        1.0,
                        VolumeUnit.LITRE);

        Quantity<WeightUnit> weight =
                new Quantity<>(
                        1.0,
                        WeightUnit.KILOGRAM);

        assertFalse(volume.equals(weight));
    }

    // LITRE TO MILLILITRE CONVERSION

    @Test
    public void testConversion_LitreToMillilitre() {

        Quantity<VolumeUnit> q1 =
                new Quantity<>(
                        1.0,
                        VolumeUnit.LITRE);

        Quantity<VolumeUnit> result =
                q1.convertTo(
                        VolumeUnit.MILLILITRE);

        assertEquals(
                1000.0,
                result.getValue(),
                EPSILON);
    }

    // GALLON TO LITRE CONVERSION

    @Test
    public void testConversion_GallonToLitre() {

        Quantity<VolumeUnit> q1 =
                new Quantity<>(
                        1.0,
                        VolumeUnit.GALLON);

        Quantity<VolumeUnit> result =
                q1.convertTo(
                        VolumeUnit.LITRE);

        assertEquals(
                3.78541,
                result.getValue(),
                EPSILON);
    }

    // LITRE TO GALLON CONVERSION

    @Test
    public void testConversion_LitreToGallon() {

        Quantity<VolumeUnit> q1 =
                new Quantity<>(
                        3.78541,
                        VolumeUnit.LITRE);

        Quantity<VolumeUnit> result =
                q1.convertTo(
                        VolumeUnit.GALLON);

        assertEquals(
                1.0,
                result.getValue(),
                EPSILON);
    }

    // SAME UNIT ADDITION

    @Test
    public void testAddition_SameUnit_LitrePlusLitre() {

        Quantity<VolumeUnit> q1 =
                new Quantity<>(
                        1.0,
                        VolumeUnit.LITRE);

        Quantity<VolumeUnit> q2 =
                new Quantity<>(
                        2.0,
                        VolumeUnit.LITRE);

        Quantity<VolumeUnit> result =
                q1.add(q2);

        assertEquals(
                3.0,
                result.getValue(),
                EPSILON);
    }

    // CROSS UNIT ADDITION

    @Test
    public void testAddition_CrossUnit_LitrePlusMillilitre() {

        Quantity<VolumeUnit> q1 =
                new Quantity<>(
                        1.0,
                        VolumeUnit.LITRE);

        Quantity<VolumeUnit> q2 =
                new Quantity<>(
                        1000.0,
                        VolumeUnit.MILLILITRE);

        Quantity<VolumeUnit> result =
                q1.add(q2);

        assertEquals(
                2.0,
                result.getValue(),
                EPSILON);
    }

    // EXPLICIT TARGET UNIT

    @Test
    public void testAddition_ExplicitTargetUnit_Millilitre() {

        Quantity<VolumeUnit> q1 =
                new Quantity<>(
                        1.0,
                        VolumeUnit.LITRE);

        Quantity<VolumeUnit> q2 =
                new Quantity<>(
                        1000.0,
                        VolumeUnit.MILLILITRE);

        Quantity<VolumeUnit> result =
                q1.add(
                        q2,
                        VolumeUnit.MILLILITRE);

        assertEquals(
                2000.0,
                result.getValue(),
                EPSILON);
    }

    // ZERO VALUE

    @Test
    public void testEquality_ZeroValue() {

        Quantity<VolumeUnit> q1 =
                new Quantity<>(
                        0.0,
                        VolumeUnit.LITRE);

        Quantity<VolumeUnit> q2 =
                new Quantity<>(
                        0.0,
                        VolumeUnit.MILLILITRE);

        assertTrue(q1.equals(q2));
    }

    // NEGATIVE VALUE

    @Test
    public void testEquality_NegativeVolume() {

        Quantity<VolumeUnit> q1 =
                new Quantity<>(
                        -1.0,
                        VolumeUnit.LITRE);

        Quantity<VolumeUnit> q2 =
                new Quantity<>(
                        -1000.0,
                        VolumeUnit.MILLILITRE);

        assertTrue(q1.equals(q2));
    }

    // NULL UNIT

    @Test
    public void testEquality_NullUnit() {

        assertThrows(
                IllegalArgumentException.class,
                () -> {

                    new Quantity<>(
                            1.0,
                            null);
                });
    }

    // SAME REFERENCE

    @Test
    public void testEquality_SameReference() {

        Quantity<VolumeUnit> q1 =
                new Quantity<>(
                        1.0,
                        VolumeUnit.LITRE);

        assertTrue(q1.equals(q1));
    }

    // ROUND TRIP CONVERSION

    @Test
    public void testConversion_RoundTrip() {

        Quantity<VolumeUnit> q1 =
                new Quantity<>(
                        1.5,
                        VolumeUnit.LITRE);

        Quantity<VolumeUnit> result =
                q1.convertTo(
                                VolumeUnit.MILLILITRE)
                        .convertTo(
                                VolumeUnit.LITRE);

        assertEquals(
                1.5,
                result.getValue(),
                EPSILON);
    }

    // VOLUME UNIT ENUM

    @Test
    public void testVolumeUnitEnum_GallonConstant() {

        assertEquals(
                3.78541,
                VolumeUnit.GALLON
                        .getConversionFactor(),
                EPSILON);
    }
}