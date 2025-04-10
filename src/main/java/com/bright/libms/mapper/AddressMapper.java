package com.bright.libms.mapper;

import com.bright.libms.dto.request.AddressRequestDto;
import com.bright.libms.dto.response.AddressResponseDto;
import com.bright.libms.model.Address;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Mappings;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface AddressMapper {

    //map from addressRequestDtoToAddress
//    @Mappings({
//            @Mapping(source = "unitNo", target = "unitNo"),
//            @Mapping(source = "street", target = "street"),
//            @Mapping(source = "city", target = "city")
//    })
    Address addressRequestDtoToAddress(AddressRequestDto addressRequestDto);

    //map from Address to AddressResponseDto
    AddressResponseDto addressToAddressResponseDto(Address address);
}
