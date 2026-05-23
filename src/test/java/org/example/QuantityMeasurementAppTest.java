package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    private static final double EPSILON = 0.01;

    // LENGTH EQUALITY

    @Test
    public void testGenericQuantity_LengthOperations_Equality() {

        Quantity<LengthUnit> q1 =
                new Quantity<>(
                        1.0,
                        LengthUnit.FEET);

        Quantity<LengthUnit> q2 =
                new Quantity<>(
                        12.0,
                        LengthUnit.INCHES);

        assertTrue(q1.equals(q2));
    }

    // WEIGHT EQUALITY

    @Test
    public void testGenericQuantity_WeightOperations_Equality() {

        Quantity<WeightUnit> q1 =
                new Quantity<>(
                        1.0,
                        WeightUnit.KILOGRAM);

        Quantity<WeightUnit> q2 =
                new Quantity<>(
                        1000.0,
                        WeightUnit.GRAM);

        assertTrue(q1.equals(q2));
    }

    // LENGTH CONVERSION

    @Test
    public void testGenericQuantity_LengthOperations_Conversion() {

        Quantity<LengthUnit> q1 =
                new Quantity<>(
                        1.0,
                        LengthUnit.FEET);

        Quantity<LengthUnit> result =
                q1.convertTo(
                        LengthUnit.INCHES);

        assertEquals(
                12.0,
                result.getValue(),
                EPSILON);
    }

    // WEIGHT CONVERSION

    @Test
    public void testGenericQuantity_WeightOperations_Conversion() {

        Quantity<WeightUnit> q1 =
                new Quantity<>(
                        1.0,
                        WeightUnit.KILOGRAM);

        Quantity<WeightUnit> result =
                q1.convertTo(
                        WeightUnit.GRAM);

        assertEquals(
                1000.0,
                result.getValue(),
                EPSILON);
    }

    // LENGTH ADDITION

    @Test
    public void testGenericQuantity_LengthOperations_Addition() {

        Quantity<LengthUnit> q1 =
                new Quantity<>(
                        1.0,
                        LengthUnit.FEET);

        Quantity<LengthUnit> q2 =
                new Quantity<>(
                        12.0,
                        LengthUnit.INCHES);

        Quantity<LengthUnit> result =
                q1.add(
                        q2,
                        LengthUnit.FEET);

        assertEquals(
                2.0,
                result.getValue(),
                EPSILON);
    }

    // WEIGHT ADDITION

    @Test
    public void testGenericQuantity_WeightOperations_Addition() {

        Quantity<WeightUnit> q1 =
                new Quantity<>(
                        1.0,
                        WeightUnit.KILOGRAM);

        Quantity<WeightUnit> q2 =
                new Quantity<>(
                        1000.0,
                        WeightUnit.GRAM);

        Quantity<WeightUnit> result =
                q1.add(
                        q2,
                        WeightUnit.KILOGRAM);

        assertEquals(
                2.0,
                result.getValue(),
                EPSILON);
    }

    // CROSS CATEGORY PREVENTION

    @Test
    public void testCrossCategoryPrevention_LengthVsWeight() {

        Quantity<LengthUnit> length =
                new Quantity<>(
                        1.0,
                        LengthUnit.FEET);

        Quantity<WeightUnit> weight =
                new Quantity<>(
                        1.0,
                        WeightUnit.KILOGRAM);

        assertFalse(length.equals(weight));
    }

    // NULL UNIT

    @Test
    public void testGenericQuantity_ConstructorValidation_NullUnit() {

        assertThrows(
                IllegalArgumentException.class,
                () -> {

                    new Quantity<>(
                            1.0,
                            null);
                });
    }

    // INVALID VALUE

    @Test
    public void testGenericQuantity_ConstructorValidation_InvalidValue() {

        assertThrows(
                IllegalArgumentException.class,
                () -> {

                    new Quantity<>(
                            Double.NaN,
                            LengthUnit.FEET);
                });
    }

    // HASHCODE CONSISTENCY

    @Test
    public void testHashCode_GenericQuantity_Consistency() {

        Quantity<LengthUnit> q1 =
                new Quantity<>(
                        1.0,
                        LengthUnit.FEET);

        Quantity<LengthUnit> q2 =
                new Quantity<>(
                        12.0,
                        LengthUnit.INCHES);

        assertEquals(
                q1.hashCode(),
                q2.hashCode());
    }

    // IMMUTABILITY

    @Test
    public void testImmutability_GenericQuantity() {

        Quantity<LengthUnit> q1 =
                new Quantity<>(
                        1.0,
                        LengthUnit.FEET);

        Quantity<LengthUnit> result =
                q1.convertTo(
                        LengthUnit.INCHES);

        assertNotSame(q1, result);
    }
}