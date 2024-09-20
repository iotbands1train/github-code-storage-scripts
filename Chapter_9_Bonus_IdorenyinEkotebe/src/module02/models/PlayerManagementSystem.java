package module02.models;

import java.util.Random;
import java.util.Scanner;

/**
 * This class represents a Player Management System that allows users 
 * to create, manage, and interact with a team of players.
 */

public class PlayerManagementSystem {
	// Array to store players
    private Player[] players; 
    // Number of players in the team
    private int playerCount; 

    /**
     * Initializes a PlayerManagementSystem with a specified maximum number of players.
     *
     * @param maxPlayers The maximum number of players that can be added to the system.
     */
    public PlayerManagementSystem(int maxPlayers) {
        players = new Player[maxPlayers];
        playerCount = 0;
    }

    /**
     * Creates a player with randomly generated attributes and adds it to the team.
     */
    public void createPlayerAuto() {
        if (playerCount < players.length) { // Check if team is not full
            int jerseyNum = generateRandomNumber(0, 99);
            String fname = generateRandomFirstName();
            String lname = generateRandomLastName();
            String pos = generateRandomPosition();
            int years = generateRandomNumber(0, 13);

            Player player = new Player(jerseyNum, fname, lname, pos, years);
            players[playerCount] = player;
            playerCount++;
        } else {
            System.out.println("Team is full. Cannot add more players.");
        }
    }

    /**
     * Generates a random first name for a player.
     *
     * @return A randomly selected first name.
     */
    private String generateRandomFirstName() {
    	// Array of possible first names
        String[] firstNames = {"Sue", "Lee", "Jen", "Rob", "Erica", "Van", "Jill"};
        // Generate a random index within the range of firstNames array
        int randomIndex = generateRandomNumber(0, firstNames.length);
        // Return the randomly selected first name
        return firstNames[randomIndex];
    }
    /**
     * Generates a random player position.
     *
     * @return A randomly selected player position.
     */
    private String generateRandomLastName() {
    	// Array of possible last names
        String[] lastNames = {"Williams", "Richards", "Willis", "Carson", "Gomez", "Wu", "Davis"};
        // Generate a random index within the range of lastNames array
        int randomIndex = generateRandomNumber(0, lastNames.length);
        // Return the randomly selected last name
        return lastNames[randomIndex];
    }
    /**
     * Generates a random player position.
     *
     * @return A randomly selected player position.
     */
    private String generateRandomPosition() {
        String[] positions = {"Guard", "Forward", "Center"};
        return positions[generateRandomNumber(0, positions.length)];
    }

    /**
     * Generates a random first name for a player.
     *
     * @return A randomly selected first name.
     */
    private int generateRandomNumber(int min, int max) {
        return new Random().nextInt(max - min + 1) + min;
    }

    /**
     * Allows the user to input player attributes and creates a player with those attributes.
     */
    public void createPlayerUserInput() {
        if (playerCount < players.length) { // Check if team is not full
        	Scanner scanner = new Scanner(System.in);
        	// Prompt user for jersey number
        	System.out.print("Enter jersey number: ");
        	int jerseyNum = scanner.nextInt();
        	// Consume newline
        	scanner.nextLine(); 
        	// Prompt user for first name
        	System.out.print("Enter first name: ");
        	String fname = scanner.nextLine();
        	// Prompt user for last name
        	System.out.print("Enter last name: ");
        	String lname = scanner.nextLine();
        	// Prompt user for position
        	System.out.print("Enter position: ");
        	String pos = scanner.nextLine();
        	// Prompt user for years
        	System.out.print("Enter years: ");
        	int years = scanner.nextInt();
        	// Create a new player instance with the provided attributes
        	Player player = new Player(jerseyNum, fname, lname, pos, years);
        	// Add the new player to the players array
        	players[playerCount] = player;
        	// Increment the player count
        	playerCount++;

        } else {
            System.out.println("Team is full. Cannot add more players.");
        }
    }

    /**
     * Displays information of all players in the team.
     */
    public void readAllPlayers() {
        for (int i = 0; i < playerCount; i++) {
            System.out.println(players[i]);
        }
    }

