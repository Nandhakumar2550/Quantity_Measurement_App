package org.example.service;

import org.example.dto.*;
import org.example.model.QuantityMeasurementEntity;
import org.example.repository.QuantityMeasurementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuantityMeasurementServiceImpl
implements IQuantityMeasurementService {

    @Autowired
    private QuantityMeasurementRepository repository;

    @Override
    public QuantityMeasurementDTO compare(
            QuantityInputDTO inputDTO) {

        boolean result =
                inputDTO.getThisQuantityDTO().getValue()
                        .equals(
                                inputDTO
                                        .getThatQuantityDTO()
                                        .getValue()
                        );

        QuantityMeasurementEntity entity =
                QuantityMeasurementEntity.builder()
                        .thisValue(
                                inputDTO.getThisQuantityDTO().getValue()
                        )
                        .thatValue(
                                inputDTO.getThatQuantityDTO().getValue()
                        )
                        .operation("COMPARE")
                        .resultString(
                                String.valueOf(result)
                        )
                        .error(false)
                        .build();

        repository.save(entity);

        return QuantityMeasurementDTO.fromEntity(entity);
    }

    @Override
    public QuantityMeasurementDTO convert(
            QuantityInputDTO inputDTO) {

        double result =
                inputDTO.getThisQuantityDTO()
                        .getValue() * 12;

        QuantityMeasurementEntity entity =
                QuantityMeasurementEntity.builder()
                        .thisValue(
                                inputDTO.getThisQuantityDTO().getValue()
                        )
                        .operation("CONVERT")
                        .resultValue(result)
                        .error(false)
                        .build();

        repository.save(entity);

        return QuantityMeasurementDTO.fromEntity(entity);
    }

    @Override
    public QuantityMeasurementDTO add(
            QuantityInputDTO inputDTO) {

        double result =
                inputDTO.getThisQuantityDTO().getValue()
                        +
                        inputDTO.getThatQuantityDTO().getValue();

        QuantityMeasurementEntity entity =
                QuantityMeasurementEntity.builder()
                        .thisValue(
                                inputDTO.getThisQuantityDTO().getValue()
                        )
                        .thatValue(
                                inputDTO.getThatQuantityDTO().getValue()
                        )
                        .operation("ADD")
                        .resultValue(result)
                        .error(false)
                        .build();

        repository.save(entity);

        return QuantityMeasurementDTO.fromEntity(entity);
    }

    @Override
    public QuantityMeasurementDTO subtract(
            QuantityInputDTO inputDTO) {

        double result =
                inputDTO.getThisQuantityDTO().getValue()
                        -
                        inputDTO.getThatQuantityDTO().getValue();

        QuantityMeasurementEntity entity =
                QuantityMeasurementEntity.builder()
                        .operation("SUBTRACT")
                        .resultValue(result)
                        .error(false)
                        .build();

        repository.save(entity);

        return QuantityMeasurementDTO.fromEntity(entity);
    }

    @Override
    public QuantityMeasurementDTO multiply(
            QuantityInputDTO inputDTO) {

        double result =
                inputDTO.getThisQuantityDTO().getValue()
                        *
                        inputDTO.getThatQuantityDTO().getValue();

        QuantityMeasurementEntity entity =
                QuantityMeasurementEntity.builder()
                        .operation("MULTIPLY")
                        .resultValue(result)
                        .error(false)
                        .build();

        repository.save(entity);

        return QuantityMeasurementDTO.fromEntity(entity);
    }

    @Override
    public QuantityMeasurementDTO divide(
            QuantityInputDTO inputDTO) {

        double divisor =
                inputDTO.getThatQuantityDTO().getValue();

        if(divisor == 0) {

            throw new RuntimeException(
                    "Divide by zero"
            );
        }

        double result =
                inputDTO.getThisQuantityDTO().getValue()
                        / divisor;

        QuantityMeasurementEntity entity =
                QuantityMeasurementEntity.builder()
                        .operation("DIVIDE")
                        .resultValue(result)
                        .error(false)
                        .build();

        repository.save(entity);

        return QuantityMeasurementDTO.fromEntity(entity);
    }

    @Override
    public List<QuantityMeasurementDTO>
    getHistoryByOperation(
            String operation) {

        return QuantityMeasurementDTO
                .fromEntityList(
                        repository.findByOperation(operation)
                );
    }

    @Override
    public List<QuantityMeasurementDTO>
    getHistoryByType(
            String type) {

        return QuantityMeasurementDTO
                .fromEntityList(
                        repository
                                .findByThisMeasurementType(type)
                );
    }

    @Override
    public List<QuantityMeasurementDTO>
    getErroredHistory() {

        return QuantityMeasurementDTO
                .fromEntityList(
                        repository.findByErrorTrue()
                );
    }

    @Override
    public long getCount(
            String operation) {

        return repository
                .countByOperationAndErrorFalse(
                        operation
                );
    }
}
