package org.example.schoolmanagement.Model;

import jakarta.persistence.*;
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
@Entity
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    @NotEmpty(message = "name cannot be empty")
    private String name;

    @Column(nullable = false)
    @Positive(message = "age cannot be zero or negative")
    @NotNull(message = "age cannot be null")
    private Integer age;

    @Column(nullable = false, unique = true)
    @Email(message = "invalid email")
    @NotEmpty(message = "email cannot be empty")
    private String email;

    @Column(nullable = false)
    @Positive(message = "salary cannot be zero or negative")
    @NotNull(message = "salary cannot be null")
    private Double salary;

    @OneToOne(mappedBy = "teacher", cascade = CascadeType.ALL)
    private Address address;

}
