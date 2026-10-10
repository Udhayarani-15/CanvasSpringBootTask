package com.example.learningmanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.learningmanagementsystem.entity.Course;
import com.example.learningmanagementsystem.repository.CourseRepository;

@Service
public class CourseService {
  
	   @Autowired
	   CourseRepository repo;
	   public List<Course> get() {
			return repo.findAll();
		   }
	   public Course add(Course stu) {
			return repo.save(stu);
		}
	   public String del(Long id) {
	   	repo.deleteById(id);
	   	return "Deleted Successfully";
	   }
	   public Course update(Long id,Course cors) {
	   	Course c = repo.findById(id).orElseThrow(()->new RuntimeException("Course is not Found"));
	   	c.setCoursename(cors.getCoursename());
	   	c.setDepartment(cors.getDepartment());
	   	return repo.save(c);
	   }
}
