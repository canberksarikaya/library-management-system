package com.patika.library.model;

public class Book
{
    private final String bookTitle;
    private final String authorName;
    private final String ISBN;
    private boolean isBorrowed;

    public Book(String bookTitle, String authorName, String ISBN)
    {
        this.bookTitle = bookTitle;
        this.authorName = authorName;
        this.ISBN = ISBN;
        this.isBorrowed = false;
    }

    public String getBookTitle()
    {
        return this.bookTitle;
    }

    public String getAuthorName()
    {
        return this.authorName;
    }

    public String getISBN()
    {
        return this.ISBN;
    }

    public boolean isBorrowed()
    {
        return this.isBorrowed;
    }

    public void setBorrowed(boolean borrowed)
    {
        this.isBorrowed = borrowed;
    }
}
