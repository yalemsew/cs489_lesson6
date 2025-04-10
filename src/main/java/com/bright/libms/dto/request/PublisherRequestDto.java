package com.bright.libms.dto.request;

//We need name, address, and book
public record PublisherRequestDto(
    String name,
    AddressRequestDto addressRequestDto
) {
}
