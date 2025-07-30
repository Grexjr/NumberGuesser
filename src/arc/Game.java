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

    // --- GAME STAT METHODS ---


    // === GAME PRINT METHODS ===


    // === GAMEPLAY METHODS ===
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
