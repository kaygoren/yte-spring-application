package yte.spring.application.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import yte.spring.application.entity.Book;
import yte.spring.application.entity.Course;
import yte.spring.application.validators.TcKimlikNo;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {

	private Long id;

	@Size(max = 255)
	private String firstName;
	@Size(max = 255)
	private String lastName;
	@Email
	@Size(max = 255)
	private String email;
	@TcKimlikNo
	private String tcKimlikNo;
	@Size(min = 7, max = 7)
	@NotNull
	private String studentNumber;
	private Set<Book> books;
	private Set<Course> pastCourses;
	private Set<Course> enrolledCourses;
}
