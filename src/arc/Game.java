package arc;

import obj.Choice;
import obj.Player;

public class Game {

    // Variables for Game
    private Round round;
    private final Player player;
    private Difficulty gameDifficulty;
    private int maxGuesses;
    private boolean gameOver;

    // Constructor for Game
    public Game(){
        // Ensure gameOver starts false
        this.gameOver = false;

        // Create new player tracked through all rounds
        this.player = new Player();

        // Print the introduction
        System.out.println(printIntro());

        // Print asking for difficulty
        System.out.println(askDifficulty());
        this.gameDifficulty = chooseDifficulty();
        this.maxGuesses = this.gameDifficulty.getMaxGuesses();

        playGame(1);
    }

    // Getter
    public Round getRound() {return round;}
    public void setRound(Round round) {this.round = round;}

    public Player getPlayer() {return this.player;}

    public Difficulty getGameDifficulty() {return this.gameDifficulty;}
    public void setGameDifficulty(Difficulty difficulty) {this.gameDifficulty = difficulty;}

    public int getMaxGuesses() {return this.maxGuesses;}
    public void setMaxGuesses(int guesses) {this.maxGuesses = guesses;}

    // Other Game methods
    // Calculate game stats

    // Lowest guess methods
    public int saveLowestGuess(){
        int lowestGuess = 10000;
        if(this.player.getGuessNumber() < lowestGuess){
            lowestGuess = this.player.getGuessNumber();
            return lowestGuess;
        }
        return this.player.getGuessNumber();
    }

    //TODO: Need to make this happen after each round, NOT just when game ends
    public void givePlayerLowestGuess(){this.player.setShortestGuesses(saveLowestGuess());}

    // Rounds won methods
    public void givePlayerRoundWon(){this.player.winRound();}

    // Calculate both stats method
    public void calculateStats(){
        givePlayerRoundWon();
        // Don't give player lowest guess because that happens at end of each round
        //TODO: Make giving player lowest guess occur in round.java
    }

    // Print methods
    // method to print opening
    public String printIntro(){
        return "Welcome to the number guessing game! \n\n";
    }

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
    public Difficulty chooseDifficulty(){
        return switch (this.player.detectChoice(1)) {
            case Choice.EASY -> Difficulty.EASY;
            case Choice.MEDIUM -> Difficulty.MEDIUM;
            case Choice.HARD -> Difficulty.HARD;
            case Choice.IMPOSSIBLE -> Difficulty.IMPOSSIBLE;
            default -> {
                System.out.print("INVALID CHOICE! Setting to impossible...\n");
                yield Difficulty.IMPOSSIBLE;
            }
        };
    }

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
    //TODO: Refactor to make clearer, but general idea is game does loop of its stuff, round does loop of its stuff
    //TODO: Move things between here and round and create more methods for these invidiual raw implementations
    public void playGame(int roundNum) {
        this.round = new Round(roundNum, this.maxGuesses, this.player);
        while (!this.gameOver) {
            while (!this.round.checkLoss(this.player)){
                this.round.playRound(this.player);
                givePlayerLowestGuess();
                if (this.round.checkLoss(this.player)) {
                    lose();
                    break;
                }
                if (round.getRoundOver()) {
                    int newRound = win(roundNum);
                    runContinueChoice(newRound);
                } else {
                    System.out.print(printTryAgain());
                }
            }
        }
    }







}
