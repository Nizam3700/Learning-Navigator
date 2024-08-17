package com.example.lms_project.Service;

import com.example.lms_project.Entity.Student;
import com.example.lms_project.Entity.Subject;
import com.example.lms_project.Respository.StudentRepo;
import com.example.lms_project.Respository.SubjectRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    private SubjectRepo subjectRepo;

    public Student save(Student student) {
        studentRepo.save(student);
        return student;
    }

    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }

    public Student getStudentById(Long id) {
        return studentRepo.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));
    }

    public void deleteStudent(Long id) {
        studentRepo.deleteById(id);
    }

    @Transactional
    public Student enrollSubject(Long studentId, Long subjectId) {
        Student student = getStudentById(studentId);
        Subject subject = subjectRepo.findById(subjectId).orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Subject not found"
        ));
        student.getEnrolledSubjects().add(subject);
        return studentRepo.save(student);
    }
}
