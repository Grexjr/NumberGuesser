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

        GameView view = new GameView();
        this.gameFrame.add(view);

        this.gameFrame.setVisible(true);

        view.getInputViewer().getInputField().requestFocusInWindow(); //TODO: Figure out if you need this when hidden
    }


    // === GETTERS ===
    public JFrame getFrame() {return this.gameFrame;}


    // === BASIC METHODS ===
    public void clear(){
        this.gameFrame.getContentPane().removeAll();
        this.refresh();
    }

    public void refresh(){
        this.gameFrame.getContentPane().revalidate();
        this.gameFrame.getContentPane().repaint();
    }


}
