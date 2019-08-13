package com.twu.biblioteca;

import java.util.Objects;

public class Book {

    private String name;
    private String author;
    private Integer yearPublished;

    public Book(String name, String author, Integer year) {
        this.name = name;
        this.author = author;
        this.yearPublished = year;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public Integer getYearPublished() {
        return yearPublished;
    }

}
