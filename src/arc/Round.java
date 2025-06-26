package arc;

import obj.Computer;
import obj.Player;

public class Round {

    // Variables required for round
    private final Computer computer;
    private int roundNumber, maxGuesses;
    private boolean roundOver;

    public Round(int roundNumber, int guesses){
        System.out.println(printRound());
        this.computer = new Computer();
        this.roundNumber = roundNumber;
        this.maxGuesses = guesses;
        this.roundOver = false;
    }

    // Getters and Setters
    public Computer getComputer() {return computer;}
    public int getRoundNumber() {return roundNumber;}
    public int getMaxGuesses() {return this.maxGuesses;}
    public boolean getRoundOver() {return this.roundOver;}

    public void setRoundNumber(int roundNumber) {this.roundNumber = roundNumber;}
    public void setMaxGuesses(int guesses) {this.maxGuesses = guesses;}

    // Other round methods
    // String return for round
    public String printRound(){return "Round: " + this.getRoundNumber();}

    // PLAY ROUND RESULTS
    public String playRoundResults(int guess){
        if(computer.checkGuess(guess)){
            this.roundOver = true;
        }
        return this.computer.tellResult(guess);
    }

    // calculate guesses left
    public int returnGuessesLeft(int numOfGuesses){
        return maxGuesses - numOfGuesses;
    }

    public String printGuessesLeft(int numOfGuesses){
        return "\n" +
                returnGuessesLeft(numOfGuesses) +
                " Guesses left!" +
                "\n \n";}



}
