package controller;

import arc.Difficulty;
import arc.Game;
import arc.GuessResult;
import arc.Round;
import obj.Player;
import view.*;

import javax.swing.*;

public class GameController {

    // === VARIABLES AND FIELDS ===
    private final Game gameState;
    private final GameWindow gameGUI;
    private final GameView view;

    // === CONSTRUCTOR ===
    public GameController(Game state, GameWindow gui){
        this.gameState = state;
        this.gameGUI = gui;

        this.view = gui.getView();

        this.addInputAction();
    }


    // === BASIC METHODS ===
    public void setDifficulty(Difficulty choice){
        this.gameState.setGameDifficulty(choice);
        this.gameState.setMaxGuesses(choice.getMaxGuesses());
    }

    public void createNewRound(int roundNum, Player player){
        Round newRound = new Round(roundNum, this.gameState.getMaxGuesses(), player);
        this.gameState.setRound(newRound);
        this.gameGUI.getView().printRoundStart(roundNum,this.gameState.getMaxGuesses());
    }

    // === INPUT METHODS ===
    private int displayInput() throws NumberFormatException{
            int guess = Integer.parseInt(this.gameGUI.getView().getInputViewer().getInputField().getText());
            view.logInput(true);
            return guess;
    }

    public void addInputAction(){
        view.getInputViewer().getInputField().addActionListener(_ -> {
            view.toggleInput(false);
            try{
                int guess = displayInput();
                runGuessResult(guess);
            } catch (NumberFormatException e){
                view.logInput(false);
                view.toggleInput(true);
            }
            view.getInputViewer().getInputField().requestFocusInWindow();
        });
    }


    // === RUN GAME METHODS ===
    private void runGameEndOrContinue(){
        RoundOverDialog roundOver = new RoundOverDialog(
                this.gameGUI.getFrame(),
                gameState.getPlayer().getGuessList());
        this.gameState.setGameOver(roundOver.getGameOver());

        if(this.gameState.isGameOver()){
            new GameOverDialog(
                    this.gameGUI.getFrame(),
                    this.gameState.getPlayer().getRoundsWon(),
                    this.gameState.getPlayer().getShortestGuesses()
            );
        } else {
            createNewRound(gameState.getRound().getRoundNumber() + 1,gameState.getPlayer());
        }
    }

    private void runGuessResult(int guess){
        GuessResult result = runPlayerGuess(guess);
        int secretNum = this.gameState.getRound().getComputer().getSecretNumber();
        this.gameGUI.getView().printGuessResult(result,secretNum);
        view.toggleInput(true);
        switch(result){
            case WIN_ROUND -> runGameEndOrContinue();
            case LOSE_ROUND -> {
                view.toggleInput(false);
                Timer time = new Timer(3000,_ -> System.exit(0));
                time.start();
            }
        }
    }

    public GuessResult runPlayerGuess(int guess) {
        return this.gameState.calculateGuessResult(guess);
    }

}
