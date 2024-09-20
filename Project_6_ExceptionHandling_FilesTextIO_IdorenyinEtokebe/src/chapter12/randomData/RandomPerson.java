package chapter12.randomData;

import java.util.ArrayList;
import java.util.Random;

import chapter12.models.Person;

/**
 * Generates a list of random persons.
 * @param next20 The number of persons to generate.
 * @return An ArrayList containing the generated persons.
 */
public class RandomPerson {
    /**
     * Generates a list of random persons.
     * @param next20 The number of persons to generate.
     * @return An ArrayList containing the generated persons.
     */
	public static ArrayList<Person> getRandPerson(int next20) {
		ArrayList<Person> people = new ArrayList<>();
		for (int i = 0; i < next20; i++) {
			Person person = randomPerson();
			people.add(person);
		}
		return people;
	}

    /**
     * Generates a single random person.
     * @return A randomly generated Person object.
     */
	public static Person randomPerson() {
		Long id = new Random().nextLong(333388821, 339988821);
		String fname = randomFirst();
		String lname = randomLast();
		String street = randomStret();
		String city = randomCity();
		String state = "Tx";
		String zip = "77" + new Random().nextInt(199, 998) + "";
		String phone = new Random().nextInt(199, 998) + "-" + new Random().nextInt(199, 998) + "-"
				+ new Random().nextInt(1991, 9989);
		Person person = new Person(id, fname, lname, street, city, state, zip, phone);
		return person;
	}
    // Methods to generate random values for different attributes
	private static String randomFirst() {
		String[] n = { "Sue", "Mike", "Nick", "Julie", "Janice", "Josh", "Fred" };
		return n[new Random().nextInt(0, n.length)];
	}

	private static String randomLast() {
		String[] n = { "William", "Stone", "Yale", "Brown", "Gomez", "Reyes", "Zho" };
		return n[new Random().nextInt(0, n.length)];
	}

	private static String randomStret() {
		String[] n = { "Main St.", "Wall Blvd.", "West Ln.", "Dulles Rd.", "Griggs Rd.", "Lone St.", "2nd St." };
		return new Random().nextInt(1254, 9562) + " " + n[new Random().nextInt(0, n.length)];
	}

	private static String randomCity() {
		String[] n = { "Houston", "SugaLand", "Bellaire", "West U", "SoHo", "Kemah", "Conroe" };
		return n[new Random().nextInt(0, n.length)];
	}

    /**
     * Generates a list of random persons.
     * @param x The number of persons to generate.
     * @return An ArrayList containing the generated persons.
     */
	public static ArrayList<Person> randomPersonList(int x) {
		ArrayList<Person> l = new ArrayList<>();
		for (int i = 0; i < x; i++) {
			l.add(randomPerson());
		}
		return l;
	}
}