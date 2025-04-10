package com.bright.libms.dto.request;

import java.util.List;

public record BookRequestDto(
        String title,
        String isbn,
        List<AuthorRequestDto> authorRequestDtos,
        PublisherRequestDto publisherRequestDto
) {
}

/*
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
    private Publisher publisher;
 */