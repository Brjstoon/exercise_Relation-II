package org.example.schoolmanagement.Service;

import lombok.RequiredArgsConstructor;
import org.example.schoolmanagement.Api.ApiException;
import org.example.schoolmanagement.DTO.IN.TeacherDTOIN;
import org.example.schoolmanagement.DTO.OUT.AddressDTOut;
import org.example.schoolmanagement.DTO.OUT.CourseDTOut;
import org.example.schoolmanagement.DTO.OUT.TeacherDTOut;
import org.example.schoolmanagement.Model.Course;
import org.example.schoolmanagement.Model.Teacher;
import org.example.schoolmanagement.Repository.TeacherRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherService {

    private final TeacherRepository teacherRepository;

    public List<TeacherDTOut> getAll(){
        List<TeacherDTOut> teacherDTOuts = new ArrayList<>();
        for (Teacher teacher : teacherRepository.findAll()){
            teacherDTOuts.add(convertToDTO(teacher));
        }
        return teacherDTOuts;
    }


    public void addTeacher(TeacherDTOIN teacherDTOIN){
        Teacher teacher = new Teacher();

        teacher.setName(teacherDTOIN.getName());
        teacher.setAge(teacherDTOIN.getAge());
        teacher.setEmail(teacherDTOIN.getEmail());
        teacher.setSalary(teacherDTOIN.getSalary());

        teacherRepository.save(teacher);
    }

    public void updateTeacher(Integer id, TeacherDTOIN teacherDTOIN){
        Teacher teacher = teacherRepository.findTeacherById(id);
        if (teacher==null){
            throw new ApiException("teacher not found");
        }
        teacher.setName(teacherDTOIN.getName());
        teacher.setAge(teacherDTOIN.getAge());
        teacher.setEmail(teacherDTOIN.getEmail());
        teacher.setSalary(teacherDTOIN.getSalary());

        teacherRepository.save(teacher);
    }

    public void deleteTeacher(Integer id){
        Teacher teacher = teacherRepository.findTeacherById(id);
        if (teacher==null){
            throw new ApiException("teacher not found");
        }
        teacherRepository.deleteById(id);
    }


    public TeacherDTOut convertToDTO(Teacher teacher) {
        AddressDTOut addressDTOut = new AddressDTOut();
        if (teacher.getAddress() != null) {
            addressDTOut.setId(teacher.getAddress().getId());
            addressDTOut.setArea(teacher.getAddress().getArea());
            addressDTOut.setStreet(teacher.getAddress().getStreet());
            addressDTOut.setBuildingNumber(teacher.getAddress().getBuildingNumber());
        }
        List<CourseDTOut> courseDTOuts = new ArrayList<>();
        for (Course course : teacher.getCourses()) {
            CourseDTOut courseDTOut = new CourseDTOut();
            courseDTOut.setId(course.getId());
            courseDTOut.setName(course.getName());
            courseDTOuts.add(courseDTOut);
        }
        return new TeacherDTOut(teacher.getId(), teacher.getName(), teacher.getAge(), addressDTOut, courseDTOuts);
    }



    public TeacherDTOut getTeacher(Integer id){
        Teacher teacher = teacherRepository.findTeacherById(id);
        if (teacher==null){
            throw new ApiException("teacher not found");
        }
        return convertToDTO(teacher);
    }

}
