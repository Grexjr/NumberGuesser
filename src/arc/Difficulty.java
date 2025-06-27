package arc;

public enum Difficulty {

    // Enum values
    EASY(25),
    MEDIUM(15),
    HARD(10),
    IMPOSSIBLE(5);

    // Variables for enum
    private final int maxGuesses;

    // Enum constructor
    Difficulty(int guesses){
        this.maxGuesses = guesses;
    }

    public int getMaxGuesses(){return this.maxGuesses;}


}
