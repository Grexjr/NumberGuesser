package view;

import javax.swing.*;
import java.awt.*;

public class InputView extends JPanel {
    // === CONSTANTS ===
    private static final int FIELD_COLUMNS = 20;
    private static final String FIELD_TITLE = "Guess: ";

    // === VARIABLES AND FIELDS ===
    private final JTextField inputField;
    private final JLabel inputTitle;


    // === CONSTRUCTOR ===
    public InputView(){
        this.inputField = new JTextField(FIELD_COLUMNS);
        this.inputTitle = new JLabel(FIELD_TITLE);

        this.setLayout(new FlowLayout());

        this.add(inputTitle);
        this.add(inputField);
    }


    // === GETTERS ===
    public JTextField getInputField() {return inputField;}

    public JLabel getInputTitle() {return inputTitle;}



}
