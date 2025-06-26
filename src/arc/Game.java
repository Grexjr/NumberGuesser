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
        this.round = new Round(1,10);
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

    // PLAY GAME METHOD
    public void playGame(){

    }

}
