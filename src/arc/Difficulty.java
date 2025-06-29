package arc;

public enum Difficulty {


    // === ENUM VALUES ===

    EASY(25),
    MEDIUM(15),
    HARD(10),
    IMPOSSIBLE(5);

    // === ENUM VARIABLES/FIELDS ===
    private final int maxGuesses;


    // === CONSTRUCTOR FOR ENUM ===
    Difficulty(int guesses){
        this.maxGuesses = guesses;
    }


    // === GETTERS AND SETTERS ===
    public int getMaxGuesses(){return this.maxGuesses;}


}
