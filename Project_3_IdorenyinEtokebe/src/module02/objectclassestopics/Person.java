package module02.objectclassestopics;

import java.util.Date;

/**
 * The Person class represents an individual with various attributes such as
 * ID, first name, last name, address details, contact information, salary, and more.
 * It provides constructors, getter and setter methods, and a string representation
 * of a person's information.
 */
public class Person {
    private int id;
    private String fname;
    private String lname;
    private int streetNo;
    private String streetName;
    private String city;
    private String state;
    private int zip;
    private int phone;
    private float salary;
    private Date creationDate;
    private boolean isMember;
    private String defaultPassword;

    // Constructors
    public Person(int id, String fname, String lname, int streetNo, String streetName, String city, String state, int zip,
                  int phone, float salary, Date creationDate, boolean isMember, String defaultPassword) {
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
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the fname
	 */
	public String getFname() {
		return fname;
	}

	/**
	 * @param fname the fname to set
	 */
	public void setFname(String fname) {
		this.fname = fname;
	}


	/**
	 * @return the lname
	 */
	public String getLname() {
		return lname;
	}

	/**
	 * @param lname the lname to set
	 */
	public void setLname(String lname) {
		this.lname = lname;
	}


	/**
	 * @return the streetNo
	 */
	public int getStreetNo() {
		return streetNo;
	}

	/**
	 * @param streetNo the streetNo to set
	 */
	public void setStreetNo(int streetNo) {
		this.streetNo = streetNo;
	}

	/**
	 * @return the streetName
	 */
	public String getStreetName() {
		return streetName;
	}

	/**
	 * @param streetName the streetName to set
	 */
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return the zip
	 */
	public int getZip() {
		return zip;
	}

	/**
	 * @param zip the zip to set
	 */
	public void setZip(int zip) {
		this.zip = zip;
	}

	/**
	 * @return the phone
	 */
	public int getPhone() {
		return phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(int phone) {
		this.phone = phone;
	}

	/**
	 * @return the salary
	 */
	public float getSalary() {
		return salary;
	}

	/**
	 * @param salary the salary to set
	 */
	public void setSalary(float salary) {
		this.salary = salary;
	}

	/**
	 * @return the creationDate
	 */
	public Date getCreationDate() {
		return creationDate;
	}

	/**
	 * @param creationDate the creationDate to set
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	/**
	 * @return the isMember
	 */
	public boolean isMember() {
		return isMember;
	}

	/**
	 * @param isMember the isMember to set
	 */
	public void setMember(boolean isMember) {
		this.isMember = isMember;
	}

	/**
	 * @return the defaultPassword
	 */
	public String getDefaultPassword() {
		return defaultPassword;
	}

	/**
	 * @param defaultPassword the defaultPassword to set
	 */
	public void setDefaultPassword(String defaultPassword) {
		this.defaultPassword = defaultPassword;
	}

	@Override
    public String toString() {
        // Implement the toString method to provide a string representation of a Person object
        return id + " " + fname + " " + lname + " " + streetNo + " " + streetName + " " + city + " " + state + " " + 
        	zip + " " + phone + " " + salary + " " + creationDate + " " + isMember + " " + defaultPassword; 
	}
}