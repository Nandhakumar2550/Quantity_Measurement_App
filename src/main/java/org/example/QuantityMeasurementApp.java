package org.example;

import org.example.controller.QuantityMeasurementController;

import org.example.dto.QuantityDTO;

import org.example.repository.QuantityMeasurementCacheRepository;

import org.example.service.IQuantityMeasurementService;

import org.example.service.QuantityMeasurementServiceImpl;

public class QuantityMeasurementApp {

    public static void main(
            String[] args) {

        // REPOSITORY

        QuantityMeasurementCacheRepository
                repository =
                QuantityMeasurementCacheRepository
                        .getInstance();

        // SERVICE

        IQuantityMeasurementService
                service =
                new QuantityMeasurementServiceImpl(
                        repository);

        // CONTROLLER

        QuantityMeasurementController
                controller =
                new QuantityMeasurementController(
                        service);

        // DTO OBJECTS

        QuantityDTO feet1 =
                new QuantityDTO(
                        1.0,
                        "FEET",
                        "LENGTH");

        QuantityDTO feet2 =
                new QuantityDTO(
                        1.0,
                        "FEET",
                        "LENGTH");

        QuantityDTO temperature1 =
                new QuantityDTO(
                        100.0,
                        "CELSIUS",
                        "TEMPERATURE");

        QuantityDTO temperature2 =
                new QuantityDTO(
                        50.0,
                        "CELSIUS",
                        "TEMPERATURE");

        // OPERATIONS

        controller.performComparison(
                feet1,
                feet2);

        controller.performAddition(
                feet1,
                feet2);

        controller.performDivision(
                temperature1,
                temperature2);
    }
}