package com.example.bookinfo.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class BookDto {
    private String title;
    private String author;
    private String publisher;
    private LocalDate published_date ;
}
