package org.example;

import org.example.controller
        .QuantityMeasurementController;

import org.example.dto.QuantityDTO;

import org.example.entity
        .QuantityMeasurementEntity;

import org.example.repository
        .QuantityMeasurementCacheRepository;

import org.example.service
        .IQuantityMeasurementService;

import org.example.service
        .QuantityMeasurementServiceImpl;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    // ENTITY TEST

    @Test
    public void
    testQuantityEntity_Success() {

        QuantityMeasurementEntity
                entity =
                new QuantityMeasurementEntity(

                        "ADD",
                        "1 FEET",
                        "1 FEET",
                        "2 FEET");

        assertFalse(
                entity.hasError());
    }

    // ENTITY ERROR TEST

    @Test
    public void
    testQuantityEntity_Error() {

        QuantityMeasurementEntity
                entity =
                new QuantityMeasurementEntity(

                        "DIVIDE",
                        "Cannot divide by zero");

        assertTrue(
                entity.hasError());
    }

    // SERVICE ADD TEST

    @Test
    public void
    testService_Add_Success() {

        IQuantityMeasurementService
                service =
                new QuantityMeasurementServiceImpl(

                        QuantityMeasurementCacheRepository
                                .getInstance());

        QuantityDTO q1 =
                new QuantityDTO(
                        10.0,
                        "FEET",
                        "LENGTH");

        QuantityDTO q2 =
                new QuantityDTO(
                        5.0,
                        "FEET",
                        "LENGTH");

        QuantityMeasurementEntity
                result =
                service.add(
                        q1,
                        q2);

        assertEquals(
                "15.0",
                result.getResult());
    }

    // SERVICE DIVIDE TEST

    @Test
    public void
    testService_Divide_ByZero() {

        IQuantityMeasurementService
                service =
                new QuantityMeasurementServiceImpl(

                        QuantityMeasurementCacheRepository
                                .getInstance());

        QuantityDTO q1 =
                new QuantityDTO(
                        10.0,
                        "FEET",
                        "LENGTH");

        QuantityDTO q2 =
                new QuantityDTO(
                        0.0,
                        "FEET",
                        "LENGTH");

        assertThrows(
                RuntimeException.class,
                () -> service.divide(
                        q1,
                        q2));
    }

    // CONTROLLER TEST

    @Test
    public void
    testController_Initialization() {

        IQuantityMeasurementService
                service =
                new QuantityMeasurementServiceImpl(

                        QuantityMeasurementCacheRepository
                                .getInstance());

        QuantityMeasurementController
                controller =
                new QuantityMeasurementController(
                        service);

        assertNotNull(controller);
    }

    // REPOSITORY TEST

    @Test
    public void
    testRepository_SaveEntity() {

        QuantityMeasurementCacheRepository
                repository =
                QuantityMeasurementCacheRepository
                        .getInstance();

        QuantityMeasurementEntity
                entity =
                new QuantityMeasurementEntity(

                        "COMPARE",
                        "1 FEET",
                        "1 FEET",
                        "true");

        repository.save(entity);

        assertFalse(
                repository
                        .getAllMeasurements()
                        .isEmpty());
    }
}