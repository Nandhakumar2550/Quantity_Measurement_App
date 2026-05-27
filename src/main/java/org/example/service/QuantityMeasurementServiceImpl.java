package org.example.service;

import org.example.dto.QuantityDTO;
import org.example.entity
        .QuantityMeasurementEntity;
import org.example.exception
        .QuantityMeasurementException;
import org.example.repository
        .IQuantityMeasurementRepository;

public class QuantityMeasurementServiceImpl
        implements
        IQuantityMeasurementService {

    private final
    IQuantityMeasurementRepository
            repository;

    public
    QuantityMeasurementServiceImpl(

            IQuantityMeasurementRepository
                    repository) {

        this.repository =
                repository;
    }

    @Override
    public QuantityMeasurementEntity
    compare(
            QuantityDTO first,
            QuantityDTO second) {

        try {

            boolean result =
                    first.getValue() ==
                            second.getValue();

            QuantityMeasurementEntity
                    entity =
                    new QuantityMeasurementEntity(

                            "COMPARE",

                            first.toString(),

                            second.toString(),

                            String.valueOf(
                                    result));

            repository.save(entity);

            return entity;

        } catch (Exception e) {

            throw new
                    QuantityMeasurementException(

                    "Comparison failed",
                    e);
        }
    }

    @Override
    public QuantityMeasurementEntity
    convert(
            QuantityDTO source,
            String targetUnit) {

        QuantityMeasurementEntity
                entity =
                new QuantityMeasurementEntity(

                        "CONVERT",

                        source.toString(),

                        targetUnit,

                        "Converted");

        repository.save(entity);

        return entity;
    }

    @Override
    public QuantityMeasurementEntity
    add(
            QuantityDTO first,
            QuantityDTO second) {

        double result =
                first.getValue() +
                        second.getValue();

        QuantityMeasurementEntity
                entity =
                new QuantityMeasurementEntity(

                        "ADD",

                        first.toString(),

                        second.toString(),

                        String.valueOf(
                                result));

        repository.save(entity);

        return entity;
    }

    @Override
    public QuantityMeasurementEntity
    subtract(
            QuantityDTO first,
            QuantityDTO second) {

        double result =
                first.getValue() -
                        second.getValue();

        QuantityMeasurementEntity
                entity =
                new QuantityMeasurementEntity(

                        "SUBTRACT",

                        first.toString(),

                        second.toString(),

                        String.valueOf(
                                result));

        repository.save(entity);

        return entity;
    }

    @Override
    public QuantityMeasurementEntity
    divide(
            QuantityDTO first,
            QuantityDTO second) {

        if (second.getValue() == 0) {

            throw new
                    QuantityMeasurementException(
                    "Cannot divide by zero");
        }

        double result =
                first.getValue() /
                        second.getValue();

        QuantityMeasurementEntity
                entity =
                new QuantityMeasurementEntity(

                        "DIVIDE",

                        first.toString(),

                        second.toString(),

                        String.valueOf(
                                result));

        repository.save(entity);

        return entity;
    }
}