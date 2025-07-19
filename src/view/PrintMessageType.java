package view;

public enum PrintMessageType {

    // === VALUES FOR ENUM ===
    // --- Game Printing ---
    INTRO(
            "Muahahahaha!\nI am an evil computer. Guess my number or perish!\nYou have",
            "guesses! \n"
    ),
    LOSS(
            "You Lose! Muahahaha! No more games for you!\n\nThe number was "
    ),
    GAME_END(
            "Game is over!\nStats:\nRounds won: ",
            "Your record for shortest guesses is: ",
            "\n\n Ending game..."
    ),

    // --- Round Printing ---
    ROUND(
            "Round: "
    ),
    GUESSES_LEFT(
            " guesses left!\n\n"
    ),
    GUESS_LIST(
            "You guessed:\n"
    ),

    CUSTOM();


    // === VARIABLES AND FIELDS ===
    private final String[] strings;


    // === CONSTRUCTOR ===
    PrintMessageType(String... args){
        this.strings = args;
    }


    // === GETTER ===
    public String[] getStrings() {return strings;}


}
