package module04.oop.main;

import java.util.Random;
import java.util.Scanner;

import module04.oop.models.Person;

public class PersonManager {
	static Scanner inpt=new Scanner(System.in);
	public static void main(String[] args) {
		int max = (int) (Math.random() * (5000 - 100) + 100);
		StackOfPersons stack = new StackOfPersons(max);
		bulkStackPersons(stack, max, "preLoad");
		while (true) {
			System.out.println("Max size of stack = " + stack.getCapacity());
			int personCount = stack.getPersonCount();
			System.out.println("Total number of persons: " + personCount);
			System.out.println("\n==== Person Manager ====");
			System.out.println("1. Add a person");
			System.out.println("2. Display all persons");
			System.out.println("3. Update a person");
			System.out.println("4. Delete a person");
			System.out.println("5. Search for a person by ID");
			System.out.println("6. Bulk");
			System.out.println("7. Count");
			System.out.println("8. Clear");
			System.out.println("9. Exit");
			System.out.print("Enter your choice: ");
			String choiceString = inpt.nextLine();
			int choice = Integer.parseInt(choiceString.charAt(0) + "");

			switch (choice) {
			case 1:

				Person newPerson = new Person();
				stack.push(newPerson);

				System.out.println("ADD=" + stack.peek() + "\nPerson added successfully.");

				break;

			case 2:
				System.out.println("All persons in stack:");
				stack.printAllPersons();
				break;

			case 3:
				if (stack.getPersonCount() > 1) {
					System.out.print("Enter ID of person to update: ");
					String updateIdString = inpt.nextLine();
					long updateId = Long.parseLong(updateIdString);

					Person foundPerson = stack.searchPersonById(updateId);
					if (foundPerson != null) {
						Person updatedPerson = updateMenu(foundPerson);
						stack.updatePerson(foundPerson, updatedPerson);
						System.out.println("Person updated successfully.");
					} else {
						System.out.println("Person with ID " + updateId + " not found.");
					}
				} else {
					System.out.println("No persons in the stack");
				}
				break;

			case 4:
				if (stack.getPersonCount() > 1) {
					System.out.print("Enter ID of person to delete: ");
					String deleteIdString = inpt.nextLine();
					long deleteId = Long.parseLong(deleteIdString);

					Person personToDelete = stack.searchPersonById(deleteId);
					if (personToDelete != null) {
						stack.deletePerson(personToDelete);
						System.out.println(personToDelete + "\nPerson deleted successfully.");
					if(stack.getPersonCount()<1)stack=new StackOfPersons();
					} else {
						System.out.println("Person with ID " + deleteId + " not found.");
					}
				} else {
					System.out.println("No persons in the stack");
				}
				break;

			case 5:
				if (stack.getPersonCount() > 1) {
					System.out.print("Enter ID of person to search: ");
					String searchIdString = inpt.nextLine();
					long searchId = Long.parseLong(searchIdString);

					Person searchedPerson = stack.searchPersonById(searchId);
					if (searchedPerson != null) {
						searchedPerson.display();
					} else {
						System.out.println("Person with ID " + searchId + " not found.");
					}
				} else {
					System.out.println("No persons in the stack");
				}
				break;

			case 6:

				stack = bulkStackPersons(stack, max);
				break;
			case 7:
				personCount = stack.getPersonCount();
				System.out.println("Total number of persons: " + personCount);
				break;
			case 8:

				System.out.println("Clearing...");
				stack.clear();
				break;
			case 9:

				System.out.println("Exiting...");
				System.exit(0);
				break;

			default:
				System.out.println("Invalid choice. Please enter a valid option.");
				break;
			}
		}
	}

	private static void bulkStackPersons(StackOfPersons stack, int max, String pre) {

		int num = new Random().nextInt(25, max);

		for (int i = 0; i < num; i++) {

			Person newPerson1 = new Person();
			stack.push(newPerson1);

		}
	}

	private static StackOfPersons bulkStackPersons(StackOfPersons stk, int max) {
		System.out.println("How many");
		int num = Integer.parseInt(inpt.nextLine());
		num = num < max ? num : max;
		for (int i = 0; i < num; i++) {

			Person newPerson1 = new Person();
			stk.push(newPerson1);

		}
		return stk;
	}

	private static Person updateMenu(Person foundPerson) {

		System.out.println("1 - Change Name");
		System.out.println("2 - Change Location");
		System.out.println("3 - Change Contact");
		System.out.println("4 - Change Funds");
		System.out.println("Enter (1-4)");
		int input = Integer.parseInt(inpt.nextLine());
		switch (input) {
		case 1:
			System.out.println("Old data " + foundPerson.getName());
			foundPerson = updateName(foundPerson);
			break;
		case 2:
			System.out.println("Old data " + foundPerson.getLocation());
			foundPerson = updateLocation(foundPerson);
			break;
		case 3:
			System.out.println("Old data " + foundPerson.getContact());
			foundPerson = updatePhone(foundPerson);
			break;
		case 4:
			System.out.println("Old data " + foundPerson.getFunds());
			foundPerson = updateSalary(foundPerson);
			break;
		default:
			System.out.println("Error in switch...");
		}
		return foundPerson;
	}

	private static Person updateName(Person foundPerson) {

		System.out.println("Enter new First Name");
		Person p = foundPerson;
		String fname = inpt.nextLine();
		p.getName().setFname(fname);
		System.out.println("Enter new Last Name");
		String lname = inpt.nextLine();
		p.getName().setLname(lname);

		System.out.println("New Values=" + p.getName());
		System.out.println(p.toString());

		return p;
	}

	private static Person updateLocation(Person foundPerson) {

		System.out.println("Enter new Street No.");
		Person p1 = foundPerson;
		String streetNo = inpt.nextLine();
		p1.getLocation().setStreetNo(Short.parseShort(streetNo));

		System.out.println("Enter new Street Name");
		String streetName = inpt.nextLine();
		p1.getLocation().setStreetName(streetName);

		System.out.println("Enter new City");
		String city = inpt.nextLine();
		p1.getLocation().setCity(city);

		System.out.println("Enter new State");
		String state = inpt.nextLine();
		p1.getLocation().setState(state);

		System.out.println("Enter new Zip");
		String zip = inpt.nextLine();
		p1.getLocation().setZip(Integer.parseInt(zip));

		System.out.println("New Values=" + p1.getLocation());
		System.out.println(p1.toString());

		return p1;
	}

	private static Person updatePhone(Person foundPerson) {
		System.out.println("Enter new Phone No.");
		Person p2 = foundPerson;
		String phone = inpt.nextLine();
		p2.getContact().setPhone(Long.parseLong(phone));

		System.out.println("New Values=" + p2.getContact());
		System.out.println(p2.toString());
		return p2;
	}

	private static Person updateSalary(Person foundPerson) {
		System.out.println("Enter new Salary");
		Person p3 = foundPerson;
		String salary = inpt.nextLine();
		p3.getFunds().setSalary(Float.parseFloat(salary));

		System.out.println("New Values=" + p3.getFunds());
		System.out.println(p3.toString());
		return p3;
	}
}
