package obj;

import java.util.Random;

public class Computer {

    // === VARIABLES AND FIELDS
    private final int secretNumber;


    // === CONSTRUCTOR FOR COMPUTER ===
    public Computer(){this.secretNumber = new Random().nextInt(0,10000);}


    // === GETTERS AND SETTERS ===
    public int getSecretNumber() {return secretNumber;}


    // === COMPUTER HELPER METHODS ===

    // Logic for checking if guess equals
    public boolean checkGuess(int guess){return guess == this.secretNumber;}

    // Logic for if guess is higher (true) or lower (false)
    public boolean higherLower(int guess){return guess > this.secretNumber;}


    // === COMPUTER PRINT METHODS ===

    // String to introduce self
    public String introduceSelf(int maxGuesses){
        return "Muahahahaha! \n" +
                "I am an evil computer. Guess my number or perish! \n" +
                "You have "  +
                maxGuesses +
                " guesses! \n";
    }

    // String to ask for guess
    public String askForGuess(){return "What is your guess? \n";}


    // String for result
    public String tellResult(int guess){
        if(checkGuess(guess)){
            return "You... win!? Impossible! \n" +
                    "Malfunctioning... need... System... reset.... \n\n";
        }
        if(!checkGuess(guess)){
            String incorrectGuess = "You fool... INCORRECT! \n";

            if(higherLower(guess)){
                return incorrectGuess +
                        "You'll never guess that my number is lower than your guess! \n";
            }
            return incorrectGuess +
                    "You'll never guess that my number is higher than your guess! \n";
        }
        System.exit(0);
        return "SYSTEM ERROR: BAD CASE";
    }




}
