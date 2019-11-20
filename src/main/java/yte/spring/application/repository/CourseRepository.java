package yte.spring.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import yte.spring.application.entity.Course;

import java.util.Optional;

public interface CourseRepository extends JpaRepository<Course, Long> {
	Optional<Course> findCourseByCode(String code);
}
