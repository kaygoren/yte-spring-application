package yte.spring.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import yte.spring.application.entity.Course;
import yte.spring.application.repository.CourseRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CourseService {

	private final CourseRepository courseRepository;

	public List<Course> getAllCourses() {
		return courseRepository.findAll();
	}

	public Course getCourseById(final Long id) {
		return courseRepository.findById(id).orElse(null);
	}

	public Course addCourse(final Course course) {
		course.setCurrentStudents(new HashSet<>());
		course.setPastStudents(new HashSet<>());
		course.setPrereqCourses(new HashSet<>());
		return courseRepository.save(course);
	}

	public Course updateCourse(final Course course) {
		Optional<Course> courseFromDB = courseRepository.findCourseByCode(course.getCode());
		courseFromDB.ifPresent(value -> course.setId(value.getId()));
		return courseRepository.save(course);
	}

	public void deleteCourse(final Long id) {
		courseRepository.deleteById(id);

	}
}
