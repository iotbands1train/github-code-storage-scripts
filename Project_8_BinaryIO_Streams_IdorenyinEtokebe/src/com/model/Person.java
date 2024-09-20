package com.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Represents a person with various personal and contact information.
 * This class is designed to store and manage data such as name, address,
 * phone number, and salary. It also includes a unique ID for each person,
 * a flag for membership status, and a default password. The class is
 * serializable to allow for easy storage and retrieval of person data.
 * 
 * Attributes:
 * - id (Long): Unique identifier for the person.
 * - fname (String): First name of the person.
 * - lname (String): Last name of the person.
 * - streetNo (Short): Street number of the person's address.
 * - streetName (String): Street name of the person's address.
 * - city (String): City of the person's address.
 * - state (String): State of the person's address.
 * - zip (Integer): ZIP code of the person's address.
 * - phone (Long): Phone number of the person.
 * - salary (Float): Salary of the person.
 * - count (int): Static counter for the number of Person instances.
 * - creationDate (Date): Creation date of the person's record.
 * - isMember (Boolean): Membership status of the person.
 * - defaultPassword (String): Default password for the person.
 */
public class Person implements Serializable{
    // Unique identification for the person. Used as a primary key.
    private Long id;

    // First name of the person.
    private String fname;

    // Last name of the person.
    private String lname;

    // Street number of the person's address.
    private Short streetNo;

    // Street name of the person's address.
    private String streetName;

    // City of the person's address.
    private String city;

    // State of the person's address.
    private String state;

    // ZIP code of the person's address.
    private Integer zip;

    // Phone number of the person.
    private Long phone;

    // Salary of the person.
    private Float salary;

    // Static counter to keep track of the number of Person instances.
    public transient static int count;

    // Creation date of the person's record.
    java.util.Date creationDate;

    // Boolean flag to indicate membership status.
    public Boolean isMember;

    // Default password for the person, for demonstration or initial setup.
    private String defaultPassword;

    /**
     * Copy constructor for the Person class. 
     * Creates a new Person object by copying the attributes of another Person object.
     * 
     * @param p The Person object to copy.
     */
    public Person(Person p) {
        id = p.getId();
        fname = p.getFname();
        lname = p.getLname();
        streetNo = p.getStreetNo();
        streetName = p.getStreetName();
        city = p.getCity();
        state = p.getState();
        zip = p.getZip();
        phone = p.getPhone();
        salary = p.getSalary();
        creationDate = p.getCreationDate();
    }

    /**
     * Constructor for the Person class with detailed parameters.
     * 
     * @param id The unique ID of the person.
     * @param fname The first name of the person.
     * @param lname The last name of the person.
     * @param streetNo The street number of the person's address.
     * @param streetName The street name of the person's address.
     * @param city The city of the person's address.
     * @param state The state of the person's address.
     * @param zip The ZIP code of the person's address.
     * @param phone The phone number of the person.
     * @param salary The salary of the person.
     * @param creationDate The creation date of the person's record.
     * @param isMember The membership status of the person.
     * @param defaultPassword The default password for the person.
     */
    public Person(Long id, String fname, String lname, Short streetNo, String streetName, String city, String state,
                  Integer zip, Long phone, Float salary, Date creationDate, Boolean isMember, String defaultPassword) {
        super();
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.streetNo = streetNo;
        this.streetName = streetName;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phone = phone;
        this.salary = salary;
        this.creationDate = creationDate;
        this.isMember = isMember;
        this.defaultPassword = defaultPassword;
    }

    /**
     * Constructor for the Person class with partial parameters.
     * Automatically parses the street number and name from a single string.
     * 
     * @param id The unique ID of the person.
     * @param fname The first name of the person.
     * @param lname The last name of the person.
     * @param street The combined street number and name.
     * @param city The city of the person's address.
     * @param state The state of the person's address.
     * @param zip The ZIP code of the person's address.
     * @param phone The phone number of the person.
     */
    public Person(Long id, String fname, String lname, String street, String city, String state,
                  Integer zip, Long phone) {
        super();
        this.id = id;
        this.fname = fname;
        this.lname = lname; 
        this.streetNo = Short.parseShort(street.replaceAll("[^0-9]", ""));
        this.streetName  = street.replaceAll("[0-9]", ""); 
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phone = phone; 
    } 

    /**
     * Alternative constructor for the Person class.
     * 
     * @param id The unique ID of the person.
     * @param fname The first name of the person.
     * @param lname The last name of the person.
     * @param streetNo The street number of the person's address.
     * @param streetName The street name of the person's address.
     * @param city The city of the person's address.
     * @param state The state of the person's address.
     * @param zip The ZIP code of the person's address.
     * @param phone The phone number of the person.
     */
    public Person(Long id, String fname, String lname, Short streetNo, String streetName, String city, String state,
                  Integer zip, Long phone) {
        super();
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.streetNo = streetNo;
        this.streetName = streetName;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phone = phone; 
    }

    /**
     * Generates a password based on a combination of the person's attributes.
     * 
     * @return A generated password string.
     */ 
	private String password() {
		String x = ("" + id).substring(1, 3) + "";
		x += ("" + fname).substring(1, 3) + "";
		x += ("" + phone).substring(1, 3) + "";
		x += ("" + creationDate).substring(1, 3) + "";
		x += ("" + streetName).substring(1, 3) + "";
		return x.trim().toLowerCase();
	}
    /**
     * Retrieves the unique ID of the person.
     * 
     * @return The unique ID.
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the unique ID for the person.
     * 
     * @param id The unique ID to be set.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Retrieves the first name of the person.
     * 
     * @return The first name.
     */
    public String getFname() {
        return fname;
    }

