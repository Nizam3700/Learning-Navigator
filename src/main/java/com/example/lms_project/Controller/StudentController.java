package com.example.lms_project.Controller;

import com.example.lms_project.Entity.Student;
import com.example.lms_project.Respository.StudentRepo;
import com.example.lms_project.Service.ExamService;
import com.example.lms_project.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private ExamService examService;

    @PostMapping
    public ResponseEntity<Student> saveStudent(@RequestBody Student student){
        Student saved = studentService.save(student);
        return new ResponseEntity<>(saved,HttpStatus.CREATED);
    }

    @GetMapping
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long studentId){
        Student student = studentService.getStudentById(studentId);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @PutMapping("/{studentId}/enrollsubject/{subjectId}")
    public ResponseEntity<Student> enrolledSubject(
            @PathVariable Long studentId,
            @PathVariable Long subjectId )
    {
        Student student = studentService.enrollSubject(studentId, subjectId);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @PutMapping("/{studentId}/regexam/{examId}")
    public ResponseEntity<Student> regexam(
            @PathVariable Long studentId,
            @PathVariable Long  examId)
    {
        Student student = examService.regExams(studentId, examId);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @DeleteMapping("/{studentId}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long studentId){
        studentService.deleteStudent(studentId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id,@RequestBody Student student){
        student.setStudentId(id);
        Student updateStudent = studentService.updateStudent(student);
        return new ResponseEntity<>(updateStudent,HttpStatus.OK);
    }
}
