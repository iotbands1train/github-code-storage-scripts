package module01.instructor.cosc1436recap;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Idorenyin_Etokebe_COSC1437_PMSproject_CRN_6241_Project_2 {
	/**
	 * The main method of the Person Management System.
	 *
	 * @param args The command line arguments passed to the program (not used in
	 *             this application).
	 */
	public static void main(String[] args) {
		boolean againStartLogin = false;
		String[] templ = { "2023002", "Henry", "James", "13205", "Brown Rd.", "Magnolias", "CA", "68566", "5386493703",
				"41488.00" };
		int colsInDatabase = indexTable(templ);
		// System.exit(0);
		String adminDatabase = "[root21,password123]\n[admin2,pass55]\n[cosc1436,pass65]\n";
		// Prompt user to enter the maximum number of people in the database and create
		// the database accordingly.
		System.out.println("Enter the Max # people in this Database, max size? = ");
		Scanner input = new Scanner(System.in);
		int rows = Integer.parseInt(input.nextLine());
		String[][] pDatabase = new String[rows][colsInDatabase];
		System.out.println("Max limit = " + rows);
		// Default starting data for the database.
		pDatabase[0] = new String[] { "2023002", "Henry", "James", "13205", "Brown Rd.", "Magnolias", "CA", "68566",
				"5386493703", "41488.00" };
		pDatabase[1] = new String[] { "2023003", "Henry", "James", "13014", "Main St.", "Bloomington", "CA", "50798",
				"6248089606", "65463.00" };
		pDatabase[2] = new String[] { "2023004", "Sue", "James", "15056", "Main St.", "Magnolias", "FL", "76579",
				"6786884725", "51037.00" };
		pDatabase[3] = new String[] { "2023005", "Henry", "Willis", "16755", "Brown Rd.", "Magnolias", "FL", "61019",
				"7687218941", "107242.00" }; 
		System.out.println(adminDatabase);
		introDisplay();
		// Start the login menu and keep running until the user decides to exit.
		do {
			loginMenu(pDatabase, adminDatabase, input, rows, colsInDatabase);
			System.out.println("Go back to Start Login Menu? Yes or No ");
			againStartLogin = input.nextLine().toUpperCase().charAt(0) == 'Y' ? true : false;
		} while (againStartLogin);
		System.out.println("Program has Ended");

		input.close();
	}
	
	/**
	 * Calculates the number of non-empty strings in the given array.
	 *
	 * @param templ The array of strings to be processed.
	 * @return The count of non-empty strings in the array.
	 */
	private static int indexTable(String[] templ) {
		int count = 0;
		
		// Count the number of non-empty strings in the array		
		for (int i = 0; i < templ.length; i++) {
			// Retrieve the current string from the array
			String string = templ[i];
			
			// Check if the string is non-empty; if yes, increment the count
			if (string.length() > 0)
				count++;
		}
		return count;
	}

	/**
	 * Displays the introductory information of the Person Management System (PMS).
	 * This method prints out a welcome message along with the objectives, chapters,
	 * topics, functionalities, and developer information of the program.
	 */ 
	public static void introDisplay() {
	    System.out.println("  =============================================== ");
	    System.out.println("            Person Management System              ");
	    System.out.println("  =============================================== ");
	    System.out.println(" Welcome to Person Management System (PMS)! ");
	    System.out.println();
		System.out.println(" This Program objectives are to manage, store, and");
		System.out.println(" create various user\'s records of personal");
		System.out.println(" information.");
		System.out.println();

	    System.out.println(" .................................................");
	    System.out.println(" This Program chapters............................");
	    System.out.println("   - Chapter 1: Introduction to Computers, Programs, and Java");
	    System.out.println("   - Chapter 2: Elementary Programming");
	    System.out.println("   - Chapter 3: Selections");
	    System.out.println("   - Chapter 4: Mathematical Functions, Characters, and Strings");
	    System.out.println("   - Chapter 5: Loops");
	    System.out.println("   - Chapter 6: Methods");
	    System.out.println("   - Chapter 7: Single-Dimensional Arrays");
	    System.out.println("   - Chapter 8: Multidimensional Arrays");
	    System.out.println(" .................................................");
		System.out.println();
		System.out.println(" This Program topics include: if-else statements, ");
		System.out.println(" Boolean values, declaring variables, new Scanner,");
		System.out.println(" Println statements, numeric data types, reassigning");
		System.out.println(" variables, time values, random values, switch");
		System.out.println(" statements, reassigning variables, string formats,");
		System.out.println(" concatenating data -----");
		System.out.println();

	    System.out.println(" .................................................");
	    System.out.println(" This Program functionalities include: (1) Creating");
		System.out.println(" a new person in the management system via an AUTO");
		System.out.println(" option or NORMAL option, where the user is able to");
		System.out.println(" manually input all of their personal information. ");
		System.out.println(" We are also able to (2) Read a persons information,");
		System.out.println(" (3) Update a persons information, (4) Delete a persons");
		System.out.println(" information, or (5) Find a person.");
		System.out.println(" ");

	    System.out.println(" .................................................");
	    System.out.println(" This Program developer....enter bio about developer.."); 
	    System.out.println(" ..............paragraph of bio......................");
	    System.out.println("  =============================================== ");
	    System.out.println("  ");
	}

	/**
	 * Displays the SignUp Menu screen and allows the user to create an admin
	 * account. This method prompts the user to enter a username and password and
	 * adds the new admin account to the adminDatabase. It then verifies the admin
	 * account and grants access if the username and password match.
	 *
	 * @param adminDatabase The database containing admin usernames and passwords.
	 * @param input         The Scanner object used for user input.
	 * @return Returns true if the login is successful and false otherwise.
	 */
	private static boolean signUpMenu(String adminDatabase, Scanner input) {
		boolean goodLogin = false;
		String currentUser = "", currentPass = "";
		System.out.println(" SignUp Menu - Screen ");
		System.out.println("Enter username (ex. code21");
		currentUser = input.nextLine();
		System.out.println("Enter password (ex. password123");
		currentPass = input.nextLine();
		adminDatabase += "[" + currentUser + "," + currentPass + "]\n";
		System.out.println("Verify your admin account!");
		System.out.println("[1] Please, Enter your username:");
		currentUser = input.nextLine();
		if (adminDatabase.contains(currentUser)) {
			System.out.println("User exist");
			int index = adminDatabase.indexOf(currentUser + ",");
			String checkPass = adminDatabase.substring(index + (currentUser + ",").length());
			checkPass = checkPass.substring(0, checkPass.indexOf(']'));
			System.out.println("password=[" + checkPass + "]");
			System.out.println("[2] Enter your password:");
			currentPass = input.nextLine();
			if (currentPass.equals(checkPass)) {
				System.out.println("Access Granted ");
				goodLogin = true;
			} else {
				System.out.println("Bad password...");
				System.out.println("Denied Access...");
				goodLogin = false;
			}
		} else {
			System.out.println("User does not exist");
			System.out.println("Denied Access...");
			goodLogin = false;
		}
		return goodLogin;
	}

	/**
	 * Verifies the admin's credentials by prompting them to enter their username
	 * and password. This method is used for admin login and checks if the provided
	 * username exists in the adminDatabase. If the username is found, it retrieves
	 * the corresponding password from the database and compares it with the
	 * provided password. If the password matches, the login is successful and the
	 * method returns true. If the username or password is incorrect, the method
	 * returns false.
	 *
	 * @param adminDatabase The database containing admin usernames and passwords.
	 * @param input         The Scanner object used for user input.
	 * @return true if the admin's credentials are verified and login is successful,
	 *         false otherwise.
	 */
	private static boolean loginScreen(String adminDatabase, Scanner input) {
		boolean goodLogin = false;
		String currentUser = "", currentPass = "";
		System.out.println("Verify your admin account!");
		System.out.println("[1] Please, Enter your username:");
		// currentUser = input.nextLine();
		currentUser = "cosc1436";
		if (adminDatabase.contains(currentUser)) {
			System.out.println("User exist");
			int index = adminDatabase.indexOf(currentUser + ",");
			String checkPass = adminDatabase.substring(index + (currentUser + ",").length());
			checkPass = checkPass.substring(0, checkPass.indexOf(']'));
			System.out.println("password=[" + checkPass + "]");
			System.out.println("[2] Enter your password:");
			// currentPass = input.nextLine();
			currentPass = "pass65";
			if (currentPass.equals(checkPass)) {
				System.out.println("Access Granted ");
				goodLogin = true;
			} else {
				System.out.println("Bad password...");
				System.out.println("Denied Access...");
				goodLogin = false;
			}
		} else {
			System.out.println("User does not exist");
			System.out.println("Denied Access...");
			goodLogin = false;
		}
		return goodLogin;
	}

	/**
	 * Displays the Login Menu screen and handles user login or signup based on the
	 * selected option. This method prompts the user to choose between signing up as
	 * an admin or logging in as an existing admin. If the user selects "SignUp
	 * Admin," it calls the signUpMenu method to create a new admin account. If the
	 * user selects "Login Admin," it calls the loginScreen method to verify the
	 * admin's credentials. If the user selects "Exit," the program terminates.
	 *
	 * @param pDatabase      The database containing person information.
	 * @param adminDatabase  The database containing admin usernames and passwords.
	 * @param input          The Scanner object used for user input.
	 * @param rows           The maximum number of people in the person database.
	 * @param colsInDatabase
	 */
	private static void loginMenu(String[][] pDatabase, String adminDatabase, Scanner input, int rows,
			int colsInDatabase) {
		int menuOptionLogin = -1;
		boolean goodLogin = false;
		System.out.println(" Login Menu ");
		System.out.println(" 1 - [SignUp] Admin ");
		System.out.println(" 2 - [Login] Admin ");
		System.out.println(" 3 - [Exit]  ");
		// menuOptionLogin = Byte.parseByte(input.nextLine());
		menuOptionLogin = 2;
		if (menuOptionLogin == 1) {
			goodLogin = signUpMenu(adminDatabase, input);
		} else if (menuOptionLogin == 2) {
			goodLogin = loginScreen(adminDatabase, input);
		} else {
			System.exit(0);
		}
		if (goodLogin) {
			mainMenu(pDatabase, input, rows, colsInDatabase);
			goodLogin = false;
		}

	}

	/**
	 * Displays the main menu of the Person Management System (PMS) and handles user
	 * input to perform various operations.
	 *
	 * @param pDatabase      The database containing person records.
	 * @param input          The Scanner object used for user input.
	 * @param rows           The maximum number of rows in the database.
	 * @param colsInDatabase
	 */
	public static void mainMenu(String[][] pDatabase, Scanner input, int rows, int colsInDatabase) {
		int menuOptionMain;
		int menuOptionCreate;
		boolean againMainMenu = true;
		while (againMainMenu) {
			System.out.println(" Main Menu ");
			System.out.println(" 1 - [CREATE] Person ");
			System.out.println(" 2 - [READ] Persons ");
			System.out.println(" 3 - [UPDATE] Person ");
			System.out.println(" 4 - [DELETE] Person ");
			System.out.println(" 5 - [FIND] Person ");
			System.out.println(" 6 - [BULK] Create (x)Persons ");
			System.out.println(" 7 - [COUNT] Persons ");
			System.out.println(" 8 - [CLEAR] Person ");
			System.out.println("  ");
			System.out.println("Please input 1-7 : ");
			menuOptionMain = Integer.parseInt(input.nextLine());
			System.out.println("  ========================== ");
			System.out.println(" [user-input-auto-select] = " + menuOptionMain);
			System.out.println("  ========================== ");
			System.out.println("  ");
			switch (menuOptionMain) {
			case 1:
				System.out.println("[CREATE] Person Menu Option");
				System.out.println("1 - AUTO - CREATE PERSON FORM");
				System.out.println("2 - NORMAL - CREATE PERSON FORM");
				menuOptionCreate = Integer.parseInt(input.nextLine());
				if (menuOptionCreate == 1) {
					String[] newPerson = autoCreatePerson(pDatabase, input);
					pDatabase = addPersonToDatabase(pDatabase, newPerson);
				} else if (menuOptionCreate == 2) {
					String[] newPerson = normalCreatePerson(pDatabase, input);
					pDatabase = addPersonToDatabase(pDatabase, newPerson);
				} else {
					System.out.println("Enter @ CREATE Menu");
				}
				printArr(pDatabase);
				break;
			case 2:
				System.out.println("[READ] Person Menu Option");
				System.out.println("List of Person:");
				readMenuOption(pDatabase);
				break;
			case 3:
				System.out.println("[UPDATE] Person Menu Option");
				System.out.println("Enter id# to change data:");
				pDatabase = updatePerson(pDatabase, input);
				break;
			case 4:
				System.out.println("[DELETE] Person Menu Option");
				System.out.println("Enter id# to change data:");
				pDatabase = deletePerson(pDatabase, input);
				break;
			case 5:
				System.out.println("[FIND] Person Menu Option");
				System.out.println("Enter id# to find data:");
				findPerson(pDatabase, input);
				break;
			case 6:
				System.out.println("[BULK] Create (x) Persons Menu Option");
				bulkCreatePersons(pDatabase, input);
				break;
			case 7:
				System.out.println("[COUNT] Persons Menu Option");
				int totalCount = countPersons(pDatabase);
				System.out.println("Total number of persons: " + totalCount);
				break;
			case 8:
				System.out.println("[CLEAR] Persons Menu Option");
				pDatabase = clearPersons(pDatabase, input, rows, colsInDatabase);
				break;
			default:
				System.out.println("Enter @ Main Menu");
			}

			System.out.println("Go back to Main Menu? Yes or No ");
			againMainMenu = input.nextLine().toUpperCase().charAt(0) == 'Y' ? true : false;
		}

	}
	
	/**
	 * Displays a menu of options and processes the selected option for manipulating a 2D array.
	 *
	 * @param pDatabase The 2D array to be manipulated.
	 * 
	 */
	private static void readMenuOption(String[][] pDatabase) {
		System.out.println("Read Option Menu");
		System.out.println("1 - Displaying Arrays");
		System.out.println("2 - Summing all elements ");
		System.out.println("3 - Shuffle/Random elements");
		int ans = Integer.parseInt(new Scanner(System.in).nextLine());
		ans = ans < 1 || ans > 3 ? 1 : ans;
		switch (ans) {
		case 1:
			readPeople(pDatabase);
			break;
		case 2:
			summingAllSalary(pDatabase);
			break;
		case 3:
			shuffleElements(pDatabase);
			break;
		}

	}
	
	/**
	 * Shuffles the elements within a 2D array randomly.
	 *
	 * @param pDatabase The 2D array to be shuffled.
	 * 
	 */
	private static void shuffleElements(String[][] pDatabase) {
		Random random = new Random();
		for (int r = pDatabase.length - 1; r > 0; r--) {
			// Generate a random index within the remaining unshuffled part of the array
			int j = random.nextInt(r + 1);
			
			// Swap the elements at indices r and j to shuffle the array
			String[] tmpArr = pDatabase[r];
			pDatabase[r] = pDatabase[j];
			pDatabase[j] = tmpArr;

		}

	}
	
	/**
	 * Calculates and prints the sum of all salaries stored in a specific column of a 2D array.
	 *
	 * @param pDatabase The 2D array containing the salary information.
	 * 
	 */
	private static void summingAllSalary(String[][] pDatabase) {
		double total = 0;
		
		// Iterate through the columns of a specific row to calculate the total salary
		for (int r = 0; r < pDatabase[0].length; r++) {
			
			// Iterate through the rows (records) of the database
			for (int c = 0; c < pDatabase.length; c++) {
				// Retrieve the salary string from the specified column
				String salaryString = pDatabase[r][9];
				
				// Parse and add the salary to the total
				total += Double.parseDouble(salaryString);
			}
		}
		
		// Print the total salary with formatted output
		System.out.printf("Total = $%,.2f\n", total);
	}

	/**
	 * Prints the non-null elements of the 2D array pDatabase.
	 *
	 * @param pDatabase The 2D array representing the database of persons.
	 */
	private static void printArr(String[][] pDatabase) {
		
		// Iterate through the records in the database to display non-null records
		for (int i = 0; i < pDatabase.length; i++) {
			 // Check if the current record is not null
			if (pDatabase[i][0] != null) {
				String[] strings = pDatabase[i];
				System.out.print("[" + i + "]");
				
				// Iterate through the strings in the record and display them
				for (int j = 0; j < strings.length; j++) {
					String string = strings[j];
					System.out.print(" " + string + " ");
				}
				// Print a newline after displaying the record
				System.out.println();
			}
		}
	}

	/**
	 * Adds a new person represented by the newPerson array to the pDatabase 2D
	 * array.
	 *
	 * @param pDatabase The 2D array representing the database of persons.
	 * @param newPerson The array representing the new person to be added.
	 * @param input     The Scanner object for user input.
	 * @return The updated 2D array representing the database of persons.
	 */
	private static String[][] addPersonToDatabase(String[][] pDatabase, String[] newPerson) {
		int count = 0;
		for (int i = 0; i < pDatabase.length; i++) {
			if (pDatabase[i][0] != null && pDatabase[i][0].length() > 0) {
				count++;
			}
		}
		if (count < pDatabase.length) {
			pDatabase[count] = newPerson;
			System.out.println("Person added to the database!");
		} else {
			System.out.println("Database is full. Cannot add more persons.");
		}
		return pDatabase;
	}

//100 max people = null = in array 
	/**
	 * Generates random data for a new person and returns the person's information
	 * as a String array.
	 *
	 * @param pDatabase The 2D array representing the database of persons.
	 * @param input     The Scanner object for user input.
	 * @return The String array representing the information of the new person in
	 *         the following order: [personID, personFirstName, personLastName,
	 *         personStreetNo, personStreetName, personCity, personState,
	 *         personZipCode, personPhone, personSalary]
	 */
	private static String[] autoCreatePerson(String[][] pDatabase, Scanner input) {

		String personFirstName = "null";
		String personLastName = "null";
		short personStreetNo = 0;
		String personStreetName = "null";
		String personCity = "null";
		String personState = "null";
		int personZipCode = 0;
		long personPhone = 0;
		double personSalary = 0;
		byte personCount = 0;
		int personID = 0;
		long startTime, endTime = 0;
		double elapsetTime = 0;
		byte personCreationHour, personCreationMin = 0;

		System.out.println("   ========================================== ");
		System.out.println("   ===AUTO===   CREATE Menu - form    ========= ");
		System.out.println("   ========================================== ");
		Random r = new Random();
		int rnd = r.nextInt(1, 3);
		startTime = System.currentTimeMillis();
		System.out.println("  ");
		personID = Integer.parseInt(getLastIdNumber(pDatabase)) + 1;
		System.out.println(" personCount = [" + personCount + "]");
		System.out.println(" personID = [" + personID + "]");
		rnd = r.nextInt(1, 3);
		personFirstName = randomFN();
		System.out.println(" personFirstName = [" + personFirstName + "]");
		rnd = r.nextInt(1, 3);
		personLastName = randomLN();
		System.out.println(" personLastName = [" + personLastName + "]");
		personStreetNo = (short) r.nextInt(1, 22000);
		System.out.println(" personStreetNo = [" + personStreetNo + "]");
		rnd = r.nextInt(1, 3);
		personStreetName = randomSN();
		System.out.println(" personStreetName = [" + personStreetName + "]");
		rnd = r.nextInt(1, 3);
		personCity = randomCI();
		System.out.println(" personCity = [" + personCity + "]");
		rnd = r.nextInt(1, 3);
		personState = randomST();
		System.out.println(" personState = [" + personState + "]");
		personZipCode = r.nextInt(11111, 99111);
		System.out.println(" personZipCode = [" + personZipCode + "]");
		personPhone = (long) (Math.random() * (9132229900L - 2132229900L) + 2132229900L);
		System.out.println(" personPhone = [" + personPhone + "]");
		personSalary = (long) (Math.random() * (125000 - 25000) + 25000);
		System.out.println(" personSalary = [" + personSalary + "]");

		endTime = System.currentTimeMillis();
		elapsetTime = ((endTime - startTime) / 1000) % 60;
		personCreationMin = (byte) ((((System.currentTimeMillis()) / 1000) / 60) % 60);
		personCreationHour = (byte) (((((System.currentTimeMillis()) / 1000) / 60) / 60) % 24);
		personCreationHour -= 5;
		personCreationHour = (personCreationHour < 0) ? (personCreationHour += 12) : personCreationHour;
		System.out.println(" Current TIme : [ " + personCreationHour + " : " + personCreationMin + "]  ");
		System.out.println("Person Creation TIme : [ " + elapsetTime + "] sec");
		System.out.println("   ========================================== ");
		personCount += 1;
		System.out.println("   ======  Person Add : id#" + personID + " ===== ");
		System.out.println("   ========================================== ");

		return new String[] { personID + "", personFirstName, personLastName, personStreetNo + "", personStreetName,
				personCity, personState, personZipCode + "", personPhone + "", personSalary + "" };

	}
	
	/**
	 * Generates a random index within the range of the given array's length.
	 *
	 * @param arr The array for which a random index needs to be generated.
	 * @return A random index within the valid range of the array
	 * 
	 */
	public static int ranArr(String[] arr) {
		double r = Math.random();
		int hi = arr.length - 1;
		int lo = 0;
		int randomValue = (int) (r * (hi - lo) + lo);
		return randomValue;
	}
	
	/**
	 * Generates a random first name from a predefined list of names.
	 *
	 * @return A randomly selected first name.
	 * 
	 */
	private static String randomFN() {
		String[] fnames = { "Sue", "Sara", "Toni", "Tyson", "Hannah", "Montana", "Vicky", "Becky", "Monica", "Henry",
				"James", "Jason", "Emma", "Olivia", "Noah", "Liam", "Ava", "Isabella", "Sophia", "Mia" };
		return fnames[ranArr(fnames)];
	}
	
	/**
	 * Generates a random last name from a predefined list of names.
	 *
	 * @return A randomly selected last name.
	 * 
	 */
	private static String randomLN() {
		String[] lnames = { "Willis", "Ramos", "Wei", "Wu", "Smits", "Dickinson", "Johns", "Johnson", "Gomez", "Tyler",
				"Nguyen", "Garcia", "Lee", "Martinez", "Brown", "Kim", "Rodriguez", "Chen", "Lopez", "Davis" };
		return lnames[ranArr(lnames)];
	}
	
	/**
	 * Generates a random street name from a predefined list of names.
	 *
	 * @return A randomly selected street name.
	 * 
	 */
	private static String randomSN() {
		String[] street = { "Main St.", "Wall Rd.", "West Ln.", "Fannin Rd.", "Westwood Ln.", "Apple St.", "Berry Ln.",
				"Maple Ave.", "Cedar Dr.", "Oak St.", "Pine Rd.", "Elm Ln.", "Birch Way", "Cherry Ct.", "Hickory Rd." };
		return street[ranArr(street)];
	}
	
	/**
	 * Generates a random city name from a predefined list of names.
	 *
	 * @return A randomly selected city name.
	 * 
	 */
	private static String randomCI() {
		String[] city = { "Austin", "NYC", "SF", "Miami", "Ball City", "Hamford", "Turtleville", "Appleton", "Chicago",
				"Los Angeles", "Seattle", "London", "Paris", "Tokyo", "Sydney", "Toronto", "Berlin", "Moscow" };
		return city[ranArr(city)];
	}
	
	/**
	 * Generates a random state abbreviation from a predefined list of abbreviations.
	 *
	 * @return A randomly selected state abbreviation.
	 * 
	 */
	private static String randomST() {
		String[] state = { "CA", "WY", "RI", "HI", "CO", "TX", "NY", "FL", "IL", "PA", "OH", "MI", "WA", "OR", "GA",
				"AZ", "NC", "VA", "MA", "WI", "MN" };
		return state[ranArr(state)];
	}

	/**
	 * Allows the user to input the information for a new person manually and
	 * returns the person's information as a String array.
	 *
	 * @param pDatabase The 2D array representing the database of persons.
	 * @param input     The Scanner object for user input.
	 * @return The String array representing the information of the new person in
	 *         the following order: [personID, personFirstName, personLastName,
	 *         personStreetNo, personStreetName, personCity, personState,
	 *         personZipCode, personPhone, personSalary]
	 */
	private static String[] normalCreatePerson(String[][] pDatabase, Scanner input) {

		String personFirstName = "null";
		String personLastName = "null";
		short personStreetNo = 0;
		String personStreetName = "null";
		String personCity = "null";
		String personState = "null";
		int personZipCode = 0;
		long personPhone = 0;
		double personSalary = 0;
		byte personCount = 0;
		int personID = 0;
		long startTime, endTime = 0;
		double elapsetTime = 0;
		byte personCreationHour, personCreationMin = 0;

		System.out.println("   ========================================== ");
		System.out.println("   ======== NORMAL  CREATE Menu - form    ==== ");
		System.out.println("   ========================================== ");
		startTime = System.currentTimeMillis();
		System.out.println("  ");
		personID = Integer.parseInt(getLastIdNumber(pDatabase)) + 1;
		System.out.println(" personCount = [" + personCount + "]");
		System.out.println(" personID = [" + personID + "]");
		System.out.println("   Enter First name : ");
		personFirstName = input.nextLine();
		System.out.println(" personFirstName = [" + personFirstName + "]");
		System.out.println("   Enter Last name : ");
		personLastName = input.nextLine();
		System.out.println(" personLastName = [" + personLastName + "]");
		System.out.println("   Enter Street No [Address] : ");
		personStreetNo = Short.parseShort(input.nextLine());
		System.out.println(" personStreetNo = [" + personStreetNo + "]");
		System.out.println("   Enter Street Name [Address] : ");
		personStreetName = input.nextLine();
		System.out.println(" personStreetName = [" + personStreetName + "]");
		System.out.println("   Enter City [Address] : ");
		personCity = input.nextLine();
		System.out.println(" personCity = [" + personCity + "]");
		System.out.println("   Enter State [Address] : ");
		personState = input.nextLine();
		System.out.println(" personState = [" + personState + "]");
		System.out.println("   Enter Zip Code [Address] : ");
		personZipCode = Integer.parseInt(input.nextLine());
		System.out.println(" personZipCode = [" + personZipCode + "]");
		System.out.println("   Enter Phone [Address] : ");
		personPhone = Long.parseLong(input.nextLine());
		System.out.println(" personPhone = [" + personPhone + "]");
		System.out.println("Please Enter your current salary (ex. 25000 - 125000):");
		personSalary = Float.parseFloat(input.nextLine());
		System.out.println(" personSalary = [" + personSalary + "]");
		endTime = System.currentTimeMillis();
		elapsetTime = ((endTime - startTime) / 1000) % 60;
		personCreationMin = (byte) ((((System.currentTimeMillis()) / 1000) / 60) % 60);
		personCreationHour = (byte) (((((System.currentTimeMillis()) / 1000) / 60) / 60) % 24);
		personCreationHour -= 5;
		personCreationHour = (personCreationHour < 0) ? (personCreationHour += 12) : personCreationHour;
		System.out.println(" Current TIme : [ " + personCreationHour + " : " + personCreationMin + "]  ");
		System.out.println("Person Creation TIme : [ " + elapsetTime + "] sec");
		personCount++;
		System.out.println("   ===========================================  ");
		System.out.println("    ===  Person Add : id#" + personID + " ===  ");
		System.out.println("   ===========================================  ");

		return new String[] { personID + "", personFirstName, personLastName, personStreetNo + "", personStreetName,
				personCity, personState, personZipCode + "", personPhone + "", personSalary + "" };

	}

	/**
	 * Displays the information of all the people in the given database.
	 *
	 * @param pDatabase The 2D array representing the database of persons.
	 */
	private static void readPeople(String[][] pDatabase) {
		printArr(pDatabase);
	}

	/**
	 * Updates the information of a person in the database with the provided ID.
	 *
	 * @param pDatabase The 2D array representing the database of persons.
	 * @param input     The Scanner object used to take user input.
	 * @return The updated 2D array representing the database after the person's
	 *         information has been updated.
	 */
	private static String[][] updatePerson(String[][] pDatabase, Scanner input) {
		String id = input.nextLine();
		boolean found = false;
		String[][] updatedDatabase = new String[pDatabase.length][pDatabase[0].length];

		for (int i = 0; i < pDatabase.length; i++) {
			if (pDatabase[i][0] != null && pDatabase[i][0].equals(id)) {
				found = true;
				System.out.println("Person found!");
				System.out.println("Select an option to change:");
				System.out.println("1 - Change [fname]\n2 - Change [lname]\n3 - Change [street no.]");
				System.out.println("4 - Change [street name]\n5 - Change [city]\n6 - Change [state]");
				System.out.println("7 - Change [zip]\n8 - Change [phone]\n9 - Change [salary]");
				System.out.println("\n\n\n[row & id] skip! Can not be updated!");
				System.out.println();
				System.out.println("Please Enter (1-9): ");
				int option = Integer.parseInt(input.nextLine());

				// Copy the existing person data to updatedDatabase
				for (int j = 0; j < pDatabase[i].length; j++) {
					updatedDatabase[i][j] = pDatabase[i][j];
				}

				int elementIndex = option;
				System.out.println("Current value: " + pDatabase[i][elementIndex]);
				System.out.println("Enter new value:");
				String newValue = input.nextLine();

				updatedDatabase[i][elementIndex] = newValue;
			} else {
				// Copy the existing person data to updatedDatabase
				for (int j = 0; j < pDatabase[i].length; j++) {
					updatedDatabase[i][j] = pDatabase[i][j];
				}
			}
		}

		if (!found) {
			System.out.println("Person does not exist or wrong ID!");
		} else {
			System.out.println("Updated personDatabase:");
			for (String[] row : updatedDatabase) {
				if (row[0] != null) {
					System.out.println(Arrays.toString(row));
				}
			}
		}
		return updatedDatabase;
	}

	/**
	 * Deletes a person with the provided ID from the database and returns the
	 * updated database.
	 *
	 * @param pDatabase The 2D array representing the database of persons.
	 * @param input     The Scanner object used to take user input.
	 * @return The updated 2D array representing the database after the person has
	 *         been deleted.
	 */
	private static String[][] deletePerson(String[][] pDatabase, Scanner input) {

		String id = input.nextLine();
		boolean found = false;
		String[] currentPerson = null;
		String[][] updatedDatabase = new String[pDatabase.length][pDatabase[0].length];
		int updatedIndex = 0;
		
		// Iterate through the records in the database
		for (int i = 0; i < pDatabase.length; i++) {
			
			// Check if the current record matches the provided ID
			if (pDatabase[i][0].equals(id)) {
				found = true;
				currentPerson = pDatabase[i];
				System.out.println("Person found and deleted!");
				break; // Exit the loop after finding the person
			} else {
				// Copy the current record to the updatedDatabase (excluding the person to be deleted)
				for (int j = 0; j < pDatabase[i].length; j++) {
					updatedDatabase[updatedIndex][j] = pDatabase[i][j];
				}
				updatedIndex++;
			}
		}
		
		// Check if the person was found or not
		if (!found) {
			System.out.println("Person does not exist or wrong ID!");
		} else {
			// Trim the updatedDatabase to remove empty rows at the end (if any)
			updatedDatabase = new String[updatedIndex][pDatabase[0].length];
			for (int i = 0; i < updatedIndex; i++) {
				for (int j = 0; j < pDatabase[i].length; j++) {
					updatedDatabase[i][j] = pDatabase[i][j];
				}
			}
			System.out.println("Database updated after deletion.");
			printArr(currentPerson); // Print the deleted person's details
		}
		return updatedDatabase;
	}

	/**
	 * Prints the information of a single person from the database.
	 *
	 * @param currentPerson An array containing the information of a single person.
	 */
	private static void printArr(String[] currentPerson) {
		for (int i = 0; i < currentPerson.length; i++) {
			String string = currentPerson[i];
			System.out.print(string + " ");
		}
		System.out.println();

	}

	/**
	 * Prints the information of a single person from the database.
	 *
	 * @param currentPerson An array containing the information of a single person.
	 */
	private static void findPerson(String[][] pDatabase, Scanner input) {

		String id = input.nextLine();
		String[][] remainingData = pDatabase;
		String[] personInfo = null;

		for (String[] row : remainingData) {
			if (row[0].equals(id)) {
				// Remove the row number and ID brackets from the line to display only the
				// person's information.
				personInfo = row;
				break; // Break the loop once the person is found.
			}
		}

		if (personInfo != null) {
			System.out.println("Person found:");
			for (int i = 0; i < personInfo.length; i++) {
				System.out.print(personInfo[i]);
				if (i < personInfo.length - 1) {
					System.out.print(", ");
				}
			}
			System.out.println();
		} else {
			System.out.println("Person does not exist or wrong ID!");
		}
	}

	/**
	 * Retrieves the last ID number from the given database.
	 *
	 * @param pDatabase The database containing information about multiple persons.
	 * @return The last ID number found in the database.
	 */
	private static String getLastIdNumber(String[][] pDatabase) {
		String lastId = "23032001"; // Start with a default value

		for (String[] row : pDatabase) {
			if (row[1] != null && !row[1].isEmpty()) {
				// Assuming the ID is stored in the second element (index 1) of each row
				String currentId = row[0];
				if (currentId.compareTo(lastId) > 0) {
					lastId = currentId;
				}
			}
		}

		return lastId;
	}

	/**
	 * Counts the number of persons in the given database.
	 *
	 * @param pDatabase The database containing information about multiple persons.
	 * @return The number of persons present in the database.
	 */
	private static int countPersons(String[][] pDatabase) {
		int count = 0;
		for (String[] row : pDatabase) {
			if (row[0] != null && !row[0].isEmpty()) {
				count++;
			}
		}
		return count;
	}

	/**
	 * Bulk creates multiple persons and adds them to the database in batches.
	 *
	 * @param pDatabase The database to which the new persons will be added.
	 * @param input     The Scanner object to read user input.
	 */
	private static void bulkCreatePersons(String[][] pDatabase, Scanner input) {
		System.out.println("How many persons do you want to create?");
		int totalPersons = Integer.parseInt(input.nextLine());
		int batchCount = (totalPersons / 20) + (totalPersons % 20 == 0 ? 0 : 1);
		
		// Batch processing loop to create persons and add them to the database
		for (int batch = 1; batch <= batchCount; batch++) {
			// Determine the number of persons to create in the current batch
			int personsInBatch = Math.min(totalPersons, 20);
			
			// Update the remaining total persons count
			totalPersons -= personsInBatch;
			
			// Create persons and add them to the database for the current batch
			for (int i = 0; i < personsInBatch; i++) {
				System.out.println("Creating person #" + (i + 1));
				String[] newPerson = autoCreatePerson(pDatabase, input); // Assuming you have a method for creating a
																			// new person
				pDatabase = addPersonToDatabase(pDatabase, newPerson); // Assuming you have the
																		// addPersonToDatabase method
				System.out.println("Person #" + (i + 1) + " created successfully!");
			}
			
			// Display batch information
			System.out.println("Batch #" + batch + " created with " + personsInBatch + " persons = ["
					+ (batch * personsInBatch) + "]");
		}
	}

	/**
	 * Clears all the existing person data from the database by creating a new empty
	 * database.
	 *
	 * @param pDatabase      The database to be cleared.
	 * @param input          The Scanner object to read user input (not used in this
	 *                       method).
	 * @param rows           The maximum number of rows in the new database.
	 * @param colsInDatabase
	 * @return A new empty database with the same dimensions as the original.
	 */
	private static String[][] clearPersons(String[][] pDatabase, Scanner input, int rows, int colsInDatabase) {

		return new String[rows][colsInDatabase];
	}

}
