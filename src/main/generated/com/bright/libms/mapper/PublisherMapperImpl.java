package com.bright.libms.mapper;

import com.bright.libms.dto.request.PublisherRequestDto;
import com.bright.libms.dto.response.AddressResponseDto;
import com.bright.libms.dto.response.PublisherResponseDto;
import com.bright.libms.model.Publisher;
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
public class PublisherMapperImpl implements PublisherMapper {

    @Autowired
    private AddressMapper addressMapper;

    @Override
    public Publisher publisherRequestDtoToPublisher(PublisherRequestDto publisherRequestDto) {
        if ( publisherRequestDto == null ) {
            return null;
        }

        Publisher publisher = new Publisher();

        publisher.setAddress( addressMapper.addressRequestDtoToAddress( publisherRequestDto.addressRequestDto() ) );
        publisher.setName( publisherRequestDto.name() );

        return publisher;
    }

    @Override
    public PublisherResponseDto publisherToPublisherResponseDto(Publisher publisher) {
        if ( publisher == null ) {
            return null;
        }

        AddressResponseDto addressResponseDto = null;
        Long id = null;
        String name = null;

        addressResponseDto = addressMapper.addressToAddressResponseDto( publisher.getAddress() );
        id = publisher.getId();
        name = publisher.getName();

        PublisherResponseDto publisherResponseDto = new PublisherResponseDto( id, name, addressResponseDto );

        return publisherResponseDto;
    }

    @Override
    public List<PublisherResponseDto> publishersToPublisherResponseDtoList(List<Publisher> publishers) {
        if ( publishers == null ) {
            return null;
        }

        List<PublisherResponseDto> list = new ArrayList<PublisherResponseDto>( publishers.size() );
        for ( Publisher publisher : publishers ) {
            list.add( publisherToPublisherResponseDto( publisher ) );
        }

        return list;
    }
}
