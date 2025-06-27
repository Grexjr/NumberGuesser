package obj;

import java.util.ArrayList;
import java.util.Scanner;

public class Player {

    // Variables for players
    private final ArrayList<Integer> guessList;
    private int shortestGuesses,guessNumber,roundsWon;

    // Constructor for player
    public Player(){
        this.guessList = new ArrayList<Integer>();
        this.shortestGuesses = 0;
        this.guessNumber = 0;
        this.roundsWon = 0;
    }

    // Getters and Setters
    public ArrayList<Integer> getGuessList() {return guessList;}
    public int getShortestGuesses() {return this.shortestGuesses;}
    public int getGuessNumber() {return this.guessNumber;}

    public void setShortestGuesses(int guesses){this.shortestGuesses = guesses;}
    public void setGuessNumber(int guess){this.guessNumber = guess;}
    public void setRoundsWon(int rounds){this.roundsWon = rounds;}

    // Other player methods
    // Guess number method
    public int guessNumber(){
        this.guessNumber++;
        Scanner kb = new Scanner(System.in);
        return kb.nextInt();
    }

    // Check if player exceeds certain guess limit (true exceeds or meets, false doesn't)
    public boolean exceedsGuess(int guessNum){return this.guessNumber >= guessNum;}

    // Win round methods
    public int incrementWonRounds(){return this.roundsWon + 1;}

    public void winRound(){this.setRoundsWon(incrementWonRounds());}

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
