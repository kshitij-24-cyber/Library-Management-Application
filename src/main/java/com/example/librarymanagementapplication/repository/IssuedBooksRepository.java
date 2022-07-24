package com.example.librarymanagementapplication.repository;/*
 * Author Name:Kshitij sahu
 * IDE: intellij IDEA Community Edition
 * Date: 24-07-2022
 */

import com.example.librarymanagementapplication.model.IssuedBooks;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IssuedBooksRepository extends JpaRepository<IssuedBooks, Integer> {
}



