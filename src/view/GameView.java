package view;

import arc.GuessResult;
import controller.GameStrings;

import javax.swing.*;
import java.awt.*;

public class GameView extends JPanel {
    // === CONSTANTS ===

    // === VARIABLES AND FIELDS ===
    private final GameLog gameLog;
    private final InputView inputViewer;


    // === CONSTRUCTOR ===
    public GameView(){
        this.gameLog = new GameLog();

        this.inputViewer = new InputView();

        this.add(this.gameLog.getScroller(), BorderLayout.CENTER);
        this.add(this.inputViewer, BorderLayout.SOUTH);
    }


    // === GETTERS ===
    public InputView getInputViewer() {return inputViewer;}


    // === DISPLAY METHODS ===
    public void printRoundStart(int roundNum, int maxGuess){
        // STEP 1: print round info
       this.gameLog.log(
                new PrintMessage(
                        GameStrings.ROUND,
                        Integer.toString(roundNum)
                ));

        // STEP 2: print the intro
        this.gameLog.log(
                new PrintMessage(
                        GameStrings.INTRO,
                        Integer.toString(maxGuess)
                ));

        // STEP 3: computer ask for guess
        this.gameLog.log(
                new PrintMessage(GameStrings.GUESS_QUESTION));


    }

    public void logInput(boolean successOrFail){
        if(successOrFail){
            this.gameLog.log(
                new PrintMessage(
                        GameStrings.SYSTEM_INPUT,
                        inputViewer.getInputField().getText()+"\n")
        );
        } else {
            this.gameLog.log(new PrintMessage(GameStrings.SYSTEM_DECLARATIONS));
        }
        this.inputViewer.getInputField().setText("");
    }

    public void printGuessResult(GuessResult result,int secretNumber){
        switch(result){
            case LOSE_ROUND ->
                this.gameLog.log(
                        new PrintMessage(
                                GameStrings.LOSS,
                                Integer.toString(secretNumber)
                        ));
            case HIGHER_KEEP_GOING ->
                    this.gameLog.log(
                            new PrintMessage(GameStrings.LOWER_GUESS_DECLARATION));
            case LOWER_KEEP_GOING ->
                    this.gameLog.log(
                            new PrintMessage(GameStrings.HIGHER_GUESS_DECLARATION));
            case WIN_ROUND ->
                this.gameLog.log(
                        new PrintMessage(GameStrings.WIN_DECLARATION));
            default ->
                    throw new IllegalArgumentException("INVALID GUESS RESULT OBTAINED!!!"); //TODO: Catch this
        }
    }

    public void printGameOver(int roundsWon, int shortestGuesses){
        this.gameLog.log(
                new PrintMessage(
                        GameStrings.GAME_END,
                        Integer.toString(roundsWon),
                        Integer.toString(shortestGuesses)
                )
        );
    }

    // === BASIC METHODS ===
    public void clear(){
        this.removeAll();
        this.refresh();
    }

    public void refresh(){
        this.revalidate();
        this.repaint();
    }

    // === HELPER METHODS ===
    public void toggleInput(boolean allowOrNot){
            this.getInputViewer().getInputField().setEnabled(allowOrNot);
    }


}
