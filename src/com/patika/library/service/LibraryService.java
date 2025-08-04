package com.patika.library.service;

import com.patika.library.model.Book;
import com.patika.library.repository.BookRepository;

import java.util.List;

public class LibraryService
{
    private final BookRepository bookRepository = new BookRepository();

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

    public Book searchBookByTitle(String title)
    {
        return bookRepository.findByTitle(title);
    }

    public List<Book> listBooks()
    {
        if (bookRepository.getAllBooks().isEmpty())
        {
            return null;
        }
        return bookRepository.getAllBooks();
    }

    public List<Book> findAllBooksByAuthor(String authorName)
    {
        return bookRepository.findAllBooksByAuthor(authorName);
    }

    public Book findBookByISBN(String ISBN)
    {
        return bookRepository.findByISBN(ISBN);
    }

    public List<Book> findByBorrowingStatus(boolean borrowStatus)
    {
        return bookRepository.findByBorrowingStatus(borrowStatus);
    }

    public void borrowBook(Book book)
    {
        bookRepository.borrowBook(book);
    }

    public void returnBook(Book book)
    {
        bookRepository.returnBook(book);
    }
}
