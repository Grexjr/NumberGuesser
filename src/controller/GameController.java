package controller;

import arc.Difficulty;
import arc.Game;
import arc.Round;
import obj.Computer;
import obj.Player;
import view.GameLog;
import view.GameWindow;
import view.PrintMessage;
import view.PrintMessageType;

import static controller.Strings.GAME_DECLARATIONS;
import static controller.Strings.SYSTEM_DECLARATIONS;

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
            this.gameState.getPlayer().setCurrentGuess(
                    Integer.parseInt(this.gameGUI.getView().getInputViewer().getInputField().getText()));
            this.gameGUI.getView().logInput(true);

            // run the rest of the round here
            runPlayerGuess(); // TODO: make this return in gameState and display here based on enum
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
    public void runPlayerGuess() { //TODO: make this return an enum for win, higher, lower
        Player player = this.gameState.getPlayer();
        Computer computer = this.gameState.getRound().getComputer();
        if(player.getCurrentGuess() != computer.getSecretNumber()){
            this.printData(
                    new PrintMessage(
                            PrintMessageType.CUSTOM,
                            GAME_DECLARATIONS[5]
                    ));
            if(player.getCurrentGuess() > computer.getSecretNumber()){
                this.printData(
                        new PrintMessage(
                                PrintMessageType.CUSTOM,
                                GAME_DECLARATIONS[6]
                        ));
            }
            if(player.getCurrentGuess() < computer.getSecretNumber()){
                this.printData(
                        new PrintMessage(
                                PrintMessageType.CUSTOM,
                                GAME_DECLARATIONS[7]
                        ));
            }
        } else {
            this.printData(
                    new PrintMessage(
                            PrintMessageType.CUSTOM,
                            GAME_DECLARATIONS[3],
                            GAME_DECLARATIONS[4]
                    ));
        }
    }


    public void runRound(int roundNum, Player player){ // TODO: Eventually have a dialog box before you enter for difficulty choice
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
        // - STEP 3a: computer ask for guess | TODO: Add a wait method
        this.printData(
                new PrintMessage(
                        PrintMessageType.CUSTOM,
                        GAME_DECLARATIONS[2]
                ));

        // - STEP 3b: allow player to input guess


    }







}
