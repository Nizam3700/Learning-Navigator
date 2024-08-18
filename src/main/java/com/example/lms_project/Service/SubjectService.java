package com.example.lms_project.Service;

import com.example.lms_project.Entity.Student;
import com.example.lms_project.Entity.Subject;
import com.example.lms_project.Exception.CustomNotFoundException;
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
        return optionalSubject.orElseThrow(() -> new CustomNotFoundException("Subject not found"));
    }

    public Subject saveSubject(Subject subject) {

        return subjectRepo.save(subject);
    }

    public Subject updateSubject(Subject subject) {
        Subject existingSubject = subjectRepo.findById(subject.getSubjectId()).orElseThrow(() -> new CustomNotFoundException("Student not found"));
        existingSubject.setSubjectName(subject.getSubjectName());
        return subjectRepo.save(existingSubject);
    }

    public void deleteSubject(Long id) {
        subjectRepo.findById(id).ifPresentOrElse(
                subjectRepo::delete,
                () -> {
                    throw new CustomNotFoundException("Student Not found");
                }
        );
    }


}
