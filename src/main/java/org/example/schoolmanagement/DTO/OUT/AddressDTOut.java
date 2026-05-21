package org.example.schoolmanagement.DTO.OUT;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.schoolmanagement.Model.Teacher;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressDTOut {

    private Integer id;

    private String area;

    private String street;

    private Integer buildingNumber;

}
