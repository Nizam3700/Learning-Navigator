package com.example.lms_project.Respository;

import com.example.lms_project.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepo extends JpaRepository<Student,Long> {
    List<Student> findAllByStudentId(Long id);
}
