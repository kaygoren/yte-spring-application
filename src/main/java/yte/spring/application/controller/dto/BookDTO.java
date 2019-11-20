package yte.spring.application.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookDTO {

	private Long id;
	@Size(max = 255)
	private String name;
	@Min(100)
	@Max(1500)
	private Long pageCount;
	@PastOrPresent
	private LocalDateTime publishDate;
}
