package yte.spring.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import yte.spring.application.entity.Student;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {
	Optional<Student> findByStudentNumber(String studentNumber);
}
