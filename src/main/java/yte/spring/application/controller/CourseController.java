package yte.spring.application.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import yte.spring.application.controller.dto.CourseDTO;
import yte.spring.application.controller.mapper.CourseMapper;
import yte.spring.application.entity.Course;
import yte.spring.application.service.CourseService;

import java.net.URI;
import java.util.List;

@RequestMapping("/courses")
@RestController
@RequiredArgsConstructor
public class CourseController {

	private final CourseService courseService;
	private final CourseMapper courseMapper;
	
	@GetMapping
	public ResponseEntity getAllCourses() {
		List<Course> allCourses = courseService.getAllCourses();

		return ResponseEntity.ok(courseMapper.entityToDto(allCourses));
	}

	@GetMapping("/{id}")
	public ResponseEntity getCourseById(@PathVariable Long id) {
		Course course = courseService.getCourseById(id);
		return ResponseEntity.ok(courseMapper.entityToDto(course));
	}

	@PostMapping
	public ResponseEntity addCourse(@RequestBody CourseDTO courseDTO) {
		Course addedCourse = courseService.addCourse(courseMapper.dtoToEntity(courseDTO));
		return ResponseEntity.created(URI.create("/courses"))
				.body(courseMapper.entityToDto(addedCourse));
	}

	@PutMapping
	public ResponseEntity updateCourse(@RequestBody CourseDTO courseDTO) {
		Course updatedCourse = courseService.updateCourse(courseMapper.dtoToEntity(courseDTO));
		return ResponseEntity.ok(courseMapper.entityToDto(updatedCourse));
	}

	@DeleteMapping("/{id}")
	public void deleteCourse(@PathVariable Long id) {
		courseService.deleteCourse(id);

	}
}
