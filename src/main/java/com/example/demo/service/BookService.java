package com.example.demo.service;

import com.example.demo.entity.Book;
import com.example.demo.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private final BookRepository repo;

    public BookService(BookRepository repo) {
        this.repo = repo;
    }

    public List<Book> getAll() {
        return repo.findAll();
    }

    public Book getById(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Book not found with id: " + id));
    }

    public void save(Book book) {
        repo.save(book);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    public List<Book> search(String keyword) {
        return repo(keyword, keyword);
    }
}
