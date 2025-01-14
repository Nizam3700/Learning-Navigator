package com.example.lms_project.Controller;

import com.example.lms_project.Dto.ExamResponseDto;
import com.example.lms_project.Dto.StudentDto;
import com.example.lms_project.Dto.SubjectDto;
import com.example.lms_project.Entity.Exam;
import com.example.lms_project.Entity.Subject;
import com.example.lms_project.Exception.ExamNotFoundException;
import com.example.lms_project.Exception.SubjectNotFoundException;
import com.example.lms_project.Service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/subject")
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @GetMapping
    public ResponseEntity<List<Subject>> getAllSubjects() {
        List<Subject> subjects = subjectService.getAllSubjects();
        return new ResponseEntity<>(subjects, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getSubjectById(@PathVariable Long id) {
        try {
            
            Subject subject = subjectService.getSubjectById(id);
            // Exam exam = examService.getExamById(id);
    
            // If the exam is not found, return 404 Not Found
            if (subject == null) {
                throw new ExamNotFoundException("Exam not found with id: " + id);
            }
            
        //convert enrolled students to Dtos
        List<StudentDto> studentDto = subject.getStudents().stream()
                .map(student -> new StudentDto(student.getStudentId(), student.getStudentName()))
                .collect(Collectors.toList());
        
         // Prepare the response object
        SubjectDto responseDto = new SubjectDto();
        responseDto.setSubjectId(subject.getSubjectId());
        responseDto.setSubjectName(subject.getSubjectName());
        responseDto.setEnrolledStudents(studentDto);

        return new ResponseEntity<>(responseDto, HttpStatus.OK);
        } catch (SubjectNotFoundException e) {
            throw e;
        }catch (Exception e) {
            return new ResponseEntity<>("An unexpected error occurred : " + e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<Subject> createSubject(@RequestBody Subject subject) {
        Subject savedSubject = subjectService.saveSubject(subject);
        return new ResponseEntity<>(savedSubject, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Subject> updateSubject(@PathVariable Long id, @RequestBody Subject subject) {
        Subject existingSubject = subjectService.getSubjectById(id);
        existingSubject.setSubjectName(subject.getSubjectName());
        Subject updatedSubject = subjectService.saveSubject(existingSubject);
        return new ResponseEntity<>(updatedSubject, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteSubject(@PathVariable Long id) {
        subjectService.deleteSubject(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}