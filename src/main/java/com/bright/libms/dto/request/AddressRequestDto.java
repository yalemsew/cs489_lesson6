package com.bright.libms.dto.request;

public record AddressRequestDto(
        String unitNo,
        String street,
        String city,
        String state,
        Integer zip
) {
}

/**
 * private String unitNo;
 *     @Column(nullable = false)
 *     private String street;
 *     @Column(nullable = false)
 *     private String city;
 *     @Column(nullable = false)
 *     private String state;
 *     @Column(nullable = false)
 *     private Integer zip;
 */