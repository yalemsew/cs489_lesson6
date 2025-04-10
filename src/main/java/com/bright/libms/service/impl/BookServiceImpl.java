package com.bright.libms.service.impl;

import com.bright.libms.dto.request.BookRequestDto;
import com.bright.libms.dto.response.BookResponseDto;
import com.bright.libms.mapper.BookMapper;
import com.bright.libms.repository.BookRepository;
import com.bright.libms.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookMapper bookMapper;
    private final BookRepository bookRepository;

    @Override
    public Optional<BookResponseDto> createBook(BookRequestDto bookRequestDto) {
        return Optional.empty();
    }

    @Override
    public Optional<BookResponseDto> updateBook(String isbn, BookRequestDto bookRequestDto) {
        return Optional.empty();
    }

    @Override
    public Optional<BookResponseDto> findBookByIsbn(String isbn) {
        return Optional.empty();
    }

    @Override
    public void deleteBookByIsbn(String isbn) {

    }

    @Override
    public List<BookResponseDto> findAllBooks() {
        return List.of();
    }
}
