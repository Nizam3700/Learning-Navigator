package com.example.lms_project.Controller;

import com.example.lms_project.Dto.ExamResponseDto;
import com.example.lms_project.Dto.StudentDto;
import com.example.lms_project.Entity.Exam;
import com.example.lms_project.Entity.Student;
import com.example.lms_project.Entity.Subject;
import com.example.lms_project.Exception.ExamNotFoundException;
import com.example.lms_project.Service.ExamService;
import com.example.lms_project.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/exams")
public class ExamController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private ExamService examService;

    @GetMapping
    public ResponseEntity<List<Exam>> getAllExam() {
        List<Exam> exam = examService.getAllExams();
        return new ResponseEntity<>(exam, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getExamById(@PathVariable Long id) {
        try {
            
            Exam exam = examService.getExamById(id);
    
            // If the exam is not found, return 404 Not Found
            if (exam == null) {
                throw new ExamNotFoundException("Exam not found with id: " + id);
            }
            
        //convert enrolled students to Dtos
        List<StudentDto> studentDto = exam.getEnrolledStudents().stream()
                .map(student -> new StudentDto(student.getStudentId(), student.getStudentName()))
                .collect(Collectors.toList());
        
         // Prepare the response object
        ExamResponseDto responseDto = new ExamResponseDto();
        responseDto.setExamId(exam.getExamId());
        responseDto.setName(exam.getName());
        responseDto.setEnrolledStudents(studentDto);

        return new ResponseEntity<>(responseDto, HttpStatus.OK);
        } catch (ExamNotFoundException e) {
            throw e;
        }catch (Exception e) {
            return new ResponseEntity<>("An unexpected error occurred : " + e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<Exam> AddExam(@RequestBody Exam exam) {
        Exam savedSubject = examService.save(exam);
        return new ResponseEntity<>(savedSubject, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Exam> updateStudent(@PathVariable Long id, @RequestBody Exam exam) {
        exam.setExamId(id);
        Exam updateExam = examService.updateExam(exam);
        return new ResponseEntity<>(updateExam, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteExam(@PathVariable Long id) {
        examService.deleteExam(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
