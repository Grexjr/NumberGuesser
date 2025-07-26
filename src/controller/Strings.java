package controller;

public class Strings {

    /*******************************************************************************************************************
     * A class of string constants for the controller to use whenever it needs to custom print data
     * QUESTION: SHOULD I MOVE THESE TO GAME VIEW AGAIN AND JUST CREATE A PRINT METHOD THERE?
     * TODO: MAKE THESE HASH MAPS!!!
     ******************************************************************************************************************/

    public static final String[] GAME_QUESTIONS = new String[]{
            // Difficulty Q (0)
            "WHICH DIFFICULTY?\n",

            // Continue Q (1)
            "Continue game?\n",

            // Computer ask for guess (2)
            "What is your guess? \n\n"
    };

    public static final String[] GAME_DECLARATIONS = new String[]{
            // Win declaration (0)
            "You win!\n",

            // Try again declaration (1)
            "Try again!\n\n",

            // Computer tells positive result declaration (2)
            "You... win!? Impossible! \n Malfunctioning... need... System... reset.... \n\n",

            // Computer tells negative result declaration (3)
            "You fool... INCORRECT! \n",

            // Computer tells lower guess declaration (4)
            "You'll never guess that my number is lower than your guess! \n",

            // Computer tells higher guess declaration (5)
            "You'll never guess that my number is higher than your guess! \n",

            // Game Over declaration [6,7]
            "Game is over! \n",
            "\n Ending game..."

    };

    public static final String[] SYSTEM_DECLARATIONS = new String[]{
            // Invalid input declaration (0)
            "INVALID INPUT!\n",
    };





}
