package module05.oop.models;

import module05.oop.randompms.MyRandomPersonData;

/**
 * The `Name` class represents a person's name, including title, first name, middle initial, and last name.
 */
public class Name {
    private String title;
    private String fname;
    private String mi;
    private String lname;

    /**
     * Constructs a `Name` object with randomly generated name components.
     */
    public Name() {
        super();
        this.title = MyRandomPersonData.randomTitle();
        this.fname = MyRandomPersonData.randomFname();
        this.mi = MyRandomPersonData.randomFname();
        this.lname = MyRandomPersonData.randomLname();
    }

    /**
     * Constructs a `Name` object with the given name components.
     *
     * @param title The title (e.g., Mr., Mrs.).
     * @param fname The first name.
     * @param mi    The middle initial.
     * @param lname The last name.
     * @param other An unused parameter.
     */
    public Name(String title, String fname, String mi, String lname, String other) {
        super();
        this.title = title;
        this.fname = fname;
        this.mi = mi;
        this.lname = lname;
    }

    /**
     * Gets the title of the name.
     *
     * @return The title.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title of the name.
     *
     * @param title The title to set.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets the first name.
     *
     * @return The first name.
     */
    public String getFname() {
        return fname;
    }

    /**
     * Sets the first name.
     *
     * @param fname The first name to set.
     */
    public void setFname(String fname) {
        this.fname = fname;
    }

    /**
     * Gets the middle initial.
     *
     * @return The middle initial.
     */
    public String getMi() {
        return mi;
    }

    /**
     * Sets the middle initial.
     *
     * @param mi The middle initial to set.
     */
    public void setMi(String mi) {
        this.mi = mi;
    }

    /**
     * Gets the last name.
     *
     * @return The last name.
     */
    public String getLname() {
        return lname;
    }

    /**
     * Sets the last name.
     *
     * @param lname The last name to set.
     */
    public void setLname(String lname) {
        this.lname = lname;
    }

    /**
     * Returns a string representation of the `Name` object.
     *
     * @return A string containing title, first name, middle initial, and last name.
     */
    @Override
    public String toString() {
        return " Name [title=" + title + ", fname=" + fname + ", mi=" + mi + ", lname=" + lname + "]";
    }
}
