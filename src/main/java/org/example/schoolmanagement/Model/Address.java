package org.example.schoolmanagement.Model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Address {

    @Id
    private Integer id;

    @Column(nullable = false)
    @NotEmpty(message = "area cannot be empty")
    private String area;

    @Column(nullable = false)
    @NotEmpty(message = "street cannot be empty")
    private String street;

    @Column(nullable = false)
    @NotNull(message = "building Number cannot be empty")
    @PositiveOrZero(message = "building Number cannot be negative")
    private Integer buildingNumber;


    @OneToOne
    @MapsId
    @JoinColumn(name = "teacher_id")
    @JsonIgnore
    private Teacher teacher;

}
