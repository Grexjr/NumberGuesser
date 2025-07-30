package view;

import arc.Difficulty;
import controller.GameStrings;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.ArrayList;

import static controller.Strings.GAME_STRINGS_MAP;

public class DifficultyDialog extends GameDialog {
    // === CONSTANTS ===
    private static final JLabel DIFFICULTY_TEXT = new JLabel(new PrintMessage(GameStrings.DIFFICULTY_QUESTION).toString());
    private static final String DIFFICULTY_TITLE = "DIFFICULTY"; // TODO: Consolidate with game strings
    private static final JPanel DIFFICULTY_BUTTONS = new JPanel();
    private static final JPanel DISPLAY_PANEL = new JPanel();

    // === VARIABLES AND FIELDS ===
    private Difficulty difficultyChoice;


    // === CONSTRUCTOR ===
    public DifficultyDialog(JFrame owner){
        super(owner,DIFFICULTY_TITLE,DISPLAY_PANEL,DIFFICULTY_BUTTONS,new BorderLayout());

        // Display Information
        DISPLAY_PANEL.setLayout(new GridLayout(0,1));
        DISPLAY_PANEL.add(DIFFICULTY_TEXT);
        DIFFICULTY_TEXT.setHorizontalAlignment(SwingConstants.CENTER);
        DIFFICULTY_TEXT.setVerticalAlignment(SwingConstants.CENTER);

        // Set visible
        this.setVisible(true);
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
