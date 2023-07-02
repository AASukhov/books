package com.example.service.impl;

import com.example.dto.BookDTO;
import com.example.entity.Book;
import com.example.entity.BookMapper;
import com.example.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    private final JdbcTemplate template;

    @Autowired
    public BookServiceImpl(JdbcTemplate template) {
        this.template = template;
    }

    public List<Book> getBookList() {
        String query = "SELECT * FROM book";
        return template.query(query, new BookMapper());
    }

    public List<Book> getBookListReversed() {
        String query = "SELECT * FROM book ORDER BY title DESC";
        return template.query(query, new BookMapper());
    }

    public ResponseEntity<String> addBook(@RequestBody BookDTO book) {
        String query = "INSERT INTO book (id, title, author, description) VALUES (?, ?, ?, ?)";
        int id = book.getId();
        String title = book.getTitle();
        String author = book.getAuthor();
        String description = book.getDescription();
        try {
            template.update(query, id, title, author, description);
            return new ResponseEntity<>("New book successfully added", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("An error occurred while adding new book", HttpStatus.BAD_REQUEST);
        }
    }

    public Map<String, List<Book>> getBookListGroupedByAuthor() {
        List<Book> list = getBookListReversed();
        Map<String, List<Book>> result = list.stream().collect(Collectors.groupingBy(Book ::getAuthor));
        return result;
    }
}
