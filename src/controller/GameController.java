package controller;

import arc.Difficulty;
import arc.Game;
import arc.Round;
import obj.Player;
import view.GameLog;
import view.GameWindow;
import view.PrintMessage;
import view.PrintMessageType;

import static controller.Strings.GAME_DECLARATIONS;

public class GameController {

    // === VARIABLES AND FIELDS === | QUESTION: Maybe should go in constructor since not ever accessed by other stuff
    private final Game gameState;
    private final GameWindow gameGUI;

    // === CONSTRUCTOR ===
    public GameController(Game state, GameWindow gui){
        this.gameState = state;
        this.gameGUI = gui;
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


    // === RUN GAME METHOD === // QUESTION: rename to run round?
    public void runRound(int roundNum, Player player){ // TODO: Eventually have a dialog box before you enter for difficulty choice
        // TODO: set a new isGuessed boolean to false
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
        this.gameState.getPlayer().guessNumber();
        //TODO: add to the input field KeyListener for enter key, when pressed sets the isGuessed boolean to true,
        // if true, runs the rest of the round
    }







}
