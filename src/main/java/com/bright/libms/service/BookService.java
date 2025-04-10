package com.bright.libms.service;

import com.bright.libms.dto.request.BookRequestDto;
import com.bright.libms.dto.response.BookResponseDto;

import java.util.List;
import java.util.Optional;

public interface BookService {
    //Create
    Optional<BookResponseDto> createBook(BookRequestDto bookRequestDto);
    //Update
    Optional<BookResponseDto> updateBook(String isbn, BookRequestDto bookRequestDto);
    //Find by isbn
    Optional<BookResponseDto> findBookByIsbn(String isbn);
    //Delete by isbn
    void deleteBookByIsbn(String isbn);
    //Find all
    List<BookResponseDto> findAllBooks();
}
