package obj;

import java.util.Random;

public class Computer {

    // Variables for computers
    private final int secretNumber;

    // Computer constructor
    public Computer(){
        System.out.println(introduceSelf());
        this.secretNumber = new Random().nextInt(0,10000);
        System.out.println(askForGuess());
    }

    // Computer methods
    // Getter
    public int getSecretNumber() {return secretNumber;}

    // Other methods
    // String to introduce self
    public String introduceSelf(){
        return "Muahahahaha! \n" +
                "I am an evil computer. Guess my number or perish! \n" +
                "You have 10 guesses!";
    }

    // String to ask for guess
    public String askForGuess(){return "What is your guess? \n";}

    // Logic for checking if guess equals
    public boolean checkGuess(int guess){return guess == this.secretNumber;}

    // Logic for if guess is higher (true) or lower (false)
    public boolean higherLower(int guess){return guess > this.secretNumber;}

    // String for result





}
