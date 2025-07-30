package arc;

import obj.Choice;
import obj.Computer;
import obj.Player;

public class Game {

    // === GAME VARIABLES ===
    private Round round;
    private final Player player;
    private Difficulty gameDifficulty;
    private int maxGuesses;
    private boolean gameOver;


    // === GAME CONSTRUCTOR ===
    public Game(){
        // Ensure gameOver starts false
        this.gameOver = false;

        // Create new player tracked through all rounds
        this.player = new Player();

        // Print the introduction
        System.out.println(printIntro());

        //playGame(1);
    }


    // === GETTERS AND SETTERS ===
    public Round getRound() {return round;}
    public void setRound(Round nextRound) {this.round = nextRound;}

    public Player getPlayer() {return player;}

    public Difficulty getGameDifficulty() {return gameDifficulty;}
    public void setGameDifficulty(Difficulty difficulty) {this.gameDifficulty = difficulty;}

    public int getMaxGuesses() {return maxGuesses;}
    public void setMaxGuesses(int guesses) {this.maxGuesses = guesses;}

    public boolean isGameOver() {return gameOver;}
    public void setGameOver(boolean val) {this.gameOver = val;}

    // === GAME HELPER METHODS ===
    private boolean checkGameOver(){return this.gameOver;}

    // --- GAME STAT METHODS ---

    // Rounds won methods
    public void givePlayerRoundWon(){this.player.winRound();}

    // Calculate both stats method
    public void calculateStats(){
        givePlayerRoundWon();
        // Don't give player lowest guess because that happens at end of each round
        //TODO: Make giving player lowest guess occur in round.java
    }


    // === GAME PRINT METHODS ===

    // method to print opening
    public String printIntro(){
        return "Welcome to the number guessing game! \n\n";
    }

    // method to print stats
    public String printStats(){
        return "Stats: \n"+
                "Rounds won: " +
                this.player.getRoundsWon() + "\n" +
                "Your record for shortest guesses is: " +
                this.player.getShortestGuesses() + "\n";
    }

    // === GAMEPLAY METHODS ===
    // increase player guess number
    public void increaseGuess(){

    }

    // return which guess result is appropriate | QUESTION: Should this go in round?
    public GuessResult calculateGuessResult(int guess){
        Computer computer = this.getRound().getComputer();
        player.guessNumber(guess);

        if(guess != computer.getSecretNumber()){
            if(player.getGuessNumber() >= this.getRound().getMaxGuesses()){
                return GuessResult.LOSE_ROUND;
            } else {
                if (guess > computer.getSecretNumber()) {
                    return GuessResult.LOWER_KEEP_GOING;
                }
                if (guess < computer.getSecretNumber()) {
                    return GuessResult.HIGHER_KEEP_GOING;
                }
            }
        } else {
            return GuessResult.WIN_ROUND;
        }
        return GuessResult.INVALID_RESULT; // TODO: error handling here
    }







}
