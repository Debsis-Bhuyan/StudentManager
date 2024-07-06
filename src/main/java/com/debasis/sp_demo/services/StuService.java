package com.debasis.sp_demo.services;

import com.debasis.sp_demo.exception.StudentAlreadyExistException;
import com.debasis.sp_demo.exception.StudentNotFoundException;
import com.debasis.sp_demo.model.Student;
import com.debasis.sp_demo.repository.StudentRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StuService  implements StudentService {
    private final StudentRepo studentRepository;
    @Override
    public Student addStudent(Student student) {
        if (studentAlreadyExists(student.getEmail())){
            throw  new StudentAlreadyExistException(student.getEmail()+ " Already Exist!");
        }
        return studentRepository.save(student);
    }

    private boolean studentAlreadyExists(String email) {
        return studentRepository.findByEmail(email).isPresent();
    }

    @Override
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student updateStudent(Student student, Long id) {
        return studentRepository.findById(id).map(st-> {
            st.setFirstName(student.getFirstName());
            st.setEmail(student.getEmail());
            st.setDepartment(student.getDepartment());
            st.setLastName(student.getLastName());
            return studentRepository.save(st);
        }).orElseThrow(()-> new StudentNotFoundException("Sorry, this student could not found"));
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElseThrow(()->  new StudentNotFoundException("Sorry, No student found with this :"+ id));
    }

    @Override
    public void deleteStudentById(Long id) {
        if (!studentRepository.existsById(id)){
            throw   new StudentNotFoundException("Sorry,  student could not found");
        }
        studentRepository.deleteById(id);
    }
}
