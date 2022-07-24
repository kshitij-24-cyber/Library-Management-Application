package com.example.librarymanagementapplication.exception;/*
 * Author Name:Kshitij sahu
 * IDE: intellij IDEA Community Edition
 * Date: 23-07-2022
 */

public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException(int id) {
        super("BOOK_NOT_FOUND : " + id);
    }

    public BookNotFoundException() {
        super("NO BOOKS HERE");
    }
}
