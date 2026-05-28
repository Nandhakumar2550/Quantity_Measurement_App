package org.example.dto;

import lombok.Data;

@Data
public class QuantityInputDTO {

    private QuantityDTO thisQuantityDTO;

    private QuantityDTO thatQuantityDTO;
}
