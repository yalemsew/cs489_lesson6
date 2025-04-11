package com.bright.libms.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "books")
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "book_id")
    private Long id;
    @Column(nullable = false)
    private String title;
    @Column(unique = true, nullable = false, updatable = false)
    private String isbn;
    @ManyToMany(cascade = {CascadeType.PERSIST}, fetch = FetchType.LAZY)
    @JoinTable(
            name = "books_authors", //joining table name
            joinColumns = @JoinColumn(name="book_id"), //which entity owns the association
            inverseJoinColumns = @JoinColumn(name="author_id")   //other entity, Author's PK or any other field(unique)
    )
    private List<Author> authors;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private Publisher publisher;//Book ->----||- Publisher
}
