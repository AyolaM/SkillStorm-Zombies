import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Introduction
        System.out.println("Lets test your compassion!");
        System.out.println(
                "In this post-apocalyptic world overrun by zombies, your objective is to reach a safe haven while navigating through various challenges.");
        System.out.println(
                "Throughout the game, you must make strategic decisions that impact your survival and the well-being of others. there's a cure in the works for the zombies so try not to harm an zombies along journey :)");

        boolean playAgain = true;
        while (playAgain) {
            // Initialize player
            System.out.println("Enter your name:");
            String playerName = scanner.nextLine();
            Player player = new Player(playerName, 100, 10, 10, 10);

            // Initialize game
            Game game = new Game(player);

            // Initialize scenes
            Scene scene1 = new Scene(
                    "Discover a Survivor Camp: You stumble upon a hidden survivor camp. What do you do?",
                    new String[] { "Offer your help and resources", "Steal supplies from the camp",
                            "Ignore the camp and move on" },
                    new int[] { 5, -15, 0 });

            Scene scene2 = new Scene(
                    "Save a Survivor: You find a survivor trapped by zombies. What is your course of action?",
                    new String[] { "Rescue the survivor",
                            "Leave the survivor behind to save yourself",
                            "Use the survivor as bait to distract the zombies" },
                    new int[] { 10, -5, -15 });

            Scene scene3 = new Scene(
                    "You come across some supplies left behind by other survivors. What do you do?",
                    new String[] { "Take only what you need and leave the rest for others",
                            "Hoard all the supplies for yourself", "Ignore the supplies and continue your journey" },
                    new int[] { 5, -10, 0 });

            Scene scene4 = new Scene(
                    "A group of hostile survivors ambushes you and demands your supplies. How do you respond?",
                    new String[] { "Negotiate with the bandits and share some supplies",
                            "Fight back against the bandits", "Surrender your supplies without resistance" },
                    new int[] { -5, -10, -15 });

            Scene scene5 = new Scene(
                    "You encounter a survivor in distress. How do you assist them?",
                    new String[] { "yay, a travel buddy",
                            "Ignore the survivor and continue your journey",
                            "Use the survivor as a distraction for zombies" },
                    new int[] { 10, -5, -10 });

            Scene scene6 = new Scene(
                    "Trapped in a Building: You get trapped inside a building surrounded by zombies. How do you escape?",
                    new String[] { "Find a safe route through the building and escape",
                            "Fight your way out, risking injury",
                            "Hide and wait for help, risking discovery by zombies" },
                    new int[] { 10, -10, -5 });

            Scene scene7 = new Scene(
                    "Rescue a Zombie Child: You encounter a zombie child who seems lost and scared. What is your response?",
                    new String[] { "Comfort the child and lead them to safety",
                            "Avoid the child and continue your journey",
                            "Attack the child out of fear or self-defense" },
                    new int[] { -10, 10, -15 });

            // Add scenes to the game
            game.addScene(scene1);
            game.addScene(scene2);
            game.addScene(scene3);
            game.addScene(scene4);
            game.addScene(scene5);
            game.addScene(scene6);
            game.addScene(scene7);

            // Start the game
            game.startGame();

            // Ask if the player wants to play again
            System.out.println("Do you want to play again? (Press 'y' to play again or any other key to exit)");
            char choice = scanner.next().charAt(0);
            playAgain = (choice == 'y' || choice == 'Y');
            scanner.nextLine(); // Consume newline
        }

        System.out.println("Thanks for playing. Bye!");

        // Closing scanner
        scanner.close();
    }
}
