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
public class Course {

	@Id
	@GeneratedValue
	private Long id;
	@Column(unique = true)
	private String code;
	private String name;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "bagladigim_ders_id")
	private Set<Course> prereqCourses;

	@ManyToMany(mappedBy = "pastCourses")
	private Set<Student> pastStudents;

	@ManyToMany(mappedBy = "enrolledCourses")
	private Set<Student> currentStudents;


}
