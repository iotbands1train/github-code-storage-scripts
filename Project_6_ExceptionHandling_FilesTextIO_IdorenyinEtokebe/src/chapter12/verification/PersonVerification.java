package chapter12.verification;

/**
 * The PersonVerification class provides 
 * methods for verifying various person fields.
 */
public class PersonVerification {
    /**
     * Verifies a first name.
     *
     * @param fname The first name to be verified.
     * @return true if the first name is valid, false otherwise.
     */
    public static boolean verifyFname(String fname) {
        boolean verify=false;
        verify=!fname.isEmpty() && fname.matches("[A-Za-z\\-]+") && fname.length()>1; 
		return verify; 
    }
    /**
     * Verifies a last name.
     *
     * @param lname The last name to be verified.
     * @return true if the last name is valid, false otherwise.
     */
    public static boolean verifyLname(String lname) {
        boolean verify=false;
        verify=!lname.isEmpty() && lname.matches("[A-Za-z\\-]+") && lname.length()>1; 
		return verify;
    }
    /**
     * Verifies a street name.
     *
     * @param street The street name to be verified.
     * @return true if the street name is valid, false otherwise.
     */
    public static boolean verifyStreet(String street) {
        boolean verify=false;
        verify=!street.isEmpty(); 
		return verify; 
    }
    /**
     * Verifies a city name.
     *
     * @param city The city name to be verified.
     * @return true if the city name is valid, false otherwise.
     */
    public static boolean verifyCity(String city) {
        return !(city.isEmpty() && city.length()>1);
    }
    /**
     * Verifies a state abbreviation.
     *
     * @param state The state abbreviation to be verified.
     * @return true if the state abbreviation is valid, false otherwise.
     */
    public static boolean verifyState(String state) {
        return  state.matches("[A-Za-z]{2}")  ;
    }
    /**
     * Verifies a ZIP code.
     *
     * @param zip The ZIP code to be verified.
     * @return true if the ZIP code is valid, false otherwise.
     */
    public static boolean verifyZip(String zip) {
        return zip.matches("\\d{5}");
    }
    /**
     * Verifies a phone number.
     *
     * @param phone The phone number to be verified.
     * @return true if the phone number is valid, false otherwise.
     */
    public static boolean verifyPhone(String phone) {
        return  (phone.matches("\\d{10}")||(phone.matches("\\d{3}-\\d{3}-\\d{4}")));
    }
}