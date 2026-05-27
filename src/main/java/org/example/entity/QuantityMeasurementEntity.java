package org.example.entity;

import java.time.LocalDateTime;

public class QuantityMeasurementEntity {

    private String operation;
    private String measurementType;
    private double value1;
    private double value2;
    private String result;
    private LocalDateTime createdAt;

    public QuantityMeasurementEntity(
            String operation,
            String measurementType,
            double value1,
            double value2,
            String result) {

        this.operation = operation;
        this.measurementType = measurementType;
        this.value1 = value1;
        this.value2 = value2;
        this.result = result;
        this.createdAt = LocalDateTime.now();
    }

    public String getOperation() {
        return operation;
    }

    public String getMeasurementType() {
        return measurementType;
    }

    public double getValue1() {
        return value1;
    }

    public double getValue2() {
        return value2;
    }

    public String getResult() {
        return result;
    }
}
