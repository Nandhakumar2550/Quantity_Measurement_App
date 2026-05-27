package org.example.controller;

import org.example.dto.QuantityDTO;
import org.example.entity.QuantityMeasurementEntity;
import org.example.service.IQuantityMeasurementService;

public class QuantityMeasurementController {

    private final
    IQuantityMeasurementService
            service;

    public
    QuantityMeasurementController(

            IQuantityMeasurementService
                    service) {

        this.service = service;
    }

    public void performComparison(
            QuantityDTO first,
            QuantityDTO second) {

        QuantityMeasurementEntity
                result =
                service.compare(
                        first,
                        second);

        displayResult(result);
    }

    public void performAddition(
            QuantityDTO first,
            QuantityDTO second) {

        QuantityMeasurementEntity
                result =
                service.add(
                        first,
                        second);

        displayResult(result);
    }

    public void performDivision(
            QuantityDTO first,
            QuantityDTO second) {

        try {

            QuantityMeasurementEntity
                    result =
                    service.divide(
                            first,
                            second);

            displayResult(result);

        } catch (Exception e) {

            System.out.println(
                    e.getMessage());
        }
    }

    private void displayResult(
            QuantityMeasurementEntity
                    entity) {

        System.out.println(entity);
    }
}