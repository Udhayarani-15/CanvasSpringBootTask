package com.example.studentmanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.studentmanagement.entity.Student;

public interface StudentRepository extends JpaRepository<Student,Long>{

        @Query("select s.name from Student s")
        List<String> findName();
        
        @Query("select s from Student s where s.mail = :mail")
        Student findMail(@Param("mail") String mail);
}
