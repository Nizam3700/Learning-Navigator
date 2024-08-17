package com.example.lms_project.Respository;

import com.example.lms_project.Entity.Subject;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SubjectRepo extends JpaRepository<Subject, Long> {
    List<Subject> findAllBySubjectId(Long SubjectId);
}
