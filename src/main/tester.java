package main;

import arc.Game;
import controller.GameController;
import obj.Player;
import view.*;

import java.util.ArrayList;

public class tester {

    public static void main(String[] args){
        GameWindow window = new GameWindow();
        DifficultyDialog dialog = new DifficultyDialog(window.getFrame());
        ArrayList<Integer> intList = new ArrayList<Integer>();
        intList.add(3);
        intList.add(5);
        RoundOverDialog dialog2 = new RoundOverDialog(window.getFrame(),intList);
        Game gameState = new Game();
        Player player = new Player();

        GameController controller = new GameController(gameState,window);
        controller.setDifficulty(dialog.getDifficultyChoice());

        controller.runRound(1,player);






    }

}
