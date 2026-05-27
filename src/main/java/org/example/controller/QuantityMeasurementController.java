package org.example.controller;

import org.example.service.IQuantityMeasurementService;

public class QuantityMeasurementController {

    private final
    IQuantityMeasurementService service;

    public QuantityMeasurementController(
            IQuantityMeasurementService service) {

        this.service = service;
    }

    public boolean compare(
            double value1,
            double value2) {

        return service.compare(
                value1,
                value2
        );
    }

    public double add(
            double value1,
            double value2) {

        return service.add(
                value1,
                value2
        );
    }
}
