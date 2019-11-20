package yte.spring.application.controller.mapper;

import org.mapstruct.Mapper;
import yte.spring.application.controller.dto.CourseDTO;
import yte.spring.application.entity.Course;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CourseMapper {


	Course dtoToEntity(CourseDTO studentDTO);
	List<Course> dtoToEntity(List<CourseDTO> studentDTO);

	CourseDTO entityToDto(Course student);
	List<CourseDTO> entityToDto(List<Course> student);
}
