package com.example.learningmanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.learningmanagementsystem.entity.Course;
import com.example.learningmanagementsystem.service.CourseService;


@RestController
@RequestMapping("/course")
public class CourseController {

	@Autowired
	CourseService serv;
	@GetMapping
     public List<Course> get() {
    	 return serv.get();
     }
	@PostMapping
	public Course add(@RequestBody Course cors) {
		return serv.add(cors);
	}
	
	@DeleteMapping("/{id}")
    public String del(@PathVariable Long id) {
    	serv.del(id);
    	return "Deleted Successfully";
    }
	
	@PutMapping("/{id}")
	public Course update(@PathVariable Long id,@RequestBody Course cors) {
		return serv.update(id, cors);
	}
}
