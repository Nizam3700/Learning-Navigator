package com.example.lms_project.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long subjectId;
    private String subjectName;

    @JsonIgnore
    @ManyToMany(mappedBy = "enrolledSubjects")
    private List<Student> students = new ArrayList<>();

}

