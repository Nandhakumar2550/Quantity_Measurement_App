package org.example.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class QuantityDTO {

    @NotNull
    private Double value;

    @NotBlank
    private String unit;

    @NotBlank
    private String measurementType;

    @AssertTrue(message =
            "Unit must be valid for the specified measurement type")
    public boolean isValidUnit() {

        return unit != null && measurementType != null;
    }
}
