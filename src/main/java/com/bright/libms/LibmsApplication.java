package com.bright.libms;

import com.bright.libms.dto.request.AddressRequestDto;
import com.bright.libms.dto.request.AuthorRequestDto;
import com.bright.libms.dto.request.BookRequestDto;
import com.bright.libms.dto.request.PublisherRequestDto;
import com.bright.libms.service.BookService;
import com.bright.libms.service.PublisherService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class LibmsApplication {

    private final PublisherService publisherService;
    private final BookService bookService;

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
            System.out.println("Find by name: " + publisherService.findPublisherByName("Apress"));
            System.out.println(publisherService.findAllPublishers());

            BookRequestDto bookRequestDto = new BookRequestDto(
                    "Flutter in Action",
                    "9781617296147",
                    List.of(
                            new AuthorRequestDto("Eric", "Windmill")
                    ),
                    new PublisherRequestDto(
                            "Manning",
                            new AddressRequestDto(
                                    "2A",
                                    "2000 N",
                                    "Fairfield",
                                    "IA",
                                    52556
                            )
                    )
            );
            System.out.println("Saved new book: " + bookService.createBook(bookRequestDto));
            System.out.println("Found book: " + bookService.findBookByIsbn("9781617296147"));
            System.out.println("All books: " + bookService.findAllBooks());
        };
    }
}
