package view;

import controller.GameStrings;

import java.util.Arrays;

import static controller.Strings.GAME_STRINGS_MAP;

public class PrintMessage {


    // === VARIABLES AND FIELDS ===
    private final String[] args;

    // === CONSTRUCTOR ===
    public PrintMessage(GameStrings type, String... vars){
        // Switch for which type it is, only for those with vars
        switch(type){
            case INTRO -> this.args = new String[]{
                    getString(GameStrings.INTRO)[0],
                    vars[0],
                    getString(GameStrings.INTRO)[1]
            };
            case LOSS -> this.args = new String[]{
                    getString(GameStrings.LOSS)[0],
                    vars[0],
                    getNewLine()
            };
            case GAME_END -> this.args = new String[]{
                    getString(GameStrings.GAME_END)[0],
                    vars[0],
                    getNewLine(),
                    getString(GameStrings.GAME_END)[1],
                    vars[1],
                    getString(GameStrings.GAME_END)[2]
            };
            case ROUND -> this.args = new String[]{
                    getString(GameStrings.ROUND)[0],
                    vars[0]
            };
            case GUESSES_LEFT -> this.args = new String[]{
                    getString(GameStrings.GUESSES_LEFT)[0],
                    vars[0],
                    getString(GameStrings.GUESSES_LEFT)[0]
            };
            case GUESS_LIST -> this.args = new String[]{
                    getString(GameStrings.GUESS_LIST)[0],
                    Arrays.toString(vars),
                    getNewLine()
            };
            case SYSTEM_INPUT -> this.args = new String[]{
                    vars[0]
            };
            // Default handles ALL strings without vars
            default -> this.args = new String[]{
                    getString(type)[0]
            };
        }
    }

    // === CONSTRUCTOR METHODS ===
    private String[] getString(GameStrings type){
        return GAME_STRINGS_MAP.get(type);
    }

    private String getNewLine(){
        return getString(GameStrings.BASIC_STRING_OPERATORS)[0];
    }


    // === TO STRING ===
    @Override
    public String toString(){
        return Arrays.toString(this.args)
                .replace(",","")
                .replace("[","")
                .replace("]","")
                .trim() + "\n";
    }


}
