package com.bright.libms.dto.response;

import java.util.List;

public record BookResponseDto(
    Long id,
    String title,
    String isbn,
    List<AuthorResponseDto> authorResponseDtos,
    PublisherResponseDto publisherResponseDto
) {
}
