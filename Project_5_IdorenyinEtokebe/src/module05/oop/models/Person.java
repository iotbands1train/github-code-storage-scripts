package module05.oop.models;

/* 
 * The Person class represents a person 
 * entity with various attributes.
 */
public class Person {
	// Private attributes for storing person details. 
	// The unique identifier for the person.
	private Long id;
	// The name of the person, including title, first name, middle initial, and last
	// name.
	private Name name;
	// The physical location or address of the person.
	private Location location;
	// The contact information of the person, including a phone number. 
	private Contact contact; 
	// The financial information of the person, including bank ID, salary, and current balance. 
	private Funds funds;
	/*
	 * Default constructor that initializes the Person with default values. It also
	 * generates an ID based on the hash code of concatenated object attributes.
	 */
	public Person() {
		super();
		this.name = new Name();
		this.location = new Location();
		this.contact = new Contact();
		this.funds = new Funds();
		this.id = (long) Math.abs((name + "" + location + "" + contact + "" + funds + "").hashCode());
	}

	/*
	 * Constructor that initializes the Person with specified values.
	 */
	public Person(Long id, Name name, Location location, Contact contact, Funds funds) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		this.contact = contact;
		this.funds = funds;
	}

	/*
	 * Copy constructor that creates a new Person instance from an existing one.
	 * 
	 */
	public Person(Person p) {
		super();
		this.id = p.getId();
		this.name = p.getName();
		this.location = p.getLocation();
		this.contact = p.getContact();
		this.funds = p.getFunds();
	}
	/*
	 * Getter method for retrieving the ID of the person.
	 */
	public Long getId() {
		return id;
	}
	/*
	 * Setter method for setting the ID of the person.
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/*
	 * Getter method for retrieving the Name of the person.
	 */
	public Name getName() {
		return name;
	}
	/*
	 * Setter method for setting the Name of the person.
	 */
	public void setName(Name name) {
		this.name = name;
	}
	/*
	 * Getter method for retrieving the Location of the person.
	 */
	public Location getLocation() {
		return location;
	}
	/*
	 * Setter method for setting the Location of the person.
	 */
	public void setLocation(Location location) {
		this.location = location;
	}
	/*
	 * Getter method for retrieving the Contact information of the person.
	 */
	public Contact getContact() {
		return contact;
	}
	/*
	 * Setter method for setting the Contact information of the person.
	 * 
	 */
	public void setContact(Contact contact) {
		this.contact = contact;
	}
	/*
	 * Getter method for retrieving the Funds information of the person. 
	 */
	public Funds getFunds() {
		return funds;
	}
	/*
	 * Setter method for setting the Funds information of the person. 
	 */
	public void setFunds(Funds funds) {
		this.funds = funds;
	}
	/*
	 * Displays the details of the person. 
	 */
	public void display() {
		String print = "Person [id=" + id + ", \n" + name + ", \n" + location + ", \n" + contact + ",\n" + funds + "]";
		System.out.println(print);
	}

	/*
	 * Overrides the toString method to provide a custom string representation of
	 * the person.
	 * 
	 */
	@Override
	public String toString() {
		return "[ID=" + id + ", Name=" + name.getFname() + ", Phone=" + contact.getPhone() + ", CurrentBalance="
				+ funds.getCurrentBalance() + "]";
	}
}
