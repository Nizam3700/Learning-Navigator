package com.example.lms_project.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;

    private String studentName;

    @ManyToMany
    private Set<Subject> enrolledSubjects = new HashSet<>();

    @ManyToMany
    private Set<Exam> registeredExams = new HashSet<>();
}
