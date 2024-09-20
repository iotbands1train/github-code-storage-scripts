package module05.oop.randompms;

import module05.oop.models.Admin;
/**
 * This class provides utility methods to generate random admin data.
 */
public class MyRandomAdminData {
	/**
     * Generates a random Admin with a random ID, username, and password.
     *
     * @return Randomly generated Admin object.
     */
    public static Admin generateRandomAdmin() { 
        return new Admin(generateRandomId(), generateRandomUsername(), generateRandomPassword());
    }

    /**
     * Generates a random ID for an Admin.
     *
     * @return Randomly generated ID.
     */
    private static Long generateRandomId() {
        return Math.abs( MyRandomPersonData.random(5_111L, 5_999L));
    } 
    /**
     * Generates a random username from a predefined array.
     *
     * @return Random username.
     */
    private static String generateRandomUsername() {
        String[] users = {  "admin1", "admin2", "admin3", "admin4", "admin5" }; 
        return users[new java.util.Random().nextInt(users.length)];
    } 
    /**
     * Generates a random password composed of alphanumeric characters.
     *
     * @return Random password.
     */
    private static String generateRandomPassword() {
        String PASSWORD_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder password = new StringBuilder();
        int length = 8; // Password length 
        for (int i = 0; i < length; i++) { 
            int randomIndex = (int) Math.abs( MyRandomPersonData.random(0, PASSWORD_CHARS.length()));
            char randomChar = PASSWORD_CHARS.charAt(randomIndex);
            password.append(randomChar);
        } 
        return password.toString();
    }
}
