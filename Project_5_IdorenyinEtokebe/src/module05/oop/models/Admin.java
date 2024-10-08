package module05.oop.models;

import module05.oop.randompms.MyRandomAdminData;

/**
 * The `Admin` class represents an administrative user with an ID, username, and password.
 */
public class Admin {
    private Long id;
    private String user;
    private String pass;

    /**
     * Constructs an `Admin` object with the given ID, username, and password.
     *
     * @param id   The ID of the admin.
     * @param user The username of the admin.
     * @param pass The password of the admin.
     */
    public Admin(Long id, String user, String pass) {
        this.id = id;
        this.user = user;
        this.pass = pass;
    }

    /**
     * Constructs an `Admin` object as a copy of another `Admin` object.
     *
     * @param admin The `Admin` object to copy.
     */
    public Admin(Admin admin) {
        this.id = admin.getId();
        this.user = admin.getUser();
        this.pass = admin.getPass();
    }

    /**
     * Constructs an `Admin` object with random data generated by `MyRandomAdminData`.
     */
    public Admin() {
        Admin generatedAdmin = MyRandomAdminData.generateRandomAdmin();
        this.id = generatedAdmin.getId();
        this.user = generatedAdmin.getUser();
        this.pass = generatedAdmin.getPass();
    }

    /**
     * Gets the ID of the admin.
     *
     * @return The admin's ID.
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the ID of the admin.
     *
     * @param id The admin's ID to set.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the username of the admin.
     *
     * @return The admin's username.
     */
    public String getUser() {
        return user;
    }

    /**
     * Sets the username of the admin.
     *
     * @param user The admin's username to set.
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * Gets the password of the admin.
     *
     * @return The admin's password.
     */
    public String getPass() {
        return pass;
    }

    /**
     * Sets the password of the admin.
     *
     * @param pass The admin's password to set.
     */
    public void setPass(String pass) {
        this.pass = pass;
    }

    /**
     * Returns a string representation of the `Admin` object.
     *
     * @return A string containing the admin's ID, username, and password.
     */
    @Override
    public String toString() {
        return "Admin [id=" + id + ", user=" + user + ", pass=" + pass + "]";
    }
}
