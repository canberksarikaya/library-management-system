package com.patika.library.repository;

import com.patika.library.model.Book;

import java.util.ArrayList;
import java.util.List;

/**
 * Repository class responsible for managing book data in memory.
 *
 * <p>
 *     This class simulates a database by using an in-memory list to store
 *     and manage books. It provides methods for CRUD operations such as saving,
 *     searching and updating book records.
 * </p>
 *
 * @author Canberk Sarıkaya
 * @version 1.0
 */
public class BookRepository
{
    private final List<Book> bookList = new ArrayList<>();

    /**
     * Retrieves all books in the repository.
     *
     * @return a list of all books
     */
    public List<Book> getAllBooks()
    {
        return bookList;
    }

    /**
     * Saves a new book into the repository.
     *
     * @param book the book to save
     */
    public void save(Book book)
    {
        bookList.add(book);
    }

    /**
     * Finds a book by its title (case-insensitive)
     *
     * @param title the title of the book
     * @return the found book, or null if not found
     */
    public Book findByTitle(String title)
    {
        for (Book book : bookList)
        {
            if (book.getBookTitle().equalsIgnoreCase(title))
            {
                return book;
            }
        }
        return null;
    }

    /**
     * Finds all books written by a specific author (case-insensitive)
     *
     * @param authorName the author's name
     * @return a list of books written by the specified author
     */
    public List<Book> findAllBooksByAuthor(String authorName)
    {
        List<Book> result = new ArrayList<>();
        for (Book book : bookList)
        {
            if (book.getAuthorName().equalsIgnoreCase(authorName))
            {
                result.add(book);
            }
        }

        return result;
    }

    /**
     * Finds a book by its ISBN (case-insensitive)
     *
     * @param ISBN the ISBN of the book
     * @return the found book, or null if not found
     */
    public Book findByISBN(String ISBN)
    {
        for (Book book : bookList)
        {
            if (book.getISBN().equalsIgnoreCase(ISBN))
            {
                return book;
            }
        }

        return null;
    }

    /**
     * Finds books based on their borrowing status
     *
     * @param borrowStatus true to find borrowed books, false for returned books
     * @return a list of books with the specified borrowing status
     */
    public List<Book> findByBorrowingStatus(boolean borrowStatus)
    {
        List<Book> result = new ArrayList<>();
        for (Book book : bookList)
        {
            if (book.isBorrowed() == borrowStatus)
            {
                result.add(book);
            }
        }

        return result;
    }

    /**
     * Marks a book as borrowed if it is currently available.
     *
     * @param book the book to borrow
     */
    public void borrowBook(Book book)
    {
        if (!book.isBorrowed())
        {
            book.setBorrowed(true);
        }
        else
        {
            System.out.println("This book is already borrowed.");
        }
    }

    /**
     * Marks a book as returned if it is currently borrowed.
     *
     * @param book the book to return
     */
    public void returnBook(Book book)
    {
        if (book.isBorrowed())
        {
            book.setBorrowed(false);
        }
        else
        {
            System.out.println("This book was not borrowed.");
        }
    }
}
