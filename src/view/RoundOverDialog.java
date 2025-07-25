package view;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;



public class RoundOverDialog extends GameDialog{
    // === CONSTANTS ===
    private static final String ROUND_OVER_TITLE = "ROUND OVER!";
    private static final JPanel ROUND_OVER_BUTTONS = new JPanel();
    // Do i have it as constant for here? I want to display the guess list on this, so probably not. pass as param


    // === CONSTRUCTOR ===
    public RoundOverDialog(JFrame owner, ArrayList<Integer> guessList){
        super(owner,ROUND_OVER_TITLE,guessList.toString(),ROUND_OVER_BUTTONS);

        this.setVisible(true);
    }


}
