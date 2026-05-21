package org.example.schoolmanagement.DTO.IN;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseDTOIN {

    @NotEmpty(message = "name cannot be empty")
    private String name;


}
