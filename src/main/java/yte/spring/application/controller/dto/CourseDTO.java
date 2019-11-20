package yte.spring.application.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import yte.spring.application.entity.Course;
import yte.spring.application.entity.Student;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseDTO {

	private Long id;
	@Size(max = 255)
	@NotNull
	private String code;
	@Size(max = 255)
	private String name;
	private Set<Course> prereqCourses;
	private Set<Student> pastStudents;
	private Set<Student> currentStudents;

}
