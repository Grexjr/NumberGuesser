package view;

import controller.GameStrings;

import javax.swing.*;
import java.util.ArrayList;

import static controller.Strings.GAME_STRINGS_MAP;


public class RoundOverDialog extends GameDialog{
    // === CONSTANTS ===
    private static final String ROUND_OVER_TITLE = "ROUND OVER";
    private static final String ROUND_OVER_TEXT = "Guess List:\n";
    private static final JPanel ROUND_OVER_BUTTONS = new JPanel();
    // Do I have it as constant for here? I want to display the guess list on this, so probably not. pass as param

    // === VARIABLES AND FIELDS ===
    private boolean gameOver;


    // === CONSTRUCTOR ===
    public RoundOverDialog(JFrame owner, ArrayList<Integer> guessList){
        super(owner,ROUND_OVER_TITLE,ROUND_OVER_TEXT,ROUND_OVER_BUTTONS);
        // SO this is technically creating two JLabels, the first with "Guess List:\n", the second with that AND the
        // guess list... so I'll want to fix that. I may just have to overwrite the whole constructor from
        // the game dialog, or find some way to genericize the formatting there (maybe have none).
        // TODO: Remove formatting from game dialog superclass
        this.gameOver = false;

        displayGuessList(guessList);

        this.setVisible(true);
    }


    // === GETTER ===
    public boolean getGameOver() {return this.gameOver;}

    private void displayGuessList(ArrayList<Integer> guessList){
        this.add(
                new JLabel(
                        ROUND_OVER_TEXT +
                                guessList.toString()
                                        .replace("[","")
                                        .replace("]","")
                                        .trim() + "\n" +
                                GAME_STRINGS_MAP.get(GameStrings.CONTINUE_QUESTION),
                        //TODO: New JLabel for this and the other text that puts this bottom
                        SwingConstants.CENTER
                )
        );
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
        buttonsList.add(yes);
        buttonsList.add(no);
        return buttonsList;
    }


}
