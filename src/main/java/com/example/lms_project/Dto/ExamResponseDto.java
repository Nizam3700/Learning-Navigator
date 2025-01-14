package com.example.lms_project.Dto;

import lombok.Data;

import java.util.List;

@Data
public class ExamResponseDto {
    private Long examId;
    private String name;
    private List<StudentDto> enrolledStudents;
}
