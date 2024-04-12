import java.util.Scanner;

public class Main {
        public static void main(String[] args) {
                Scanner scanner = new Scanner(System.in);

                // Intro
                System.out.println("Save the ZOMBIES!");
                System.out.println(
                                "In this post-apocalyptic world overrun by zombies, your objective is to reach a safe haven while navigating through various challenges.");
                System.out.println(
                                "Throughout the game, you must make strategic decisions that impact your survival and the well-being of others. There's a cure in the works for the zombies so try not to harm an zombies along journey. (You need 25 points to win the game)");

                boolean playAgain = true;
                while (playAgain) {

                        System.out.println("Enter your name:");
                        String playerName = scanner.nextLine();
                        System.out.println("Use numbers to select your choices");

                        // constructor- Player(String name, int healthPoints int compassion)
                        Player player = new Player(playerName, 100, 10);

                        // Game object witth var game is initialized with player object
                        Game game = new Game(player);

                        // new instance of scene assigned to scene 1-7 vars...
                        // public Scene(String description, String[] choices, int[] outcomes)
                        Scene scene1 = new Scene(
                                        "You stumble upon a hidden survivor camp. What do you do?",
                                        new String[] { "Offer your help", "Steal supplies from the camp",
                                                        "Ignore the camp and move on" },
                                        new int[] { 5, -15, 0 });

                        Scene scene2 = new Scene(
                                        "You find a survivor trapped by zombies. What's your next move?",
                                        new String[] { "Rescue the survivor",
                                                        "Leave the survivor behind to save yourself",
                                                        "Use the survivor as bait to distract the zombies" },
                                        new int[] { 10, 0, -10 });

                        Scene scene3 = new Scene(
                                        "You come across some supplies left behind by other survivors. What do you do?",
                                        new String[] { "Take only what you need and leave the rest for others",
                                                        "Hoard all the supplies for yourself",
                                                        "Ignore the supplies and continue your journey" },
                                        new int[] { 5, -5, 0 });

                        Scene scene4 = new Scene(
                                        "A group of hostile survivors ambushes you and demands your supplies. What do you do?",
                                        new String[] { "Negotiate with the bandits and share some supplies",
                                                        "Fight back against the bandits",
                                                        "Surrender your supplies without resistance" },
                                        new int[] { -5, -10, -5 });

                        Scene scene5 = new Scene(
                                        "You encounter a survivor in distress. What's your next move?",
                                        new String[] { "Offer your help, might be a travel buddy",
                                                        "Ignore the survivor and continue your journey",
                                                        "Use the survivor as a distraction for zombies" },
                                        new int[] { 10, -5, -10 });

                        Scene scene6 = new Scene(
                                        "You encounter a zombie child who seems lost and scared. What is your response?",
                                        new String[] { "Comfort the child and lead them to safety",
                                                        "Avoid the child and continue your journey",
                                                        "Attack the child out of fear or self-defense" },
                                        new int[] { 10, -5, -15 });

                        game.addScene(scene1);
                        game.addScene(scene2);
                        game.addScene(scene3);
                        game.addScene(scene4);
                        game.addScene(scene5);
                        game.addScene(scene6);
                        // starts the game by calling the startGame method of the Game class, initiating
                        // the game loop.
                        game.startGame(scanner);

                        // Ask if the player wants to play again
                        System.out.println(
                                        "Do you want to play again? (Press 'yes' to play again or any other key to exit)");
                        String choice = scanner.nextLine();
                        playAgain = choice.equalsIgnoreCase("yes");
                        // scanner.nextLine();
                        // If the player chooses not to play again, the loop is exited using the break
                        // statement
                        if (!choice.equalsIgnoreCase("yes"))
                                break;
                }
                System.out.println("Thanks for playing. Bye!");

                // Closing scanner
                scanner.close();
        }// main method
} // class
