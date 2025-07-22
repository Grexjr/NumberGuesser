package controller;

public class Strings {

    /*******************************************************************************************************************
     * A class of string constants for the controller to use whenever it needs to custom print data
     * QUESTION: SHOULD I MOVE THESE TO GAME VIEW AGAIN AND JUST CREATE A PRINT METHOD THERE? ----
     ******************************************************************************************************************/

    public static final String[] GAME_QUESTIONS = new String[]{
            // Difficulty Q (0)
            "What difficulty would you like?\n (type: easy, medium, hard, or impossible)\n",

            // Continue Q (1)
            "Continue game?\n(type yes or no)\n"
    };

    public static final String[] GAME_DECLARATIONS = new String[]{
            // Win declaration (0)
            "You win!\n",

            // Try again declaration (1)
            "Try again!\n\n",

            // Computer ask for guess declaration (2)
            "What is your guess? \n\n",

            // Computer tells positive result declaration (3,4)
            "You... win!? Impossible! \n",
            "Malfunctioning... need... System... reset.... \n\n",

            // Computer tells negative result declaration (5)
            "You fool... INCORRECT! \n",

            // Computer tells lower guess declaration (6)
            "You'll never guess that my number is lower than your guess! \n",

            // Computer tells higher guess declaration (7)
            "You'll never guess that my number is higher than your guess! \n"
    };

    public static final String[] SYSTEM_DECLARATIONS = new String[]{
            // Invalid input declaration (0)
            "INVALID INPUT!\n",
    };





}
