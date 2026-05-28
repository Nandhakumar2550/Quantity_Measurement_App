package org.example.controller;

import io.swagger.v3.oas.annotations.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.example.dto.*;
import org.example.service.IQuantityMeasurementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/api/v1/quantities")

@Tag(
        name = "Quantity Measurements",
        description = "REST API for quantity operations"
)
public class QuantityMeasurementController {

    @Autowired
    private IQuantityMeasurementService service;

    public QuantityMeasurementController(IQuantityMeasurementService service) {
    }

    @Operation(
            summary = "Compare quantities"
    )
    @PostMapping("/compare")
    public QuantityMeasurementDTO compare(

            @Valid
            @RequestBody
            QuantityInputDTO inputDTO) {

        return service.compare(inputDTO);
    }

    @Operation(
            summary = "Convert quantities"
    )
    @PostMapping("/convert")
    public QuantityMeasurementDTO convert(

            @Valid
            @RequestBody
            QuantityInputDTO inputDTO) {

        return service.convert(inputDTO);
    }

    @Operation(
            summary = "Add quantities"
    )
    @PostMapping("/add")
    public QuantityMeasurementDTO add(

            @Valid
            @RequestBody
            QuantityInputDTO inputDTO) {

        return service.add(inputDTO);
    }

    @PostMapping("/subtract")
    public QuantityMeasurementDTO subtract(

            @RequestBody
            QuantityInputDTO inputDTO) {

        return service.subtract(inputDTO);
    }

    @PostMapping("/multiply")
    public QuantityMeasurementDTO multiply(

            @RequestBody
            QuantityInputDTO inputDTO) {

        return service.multiply(inputDTO);
    }

    @PostMapping("/divide")
    public QuantityMeasurementDTO divide(

            @RequestBody
            QuantityInputDTO inputDTO) {

        return service.divide(inputDTO);
    }

    @GetMapping("/history/operation/{operation}")
    public List<QuantityMeasurementDTO>
    historyByOperation(

            @PathVariable
            String operation) {

        return service.getHistoryByOperation(
                operation
        );
    }

    @GetMapping("/history/type/{type}")
    public List<QuantityMeasurementDTO>
    historyByType(

            @PathVariable
            String type) {

        return service.getHistoryByType(type);
    }

    @GetMapping("/history/errored")
    public List<QuantityMeasurementDTO>
    erroredHistory() {

        return service.getErroredHistory();
    }

    @GetMapping("/count/{operation}")
    public long count(

            @PathVariable
            String operation) {

        return service.getCount(operation);
    }
}
