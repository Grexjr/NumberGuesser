package controller;

import arc.Difficulty;
import arc.Game;
import arc.GuessResult;
import arc.Round;
import obj.Player;
import view.*;

import javax.swing.*;

import static controller.Strings.*;

public class GameController {

    // === VARIABLES AND FIELDS === | QUESTION: Maybe should go in constructor since not ever accessed by other stuff
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
    }

    // === INPUT METHODS ===
    public void displayInput(){ // TODO: Rename this method because it does more
        try{
            int guess = Integer.parseInt(this.gameGUI.getView().getInputViewer().getInputField().getText());
            view.logInput(true);

            // run the rest of the round here
            runPlayerGuess(guess);

            // end the round in the above method


        } catch(NumberFormatException e) {
            view.logInput(false);
        }
    }

    public void addInputAction(){
        view.getInputViewer().getInputField().addActionListener(_ -> {
                displayInput();
        });
    }

    private void setContinueStatus(boolean value){
        this.gameState.setGameOver(value);
    }

    private void checkContinueGame(RoundOverDialog roundOver){
        if(roundOver.getGameOver()){
            // increase game state round, generate new computer, new round
            this.gameState.setRound(
                    new Round(
                            2,
                            this.gameState.getGameDifficulty().getMaxGuesses(),
                            this.gameState.getPlayer()));
        } else {
            System.exit(0);
        }
    }


    // === RUN GAME METHODS ===
    public void runPlayerGuess(int guess) {
        GuessResult result = this.gameState.calculateGuessResult(guess);
        view.toggleInput(false);

        switch(result){
            case LOSE_ROUND ->{
                view.printData(
                        new PrintMessage(
                                GameStrings.LOSS,
                                Integer.toString(this.gameState.getRound().getComputer().getSecretNumber())
                        ));
                System.exit(0);
            }
            case HIGHER_KEEP_GOING ->
                    view.printData(
                        new PrintMessage(GameStrings.LOWER_GUESS_DECLARATION));
            case LOWER_KEEP_GOING ->
                    view.printData(
                        new PrintMessage(GameStrings.HIGHER_GUESS_DECLARATION));
            case WIN_ROUND -> {
                view.printData(
                        new PrintMessage(GameStrings.WIN_DECLARATION));
                RoundOverDialog roundOver = new RoundOverDialog(
                        this.gameGUI.getFrame(),
                        gameState.getPlayer().getGuessList());
                this.gameState.setGameOver(roundOver.getGameOver());

                // Method to run logic when game state isGameOver is true
                if(this.gameState.isGameOver()){
                    // Print the message for game to be over
                    view.printData(
                            new PrintMessage(
                                    GameStrings.GAME_END,
                                    Integer.toString(this.gameState.getPlayer().getRoundsWon()),
                                    Integer.toString(this.gameState.getPlayer().getShortestGuesses())
                            )
                    );
                    Timer time = new Timer(5000,_ -> System.exit(0));
                    time.start();
                } else {
                    runRound(gameState.getRound().getRoundNumber() + 1,gameState.getPlayer());
                }
            }
            default ->
                throw new IllegalArgumentException("INVALID GUESS RESULT OBTAINED!!!"); //TODO: Catch this
        }

        view.toggleInput(true);
        view.getInputViewer().getInputField().requestFocusInWindow();

        }


    public void runRound(int roundNum, Player player){
        // STEP 1: start round and print it
        createNewRound(roundNum,player);
        view.printData(
                new PrintMessage(
                        GameStrings.ROUND,
                        Integer.toString(this.gameState.getRound().getRoundNumber())
                ));

        // STEP 2: print the introduction of the round
        view.printData(
                new PrintMessage(
                        GameStrings.INTRO,
                        Integer.toString(this.gameState.getRound().getMaxGuesses())
                ));

        // STEP 3: play the round
        // - STEP 3a: computer ask for guess
        view.printData(
                new PrintMessage(GameStrings.GUESS_QUESTION));

        // - STEP 3b: allow player to input guess


    }







}
