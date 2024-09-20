package chapter12.exceptions.person;

/**
 * Custom exception class for handling person validation errors.
 */
 //12.9 Defining Custom Exception Classes.
public class PersonValidationException extends RuntimeException {
	
	
	/**
	 * A unique serial version UID for serialization and deserialization.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructs a new PersonValidationException with the specified error message.
	 *
	 * @param message The error message associated with the exception.
	 */
	
	public PersonValidationException(String message) {
		super(message);
	}
}