/*
 * Author Name:Kshitij sahu
 * IDE: intellij IDEA Community Edition
 * Date: 23-07-2022
 */

package com.example.librarymanagementapplication.controller;

import com.example.librarymanagementapplication.exception.BookNotFoundException;
import com.example.librarymanagementapplication.model.Book;
import com.example.librarymanagementapplication.repository.BooksRepository;
import com.example.librarymanagementapplication.repository.UserRepository;
import com.example.librarymanagementapplication.util.BookValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BookController {
    @Autowired
    BooksRepository booksRepository;
    @Autowired
    UserRepository userRepository;

    BookValidator bookValidator = new BookValidator();

    // this API will fetch all the books stored in the database by the user
    @GetMapping("/GetAllbooks")
    List<Book> findAllBooks() {
        List<Book> list = new ArrayList<>();
        try {
            list = booksRepository.findAll();
            if (list.size() == 0) {
                throw new BookNotFoundException();
            }
        } catch (BookNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No Books Found", e);
        }
        return list;
    }

    // this API will addBook to the Database
    @PostMapping("/AddBook")
    @ResponseStatus(HttpStatus.CREATED)
    Book newBook(@RequestBody Book newBook) {
        if (bookValidator.isValid(newBook)) {
            return booksRepository.save(newBook);
        } else {
            return null;
        }
    }

    // this API will search all  the book from the database by the book Author name
    @GetMapping(value = "/searchBookByAuthor")
    public List<Book> searchBookByAuthor(@RequestParam(value = "q") String author) {
        List<Book> books = booksRepository.findAll();
        ArrayList<Book> list = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().equals(author)) {
                list.add(book);
            }
        }
        return list;
    }

    @GetMapping(value = "/searchBookByGenre")
    public List<Book> searchBookByGenre(@RequestParam(value = "q") String genre) {
        List<Book> books = booksRepository.findAll();
        ArrayList<Book> list = new ArrayList<>();
        for (Book book : books) {
            if (book.getGenre().equals(genre)) {
                list.add(book);
            }
        }
        return list;
    }

}
