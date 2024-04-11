public class Scene {
    // fields/ properties
    private String description;
    private String[] choices;
    private int[] outcomes;
// no arg constructor
    public Scene() {
    }
// constructor with parametersi initializes the scene
    public Scene(String description, String[] choices, int[] outcomes) {
        this.description = description;
        this.choices = choices;
        this.outcomes = outcomes;
    }
// description of the scene
    public String getDescription() {
        return description;
    }
// get choices- returns array with available choices
    public String[] getChoices() {
        return choices;
    }
// displays description and choices of the scene
    public void displayScene() {
        System.out.println(description);
        System.out.println("Choices:"); //print

        //iterate over choices and displays, indexed
        for (int i = 0; i < choices.length; i++) {
            System.out.println((i + 1) + ". " + choices[i]);
        }
    }

    public void resolveChoice(int choice, Player player, Game game) {
        //adjust by 1...index
        System.out.println("You chose: " + choices[choice - 1]);//choice made by player
        System.out.println("Outcome: " + outcomes[choice - 1]); //outcome resulting from choice

        int pointsChange = outcomes[choice - 1];
        //Based on the outcome, it either adds or subtracts points from the player's score using the Game object provided as an argument.
        if (pointsChange > 0) {
            game.addPoints(pointsChange);
            System.out.println("You gained " + pointsChange + " points.");
        } else if (pointsChange < 0) {
            game.subtractPoints(-pointsChange);
            System.out.println("You lost " + (-pointsChange) + " points.");
        }
        //print points
        System.out.println("Current points: " + game.getPoints());
    }
}
