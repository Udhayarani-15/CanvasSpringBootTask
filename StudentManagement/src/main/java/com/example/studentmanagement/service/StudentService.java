package com.example.studentmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.studentmanagement.dto.StudentDTO;
import com.example.studentmanagement.entity.Student;
import com.example.studentmanagement.entity.Teacher;
import com.example.studentmanagement.mapper.StudentMapper;
import com.example.studentmanagement.repository.StudentRepository;
import com.example.studentmanagement.repository.TeacherRepository;
@Service
public class StudentService {
    @Autowired
    StudentRepository repo;
    
    @Autowired
    TeacherRepository teacherRepo;
    
    @Autowired
    StudentMapper mapper;
    
    public List<StudentDTO> getA(){
    	List<Student> students = repo.findAll();
    	return students.stream()
    			.map(mapper::toDTO)
    			.toList();
    }
    public Student add(Student stu, Long teacherId) {
    	Teacher teacher = teacherRepo.findById(teacherId).orElseThrow(() ->new RuntimeException("Teacher not Found"));
    	stu.setTeacher(teacher);
		return repo.save(stu);
	}
    public String del(Long id) {
    	repo.deleteById(id);
    	return "Deleted Successfully";
    }
    public Student update(Long id,Student stu) {
    	Student s = repo.findById(id).orElseThrow(()->new RuntimeException("Student is not Found"));
    	s.setName(stu.getName());
    	s.setAge(stu.getAge());
    	s.setDepartment(stu.getDepartment());
    	s.setPhno(stu.getPhno());
    	return repo.save(s);
    }
    public Student findMail(String mail) {
        return repo.findMail(mail);
    }

}
