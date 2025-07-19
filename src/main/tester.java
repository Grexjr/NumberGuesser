package main;

import arc.Game;
import view.GameView;
import view.GameWindow;
import view.PrintMessage;
import view.PrintMessageType;

public class tester {

    public static void main(String[] args){
        GameWindow window = new GameWindow();

        window.getView().getGameLog().log(new PrintMessage(PrintMessageType.INTRO,Integer.toString(15)));






    }

}
