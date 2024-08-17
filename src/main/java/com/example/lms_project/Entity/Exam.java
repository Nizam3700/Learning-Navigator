package com.example.lms_project.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import javax.security.auth.Subject;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
public class Exam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long examId;
    private String name;

    @ManyToMany(mappedBy = "registeredExams")
    private Set<Student> enrolledStudents = new HashSet<>();
}
