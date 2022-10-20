package com.example.deneme.service.impl;

import com.example.deneme.entity.Student;
import com.example.deneme.repository.StudentRepository;
import com.example.deneme.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
     private StudentRepository studentRepository;

    @Override
    public Optional<Student> findById(int id) {
        return studentRepository.findById(id);

    }

    @Override
    public Collection<Student> findAll() {
       return  studentRepository.findAll();

    }

    @Override
    public void deleteById(int id) {
        studentRepository.deleteById(id);

    }

    @Override
    public void save(Student student) {
        studentRepository.save(student);
    }
}
