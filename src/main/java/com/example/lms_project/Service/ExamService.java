package com.example.lms_project.Service;

import com.example.lms_project.Entity.Exam;
import com.example.lms_project.Entity.Student;
import com.example.lms_project.Entity.Subject;
import com.example.lms_project.Respository.ExamRepo;
import com.example.lms_project.Respository.StudentRepo;
import com.example.lms_project.Respository.SubjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ExamService {

    @Autowired
    private StudentRepo studentRepo;
    @Autowired
    private ExamRepo examRepo;

    public Exam save(Exam exam) {
        examRepo.save(exam);
        return exam;
    }

    public List<Exam> getAllExams() {
        return examRepo.findAll();
    }

    public Exam getExamById(Long id) {
        return examRepo.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));
    }

    public Student getStudentById(Long id) {
        return studentRepo.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));
    }

    public Student regExams(Long studentId, Long subjectId) {
        Student student = getStudentById(studentId);
        Exam exam = examRepo.findById(subjectId).orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "exam not found"
        ));
        student.getRegisteredExams().add(exam);
        return studentRepo.save(student);
    }

    public void deleteExam(Long id) {
        examRepo.deleteById(id);
    }
}
