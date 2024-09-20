// Import necessary packages
package chapter12.formuserinput;

import java.util.ArrayList;
import java.util.Scanner;

import chapter12.models.Person;
import chapter12.randomData.RandomPerson;

/**
 * This class handles user input for various 
 * form fields related to person data.
 */
public class FormFields {
	// 12.11.3: Reading Data using Scanner.
	// 12.4: Declaring, Throwing, and Catching Exceptions.
	
	/**
	 * Gets user input for the phone field.
	 */
	public static String phoneForm(Scanner in) {
		// Generate random person data for demonstration
		ArrayList<Person> r = RandomPerson.randomPersonList(10);
		String x = r.get(0).getPhone();
		System.out.println("Enter your phone {" + x + "} : ");
		String phone = in.nextLine();
		// Use default if input is empty
		phone = phone.equals("") ? x : phone; 
		// Apply formatting/validation
		phone = FormBox.phoneFieldBox(phone, in); 
		return phone;
	}
	/**
	 * Gets user input for the zip code field.
	 */
	public static String zipForm(Scanner in) {
		// Generate random person data for demonstration
		ArrayList<Person> r = RandomPerson.randomPersonList(10);
		String x = r.get(0).getZip();
		System.out.println("Enter your zip {" + x + "} : ");
		String zip = in.nextLine();
		 // Use default if input is empty
		zip = zip.equals("") ? x : zip;
		 // Apply formatting/validation
		zip = FormBox.zipFieldBox(zip, in);
		return zip;
	}
	/**
	 * Gets user input for the state field.
	 */
	public static String stateForm(Scanner in) {
		// Generate random person data for demonstration
		ArrayList<Person> r = RandomPerson.randomPersonList(10);
		String x = r.get(0).getState();
		System.out.println("Enter your state {" + x + "} : ");
		String state = in.nextLine();
		// Use default if input is empty
		state = state.equals("") ? x : state; 
		// Apply formatting/validation
		state = FormBox.stateFieldBox(state, in); 
		return state;
	}
	/**
	 * Gets user input for the city field.
	 */
	public static String cityForm(Scanner in) {
		// Generate random person data for demonstration
		ArrayList<Person> r = RandomPerson.randomPersonList(10);
		String x = r.get(0).getCity();
		System.out.println("Enter your city {" + x + "} : ");
		String city = in.nextLine();
		// Use default if input is empty
		city = city.equals("") ? x : city; 
		 // Apply formatting/validation
		city = FormBox.cityFieldBox(city, in);
		return city;
	}
	/**
	 * Gets user input for the street field.
	 */
	public static String streetForm(Scanner in) {
		// Generate random person data for demonstration
		ArrayList<Person> r = RandomPerson.randomPersonList(10);
		String x = r.get(0).getStreet();
		System.out.println("Enter your street {" + x + "} : ");
		String street = in.nextLine();
		// Use default if input is empty
		street = street.equals("") ? x : street; 
		// Apply formatting/validation
		street = FormBox.streetFieldBox(street, in); 
		return street;
	}
	/**
	 * Gets user input for the last name field.
	 */
	public static String lnameForm(Scanner in) {
		// Generate random person data for demonstration
		ArrayList<Person> r = RandomPerson.randomPersonList(10);
		String x = r.get(0).getLname();
		System.out.println("Enter your last name {" + x + "} : ");
		String lname = in.nextLine();
		// Use default if input is empty
		lname = lname.equals("") ? x : lname; 
		// Apply formatting/validation
		lname = FormBox.lnameFieldBox(lname, in); 
		return lname;
	}
	/**
	 * Gets user input for the first name field.
	 */
	public static String fnameForm(Scanner in) {
		// Generate random person data for demonstration
		ArrayList<Person> r = RandomPerson.randomPersonList(10);
		String x = r.get(0).getFname();
		System.out.println("Enter your first name {" + x + "} : ");
		String fname = in.nextLine();
		// Use default if input is empty
		fname = fname.equals("") ? x : fname;
		// Apply formatting/validation
		fname = FormBox.fnameFieldBox(fname, in);
		return fname;
	}
}