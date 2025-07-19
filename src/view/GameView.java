package view;

import javax.swing.*;
import java.awt.*;

public class GameView extends JPanel {
    // === CONSTANTS ===
    private static final int LOG_ROWS = 30;
    private static final int LOG_COLUMNS = 45;

    // === VARIABLES AND FIELDS ===
    private final JTextArea gameLog;
    private final InputView inputViewer;


    // === CONSTRUCTOR ===
    public GameView(){
        this.gameLog = new JTextArea(LOG_ROWS,LOG_COLUMNS);
        this.gameLog.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.gameLog.setEditable(false);
        this.gameLog.setLineWrap(true);
        this.gameLog.setWrapStyleWord(true);
        // TODO: Method to scroll to bottom
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
