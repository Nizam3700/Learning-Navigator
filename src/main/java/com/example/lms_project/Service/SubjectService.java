package com.example.lms_project.Service;

import com.example.lms_project.Entity.Subject;
import com.example.lms_project.Respository.SubjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectService {

    @Autowired
    private SubjectRepo subjectRepo;

    public List<Subject> getAllSubjects() {
        return subjectRepo.findAll();
    }

    public Subject getSubjectById(Long id) {
        Optional<Subject> optionalSubject = subjectRepo.findById(id);
        return optionalSubject.orElseThrow(() -> new RuntimeException("Subject not found"));
    }

    public Subject saveSubject(Subject subject) {

        return subjectRepo.save(subject);
    }

    public void deleteSubject(Long id) {
        subjectRepo.deleteById(id);
    }
}
