package org.example.service;

import org.example.dto.*;

import java.util.List;

public interface IQuantityMeasurementService {

    QuantityMeasurementDTO compare(
            QuantityInputDTO inputDTO
    );

    QuantityMeasurementDTO convert(
            QuantityInputDTO inputDTO
    );

    QuantityMeasurementDTO add(
            QuantityInputDTO inputDTO
    );

    QuantityMeasurementDTO subtract(
            QuantityInputDTO inputDTO
    );

    QuantityMeasurementDTO multiply(
            QuantityInputDTO inputDTO
    );

    QuantityMeasurementDTO divide(
            QuantityInputDTO inputDTO
    );

    List<QuantityMeasurementDTO>
    getHistoryByOperation(
            String operation
    );

    List<QuantityMeasurementDTO>
    getHistoryByType(
            String type
    );

    List<QuantityMeasurementDTO>
    getErroredHistory();

    long getCount(
            String operation
    );
}
