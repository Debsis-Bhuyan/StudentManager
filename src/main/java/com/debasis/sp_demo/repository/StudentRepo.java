package com.debasis.sp_demo.repository;

import com.debasis.sp_demo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long > {

    Optional<Student> findByEmail(String email);
}
