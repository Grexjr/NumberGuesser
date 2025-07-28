package controller;

import java.util.EnumMap;

public class Strings {

    /*******************************************************************************************************************
     * A class of string constants for the controller to use whenever it needs to custom print data
     * QUESTION: Make this a hashmap of enums and string arrays, then put all the print messages into here as well?
     * TODO: Put ALL strings in here, including button labels, etc.
     ******************************************************************************************************************/

    public static final EnumMap<GameStrings,String[]> GAME_STRINGS_MAP = new EnumMap<GameStrings,String[]>(GameStrings.class){{
       // === QUESTIONS ===
        put(
                GameStrings.DIFFICULTY_QUESTION,
                new String[]{"WHICH DIFFICULTY?\n"}
        );
        put(
                GameStrings.CONTINUE_QUESTION,
                new String[]{"Continue game?\n"}
        );
        put(
                GameStrings.GUESS_QUESTION,
                new String[]{"What is your guess? \n\n"}
        );


        // === DECLARATIONS NO VARS ===
        put(
                GameStrings.WIN_DECLARATION,
                new String[]{"You win!\n"}
        );
        put(
                GameStrings.TRY_AGAIN_DECLARATION,
                new String[]{"Try again!\n\n"}
        );
        put(
                GameStrings.POSITIVE_RESULT_DECLARATION,
                new String[]{"You... win!? Impossible! \n Malfunctioning... need... System... reset.... \n\n"}
        );
        put(
                GameStrings.NEGATIVE_RESULT_DECLARATION,
                new String[]{"You fool... INCORRECT! \n"}
        );
        put(
                GameStrings.HIGHER_GUESS_DECLARATION,
                new String[]{"You'll never guess that my number is lower than your guess! \n"}
        );
        put(
                GameStrings.LOWER_GUESS_DECLARATION,
                new String[]{"You'll never guess that my number is higher than your guess! \n"}
        );


        // === GAME DECLARATIONS WITH VARS ===
        put(
                GameStrings.INTRO,
                new String[]{
                        "Muahahahaha!\nI am an evil computer. Guess my number or perish!\nYou have",
                        "guesses! \n"
                }
        );
        put(
                GameStrings.LOSS,
                new String[]{
                        "You Lose! Muahahaha! No more games for you!\n\nThe number was "
                }
        );
        put(
                GameStrings.GAME_END,
                new String[]{
                        "Game is over!\nStats:\nRounds won: ",
                        "Your record for shortest guesses is: ",
                        "\n\n Ending game..."
                }
        );
        put(
                GameStrings.ROUND,
                new String[]{
                        "Round: "
                }
        );
        put(
                GameStrings.GUESSES_LEFT,
                new String[]{
                        " guesses left!\n\n"
                }
        );
        put(
                GameStrings.GUESS_LIST,
                new String[]{
                        "You guessed:\n"
                }
        );


        // === SYSTEM DECLARATIONS ===
        put(
                GameStrings.SYSTEM_DECLARATIONS,
                new String[]{
                        "INVALID INPUT!\n"
                }
        );
        put(
                GameStrings.SYSTEM_INPUT,
                new String[]{}
        );


        // === BASIC STRING OPERATORS ===
        put(
                GameStrings.BASIC_STRING_OPERATORS,
                new String[]{
                        "\n"
                }
        );
    }};

}
