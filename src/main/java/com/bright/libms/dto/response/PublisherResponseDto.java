package com.bright.libms.dto.response;

public record PublisherResponseDto(
        Long id,
        String name,
        AddressResponseDto addressResponseDto
) {
}
