package controller;

import arc.Game;
import view.GameLog;
import view.GameWindow;
import view.PrintMessage;
import view.PrintMessageType;

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


    // === RUN GAME METHOD ===
    public void runGame(){ // TODO: Eventually have a dialog box before you enter for difficulty choice
        // STEP 1: start round

        // STEP 2: print the introduction of the round

        // STEP 3: play the round
    }







}
