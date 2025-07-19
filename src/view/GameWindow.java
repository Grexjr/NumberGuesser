package view;

import javax.swing.*;

public class GameWindow {

    // === CONSTANTS ===
    private static final int FRAME_HEIGHT = 600;
    private static final int FRAME_WIDTH = 800;
    private static final String FRAME_TITLE = "NUMBERTRON 5000";

    // === VARIABLES AND FIELDS ===
    private final JFrame gameFrame;


    // === CONSTRUCTOR ===
    public GameWindow(){
        this.gameFrame = new JFrame(FRAME_TITLE);
        this.gameFrame.setSize(FRAME_WIDTH,FRAME_HEIGHT);
        this.gameFrame.setResizable(false);
        this.gameFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.gameFrame.setLocationRelativeTo(null);

        this.gameFrame.add(new GameView());

        this.gameFrame.setVisible(true);
    }


    // === GETTERS ===
    public JFrame getFrame() {return this.gameFrame;}


}
