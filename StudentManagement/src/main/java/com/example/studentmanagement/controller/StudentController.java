package com.example.studentmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.studentmanagement.dto.StudentDTO;
import com.example.studentmanagement.entity.Student;
import com.example.studentmanagement.service.StudentService;


@RestController
@RequestMapping("/student")
public class StudentController {
	@Autowired
	StudentService serv;
	@GetMapping
     public List<StudentDTO> get() {
    	 return serv.getA();
     }
	
	@PostMapping("/{teacherId}")
	public Student add(@RequestBody Student stu, @PathVariable Long teacherId) {
		return serv.add(stu,teacherId);
	}
	
	@DeleteMapping("/{id}")
    public String del(@PathVariable Long id) {
    	serv.del(id);
    	return "Deleted Successfully";
    }
	
	@PutMapping("/{id}")
	public Student update(@PathVariable Long id,@RequestBody Student stu) {
		return serv.update(id, stu);
	}
	
	@GetMapping("/mail")
	public Student findStudentByMail(@RequestParam String mail) {
	    return serv.findMail(mail);
	}
}
