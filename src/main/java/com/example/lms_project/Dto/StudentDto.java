package com.example.lms_project.Dto;

import com.example.lms_project.Entity.Exam;
import com.example.lms_project.Entity.Subject;
import lombok.Data;

import java.util.List;

@Data
public class StudentDto {
        private Long studentId;
        private String studentName;
        private List<Subject> enrolledSubjects;
        private List<Exam> registeredExams;
}

