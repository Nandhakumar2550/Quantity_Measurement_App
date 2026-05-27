package org.example.service;

import org.example.entity.QuantityMeasurementEntity;
import org.example.repository.IQuantityMeasurementRepository;

public class QuantityMeasurementServiceImpl
        implements IQuantityMeasurementService {

    private final
    IQuantityMeasurementRepository repository;

    public QuantityMeasurementServiceImpl(
            IQuantityMeasurementRepository repository) {

        this.repository = repository;
    }

    @Override
    public boolean compare(
            double value1,
            double value2) {

        boolean result =
                value1 == value2;

        repository.save(
                new QuantityMeasurementEntity(
                        "COMPARE",
                        "LENGTH",
                        value1,
                        value2,
                        String.valueOf(result)
                )
        );

        return result;
    }

    @Override
    public double add(
            double value1,
            double value2) {

        double result =
                value1 + value2;

        repository.save(
                new QuantityMeasurementEntity(
                        "ADD",
                        "LENGTH",
                        value1,
                        value2,
                        String.valueOf(result)
                )
        );

        return result;
    }
}
