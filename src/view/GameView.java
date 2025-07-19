package view;

import javax.swing.*;
import java.awt.*;

public class GameView extends JPanel {

    // === VARIABLES AND FIELDS ===
    private final JTextArea gameLog;
    private final InputView inputViewer;


    // === CONSTRUCTOR ===
    public GameView(){
        this.gameLog = new GameLog();

        this.inputViewer = new InputView();

        // this.setLayout(new BorderLayout()); TODO: Decide if you want this kind of format

        this.add(this.gameLog, BorderLayout.CENTER);
        this.add(this.inputViewer, BorderLayout.SOUTH);

        this.addInputAction();
    }


    // === GETTERS ===
    public JTextArea getGameLog() {return gameLog;}

    public InputView getInputViewer() {return inputViewer;}

    // === DISPLAY METHODS ===
    public void displayInput(){
        this.gameLog.append(this.inputViewer.getInputField().getText());
        this.inputViewer.getInputField().setText("");
    }

    // === HELPER METHODS ===
    public void addInputAction(){
        this.inputViewer.getInputField().addActionListener(_ -> displayInput());
    }


    // === BASIC METHODS ===
    public void refresh(){
        this.revalidate();
        this.repaint();
    }

    public void clear(){
        this.removeAll();
        this.refresh();
    }


}
