package com.example.studentmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.studentmanagement.entity.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher,Long>{

}
