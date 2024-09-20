package module02.models;

import java.util.Random;
import java.util.Scanner;

/**
 * This class demonstrates the usage of the Player class by generating and
 * displaying player attributes. It also explores various concepts related to
 * class definition, object creation, encapsulation, and more.
 *
 * 9.2 Defining Classes for Objects The Player class is used here, which
 * encapsulates player attributes and behavior, following object-oriented
 * principles.
 *
 * 9.4 Constructing Objects Using Constructors Player objects are created using
 * constructors to initialize their attributes with specific values.
 *
 * 9.5 Accessing Objects via Reference Variables Player objects are accessed and
 * manipulated using reference variables in this class.
 *
 * 9.5.1 Accessing an Object’s Data and Methods Player attributes and methods
 * are accessed and called to interact with the objects.
 *
 * 9.5.2 Reference Data Fields and the null Value Reference variables are
 * demonstrated here, where they are used to refer to Player objects. They can
 * also be null.
 *
 * 9.6 Using Classes from the Java Library The Random class is used to generate
 * random values for player attributes.
 *
 * 9.10 Passing Objects to Methods Player objects are created with random
 * attributes and then passed as arguments to other methods.
 *
 * 9.11 Array of Objects Demonstrates the creation of an array of Player objects
 * to store and manage multiple players.
 *
 * 9.12 Immutable Objects and Classes Player objects are mutable here, but
 * concepts of immutability are relevant when designing classes.
 *
 * 9.14 The this Reference In the Player class, the constructor uses 'this' to
 * refer to instance variables while distinguishing them from parameters.
 */
public class TestMyPlayer {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		// Get user input for player attributes
		System.out.print("Enter jersey number (0-99): ");
		int jerseyNum = scanner.nextInt();
		// Consume newline character
		scanner.nextLine();
		// Prompt user for first name
		System.out.print("Enter first name: ");
		String fname = scanner.nextLine();
		// Prompt user for last name
		System.out.print("Enter last name: ");
		String lname = scanner.nextLine();
		// Prompt user for position
		System.out.print("Enter position (Guard/Forward/Center): ");
		String pos = scanner.nextLine();
		// Prompt user for years active
		System.out.print("Enter years active (0-13): ");
		int yr = scanner.nextInt();
		// Create a Player object with user-provided attributes
		Player player = new Player(jerseyNum, fname, lname, pos, yr);
		System.out.println("Player created:");
		System.out.println(player);

		scanner.close();
		// Generate random values for Player attributes
		jerseyNum = random(0, 99);
		fname = ranFname();
		lname = ranLname();
		pos = ranPos();
		yr = random(0, 13);

		// Create a Player object with random attribute values
		player = new Player(jerseyNum, fname, lname, pos, yr);
		System.out.println(player);

		// Demonstrate creating an array of Player objects
		Player[] players = new Player[5];
		for (int i = 0; i < players.length; i++) {
			players[i] = generateRandomPlayer();
		}
		printPlayers(players);
	}

	/**
	 * Generate a random position for the player.
	 *
	 * @return Randomly selected position
	 */
	private static String ranPos() {
		String[] p = { "Guard", "Forward", "Center" };
		return p[random(0, p.length)];
	}

	/**
	 * Generate a random last name for the player.
	 *
	 * @return Randomly selected last name
	 */
	private static String ranLname() {
		String[] l = { "Williams", "Richards", "Willis", "Carson", "Gomez", "Wu", "Davis" };
		return l[random(0, l.length)];
	}

	/**
	 * Generate a random first name for the player.
	 *
	 * @return Randomly selected first name
	 */
	private static String ranFname() {
		String[] f = { "Sue", "Lee", "Jen", "Rob", "Erica", "Van", "Jill" };
		return f[random(0, f.length)];
	}

	/**
	 * Generate a random integer within the specified range.
	 *
	 * @param i Lower bound of the range
	 * @param j Upper bound of the range
	 * @return Random integer within the specified range
	 */
	private static int random(int i, int j) {
		return new Random().nextInt(j - i) + i;
	}

	/**
	 * Generate a Player object with random attributes.
	 *
	 * @return Player object with random attributes
	 */
	private static Player generateRandomPlayer() {
		int jeresyNum = random(0, 99);
		String fname = ranFname();
		String lname = ranLname();
		String pos = ranPos();
		int yr = random(0, 13);
		return new Player(jeresyNum, fname, lname, pos, yr);
	}

	/**
	 * Print details of an array of Player objects.
	 *
	 * @param players Array of Player objects
	 */
	private static void printPlayers(Player[] players) {
		for (Player player : players) {
			System.out.println(player);
		}
	}
}
