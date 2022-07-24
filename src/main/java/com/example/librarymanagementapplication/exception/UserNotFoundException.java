package com.example.librarymanagementapplication.exception;/*
 * Author Name:Kshitij sahu
 * IDE: intellij IDEA Community Edition
 * Date: 24-07-2022
 */

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(int id) {
        super("USER_ID_NOT_FOUND : " + id);
    }

}

