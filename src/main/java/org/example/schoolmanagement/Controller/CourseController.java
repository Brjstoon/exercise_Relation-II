package org.example.schoolmanagement.Controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.schoolmanagement.Api.ApiResponse;
import org.example.schoolmanagement.DTO.IN.CourseDTOIN;
import org.example.schoolmanagement.Service.CourseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/course")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @GetMapping("/get")
    public ResponseEntity<?> getCourses() {
        return ResponseEntity.status(200).body(courseService.getAll());
    }

    @PostMapping("/add/{teacher_id}")
    public ResponseEntity<?> addCourse(@PathVariable Integer teacher_id, @RequestBody @Valid CourseDTOIN courseDTOIN) {
        courseService.addCourse(teacher_id, courseDTOIN);
        return ResponseEntity.status(200).body(new ApiResponse("course added successfully"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateCourse(@PathVariable Integer id, @RequestBody @Valid CourseDTOIN courseDTOIN) {
        courseService.updateCourse(id, courseDTOIN);
        return ResponseEntity.status(200).body(new ApiResponse("course updated successfully"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCourse(@PathVariable Integer id) {
        courseService.deleteCourse(id);
        return ResponseEntity.status(200).body(new ApiResponse("course deleted successfully"));
    }

}