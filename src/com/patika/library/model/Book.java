package com.patika.library.model;

/**
 * Represents a Book in the Library Management System.
 * <p>
 *     Each book has a title, an author, an ISBN number, and a borrowing status.
 *     This model is used to hold and transfer book-related data throughout the system.
 * </p>
 *
 * @author Canberk Sarıkaya
 * @version 1.0
 */
public class Book
{
    private final String bookTitle;
    private final String authorName;
    private final String ISBN;
    private boolean isBorrowed;

    /**
     * Constructs a new Book object with the given title, author and ISBN.
     * The book is marked as not borrowed by default.
     *
     * @param bookTitle the title of the book
     * @param authorName the name of the book's author
     * @param ISBN the ISBN number of the book
     */
    public Book(String bookTitle, String authorName, String ISBN)
    {
        this.bookTitle = bookTitle;
        this.authorName = authorName;
        this.ISBN = ISBN;
        this.isBorrowed = false;
    }

    /**
     * Returns the title of the book.
     *
     * @return the book title
     */
    public String getBookTitle()
    {
        return this.bookTitle;
    }

    /**
     * Returns the author's name.
     *
     * @return the author's name
     */
    public String getAuthorName()
    {
        return this.authorName;
    }

    /**
     * Returns the ISBN of the book.
     *
     * @return the ISBN
     */
    public String getISBN()
    {
        return this.ISBN;
    }

    /**
     * Returns whether the book is currently borrowed.
     *
     * @return true if the book is borrowed, false otherwise
     */
    public boolean isBorrowed()
    {
        return this.isBorrowed;
    }

    /**
     * Sets the borrowing status of the book.
     *
     * @param borrowed true if the book is being borrowed, false if it is being
     *                 returned
     */
    public void setBorrowed(boolean borrowed)
    {
        this.isBorrowed = borrowed;
    }
}
