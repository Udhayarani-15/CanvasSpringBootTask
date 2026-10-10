package com.example.studentmanagement.mapper;

import org.mapstruct.Mapper;

import com.example.studentmanagement.dto.TeacherDTO;
import com.example.studentmanagement.entity.Teacher;

@Mapper(componentModel = "spring")
public interface TeacherMapper {
	TeacherDTO toDTO(Teacher teacher);//Entity to DTO
	
    Teacher toEntity(TeacherDTO dto);//DTO to Entity
}
