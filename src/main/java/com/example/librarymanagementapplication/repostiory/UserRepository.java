package com.example.librarymanagementapplication.repostiory;/*
 * Author Name:Kshitij sahu
 * IDE: intellij IDEA Community Edition
 * Date: 22-07-2022
 */

import com.example.librarymanagementapplication.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}



