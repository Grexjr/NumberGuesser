package controller;

import arc.Difficulty;
import arc.Game;
import arc.GuessResult;
import arc.Round;
import obj.Computer;
import obj.Player;
import view.GameLog;
import view.GameWindow;
import view.PrintMessage;
import view.PrintMessageType;

import static controller.Strings.*;

public class GameController {

    // === VARIABLES AND FIELDS === | QUESTION: Maybe should go in constructor since not ever accessed by other stuff
    private final Game gameState;
    private final GameWindow gameGUI;

    // === CONSTRUCTOR ===
    public GameController(Game state, GameWindow gui){
        this.gameState = state;
        this.gameGUI = gui;

        this.addInputAction();
    }


    // === BASIC METHODS ===
    public void printData(PrintMessage data){
        GameLog log = this.gameGUI.getView().getGameLog();
        log.log(data);
    }

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
            this.gameGUI.getView().logInput(true);

            // run the rest of the round here
            runPlayerGuess(guess);

            // end the round in the above method


        } catch(NumberFormatException e) {
            this.gameGUI.getView().logInput(false);
        }
    }

    public void addInputAction(){
        this.gameGUI.getView().getInputViewer().getInputField().addActionListener(_ -> {
                displayInput();
        });
    }


    // === RUN GAME METHODS ===
    public void runPlayerGuess(int guess) {
        GuessResult result = this.gameState.calculateGuessResult(guess);
        this.gameGUI.getView().toggleInput(false);

        switch(result){
            case LOSE_ROUND ->
                this.printData(
                        new PrintMessage(
                                PrintMessageType.LOSS,
                                Integer.toString(this.gameState.getRound().getComputer().getSecretNumber())
                        ));
            case HIGHER_KEEP_GOING ->
                    this.printData(
                        new PrintMessage(
                                PrintMessageType.CUSTOM,
                                GAME_DECLARATIONS[5]
                        ));
            case LOWER_KEEP_GOING ->
                    this.printData(
                        new PrintMessage(
                                PrintMessageType.CUSTOM,
                                GAME_DECLARATIONS[4]
                        ));
            case WIN_ROUND -> {
                this.printData(
                        new PrintMessage(
                                PrintMessageType.CUSTOM,
                                GAME_DECLARATIONS[2]
                        ));

            }
            default ->
                throw new IllegalArgumentException("INVALID GUESS RESULT OBTAINED!!!"); //TODO: Catch this
        }

        this.gameGUI.getView().toggleInput(true);
        this.gameGUI.getView().getInputViewer().getInputField().requestFocusInWindow();

        }


    public void runRound(int roundNum, Player player){
        // STEP 1: start round and print it
        createNewRound(roundNum,player);
        this.printData(
                new PrintMessage(
                        PrintMessageType.ROUND,
                        Integer.toString(this.gameState.getRound().getRoundNumber())
                ));

        // STEP 2: print the introduction of the round
        this.printData(
                new PrintMessage(
                        PrintMessageType.INTRO,
                        Integer.toString(this.gameState.getRound().getMaxGuesses())
                ));

        // STEP 3: play the round
        // - STEP 3a: computer ask for guess
        this.printData(
                new PrintMessage(
                        PrintMessageType.CUSTOM,
                        GAME_QUESTIONS[2]
                ));

        // - STEP 3b: allow player to input guess


    }







}
