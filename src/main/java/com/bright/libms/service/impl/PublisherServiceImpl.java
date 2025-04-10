package com.bright.libms.service.impl;

import com.bright.libms.dto.request.PublisherRequestDto;
import com.bright.libms.dto.response.AddressResponseDto;
import com.bright.libms.dto.response.PublisherResponseDto;
import com.bright.libms.mapper.PublisherMapper;
import com.bright.libms.model.Address;
import com.bright.libms.model.Publisher;
import com.bright.libms.repository.PublisherRepository;
import com.bright.libms.service.PublisherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PublisherServiceImpl implements PublisherService {

    private final PublisherRepository publisherRepository;
    private final PublisherMapper publisherMapper;

    @Override
    public Optional<PublisherResponseDto> createPublisher(PublisherRequestDto publisherRequestDto) {
        //From publisherRequestDto, construct Publisher
        Publisher publisher = publisherMapper.publisherRequestDtoToPublisher(publisherRequestDto);
        Publisher savedPublisher = publisherRepository.save(publisher);
        //Map Publisher to PublisherResponseDto
        PublisherResponseDto publisherResponseDto = publisherMapper.publisherToPublisherResponseDto(savedPublisher);
        return Optional.ofNullable(publisherResponseDto);
    }

    @Override
    public Optional<PublisherResponseDto> findPublisherByName(String name) {
        Optional<Publisher> optionalPublisher = publisherRepository.findByNameIgnoreCase(name);
        if (optionalPublisher.isPresent()) {
            return Optional.ofNullable(publisherMapper.publisherToPublisherResponseDto(optionalPublisher.get()));
        }
        return Optional.empty();
    }

    @Override
    public List<PublisherResponseDto> findAllPublishers() {
        List<Publisher> publishers = publisherRepository.findAll();
        List<PublisherResponseDto> publisherResponseDtoList = publisherMapper.publishersToPublisherResponseDtoList(publishers);
        return publisherResponseDtoList;
    }

    @Override
    public Optional<PublisherResponseDto> updatePublisher(String name, PublisherRequestDto publisherRequestDto) {
        //Check publisher is existing or not
        Optional<Publisher> optionalPublisher = publisherRepository.findByNameIgnoreCase(name);
        if (optionalPublisher.isPresent()) {
            Publisher foundPublisher = optionalPublisher.get();
            //edit the foundPublisher object
            Publisher mappedPublisher = publisherMapper.publisherRequestDtoToPublisher(publisherRequestDto);
            mappedPublisher.setId(foundPublisher.getId());
            Publisher updatedPublisher = publisherRepository.save(mappedPublisher);
            return Optional.ofNullable(publisherMapper.publisherToPublisherResponseDto(updatedPublisher));
        }
        return Optional.empty();
    }
}
