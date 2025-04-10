package com.bright.libms.repository;

import com.bright.libms.model.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PublisherRepository extends JpaRepository<Publisher, Long> {
    //JPA query method => find a publisher by name
    Optional<Publisher> findByName(String name);
    void deleteByName(String name);
}
