package view;

import controller.GameStrings;

import javax.swing.*;
import java.awt.*;

import static controller.Strings.GAME_STRINGS_MAP;

public class GameView extends JPanel {
    // === CONSTANTS ===

    // === VARIABLES AND FIELDS === | TODO: Input field only visible when player needs to input
    private final GameLog gameLog;
    private final InputView inputViewer;
    private int inputtedGuess;
    private boolean isGuessDone;


    // === CONSTRUCTOR ===
    public GameView(){
        this.gameLog = new GameLog();

        this.inputViewer = new InputView();

        this.inputtedGuess = -1;
        this.isGuessDone = false;

        this.add(this.gameLog.getScroller(), BorderLayout.CENTER);
        this.add(this.inputViewer, BorderLayout.SOUTH);
    }


    // === GETTERS ===
    public GameLog getGameLog() {return gameLog;}

    public InputView getInputViewer() {return inputViewer;}

    public int getInputtedGuess() {return inputtedGuess;}

    public boolean getGuessDone() {return isGuessDone;}

    // === DISPLAY METHODS ===
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
