package controller;

import java.util.EnumMap;

public class Strings {

    /*******************************************************************************************************************
     * A class of string constants for the controller to use whenever it needs to custom print data
     * QUESTION: Make this a hashmap of enums and string arrays, then put all the print messages into here as well?
     ******************************************************************************************************************/

    public static final EnumMap<GameStrings,String> GAME_STRINGS_MAP = new EnumMap<GameStrings,String>(GameStrings.class){{
        put(GameStrings.DIFFICULTY_QUESTION,"WHICH DIFFICULTY?\n");
        put(GameStrings.CONTINUE_QUESTION,"Continue game?\n");
        put(GameStrings.GUESS_QUESTION,"What is your guess? \n\n");

        put(GameStrings.WIN_DECLARATION,"You win!\n");
        put(GameStrings.TRY_AGAIN_DECLARATION,"Try again!\n\n");
        put(GameStrings.POSITIVE_RESULT_DECLARATION,
                "You... win!? Impossible! \n Malfunctioning... need... System... reset.... \n\n");
        put(GameStrings.NEGATIVE_RESULT_DECLARATION,"You fool... INCORRECT! \n");
        put(GameStrings.HIGHER_GUESS_DECLARATION,"You'll never guess that my number is lower than your guess! \n");
        put(GameStrings.LOWER_GUESS_DECLARATION,"You'll never guess that my number is higher than your guess! \n");

        put(GameStrings.SYSTEM_INVALID_INPUT,"INVALID INPUT!\n");

        put(GameStrings.BASIC_STRING_NEWLINE,"\n");
    }};

}
