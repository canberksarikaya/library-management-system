package com.patika.library.util;

public class InputHelper
{
    public void checkBlankInput(String bookTitle, String bookAuthor, String ISBN)
    {
        if (bookTitle.isBlank() || bookAuthor.isBlank() || ISBN.isBlank())
        {
            System.out.println("Please enter a valid input.");
            System.out.println("Inputs cannot be blank.");
        }
    }
}
