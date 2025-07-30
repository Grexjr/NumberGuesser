package arc;

import obj.Computer;
import obj.Player;

public class Round {


    // === VARIABLES AND FIELDS ===

    private final Computer computer;
    private final int roundNumber, maxGuesses;
    private boolean roundOver;


    // === CONSTRUCTOR FOR ROUND ===
    public Round(int roundNumber, int guesses, Player player){
        this.roundNumber = roundNumber;
        this.computer = new Computer();
        this.maxGuesses = guesses;
        this.roundOver = false;

        // Set up and print round method after initialization
        player.setGuessNumber(0);
        player.getGuessList().clear();
        setUpRound(this.returnGuessesLeft(player.getGuessNumber()));
    }


    // === GETTERS AND SETTERS ===

    public Computer getComputer() {return computer;}
    public int getRoundNumber() {return roundNumber;}
    public int getMaxGuesses() {return this.maxGuesses;}
    public boolean getRoundOver() {return this.roundOver;}


    // === ROUND HELPER METHODS ===

    // General round setup method
    private void setUpRound(int maxGuesses){
        System.out.println(printRound());
        System.out.println(this.computer.introduceSelf(maxGuesses));
    }

    // method to check if player loses (true loses, false not)
    public boolean checkLoss(Player player){return player.exceedsGuess(this.getMaxGuesses());}

    // calculate guesses left
    public int returnGuessesLeft(int numOfGuesses){
        return maxGuesses - numOfGuesses;
    }

    // --- ROUND STAT METHODS ---

    // Logic to print the guess list of the player; concat strings of guesses together
    private String logicToPrintGuessList(Player player){
        String listString = "\n";
        for(int guess : player.getGuessList()){
            listString = listString.concat(String.valueOf(guess)) + "\n";
        }
        return listString;
    }


    // === PRINT ROUND METHODS ===

    // String return for round
    public String printRound(){return "Round: " + this.getRoundNumber();}

    // Print how many guesses are left
    public String printGuessesLeft(int numOfGuesses){
        return "\n" +
                returnGuessesLeft(numOfGuesses) +
                " Guesses left!" +
                "\n \n";
    }

    // Print guess list
    public String printGuessList(Player player){
        return "You guessed: \n" +
                logicToPrintGuessList(player) +
                "\n";
    }


    // === PLAY ROUNDS METHODS ===

    // PLAY ROUND RESULTS
    public String playRoundResults(int guess){
        if(computer.checkGuess(guess)){this.roundOver = true;}
        return this.computer.tellResult(guess);
    }



}
