package com.example.bookinfo.mapper;

import com.example.bookinfo.dto.BookDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BookMapper {
    List<BookDto> getAllBooks();
    List<BookDto> searchBooks(String title, String author, String publisher);
}
