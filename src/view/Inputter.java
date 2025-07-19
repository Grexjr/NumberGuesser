package view;

import javax.swing.*;

public class Inputter extends JTextField {
    // === CONSTANTS ===
    private static final String FIELD_TITLE = "Guess: ";

    // === VARIABLES AND FIELDS ===
    private final JLabel fieldLabel;


    // === CONSTRUCTOR ===
    public Inputter(JLabel label, int columns){
        this.fieldLabel = label;
        label.setText(FIELD_TITLE);
        this.setColumns(columns);
    }


    // === GETTERS ===
    public JLabel getFieldLabel() {return fieldLabel;}


    // === BASIC METHODS ===


}
