package com.debasis.sp_demo.services;

import com.debasis.sp_demo.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;

public interface StudentService {
    Student addStudent(Student student);
    List<Student> getStudents();
    Student updateStudent(Student student, Long id);
    Student getStudentById(Long id);
    void deleteStudentById(Long id);

}
