import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    private Player player; // instance of player
    private List<Scene> scenes; // list of scenes
    private int currentSceneIndex;
    private int points;

    // no args constr
    public Game() {
    }

    // constructor parameterized
    public Game(Player player) {
        this.player = player;
        this.points = 10; // give player initial 10 points
        scenes = new ArrayList<>(); // empty list for scenes
        currentSceneIndex = 0;
    }

    // methods/getters/setters
    // lets start the game
    public void startGame(Scanner scanner) {
        // Scanner scanner = new Scanner(System.in);
        // as long game is not over- between 0 and 25
        while (currentSceneIndex < scenes.size() && points > 0 && points < 25) {
            Scene currentScene = scenes.get(currentSceneIndex);
            currentScene.displayScene();

            int choice = getValidChoice(scanner, currentScene.getChoices().length);
            currentScene.resolveChoice(choice, player, this);

            currentSceneIndex++;
        }
        // scanner.close();
        // win, lose or safe
        if (points >= 25) {
            System.out.println("Congrats! You've won the game!");
        } else if (points <= 0) {
            System.out.println("You've lost the game. Be kinder next!");
        } else {
            System.out.println(
                    "Congrats on making it to the survivor zone but you didn't save enough lives to win the game");
        }
    }

    public void addScene(Scene scene) {
        scenes.add(scene);
    }

    public void addPoints(int points) {
        this.points += points;
    }

    // Guard clause- points negative after subtraction?
    public void subtractPoints(int points) {
        this.points -= points;
        if (this.points < 0) {
            this.points = 0; // if total points are negative, set them to 0
        }
    }

    // Getters

    public int getCurrentSceneIndex() {
        return currentSceneIndex;
    }

    public List<Scene> getScenes() {
        return scenes;
    }

    public int getPoints() {
        return points;
    }

    // helper- validate player's input
    private int getValidChoice(Scanner scanner, int maxChoice) {
        int choice = 0;
        while (true) {
            System.out.print("Enter your choice: ");
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine();
                if (choice >= 1 && choice <= maxChoice) { // input 1,2,3
                    break;
                } else {
                    System.out.println("Invalid choice. Please enter a number between 1 and " + maxChoice);
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine();
            }
            scanner.close();
        }
        return choice;
    }

}
