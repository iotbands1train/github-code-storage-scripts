// Import necessary packages
package chapter12.formuserinput;

import java.util.Scanner;

import chapter12.exceptions.person.field.CityValidationException;
import chapter12.exceptions.person.field.FirstNameValidationException;
import chapter12.exceptions.person.field.LastNameValidationException;
import chapter12.exceptions.person.field.PhoneNumberFormatException;
import chapter12.exceptions.person.field.StateAbbreviationFormatException;
import chapter12.exceptions.person.field.StreetValidationException;
import chapter12.exceptions.person.field.ZipCodeFormatException;
import chapter12.validator.PersonValidator;
import chapter12.verification.PersonVerification;

/**
 * This class handles user input validation and verification for various form fields.
 */
public class FormBox {
	// 12.11.3: Reading Data using Scanner.
	// 12.4: Declaring, Throwing, and Catching Exceptions.

    /**
     * Validates and verifies the first name field.
     */
    public static String fnameFieldBox(String fname, Scanner in) {
        boolean good = false;
        do {
            try {
                // Validate the first name using PersonValidator
                PersonValidator.validateFname(fname);
                // Verify the first name using PersonVerification
                good = PersonVerification.verifyFname(fname);
            } catch (FirstNameValidationException e) {
                // Print stack trace to indicate the error details
                e.printStackTrace();
            }
            if (!good) {
                // Prompt user to re-enter first name if validation or verification fails
                System.out.println("[Reverify]Enter your FNAME : ");
                fname = in.nextLine();
            }
        } while (!good);
        return fname;
    }

    /**
     * Validates and verifies the last name field.
     */
    public static String lnameFieldBox(String lname, Scanner in) {
        boolean good = false;
        do {
            try {
                // Validate the last name using PersonValidator
                PersonValidator.validateLname(lname);
                // Verify the last name using PersonVerification
                good = PersonVerification.verifyLname(lname);
            } catch (LastNameValidationException e) {
                // Print stack trace to indicate the error details
                e.printStackTrace();
            }
            if (!good) {
                // Prompt user to re-enter last name if validation or verification fails
                System.out.println("[Reverify]Enter your LNAME : ");
                lname = in.nextLine();
            }
        } while (!good);
        return lname;
    }

    /**
     * Validates and verifies the street field.
     */
    public static String streetFieldBox(String street, Scanner in) {
        boolean good = false;
        do {
            try {
                // Validate the street using PersonValidator
                PersonValidator.validateStreet(street);
                // Verify the street using PersonVerification
                good = PersonVerification.verifyStreet(street);
            } catch (StreetValidationException e) {
                // Print stack trace to indicate the error details
                e.printStackTrace();
            }
            if (!good) {
                // Prompt user to re-enter street if validation or verification fails
                System.out.println("[Reverify]Enter your STREET : ");
                street = in.nextLine();
            }
        } while (!good);
        return street;
    }

    /**
     * Validates and verifies the city field.
     */
    public static String cityFieldBox(String city, Scanner in) {
        boolean good = false;
        do {
            try {
                // Validate the city using PersonValidator
                PersonValidator.validateCity(city);
                // Verify the city using PersonVerification
                good = PersonVerification.verifyCity(city);
            } catch (CityValidationException e) {
                // Print stack trace to indicate the error details
                e.printStackTrace();
            }
            if (!good) {
                // Prompt user to re-enter city if validation or verification fails
                System.out.println("[Reverify]Enter your CITY : ");
                city = in.nextLine();
            }
        } while (!good);
        return city;
    }

    /**
     * Validates and verifies the state field.
     */
    public static String stateFieldBox(String state, Scanner in) {
        boolean good = false;
        do {
            try {
                // Validate the state using PersonValidator
                PersonValidator.validateState(state);
                // Verify the state using PersonVerification
                good = PersonVerification.verifyState(state);
            } catch (StateAbbreviationFormatException e) {
                // Print stack trace to indicate the error details
                e.printStackTrace();
            }
            if (!good) {
                // Prompt user to re-enter state if validation or verification fails
                System.out.println("[Reverify]Enter your STATE : ");
                state = in.nextLine();
            }
        } while (!good);
        return state;
    }

    /**
     * Validates and verifies the zip code field.
     */
    public static String zipFieldBox(String zip, Scanner in) {
        boolean good = false;
        do {
            try {
                // Validate the zip code using PersonValidator
                PersonValidator.validateZip(zip);
                // Verify the zip code using PersonVerification
                good = PersonVerification.verifyZip(zip);
            } catch (ZipCodeFormatException e) {
                // Print stack trace to indicate the error details
                e.printStackTrace();
            }
            if (!good) {
                // Prompt user to re-enter zip code if validation or verification fails
                System.out.println("[Reverify]Enter your ZIP : ");
                zip = in.nextLine();
            }
        } while (!good);
        return zip;
    }

    /**
     * Validates and verifies the phone field.
     */
    public static String phoneFieldBox(String phone, Scanner in) {
        boolean good = false;
        do {
            try {
                // Validate the phone number using PersonValidator
                PersonValidator.validatePhone(phone);
                // Verify the phone number using PersonVerification
                good = PersonVerification.verifyPhone(phone);
            } catch (PhoneNumberFormatException e) {
                // Print stack trace to indicate the error details
                e.printStackTrace();
            }
            if (!good) {
                // Prompt user to re-enter phone number if validation or verification fails
                System.out.println("[Reverify]Enter your PHONE : ");
                phone = in.nextLine();
            }
        } while (!good);
        return phone;
    }
}