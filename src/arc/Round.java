package arc;

import obj.Computer;
import obj.Player;

public class Round {

    // Variables required for round
    private final Computer computer;
    private int roundNumber, maxGuesses;
    private boolean roundOver;

    public Round(int roundNumber, int guesses, Player player){
        this.roundNumber = roundNumber;
        this.computer = new Computer();
        this.maxGuesses = guesses;
        this.roundOver = false;

        // Set up and print round method after initialization
        player.setGuessNumber(0);
        setUpRound(this.returnGuessesLeft(player.getGuessNumber()));

        playRound(player);
    }

    // Getters and Setters
    public Computer getComputer() {return computer;}
    public int getRoundNumber() {return roundNumber;}
    public int getMaxGuesses() {return this.maxGuesses;}
    public boolean getRoundOver() {return this.roundOver;}

    public void setRoundNumber(int roundNumber) {this.roundNumber = roundNumber;}
    public void setMaxGuesses(int guesses) {this.maxGuesses = guesses;}
    public void setRoundOver(boolean value) {this.roundOver = value;}

    // General round setup method
    private void setUpRound(int maxGuesses){
        System.out.println(printRound());
        System.out.println(this.computer.introduceSelf(maxGuesses));
    }

    // Other round methods
    // method to check if player loses (true loses, false not)
    public boolean checkLoss(Player player){return player.exceedsGuess(this.getMaxGuesses());}

    // String return for round
    public String printRound(){return "Round: " + this.getRoundNumber();}

    // PLAY ROUND METHOD
    public void playRound(Player player){
        while(!this.roundOver){
            System.out.print(this.computer.askForGuess());
            System.out.print(playRoundResults(player.guessNumber()));
            if(!this.roundOver) {System.out.print(printGuessesLeft(player.getGuessNumber()));}
        }
    }

    // PLAY ROUND RESULTS
    public String playRoundResults(int guess){
        if(computer.checkGuess(guess)){this.roundOver = true;}
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
