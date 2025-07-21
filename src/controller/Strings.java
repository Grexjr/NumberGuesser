package controller;

public class Strings {

    /*******************************************************************************************************************
     * A class of string constants for the controller to use whenever it needs to custom print data
     * QUESTION: SHOULD I MOVE THESE TO GAME VIEW AGAIN AND JUST CREATE A PRINT METHOD THERE? ----
     ******************************************************************************************************************/

    protected static final String[] GAME_QUESTIONS = new String[]{
            // Difficulty Q (0)
            "What difficulty would you like?\n (type: easy, medium, hard, or impossible)\n",

            // Continue Q (1)
            "Continue game?\n(type yes or no)\n"
    };

    protected static final String[] GAME_DECLARATIONS = new String[]{
            // Win declaration (0)
            "You win!\n",

            // Try again declaration (1)
            "Try again!\n\n",

            // Computer ask for guess declaration (2)
            "What is your guess? \n\n"
    };





}
