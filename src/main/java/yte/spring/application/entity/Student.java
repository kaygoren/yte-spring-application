package yte.spring.application.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Student {

	@Id
	@GeneratedValue
	private Long id;

	private String firstName;
	private String lastName;
	private String email;
	private String tcKimlikNo;
	@Column(unique = true)
	private String studentNumber;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "student_id")
	private Set<Book> books;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
			name = "Past_Enrollments",
			joinColumns = @JoinColumn(name = "student_id"),
			inverseJoinColumns = @JoinColumn(name = "course_id")
	)
	private Set<Course> pastCourses;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
			name = "Current_Enrollments",
			joinColumns = @JoinColumn(name = "student_id"),
			inverseJoinColumns = @JoinColumn(name = "course_id")
	)
	private Set<Course> enrolledCourses;
}
