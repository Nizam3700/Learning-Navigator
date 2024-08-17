package com.example.lms_project.Controller;

import com.example.lms_project.Entity.Exam;
import com.example.lms_project.Entity.Subject;
import com.example.lms_project.Service.ExamService;
import com.example.lms_project.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<Exam> getExamById(@PathVariable Long id) {
        Exam exam = examService.getExamById(id);
        return new ResponseEntity<>(exam, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Exam> AddExam(@RequestBody Exam exam) {
        Exam savedSubject = examService.save(exam);
        return new ResponseEntity<>(savedSubject, HttpStatus.CREATED);
    }

//    @PutMapping("/{id}")
//    public ResponseEntity<Subject> updateSubject(@PathVariable Long id, @RequestBody Exam exam) {
//        Exam existingexam = examService.getExamById(id);
//        existingexam.setName(exam.getName());
//        Exam updatedExam = examService.regExams(existingexam);
//        return new ResponseEntity<>(updatedSubject, HttpStatus.OK);
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteExam(@PathVariable Long id) {
        examService.deleteExam(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
