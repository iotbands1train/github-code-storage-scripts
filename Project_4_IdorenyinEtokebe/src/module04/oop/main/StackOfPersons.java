package module04.oop.main;

import java.util.ArrayList;

import module04.oop.models.Person;

public class StackOfPersons {
	private Person[] stack;
	private int top;
	private int capacity;

	public StackOfPersons() {
		this.stack = new Person[500]; // Assuming a maximum of 500 persons
		capacity = stack.length;
		top = -1;
	}

	public StackOfPersons(int capacity) {
		stack = new Person[capacity]; // Assuming a maximum of x persons
		this.capacity = capacity;
		top = -1;
	}
	public StackOfPersons(Person[] stack) {
		this.stack = stack; 
		top=stack.length-1;
		capacity=stack.length;
	}
	public int getPersonCount() {
		return top + 1;
	}

	public int getCapacity() {
		return capacity;
	}

	public void push(Person person) {
		if (top < stack.length - 1) {
			top++;
			stack[top] = person;
		} else {
			System.out.println("Stack is full. Cannot push more persons.");
		}
	}

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

	public Person peek() {
		if (top >= 0) {
			return stack[top];
		} else {
			System.out.println("Stack is empty. Cannot peek.");
			return null;
		}
	}

	public void printAllPersons() {
		for (int i = 0; i <= top; i++) {
			System.out.println(i+" "+stack[i]);
		}
	}

	public void updatePerson(Person oldPerson, Person newPerson) {
		for (int i = 0; i <= top; i++) {
			if (stack[i] == oldPerson) {
				stack[i] = newPerson;
				break;
			}
		}
	}

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

	public void createBulkPersons(Person[] persons) {
		for (Person person : persons) {
			push(person);
		}
	}

	public Person searchPersonById(long searchId) {
		if(top>1) {
		for (int i = 0; i <= top; i++) {
			if (stack[i].getId() == searchId) {
				return stack[i];
			}
		}}else {
			System.out.println("Only 1 person in database");
		}
		return null;
	}
	
	public ArrayList<Person> searchPersonsByName(String searchName) {
	    ArrayList<Person> foundPersons = new ArrayList<>();

	    for (int i = 0; i <= top; i++) {
	        if (stack[i].getName().getFname().equals(searchName)) {
	            foundPersons.add(stack[i]);
	        }
	    }

	    if (foundPersons.isEmpty()) {
	        System.out.println("No persons with name " + searchName + " found.");
	    }

	    return foundPersons;
	}
	
	public void SortAlphabetically() {
	    for (int i = 0; i <= top; i++) {
	        for (int j = i + 1; j <= top; j++) {
	            if (stack[i].getName().getFname().compareTo(stack[j].getName().getFname()) > 0) {
	                // Swap persons
	                Person temp = stack[i];
	                stack[i] = stack[j];
	                stack[j] = temp;
	            }
	        }
	    }
	}




	public void setCapacity(int input) {
		capacity=input;
	}

	public void clear() {
		stack=new Person[capacity];
		top=0;
	}
 

}
