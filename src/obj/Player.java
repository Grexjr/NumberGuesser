package obj;

import java.util.ArrayList;
import java.util.Scanner;

public class Player {

    // Variables for players
    private final ArrayList<Integer> guessList;
    private int shortestGuesses,guessNumber,roundsWon;

    // Constructor for player
    public Player(){
        this.guessList = new ArrayList<>();
        this.shortestGuesses = 10000;
        this.guessNumber = 0;
        this.roundsWon = 0;
    }

    // Getters and Setters
    public ArrayList<Integer> getGuessList() {return guessList;}
    public int getShortestGuesses() {return this.shortestGuesses;}
    public int getGuessNumber() {return this.guessNumber;}
    public int getRoundsWon() {return this.roundsWon;}

    public void setShortestGuesses(int guesses){this.shortestGuesses = guesses;}
    public void setGuessNumber(int guess){this.guessNumber = guess;}
    public void setRoundsWon(int rounds){this.roundsWon = rounds;}

    // Other player methods
    // === PLAYER HELPER METHODS ===

    // Check if player exceeds certain guess limit (true exceeds or meets, false doesn't)
    public boolean exceedsGuess(int guessNum){return this.guessNumber >= guessNum;}

    // Win round methods
    private int incrementWonRounds(){return this.roundsWon + 1;}
    public void winRound(){this.setRoundsWon(incrementWonRounds());}


    // === PLAYER STAT METHODS ===

    // --- Player shortest guesses methods ---

    // check if an integer is smaller than the shortest guess
    private boolean isGuessQuicker(int guessNum){return guessNum < shortestGuesses;}

    // save the lowest guess into shortestGuesses if it is quicker
    private void saveLowestGuess(int guessNum){
        if(isGuessQuicker(guessNum)){
            this.shortestGuesses = guessNum;
        }
    }

    // calculate the lowest guess
    public void calculateLowestGuess(){saveLowestGuess(this.guessNumber);}

    // === PLAYER ACTION METHODS ===

    // Guess number method
    public int guessNumber(){
        this.guessNumber++;
        Scanner kb = new Scanner(System.in);
        return kb.nextInt();
    }

    // Make choice methods
    public Choice detectChoice(int choiceSet){
        ArrayList<Choice> possibleChoices = Choice.possibleChoices(choiceSet);
        Scanner kb = new Scanner(System.in);
        String choice = kb.nextLine();

        for(Choice bankedChoice : possibleChoices){
            if(choice.equalsIgnoreCase(bankedChoice.getChoiceLabel())){
                return bankedChoice;
            }
        }
        return Choice.INVALID;
    }




}
