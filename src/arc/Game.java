package arc;

import obj.Player;

public class Game {

    // Variables for Game
    private Round round;
    private final Player player;

    // Constructor for Game
    public Game(){
        this.player = new Player();
        System.out.println("Welcome to the number guessing game!");
        playGame();
    }

    // Getter
    public Round getRound() {return round;}
    public void setRound(Round round) {this.round = round;}

    public Player getPlayer() {return this.player;}

    // Other Game methods
    public void createNewRound(){
        this.setRound(new Round(this.round.getRoundNumber() + 1, this.round.getMaxGuesses()));
    }

    // method to check if player loses (true loses, false not)
    public boolean checkLoss(){return player.exceedsGuess(this.round.getMaxGuesses());}

    // method to print loss
    public String printLoss(){
        return "You Lose! Muahahaha! No more games for you!" +
                "The number was " + this.round.getComputer().getSecretNumber() +
                "\n"
                ;}

    // method to print win
    public String printWin(){return "You win! \n";}

    // method to print try again
    public String printTryAgain(){return "Try again! \n";}

    // PLAY GAME METHOD
    public void playGame(){
        this.round = new Round(1,10); // will need to change this but not now
        while(!checkLoss()) {
            //TODO: Figure out how to redo the beginning of the round again... create a new round
            System.out.print(this.round.playRoundResults(this.player.guessNumber()));
            if (checkLoss()) {
                System.out.print(printLoss());
                break;
            }
            if (round.getRoundOver()) {
                System.out.print(printWin());
                this.round.setRoundNumber(this.round.getRoundNumber()+1);
            }
            else {
                System.out.print(this.round.printGuessesLeft(this.player.getGuessNumber()));
                System.out.print(printTryAgain());
            }
        }
    }

}
