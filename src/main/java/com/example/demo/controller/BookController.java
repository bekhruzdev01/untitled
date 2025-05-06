package com.example.demo.controller;

import com.example.demo.entity.Book;
import com.example.demo.payload.BookRequest;
import com.example.demo.payload.BookResponse;
import com.example.demo.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping()
    public String getAllBooks(Model model) {
        List<BookResponse> books = bookService.getAll().stream()
            .map(book -> {
                BookResponse response = new BookResponse();
                response.setId(book.getId());
                response.setTitle(book.getTitle());
                response.setAuthor(book.getAuthor());
                return response;
            })
            .toList();
        model.addAttribute("books", books);
        return "index";
    }

    @PostMapping
    public String addBook(@ModelAttribute BookRequest bookRequest, RedirectAttributes redirectAttributes) {
        Book book = Book.builder()
                        .title(bookRequest.getTitle())
                        .author(bookRequest.getAuthor())
                        .build();
        bookService.save(book);

        // Xabarni qo'shish
        redirectAttributes.addFlashAttribute("message", "Kitob muvaffaqiyatli qo'shildi!");
        return "redirect:/books";
    }

    @GetMapping("/edit/{id}")
    public String editBook(@PathVariable Long id, Model model) {
        model.addAttribute("book", bookService.getById(id));
        return "edit";
    }

    @PostMapping("/update/{id}")
    public String updateBook(@PathVariable Long id, @ModelAttribute Book updatedBook) {
        Book existingBook = bookService.getById(id);
        existingBook.setTitle(updatedBook.getTitle());
        existingBook.setAuthor(updatedBook.getAuthor());
        bookService.save(existingBook);
        return "redirect:/books";
    }

    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        bookService.delete(id);

        // Xabarni qo'shish
        redirectAttributes.addFlashAttribute("message", "Kitob muvaffaqiyatli o'chirildi!");
        return "redirect:/books";
    }

    @GetMapping("/search")
    public String searchBooks(@RequestParam String keyword, Model model) {
        model.addAttribute("books", bookService.search(keyword));
        return "index";
    }
}
