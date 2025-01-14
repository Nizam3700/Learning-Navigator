package com.example.lms_project.Dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubjectDto {
    private long subjectId;
    private String subjectName;
    private List<StudentDto> enrolledStudents;

}
