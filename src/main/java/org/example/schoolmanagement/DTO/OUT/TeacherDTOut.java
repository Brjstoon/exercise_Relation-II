package org.example.schoolmanagement.DTO.OUT;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.schoolmanagement.Model.Address;
import org.example.schoolmanagement.Model.Course;

import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeacherDTOut {

    private Integer id;

    private String name;

    private Integer age;

    private AddressDTOut addressDTOut;

    private List<CourseDTOut> courseDTOuts;

}
