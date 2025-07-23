package view;

import arc.Difficulty;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.ArrayList;

import static controller.Strings.GAME_DECLARATIONS;
import static controller.Strings.GAME_QUESTIONS;

public class DifficultyDialog extends JDialog {
    // === CONSTANTS ===
    private static final int DIMENSION = 500;
    private static final String DIFFICULTY_TEXT = "Please choose a difficulty!\n";

    // === VARIABLES AND FIELDS ===
    private Difficulty difficultyChoice;


    // === CONSTRUCTOR ===
    public DifficultyDialog(JFrame owner,String title){
        super(owner, GAME_QUESTIONS[0], true);
        // Layout
        this.setSize(DIMENSION,DIMENSION);
        this.setLayout(new BorderLayout());

        // Text
        JLabel text = new JLabel(DIFFICULTY_TEXT,SwingConstants.CENTER);
        this.add(text,BorderLayout.CENTER);


        // Button panel
        JPanel buttonPanel = new JPanel();
        this.add(buttonPanel,BorderLayout.SOUTH);
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        // Basics
        this.setLocationRelativeTo(owner);
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

        // Buttons
        for(JButton b : createDifficultyButtons()){
            buttonPanel.add(b,BorderLayout.SOUTH);
        }

        // Set visible
        this.setVisible(true);
    }


    // === GETTER ===
    public Difficulty getDifficultyChoice() {return difficultyChoice;}

    // === BUTTON!!! ===
    private ArrayList<JButton> createDifficultyButtons(){
        JButton easy = new JButton("Easy");
        easy.addActionListener(_ -> {
            this.difficultyChoice = Difficulty.EASY;
            this.dispose();
        });
        JButton medium = new JButton("Medium");
        medium.addActionListener(_ -> {
            this.difficultyChoice = Difficulty.MEDIUM;
            this.dispose();
        });
        JButton hard = new JButton("Hard");
        hard.addActionListener(_ -> {
            this.difficultyChoice = Difficulty.HARD;
            this.dispose();
        });
        JButton impossible = new JButton("IMPOSSIBLE");
        impossible.addActionListener(_ -> {
            this.difficultyChoice = Difficulty.IMPOSSIBLE;
            this.dispose();
        });

        ArrayList<JButton> buttonsList = new ArrayList<JButton>();
        buttonsList.add(easy);
        buttonsList.add(medium);
        buttonsList.add(hard);
        buttonsList.add(impossible);

        return buttonsList;
    }





}
