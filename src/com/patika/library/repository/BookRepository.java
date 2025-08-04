package com.patika.library.repository;

import com.patika.library.model.Book;

import java.util.ArrayList;
import java.util.List;

public class BookRepository
{
    private final List<Book> bookList = new ArrayList<>();

    public List<Book> getAllBooks()
    {
        return bookList;
    }

    public void save(Book book)
    {
        bookList.add(book);
    }

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
