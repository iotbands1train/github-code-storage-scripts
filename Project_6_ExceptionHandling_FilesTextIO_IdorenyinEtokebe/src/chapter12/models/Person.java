package chapter12.models;

/**
 * This class represents a Person entity with various attributes.
 */  
public class Person { 
	private Long id; 
	private String fname; 
	private String lname; 
	private String street; 
	private String city; 
	private String state;  
	private String zip; 
	private String phone;    
    /**
     * Constructor to create a Person object with provided attributes.
     * @param id The unique identifier of the person.
     * @param fname The first name of the person.
     * @param lname The last name of the person.
     * @param street The street address of the person.
     * @param city The city of the person.
     * @param state The state of the person.
     * @param zip The zip code of the person.
     * @param phone The phone number of the person.
     */
	public Person(Long id,String fname, String lname, 
			String street, String city, String state, String zip,String phone) {
		super();
		this.id=id;
		this.fname = fname;
		this.lname = lname;
		this.street = street;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.phone = phone;
	}
    /**
     * Default constructor.
     */
	public Person() {
		// TODO Auto-generated constructor stub
	} 
    /**
     * Copy constructor to create a Person object from another Person object.
     * @param object The source Person object.
     */
	public Person(Person object) {

		this.id=0L;
		this.fname = "n/a";
		this.lname = "n/a";
		this.street = "n/a";
		this.city = "n/a";
		this.state = "n/a";
		this.zip = "n/a";
		this.phone  = "n/a";
	}    
	// Getters and setters for all attributes
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	} 
	/**
	 * to String
	 */
	@Override
	public String toString() {
		return "id=" + id + ", fname=" + fname + ", lname=" + lname + ", street=" + street + ", city=" + city
				+ ", state=" + state + ", zip=" + zip + ", phone=" + phone  ;
	} 
}