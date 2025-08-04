package com.patika.library.controller;

import com.patika.library.model.Book;
import com.patika.library.service.LibraryService;
import com.patika.library.util.ConsolePrinter;

import java.util.List;

public class LibraryController
{
    private final LibraryService libraryService = new LibraryService();
    private final ConsolePrinter consolePrinter = new ConsolePrinter();

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

    public Book searchBookByTitle(String title)
    {
        return libraryService.searchBookByTitle(title);
    }

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

    public List<Book> searchAllBooksByAuthor(String authorName)
    {
        return libraryService.findAllBooksByAuthor(authorName);
    }

    public Book searchBookByISBN(String ISBN)
    {
        return libraryService.findBookByISBN(ISBN);
    }

    public List<Book> searchBooksByBorrowingStatus(boolean borrowStatus)
    {
        return libraryService.findByBorrowingStatus(borrowStatus);
    }

    public void borrowBook(Book book)
    {
        libraryService.borrowBook(book);
        System.out.println("Book has been successfully borrowed.");
    }

    public void returnBook(Book book)
    {
        libraryService.returnBook(book);
        System.out.println("Book has been successfully returned.");
    }
}
