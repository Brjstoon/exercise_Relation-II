package org.example.schoolmanagement.Service;

import lombok.RequiredArgsConstructor;
import org.example.schoolmanagement.Api.ApiException;
import org.example.schoolmanagement.DTO.IN.CourseDTOIN;
import org.example.schoolmanagement.DTO.OUT.CourseDTOut;
import org.example.schoolmanagement.Model.Course;
import org.example.schoolmanagement.Model.Teacher;
import org.example.schoolmanagement.Repository.CourseRepository;
import org.example.schoolmanagement.Repository.TeacherRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;
    private final TeacherRepository teacherRepository;


    public List<CourseDTOut> getAll(){
        List<CourseDTOut> courseDTOuts = new ArrayList<>();
        for (Course course: courseRepository.findAll()){
            courseDTOuts.add(convertToDTO(course));
        }
        return courseDTOuts;
    }

    public void addCourse(Integer id, CourseDTOIN courseDTOIN){
        Teacher teacher = teacherRepository.findTeacherById(id);
        if (teacher == null){
            throw new ApiException("teacher not found");
        }
        Course course = new Course();

        course.setName(courseDTOIN.getName());
        course.setTeacher(teacher);
        courseRepository.save(course);
    }


    public void updateCourse(Integer id, CourseDTOIN courseDTOIN){
        Course course = courseRepository.findCourseById(id);
        if (course == null){
            throw new ApiException("course not found");
        }

        course.setName(courseDTOIN.getName());
        course.setTeacher(course.getTeacher());
        courseRepository.save(course);
    }


    public void deleteCourse(Integer id) {
        Course course = courseRepository.findCourseById(id);
        if (course == null) {
            throw new ApiException("course not found");
        }
        courseRepository.deleteById(id);
    }



        public CourseDTOut convertToDTO(Course course){
        return new CourseDTOut(course.getId(), course.getName());
    }

}
