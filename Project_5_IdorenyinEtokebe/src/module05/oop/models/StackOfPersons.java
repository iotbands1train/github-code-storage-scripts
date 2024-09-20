package module05.oop.models;

/**
 * The StackOfPersons class represents a stack data structure for storing Person
 * objects.
 */
public class StackOfPersons {
	// Array to store Person objects.
	private Person[] stack;
	// Index of the top element in the stack.
	private int top;
	// The maximum capacity of the stack.
	private int capacity;

	/**
	 * Constructs a StackOfPersons with a default capacity of 500.
	 */
	public StackOfPersons() {
		this.stack = new Person[500]; // Assuming a maximum of 500 persons
		capacity = stack.length;
		top = -1;
	}
	/**
	 * Constructs a StackOfPersons with the specified capacity.
	 *
	 * @param capacity The maximum number of persons the stack can hold.
	 */
	public StackOfPersons(int capacity) {
		stack = new Person[capacity]; // Assuming a maximum of x persons
		this.capacity = capacity;
		top = -1;
	}
	/**
	 * Constructs a StackOfPersons with an array of Person objects.
	 *
	 * @param stack The initial array of Person objects.
	 */
	public StackOfPersons(Person[] stack) {
		this.stack = stack;
		top = stack.length - 1;
		capacity = stack.length;
	}
	/**
	 * Gets the current count of persons in the stack.
	 *
	 * @return The number of persons in the stack.
	 */
	public int getPersonCount() {
		return top + 1;
	}
	/**
	 * Gets the capacity of the stack.
	 *
	 * @return The maximum number of persons the stack can hold.
	 */
	public int getCapacity() {
		return capacity;
	}
	/**
	 * Pushes a Person object onto the stack.
	 *
	 * @param person The Person object to push onto the stack.
	 */
	public void push(Person person) {
		if (top < stack.length - 1) {
			top++;
			stack[top] = person;
		} else {
			System.out.println("Stack is full. Cannot push more persons.");
		}
	}
	/**
	 * Pops and returns the top Person object from the stack.
	 *
	 * @return The top Person object, or null if the stack is empty.
	 */
	public Person pop() {
		if (top >= 0) {
			Person person = stack[top];
			stack[top] = null;
			top--;
			return person;
		} else {
			System.out.println("Stack is empty. Cannot pop.");
			return null;
		}
	}
	/**
	 * Returns the top Person object from the stack without removing it.
	 *
	 * @return The top Person object, or null if the stack is empty.
	 */
	public Person peek() {
		if (top >= 0) {
			return stack[top];
		} else {
			System.out.println("Stack is empty. Cannot peek.");
			return null;
		}
	}
	/**
	 * Prints all persons in the stack.
	 */
	public void printAllPersons() {
		for (int i = 0; i <= top; i++) {
			System.out.println(i + " " + stack[i]);
		}
	}
	/**
	 * Updates an old Person object with a new Person object in the stack.
	 *
	 * @param oldPerson The old Person object to be replaced.
	 * @param newPerson The new Person object to replace the old one.
	 */
	public void updatePerson(Person oldPerson, Person newPerson) {
		for (int i = 0; i <= top; i++) {
			if (stack[i] == oldPerson) {
				stack[i] = newPerson;
				break;
			}
		}
	}
	/**
	 * Deletes a specific Person object from the stack.
	 *
	 * @param person The Person object to be deleted.
	 */
	public void deletePerson(Person person) {
		for (int i = 0; i <= top; i++) {
			if (stack[i] == person) {
				for (int j = i; j < top; j++) {
					stack[j] = stack[j + 1];
				}
				stack[top] = null;
				top--;
				break;
			}
		}
	}
	/**
	 * Adds an array of Person objects to the stack.
	 *
	 * @param persons The array of Person objects to be added.
	 */
	public void createBulkPersons(Person[] persons) {
		for (Person person : persons) {
			push(person);
		}
	}
	/**
	 * Searches for a Person object by its ID in the stack.
	 *
	 * @param searchId The ID to search for.
	 * @return The found Person object, or null if not found.
	 */
	public Person searchPersonById(long searchId) {
		if (top > 1) {
			for (int i = 0; i <= top; i++) {
				if (stack[i].getId() == searchId) {
					return stack[i];
				}
			}
		} else {
			System.out.println("Only 1 person in the database.");
		}
		return null;
	}
	/**
	 * Sets the capacity of the stack.
	 *
	 * @param input The new capacity to set.
	 */
	public void setCapacity(int input) {
		capacity = input;
	}
	/**
	 * Clears the stack by creating a new array of Persons.
	 */
	public void clear() {
		stack = new Person[capacity];
		top = 0;
	}
}
