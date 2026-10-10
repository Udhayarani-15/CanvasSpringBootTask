package com.example.studentmanagement.mapper;

import org.mapstruct.Mapper;


import com.example.studentmanagement.dto.StudentDTO;
import com.example.studentmanagement.entity.Student;

@Mapper(componentModel = "spring", uses = TeacherMapper.class)
public interface StudentMapper {
     StudentDTO toDTO(Student student);//Entity to DTO
     
     Student toEntity(StudentDTO dto);//DTO to Entity
}
