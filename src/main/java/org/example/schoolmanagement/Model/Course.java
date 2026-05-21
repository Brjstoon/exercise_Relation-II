package org.example.schoolmanagement.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "courses")
public class Course {

    @Id
    private Integer id;

    @Column(nullable = false)
    private String name;


    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

}
