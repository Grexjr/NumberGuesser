package arc;

import obj.Computer;
import obj.Player;

public class Round {


    // === VARIABLES AND FIELDS ===

    private final Computer computer;
    private final int roundNumber, maxGuesses;


    // === CONSTRUCTOR FOR ROUND ===
    public Round(int roundNumber, int guesses, Player player){
        this.roundNumber = roundNumber;
        this.computer = new Computer();
        this.maxGuesses = guesses;

        // Set up and print round method after initialization
        player.setGuessNumber(0);
        player.getGuessList().clear();
    }


    // === GETTERS AND SETTERS ===

    public Computer getComputer() {return computer;}
    public int getRoundNumber() {return roundNumber;}
    public int getMaxGuesses() {return this.maxGuesses;}


    // === ROUND HELPER METHODS ===

    // --- ROUND STAT METHODS ---


    // === PLAY ROUNDS METHODS ===



}
