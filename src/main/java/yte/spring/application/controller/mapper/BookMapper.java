package yte.spring.application.controller.mapper;

import org.mapstruct.Mapper;
import yte.spring.application.controller.dto.BookDTO;
import yte.spring.application.entity.Book;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookMapper {

	Book dtoToEntity(BookDTO studentDTO);
	List<Book> dtoToEntity(List<BookDTO> studentDTO);

	BookDTO entityToDto(Book student);
	List<BookDTO> entityToDto(List<Book> student);
}
