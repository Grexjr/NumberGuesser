package view;

import java.util.Arrays;

public class PrintMessage {
    // QUESTION: Should I make these all one big array and choose from there?
    // QUESTION: Or should I turn these into enums and just call their string components? Put these into type enum?
    // === CONSTANTS ===
    private static final String[] STRING_OPERATORS = new String[]{
            // New line (0)
            "\n",
    };

    // === VARIABLES AND FIELDS ===
    private final String[] args;


    // === CONSTRUCTOR
    public PrintMessage(PrintMessageType type, String... vars){
        switch(type){
            case INTRO -> this.args = new String[]{
                    type.getStrings()[0],
                    vars[0],
                    type.getStrings()[1]};
            case LOSS -> this.args = new String[]{
                    type.getStrings()[0],
                    vars[0],
                    STRING_OPERATORS[0]
            };
            case GAME_END -> this.args = new String[]{
                    type.getStrings()[0],
                    vars[0],
                    STRING_OPERATORS[0],
                    type.getStrings()[1],
                    vars[1],
                    type.getStrings()[2]
            };
            case ROUND -> this.args = new String[]{
                    type.getStrings()[0],
                    vars[0]
            };
            case GUESSES_LEFT -> this.args = new String[]{
                    STRING_OPERATORS[0],
                    vars[0],
                    type.getStrings()[0]
            };
            case GUESS_LIST -> this.args = new String[]{
                    type.getStrings()[0],
                    Arrays.toString(vars), // QUESTION: NOT SURE IF THIS WILL WORK OR NOT
                    STRING_OPERATORS[0]
            };
            default -> this.args = new String[]{
                    vars[0]
            };
        }
    }


    // === GETTERS ===
    public String[] getArgs() {return args;}


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
