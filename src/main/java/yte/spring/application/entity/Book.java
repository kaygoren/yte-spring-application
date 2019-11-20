package yte.spring.application.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Book {

	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private Long pageCount;
	private LocalDateTime publishDate;

}
