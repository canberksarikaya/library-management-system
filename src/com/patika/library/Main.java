package com.patika.library;

import com.patika.library.ui.ConsoleUI;

/**
 * Entry point of the Library Management System.
 *
 * <p>
 *     This class is responsible for starting the console-based user interface
 *     which allows the user to interact with the library system.
 * </p>
 *
 * @author Canberk Sarıkaya
 * @version 1.0
 */
public class Main
{
    /**
     * ConsoleUI instance that handles user interactions through the terminal.
     */
    static final ConsoleUI consoleUI = new ConsoleUI();

    /**
     * Main method which starts the application.
     *
     * @param args command-line arguments (not used in this application)
     */
    public static void main(String[] args)
    {
        consoleUI.mainMenu();
    }
}
