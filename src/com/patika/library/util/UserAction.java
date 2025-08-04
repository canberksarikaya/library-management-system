package com.patika.library.util;

/**
 * Represents user actions after completing an operation in the UI.
 * Used for controlling flow in loop-based interactions.
 *
 * <ul>
 *     <li>{@link #REPEAT} - Repeat the current operation</li>
 *     <li>{@link #RETURN_MENU} - Return to the main menu</li>
 *     <li>{@link #QUIT} - Exit the application</li>
 * </ul>
 *
 * This enum helps to avoid magic values and improves readability of the control
 * flow logic.
 *
 * @author Canberk Sarıkaya
 * @version 1.0
 */
public enum UserAction
{
    /**
     * Indicates that the current operation should be repeated.
     */
    REPEAT,
    /**
     * Indicates that the program should return to the main menu.
     */
    RETURN_MENU,
    /**
     * Indicates that the application should be terminated.
     */
    QUIT
}
