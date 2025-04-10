package com.bright.libms.repository;

import com.bright.libms.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    Optional<Author> findByFirstNameAndLastName(String firstName, String lastName);
}

/***
 * private String firstName;
 *     private String lastName;
 */