package com.patika.library.util;

import com.patika.library.model.Book;

import java.util.List;

/**
 * Utility class for printing book details to the console.
 * Supports printing a single book or a list of books in a formatted manner.
 * THis class is intended to keep UI code clean and reusable.
 *
 * @author Canberk Sarıkaya
 * @version 1.0
 */
public class ConsolePrinter
{
    /**
     * Prints the details of a single book to the console.
     *
     * @param book the book whose details are to be printed.
     */
    public void printBookDetails(Book book)
    {
        System.out.print("\n-----------------------------");
        System.out.print("\nBook Title: " + book.getBookTitle() + " \n"
                + "Author: " + book.getAuthorName() + " \n"
                + "ISBN: " + book.getISBN() + " \n"
                + "Borrowing Status: " +
                (book.isBorrowed() ? "Borrowed." : "Available."));
        System.out.println();
        System.out.print("------------------------------\n");
    }

    /**
     * Prints the details of a list of books to the console.
     *
     * @param books the list of books to be printed.
     */
    public void printBookDetails(List<Book> books)
    {
        for (Book book : books)
        {
            System.out.print("\n-----------------------------");
            System.out.print("\nBook Title: " + book.getBookTitle() + " \n"
                    + "Author: " + book.getAuthorName() + " \n"
                    + "ISBN: " + book.getISBN() + " \n"
                    + "Borrowing Status: " +
                    (book.isBorrowed() ? "Borrowed." : "Available."));
            System.out.println();
            System.out.print("------------------------------\n");
        }
    }
}
