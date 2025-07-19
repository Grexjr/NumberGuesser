package view;

import java.util.Arrays;

public class PrintMessage {

    // === ENUM FOR TYPE ===
    public enum Type{
        // --- Game Printing ---
        INTRO,
        DIFFICULTY_QUESTION,
        LOSS,
        WIN,
        TRY_AGAIN,
        CONTINUE_QUESTION,
        GAME_END,

        // --- Round Printing ---
        ROUND,
        GUESSES_LEFT,
        GUESS_LIST;
    }

    // === VARIABLES AND FIELDS ===
    private String[] args;


    // === CONSTRUCTOR
    public PrintMessage(Type type, String... vars){ //TODO: Condense these, add a CUSTOM type for no vars args
        switch(type){
            case INTRO -> this.args = new String[]{
                    "Muahahahaha!\nI am an evil computer. Guess my number or perish!\nYou have ",
                    vars[0],
                    "guesses! \n"};
            case DIFFICULTY_QUESTION -> this.args = new String[]{
                    "What difficulty would you like?\n (type: easy, medium, hard, or impossible)\n"
            };
            case LOSS -> this.args = new String[]{
                    "You Lose! Muahahaha! No more games for you!\n\nThe number was ",
                    vars[0],
                    "\n"
            };
            case WIN -> this.args = new String[]{
                    "You win!\n"
            };
            case TRY_AGAIN -> this.args = new String[]{
                    "Try again!\n\n"
            };
            case CONTINUE_QUESTION -> this.args = new String[]{
                    "Continue game?\n(type yes or no)\n"
            };
            case GAME_END -> this.args = new String[]{
                    "Game is over!\nStats:\nRounds won: ",
                    vars[0],
                    "\n",
                    "Your record for shortest guesses is: ",
                    vars[1],
                    "\n\n Ending game..."
            };
            case ROUND -> this.args = new String[]{
                    "Round: ",
                    vars[0]
            };
            case GUESSES_LEFT -> this.args = new String[]{
                    "\n",
                    vars[0],
                    " guesses left!\n\n"
            };
            case GUESS_LIST -> this.args = new String[]{
                    "You guessed:\n",
                    Arrays.toString(vars), // QUESTION: NOT SURE IF THIS WILL WORK OR NOT
                    "\n"
            };
        }
    }


    // === GETTERS ===
    public String[] getArgs() {return args;}


}
