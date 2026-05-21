package org.example.schoolmanagement.DTO.IN;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressDTOIN {


    @NotEmpty(message = "area cannot be empty")
    private String area;

    @NotEmpty(message = "street cannot be empty")
    private String street;

    @NotNull(message = "building Number cannot be empty")
    @PositiveOrZero(message = "building Number cannot be negative")
    private Integer buildingNumber;
}
