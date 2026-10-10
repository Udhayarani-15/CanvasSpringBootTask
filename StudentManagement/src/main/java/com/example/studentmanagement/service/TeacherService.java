package com.example.studentmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.studentmanagement.dto.TeacherDTO;
import com.example.studentmanagement.entity.Student;
import com.example.studentmanagement.entity.Teacher;
import com.example.studentmanagement.mapper.TeacherMapper;
import com.example.studentmanagement.repository.TeacherRepository;
@Service
public class TeacherService {
    @Autowired
    TeacherRepository repo;
    
    @Autowired
    TeacherMapper mapper;
    public List<TeacherDTO> getA(){
    	List<Teacher> teachers = repo.findAll();
    	return teachers.stream()
    			.map(mapper::toDTO)
    			.toList();
    }
    public Teacher add(Teacher teach) {
		return repo.save(teach);
	}
    public Teacher update(Long id,Teacher teach) {
    	Teacher t = repo.findById(id).orElseThrow(()->new RuntimeException("Teacher is not Found"));
    	t.setName(teach.getName());
    	t.setAge(teach.getAge());
    	t.setDepartment(teach.getDepartment());
    	t.setPhno(teach.getPhno());
    	return repo.save(t);
    }
    public String del(Long id) {
    	repo.deleteById(id);
    	return "Deleted Successfully";
    }
}
