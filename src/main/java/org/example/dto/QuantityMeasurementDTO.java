package org.example.dto;

import lombok.*;
import org.example.model.QuantityMeasurementEntity;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QuantityMeasurementDTO {

    private Double thisValue;

    private String thisUnit;

    private String thisMeasurementType;

    private Double thatValue;

    private String thatUnit;

    private String thatMeasurementType;

    private String operation;

    private String resultString;

    private Double resultValue;

    private String resultUnit;

    private String resultMeasurementType;

    private String errorMessage;

    private boolean error;

    public static QuantityMeasurementDTO
    fromEntity(
            QuantityMeasurementEntity entity) {

        return QuantityMeasurementDTO.builder()
                .thisValue(entity.getThisValue())
                .thisUnit(entity.getThisUnit())
                .thisMeasurementType(
                        entity.getThisMeasurementType()
                )
                .thatValue(entity.getThatValue())
                .thatUnit(entity.getThatUnit())
                .thatMeasurementType(
                        entity.getThatMeasurementType()
                )
                .operation(entity.getOperation())
                .resultString(entity.getResultString())
                .resultValue(entity.getResultValue())
                .resultUnit(entity.getResultUnit())
                .resultMeasurementType(
                        entity.getResultMeasurementType()
                )
                .errorMessage(entity.getErrorMessage())
                .error(entity.isError())
                .build();
    }

    public QuantityMeasurementEntity toEntity() {

        return QuantityMeasurementEntity.builder()
                .thisValue(thisValue)
                .thisUnit(thisUnit)
                .thisMeasurementType(thisMeasurementType)
                .thatValue(thatValue)
                .thatUnit(thatUnit)
                .thatMeasurementType(thatMeasurementType)
                .operation(operation)
                .resultString(resultString)
                .resultValue(resultValue)
                .resultUnit(resultUnit)
                .resultMeasurementType(resultMeasurementType)
                .errorMessage(errorMessage)
                .error(error)
                .build();
    }

    public static List<QuantityMeasurementDTO>
    fromEntityList(
            List<QuantityMeasurementEntity> entities) {

        return entities.stream()
                .map(
                        QuantityMeasurementDTO::fromEntity
                )
                .toList();
    }
}
