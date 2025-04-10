package com.bright.libms.service.impl;

import com.bright.libms.dto.request.BookRequestDto;
import com.bright.libms.dto.response.BookResponseDto;
import com.bright.libms.mapper.BookMapper;
import com.bright.libms.model.Author;
import com.bright.libms.model.Book;
import com.bright.libms.model.Publisher;
import com.bright.libms.repository.AuthorRepository;
import com.bright.libms.repository.BookRepository;
import com.bright.libms.repository.PublisherRepository;
import com.bright.libms.service.BookService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookMapper bookMapper;//for mapper
    private final BookRepository bookRepository;//to save Book entity
    private final PublisherRepository publisherRepository;
    private final AuthorRepository authorRepository;

    @Override
    @Transactional
    public Optional<BookResponseDto> createBook(BookRequestDto bookRequestDto) {
        //check whether the book is existing or not
        Optional<Book> optionalBook = bookRepository.findByIsbn(bookRequestDto.isbn());
        if (optionalBook.isPresent()) {
            return Optional.empty();
        }
        Book mappedBook = bookMapper.bookRequestDtoToBook(bookRequestDto);
        //check whether publisher is existing or not
        if (mappedBook.getPublisher() != null) {
            Optional<Publisher> optionalPublisher =
                    publisherRepository.findByNameIgnoreCase(mappedBook.getPublisher().getName());
            if (optionalPublisher.isPresent()) {
                Publisher foundPublisher = optionalPublisher.get();
                mappedBook.getPublisher().setId(foundPublisher.getId());
            }
        }
        List<Author> resolvedAuthors = new ArrayList<>();
        //check whether authors are existing or not
        mappedBook.getAuthors().forEach(author -> {
            Optional<Author> optionalAuthor =
                    authorRepository.findByFirstNameAndLastName(author.getFirstName(), author.getLastName());
            if (optionalAuthor.isPresent()) {
                resolvedAuthors.add(optionalAuthor.get());//existing Author object
            } else {
                resolvedAuthors.add(author);
            }
        });
        mappedBook.setAuthors(resolvedAuthors);
//
        Book savedBook = bookRepository.save(mappedBook);
        return Optional.ofNullable(bookMapper.bookToBookResponseDto(savedBook));
    }

    @Override
    @Transactional
    public Optional<BookResponseDto> updateBook(String isbn, BookRequestDto bookRequestDto) {
        //check whether the book is existing or not
        Optional<Book> optionalBook = bookRepository.findByIsbn(isbn);
        if (optionalBook.isPresent()) {
            Book foundBook = optionalBook.get();
            Book mappedBook = bookMapper.bookRequestDtoToBook(bookRequestDto);
            mappedBook.setId(foundBook.getId());
            if (mappedBook.getPublisher() != null) {
                mappedBook.getPublisher().setId(foundBook.getPublisher().getId());
            }
            List<Author> resolvedAuthors = new ArrayList<>();
            mappedBook.getAuthors().forEach(author -> {
               Optional<Author> optionalAuthor =
                       authorRepository.findByFirstNameAndLastName(author.getFirstName(), author.getLastName());
               if (optionalAuthor.isPresent()) {
                   Author foundAuthor = optionalAuthor.get();
                   resolvedAuthors.add(foundAuthor);//this object has id, provided by Hibernate
               } else {
                   resolvedAuthors.add(author);
               }
            });
            mappedBook.setAuthors(resolvedAuthors);
            Book updatedBook = bookRepository.save(mappedBook);
            return Optional.ofNullable(bookMapper.bookToBookResponseDto(updatedBook));
        }
        return Optional.empty();
    }

    @Override
//    @Transactional//It leads to N+1 query problem. So it is not recommended
    //Prefer to use JPQL
    public Optional<BookResponseDto> findBookByIsbn(String isbn) {
//        Optional<Book> optionalBook = bookRepository.findByIsbn(isbn);
//        if (optionalBook.isPresent()) {
//            return Optional.ofNullable(bookMapper.bookToBookResponseDto(optionalBook.get()));
//        }
//        return Optional.empty();
        Optional<Book> optionalBook = bookRepository.findBookWithAuthorsAndPublication(isbn);
        if (optionalBook.isPresent()) {
            return Optional.ofNullable(bookMapper.bookToBookResponseDto(optionalBook.get()));
        }
        return Optional.empty();
    }

    @Override
    public void deleteBookByIsbn(String isbn) {

    }

    @Override
    public List<BookResponseDto> findAllBooks() {
        List<Book> books = bookRepository.findAllBooksWithAuthorsAndPublication();
        return bookMapper.bookToBookResponseDtoList(books);
    }
}
