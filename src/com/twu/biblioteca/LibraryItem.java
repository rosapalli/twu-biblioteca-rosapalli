package com.twu.biblioteca;

public abstract class LibraryItem {
    protected String name;
    protected String author;
    protected Integer year;
    protected Boolean isAvailable;
    protected String loanedByUsername;

    public LibraryItem(String name, String author, Integer year) {
        this.name = name;
        this.author = author;
        this.year = year;
        this.isAvailable = true;
        this.loanedByUsername = null;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public Integer getYear() {
        return year;
    }

    public Boolean getIsAvailable() { return isAvailable; }

    public String getLoanedByUsername() {
        return loanedByUsername;
    }

    public void setLoanedByUsername(String username) {
        this.loanedByUsername = username;
    }

    public void setIsAvailable(Boolean isAvailable) { this.isAvailable = isAvailable; }
}
