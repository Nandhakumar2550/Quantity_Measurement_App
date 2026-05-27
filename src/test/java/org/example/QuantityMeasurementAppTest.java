package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    private static final double EPSILON =
            0.01;

    // CELSIUS TO FAHRENHEIT

    @Test
    public void testTemperatureEquality_CelsiusToFahrenheit() {

        Quantity<TemperatureUnit> celsius =
                new Quantity<>(
                        0.0,
                        TemperatureUnit.CELSIUS);

        Quantity<TemperatureUnit> fahrenheit =
                new Quantity<>(
                        32.0,
                        TemperatureUnit.FAHRENHEIT);

        assertTrue(
                celsius.equals(
                        fahrenheit));
    }

    // CELSIUS TO KELVIN

    @Test
    public void testTemperatureEquality_CelsiusToKelvin() {

        Quantity<TemperatureUnit> celsius =
                new Quantity<>(
                        0.0,
                        TemperatureUnit.CELSIUS);

        Quantity<TemperatureUnit> kelvin =
                new Quantity<>(
                        273.15,
                        TemperatureUnit.KELVIN);

        assertTrue(
                celsius.equals(
                        kelvin));
    }

    // CONVERSION TEST

    @Test
    public void testTemperatureConversion_CelsiusToFahrenheit() {

        Quantity<TemperatureUnit> boiling =
                new Quantity<>(
                        100.0,
                        TemperatureUnit.CELSIUS);

        Quantity<TemperatureUnit> result =
                boiling.convertTo(
                        TemperatureUnit.FAHRENHEIT);

        assertEquals(
                212.0,
                result.getValue(),
                EPSILON);
    }

    // NEGATIVE TEMPERATURE

    @Test
    public void testTemperatureConversion_Negative40Equal() {

        Quantity<TemperatureUnit> celsius =
                new Quantity<>(
                        -40.0,
                        TemperatureUnit.CELSIUS);

        Quantity<TemperatureUnit> fahrenheit =
                new Quantity<>(
                        -40.0,
                        TemperatureUnit.FAHRENHEIT);

        assertTrue(
                celsius.equals(
                        fahrenheit));
    }

    // UNSUPPORTED ADDITION

    @Test
    public void testTemperatureUnsupportedOperation_Add() {

        Quantity<TemperatureUnit> t1 =
                new Quantity<>(
                        100.0,
                        TemperatureUnit.CELSIUS);

        Quantity<TemperatureUnit> t2 =
                new Quantity<>(
                        50.0,
                        TemperatureUnit.CELSIUS);

        assertThrows(
                UnsupportedOperationException.class,
                () -> t1.add(t2));
    }

    // UNSUPPORTED SUBTRACTION

    @Test
    public void testTemperatureUnsupportedOperation_Subtract() {

        Quantity<TemperatureUnit> t1 =
                new Quantity<>(
                        100.0,
                        TemperatureUnit.CELSIUS);

        Quantity<TemperatureUnit> t2 =
                new Quantity<>(
                        50.0,
                        TemperatureUnit.CELSIUS);

        assertThrows(
                UnsupportedOperationException.class,
                () -> t1.subtract(t2));
    }

    // UNSUPPORTED DIVISION

    @Test
    public void testTemperatureUnsupportedOperation_Divide() {

        Quantity<TemperatureUnit> t1 =
                new Quantity<>(
                        100.0,
                        TemperatureUnit.CELSIUS);

        Quantity<TemperatureUnit> t2 =
                new Quantity<>(
                        50.0,
                        TemperatureUnit.CELSIUS);

        assertThrows(
                UnsupportedOperationException.class,
                () -> t1.divide(t2));
    }

    // CROSS CATEGORY CHECK

    @Test
    public void testTemperatureVsLengthIncompatibility() {

        Quantity<TemperatureUnit> temperature =
                new Quantity<>(
                        100.0,
                        TemperatureUnit.CELSIUS);

        Quantity<LengthUnit> length =
                new Quantity<>(
                        100.0,
                        LengthUnit.FEET);

        assertFalse(
                temperature.equals(
                        length));
    }

    // OPERATION SUPPORT

    @Test
    public void testOperationSupportMethods_TemperatureUnitAddition() {

        assertFalse(
                TemperatureUnit.CELSIUS
                        .supportsArithmetic());
    }

    // ROUND TRIP CONVERSION

    @Test
    public void testTemperatureConversion_RoundTrip() {

        Quantity<TemperatureUnit> original =
                new Quantity<>(
                        50.0,
                        TemperatureUnit.CELSIUS);

        Quantity<TemperatureUnit> converted =
                original.convertTo(
                        TemperatureUnit.FAHRENHEIT);

        Quantity<TemperatureUnit> result =
                converted.convertTo(
                        TemperatureUnit.CELSIUS);

        assertEquals(
                50.0,
                result.getValue(),
                EPSILON);
    }
}