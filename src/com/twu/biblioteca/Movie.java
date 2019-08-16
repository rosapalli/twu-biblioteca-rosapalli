package com.twu.biblioteca;

public class Movie extends LibraryItem {

    private Float rating;

    public Movie(String name, String author, Integer year, Float rating) {
        super(name, author, year);
        this.rating = rating;
    }

    public Float getRating() {
        return rating;
    }

    public Boolean getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(Boolean available) {
        isAvailable = available;
    }
}
