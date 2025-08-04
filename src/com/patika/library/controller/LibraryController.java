package com.patika.library.controller;

import com.patika.library.model.Book;
import com.patika.library.service.LibraryService;
import com.patika.library.util.ConsolePrinter;

import java.util.List;

/**
 * Controller layer responsible for handling user interactions and delegating
 * tasks to the {@link LibraryService}
 *
 * <p>
 *     Acts as a bridge between the UI layer and the business logic.
 *     Handles tasks such as adding, searching, listing, borrowing, and returning books.
 * </p>
 *
 * @author Canberk Sarıkaya
 * @version 1.0
 */
public class LibraryController
{
    private final LibraryService libraryService = new LibraryService();
    private final ConsolePrinter consolePrinter = new ConsolePrinter();

    /**
     * Adds a book to the system and prints the result.
     *
     * @param book the book to be added
     */
    public void addBook(Book book)
    {
        if(libraryService.addBook(book))
        {
            System.out.println("Book added successfully");
        }
        else
        {
            System.out.println("Cannot add book. It's already added.");
        }
    }

    /**
     * Searches for a book by title.
     *
     * @param title the book title to search
     * @return the found book, or null if not found
     */
    public Book searchBookByTitle(String title)
    {
        return libraryService.searchBookByTitle(title);
    }

    /**
     * Lists all books in the system. Prints each book's details.
     */
    public void listBooks()
    {
        List<Book> books = libraryService.listBooks();
        if (books == null || books.isEmpty())
        {
            System.out.println("No books found.");
        }
        else
        {
            for (Book book : books)
            {
                consolePrinter.printBookDetails(book);
            }
        }
    }

    /**
     * Searches for all books written by a specific author.
     *
     * @param authorName the name of the author
     * @return list of books by the given author
     */
    public List<Book> searchAllBooksByAuthor(String authorName)
    {
        return libraryService.findAllBooksByAuthor(authorName);
    }

    /**
     * Searches for a book by its ISBN.
     *
     * @param ISBN the ISBN number
     * @return the book if found, otherwise null
     */
    public Book searchBookByISBN(String ISBN)
    {
        return libraryService.findBookByISBN(ISBN);
    }

    /**
     * Searches for books based on borrowing status.
     *
     * @param borrowStatus true if looking for borrowed books, false for available books
     * @return list of books with the given borrowing status
     */
    public List<Book> searchBooksByBorrowingStatus(boolean borrowStatus)
    {
        return libraryService.findByBorrowingStatus(borrowStatus);
    }

    /**
     * Borrows a book and prints a confirmation message.
     *
     * @param book the book to be borrowed
     */
    public void borrowBook(Book book)
    {
        libraryService.borrowBook(book);
        System.out.println("Book has been successfully borrowed.");
    }

    /**
     * Returns a previously borrowed book and prints a confirmation message.
     *
     * @param book the book to be returned
     */
    public void returnBook(Book book)
    {
        libraryService.returnBook(book);
        System.out.println("Book has been successfully returned.");
    }
}
