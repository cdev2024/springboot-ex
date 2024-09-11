package com.example.bookinfo.service;

import com.example.bookinfo.dto.BookDto;
import com.example.bookinfo.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookMapper bookMapper;

    // 전체 도서 목록 조회
    public List<BookDto> getAllBooks() {
        return bookMapper.getAllBooks();
    }

    // 도서 검색
    public List<BookDto> searchBooks(String title, String author, String publisher) {
        return bookMapper.searchBooks(title, author, publisher);
    }
}
