package yte.spring.application.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import yte.spring.application.entity.Book;
import yte.spring.application.entity.Course;
import yte.spring.application.entity.Student;
import yte.spring.application.repository.CourseRepository;
import yte.spring.application.repository.StudentRepository;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentService {

	private final StudentRepository studentRepository;
	private final CourseRepository courseRepository;

	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	public Student getStudentById(final Long id) {
		return studentRepository.findById(id).orElse(null);
	}

	public Student addStudent(final Student student) {
		student.setEnrolledCourses(new HashSet<>());
		student.setPastCourses(new HashSet<>());
		student.setBooks(new HashSet<>());

		Book algorithmBook = new Book(null, "Introduction to Algorithms",1050L, LocalDateTime.parse("1997-01-01T00:00"));
		student.getBooks().add(algorithmBook);
		return studentRepository.save(student);
	}

	public Student updateStudent(final Student student) {
		Optional<Student> studentFromDB = studentRepository.findByStudentNumber(student.getStudentNumber());
		studentFromDB.ifPresent(value -> student.setId(value.getId()));
		return studentRepository.save(student);
	}

	public void deleteStudent(final Long id) {
		studentRepository.deleteById(id);
	}

	public Student addBook(Long studentId, Book book) {
		Student student = studentRepository.findById(studentId).get();

		student.getBooks().add(book);
		return studentRepository.save(student);
	}

	public Student addCourse(Long studentId, Long courseId) {
		Optional<Student> studentOptional = studentRepository.findById(studentId);
		Optional<Course> courseOptional = courseRepository.findById(courseId);
		if(studentOptional.isPresent() && courseOptional.isPresent()) {
			Student student = studentOptional.get();
			Course course = courseOptional.get();

			student.getEnrolledCourses().add(course);
			return studentRepository.save(student);
		}

		return null;
	}
}
