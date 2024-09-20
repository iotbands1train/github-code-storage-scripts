package module02.objectclassestopics;

import java.util.Scanner;

public class Main {
	/**
	 * The main method of the Person Management System.
	 *
	 * @param args The command line arguments passed to the program (not used in
	 *             this application).
	 */

	public static void main(String[] args) {
		System.out.println("  =============================================== ");
	    System.out.println("            Person Management System              ");
	    System.out.println("  =============================================== ");
	    System.out.println(" Welcome to Person Management System (PMS)! ");
	    System.out.println();
		System.out.println(" This Program objectives are to manage, store, and");
		System.out.println(" create various user\'s records of personal");
		System.out.println(" information.");
		System.out.println();
		
        // Create an instance of PersonArray
        PersonArray personArray = new PersonArray();
        
        Scanner input = new Scanner(System.in);
        
        System.out.println("1---------------------------------");       // Scenario 1: Add random persons to the array
        System.out.println("Scenario 1: Enter the number of random person to create: ");
        int randomPersons = Integer.parseInt(input.nextLine()); // Enter a Random Number.
        personArray.createBulkRandomPersons(randomPersons);
        
        System.out.println("2---------------------------------"); // Scenario 2: Display all persons
        System.out.println("Scenario 2: All Random Persons Created:");
        personArray.displayAllPersons();

        System.out.println("3---------------------------------"); // Scenario 3: Update a person
        System.out.println("Enter the id number for the person to update: ");		
		int idToUpdate = Integer.parseInt(input.nextLine()); // Replace with a valid person's ID
        
        Person updatedPerson = new Person(idToUpdate, "UpdatedFirstName", "UpdatedLastName", 999, "UpdatedStreet", "UpdatedCity", "UpdatedState", 54321, 987654321, 50000.0f, null, false, "UpdatedPassword");
        personArray.updatePerson(idToUpdate, updatedPerson);
        System.out.println("\nScenario 3: All Persons After Update:");
        personArray.displayAllPersons();

        System.out.println("4---------------------------------"); // Scenario 4: Delete a person
        System.out.println("Enter the id number for the person to Delete: ");
        int idToDelete = Integer.parseInt(input.nextLine()); // Replace with a valid person's ID
        personArray.deletePerson(idToDelete);
        System.out.println("\nScenario 4: All Persons After Delete:");
        personArray.displayAllPersons();

        // Scenario 5: Add more random persons
        System.out.println("5---------------------------------");
        System.out.println("Enter number of more random persons to create: ");
        int morePersons = Integer.parseInt(input.nextLine()); // Enter a Random Number.
        personArray.createBulkRandomPersons(morePersons);
        System.out.println("\nScenario 5: All Persons After Adding More:");
        personArray.displayAllPersons();
        
        System.out.println("Thank you. Byeee!!!");
        System.out.println("System Under Development");

    }
}
