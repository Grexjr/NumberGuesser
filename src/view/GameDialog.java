package view;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GameDialog extends JDialog {
    // === CONSTANTS ===
    private static final int DIMENSION = 500;

    public GameDialog(JFrame owner, String title, JPanel displayPanel, JPanel buttonsPanel, LayoutManager layout){
        super(owner, title, true);
        // Layout
        this.setSize(DIMENSION,DIMENSION);
        this.setLayout(layout);

        // Panels
        this.add(displayPanel,BorderLayout.CENTER);

        // Basics
        this.setLocationRelativeTo(owner);
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

        // Buttons
        this.add(buttonsPanel,BorderLayout.SOUTH);
        buttonsPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
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
