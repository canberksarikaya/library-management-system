package com.patika.library.ui;

import com.patika.library.controller.LibraryController;
import com.patika.library.model.Book;
import com.patika.library.util.ConsolePrinter;
import com.patika.library.util.UserFlowHandler;

import java.util.List;
import java.util.Scanner;

/**
 * Console-based user interface for the Library Management System.
 * <p>
 *     This class handles all interactions with the user through the terminal,
 *     including displaying menus, accepting input, and forwarding user actions
 *     to the controller layer.
 * </p>
 *
 * @author Canberk Sarıkaya
 * @version 1.0
 */
public class ConsoleUI
{
    private final LibraryController libraryController = new LibraryController();
    private final ConsolePrinter consolePrinter = new ConsolePrinter();
    private final Scanner scanner = new Scanner(System.in);
    private boolean isMainMenuRunning = true;

    /**
     * Starts the main menu loop and handles user selection.
     * Displays options and routes them to the appropriate handlers.
     */
    public void mainMenu()
    {
        while (isMainMenuRunning)
        {
            printMenu();

            System.out.print("Select an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // buffer cleaning

            switch (choice)
            {
                case 1:
                    handleAddBook();
                    break;
                case 2:
                    handleSearchBookByTitle();
                    break;
                case 3:
                    handleSearchBookByAuthor();
                    break;
                case 4:
                    handleSearchByISBN();
                    break;
                case 5:
                    handleSearchByBorrowingStatus();
                    break;
                case 6:
                    handleListAllBooks();
                    break;
                case 7:
                    handleBorrowBook();
                    break;
                case 8:
                    handleReturnBook();
                    break;
                case 9:
                    System.out.println("Quitting the application.");
                    isMainMenuRunning = false;
                    break;
                default:
                    System.out.println("Select a valid option.");
            }
        }
    }

    /**
     * Prints the available options in the library menu to the console.
     */
    public void printMenu()
    {
        String menu = """
                ====== Library Menu ======
                1. Add Book
                2. Search Book by Title
                3. Search Book by Author
                4. Search Book by ISBN
                5. Search Book by Borrowing Status
                6. List All Books
                7. Borrow a Book
                8. Return a Book
                9. Quit
                ==========================
                """;
        System.out.println(menu);
    }

    /**
     * Handles the process of adding a new book to the system.
     * Promps the user for book details and sends them to the controller.
     */
    public void handleAddBook()
    {
        UserFlowHandler.runWithLoop(() -> {
            System.out.println("Enter Book Title: ");
            String bookTitle = scanner.nextLine();

            System.out.println("Enter Book Author: ");
            String bookAuthor = scanner.nextLine();

            System.out.println("Enter Book ISBN: ");
            String bookISBN = scanner.nextLine();

            Book newBook = new Book(bookTitle, bookAuthor, bookISBN);
            libraryController.addBook(newBook);
        });
    }

    /**
     * Allows the user to search for a book by its title.
     * If found, displays the book details.
     */
    public void handleSearchBookByTitle()
    {
        UserFlowHandler.runWithLoop(() -> {
            System.out.println("Enter the Book Title for search: ");
            String bookTitle = scanner.nextLine();

            Book book = libraryController.searchBookByTitle(bookTitle);

            if (book == null)
            {
                System.out.println("Book not found.");
                return;
            }

            consolePrinter.printBookDetails(book);
        });
    }

    /**
     * Allows the user to search for all books written by a specific author.
     * Displays a list of matching books.
     */
    public void handleSearchBookByAuthor()
    {
        UserFlowHandler.runWithLoop(() -> {
            System.out.println("Enter the Book Author for search: ");
            String bookAuthor = scanner.nextLine();

            List<Book> books = libraryController.searchAllBooksByAuthor(bookAuthor);

            if (books.isEmpty())
            {
                System.out.println("No books found for author: " + bookAuthor);
            }
            else
            {
                System.out.println(books.size() + " books found for author: " + bookAuthor);
                consolePrinter.printBookDetails(books);
            }
        });
    }

    /**
     * Searches for a book based on its ISBN number.
     * If found, displays the book details.
     */
    public void handleSearchByISBN()
    {
        UserFlowHandler.runWithLoop(() -> {
            System.out.println("Enter the Book ISBN for search: ");
            String bookISBN = scanner.nextLine();

            Book book = libraryController.searchBookByISBN(bookISBN);

            if (book == null)
            {
                System.out.println("Book not found.");
                return;
            }

            consolePrinter.printBookDetails(book);
        });
    }

    /**
     * Lists books based on borrowing status (borrowed or available).
     * User selects the status to filter by.
     */
    public void handleSearchByBorrowingStatus()
    {
        UserFlowHandler.runWithLoop(() -> {
            System.out.println("Press 1 to see borrowed books.");
            System.out.println("Press 2 to see returned books.");
            int choice = scanner.nextInt();
            scanner.nextLine();

            boolean isBorrowed;

            switch (choice)
            {
                case 1 -> isBorrowed = true;
                case 2 -> isBorrowed = false;
                default ->
                        {
                            System.out.println("Select a valid option.");
                            return;
                        }
            }

            List<Book> books = libraryController.searchBooksByBorrowingStatus(isBorrowed);

            if (books.isEmpty())
            {
                System.out.println("No books found for borrowing status: " + isBorrowed);
            }
            else
            {
                consolePrinter.printBookDetails(books);
            }
        });
    }

    /**
     * Displays all books currently in the library.
     */
    public void handleListAllBooks()
    {
        UserFlowHandler.runWithLoop(libraryController::listBooks);
    }

    /**
     * Allows the user to borrow a book by providing its title.
     * Checks if the book is available before borrowing.
     */
    public void handleBorrowBook()
    {
        UserFlowHandler.runWithLoop(() -> {
            List<Book> books = libraryController.searchBooksByBorrowingStatus(false);

            if (books.isEmpty())
            {
                System.out.println("No books found.");
            }
            else
            {
                consolePrinter.printBookDetails(books);
            }

            System.out.println("Enter the name of the book you want to borrow: ");
            String bookName = scanner.nextLine();

            Book book = libraryController.searchBookByTitle(bookName);

            if (book == null)
            {
                System.out.println("Book not found.");
                return;
            }

            if (book.isBorrowed())
            {
                System.out.println("The book has been borrowed.");
            }
            else
            {
                libraryController.borrowBook(book);
            }
        });
    }

    /**
     * Allows the user to return a borrowed book by providing its title.
     * Checks if the book is currently marked as borrowed.
     */
    public void handleReturnBook()
    {
        UserFlowHandler.runWithLoop(() -> {
            List<Book> books = libraryController.searchBooksByBorrowingStatus(true);

            if (books.isEmpty())
            {
                System.out.println("No books found borrowed.");
            }
            else
            {
                consolePrinter.printBookDetails(books);
            }

            System.out.println("Enter the name of the book you want to return: ");
            String bookName = scanner.nextLine();

            Book book = libraryController.searchBookByTitle(bookName);

            if (book == null)
            {
                System.out.println("Book not found.");
                return;
            }

            if (book.isBorrowed())
            {
                libraryController.returnBook(book);
            }
            else
            {
                System.out.println("This book is not currently borrowed.");
            }
        });
    }
}
