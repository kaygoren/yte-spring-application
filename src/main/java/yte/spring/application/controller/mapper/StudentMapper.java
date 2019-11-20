package yte.spring.application.controller.mapper;

import org.mapstruct.Mapper;
import yte.spring.application.controller.dto.StudentDTO;
import yte.spring.application.entity.Student;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StudentMapper {
	Student dtoToEntity(StudentDTO studentDTO);
	List<Student> dtoToEntity(List<StudentDTO> studentDTO);

	StudentDTO entityToDto(Student student);
	List<StudentDTO> entityToDto(List<Student> student);


}
