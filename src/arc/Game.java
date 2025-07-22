package arc;

import obj.Choice;
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

    // method to print asking for difficulty
    public String askDifficulty(){
        return "What difficulty would you like? \n (type: easy, medium, hard, or impossible) \n";
    }

    // method to print loss
    public String printLoss(){
        return "You Lose! Muahahaha! No more games for you! \n\n" +
                "The number was " + this.round.getComputer().getSecretNumber() +
                "\n"
                ;}

    // method to print win
    public String printWin(){return "You win! \n";}

    // method to print try again
    public String printTryAgain(){return "Try again! \n\n";}

    // method to print continue or not
    public String printContinueQuestion(){return "Continue game? \n (type yes or no) \n";}

    // method to print stats
    public String printStats(){
        return "Stats: \n"+
                "Rounds won: " +
                this.player.getRoundsWon() + "\n" +
                "Your record for shortest guesses is: " +
                this.player.getShortestGuesses() + "\n";
    }

    // method to print end of game
    public String printEnd(){return "Game is over! \n" +
            printStats() +
            "\n Ending game...";}

    // Helper methods
    // Method for changing the difficulty

    // Method for continue or not choice
    private void runContinueChoice(int roundNum){
        System.out.print(printContinueQuestion());
        if(this.player.detectChoice(2).equals(Choice.YES)){
            this.round = new Round(roundNum,this.maxGuesses,this.player);
        } else {
            System.out.print(printEnd());
            this.gameOver = true;
            System.exit(0);
        }
    }

    // === GAMEPLAY METHODS ===

    // Win method -- no win game, goes on forever
    private int win(int roundNum){
        System.out.print(printWin());
        calculateStats();
        return roundNum + 1;
    }

    // Lose game method
    private void lose(){
        System.out.print(printLoss());
        System.out.print(printEnd());
    }

    // PLAY GAME METHOD
    //TODO: Refactor this method, if it needs it, for clarity and simplicity and ease of understanding
    public void playGame(int roundNum) {
        while (!checkGameOver()) {
            this.round = new Round(roundNum, this.maxGuesses, this.player);
            while (!this.round.checkLoss(this.player)){
                this.round.playRound(this.player);
                if (this.round.checkLoss(this.player)) {
                    lose();
                    break;
                }
                if (this.round.getRoundOver()) {
                    System.out.print(this.round.printGuessList(this.player));
                    int newRound = win(roundNum);
                    runContinueChoice(newRound);
                } else {
                    System.out.print(printTryAgain());
                }
            }
        }
    }







}
