package obj;

import java.util.ArrayList;

public enum Choice {
    //TODO: Add choiceSet as a param so you can just call on it

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

    // Variables required for choice
    private String choiceLabel;

    // Constructor for choices
    Choice(String label){
        this.choiceLabel = label;
    }

    // Getter
    public String getChoiceLabel() {return this.choiceLabel;}

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
