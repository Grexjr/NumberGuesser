package view;

import controller.GameStrings;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GameOverDialog extends GameDialog {
    // === CONSTANTS ===
    private static final String GAME_OVER_TITLE = "GAME OVER";
    private static final JPanel GAME_OVER_DISPLAY = new JPanel();
    private static final JPanel GAME_OVER_BUTTONS = new JPanel();
    private static final LayoutManager GAME_OVER_LAYOUT = new GridLayout(0,1);

    // === CONSTRUCTOR ===
    public GameOverDialog(JFrame owner, int roundsWon, int shortestGuesses){
        super(owner,GAME_OVER_TITLE,GAME_OVER_DISPLAY,GAME_OVER_BUTTONS,GAME_OVER_LAYOUT);

        // DISPLAY
        GAME_OVER_DISPLAY.add(displayGameStats(roundsWon,shortestGuesses));

        this.setVisible(true);
    }


    // === METHODS === | TODO: FORMATTING ON DIFFERNT LINES!!!!
    private JLabel displayGameStats(int roundsWon, int shortestGuessAmount){
        return new JLabel(
                new PrintMessage(
                        GameStrings.GAME_END,
                        Integer.toString(roundsWon),
                        Integer.toString(shortestGuessAmount)
                ).toString()
        );
    }

    @Override
    protected ArrayList<JButton> createButtons(){
        JButton okay = new JButton("OK");
        okay.addActionListener(_ -> System.exit(0));
        ArrayList<JButton> buttonsList = new ArrayList<JButton>();
        buttonsList.add(okay);
        return buttonsList;
    }



}
