package com.example.learningmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.learningmanagementsystem.entity.Course;


public interface CourseRepository extends JpaRepository<Course,Long>{

}
