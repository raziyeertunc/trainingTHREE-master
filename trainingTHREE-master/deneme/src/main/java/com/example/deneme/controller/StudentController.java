package com.example.deneme.controller;

import com.example.deneme.entity.Student;
import com.example.deneme.exceptionHandling.StudentNotFoundException;
import com.example.deneme.repository.StudentRepository;
import com.example.deneme.repository.StudentRepository;
import com.example.deneme.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/students")

public class
StudentController {
    @Autowired
    private StudentRepository StudentRepository;

    @Autowired
    private StudentService studentService;

    @GetMapping()
    public Collection<Student> getAllStudents() {
        return studentService.findAll();

    }


    @GetMapping(value = "/{id}")
    public Optional<Student> getStudentById(@PathVariable("id") int id) {

        return studentService.findById(id);
    }


    @DeleteMapping(value = "/{id}")
    public void deleteStudentById(@PathVariable("id") int id, String name, String course) {
        studentService.deleteById(id);
    }


    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Student> updateStudent(@RequestBody Student student) throws StudentNotFoundException {

        Student updateStudent = studentService.findById(student.getId())
                .orElseThrow(() -> new StudentNotFoundException("Employee not exist with id: " + student.getId()));
        updateStudent.setName(student.getName());
        updateStudent.setCourse(student.getCourse());

        studentService.save(updateStudent);

        return ResponseEntity.ok(student);

    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void insertStudent(@RequestBody Student student) {

        studentService.save(student);
    }


}