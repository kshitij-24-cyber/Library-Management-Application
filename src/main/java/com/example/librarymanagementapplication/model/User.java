package com.example.librarymanagementapplication.model;/*
 * Author Name:Kshitij sahu
 * IDE: intellij IDEA Community Edition
 * Date: 22-07-2022
 */

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String name;
    private String email;
    private String mobile;

}
