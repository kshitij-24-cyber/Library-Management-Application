package com.example.librarymanagementapplication.util;/*
 * Author Name:Kshitij sahu
 * IDE: intellij IDEA Community Edition
 * Date: 22-07-2022
 */

import com.example.librarymanagementapplication.model.User;

public class UserValidator {
    public static boolean isValid(User user) {
        return user.getName() != "" && user.getName() != null;
    }

}
