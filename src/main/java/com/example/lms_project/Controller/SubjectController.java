package com.example.lms_project.Controller;

import com.example.lms_project.Entity.Subject;
import com.example.lms_project.Service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<Subject> getSubjectById(@PathVariable Long id) {
        Subject subject = subjectService.getSubjectById(id);
        return new ResponseEntity<>(subject, HttpStatus.OK);
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