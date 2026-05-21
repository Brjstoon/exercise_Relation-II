package org.example.schoolmanagement.DTO.IN;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeacherDTOIN {

    @NotEmpty(message = "name cannot be empty")
    private String name;

    @Positive(message = "age cannot be zero or negative")
    @NotNull(message = "age cannot be null")
    private Integer age;

    @Email(message = "invalid email")
    @NotEmpty(message = "email cannot be empty")
    private String email;

    @Positive(message = "salary cannot be zero or negative")
    @NotNull(message = "salary cannot be null")
    private Double salary;

}
