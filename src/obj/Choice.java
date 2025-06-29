package obj;

import java.util.ArrayList;

public enum Choice {


    // === ENUM VALUES ===

    // Default choice value
    INVALID("Invalid"),

    // Values for difficulty choice
    EASY("Easy"),
    MEDIUM("Medium"),
    HARD("Hard"),
    IMPOSSIBLE("Impossible"),

    // Values for yes/no choice
    YES("Yes"),
    NO("No");

    // === ENUM VARIABLES/FIELDS ===

    // Variables required for choice
    private final String choiceLabel;


    // == CHOICE CONSTRUCTOR ===
    Choice(String label){
        this.choiceLabel = label;
    }


    // === GETTERS AND SETTERS ===
    public String getChoiceLabel() {return this.choiceLabel;}


    // === CHOICE HELPER METHODS

    // Static method to create possible choice set
    public static ArrayList<Choice> possibleChoices(int choiceSet){
        ArrayList<Choice> choices = new ArrayList<Choice>();
        switch (choiceSet){
            case 1:
                choices.add(Choice.EASY);
                choices.add(Choice.MEDIUM);
                choices.add(Choice.HARD);
                choices.add(Choice.IMPOSSIBLE);
                return choices;
            case 2:
                choices.add(Choice.YES);
                choices.add(Choice.NO);
                return choices;
            default:
                choices.add(Choice.INVALID);
                return choices;
        }
    }

}
