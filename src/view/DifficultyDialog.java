package view;

import arc.Difficulty;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.ArrayList;

import static controller.Strings.GAME_DECLARATIONS;
import static controller.Strings.GAME_QUESTIONS;

public class DifficultyDialog extends GameDialog {
    // === CONSTANTS ===
    private static final String DIFFICULTY_TEXT = "Please choose a difficulty!\n";
    private static final String DIFFICULTY_TITLE = "DIFFICULTY";
    private static final JPanel DIFFICULTY_BUTTONS = new JPanel();

    // === VARIABLES AND FIELDS ===
    private Difficulty difficultyChoice;


    // === CONSTRUCTOR ===
    public DifficultyDialog(JFrame owner){
        super(owner,DIFFICULTY_TITLE,DIFFICULTY_TEXT,DIFFICULTY_BUTTONS);

        // Button panel
        this.add(DIFFICULTY_BUTTONS,BorderLayout.SOUTH);
        DIFFICULTY_BUTTONS.setLayout(new FlowLayout(FlowLayout.CENTER));

        // Set visible
        this.setVisible(true); // must go in every subclass, OR do it outside the subclass
    }


    // === GETTER ===
    public Difficulty getDifficultyChoice() {return difficultyChoice;}

    // === BUTTON!!! ===
    @Override
    protected ArrayList<JButton> createButtons(){
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
