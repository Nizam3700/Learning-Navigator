package com.example.lms_project.Respository;

import com.example.lms_project.Entity.Exam;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExamRepo extends JpaRepository<Exam,Long> {
    List<Exam> findAllByExamId(Long ExamId);
}
