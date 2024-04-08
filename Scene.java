public class Scene {
    private String description;
    private String[] choices;
    private int[] outcomes;

    public Scene(String description, String[] choices, int[] outcomes) {
        this.description = description;
        this.choices = choices;
        this.outcomes = outcomes;
    }

    public String getDescription() {
        return description;
    }

    public String[] getChoices() {
        return choices;
    }

    public void displayScene() {
        System.out.println(description);
        System.out.println("Choices:");
        for (int i = 0; i < choices.length; i++) {
            System.out.println((i + 1) + ". " + choices[i]);
        }
    }

    public void resolveChoice(int choice, Player player, Game game) {
        System.out.println("You chose: " + choices[choice - 1]);
        System.out.println("Outcome: " + outcomes[choice - 1]);

        // Apply points based on the outcome
        int pointsChange = outcomes[choice - 1];
        if (pointsChange > 0) {
            game.addPoints(pointsChange);
            System.out.println("You gained " + pointsChange + " points.");
        } else if (pointsChange < 0) {
            game.subtractPoints(-pointsChange);
            System.out.println("You lost " + (-pointsChange) + " points.");
        }

        System.out.println("Current points: " + game.getPoints());
    }
}
