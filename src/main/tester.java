package main;

import arc.Game;
import controller.GameController;
import obj.Player;
import view.*;

import java.util.ArrayList;

public class tester {

    public static void main(String[] args){
        GameWindow window = new GameWindow();
        //GameOverDialog over = new GameOverDialog(window.getFrame(),1,1);
        DifficultyDialog dialog = new DifficultyDialog(window.getFrame());
        ArrayList<Integer> arary = new ArrayList<Integer>();
        arary.add(4);arary.add(4);arary.add(4);arary.add(4);arary.add(4);arary.add(4);arary.add(4);
        //RoundOverDialog dialog2 = new RoundOverDialog(window.getFrame(), arary);
        Game gameState = new Game();
        Player player = new Player();


        GameController controller = new GameController(gameState,window);
        controller.setDifficulty(dialog.getDifficultyChoice());

        controller.createNewRound(1,player);






    }

}
