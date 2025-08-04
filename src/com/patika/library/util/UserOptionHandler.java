package com.patika.library.util;

import java.util.Scanner;

/**
 * Utility class to handle user input for selecting a next action after an operation.
 *
 * <p>
 *     This class provides a single responsibility: to ask the user what they want
 *     to do next (repeat, return to menu, or quit), and return a corresponding
 *     {@link UserAction} enum.
 * </p>
 *
 * <p>
 *     It's typically used within {@link UserFlowHandler} to control the flow of
 *     console operations.
 * </p>
 *
 * Example:
 * <pre>{@code
 *          UserAction action = UserOptionHandler.getUserNextAction();
 * }</pre>
 *
 * @author Canberk Sarıkaya
 * @version 1.0
 */
public class UserOptionHandler
{
    private static final Scanner scanner = new Scanner(System.in);

    /**
     * Prompts the user to choose the next action after an operation is completed.
     * <p>
     *     Options:
     *     <ul>
     *         <li>1 - Repeat the same action</li>
     *         <li>2 - Return to main menu</li>
     *         <li>3 - Quit the application</li>
     *     </ul>
     * </p>
     *
     * <p>If the user enters an invalid option, the method recursively asks again.</p>
     *
     * @return A {@link UserAction} enum representing the user's decision.
     */
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
                yield getUserNextAction(); // Recursion for valid input.
            }
        };
    }
}
