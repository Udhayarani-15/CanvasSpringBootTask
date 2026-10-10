package com.example.learningmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.learningmanagementsystem.entity.Student;


public interface StudentRepository extends JpaRepository<Student,Long> {

}
