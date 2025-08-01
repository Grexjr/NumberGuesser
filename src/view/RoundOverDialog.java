package view;

import controller.GameStrings;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

import static controller.Strings.GAME_STRINGS_MAP;


public class RoundOverDialog extends GameDialog{
    // === CONSTANTS ===
    private static final String ROUND_OVER_TITLE = "ROUND OVER"; // TODO: Consolidate with game strings
    private static final JPanel ROUND_OVER_BUTTONS = new JPanel();
    private static final JPanel ROUND_OVER_DISPLAY = new JPanel();
    private static final LayoutManager LAYOUT = new GridLayout(0,1);
    private static final JLabel CONTINUE_QUESTION = new JLabel(new PrintMessage(GameStrings.CONTINUE_QUESTION).toString());
    // Do I have it as constant for here? I want to display the guess list on this, so probably not. pass as param

    // === VARIABLES AND FIELDS ===
    private boolean gameOver;


    // === CONSTRUCTOR ===
    public RoundOverDialog(JFrame owner, ArrayList<Integer> guessList){
        super(owner,ROUND_OVER_TITLE,ROUND_OVER_DISPLAY,ROUND_OVER_BUTTONS,LAYOUT);

        // Display Information
        ROUND_OVER_DISPLAY.setLayout(new GridLayout(0,1));

        ROUND_OVER_DISPLAY.add(displayGuessList(guessList));

        ROUND_OVER_DISPLAY.add(CONTINUE_QUESTION);
        CONTINUE_QUESTION.setHorizontalAlignment(SwingConstants.CENTER);

        this.gameOver = false;

        this.setVisible(true);
    }


    // === GETTER ===
    public boolean getGameOver() {return this.gameOver;}

    private JLabel displayGuessList(ArrayList<Integer> guessList){ // TODO: Redo the box so both these show up
        return new JLabel(
                        new PrintMessage(
                                GameStrings.GUESS_LIST,
                                String.valueOf(guessList)).toString());
    }

    @Override
    protected ArrayList<JButton> createButtons(){
        JButton yes = new JButton("Yes");
        yes.addActionListener(_ -> {
            this.gameOver = false;
            this.dispose();
        });

        JButton no = new JButton("No");
        no.addActionListener(_ -> {
            this.gameOver = true;
            this.dispose();
        });

        ArrayList<JButton> buttonsList = new ArrayList<JButton>();
        buttonsList.add(yes); // TODO: This is likely causing multiple buttons, super already has add buttons.
        buttonsList.add(no);
        return buttonsList;
    }


}
