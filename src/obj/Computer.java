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




}
