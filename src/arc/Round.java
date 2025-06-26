package arc;

import obj.Computer;
import obj.Player;

public class Round {

    // Variables required for round
    private final Computer computer;
    private int roundNumber, maxGuesses;

    public Round(int roundNumber, int guesses){
        System.out.println(printRound());
        this.computer = new Computer();
        this.roundNumber = roundNumber;
        this.maxGuesses = guesses;
    }

    // Getters and Setters
    public Computer getComputer() {return computer;}
    public int getRoundNumber() {return roundNumber;}
    public int getMaxGuesses() {return this.maxGuesses;}

    public void setRoundNumber(int roundNumber) {this.roundNumber = roundNumber;}
    public void setMaxGuesses(int guesses) {this.maxGuesses = guesses;}

    // Other round methods
    // String return for round
    public String printRound(){return "Round: " + this.getRoundNumber();}
    // Method to check if player has exceeded max guesses





}
