package org.example.service;

public interface IQuantityMeasurementService {

    boolean compare(
            double value1,
            double value2
    );

    double add(
            double value1,
            double value2
    );
}
