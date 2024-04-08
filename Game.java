import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    private Player player;
    private List<Scene> scenes;
    private int currentSceneIndex;
    private int points;

    public Game(Player player) {
        this.player = player;
        this.points = 10; // Initial points
        scenes = new ArrayList<>();
        currentSceneIndex = 0;
    }

    public void addScene(Scene scene) {
        scenes.add(scene);
    }

    public void startGame() {
        Scanner scanner = new Scanner(System.in);
        while (currentSceneIndex < scenes.size() && points > 0 && points < 25) {
            Scene currentScene = scenes.get(currentSceneIndex);
            currentScene.displayScene();

            int choice = getValidChoice(scanner, currentScene.getChoices().length);
            currentScene.resolveChoice(choice, player, this);

            // Move to the next scene
            currentSceneIndex++;
        }
        scanner.close();

        if (points >= 25) {
            System.out.println("Congratulations! You've won the game!");
        } else {
            System.out.println("You've lost the game. Better luck next time!");
        }
    }

    public int getPoints() {
        return points;
    }

    public void addPoints(int points) {
        this.points += points;
    }

    public void subtractPoints(int points) {
        this.points -= points;
        if (this.points < 0) {
            this.points = 0;
        }
    }

    private int getValidChoice(Scanner scanner, int maxChoice) {
        int choice = 0;
        while (true) {
            System.out.print("Enter your choice: ");
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                if (choice >= 1 && choice <= maxChoice) {
                    break;
                } else {
                    System.out.println("Invalid choice. Please enter a number between 1 and " + maxChoice);
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Clear the buffer
            }
        }
        return choice;
    }
}
