package view;

import javax.swing.*;

public class GameWindow {

    // === CONSTANTS ===
    private static final int FRAME_HEIGHT = 600;
    private static final int FRAME_WIDTH = 800;

    // === VARIABLES AND FIELDS ===
    private final JFrame gameFrame;


    // === CONSTRUCTOR ===
    public GameWindow(){
        this.gameFrame = new JFrame("NUMBERTRON");
        this.gameFrame.setSize(FRAME_WIDTH,FRAME_HEIGHT);
        this.gameFrame.setResizable(false);
        this.gameFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }


    // === GETTERS ===
    public JFrame getFrame() {return this.gameFrame;}



}
