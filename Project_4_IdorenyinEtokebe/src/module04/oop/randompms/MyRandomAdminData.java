package module04.oop.randompms;

import module04.oop.models.Admin;

/**
 * This class provides methods to generate random data for creating Admin objects.
 */
public class MyRandomAdminData {
	 /**
     * Generates a random Admin object with random attributes.
     */
    public static Admin generateRandomAdmin() {
        Long id = generateRandomId();
        String username = generateRandomUsername();
        String password = generateRandomPassword();

        return new Admin(id, username, password);
    }
    /**
     * Generates a random positive Long ID.
     */
    private static Long generateRandomId() {
        return Math.abs(new java.util.Random().nextLong());
    }
    /**
     * Generates a random positive Long ID.
     */
    private static String generateRandomUsername() {
        String[] USERNAMES = {
            "admin1", "admin2", "admin3", "admin4", "admin5"
            // ... Add more usernames as needed
        };
        int randomIndex = new java.util.Random().nextInt(USERNAMES.length);
        return USERNAMES[randomIndex];
    }

    /**
     * Generates a random password with a specified length and characters.
     */
    private static String generateRandomPassword() {
        String PASSWORD_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder password = new StringBuilder();
        int length = 8; // Password length

        for (int i = 0; i < length; i++) {
            int randomIndex = new java.util.Random().nextInt(PASSWORD_CHARS.length());
            char randomChar = PASSWORD_CHARS.charAt(randomIndex);
            password.append(randomChar);
        }

        return password.toString();
    }
}
