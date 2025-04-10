package com.bright.libms.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "book_id")
    private Long id;
    @Column(nullable = false)
    private String title;
    @Column(unique = true, nullable = false)
    private String isbn;
    @ManyToMany(cascade = {CascadeType.PERSIST}, fetch = FetchType.LAZY)
    @JoinTable(
            name = "books_authors", //joining table name
            joinColumns = @JoinColumn(name="book_id"), //which entity owns the asscociation
            inverseJoinColumns = @JoinColumn(name="author_d")   //other entity, Author's PK or any other field(unique)
    )
    private List<Author> authors;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private Publisher publisher;//Book ->----||- Publisher
}
