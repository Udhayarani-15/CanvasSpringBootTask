package com.example.learningmanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.learningmanagementsystem.entity.Student;
import com.example.learningmanagementsystem.repository.StudentRepository;

@Service
public class StudentService {
   @Autowired
   StudentRepository repo;
   public List<Student> get() {
		return repo.findAll();
	   }
   public Student add(Student stu) {
		return repo.save(stu);
	}
   public String del(Long id) {
   	repo.deleteById(id);
   	return "Deleted Successfully";
   }
   public Student update(Long id,Student stu) {
   	Student s = repo.findById(id).orElseThrow(()->new RuntimeException("Student is not Found"));
   	s.setName(stu.getName());
   	s.setEmail(stu.getEmail());
   	s.setDepartment(stu.getDepartment());
   	return repo.save(s);
   }
 
}
