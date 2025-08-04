package com.patika.library.util;

/**
 * Utility class for handling repetitive user operations in a console-based flow.
 *
 * <p>
 *     This class provides a reusable way to wrap any operation that should repeat
 *     based on user input. It integrates with {@link UserOptionHandler} and {@link UserAction}
 *     to control the loop flow.
 * </p>
 *
 * <p>
 *     Use this when you want to present a menu or action repeatedly, until the user
 *     chooses to return to main menu or quit the application.
 * </p>
 *
 * Example:
 * <pre>
 *     {
 *     @code UserFlowHandler.runWithLoop(() -> {
 *         // operation logic (e.g., search, add, delete)
 *     });
 *     }
 * </pre>
 *
 * @author Canberk Sarıkaya
 * @version 1.0
 */
public class UserFlowHandler
{
    /**
     * Repetas the given action in a loop based on the user's selected {@link UserAction}
     *
     * @param action A {@link Runnable} containing the operation logic to repeat.
     */
    public static void runWithLoop(Runnable action)
    {
        boolean isRunning = true;

        while (isRunning)
        {
            action.run();

            UserAction userAction = UserOptionHandler.getUserNextAction();

            switch (userAction)
            {
                case REPEAT -> {
                    // Do nothing, loop continues
                }
                case RETURN_MENU -> isRunning = false;
                case QUIT ->
                {
                    isRunning = false;
                    System.out.println("Quitting the application.");
                    System.exit(0);
                }
            }
        }
    }
}
