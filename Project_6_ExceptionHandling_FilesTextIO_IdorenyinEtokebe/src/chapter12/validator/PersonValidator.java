package chapter12.validator;

import chapter12.exceptions.person.field.CityValidationException;
import chapter12.exceptions.person.field.FirstNameValidationException;
import chapter12.exceptions.person.field.LastNameValidationException;
import chapter12.exceptions.person.field.PhoneNumberFormatException;
import chapter12.exceptions.person.field.StateAbbreviationFormatException;
import chapter12.exceptions.person.field.StreetValidationException;
import chapter12.exceptions.person.field.ZipCodeFormatException;
/**
 * This class contains methods to validate various attributes of a person.
 */
public class PersonValidator {
	// 12.4.2: Throwing Exceptions.
	/**
	 * Validates a first name.
	 *
	 * @param fname The first name to be validated.
	 * @return The validated first name.
	 * @throws FirstNameValidationException If the first name format is invalid.
	 */
	public static String validateFname(String fname) {
		// Check if the first name is not empty and matches the expected format (letters
		// and hyphens)
		if (!fname.isEmpty() && fname.matches("[A-Za-z\\-]+")) {
			return fname; // Return the validated first name
		} else {
			// Throw an exception with an error message
			throw new FirstNameValidationException(
					"Invalid first name format. " + "First name should only contain letters and hyphens.");
		}
	}

	/**
	 * Validates a last name.
	 *
	 * @param lname The last name to be validated.
	 * @return The validated last name.
	 * @throws LastNameValidationException If the last name format is invalid.
	 */
	public static String validateLname(String lname) {
		// Check if the last name is not empty and matches the expected format (letters
		// and hyphens)
		if (!lname.isEmpty() && lname.matches("[A-Za-z\\-]+")) {
			return lname; // Return the validated last name
		} else {
			// Throw an exception with an error message
			throw new LastNameValidationException(
					"Invalid last name format. " + "Last name should only contain letters and hyphens.");
		}
	}

	/**
	 * Validates a street name.
	 *
	 * @param street The street name to be validated.
	 * @return The validated street name.
	 * @throws StreetValidationException If the street name is empty.
	 */
	public static String validateStreet(String street) {
		// Check if the street name is not empty
		if (!street.isEmpty()) {
			return street; // Return the validated street name
		} else {
			// Throw an exception with an error message
			throw new StreetValidationException("Street name cannot be empty.");
		}
	}

	/**
	 * Validates a city name.
	 *
	 * @param city The city name to be validated.
	 * @return The validated city name.
	 * @throws CityValidationException If the city name is empty.
	 */
	public static String validateCity(String city) {
		// Check if the city name is not empty
		if (!city.isEmpty()) {
			return city; // Return the validated city name
		} else {
			// Throw an exception with an error message
			throw new CityValidationException("City name cannot be empty.");
		}
	}

	/**
	 * Validates a state abbreviation.
	 *
	 * @param state The state abbreviation to be validated.
	 * @return The validated state abbreviation.
	 * @throws StateAbbreviationFormatException If the state abbreviation format is
	 *                                          invalid.
	 */
	public static String validateState(String state) {
		// Check if the state abbreviation matches the expected format (2 letters)
		if (state.matches("[A-Za-z]{2}")) {
			return state; // Return the validated state abbreviation
		} else {
			// Throw an exception with an error message
			throw new StateAbbreviationFormatException(
					"Invalid state " + "abbreviation format. Please enter a 2-letter abbreviation.");
		}
	}

	/**
	 * Validates a ZIP code.
	 *
	 * @param zip The ZIP code to be validated.
	 * @return The validated ZIP code.
	 * @throws ZipCodeFormatException If the ZIP code format is invalid.
	 */
	public static String validateZip(String zip) {
		// Check if the ZIP code matches the expected format (5 digits)
		if (zip.matches("\\d{5}")) {
			return zip; // Return the validated ZIP code
		} else {
			// Throw an exception with an error message
			throw new ZipCodeFormatException("Invalid ZIP code format." + " Please enter a 5-digit number.");
		}
	}

	/**
	 * Validates a phone number.
	 *
	 * @param phone The phone number to be validated.
	 * @return The validated phone number.
	 * @throws PhoneNumberFormatException If the phone number format is invalid.
	 */
	public static String validatePhone(String phone) {
		// Check if the phone number matches the expected format (10 digits)
		if (phone.matches("\\d{10}")||(phone.matches("\\d{3}-\\d{3}-\\d{4}"))) {
			return phone; // Return the validated phone number
		} else {
			// Throw an exception with an error message
			throw new PhoneNumberFormatException("Invalid phone number format." + " Please enter a 10-digit number.");
		}
	}

}