package org.example.repository;

import org.example.model.QuantityMeasurementEntity;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface QuantityMeasurementRepository
extends JpaRepository<
        QuantityMeasurementEntity,
        Long> {

    List<QuantityMeasurementEntity>
    findByOperation(
            String operation
    );

    List<QuantityMeasurementEntity>
    findByThisMeasurementType(
            String measurementType
    );

    List<QuantityMeasurementEntity>
    findByCreatedAtAfter(
            LocalDateTime date
    );

    @Query("""
            SELECT q
            FROM QuantityMeasurementEntity q
            WHERE q.operation = :operation
            AND q.error = false
            """)
    List<QuantityMeasurementEntity>
    getValidOperations(
            String operation
    );

    long countByOperationAndErrorFalse(
            String operation
    );

    List<QuantityMeasurementEntity>
    findByErrorTrue();
}
