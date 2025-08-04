package com.patika.library.util;

public class UserFlowHandler
{
    public static void runWithLoop(Runnable action)
    {
        boolean isRunning = true;

        while (isRunning)
        {
            action.run();

            UserAction userAction = UserOptionHandler.getUserNextAction();

            switch (userAction)
            {
                case REPEAT -> {}
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
