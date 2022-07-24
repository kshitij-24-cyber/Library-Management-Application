package com.example.librarymanagementapplication.controller;/*
 * Author Name:Kshitij sahu
 * IDE: intellij IDEA Community Edition
 * Date: 24-07-2022
 */

import com.example.librarymanagementapplication.model.IssuedBooks;
import com.example.librarymanagementapplication.repository.IssuedBooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class IssuedBooksController {
    @Autowired
    IssuedBooksRepository issuedBooksRepository;

    @GetMapping("getAllIssueBook")
    public List<IssuedBooks> findAllIssuedBooks() {
        return issuedBooksRepository.findAll();
    }

    @PostMapping("/isseueBook")
    @ResponseStatus(HttpStatus.CREATED)
    public IssuedBooks newIssuedBooks(@RequestBody IssuedBooks newIssuedBooks) throws Exception {
        try {
            return issuedBooksRepository.save(newIssuedBooks);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception();
        }

    }

    @GetMapping("/searchIssuedBookByUser")
    public List<IssuedBooks> searchIssuedBookByUser(@RequestParam(value = "q") String user) {
        List<IssuedBooks> issuedBooks = issuedBooksRepository.findAll();
        ArrayList<IssuedBooks> list = new ArrayList<>();
        for (IssuedBooks book : issuedBooks) {
            int id = Integer.parseInt(user);
            if (book.getUserId() == id) {
                list.add(book);
            }
        }
        return list;
    }

}

