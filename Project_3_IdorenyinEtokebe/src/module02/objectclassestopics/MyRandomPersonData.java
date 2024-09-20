package module02.objectclassestopics;

import java.util.Date;
import java.util.Random;

/**
 * The MyRandomPersonDataclass provides random data generation methods for
 * creating Person objects. It includes methods to generate random IDs, names,
 * addresses, contact information, salary, and other attributes with a focus on
 * randomness and diversity in data.
 */
public class MyRandomPersonData {
    private static final String[] FIRST_NAMES =  { "Sue", "Sara", "Toni", "Tyson", "Hannah", "Montana", "Vicky", "Becky", "Monica", "Henry",
			"James", "Jason", "Emma", "Olivia", "Noah", "Liam", "Ava", "Isabella", "Sophia", "Mia" };
    
    private static final String[] LAST_NAMES = { "Willis", "Ramos", "Wei", "Wu", "Smits", "Dickinson", "Johns", "Johnson", "Gomez", "Tyler",
			"Nguyen", "Garcia", "Lee", "Martinez", "Brown", "Kim", "Rodriguez", "Chen", "Lopez", "Davis" };
    
    private static final String[] STREET_NAMES = { "Main St.", "Wall Rd.", "West Ln.", "Fannin Rd.", "Westwood Ln.", "Apple St.", "Berry Ln.",
			"Maple Ave.", "Cedar Dr.", "Oak St.", "Pine Rd.", "Elm Ln.", "Birch Way", "Cherry Ct.", "Hickory Rd." };
    
    private static final String[] CITIES = { "Austin", "NYC", "SF", "Miami", "Ball City", "Hamford", "Turtleville", "Appleton", "Chicago",
			"Los Angeles", "Seattle", "London", "Paris", "Tokyo", "Sydney", "Toronto", "Berlin", "Moscow" };
    
    private static final String[] STATES = { "CA", "WY", "RI", "HI", "CO", "TX", "NY", "FL", "IL", "PA", "OH", "MI", "WA", "OR", "GA",
			"AZ", "NC", "VA", "MA", "WI", "MN" };
    
    private static final String[] PASSWORDS = {"password123", "secret", "123456", "qwerty", "letmein"};

    /**
     * Generates a random ID for a  Person object.
     *
     * @return A random integer ID.
     */
    public static int generateRandomId() {
        Random rand = new Random();
        return rand.nextInt(Integer.MAX_VALUE);
    }

    /**
     * Generates a random first name for a Person object.
     *
     * @return A random first name from the predefined list.
     */
    public static String generateRandomFirstName() {
        Random rand = new Random();
        int index = rand.nextInt(FIRST_NAMES.length);
        return FIRST_NAMES[index];
    }

    /**
     * Generates a random last name for a Person object.
     *
     * @return A random last name from the predefined list.
     */
    public static String generateRandomLastName() {
        Random rand = new Random();
        int index = rand.nextInt(LAST_NAMES.length);
        return LAST_NAMES[index];
    }

    /**
     * Generates a random street number for a Person object's address.
     *
     * @return A random street number between 1 and 1000.
     */
    public static int generateRandomStreetNumber() {
        Random rand = new Random();
        return rand.nextInt(1000) + 1;
    }

    /**
     * Generates a random street name for a  Person object's address.
     *
     * @return A random street name from the predefined list.
     */
    public static String generateRandomStreetName() {
        Random rand = new Random();
        int index = rand.nextInt(STREET_NAMES.length);
        return STREET_NAMES[index];
    }

    /**
     * Generates a random city name for a Person object's address.
     *
     * @return A random city name from the predefined list.
     */
    public static String generateRandomCity() {
        Random rand = new Random();
        int index = rand.nextInt(CITIES.length);
        return CITIES[index];
    }

    /**
     * Generates a random state abbreviation for a Person object's address.
     *
     * @return A random state abbreviation from the predefined list.
     */
    public static String generateRandomState() {
        Random rand = new Random();
        int index = rand.nextInt(STATES.length);
        return STATES[index];
    }

    /**
     * Generates a random ZIP code for a  Person object's address.
     *
     * @return A random ZIP code between 10000 and 99999.
     */
    public static int generateRandomZip() {
        Random rand = new Random();
        return rand.nextInt(99999) + 10000;
    }

    /**
     * Generates a random phone number for a  Person object's contact information.
     *
     * @return A random 10-digit phone number.
     */
    public static int generateRandomPhoneNumber() {
        Random rand = new Random();
        return rand.nextInt(999999999) + 1000000000;
    }

    /**
     * Generates a random salary for a Person object.
     *
     * @return A random salary.
     */
    public static float generateRandomSalary() {
        Random rand = new Random();
        return rand.nextFloat() * 10000 + 30000;
    }

    /**
     * Generates a random creation date for a  Person object.
     *
     * @return A random creation date within a range.
     */
    public static Date generateRandomCreationDate() {
        Random rand = new Random();
        long randomMillis = Math.abs(rand.nextLong() % (System.currentTimeMillis() + 1));
        return new Date(randomMillis);
    }

    /**
     * Generates a random membership status for a  Person object.
     *
     * @return true or false representing membership status.
     */
    public static boolean generateRandomIsMember() {
        Random rand = new Random();
        return rand.nextBoolean();
    }

    /**
     * Generates a random password for a Person object.
     *
     * @return A random password from the predefined list.
     */
    public static String generateRandomPassword() {
        Random rand = new Random();
        int index = rand.nextInt(PASSWORDS.length);
        return PASSWORDS[index];
    }
}
