package com.example.deneme.service;

import com.example.deneme.entity.Student;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public interface
StudentService {
    Optional<Student> findById(int id);

    Collection<Student> findAll();

    void deleteById(int id);

    void save(Student student);
}
