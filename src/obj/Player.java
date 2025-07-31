package obj;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Player {


    // === VARIABLES AND FIELDS ===
    private final ArrayList<Integer> guessList;
    private int shortestGuesses,guessNumber,roundsWon,currentGuess;


    // === PLAYER CONSTRUCTOR ===
    public Player(){
        this.guessList = new ArrayList<>();
        this.shortestGuesses = 10000;
        this.guessNumber = 0;
        this.roundsWon = 0;
        this.currentGuess = -1;
    }


    // === GETTERS AND SETTERS ===
    public ArrayList<Integer> getGuessList() {return guessList;}
    public int getShortestGuesses() {return this.shortestGuesses;}
    public int getGuessNumber() {return this.guessNumber;}
    public int getRoundsWon() {return this.roundsWon;}
    public int getCurrentGuess() {return currentGuess;}

    public void setGuessNumber(int guess){this.guessNumber = guess;}
    public void setRoundsWon(int rounds){this.roundsWon = rounds;}
    public void setCurrentGuess(int guess){this.currentGuess = guess;}


    // === PLAYER HELPER METHODS ===


    // === PLAYER STAT METHODS ===


    // === PLAYER ACTION METHODS ===

    // Guess number method
    public void guessNumber(int guess){
        this.guessNumber++;
        this.currentGuess = guess;
        this.guessList.add(currentGuess);
    }



}
