package com.bright.libms;

import com.bright.libms.dto.request.AddressRequestDto;
import com.bright.libms.dto.request.PublisherRequestDto;
import com.bright.libms.service.PublisherService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@RequiredArgsConstructor
public class LibmsApplication {

    private final PublisherService publisherService;

    public static void main(String[] args) {
        SpringApplication.run(LibmsApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner() {
        return args -> {
            //Create PublisherRequestDto
            PublisherRequestDto publisherRequestDto = new PublisherRequestDto(
                    "Apress",
                    new AddressRequestDto(
                            "1A",
                            "LLC One New York Plaza",
                            "New York",
                            "NY",
                            1562
                    )
            );
            System.out.println(publisherService.createPublisher(publisherRequestDto));
            System.out.println(publisherService.findAllPublishers());
        };
    }
}
