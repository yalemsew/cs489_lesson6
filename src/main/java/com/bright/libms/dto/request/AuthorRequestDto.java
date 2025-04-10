package com.bright.libms.dto.request;

public record AuthorRequestDto(
        String firstName,
        String lastName
) {
}

/***
 * private String firstName;
 *     private String lastName;
 */