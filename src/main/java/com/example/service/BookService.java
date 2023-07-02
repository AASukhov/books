package com.example.service;

import com.example.dto.BookDTO;
import com.example.entity.Book;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface BookService {

    List<Book> getBookList();
    List<Book> getBookListReversed();
    ResponseEntity<String> addBook(BookDTO book);
    Map<String, List<Book>> getBookListGroupedByAuthor();
}
