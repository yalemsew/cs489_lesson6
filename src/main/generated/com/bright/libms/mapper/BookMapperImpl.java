package com.bright.libms.mapper;

import com.bright.libms.dto.request.AuthorRequestDto;
import com.bright.libms.dto.request.BookRequestDto;
import com.bright.libms.dto.response.AuthorResponseDto;
import com.bright.libms.dto.response.BookResponseDto;
import com.bright.libms.dto.response.PublisherResponseDto;
import com.bright.libms.model.Author;
import com.bright.libms.model.Book;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-04-10T21:02:57-0500",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.1 (Oracle Corporation)"
)
@Component
public class BookMapperImpl implements BookMapper {

    @Autowired
    private PublisherMapper publisherMapper;

    @Override
    public Book bookRequestDtoToBook(BookRequestDto bookRequestDto) {
        if ( bookRequestDto == null ) {
            return null;
        }

        Book book = new Book();

        book.setAuthors( authorRequestDtoListToAuthorList( bookRequestDto.authorRequestDtos() ) );
        book.setPublisher( publisherMapper.publisherRequestDtoToPublisher( bookRequestDto.publisherRequestDto() ) );
        book.setTitle( bookRequestDto.title() );
        book.setIsbn( bookRequestDto.isbn() );

        return book;
    }

    @Override
    public BookResponseDto bookToBookResponseDto(Book book) {
        if ( book == null ) {
            return null;
        }

        List<AuthorResponseDto> authorResponseDtos = null;
        PublisherResponseDto publisherResponseDto = null;
        Long id = null;
        String title = null;
        String isbn = null;

        authorResponseDtos = authorListToAuthorResponseDtoList( book.getAuthors() );
        publisherResponseDto = publisherMapper.publisherToPublisherResponseDto( book.getPublisher() );
        id = book.getId();
        title = book.getTitle();
        isbn = book.getIsbn();

        BookResponseDto bookResponseDto = new BookResponseDto( id, title, isbn, authorResponseDtos, publisherResponseDto );

        return bookResponseDto;
    }

    @Override
    public List<BookResponseDto> bookToBookResponseDtoList(List<Book> books) {
        if ( books == null ) {
            return null;
        }

        List<BookResponseDto> list = new ArrayList<BookResponseDto>( books.size() );
        for ( Book book : books ) {
            list.add( bookToBookResponseDto( book ) );
        }

        return list;
    }

    protected Author authorRequestDtoToAuthor(AuthorRequestDto authorRequestDto) {
        if ( authorRequestDto == null ) {
            return null;
        }

        Author author = new Author();

        author.setFirstName( authorRequestDto.firstName() );
        author.setLastName( authorRequestDto.lastName() );

        return author;
    }

    protected List<Author> authorRequestDtoListToAuthorList(List<AuthorRequestDto> list) {
        if ( list == null ) {
            return null;
        }

        List<Author> list1 = new ArrayList<Author>( list.size() );
        for ( AuthorRequestDto authorRequestDto : list ) {
            list1.add( authorRequestDtoToAuthor( authorRequestDto ) );
        }

        return list1;
    }

    protected AuthorResponseDto authorToAuthorResponseDto(Author author) {
        if ( author == null ) {
            return null;
        }

        Long id = null;
        String firstName = null;
        String lastName = null;

        id = author.getId();
        firstName = author.getFirstName();
        lastName = author.getLastName();

        AuthorResponseDto authorResponseDto = new AuthorResponseDto( id, firstName, lastName );

        return authorResponseDto;
    }

    protected List<AuthorResponseDto> authorListToAuthorResponseDtoList(List<Author> list) {
        if ( list == null ) {
            return null;
        }

        List<AuthorResponseDto> list1 = new ArrayList<AuthorResponseDto>( list.size() );
        for ( Author author : list ) {
            list1.add( authorToAuthorResponseDto( author ) );
        }

        return list1;
    }
}
