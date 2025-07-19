package view;

import javax.swing.*;
import java.awt.*;

public class GameLog extends JTextArea {
    // === CONSTANTS ===
    private static final int LOG_ROWS = 30;
    private static final int LOG_COLUMNS = 45;


    // === VARIABLES AND FIELDS ===
    private final JScrollPane scroller;

    // === CONSTRUCTOR ===
    public GameLog(){
        super(LOG_ROWS,LOG_COLUMNS);
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.setEditable(false);
        this.setLineWrap(true);
        this.setWrapStyleWord(true);
        this.scroller = new JScrollPane(this);
    }


    // === GETTERS ===
    public JScrollPane getScroller() {return scroller;}


    // === BASIC METHODS ===
    public void log(String message){
        this.append(message);
        SwingUtilities.invokeLater(this::scrollDown);
    }

    private void scrollDown(){
        JScrollBar scroller = this.scroller.getVerticalScrollBar();
        scroller.setValue(scroller.getMaximum());
    }





}
