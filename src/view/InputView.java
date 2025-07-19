package view;

import javax.swing.*;
import java.awt.*;

public class InputView extends JPanel {
    // === CONSTANTS ===
    private static final int FIELD_COLUMNS = 20;
    private static final JLabel FIELD_LABEL = new JLabel();

    // === VARIABLES AND FIELDS ===
    private final Inputter inputField;


    // === CONSTRUCTOR ===
    public InputView(){
        this.inputField = new Inputter(FIELD_LABEL,FIELD_COLUMNS);

        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));

        this.add(FIELD_LABEL); //TODO: Make the label centered
        this.add(inputField);
    }


    // === GETTERS ===
    public JTextField getInputField() {return inputField;}


}
