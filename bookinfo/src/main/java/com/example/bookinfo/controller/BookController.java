package com.example.bookinfo.controller;

import com.example.bookinfo.dto.BookDto;
import com.example.bookinfo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    // 전체 도서 목록 조회
    // http://localhost:8080/books
    @GetMapping
    public List<BookDto> getAllBooks() {
        return bookService.getAllBooks();
    }

    // 도서 검색
    // http://localhost:8080/books/search?title=Java&author=&publisher=
    @GetMapping("/search")
    public List<BookDto> searchBooks(@RequestParam(required=false) String title,
                                     @RequestParam(required=false) String author,
                                     @RequestParam(required=false) String publisher) {
        return bookService.searchBooks(title, author, publisher);
    }
}

