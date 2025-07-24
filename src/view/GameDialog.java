package view;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GameDialog extends JDialog {
    // === CONSTANTS ===
    private static final int DIMENSION = 500;

    public GameDialog(JFrame owner, String title, String text, JPanel buttonsPanel){
        super(owner, title, true); // TODO: catch the null, or some other error
        // Layout
        this.setSize(DIMENSION,DIMENSION);
        this.setLayout(new BorderLayout());

        // Text
        JLabel displayText = new JLabel(text,SwingConstants.CENTER);
        this.add(displayText,BorderLayout.CENTER);

        // Basics
        this.setLocationRelativeTo(owner);
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

        // Buttons
        this.addButtons(buttonsPanel);
    }

    protected ArrayList<JButton> createButtons(){
        System.out.println("ERROR: UNUSABLE BUTTON ARRAY CREATED!"); //TODO: Throw an error
        return new ArrayList<JButton>();
    }

    protected void addButtons(JPanel buttonPanel){
        for(JButton b : createButtons()){
            buttonPanel.add(b);
        }
    }






}
