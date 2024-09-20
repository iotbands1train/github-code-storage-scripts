package chapter12.exceptions.person.field;
//Import necessary packages
import chapter12.exceptions.person.PersonValidationException;

/**
* This class represents a custom exception for phone number format errors.
* It extends the PersonValidationException class.
*/
public class PhoneNumberFormatException extends PersonValidationException {
	
	// 12.9 Defining Custom Exception Classes.
	
	// Serial version UID for serialization purposes
	private static final long serialVersionUID = 1L;
	
	/**
	 * Constructor to create a PhoneNumberFormatException with a custom error message.
	 * @param message The error message for the exception.
	 */
	
	public PhoneNumberFormatException(String message) {
		// Call the constructor of the superclass
		//(PersonValidationException) with the provided message
		super(message);
	}
}