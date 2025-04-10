package com.bright.libms.repository;

import com.bright.libms.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {
    Optional<Book> findByIsbn(String isbn);
    void deleteByIsbn(String isbn);
    List<Book> findByTitle(String title);//here it may return a collection of books
    @Query("""
        SELECT b FROM Book b 
            JOIN FETCH b.authors
                JOIN FETCH b.publisher 
                    WHERE b.isbn = :isbn
    """)
    Optional<Book> findBookWithAuthorsAndPublication(@Param("isbn") String isbn);

    @Query("""
    select b from Book b
        left join fetch b.authors
            left join fetch b.publisher
    """)
    List<Book> findAllBooksWithAuthorsAndPublication();
}

/***
 * @Query("SELECT b FROM Book b JOIN FETCH b.authors WHERE b.isbn = :isbn")
 */
