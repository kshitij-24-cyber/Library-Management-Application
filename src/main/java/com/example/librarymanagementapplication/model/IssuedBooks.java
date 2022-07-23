/*
 * Author Name:Kshitij sahu
 * IDE: intellij IDEA Community Edition
 * Date: 23-07-2022
 */


package com.example.librarymanagementapplication.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class IssuedBooks {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int userId;
    private int bookId;
    private String status;
}
