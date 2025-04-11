package com.bright.libms.mapper;

import com.bright.libms.dto.request.AddressRequestDto;
import com.bright.libms.dto.response.AddressResponseDto;
import com.bright.libms.model.Address;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-04-10T21:02:56-0500",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.1 (Oracle Corporation)"
)
@Component
public class AddressMapperImpl implements AddressMapper {

    @Override
    public Address addressRequestDtoToAddress(AddressRequestDto addressRequestDto) {
        if ( addressRequestDto == null ) {
            return null;
        }

        Address address = new Address();

        address.setUnitNo( addressRequestDto.unitNo() );
        address.setStreet( addressRequestDto.street() );
        address.setCity( addressRequestDto.city() );
        address.setState( addressRequestDto.state() );
        address.setZip( addressRequestDto.zip() );

        return address;
    }

    @Override
    public AddressResponseDto addressToAddressResponseDto(Address address) {
        if ( address == null ) {
            return null;
        }

        Long id = null;
        String unitNo = null;
        String street = null;
        String city = null;
        String state = null;
        Integer zip = null;

        id = address.getId();
        unitNo = address.getUnitNo();
        street = address.getStreet();
        city = address.getCity();
        state = address.getState();
        zip = address.getZip();

        AddressResponseDto addressResponseDto = new AddressResponseDto( id, unitNo, street, city, state, zip );

        return addressResponseDto;
    }
}
