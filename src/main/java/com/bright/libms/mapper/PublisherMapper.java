package com.bright.libms.mapper;

import com.bright.libms.dto.request.PublisherRequestDto;
import com.bright.libms.dto.response.PublisherResponseDto;
import com.bright.libms.model.Publisher;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {AddressMapper.class})//"spring"
public interface PublisherMapper {
    //mapper method to map from PublisherRequestDto to Publisher
    @Mapping(source = "addressRequestDto", target = "address")
    Publisher publisherRequestDtoToPublisher(PublisherRequestDto publisherRequestDto);

    //mapper method => map from Publisher to PublisherResponseDto
    @Mapping(source = "address", target = "addressResponseDto")
    PublisherResponseDto publisherToPublisherResponseDto(Publisher publisher);

    //mapping from List<Publisher> to List<PublisherResponseDto
    @Mapping(source = "address", target = "addressResponseDto")
    List<PublisherResponseDto> publishersToPublisherResponseDtoList(List<Publisher> publishers);
}
