package com.patika.library.util;

import java.util.Scanner;

public class UserOptionHandler
{
    private static final Scanner scanner = new Scanner(System.in);

    public static UserAction getUserNextAction()
    {
        System.out.println("Press 1 to repeat the action.");
        System.out.println("Press 2 to return main menu.");
        System.out.println("Press 3 to quit application.");

        int option = scanner.nextInt();
        scanner.nextLine();

        return switch (option)
        {
            case 1 -> UserAction.REPEAT;
            case 2 -> UserAction.RETURN_MENU;
            case 3 -> UserAction.QUIT;
            default ->
            {
                System.out.println("Invalid option.");
                yield getUserNextAction();
            }
        };
    }
}
