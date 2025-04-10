package com.bright.libms.service;

import com.bright.libms.dto.request.PublisherRequestDto;
import com.bright.libms.dto.response.PublisherResponseDto;
import com.bright.libms.model.Publisher;

import java.util.List;
import java.util.Optional;

public interface PublisherService {
    //Create
    Optional<PublisherResponseDto> createPublisher(PublisherRequestDto publisherRequestDto);
    //Find
    Optional<PublisherResponseDto> findPublisherByName(String name);
    //Find all
    List<PublisherResponseDto> findAllPublishers();
    //Update
    Optional<PublisherResponseDto> updatePublisher(String name, PublisherRequestDto publisherRequestDto);
    //Delete
    void deletePublisherByName(String name);
}
