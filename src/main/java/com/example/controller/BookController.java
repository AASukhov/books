package com.example.controller;

import com.example.dto.BookDTO;
import com.example.entity.Book;
import com.example.service.impl.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookServiceImpl service;

    @GetMapping("/list")
    public List<Book> getBookList() {
        return service.getBookList();
    }

    @GetMapping("/list-reversed")
    public List<Book> getBookListReversed() {
        return service.getBookListReversed();
    }

    @GetMapping("/group-by-author")
    public Map<String, List<Book>> getBookListGroupedByAuthor() {
        return service.getBookListGroupedByAuthor();
    }

    @PostMapping("/new")
    public ResponseEntity<String> addBook(@RequestBody BookDTO bookDTO) {
        return service.addBook(bookDTO);
    }
}
