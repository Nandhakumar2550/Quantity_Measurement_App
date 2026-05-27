package org.example.service;

import org.example.dto.QuantityDTO;
import org.example.entity
        .QuantityMeasurementEntity;

public interface IQuantityMeasurementService {

    QuantityMeasurementEntity
    compare(
            QuantityDTO first,
            QuantityDTO second);

    QuantityMeasurementEntity
    convert(
            QuantityDTO source,
            String targetUnit);

    QuantityMeasurementEntity
    add(
            QuantityDTO first,
            QuantityDTO second);

    QuantityMeasurementEntity
    subtract(
            QuantityDTO first,
            QuantityDTO second);

    QuantityMeasurementEntity
    divide(
            QuantityDTO first,
            QuantityDTO second);
}