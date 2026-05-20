package org.example.schoolmanagement.Controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.schoolmanagement.Api.ApiResponse;
import org.example.schoolmanagement.Model.Teacher;
import org.example.schoolmanagement.Service.TeacherService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/teacher")
@RequiredArgsConstructor
public class TeacherController {

    private final TeacherService teacherService;

    @GetMapping("/get")
    public ResponseEntity<?> getTeachers() {
        return ResponseEntity.status(200).body(teacherService.getAll());
    }

    @PostMapping("/add")
    public ResponseEntity<?> addTeacher(@RequestBody @Valid Teacher teacher) {
        teacherService.addTeacher(teacher);
        return ResponseEntity.status(200).body(new ApiResponse("teacher added successfully"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateTeacher(@PathVariable Integer id, @RequestBody @Valid Teacher teacher) {
        teacherService.updateTeacher(id, teacher);
        return ResponseEntity.status(200).body(new ApiResponse("teacher updated successfully"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteTeacher(@PathVariable Integer id) {
        teacherService.deleteTeacher(id);
        return ResponseEntity.status(200).body(new ApiResponse("teacher deleted successfully"));
    }



    @GetMapping("/get-teacher/{id}")
    public ResponseEntity<?> getTeacher(@PathVariable Integer id){
        return ResponseEntity.status(200).body(teacherService.getTeacher(id));
    }

}