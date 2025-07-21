package main;

import arc.Game;
import controller.GameController;
import view.*;

public class tester {

    public static void main(String[] args){
        GameWindow window = new GameWindow();
        DifficultyDialog dialog = new DifficultyDialog(window.getFrame(),"DIFFICULTY");
        Game gameState = new Game();

        GameController controller = new GameController(gameState,window);
        controller.setDifficulty(dialog.getDifficultyChoice());

        controller.runGame();






    }

}
