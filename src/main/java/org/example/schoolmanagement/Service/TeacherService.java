package org.example.schoolmanagement.Service;

import lombok.RequiredArgsConstructor;
import org.example.schoolmanagement.Api.ApiException;
import org.example.schoolmanagement.Model.Teacher;
import org.example.schoolmanagement.Repository.TeacherRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherService {

    private final TeacherRepository teacherRepository;

    public List<Teacher> getAll(){
        return teacherRepository.findAll();
    }


    public void addTeacher(Teacher teacher){
        teacherRepository.save(teacher);
    }
    public void updateTeacher(Integer id, Teacher teacher){
        Teacher oldTeacher = teacherRepository.findTeacherById(id);
        if (oldTeacher==null){
            throw new ApiException("teacher not found");
        }
        oldTeacher.setName(teacher.getName());
        oldTeacher.setAge(teacher.getAge());
        oldTeacher.setEmail(teacher.getEmail());
        oldTeacher.setSalary(teacher.getSalary());
        teacherRepository.save(oldTeacher);
    }
    public void deleteTeacher(Integer id){
        Teacher teacher = teacherRepository.findTeacherById(id);
        if (teacher==null){
            throw new ApiException("teacher not found");
        }
        teacherRepository.deleteById(id);
    }



    public Teacher getTeacher(Integer id){
        Teacher teacher = teacherRepository.findTeacherById(id);
        if (teacher==null){
            throw new ApiException("teacher not found");
        }
        return teacher;
    }

}
