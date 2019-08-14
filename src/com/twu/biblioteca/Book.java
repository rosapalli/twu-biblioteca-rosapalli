package com.twu.biblioteca;

public class Book {

    private String name;
    private String author;
    private Integer yearPublished;
    private Boolean isAvailable;

    public Book(String name, String author, Integer year) {
        this.name = name;
        this.author = author;
        this.yearPublished = year;
        this.isAvailable = true;
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

    public Boolean getIsAvailable() { return isAvailable; }

    public void setIsAvailable(Boolean isAvailable) { this.isAvailable = isAvailable; }

}
