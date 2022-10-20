package com.example.deneme.entity;

import javax.persistence.*;
import java.util.List;


@Entity
public class Teacher {
    @Id
    @GeneratedValue()
    private int phoneNumber;
    private String name;
    private String email;
    private String courseName;




}
