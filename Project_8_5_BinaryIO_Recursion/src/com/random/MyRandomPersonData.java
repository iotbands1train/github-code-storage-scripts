package com.random;

import java.util.Random;

import com.model.Person;
 


/**
 * This class provides utility methods to generate random person data.
 */
public class MyRandomPersonData {


    /**
     * Generates a random float within the specified range.
     *
     * @param min Minimum value (inclusive) of the range.
     * @param max Maximum value (exclusive) of the range.
     * @return Random float value within the specified range.
     */
	public static long random(long min, long max) {
		return Math.abs(new java.util.Random().nextLong(min, max));
	}


    /**
     * Generates a random float within the specified range.
     *
     * @param min Minimum value (inclusive) of the range.
     * @param max Maximum value (exclusive) of the range.
     * @return Random float value within the specified range.
     */
	public static float random(double min, double max) { 
		return Float.parseFloat(String.format("%.2f", Math.
				abs(new java.util.Random().nextDouble(min, max))));
	}
	/**
     * Generates a random first name from a predefined array.
     *
     * @return Random first name.
     */
	public static String randomFname() {
		String[] FIRST_NAMES = { "Emma", "Liam", "Olivia", "Noah", "Ava", "Isabella", "Sophia", "Mia", "Charlotte",
				"Amelia", "Harper", "Evelyn", "Abigail", "Emily", "Elizabeth", "Sofia", "Avery", "Ella", "Scarlett",
				"Grace", "Victoria", "Riley", "Aria", "Lily", "Aubrey", "Zoey", "Penelope", "Hannah", "Layla", "Nora",
				"Lily", "Lillian", "Addison", "Eleanor", "Natalie", "Ellie", "Leah", "Aubrey", "Hazel", "Violet",
				"Aurora", "Savannah", "Audrey", "Brooklyn", "Bella", "Claire", "Skylar", "Lucy", "Paisley", "Everly" }; 
		return randomElementFromStringArray(FIRST_NAMES);
	}

    /**
     * Generates a random last name from a predefined array.
     *
     * @return Random last name.
     */
	public static String randomLname() {
		String[] LAST_NAMES = { "Smith", "Johnson", "Brown", "Taylor", "Miller", "Jones", "Garcia", "Davis",
				"Rodriguez", "Martinez", "Hernandez", "Lopez", "Gonzalez", "Wilson", "Anderson", "Thomas", "Taylor",
				"Moore", "Jackson", "Martin" }; 
		return randomElementFromStringArray(LAST_NAMES);
	}


    /**
     * Generates a random state from a predefined array.
     *
     * @return Random state name.
     */
	public static String randomStreet() {
		String[] STREET_TYPES = { "St.", "Ave.", "Rd.", "Ln.", "Dr.", "Ct.", "Pl.", "Cir.", "Blvd.", "Way" };
		String[] STREET_NAMES = { "Maple", "Oak", "Cedar", "Pine", "Elm", "Birch", "Willow", "Hickory", "Ash", "Poplar",
				"Cherry", "Spruce", "Sycamore", "Cypress", "Alder", "Dogwood", "Juniper", "Magnolia", "Redwood", "Fir" }; 
		return randomElementFromStringArray(STREET_NAMES) + " " + randomElementFromStringArray(STREET_TYPES);
	}


    /**
     * Generates a random city from a predefined array.
     *
     * @return Random city name.
     */
	public static String randomCity() {
		String[] CITIES = { "New York", "Los Angeles", "Chicago", "Houston", "Phoenix", "Philadelphia", "San Antonio",
				"San Diego", "Dallas", "San Jose", "Austin", "Jacksonville", "San Francisco", "Columbus",
				"Indianapolis", "Fort Worth", "Charlotte", "Seattle", "Denver", "Washington" }; 
		return randomElementFromStringArray(CITIES);
	}


    /**
     * Generates a random state from a predefined array.
     *
     * @return Random state name.
     */
	public static String randomState() {
		String[] STATES = { "Alabama", "Alaska", "Arizona", "Arkansas", "California", "Colorado", "Connecticut",
				"Delaware", "Florida", "Georgia", "Hawaii", "Idaho", "Illinois", "Indiana", "Iowa", "Kansas",
				"Kentucky", "Louisiana", "Maine", "Maryland", "Massachusetts", "Michigan", "Minnesota", "Mississippi",
				"Missouri", "Montana", "Nebraska", "Nevada", "New Hampshire", "New Jersey" }; 
		return randomElementFromStringArray(STATES);
	}
	 /**
     * Generates an array of random Person objects.
     *
     * @param size The size of the array.
     * @return Array of randomly generated Person objects.
     */
	public static String randomTitle() {
		String[] titles = { "Dr.", "Mr/Mrs"  }; 
		return randomElementFromStringArray(titles);
	}
	 /**
     * Generates an array of random Person objects.
     *
     * @param size The size of the array.
     * @return Array of randomly generated Person objects.
     */
	public static String randomElementFromStringArray(String[] arr) {
	    if (arr == null || arr.length == 0) {
	        throw new IllegalArgumentException("Array must not be null or empty");
	    }
	    int randomIndex = new Random().nextInt(arr.length);
	    return arr[randomIndex];
	}
	
	/**
     * Generates an array of random Person objects.
     *
     * @param size The size of the array.
     * @return Array of randomly generated Person objects.
     */
    public static Person[] randomNumPeople(int size) {
        Person[] people = new Person[size];
        return generateRandomPeople(people, 0);
    }
    
    /**
     * Recursively generates random Person objects and populates the array.
     *
     * @param people The array to store the generated Person objects.
     * @param index  The index to place the current Person object in the array.
     * @return Array of randomly generated Person objects.
     */
    private static Person[] generateRandomPeople(Person[] people, int index) {
        if (index < people.length) {
            people[index] = new Person(
                    randomID(), randomFname(), randomLname(), random(10L, 1500L) + " " + randomStreet(),
                    randomCity(), randomState(), randomZip(), randomPhone()
            );
            generateRandomPeople(people, index + 1); // Recursively generate the next Person object
        }
        return people;
    }
	
    /**
     * Generates a random ZIP code within a specified range.
     * 
     * @return An Integer representing a random ZIP code.
     */
    private static Integer randomZip() {
        // Generate a random ZIP code between 17011 and 99900
        return  (int)random(17011, 99900);
    }

    /**
     * Generates a random phone number within a specified range.
     * 
     * @return A Long representing a random phone number.
     */
    private static Long randomPhone() {
        // Generate a random phone number between 213_222_0000 and 993_222_0000
        return random(213_222_0000L, 993_222_0000L);
    }

    /**
     * Generates a random ID within a specified range.
     * 
     * @return A Long representing a random ID.
     */
    private static Long randomID() {
        // Generate a random ID between 8015500 and 8915500
        return random(8015500L, 8915500L);
    }

}