package com.patika.library.util;

import com.patika.library.model.Book;

import java.util.List;

public class ConsolePrinter
{
    public void printBookDetails(Book book)
    {
        System.out.print("\n-----------------------------");
        System.out.print("\nKitap Adı: " + book.getBookTitle() + " \n"
                + "Kitabın Yazarı: " + book.getAuthorName() + " \n"
                + "Kitabın ISBN Numarası: " + book.getISBN() + " \n"
                + "Kitabın Ödünç Alınma Durumu: " +
                (book.isBorrowed() ? "Alındı." : "Alınmadı."));
        System.out.println();
        System.out.print("------------------------------\n");
    }

    public void printBookDetails(List<Book> books)
    {
        for (Book book : books)
        {
            System.out.print("\n-----------------------------");
            System.out.print("\nKitap Adı: " + book.getBookTitle() + " \n"
                    + "Kitabın Yazarı: " + book.getAuthorName() + " \n"
                    + "Kitabın ISBN Numarası: " + book.getISBN() + " \n"
                    + "Kitabın Ödünç Alınma Durumu: " +
                    (book.isBorrowed() ? "Alındı." : "Alınmadı."));
            System.out.println();
            System.out.print("------------------------------\n");
        }
    }
}
