package view;

import javax.swing.*;
import java.awt.*;

public class GameView extends JPanel {
    // === CONSTANTS === | TODO: move these to controller class and make protected

    // === VARIABLES AND FIELDS === | TODO: Input field only visible when player needs to input
    private final GameLog gameLog;
    private final InputView inputViewer;


    // === CONSTRUCTOR ===
    public GameView(){
        this.gameLog = new GameLog();

        this.inputViewer = new InputView();

        this.add(this.gameLog.getScroller(), BorderLayout.CENTER);
        this.add(this.inputViewer, BorderLayout.SOUTH);

        this.addInputAction();
    }


    // === GETTERS ===
    public GameLog getGameLog() {return gameLog;}

    public InputView getInputViewer() {return inputViewer;}

    // === DISPLAY METHODS ===
    public void displayInput(){
        this.gameLog.log(
                new PrintMessage(PrintMessageType.CUSTOM, inputViewer.getInputField().getText()+"\n")
        );
        this.inputViewer.getInputField().setText("");
    }

    // === HELPER METHODS ===
    public void addInputAction(){
        this.inputViewer.getInputField().addActionListener(_ -> displayInput());
    }


    // === BASIC METHODS ===
    // === BASIC METHODS ===
    public void clear(){
        this.removeAll();
        this.refresh();
    }

    public void refresh(){
        this.revalidate();
        this.repaint();
    }


}
