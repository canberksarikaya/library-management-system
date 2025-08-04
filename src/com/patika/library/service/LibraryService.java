package com.patika.library.service;

import com.patika.library.model.Book;
import com.patika.library.repository.BookRepository;

import java.util.List;

/**
 * Service layer responsible for implementing the business logic of the library
 * system.
 * <p>
 *     Handles operations such as adding, searching, borrowing and returning books.
 *     Delegates data persistance tasks to {@link BookRepository}.
 * </p>
 *
 * @author Canberk Sarıkaya
 * @version 1.0
 */
public class LibraryService
{
    private final BookRepository bookRepository = new BookRepository();

    /**
     * Adds a new book to the repository if it does not already exist.
     *
     * @param book the book to add
     * @return true if the book was successfully added, false if a book
     * with the same title already exists
     */
    public boolean addBook(Book book)
    {
        if (bookRepository.findByTitle(book.getBookTitle()) == null)
        {
            bookRepository.save(book);
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * Searches for a book by its title.
     *
     * @param title the title to search
     * @return the matching book or null if not found
     */
    public Book searchBookByTitle(String title)
    {
        return bookRepository.findByTitle(title);
    }

    /**
     * Returns a list of all books in the repository.
     *
     * @return list of books; null if no books are found
     */
    public List<Book> listBooks()
    {
        if (bookRepository.getAllBooks().isEmpty())
        {
            return null;
        }
        return bookRepository.getAllBooks();
    }

    /**
     * Finds all book written by a specific author.
     *
     * @param authorName the author's name
     * @return list of books by the author
     */
    public List<Book> findAllBooksByAuthor(String authorName)
    {
        return bookRepository.findAllBooksByAuthor(authorName);
    }

    /**
     * Finds a book by its ISBN number.
     *
     * @param ISBN the ISBN to search
     * @return the matching book or null if not found
     */
    public Book findBookByISBN(String ISBN)
    {
        return bookRepository.findByISBN(ISBN);
    }

    /**
     * Finds books based on their borrowing status.
     *
     * @param borrowStatus true for borrowed books, false for available books
     * @return list of books with the given status
     */
    public List<Book> findByBorrowingStatus(boolean borrowStatus)
    {
        return bookRepository.findByBorrowingStatus(borrowStatus);
    }

    /**
     * Marks a book as borrowed if available.
     *
     * @param book the book to borrow
     */
    public void borrowBook(Book book)
    {
        bookRepository.borrowBook(book);
    }

    /**
     * Marks a book as returned if currently borrowed.
     *
     * @param book the book to return
     */
    public void returnBook(Book book)
    {
        bookRepository.returnBook(book);
    }
}