    /**
     * Updates the position of a player with a specified jersey number.
     *
     * @param jerseyNum The jersey number of the player to be updated.
     */
    public void updatePlayer(int jerseyNum) {
        int index = findPlayerIndexByJerseyNum(jerseyNum);
        if (index != -1) { // Check if player is found
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter new position: ");
            String newPos = scanner.nextLine();

            players[index].setPosition(newPos);
            System.out.println("Player updated successfully.");
        } else {
            System.out.println("Player not found.");
        }
    }

    /**
     * Trades a player with a specified jersey number out of the team.
     *
     * @param jerseyNum The jersey number of the player to be traded.
     */
    public void tradePlayer(int jerseyNum) {
        int index = findPlayerIndexByJerseyNum(jerseyNum);
        if (index != -1) { // Check if player is found
            for (int i = index; i < playerCount - 1; i++) {
                players[i] = players[i + 1];
            }
            playerCount--;
            System.out.println("Player traded successfully.");
        } else {
            System.out.println("Player not found.");
        }
    }

    /**
     * Displays information of a player with a specified jersey number.
     *
     * @param jerseyNum The jersey number of the player to be displayed.
     */
    public void displayPlayerByJerseyNum(int jerseyNum) {
        int index = findPlayerIndexByJerseyNum(jerseyNum);
        if (index != -1) { // Check if player is found
            System.out.println(players[index]);
        } else {
            System.out.println("Player not found.");
        }
    }

    /**
     * Finds the index of a player in the team based on their jersey number.
     *
     * @param jerseyNum The jersey number of the player to search for.
     * @return The index of the player in the players array, or -1 if not found.
     */
    private int findPlayerIndexByJerseyNum(int jerseyNum) {
        for (int i = 0; i < playerCount; i++) {
            if (players[i].getJerseyNum() == jerseyNum) {
                return i; // Player found at index i
            }
        }
        return -1; // Player not found
    }

    /**
     * Creates a bulk of players with randomly generated attributes.
     *
     * @param count The number of players to be created.
     */
    public void createBulkPlayers(int count) {
        for (int i = 0; i < count; i++) {
            createPlayerAuto();
        }
    }

    /**
     * Gets the count of players in the team.
     *
     * @return The number of players in the team.
     */
    public int getPlayerCount() {
        return playerCount;
    }

    /**
     * The main method to interact with the Player Management System.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get the maximum number of players from the user
        System.out.print("Enter the maximum number of players: ");
        int maxPlayers = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        // Initialize the player management system with the maximum number of players
        PlayerManagementSystem system = new PlayerManagementSystem(maxPlayers);

        // Start the player management system loop
        system = managementSystem(system, scanner);

        // Close the scanner
        scanner.close();
    }

    /**
     * Runs the main loop of the player management system.
     *
     * @param system The PlayerManagementSystem instance to operate on.
     * @param scanner The Scanner instance for user input.
     * @return The updated PlayerManagementSystem instance.
     */
    private static PlayerManagementSystem managementSystem(PlayerManagementSystem system, Scanner scanner) {
        PlayerManagementSystem s = system;
        while (true) {
            // Display menu options
            System.out.println("Player Management System Menu:");
            System.out.println("1. Create Player (Auto)");
            System.out.println("2. Create Player (User Input)");
            System.out.println("3. Read All Players");
            System.out.println("4. Update Player");
            System.out.println("5. Trade Player");
            System.out.println("6. Display Player by Jersey Number");
            System.out.println("7. Create Bulk Players");
            System.out.println("8. Get Player Count");
            System.out.println("0. Exit");

            // Prompt for user choice
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            // Process user choice using a switch statement
            switch (choice) {
                case 1:
                    // Create Player (Auto)
                    s.createPlayerAuto();
                    break;
                case 2:
                    // Create Player (User Input)
                    s.createPlayerUserInput();
                    break;
                case 3:
                    // Read All Players
                    s.readAllPlayers();
                    break;
                case 4:
                    // Update Player
                    System.out.print("Enter jersey number: ");
                    int jerseyNum = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    s.updatePlayer(jerseyNum);
                    // ... (rest of the switch cases)
                case 0:
                    // Exit
                    System.out.println("Exiting Player Management System.");
                    scanner.close();
                    System.exit(0);
                default:
                    // Invalid choice
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}

