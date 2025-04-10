package com.bright.libms.mapper;

import com.bright.libms.dto.request.BookRequestDto;
import com.bright.libms.dto.response.BookResponseDto;
import com.bright.libms.model.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {PublisherMapper.class})
public interface BookMapper {
    @Mappings({
            @Mapping(source = "authorRequestDtos", target = "authors"),
            @Mapping(source = "publisherRequestDto", target = "publisher")
    })
    Book bookRequestDtoToBook(BookRequestDto bookRequestDto);

    @Mappings({
            @Mapping(source = "authors", target = "authorResponseDtos"),
            @Mapping(source = "publisher", target = "publisherResponseDto")
    })
    BookResponseDto bookToBookResponseDto(Book book);

    @Mappings({
            @Mapping(source = "authors", target = "authorResponseDtos"),
            @Mapping(source = "publisher", target = "publisherResponseDto")
    })
    List<BookResponseDto> bookToBookResponseDtoList(List<Book> books);
}