    /**
     * Sets the first name of the person.
     * 
     * @param fname The first name to be set.
     */
    public void setFname(String fname) {
        this.fname = fname;
    }

    /**
     * Retrieves the last name of the person.
     * 
     * @return The last name.
     */
    public String getLname() {
        return lname;
    }

    /**
     * Sets the last name of the person.
     * 
     * @param lname The last name to be set.
     */
    public void setLname(String lname) {
        this.lname = lname;
    }

    /**
     * Retrieves the street number of the person's address.
     * 
     * @return The street number.
     */
    public Short getStreetNo() {
        return streetNo;
    }

    /**
     * Sets the street number for the person's address.
     * 
     * @param streetNo The street number to be set.
     */
    public void setStreetNo(Short streetNo) {
        this.streetNo = streetNo;
    }

    /**
     * Retrieves the street name of the person's address.
     * 
     * @return The street name.
     */
    public String getStreetName() {
        return streetName;
    }

    /**
     * Sets the street name for the person's address.
     * 
     * @param streetName The street name to be set.
     */
    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    /**
     * Retrieves the city of the person's address.
     * 
     * @return The city.
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets the city for the person's address.
     * 
     * @param city The city to be set.
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Retrieves the state of the person's address.
     * 
     * @return The state.
     */
    public String getState() {
        return state;
    }

    /**
     * Sets the state for the person's address.
     * 
     * @param state The state to be set.
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * Retrieves the ZIP code of the person's address.
     * 
     * @return The ZIP code.
     */
    public Integer getZip() {
        return zip;
    }

    /**
     * Sets the ZIP code for the person's address.
     * 
     * @param zip The ZIP code to be set.
     */
    public void setZip(Integer zip) {
        this.zip = zip;
    }

    /**
     * Retrieves the phone number of the person.
     * 
     * @return The phone number.
     */
    public Long getPhone() {
        return phone;
    }

    /**
     * Sets the phone number for the person.
     * 
     * @param phone The phone number to be set.
     */
    public void setPhone(Long phone) {
        this.phone = phone;
    }

    /**
     * Retrieves the salary of the person.
     * 
     * @return The salary.
     */
    public Float getSalary() {
        return salary;
    }

    /**
     * Sets the salary for the person.
     * 
     * @param salary The salary to be set.
     */
    public void setSalary(Float salary) {
        this.salary = salary;
    }

    /**
     * Retrieves the current count of Person instances.
     * 
     * @return The count of Person instances.
     */
    public static int getCount() {
        return count;
    }

    /**
     * Retrieves the creation date of the person's record.
     * 
     * @return The creation date.
     */
    public java.util.Date getCreationDate() {
        return creationDate;
    }

    /**
     * Sets the creation date for the person's record.
     * 
     * @param creationDate The creation date to be set.
     */
    public void setCreationDate(java.util.Date creationDate) {
        this.creationDate = creationDate;
    }

    /**
     * Retrieves the membership status of the person.
     * 
     * @return The membership status.
     */
    public Boolean getIsMember() {
        return isMember;
    }

    /**
     * Sets the membership status for the person.
     * 
     * @param isMember The membership status to be set.
     */
    public void setIsMember(Boolean isMember) {
        this.isMember = isMember;
    }

    /**
     * Retrieves the default password for the person.
     * 
     * @return The default password.
     */
    public String getDefaultPassword() {
        return defaultPassword;
    }
    /**
     * Displays the person's information in a formatted manner to the console.
     */
    public void display() {
        // Print each attribute of the person in a readable format
        System.out.println("row: [" + count + "]");
        System.out.println("id = [" + id + "]");
        System.out.println("fname = [" + fname + "]");
        System.out.println("lname = [" + lname + "]");
        System.out.println("address = [" + streetNo + " " + streetName + "]");
        System.out.println("city = [" + city + "]");
        System.out.println("state = [" + state + "]");
        System.out.println("zip = [" + zip + "]");
        System.out.printf("phone = [%s]\n", (phone + "").replaceFirst("(\\d{3})(\\d{3})(\\d{4})", "$1-$2-$3"));
    }

    /**
     * Gets the current password of the person.
     * 
     * @return The current password.
     */
    public String getCurrentPassword() {
        return defaultPassword;
    }

    /**
     * Sets a new password for the person.
     * 
     * @param password The new password to be set.
     */
    public void setDefaultPassword(String password) {
        this.defaultPassword = password;
    }

    /**
     * Formats and returns the person's information as a string.
     * 
     * @return A string representation of the person's information.
     */
    public String printPerson() {
        return "Person [id=" + id + ", fname=" + fname + ", lname=" + lname + ", streetNo=" + streetNo + ", streetName="
                + streetName + ", city=" + city + ", state=" + state + ", zip=" + zip + ", phone=" + phone + ", salary="
                + salary + ", creationDate=" + creationDate + ", isMember=" + isMember + ", defaultPassword="
                + defaultPassword + "]";
    }

    /**
     * Overrides the toString method to provide a detailed representation of the person's information.
     * 
     * @return A string representation of the person.
     */
    @Override
    public String toString() {
        String string = "";
        string += ("row: [" + count++ + "] | ");
        string += ("id = [" + id + "] | ");
        string += ("fname = [" + fname + "] | ");
        string += ("lname = [" + lname + "] | ");
        string += ("address = [" + streetNo + " " + streetName + "] | ");
        string += ("city = [" + city + "] | ");
        string += ("state = [" + state + "] | ");
        string += ("zip = [" + zip + "] | ");
        string += String.format("phone = [%s]", (phone + "").replaceFirst("(\\d{3})(\\d{3})(\\d{4})", "$1-$2-$3"));
        return string;
    }


}