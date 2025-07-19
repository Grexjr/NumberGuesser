package view;

import javax.swing.*;
import java.awt.*;

public class GameView extends JPanel {
    // === CONSTANTS === | TODO: figure out if these should be moved or what | also public only for testing
    private static final String[] GAME_QUESTIONS = new String[]{
            // Difficulty Q (0)
            "What difficulty would you like?\n (type: easy, medium, hard, or impossible)\n",

            // Continue Q (1)
            "Continue game?\n(type yes or no)\n"
    };

    private static final String[] GAME_DECLARATIONS = new String[]{
            // Win declaration (0)
            "You win!\n",

            // Try again declaration (1)
            "Try again!\n\n"
    };

    // === VARIABLES AND FIELDS ===
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
