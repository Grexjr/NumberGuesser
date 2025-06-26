package obj;

import java.util.ArrayList;
import java.util.Scanner;

public class Player {

    // Variables for players
    private final ArrayList<Integer> guessList;
    private int shortestGuesses,guessNumber;

    // Constructor for player
    public Player(){
        this.guessList = new ArrayList<Integer>();
        this.shortestGuesses = 0;
        this.guessNumber = 0;
    }

    // Getters and Setters
    public ArrayList<Integer> getGuessList() {return guessList;}
    public int getShortestGuesses() {return this.shortestGuesses;}
    public int getGuessNumber() {return this.guessNumber;}

    public void setShortestGuesses(int guesses){this.shortestGuesses = guesses;}
    public void setGuessNumber(int guess){this.guessNumber = guess;}

    // Other player methods
    // Guess number method
    public int guessNumber(){
        Scanner kb = new Scanner(System.in);
        return kb.nextInt();
    }

    // Check if player exceeds certain guess limit (true exceeds, false doesn't)
    public boolean exceedsGuess(int guessNum){return this.guessNumber > guessNum;}




}
