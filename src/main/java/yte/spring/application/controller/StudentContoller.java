package yte.spring.application.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import yte.spring.application.controller.dto.BookDTO;
import yte.spring.application.controller.dto.StudentDTO;
import yte.spring.application.controller.mapper.BookMapper;
import yte.spring.application.controller.mapper.StudentMapper;
import yte.spring.application.entity.Student;
import yte.spring.application.service.StudentService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentContoller {

	private final StudentService studentService;
	private final StudentMapper studentMapper;
	private final BookMapper bookMapper;

	@GetMapping
	public ResponseEntity getAllStudents() {
		List<Student> allStudents = studentService.getAllStudents();

		return ResponseEntity.ok(studentMapper.entityToDto(allStudents));
	}

	@GetMapping("/{id}")
	public ResponseEntity getStudentById(@PathVariable Long id) {
		Student student = studentService.getStudentById(id);
		return ResponseEntity.ok(studentMapper.entityToDto(student));
	}

	@PostMapping
	public ResponseEntity addStudent(@RequestBody StudentDTO studentDTO) {
		Student addedStudent = studentService.addStudent(studentMapper.dtoToEntity(studentDTO));
		return ResponseEntity.created(URI.create("/students"))
				.body(studentMapper.entityToDto(addedStudent));
	}

	@PutMapping
	public ResponseEntity updateStudent(@RequestBody StudentDTO studentDTO) {
		Student updatedStudent = studentService.updateStudent(studentMapper.dtoToEntity(studentDTO));
		return ResponseEntity.ok(studentMapper.entityToDto(updatedStudent));
	}

	@DeleteMapping("/{id}")
	public void deleteStudent(@PathVariable Long id) {
		studentService.deleteStudent(id);

	}

	@PostMapping("/{studentId}/books")
	public ResponseEntity addBook(@PathVariable Long studentId, @RequestBody BookDTO bookDTO) {
		Student updatedStudent = studentService.addBook(studentId, bookMapper.dtoToEntity(bookDTO));

		return ResponseEntity.ok(studentMapper.entityToDto(updatedStudent));
	}

	@PostMapping("/{studentId}/courses")
	public Student addCourse(@PathVariable Long studentId, @RequestParam Long courseId) {
		return studentService.addCourse(studentId,courseId);
	}
}
