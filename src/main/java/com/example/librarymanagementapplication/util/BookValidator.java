package com.example.librarymanagementapplication.util;/*
 * Author Name:Kshitij sahu
 * IDE: intellij IDEA Community Edition
 * Date: 22-07-2022
 */

import com.example.librarymanagementapplication.model.Book;

public class BookValidator {
    public boolean isValid(Book book) {
        return book.getTitle() != "" && book.getTitle() != null;
    }
}
